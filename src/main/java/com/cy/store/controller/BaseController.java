package com.cy.store.controller;

import com.cy.store.service.ex.*;
import com.cy.store.utils.jsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;

//控制岑的基类 用于统一异常处理
public class BaseController implements Serializable {
    public static final int success = 200;

    //todo 请求处理方法 这个方法的返回值就是返回给前端的数据
    //todo 自动将异常对象传递给此方法的参数列表上
    @ExceptionHandler(serviceException.class) //用于统一处理抛出的异常
    public jsonResult<Void> handleException(Throwable e){
        jsonResult<Void> result = new jsonResult<>();
        if (e instanceof insertException){
            result.setState(5000);
            result.setMessage("插入数据异常");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(5001);
            result.setMessage("用户密码错误异常");
        }else if (e instanceof UserNameNotFoundException){
            result.setState(5002);
            result.setMessage("用户名未找到异常");
        }
        else if (e instanceof userNameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已被占用");
        }
        return result;
    }
}
