package org.sid.test;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sid.component.scan.Animal;
import org.sid.component.scan.autowired.FeralAnimal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Log
public class SpringXMLConfigurationTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeAll
    static void start() {
        log.info("Beginning XML Configuration Tests");
    }

    @Test
    @DisplayName("Configuration Test 1 - Explicit Name Component Scan")
    public void explicitComponentNameCheck() {
        context = new ClassPathXmlApplicationContext("context/componentScan/componentScan1-context.xml");
        Animal animal = context.getBean("myComponentAnimal", Animal.class);
        assertEquals("Bark!", animal.makeSound());
    }

    @Test
    @DisplayName("Configuration Test 2 - Default Name Component Scan")
    public void defaultComponentNameCheck() {
        context = new ClassPathXmlApplicationContext("context/componentScan/componentScan1-context.xml");
        Animal animal = context.getBean("horse", Animal.class);
        assertEquals("Neigh!", animal.makeSound());
    }

    @Test
    @DisplayName("Configuration Test 3 - Constructor Injection")
    public void constructorInjectionCheck() {
        context = new ClassPathXmlApplicationContext("context/componentScan/componentScan2-context.xml");
        FeralAnimal animal = context.getBean("tiger", FeralAnimal.class);
        assertEquals("Meow!", animal.makeSound());
        assertEquals("Meat", animal.getTodaysFood());
    }

    @AfterAll
    static void done() {
        log.info("XML Configuration Tests Completed");
        if (context != null) {
            context.close();
        }
    }

}
