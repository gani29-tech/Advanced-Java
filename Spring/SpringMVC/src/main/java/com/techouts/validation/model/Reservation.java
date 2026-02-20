package com.techouts.validation.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Reservation {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 4, max = 10, message = "name must be 4-10 characters")
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}