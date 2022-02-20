package com.cy.store.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 作为实体类的基类
 */
@EqualsAndHashCode()
@Data
@ToString
public class baseEntity implements Serializable { //因为要在网络中以流的方式传输数据 所以需要实现serializable方法
    private String createdUser;
    private Date createdTime ;
    private String modifiedUser;
    private Date modifiedTime ;
}
