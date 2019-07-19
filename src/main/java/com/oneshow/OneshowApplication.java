package com.oneshow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.oneshow.*.mapper")
public class OneshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneshowApplication.class, args);
	}

}
