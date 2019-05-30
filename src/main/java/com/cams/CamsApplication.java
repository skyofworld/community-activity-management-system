package com.cams;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.cams.dao.mapper")
@EnableCaching
public class CamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamsApplication.class, args);
	}

}
