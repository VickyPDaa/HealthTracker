package com.yoga.yoga_tracker_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class YogaTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogaTrackerServiceApplication.class, args);
	}

}
