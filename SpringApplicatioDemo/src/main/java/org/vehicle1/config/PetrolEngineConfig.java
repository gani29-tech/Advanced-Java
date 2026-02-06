package org.vehicle1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.vehicle1.engine.PetrolEngine;
import org.vehicle1.engine.Engine;

public class PetrolEngineConfig {
    @Bean
    @Primary
    @Scope("prototype")
    public Engine petrolEngine() {
        System.out.println("petrol engine is running");
        return new PetrolEngine();
    }
}
