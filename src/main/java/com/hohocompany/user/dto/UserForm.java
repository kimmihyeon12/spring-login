package com.hohocompany.user.dto;

import com.hohocompany.user.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserForm {



    private String email;
    private String password;
    private String name;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .password(password)
                .build();
    }


    @Builder
    public UserForm(Long id, String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }




}
