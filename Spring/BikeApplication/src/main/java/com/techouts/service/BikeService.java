package com.techouts.service;

import com.techouts.dao.BikeDao;
import com.techouts.model.Bike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    private final BikeDao bikeDao;
    public BikeService(BikeDao bikeDao){
        this.bikeDao=bikeDao;
    }
    public void addBike(Bike bike) {
        bikeDao.addBike(bike);
    }
    public List<Bike> getAllBikes() {
        return bikeDao.getAllBikes();
    }
}
