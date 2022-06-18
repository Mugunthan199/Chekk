package com.santainc.hoodfiller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HoodfillerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoodfillerApplication.class, args);
	}

}
