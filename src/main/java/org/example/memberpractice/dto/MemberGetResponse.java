package org.example.memberpractice.dto;

import lombok.Getter;

@Getter
public class MemberGetResponse {
    private final Long id;
    private final String name;
    private final String email;

    public MemberGetResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
