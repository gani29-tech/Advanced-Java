package org.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
        //Sim sim = con.getBean("sim",Sim.class);
        ApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
        Sim sim = con.getBean(Sim.class);
        sim.calling();
        sim.data();
    }
}
