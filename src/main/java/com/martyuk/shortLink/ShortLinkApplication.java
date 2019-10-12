package com.martyuk.shortLink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.martyuk.shortLink.data")
@EntityScan(basePackages = "com.martyuk.shortlink.entity")
@EnableTransactionManagement
@EnableScheduling
public class ShortLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortLinkApplication.class, args);
	}

}
