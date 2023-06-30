package com.example.aop.config;

import com.example.aop.database.MockDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    MockDAO mockDAO() {
        return new MockDAO();
    }
}
