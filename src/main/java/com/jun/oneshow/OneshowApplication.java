package com.jun.oneshow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jun.oneshow.mapper")
public class OneshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneshowApplication.class, args);
	}

}
