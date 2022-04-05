package hello.core.order;

import hello.core.annotation.MainDisCountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //인터페이스, 구현체 둘 다 의존하는 것...!! -> 관심사를 분리하자
//    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolity();

    //RequiredArgsConstructor가 private final붙은 변수들로 이걸 만들어 줌
    public OrderServiceImpl(MemberRepository memberRepository, @MainDisCountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //ㅌㅔ스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
