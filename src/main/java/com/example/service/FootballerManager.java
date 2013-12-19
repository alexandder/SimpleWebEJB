package com.example.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.domain.Footballer;

@Stateless
public class FootballerManager {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public void addFootballer(Footballer footballer) {
        footballer.setId(0);
        entityManager.persist(footballer);
    }
    
    public void deleteFootballer(Footballer footballer) {
        footballer = entityManager.find(Footballer.class, footballer.getId());
        entityManager.remove(footballer);
    }
    
    @SuppressWarnings("unchecked")
    public List<Footballer> getAllFootballers() {
        return entityManager.createNamedQuery("footballer.all").getResultList();
    }
}
