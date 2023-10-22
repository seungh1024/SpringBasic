package com.seungh1024;

import com.seungh1024.discount.DiscountPolicy;
import com.seungh1024.discount.FixDiscountPolicy;
import com.seungh1024.discount.RateDiscountPolicy;
import com.seungh1024.member.MemberService;
import com.seungh1024.member.MemberServiceImpl;
import com.seungh1024.member.MemoryMemberRepository;
import com.seungh1024.order.OrderService;
import com.seungh1024.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {

        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){

        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
