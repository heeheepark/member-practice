package org.example.memberpractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
}
