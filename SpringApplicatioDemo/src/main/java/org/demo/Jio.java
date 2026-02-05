package org.demo;

import org.springframework.stereotype.Component;

@Component
public class Jio implements Sim{
    @Override
    public void data() {
        System.out.println("data1");
    }
    @Override
    public void calling() {
        System.out.println("calling");
    }
}
