package com.seungh1024;


import com.seungh1024.member.Grade;
import com.seungh1024.member.Member;
import com.seungh1024.member.MemberService;
import com.seungh1024.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
