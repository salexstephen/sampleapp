/**
 * 
 */
package com.staterkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ismailibrahim.s@cognizant.com This is a Spring boot application class
 *         which implements a CommandLineRunner. This class will create and load
 *         all the required beans during runtime
 */
@SpringBootApplication
public class Application {

	/**
	 * Loading all the required beans for this demo application
	 * 
	 * @param args[]
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
