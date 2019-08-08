package com.neuedu.Interceptor;

import com.neuedu.consts.Const;
import com.neuedu.dao.UserInfoMapper;
import com.neuedu.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Component
@RequestMapping("/user/")
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session=request.getSession();
        UserInfo userInfo2=(UserInfo)request.getSession().getAttribute(Const.CURRENT_USER);
        System.out.println(userInfo2);
        if(userInfo2!=null)
        {
            return true;
        }

        /**
         * 从cookie获取用户名密码
         */

        Cookie[] cookies=request.getCookies();
        UserInfo userInfo=new UserInfo();
        if(cookies!=null&&cookies.length>0)
        {
            for(Cookie c:cookies)
            {
                //c->name value
                if(c.getName().equals("username"))
                {
                    userInfo.setUsername(c.getValue());
                }
                if(c.getName().equals("password"))
                {
                    userInfo.setPassword(c.getValue());
                }

            }
        }
        /**
         * 判断用户名密码是否正确
         */
        if(userInfo.getUsername()!=null&&userInfo.getPassword()!=null)//根据用户名密码进行登录
        {
            int username_result=userInfoMapper.exsitsUsername(userInfo.getUsername());
            if(username_result!=0)
            {

                UserInfo userInfo_result=userInfoMapper.findByUsernameAndPassword(userInfo);
                if(userInfo_result!=null)
                {

                    return true;
                }
            }


        }
        /**
         * 不行返回登录
         */

        try {
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

