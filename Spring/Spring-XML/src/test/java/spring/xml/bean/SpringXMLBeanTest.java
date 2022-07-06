package spring.xml.bean;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sid.spring.xml.bean.Coach;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Log
public class SpringXMLBeanTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeAll
    static void start() {
        log.info("Beginning XML Bean Tests");
    }

    @Test
    @DisplayName("XML Bean Test 1 - XML Bean Definition")
    public void trackCoachCheck() {
        context = new ClassPathXmlApplicationContext("context/bean/xmlbean1Context.xml");
        Coach coach = context.getBean("trackCoach", Coach.class);
        assertEquals("Run a 5k.", coach.getDailyWorkout());
    }

    @Test
    @DisplayName("XML Bean Test 2 - XML Bean Fail")
    public void xmlBeanFailTest() {
        String expectedFailureMessage = "Cannot find class [org.sid.spring.xml.FailCoach] for bean with name 'failCoach' defined in class path resource [context/bean/xmlbean2Context.xml]; nested exception is java.lang.ClassNotFoundException: org.sid.spring.xml.FailCoach";
        Throwable exception = assertThrows(CannotLoadBeanClassException.class, () -> {
            context = new ClassPathXmlApplicationContext("context/bean/xmlbean2Context.xml");
        });
        log.severe(exception.getMessage());
        assertEquals(expectedFailureMessage, exception.getMessage());
    }

    @Test
    @DisplayName("XML Bean Test 3 - IOC Test")
    public void basketBallCoachCheck() {
        context = new ClassPathXmlApplicationContext("context/bean/xmlbean1Context.xml");
        Coach coach = context.getBean("basketballCoach", Coach.class);
        assertEquals("Practice Throws.", coach.getDailyWorkout());
    }

    @AfterAll
    static void done() {
        log.info("XML Bean Tests Completed");
        if (context != null) {
            context.close();
        }
    }

}
