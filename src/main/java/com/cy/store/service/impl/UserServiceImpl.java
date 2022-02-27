package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
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

    @Override
    public User login(String userName, String password) {
        User user = userMapper.findUser(userName);
        if (user == null){
            throw new UserNameNotFoundException("用户没有查询到");
        }
        //再判断用户的密码是否匹配
        //1.先获取用户数据库中的密码和盐值
        String oldPass = user.getPassword();
        String salt = user.getSalt();
        //2.在用现在传入的密码来加上盐值加密 最后来比较两个密码是否相同
        String newPass = getMd5passFun(password, salt);
        if (!oldPass.equals(newPass)){
            throw new PasswordNotMatchException("密码不正确");
        }
        //还要判断用户信息是否删除过
        if (user.getIsDelete() == 1){
            throw new userNameDuplicatedException("用户不存在");
        }
        //减小数据的传输 只传有用的
        User res = new User();
        res.setUserName(user.getUserName());
        res.setAvatar(user.getAvatar());
        res.setUid(user.getUid());

        return res;
    }

    @Override
    public void updatePassword(Integer uid, String oldPassword, String newPassword, String userName) {
        User user = userMapper.findByUid(uid);
        if (user.getIsDelete() == 1 || user == null) {
            throw new UserNameNotFoundException("用户数据不存在");
        }
        //原始密码和数据库中的密码比较
        String md5passFun = getMd5passFun(oldPassword, user.getSalt());
        if (!md5passFun.equals(user.getPassword())){
            throw new PasswordNotMatchException("密码错误");
        }
        //设置新的密码
        String newMd5Password = getMd5passFun(newPassword, user.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, userName, new Date());
        if (rows != 1){
            throw new UpdateException("更新数据时产生错误");
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
