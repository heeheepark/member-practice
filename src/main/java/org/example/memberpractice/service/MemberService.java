package org.example.memberpractice.service;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    
}
