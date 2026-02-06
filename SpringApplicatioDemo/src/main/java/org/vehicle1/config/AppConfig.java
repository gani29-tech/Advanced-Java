package org.vehicle1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.vehicle1")
@PropertySource("classpath:application.properties")
@Import({PetrolEngineConfig.class, DevDieselEngineConfig.class})
public class AppConfig {
}
