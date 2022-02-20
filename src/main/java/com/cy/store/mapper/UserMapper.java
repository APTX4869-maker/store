package com.cy.store.mapper;

import com.cy.store.entity.User;

/**
 * 用户模块持久层接口 111
 */
public interface UserMapper {

    /**
     * 插入用户的数据
     * @param user 用户的信息
     * @return 受影响的行数（增删改都有受影响的行数，可以根据返回值来判断是否执行成功）
     */
    Integer insertUser(User user);

    /**
     * 通过用户名查询用户是否存在
     * @param username 用户名
     * @return 如果找到返回用户数据 如果没有找到 返回null
     */
    User findUser(String username);
}
