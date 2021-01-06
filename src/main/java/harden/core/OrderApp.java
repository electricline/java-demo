package harden.core;

import harden.core.member.Grade;
import harden.core.member.Member;
import harden.core.member.MemberService;
import harden.core.member.MemberServiceImpl;
import harden.core.order.Order;
import harden.core.order.OrderService;
import harden.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
