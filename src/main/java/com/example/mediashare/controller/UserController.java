package com.example.mediashare.controller;

import com.example.mediashare.Util.DateUtil;
import com.example.mediashare.api.UserService;
import com.example.mediashare.jpa.UserRepository;
import com.example.mediashare.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController implements UserService {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/login/password",method = RequestMethod.POST)
    @Override
    public boolean login(@RequestBody LoginUser loginUser, HttpSession httpSession) {
        int count=userRepository.findByNameAndPassWord(loginUser.getUserName(),loginUser.getPassWord());
        if(count>0)
        {
            httpSession.setAttribute("loginTime", DateUtil.getTime());
            return true;
        }
        return false;
    }
}
