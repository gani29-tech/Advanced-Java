package org.vehicle1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.vehicle1.engine.Engine;

@Component
public class Bike {
    @Autowired
    private Engine engine;
    @Value("${bike.cc}")
    private int cc;
    @Value("${bike.name}")
    private String name;
    void bikeDetails(){
        System.out.println("Bike cc : "+cc);
        System.out.println("Bike name : "+name);
        System.out.println("Engine Type: "+engine.getType());
    }
}
