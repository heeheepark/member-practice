package org.example.memberpractice.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponse {
    private final Long id;
    private final String name;
    private final String email;

    public MemberUpdateResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
