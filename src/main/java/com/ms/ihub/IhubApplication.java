package com.ms.ihub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ms.ihub.*")
@MapperScan("com.ms.ihub.**.dao")
public class IhubApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhubApplication.class, args);
    }

}
