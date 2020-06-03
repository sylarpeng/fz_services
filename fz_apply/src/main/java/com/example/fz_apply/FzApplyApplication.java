package com.example.fz_apply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.fz_user","com.example.fz_apply"})
public class FzApplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzApplyApplication.class, args);
    }

}
