package org.example.memberpractice.service;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.dto.*;
import org.example.memberpractice.entity.Member;
import org.example.memberpractice.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getName(), request.getEmail());
        Member save = memberRepository.save(member);

        return new MemberCreateResponse(save.getId(), save.getName(), save.getEmail());
    }

    @Transactional(readOnly = true)
    public List<MemberGetResponse> getAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberGetResponse> dtos = new ArrayList<>();

        for (Member member : members) {
            dtos.add(new MemberGetResponse(member.getId(), member.getName(), member.getEmail()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public MemberGetResponse getOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("멤버를 찾을 수 없습니다.")
        );

        return new MemberGetResponse(member.getId(), member.getName(), member.getEmail());
    }

    @Transactional
    public MemberUpdateResponse update(Long memberId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("멤버를 찾을 수 없습니다.")
        );

        member.update(request.getName(), request.getEmail());

        return new MemberUpdateResponse(member.getId(), member.getName(), member.getEmail());
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);
        if (!existence) {
            throw new IllegalArgumentException("존재하지 않는 멤버입니다.");
        }

        memberRepository.deleteById(memberId);
    }
}
