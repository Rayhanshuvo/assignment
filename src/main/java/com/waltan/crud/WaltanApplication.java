package com.waltan.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class) 
public class WaltanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaltanApplication.class, args);
	}

}
