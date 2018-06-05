package com.spring.fpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FptApplication {

    public static void main(String[] args) {
    	System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(FptApplication.class, args);
    }
}
