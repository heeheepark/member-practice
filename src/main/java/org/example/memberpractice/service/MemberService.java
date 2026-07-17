package org.example.memberpractice.service;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.dto.*;
import org.example.memberpractice.entity.Member;
import org.example.memberpractice.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse create(MemberCreateRequest request) {
        Member member = new Member(request.getName(), request.getEmail(), request.getAddress());
        Member saveMember = memberRepository.save(member);

        return new MemberCreateResponse(saveMember.getId(), saveMember.getName(), saveMember.getEmail(), saveMember.getAddress(), member.getCreatedAt(), member.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<MemberGetResponse> getAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberGetResponse> dtos = new ArrayList<>();

        for (Member member : members) {
            dtos.add(new MemberGetResponse(member.getId(), member.getName(), member.getEmail(), member.getAddress(), member.getCreatedAt(), member.getModifiedAt()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public MemberGetResponse getOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 멤버가 없습니다.")
        );

        return new MemberGetResponse(member.getId(), member.getName(), member.getEmail(), member.getAddress(), member.getCreatedAt(), member.getModifiedAt());
    }

    @Transactional
    public MemberUpdateResponse update(Long memberId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 멤버가 없습니다.")
        );

        String memberEmail = member.getEmail();
        String requestEmail = request.getEmail();

        if (ObjectUtils.nullSafeEquals(memberEmail, requestEmail)) {
            throw new IllegalArgumentException("해당 이메일이 이미 존재합니다.");
        }

        member.updateMember(request.getName(), request.getEmail(), request.getAddress());

        return new MemberUpdateResponse(member.getId(), member.getName(), member.getEmail(), member.getAddress(), member.getCreatedAt(), member.getModifiedAt());
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);

        if (!existence) {
            throw new IllegalArgumentException("해당 멤버가 없습니다.");
        }

        memberRepository.deleteById(memberId);
    }
}
