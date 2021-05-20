package com.sayan.javabrains.ipldashboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sayan.common.model.Match;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamDTO {

    @NotNull
    private long teamId;

    @NotNull
    private String teamName;
    private long totalMatches;
    private long totalWins;
    private List<Match> matches;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    public TeamDTO(String name, long numberOfMatch){
        this.teamName=name;
        this.totalMatches=numberOfMatch;
    }
}
