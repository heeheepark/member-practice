package org.example.memberpractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.dto.MemberCreateRequest;
import org.example.memberpractice.dto.MemberCreateResponse;
import org.example.memberpractice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<MemberCreateResponse> save(
            @RequestBody MemberCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }
}
