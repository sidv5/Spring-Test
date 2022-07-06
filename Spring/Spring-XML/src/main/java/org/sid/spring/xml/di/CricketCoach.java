package org.sid.spring.xml.di;

import lombok.extern.java.Log;

@Log
public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String team;

    private String email;

    public String getTeam() {
        return team;
    }

    public String getEmail() {
        return email;
    }
    public void setTeam(String team) {
        this.team = team;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
