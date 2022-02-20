package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.insertException;
import com.cy.store.service.ex.userNameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

//用户模块业务层实现类
@Service //作用 将这个类交给spring处理 能够自动创建对象和对象的维护
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void regist(User user) {
        if (user == null){
            throw new insertException("输入用户信息为空");
        }
        String userName = user.getUserName();
        User result = userMapper.findUser(userName);
        if (result != null){
            throw new userNameDuplicatedException("用户名已经注册");
        }
        //补全用户缺失的is_delete
        user.setIsDelete(0);
        //补全修改人 修改时间
        user.setCreatedUser(userName);
        user.setModifiedUser(userName);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //需要对密码进行加密
        //使用盐值+密码+盐值再加md5的方法 进行加密
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String newPassWord = getMd5passFun(oldPassword,salt);
        user.setPassword(newPassWord);
        user.setSalt(salt);

        Integer rows = userMapper.insertUser(user);



        if (rows != 1){
            throw new insertException("插入过程中出现异常");
        }
    }
    //定义一个加密方法
    private String getMd5passFun(String password,String salt){
        //加密三次
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
