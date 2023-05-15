package com.board.qnaboard.member.service;

//import com.board.qnaboard.helper.event.MemberRegistrationApplicationEvent;
import com.board.qnaboard.member.entity.Member;
import com.board.qnaboard.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());
        Member savedMember = memberRepository.save(member);

//        publisher.publishEvent(new MemberRegistrationApplicationEvent(this, savedMember));
        return savedMember;
    }

    public Member findMember(String email) {
        findVerifiedMember(email);
        return memberRepository.findMemberByEmail(email);
    }

    @Transactional(readOnly = true)
    public Member findVerifiedMember(String email) {
        Member findMember = memberRepository.findMemberByEmail(email);
        if(findMember == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return findMember;
    }

    private void verifyExistsEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if (findMember.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
    }
}
