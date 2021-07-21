package com.hohocompany.user.repository;

import com.hohocompany.user.domain.UserEntity;
import com.hohocompany.user.dto.UserForm;

public interface UserRepository {
    UserEntity insert(UserEntity user);
    UserEntity selectAll(Long id);
    UserEntity fIndEmail(String email);
    Long delete(Long id);
}
