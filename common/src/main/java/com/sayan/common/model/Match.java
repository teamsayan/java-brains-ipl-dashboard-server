package com.sayan.common.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "match")
public class Match {

    @Id
    @Column(name = "match_id")
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name="match_date")
    private LocalDate date;

    @Column(name = "player_of_match")
    private String playerOfMatch;

    @Column(name = "venue")
    private String venue;

    @Column(name = "batting_team")
    private String team1;

    @Column(name = "fielding_team")
    private String team2;

    @Column(name = "toss_winner")
    private String tossWinner;

    @Column(name = "toss_decision")
    private String tossDecision;

    @Column(name = "match_winner")
    private String winner;

    @Column(name = "match_result")
    private String result;

    @Column(name = "result_margin")
    private String resultMargin;

    @Column(name = "is_eliminator")
    private String eliminator;

    @Column(name = "method")
    private String method;

    @Column(name = "umpire_one")
    private String umpire1;

    @Column(name = "umpire_two")
    private String umpire2;
}
