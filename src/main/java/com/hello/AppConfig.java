package com.hello;

import com.hello.discount.FixDiscountPolicy;
import com.hello.discount.RateDiscountPolicy;
import com.hello.member.MemberRepository;
import com.hello.member.MemberService;
import com.hello.member.MemberServiceImpl;
import com.hello.member.MemoryMemberRepository;
import com.hello.order.OrderService;
import com.hello.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
