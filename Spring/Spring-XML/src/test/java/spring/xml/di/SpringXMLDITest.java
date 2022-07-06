package spring.xml.di;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sid.spring.xml.di.Coach;
import org.sid.spring.xml.di.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Log
public class SpringXMLDITest {

    private static ClassPathXmlApplicationContext context;

    @BeforeAll
    static void start() {
        log.info("Beginning XML DI Tests");
    }

    @Test
    @DisplayName("XML DI Test 1 - Constructor DI")
    public void constructorDependencyInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di1Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        assertEquals("Great day today", coach.getFortune());
    }

    @Test
    @DisplayName("XML DI Test 2 - Setter DI")
    public void setterDependencyInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di1Context.xml");
        Coach coach = context.getBean("cricketCoach", Coach.class);
        assertEquals("Practice Bowling", coach.getDailyWorkout());
        assertEquals("Great day today", coach.getFortune());
    }

    @Test
    @DisplayName("XML DI Test 3 - Literal Value Injection")
    public void literalValueInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di1Context.xml");
        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
        assertEquals("testmail@gmail.com", coach.getEmail());
        assertEquals("kings xi", coach.getTeam());
    }

    @Test
    @DisplayName("XML DI Test 4 - Literal Value from Property File")
    public void propertyFileInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di2Context.xml");
        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
        assertEquals("testmail@gmail.com", coach.getEmail());
        assertEquals("kingsxi", coach.getTeam());
    }

    @AfterAll
    static void done() {
        log.info("XML Tests Completed");
        if (context != null) {
            context.close();
        }
    }

}
