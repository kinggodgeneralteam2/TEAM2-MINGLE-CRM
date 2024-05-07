package com.team2final.minglecrm.domain;


import com.team2final.minglecrm.BaseTimeEntity;
import com.team2final.minglecrm.controller.user.dto.UserUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="users")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String authority;
    private Boolean deletedYn;

    @Builder
    public User(String name, String email, String password, String authority, Boolean deletedYn ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.deletedYn = deletedYn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateUser(UserUpdateRequest userUpdateRequest, String encodedPassword) {
        this.name = userUpdateRequest.getName();
        this.password = encodedPassword;
    }
}
