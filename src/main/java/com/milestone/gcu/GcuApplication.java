/*
 * GcuApplication.java:
 * Developer: Nathan Meyer
 * 
 * Description: The main class for the Spring Boot Application. Starts the application and configures it for use on cloud services.
 */

package com.milestone.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GcuApplication extends SpringBootServletInitializer{

	
	/** 
	 * GcuApplication.main:
	 * Starts the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(GcuApplication.class, args);
	}

	
	/** 
	 * GcuApplication.SpringApplicationBuilder
	 * Configures the application to be able to run on cloud services
	 * @param builder
	 * @return SpringApplicationBuilder
	 */
	@Override
  	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(GcuApplication.class);
  }
}
