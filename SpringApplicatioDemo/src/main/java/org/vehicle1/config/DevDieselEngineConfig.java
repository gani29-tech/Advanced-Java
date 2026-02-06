package org.vehicle1.config;

import org.springframework.context.annotation.*;
import org.vehicle1.engine.DieselEngine;
import org.vehicle1.engine.Engine;

@Configuration
@Profile("dev")
public class DevDieselEngineConfig {
    @Bean
    @Scope("singleton")
    public Engine dieselEngine() {
        System.out.println("Diesel engine is running");
        return new DieselEngine();
    }
}
