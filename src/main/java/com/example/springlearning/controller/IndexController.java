package com.example.springlearning.controller;

import com.example.springlearning.jpa.UserRepository;
import com.example.springlearning.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/page")
    public ModelAndView handleIndex()
    {
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value="/data",method = RequestMethod.POST)
    @ResponseBody
    //,@RequestParam String token
    public UserInfo data(HttpServletResponse httpServletResponse)
    {
        List<UserInfo> list=userRepository.findByNameAndPassWord();
        for(UserInfo x:list)
            System.out.println(x.getUsername());
        return list.size()==0?null:list.get(0);
    }
}
