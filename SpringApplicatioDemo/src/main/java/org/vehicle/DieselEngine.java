package org.vehicle;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dieselEngine")
@Primary
@Scope("singleton") // By default singleton in spring
public class DieselEngine implements Engine {
    @Override
    public String getType() {
        return "DieselEngine";
    }
}
