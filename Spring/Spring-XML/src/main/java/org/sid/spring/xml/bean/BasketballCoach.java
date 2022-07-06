package org.sid.spring.xml.bean;

import lombok.NoArgsConstructor;
import org.sid.spring.xml.di.FortuneService;

@NoArgsConstructor
public class BasketballCoach implements Coach{

	public String getDailyWorkout() {
		return "Practice Throws.";
	}

}
