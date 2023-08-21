package com.cynefian.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling

public class Base 
{
     public static void main(String[] args) 
     {
    	 SpringApplication.run(Base.class, args);
     }
}