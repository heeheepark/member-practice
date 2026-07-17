package org.example.memberpractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberGetResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final String address;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemberGetResponse(Long id, String name, String email, String address, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
