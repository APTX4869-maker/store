package com.cy.store.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

//用户的实体类
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class User extends baseEntity implements Serializable {
    private Integer uid ;
    private String userName ;
    private String  password ;
    private String salt ;
    private String phone ;
    private String email ;
    private Integer gender ;
    private String avatar ;
    private Integer isDelete ;
}
