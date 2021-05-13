package com.soma.pgui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:config.properties"})
public class PguiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PguiApplication.class, args);
	}

}
