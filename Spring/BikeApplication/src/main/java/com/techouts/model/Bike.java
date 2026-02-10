package com.techouts.model;

import jakarta.persistence.*;

@Entity
public class Bike{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bike() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Bike(String name, int cc) {
        this.name = name;
        this.cc = cc;
    }
    @Column(name="bike_name")
    private String name;
    @Column(name="cubic_capacity")
    private int cc;
}
