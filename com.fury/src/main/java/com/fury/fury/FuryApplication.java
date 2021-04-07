package com.fury.fury;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fury.fury.model.Fury;
import com.fury.fury.repository.FuryRepository;

@SpringBootApplication
public class FuryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuryApplication.class, args);
	}


}
