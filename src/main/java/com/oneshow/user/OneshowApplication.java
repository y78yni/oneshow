package com.oneshow.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oneshow.*.mapper")
public class OneshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneshowApplication.class, args);
	}

}
