package com.cy.store.utils;


import lombok.Data;

import java.io.Serializable;

//json格式的响应
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class jsonResult<E> implements Serializable {
    //状态码
    private Integer state ;

    //消息
    private String message;
    //数据 不确定数据类型 使用范型 然后类名也需要加上范型9
    private E data;

    public jsonResult() {
    }

    public jsonResult(Integer state) {
        this.state = state;
    }

    public jsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
    //将异常传递给构造
    public jsonResult(Throwable e){
        this.message = e.getMessage();
    }


}
