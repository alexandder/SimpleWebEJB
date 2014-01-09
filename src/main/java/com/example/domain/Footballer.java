package com.example.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "footballer.all", query = "Select f from Footballer f")
})
public class Footballer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2, max = 25)
    private String name;

    @Size(min = 2, max = 25)
    private String lastName;

    private int goalsNumber;

    @ManyToOne
    @JoinColumn(name = "idTeam", nullable = true)
    private Team team;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGoalsNumber() {
        return goalsNumber;
    }

    public void setGoalsNumber(int goalsNumber) {
        this.goalsNumber = goalsNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
