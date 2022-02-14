package com.springboot.blog.model.user;

import lombok.*;

import javax.persistence.*;

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

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String email, String password, String name, String picture,Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
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
