package org.setterinjection;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<String> address;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public void show() {
        System.out.println("Student id: " + id);
        System.out.println("Student name: " + name);
        for (String s : address) {
            System.out.println(s);
        }
    }
}
