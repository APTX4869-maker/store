package com.cy.store.service;

import com.cy.store.entity.User;

//用户模块 业务层接口
public interface IUserService {

    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void regist(User user);
}
