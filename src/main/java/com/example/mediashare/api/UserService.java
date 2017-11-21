package com.example.mediashare.api;

import com.example.mediashare.controller.UserController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    /**
     *根据用户名和密码登录
     * success:
     *  status: 200
     *fail:
     *  status: 403
     * @param user username,password
     * @return ture :用户名和密码正确,false :登录失败
     */
    @RequestMapping("/login/password")
    boolean login(@RequestParam UserController.LoginUser user);
}
