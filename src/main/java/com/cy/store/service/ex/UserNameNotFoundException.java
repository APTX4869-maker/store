package com.cy.store.service.ex;

//用户查询不到异常
public class UserNameNotFoundException extends serviceException{
    public UserNameNotFoundException() {
        super();
    }

    public UserNameNotFoundException(String message) {
        super(message);
    }

    public UserNameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
