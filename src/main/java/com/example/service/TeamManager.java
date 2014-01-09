/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.service;

import com.example.domain.Team;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aleksander
 */
@Stateless
public class TeamManager {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public void addTeam(Team team) {
        team.setId(0);
        entityManager.persist(team);
    }
    
    public List<Team> getAllTeams() {
        return entityManager.createNamedQuery("team.all").getResultList();
    }
}
