package org.vehicle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("petrolEngine")
@Lazy
public class PetrolEngine implements Engine {
    @Override
    public String getType() {
        return "PetrolEngine";
    }
}
