package com.seungh1024.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
