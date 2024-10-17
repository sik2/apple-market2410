package com.market.apple.domain.member.service;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member join (String username, String password, String nickname, String email) {
        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .email(email)
                .build();

        return  this.memberRepository.save(member);
    }

    @Transactional
    public Member whenSocialLogin(String providerTypeCode, String username, String nickname) throws Exception {
        Member member = findByUsername(username);

        // 소셜 로그인를 통한 가입시 비번은 없다.
        return join(username, "", nickname, ""); // 최초 로그인 시 딱 한번 실행
    }

    public Member findByUsername(String username) throws Exception {
        Optional<Member> optionalMember = this.memberRepository.findByusername(username);

        if (optionalMember.isPresent()) {
            return optionalMember.get();
        } else {
            throw  new RuntimeException("data not found");
        }
    }
}
