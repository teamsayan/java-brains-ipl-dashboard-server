package com.sayan.javabrains.ipldashboard.controller;

import com.sayan.common.model.Team;
import com.sayan.common.repo.ITeamRepository;
import com.sayan.javabrains.ipldashboard.dto.TeamDTO;
import com.sayan.javabrains.ipldashboard.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/team/{teamName}")
    public ResponseEntity<TeamDTO> getTeam(@PathVariable String teamName){
        Optional<TeamDTO> responseTeam = teamService.getTeamByTeamName(teamName);
        if (responseTeam.isPresent()){
            return ResponseEntity.ok().body(responseTeam.get());
        }
        return ResponseEntity.notFound().build();
    }
}
