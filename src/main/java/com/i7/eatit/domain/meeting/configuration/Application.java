package com.i7.eatit.domain.meeting.configuration;

import com.i7.eatit.EatItApplication;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.i7.eatit.domain")
@MapperScan(basePackages = "com.i7.eatit.domain", annotationClass = Mapper.class)
public class Application {
    public static void main(String[] args) {SpringApplication.run(Application.class, args);}
}
