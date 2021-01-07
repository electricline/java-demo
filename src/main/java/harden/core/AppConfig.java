package harden.core;

import harden.core.discount.DiscountPolicy;
import harden.core.discount.FixDiscountPolicy;
import harden.core.discount.RateDiscountPolicy;
import harden.core.member.MemberRepository;
import harden.core.member.MemberService;
import harden.core.member.MemberServiceImpl;
import harden.core.member.MemoryMemberRepository;
import harden.core.order.OrderService;
import harden.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
