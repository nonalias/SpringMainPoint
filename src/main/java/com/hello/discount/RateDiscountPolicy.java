package com.hello.discount;

import com.hello.member.Grade;
import com.hello.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 20;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price * discountPercent / 100;
        else
            return 0;
    }
}
