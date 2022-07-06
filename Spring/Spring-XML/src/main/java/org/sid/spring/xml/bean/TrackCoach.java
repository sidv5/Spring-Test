package org.sid.spring.xml.bean;

import lombok.NoArgsConstructor;
import org.sid.spring.xml.di.FortuneService;

@NoArgsConstructor
public class TrackCoach implements Coach{

	public String getDailyWorkout() {
		return "Run a 5k.";
	}

}
