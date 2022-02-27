package com.cy.store.config;


import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration //加载当前拦截器并进行注册
public class loginInterceptorConfigure implements WebMvcConfigurer {


    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建一个自定义的拦截器
        HandlerInterceptor interceptor = new LoginInterceptor();
        //配置白名单集合
        List<String> parttens = new ArrayList<>();
        parttens.add("/web/**"); //将不需要拦截的前端页面配置到list集合中
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(parttens);
    }
}
