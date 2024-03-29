package com.seungh1024.order;

import com.seungh1024.annotation.MainDiscountPolicy;
import com.seungh1024.discount.DiscountPolicy;
import com.seungh1024.discount.FixDiscountPolicy;
import com.seungh1024.discount.RateDiscountPolicy;
import com.seungh1024.member.Member;
import com.seungh1024.member.MemberRepository;
import com.seungh1024.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); // 단일 책임 원칙이 잘 된 것임. 할인 관련된 것을 잘 분리한 것!
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
