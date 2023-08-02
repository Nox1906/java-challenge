package com.javachallenge.streamworker;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisServer;

import java.io.IOException;

@SpringBootApplication
public class StreamWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamWorkerApplication.class, args);
	}

}
