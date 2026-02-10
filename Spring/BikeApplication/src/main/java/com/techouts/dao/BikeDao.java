package com.techouts.dao;

import com.techouts.model.Bike;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class BikeDao implements Dao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addBike(Bike bike) {
        sessionFactory.getCurrentSession().persist(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        return sessionFactory.getCurrentSession().createQuery("from Bike",Bike.class).getResultList()   ;
    }

    @Override
    public Bike getBikeById(int id) {
        return sessionFactory.getCurrentSession().get(Bike.class, id);
    }
}
