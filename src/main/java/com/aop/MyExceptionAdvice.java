package com.aop;

public class MyExceptionAdvice  {
    public void myexception(Exception e1){
        System.out.println("执行异常通知 "+e1.getMessage());
    }
}
