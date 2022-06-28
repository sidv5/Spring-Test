package org.sid.test;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sid.spring.xml.Coach;
import org.sid.spring.xml.CricketCoach;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Log
public class SpringXMLBeanTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeAll
    static void start() {
        log.info("Beginning XML Tests");
    }

    @Test
    @DisplayName("XML Test 1 - XML Bean Definition")
    public void trackCoachCheck() {
        context = new ClassPathXmlApplicationContext("context/ioc/test1Context.xml");
        Coach coach = context.getBean("trackCoach", Coach.class);
        assertEquals("Run a 5k.", coach.getDailyWorkout());
    }

    @Test
    @DisplayName("XML Test 2 - XML Bean Fail")
    public void xmlBeanFailTest() {
        String expectedFailureMessage = "Cannot find class [org.sid.spring.xml.FailCoach] for bean with name 'failCoach' defined in class path resource [context/ioc/test2Context.xml]; nested exception is java.lang.ClassNotFoundException: org.sid.spring.xml.FailCoach";
        Throwable exception = assertThrows(CannotLoadBeanClassException.class, () -> {
            context = new ClassPathXmlApplicationContext("context/ioc/test2Context.xml");
        });
        log.severe(exception.getMessage());
        assertEquals(expectedFailureMessage, exception.getMessage());
    }

    @Test
    @DisplayName("XML Test 3 - IOC Test")
    public void basketBallCoachCheck() {
        context = new ClassPathXmlApplicationContext("context/ioc/test1Context.xml");
        Coach coach = context.getBean("basketballCoach", Coach.class);
        assertEquals("Practice Throws.", coach.getDailyWorkout());
    }

    @Test
    @DisplayName("XML Test 4 - Constructor DI")
    public void constructorDependencyInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di1Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        assertEquals("Great day today", coach.getFortune());
    }

    @Test
    @DisplayName("XML Test 5 - Setter DI")
    public void setterDependencyInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di1Context.xml");
        Coach coach = context.getBean("cricketCoach", Coach.class);
        assertEquals("Practice Bowling", coach.getDailyWorkout());
        assertEquals("Great day today", coach.getFortune());
    }

    @Test
    @DisplayName("XML Test 6 - Literal Value Injection")
    public void literalValueInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di1Context.xml");
        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
        assertEquals("testmail@gmail.com", coach.getEmail());
        assertEquals("kings xi", coach.getTeam());
    }

    @Test
    @DisplayName("XML Test 7 - Literal Value from Property File")
    public void propertyFileInjectionTest() {
        context = new ClassPathXmlApplicationContext("context/di/di2Context.xml");
        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
        assertEquals("testmail@gmail.com", coach.getEmail());
        assertEquals("kingsxi", coach.getTeam());
    }

    @Test
    @DisplayName("XML Test 8 - Singleton Bean Scope")
    public void singletonBeanScopeTest() {
        context = new ClassPathXmlApplicationContext("context/beanScope/beanScope1-Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        Coach newcoach = context.getBean("myCoach", Coach.class);
        assertEquals(coach, newcoach);
    }

    @Test
    @DisplayName("XML Test 9 - Prototype Bean Scope")
    public void prototypeBeanScopeTest() {
        context = new ClassPathXmlApplicationContext("context/beanScope/beanScope2-Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        Coach newcoach = context.getBean("myCoach", Coach.class);
        assertNotEquals(coach, newcoach);
    }

    @Test
    @DisplayName("XML Test 10 - Bean Lifecycle")
    public void beanLifecycleTest() {
        context = new ClassPathXmlApplicationContext("context/beanScope/beanLifecycle1-Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        assertEquals("Practice Kicking", coach.getDailyWorkout());
        // check for init and destroy s.out
    }

    @AfterAll
    static void done() {
        log.info("XML Tests Completed");
        if (context != null) {
            context.close();
        }
    }

}
