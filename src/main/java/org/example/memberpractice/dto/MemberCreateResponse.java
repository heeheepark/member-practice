package org.example.memberpractice.dto;

import lombok.Getter;

@Getter
public class MemberCreateResponse {
    private final Long id;
    private final String name;
    private final String email;

    public MemberCreateResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
