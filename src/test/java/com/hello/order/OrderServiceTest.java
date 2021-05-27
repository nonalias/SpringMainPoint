package com.hello.order;

import com.hello.member.Grade;
import com.hello.member.Member;
import com.hello.member.MemberService;
import com.hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Long memberId2 = 2L;
        Member member2 = new Member(memberId2, "memberA", Grade.BASIC);
        memberService.join(member2);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Order order2 = orderService.createOrder(memberId2, "itemB", 100000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);
    }
}
