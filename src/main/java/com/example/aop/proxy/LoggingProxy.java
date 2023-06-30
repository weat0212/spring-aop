package com.example.aop.proxy;

import lombok.extern.java.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Log
public class LoggingProxy implements InvocationHandler {

    private Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            log.info("Invoke Class: " + target.getClass().getName());
            log.info("Method Name: " + method.getName());
            log.info("Args: " + Arrays.toString(args));
            return method.invoke(target, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }
}
