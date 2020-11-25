package com.zuiqiang.componnent;

import com.zuiqiang.user.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 这是一个拦截器类，用于拦截未登陆用户
 */
public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        Integer userId=(Integer)request.getSession().getAttribute("userId");
//        if(userId !=null){
//            //response.sendRedirect("");
//            return false;
//
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
