package org.sid.spring.xml;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BasketballCoach implements Coach{

	private FortuneService fortuneService;

	public BasketballCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Practice Throws.";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
