package com.example.mediashare.api;

import com.example.mediashare.controller.UserController;
import com.example.mediashare.model.LoginUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     *根据用户名和密码登录
     * success:
     *  status: 200
     *fail:
     *  status: 403
     * @param loginUser username,password
     * @return ture :用户名和密码正确,false :登录失败
     */
    @RequestMapping(value = "/login/password",method = RequestMethod.POST)
    boolean login(@RequestBody LoginUser loginUser, HttpSession httpSession);
}
