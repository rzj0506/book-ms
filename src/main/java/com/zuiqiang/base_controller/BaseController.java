package com.zuiqiang.base_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.zuiqiang.user.domain.User;


/**
 *这是控制器的基类
 * 若想使用该基类，请继承它
 * @author rzj
 */
public class BaseController {

    protected HttpServletRequest request;
    protected User loginUser;
    protected Integer userId;

    /**在每一个子类方法调用之前调用
     * 获取登录用户信息
     * @param request
     */
    @ModelAttribute
    public void getLoginUser(HttpServletRequest request) {
        this.request = request;

        User loginUser = (User) request.getSession().getAttribute("loginUser");

       userId = Integer.getInteger(request.getHeader("sessionId"));

    }
}
