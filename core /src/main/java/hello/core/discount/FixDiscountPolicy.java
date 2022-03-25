package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;//무조건 천원만 할인

    @Override
    public int discount(Member member, int price) {
        //등급이 VIP일때 1000원 할인 아님 0
        if (member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;

        }

    }
}
