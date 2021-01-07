package harden.core;

import harden.core.discount.FixDiscountPolicy;
import harden.core.member.MemberService;
import harden.core.member.MemberServiceImpl;
import harden.core.member.MemoryMemberRepository;
import harden.core.order.OrderService;
import harden.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
