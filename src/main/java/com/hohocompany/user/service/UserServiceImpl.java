package com.hohocompany.user.service;

import com.hohocompany.user.domain.UserEntity;
import com.hohocompany.user.dto.Message;
import com.hohocompany.user.dto.UserForm;
import com.hohocompany.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity signIn(UserForm userForm) {
        UserEntity user = UserEntity.builder().email(userForm.getEmail()).password(userForm.getPassword()).name(userForm.getName()).build();
        userRepository.insert(user);
        return null;
    }
    @Override
    public Message signUp(String eamil, String password) {
        UserEntity user = userRepository.fIndEmail(eamil);
        if(user == null) return Message.builder()
                               .isSuccess(false)
                               .message("email 존재하지 않음")
                               .build(); //email과 일치하는 회원 없음!
       else{
           if (user.getPassword()==password){
               return Message.builder()
                       .isSuccess(false)
                       .message("비밀번호 불일치")
                       .build(); // 비밀번호가 일치하지 않음

           }
           else  return Message.builder()
                   .isSuccess(false)
                   .message("비밀번호 일치")
                   .build(); // 비밀번호가 일치하지 않음
       }

    }

    @Override
    public Long withdrawal(Long id) {
        return null;
    }
}
