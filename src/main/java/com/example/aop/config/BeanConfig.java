package com.example.aop.config;

import com.example.aop.database.IMockDAO;
import com.example.aop.database.MockDAO;
import com.example.aop.proxy.LoggingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class BeanConfig {

    @Autowired
    MockDAO mockDAO;

    @Bean(name = "mockDAOProxy")
    public IMockDAO mockDAOProxy() {
        return (IMockDAO) Proxy.newProxyInstance(mockDAO.getClass().getClassLoader(),
                                                mockDAO.getClass().getInterfaces(),
                                                new LoggingProxy(mockDAO));
    }
}
