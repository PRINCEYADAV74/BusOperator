package com.yash.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
	
	//@Scheduled(cron="0 0 10,22 * * *")
    
	@Scheduled(initialDelay=15000, fixedDelay=20000)
	public void markExpired() {
		System.out.println("Helllooooooo again"+java.time.LocalTime.now());
		
	}
}
