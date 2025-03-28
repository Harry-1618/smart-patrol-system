package com.hrt.smartpatrolsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hrt.smartpatrolsystem.mapper")
public class SmartPatrolSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartPatrolSystemApplication.class, args);
    }

}
