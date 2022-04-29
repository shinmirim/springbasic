package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")// 테스트 이름을 정할 수 있다. Junit5부터 지원하는다.
    void vip_o(){// vip 는 잘 적용이 된다는 뜻

        //given
        //임의의 멤버를 만들어준다.
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);


        //then
        //검증 할인된 금액은 천원이 나와야한다.
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다.")
    void vip_x(){//vip가 아닌경우

        //given
        //임의의 멤버를 만들어준다.
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);


        //then Assertions.assertThat(discount).isEqualTo(1000);
        //검증 할인된 금액은 천원이 나와야한다.
        assertThat(discount).isEqualTo(0);

    }
}