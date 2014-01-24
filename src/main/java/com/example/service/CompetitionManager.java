/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.service;

import com.example.domain.Competition;
import com.example.domain.Team;
import java.util.ArrayList;
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
    
    public void addCompetition(Competition competition, Long[] teamsId){
        competition.setId(0);
        List<Team> teams = new ArrayList<>();
        for (Long teamId: teamsId) {
            Team team = entityManager.find(Team.class, teamId);
            teams.add(team);
        }
        competition.setTeams(teams);
        entityManager.persist(competition);
    }
    
    public void updateCompetition(Competition competition, Long[] teamsId) {
        for (Long teamId: teamsId) {
            Team team = entityManager.find(Team.class, teamId);
            competition.getTeams().add(team);
        }
        entityManager.merge(competition);
    }
    
    public void deleteCompetition(Competition competition) {
        competition = entityManager.find(Competition.class, competition.getId());
        entityManager.remove(competition);
    }
    
    public void removeTeamFromCompetition(Competition competition, Team team) {
        competition.getTeams().remove(team);
        entityManager.merge(competition);
    }
    
    @SuppressWarnings("unchecked")
    public List<Competition> getAllCompetitions() {
        return entityManager.createNamedQuery("competition.all").getResultList();
    }
    
    
}
