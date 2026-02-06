package org.vehicle;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("petrolEngine")
@Lazy
@Scope("prototype")
public class PetrolEngine implements Engine {
    @Override
    public String getType() {
        return "PetrolEngine";
    }
}
