package com.example.springlearning.jpa;

import com.example.springlearning.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    @Query(value="select u from UserInfo u ")//where u.username = ?1 and u.password = ?2
    List<UserInfo> findByNameAndPassWord();
    //String name, String password
}
