package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    //할인 10퍼센터 해주겠다
    private int DiscountPolicy = 10;// 할인과 돈 관련은 테스트를 자주한다.

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade()== Grade.VIP){
            return price * DiscountPolicy/100;
        }else{
            return 0;
        }

    }
}
