package com.cy.store.service.ex;

//用户名被占用异常
public class userNameDuplicatedException extends serviceException{
    public userNameDuplicatedException() {
        super();
    }

    public userNameDuplicatedException(String message) {
        super(message);
    }

    public userNameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public userNameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected userNameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
