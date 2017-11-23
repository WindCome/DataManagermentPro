package com.example.mediashare.jpa;

import com.example.mediashare.model.UserInfo;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    @Query(value="select count(u) from UserInfo u where u.username = ?1 and u.password = ?2")//
    int findByNameAndPassWord(String name, String password);
}
