package com.cy.store.mapper;

import com.cy.store.entity.User;

import java.util.Date;

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


    /**
     * 通过用户uid来更新密码
     * @param uid 用户的uid
     * @param password 用户要修改的新密码
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 返回受影响的行数
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);


    /**
     * 根据uid来查询用户信息
     * @param uid 用户ID
     * @return 返回用户信息
     */
    User findByUid(Integer uid);
}
