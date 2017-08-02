package com.brander;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:jdbc.properties") //可加载多个配置文件
@MapperScan("cn.form1.mapper") //指定mybatis的Mapper的包路径
public class BranderApplication {

	public static void main(String[] args) {

		SpringApplication.run(BranderApplication.class, args);

	}
}
