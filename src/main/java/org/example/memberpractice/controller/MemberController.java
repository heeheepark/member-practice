package org.example.memberpractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.memberpractice.dto.*;
import org.example.memberpractice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/member")
    public ResponseEntity<List<MemberGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getAll());
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<MemberGetResponse> getOne(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getOne(memberId));
    }

    @PutMapping("/member/{memberId}")
    public ResponseEntity<MemberUpdateResponse> update(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.update(memberId, request));
    }

}
