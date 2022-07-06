package org.sid.spring.xml.di;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public String getDailyWorkout() {
		return "Run a 5k.";
	}

	public TrackCoach(FortuneService myFortune){
		this.fortuneService = myFortune;
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
