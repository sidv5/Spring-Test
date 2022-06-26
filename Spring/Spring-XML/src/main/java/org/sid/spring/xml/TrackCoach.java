package org.sid.spring.xml;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackCoach implements Coach{

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Run a 5k.";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
