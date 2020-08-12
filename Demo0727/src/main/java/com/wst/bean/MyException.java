package com.wst.bean;

public class MyException extends Exception{
    public MyException() {
        super("这是发生了自定义异常-MyException") ;
    }
}
