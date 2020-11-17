package com.zuiqiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.zuiqiang.*.dao")
@SpringBootApplication
public class BookMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMsApplication.class, args);
    }

}
