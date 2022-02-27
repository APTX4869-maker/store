package com.cy.store.interceptor;

import com.cy.store.service.ex.UserNameNotFoundException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现用户登陆拦截功能
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测q全局session对象中是否有uid , 如果有就放行 ，如果没有就拦截 重定向到登陆页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器 url+controller映射
     * @return true 表示放行 / false 表示拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //通过HttpServletRequest 来获取session对象
        Object result = request.getSession().getAttribute("uid");
        if (result == null){
            //如果用户没有登陆过，重定向到login.html页面 暂时没有
           // response.sendRedirect("/web/login.html");
            throw new UserNameNotFoundException("用户名不存在");
        }

        return true ;

    }

}
