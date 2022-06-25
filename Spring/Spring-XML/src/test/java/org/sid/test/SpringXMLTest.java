package org.sid.test;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sid.spring.xml.Coach;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Log
public class SpringXMLTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeAll
    static void start(){
        log.info("Beginning XML Tests");
    }

    @Test
    @DisplayName("XML Test 1 - XML Bean Definition")
    public void trackCoachCheck() {
        context = new ClassPathXmlApplicationContext("context/ioc/test1Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        assertEquals("Run a 5k.",coach.getDailyWorkout());
    }

    @Test
    @DisplayName("XML Test 2 - XML Bean Fail")
    public void xmlBeanFailTest() {
        String expectedFailureMessage = "Cannot find class [org.sid.spring.xml.FailCoach] for bean with name 'myCoach' defined in class path resource [context/test2Context.xml]; nested exception is java.lang.ClassNotFoundException: org.sid.spring.xml.FailCoach";
        Throwable exception = assertThrows(CannotLoadBeanClassException.class, () -> {
            context = new ClassPathXmlApplicationContext("context/ioc/test2Context.xml");
        });
        log.severe(exception.getMessage());
        assertEquals(expectedFailureMessage, exception.getMessage());
    }

    @Test
    @DisplayName("XML Test 3 - IOC Test")
    public void basketBallCoachCheck() {
        context = new ClassPathXmlApplicationContext("context/ioc/test3Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        assertEquals("Practice Throws.",coach.getDailyWorkout());
    }

    @AfterAll
    static void done() {
        log.info("XML Tests Completed");
        context.close();
    }

}
