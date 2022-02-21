package com.cy.store.service;


import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.serviceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest //标注这个一个测试类 不会同项目一起打包
@RunWith(SpringRunner.class) //最外层的测试类可以省略 里层的不能省略 表示启动单元测试类 不写不能够运行
public class UserServiceTests {

    /**
     * 单元测试方法满足的条件 可以独立运行 不用启动服务
     * 1.方法必须被test注解修饰
     * 2.返回值的类型必须是void
     * 3.方法的参数列表不能有任何值
     * 4.方法的访问修饰符必须是public
     *
     *
     */
    @Autowired
    private IUserService userService;
    @Test //注意倒包的 import org.junit.Test;
    public void regist(){
        User user = new User();
        user.setUserName("王武");
        user.setPassword("1122");
        //密码要加密 md5

        try {
            userService.regist(user);
            System.out.println("执行完成");
        } catch (serviceException e) {
            //获取异常类对象 异常类名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常信息
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void login(){
        User user = userService.login("tim01", "123456");
        System.out.println(user);
    }


}
