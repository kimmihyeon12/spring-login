package com.hohocompany.user.repository;

import com.hohocompany.user.domain.UserEntity;
import com.hohocompany.user.dto.UserForm;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaUserRepository implements UserRepository {
    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public UserEntity insert(UserEntity user) {
        em.persist(user);
        return user;
    }

    @Override
    public UserEntity selectAll(Long id) {
        UserEntity user = em.find(UserEntity.class, id); //객체로 반환하는가?
        return user;
    }

    @Override
    public Long delete(Long id) {
        em.remove(id);
        return id;
    }

    @Override
    public UserEntity fIndEmail(String email) {
        UserEntity user =  em.find(UserEntity.class, email);
        if(user == null){
            return null;
        }else{
            return user;
        }

    }
}
