package com.cy.store.mapper;


import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest //标注这个一个测试类 不会同项目一起打包
@RunWith(SpringRunner.class) //最外层的测试类可以省略 里层的不能省略 表示启动单元测试类 不写不能够运行
public class UserMapperTests {

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
    private UserMapper userMapper;
    @Test //注意倒包的 import org.junit.Test;
    public void insert(){
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123");
        Integer integer = userMapper.insertUser(user);
        System.out.println(integer);

    }
    @Test
    public void findByUsername(){
        User name = userMapper.findUser("张三");
        System.out.println(name);
    }

}
