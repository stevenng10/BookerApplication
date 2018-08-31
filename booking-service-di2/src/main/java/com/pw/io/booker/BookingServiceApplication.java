package com.pw.io.booker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.pw.io.booker.config", "com.pw.io.booker.controller",
		"com.pw.io.booker.repository.impl.jdbc", "com.pw.io.booker.repository.impl.map" })
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}
