package br.com.product.stockapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockapiApplication.class, args);
	}

}
