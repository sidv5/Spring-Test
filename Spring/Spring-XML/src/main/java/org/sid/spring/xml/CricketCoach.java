package org.sid.spring.xml;

import lombok.extern.java.Log;

@Log
public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    public void setFortuneService(FortuneService fortuneService) {
        log.info("CricketCoach - inside setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Bowling";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
