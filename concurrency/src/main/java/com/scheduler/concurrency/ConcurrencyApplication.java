package com.scheduler.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConcurrencyApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ConcurrencyApplication.class, args);
		ConcurrencyApplication concurrencyApplication = new ConcurrencyApplication();
		System.out.println(100 % 2000);;
	}

	public int fib(int n) {
		if (n <= 1) return n;
		return fib(n-1) + fib(n -2);
	}
}
