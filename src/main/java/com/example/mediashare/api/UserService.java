package com.example.mediashare.api;

import com.example.mediashare.controller.UserController;
import com.example.mediashare.model.LoginUser;
import com.example.mediashare.model.UserInfo;
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
    /**
     *注册
     * success:
     *  status: 200
     *fail:
     *  status: 403
     * @param user username,password
     * @return ture :注册成功,false :注册失败，用户名已存在
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    boolean register(@RequestBody UserInfo user);
}
