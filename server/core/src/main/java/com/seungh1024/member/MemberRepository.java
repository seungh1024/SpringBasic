package com.seungh1024.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
