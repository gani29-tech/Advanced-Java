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
        Engine dieselEngine1 = createDieselEngine();
        Engine dieselEngine2 = createDieselEngine();
        System.out.println("Diesel1 Engine Hashcode : "+dieselEngine1.hashCode());
        System.out.println("Diesel2 Engine Hashcode : "+dieselEngine2.hashCode());
        System.out.println(("Same Object of Diesel?"+(dieselEngine2==dieselEngine1)));
        Engine petrolEngine1 = createPetrolEngine();
        Engine petrolEngine2 = createPetrolEngine();
        System.out.println("Petrol Engine Hashcode : "+petrolEngine1.hashCode());
        System.out.println("Petrol Engine Hashcode : "+petrolEngine2.hashCode());
        System.out.println("Same Object of Petrol?"+(petrolEngine1==petrolEngine2));
    }
    @Lookup("dieselEngine")
    protected Engine createDieselEngine(){
        return null;
    }
    @Lookup("petrolEngine")
    protected Engine createPetrolEngine(){
        return null;
    }
}
