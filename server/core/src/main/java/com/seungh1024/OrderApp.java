package com.seungh1024;

import com.seungh1024.member.Grade;
import com.seungh1024.member.Member;
import com.seungh1024.member.MemberService;
import com.seungh1024.member.MemberServiceImpl;
import com.seungh1024.order.Order;
import com.seungh1024.order.OrderService;
import com.seungh1024.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);

        System.out.println("order = " +order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
