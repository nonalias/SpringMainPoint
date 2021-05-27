package com.hello.order;

import com.hello.discount.DiscountPolicy;
import com.hello.discount.FixDiscountPolicy;
import com.hello.discount.RateDiscountPolicy;
import com.hello.member.Member;
import com.hello.member.MemberRepository;
import com.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
