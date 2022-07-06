package org.sid.spring.xml.beanscope;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class FootballCoach implements Coach {

	private FortuneService fortuneService;

	public FootballCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Practice Kicking";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
	public void myStartupStuff(){
		System.out.println("Football Coach: Inside init method");
	}

	public void myCleanupStuff(){
		System.out.println("Football Coach: Inside destroy method");
	}

}
