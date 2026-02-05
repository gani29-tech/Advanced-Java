package org.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bike {
    @Autowired
    @Qualifier("petrolEngine")
    private Engine engine;
    @Value("200")
    private int cc;
    @Value("NS")
    private String name;
    void bikeDetails(){
        System.out.println("Bike cc : "+cc);
        System.out.println("Bike name : "+name);
        System.out.println("Engine Type: "+engine.getType());
        Engine diesel = createDieselEngine();
        System.out.println("Diesel Type: "+diesel.getType());
    }
    @Lookup("dieselEngine")
    protected Engine createDieselEngine(){
        return null;
    }
}
