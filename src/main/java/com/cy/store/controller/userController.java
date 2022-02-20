package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.insertException;
import com.cy.store.service.ex.userNameDuplicatedException;
import com.cy.store.utils.jsonResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //@Controller + @ResponseBody controller 表示这个类被spring接管为控制器类 responsebody表示以json格式响应到前端
@RequestMapping("/users") //什么类型的请求能进入该controller
public class userController extends BaseController{
    @Autowired
    private IUserService userService ; //依赖于用户层接口

    @RequestMapping("/reg")
    private jsonResult<Void> reg(User user) {
        // jsonResult<Void> result = new jsonResult<>();

        //没有使用统一异常处理基类的写法
//        try {
//            userService.regist(user);
//            result.setState(200);
//            result.setMessage("注册成功");
//        } catch (userNameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用了");
//        }catch (insertException e) {
//            result.setState(5000);
//            result.setMessage("插入时异常");
//        }
//        return result;
//    }
        userService.regist(user);
        return new jsonResult<>(success);
    }
}
