/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.web;

import com.example.domain.Team;
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
public class TeamFormBean implements Serializable {
    
    private Team team = new Team();
    private ListDataModel<Team> teams = new ListDataModel<>();
    
    @Inject
    TeamManager teamManager;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public ListDataModel<Team> getTeams() {
        teams.setWrappedData(teamManager.getAllTeams());
        return teams;
    }

    public void setTeams(ListDataModel<Team> teams) {
        this.teams = teams;
    }
    
    public String addTeam() {
        teamManager.addTeam(team);
        return "show";
    }
    
}
