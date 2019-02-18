package com.infinova.sfdhf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.infinova.sfdhf.dao")
public class SfDhfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfDhfApplication.class, args);
    }

}

