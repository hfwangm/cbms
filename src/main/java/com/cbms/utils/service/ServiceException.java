package com.cbms.utils.service;

/**
 * Service层公用exception
 * 继承自runtimeexception,从由spring管理事务的函数抛出时触发事务回滚
 * Created by Administrator on 2015/3/14.
 */
public class ServiceException extends RuntimeException{

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ServiceException(String message , Throwable cause){
        super(message , cause);
    }

}
