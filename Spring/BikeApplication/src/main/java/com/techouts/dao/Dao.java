package com.techouts.dao;

import com.techouts.model.Bike;

import java.util.List;

public interface Dao {
    public void addBike(Bike bike);
    public List<Bike> getAllBikes();
    public Bike getBikeById(int id);
}
