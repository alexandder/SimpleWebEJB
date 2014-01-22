/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.service;

import com.example.domain.Competition;
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
public class CompetitionManager {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public void addCompetition(Competition competition, long teamId){
        Team team = entityManager.find(Team.class, teamId);
        competition.setId(0);
        competition.getTeams().add(team);
        entityManager.persist(competition);
    }
    
    public List<Competition> getAllCompetitions() {
        return entityManager.createNamedQuery("competition.all").getResultList();
    }
    
    
}
