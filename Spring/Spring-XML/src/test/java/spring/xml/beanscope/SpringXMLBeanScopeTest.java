package spring.xml.beanscope;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sid.spring.xml.beanscope.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Log
public class SpringXMLBeanScopeTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeAll
    static void start() {
        log.info("Beginning XML BeanScope Tests");
    }

    @Test
    @DisplayName("XML BeanScope Test 1 - Singleton Bean Scope")
    public void singletonBeanScopeTest() {
        context = new ClassPathXmlApplicationContext("context/beanScope/beanScope1-Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        Coach newCoach = context.getBean("myCoach", Coach.class);
        assertEquals(coach, newCoach);
    }

    @Test
    @DisplayName("XML BeanScope Test 2 - Prototype Bean Scope")
    public void prototypeBeanScopeTest() {
        context = new ClassPathXmlApplicationContext("context/beanScope/beanScope2-Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        Coach newCoach = context.getBean("myCoach", Coach.class);
        assertNotEquals(coach, newCoach);
    }

    @Test
    @DisplayName("XML BeanScope Test 3 - Bean Lifecycle")
    public void beanLifecycleTest() {
        context = new ClassPathXmlApplicationContext("context/beanScope/beanLifecycle1-Context.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        assertEquals("Practice Kicking", coach.getDailyWorkout());
        // check for init and destroy s.out
    }

    @AfterAll
    static void done() {
        log.info("XML BeanScope Tests Completed");
        if (context != null) {
            context.close();
        }
    }

}
