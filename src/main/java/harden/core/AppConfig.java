package harden.core;

import harden.core.discount.DiscountPolicy;
import harden.core.discount.FixDiscountPolicy;
import harden.core.member.MemberRepository;
import harden.core.member.MemberService;
import harden.core.member.MemberServiceImpl;
import harden.core.member.MemoryMemberRepository;
import harden.core.order.OrderService;
import harden.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
