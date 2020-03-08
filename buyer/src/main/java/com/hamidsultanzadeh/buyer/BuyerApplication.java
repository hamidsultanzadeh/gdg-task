package com.hamidsultanzadeh.buyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerApplication.class, args);
	}

}
