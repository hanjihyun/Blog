package com.springboot.blog.config.auth.dto;


import com.springboot.blog.model.user.Role;
import com.springboot.blog.model.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String password;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String email, String password, String name, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
        this.password = password;
        this.name = name;
        this.picture = picture;
    }

    //  of() OAuth2에서 반환하는 사용자 정보는 Map이기 때문에 하나하나 변환해줘야한다
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .email((String) attributes.get("email"))
                .password((String) attributes.get("password"))
                .name((String) attributes.get("name"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .password((String) response.get("password"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    //  toEntity() : User entity생성 OAuthAttributes에서 엔티티 생성하는 시점은 처음 가입했을 때
//    가입 했을 때 기본 권한 GUEST로 주기 위해 role에 작성
    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .picture(picture)
                .role(Role.USER)
                .build();
    }
}
