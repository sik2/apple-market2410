package com.market.apple.domain.member.service;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join (String username, String password, String nickname, String email) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .build();

        return  this.memberRepository.save(member);
    }

}
