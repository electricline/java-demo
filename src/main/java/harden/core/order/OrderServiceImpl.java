package harden.core.order;

import harden.core.annotation.MainDiscountPolicy;
import harden.core.discount.DiscountPolicy;
import harden.core.member.Member;
import harden.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    
    @MainDiscountPolicy
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존 하도록 설계 변경


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
