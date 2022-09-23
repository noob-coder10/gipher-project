package com.gipher;

import com.gipher.controller.UserController;
import com.gipher.models.User;
import com.gipher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
public class GipherserverApplication implements CommandLineRunner {
	private static final Logger logger= LogManager.getLogger(GipherserverApplication.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(GipherserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
