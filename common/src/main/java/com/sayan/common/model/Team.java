package com.sayan.common.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "total_matches")
    private long totalMatches;

    @Column(name = "total_wins")
    private long totalWins;

    public Team(String name, long numberOfMatch){
        this.teamName=name;
        this.totalMatches=numberOfMatch;
    }
}
