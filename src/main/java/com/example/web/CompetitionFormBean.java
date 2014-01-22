/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.web;

import com.example.domain.Competition;
import com.example.service.CompetitionManager;
import com.example.service.TeamManager;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author aleksander
 */

@SessionScoped
@Named
public class CompetitionFormBean implements Serializable{
    
    private Competition competition = new Competition();
    private ListDataModel<Competition> competitions = new ListDataModel<Competition>();
    private long teamId;
    
    @Inject
    private CompetitionManager competitionManager;
    
    @Inject
    private TeamManager teamManager;

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public ListDataModel<Competition> getAllCompetitions() {
        return competitions;
    }

    public void setCompetitions(ListDataModel<Competition> competitions) {
        this.competitions = competitions;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public CompetitionManager getCompetitionManager() {
        return competitionManager;
    }

    public void setCompetitionManager(CompetitionManager competitionManager) {
        this.competitionManager = competitionManager;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
    }
    
    
}
