package org.example.memberpractice.service;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.dto.MemberCreateRequest;
import org.example.memberpractice.dto.MemberCreateResponse;
import org.example.memberpractice.entity.Member;
import org.example.memberpractice.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getName(), request.getEmail());
        Member save = memberRepository.save(member);

        return new MemberCreateResponse(save.getId(), save.getName(), save.getEmail());
    }
}
