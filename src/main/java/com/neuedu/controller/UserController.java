package com.neuedu.controller;


import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    IUserService userService;


    @RequestMapping(value="login", method= RequestMethod.GET)
    public String login(){

        return "login";
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    public String login(UserInfo userInfo, HttpSession session,HttpServletResponse response){

        UserInfo loginUserInfo=userService.login(userInfo);
        System .out.println(loginUserInfo);

        if(loginUserInfo!=null) {
            session.setAttribute(Const.CURRENT_USER,loginUserInfo);

            Cookie username_cookie=new Cookie("username",userInfo.getUsername());
            Cookie password_cookie=new Cookie("password",userInfo.getPassword());

            /**
             * 设置cookie保存7天
             */
            username_cookie.setMaxAge(60*60*24*7);
            password_cookie.setMaxAge(60*60*24*7);

            response.addCookie(username_cookie);
            response.addCookie(password_cookie);


            return "redirect:home";
        }

        return "login";
    }


    @RequestMapping("home")
    public String home(){
        return "home";

    }

}
