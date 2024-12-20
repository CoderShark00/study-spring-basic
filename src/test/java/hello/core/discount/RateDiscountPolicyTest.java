package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_0(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.Vip);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertEquals(discount,1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(1L,"memberBASIC", Grade.Basic);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertEquals(discount,0);
    }

}