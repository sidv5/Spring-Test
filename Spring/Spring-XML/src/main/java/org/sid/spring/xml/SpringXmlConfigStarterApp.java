package org.sid.spring.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlConfigStarterApp {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
		
	}
}
