package com.cy.store.service.ex;

//数据插入过程中的异常
public class insertException extends serviceException{
    public insertException() {
        super();
    }

    public insertException(String message) {
        super(message);
    }

    public insertException(String message, Throwable cause) {
        super(message, cause);
    }

    public insertException(Throwable cause) {
        super(cause);
    }

    protected insertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
