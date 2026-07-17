package org.example.memberpractice.dto;

import lombok.Getter;

@Getter
public class MemberCreateRequest {
    private String name;
    private String email;
    private String address;
}
