package org.sid.spring.xml.beanscope;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Great day today";
    }
}
