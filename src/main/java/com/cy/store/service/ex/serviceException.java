package com.cy.store.service.ex;

/**
 * 作为业务层的异常基类 根据业务层不同功能来详细定义具体的异常类型 统一的去继承serviceException异常类
 */
public class serviceException extends RuntimeException{
    public serviceException() {
        super();
    }

    public serviceException(String message) {
        super(message);
    }

    public serviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public serviceException(Throwable cause) {
        super(cause);
    }

    protected serviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
