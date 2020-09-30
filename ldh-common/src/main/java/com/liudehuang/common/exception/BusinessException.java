package com.liudehuang.common.exception;

public class BusinessException extends Exception{
    private static final long serialVersionUID = -6916154462432027437L;

    public BusinessException(String message){
        super(message);
    }
}
