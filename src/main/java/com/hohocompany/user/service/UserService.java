package com.hohocompany.user.service;

import com.hohocompany.user.domain.UserEntity;
import com.hohocompany.user.dto.Message;
import com.hohocompany.user.dto.UserForm;

public interface UserService {
    UserEntity signIn(UserForm userForm);
    Message signUp(String eamil, String password);
    Long withdrawal(Long id);

}
