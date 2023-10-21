package com.seungh1024;

import com.seungh1024.discount.FixDiscountPolicy;
import com.seungh1024.discount.RateDiscountPolicy;
import com.seungh1024.member.MemberService;
import com.seungh1024.member.MemberServiceImpl;
import com.seungh1024.member.MemoryMemberRepository;
import com.seungh1024.order.OrderService;
import com.seungh1024.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
