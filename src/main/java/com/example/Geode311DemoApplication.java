package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Geode311DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Geode311DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0 && args[0].equals("exitcode")) {
			throw new Exception("");
		}
	}
}
