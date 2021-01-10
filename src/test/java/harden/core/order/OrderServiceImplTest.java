package harden.core.order;

import harden.core.discount.FixDiscountPolicy;
import harden.core.member.Grade;
import harden.core.member.Member;
import harden.core.member.MemberRepository;
import harden.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    /*
    생성자 주입이 아닌 수정자 매서드를 통한 DI의 경우 테스트를 돌리기전 까지 문제점 파악 못함 -> 여기선 npe
    만약 생성자 주입이라면 컴파일 오류로 쉽게 발견할 수 있음
     */
//    @Test
//    @DisplayName("생성자 주입이 아닐 때 수정자 매서드를 통한 테스트 문제점")
//    void createOrder() {
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L,"itemA",10000);
//    }

    @Test
    @DisplayName("생성자 주입")
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


}