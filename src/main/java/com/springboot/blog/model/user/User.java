package com.springboot.blog.model.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id_pk")
    private Long id;

    private String email;
    private String password;
    private String name;
    private LocalDate createDate;
    private String token;
    private String picture;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String email, String password, String name, LocalDate createDate, String token, String picture, UserRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.createDate = createDate;
        this.token = token;
        this.picture = picture;
        this.role = role;

    }
    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;
        return this;
    }
    public String getRoleKey() {
        return this.role.getKey();
    }
}
