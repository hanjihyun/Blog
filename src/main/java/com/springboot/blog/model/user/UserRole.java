package com.springboot.blog.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "회원"),
    WITHDRAW("ROLE_WITHDRAW", "탈퇴자");

    private final String key;
    private final String title;
}
