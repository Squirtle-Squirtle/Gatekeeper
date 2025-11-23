package com.gatekeeper.dynamicgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.gatekeeper.models")
public class DynamicGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicGatewayServiceApplication.class, args);
	}

}
