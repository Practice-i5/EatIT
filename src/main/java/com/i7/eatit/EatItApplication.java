package com.i7.eatit;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages="com.i7.eatit", annotationClass = Mapper.class)
public class EatItApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EatItApplication.class, args);
	}
}