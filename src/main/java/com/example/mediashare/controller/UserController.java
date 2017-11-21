package com.example.mediashare.controller;

import com.example.mediashare.api.UserService;
import com.example.mediashare.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userlogin")
public class UserController implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean login(LoginUser user) {
        return false;
    }

    public class LoginUser
    {
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        private String userName;
        private String passWord;
    }
}
