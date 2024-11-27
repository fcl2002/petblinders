package com.ninja.startup.marketplace.petblinders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PetblindersApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PetblindersApplication.class, args);
    }

    public void run(String... args) throws Exception {
    }
}
