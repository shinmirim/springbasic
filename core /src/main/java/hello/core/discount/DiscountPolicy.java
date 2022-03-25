package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //return 할인 대상 금액 , 호출하면 결과로 얼마가 할인 되었는지 return
    int discount(Member member, int price);//파라미터로 멤버 넘김
}
