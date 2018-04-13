package com.example.qfang_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class QfangWebApplication {

	@RequestMapping("/index")
	String index(){
		System.out.println(111);
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(QfangWebApplication.class, args);
	}
}
