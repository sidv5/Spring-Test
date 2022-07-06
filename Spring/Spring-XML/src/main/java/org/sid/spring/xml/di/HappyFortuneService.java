package org.sid.spring.xml.di;

public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Great day today";
    }
}
