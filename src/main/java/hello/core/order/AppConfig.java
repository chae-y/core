package hello.core.order;

import hello.core.discount.FIxDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FIxDiscountPolicy());
    }
}
