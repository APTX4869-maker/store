package com.cy.store.service;

import com.cy.store.entity.User;

//用户模块 业务层接口
public interface IUserService {

    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void regist(User user);

    /**
     * 用于用户登陆
     * @param userName 用户名
     * @param password 密码
     * @return 返回登陆的用户信息，如果没有返回 null
     */
    User login(String userName,String password);

    /**
     * 用于修改密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     * @param userName
     */
    void updatePassword(Integer uid,String oldPassword,String newPassword,String userName);
}
