package org.zerock.myapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@ServletComponentScan

@SpringBootApplication
public class StudySpringJdbcApp extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StudySpringJdbcApp.class, args);
		log.trace("main({}) invoked.", Arrays.toString(args));
	} // main

} // end class
