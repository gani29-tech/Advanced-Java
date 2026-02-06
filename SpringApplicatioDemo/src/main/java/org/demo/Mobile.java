package org.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
    @Autowired
    private Sim sim;
     public void useSim(){
         sim.calling();
         sim.data();
     }
    // Without Configuration File
     public static void main(String[] args) {
         ApplicationContext com = new AnnotationConfigApplicationContext("org.demo");
         Mobile mobile = com.getBean(Mobile.class);
         mobile.useSim();
     }
}
