package org.vehicle1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vehicle1.config.AppConfig;
import org.vehicle1.engine.DieselEngine;
import org.vehicle1.engine.PetrolEngine;

public class Main {
    public static void main(String[] args) {
       System.setProperty("spring.profiles.active", "dev");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Bike bike = context.getBean(Bike.class);
        bike.bikeDetails();
        DieselEngine dieselEngine1 = (DieselEngine) context.getBean("dieselEngine");
        DieselEngine dieselEngine2 = (DieselEngine) context.getBean("dieselEngine");
        System.out.println("dieselEngine1 Hashcode: " + dieselEngine1.hashCode());
        System.out.println("dieselEngine2 Hashcode: " + dieselEngine2.hashCode());
        System.out.println("Same Object?"+(dieselEngine1==dieselEngine2));
        PetrolEngine petrolEngine1 = (PetrolEngine) context.getBean("petrolEngine");
        PetrolEngine petrolEngine2 = (PetrolEngine) context.getBean("petrolEngine");
        System.out.println("petrolEngine1 Hashcode: " + petrolEngine1.hashCode());
        System.out.println("petrolEngine2 Hashcode: " + petrolEngine2.hashCode());
        System.out.println("Same Object?"+(petrolEngine1==petrolEngine2));
    }
}
