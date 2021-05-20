package com.sayan.javabrains.ipldashboard.service;

import com.sayan.common.model.Match;
import com.sayan.common.model.Team;
import com.sayan.common.repo.IMatchRepository;
import com.sayan.common.repo.ITeamRepository;
import com.sayan.javabrains.ipldashboard.dto.TeamDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    ITeamRepository teamRepository;

    @Autowired
    IMatchRepository matchRepository;

    @Autowired
    ModelMapper modelMapper;

    public Optional<TeamDTO> getTeamByTeamName(String teamName){
        if(teamName.strip().isEmpty()){
            return Optional.empty();
        }

        Team team =  teamRepository.findByTeamName(teamName).get();
        TeamDTO dto = modelMapper.map(team, TeamDTO.class);

        Pageable pageable = PageRequest.of(0, 4);
        List<Match> matches = matchRepository.findByTeam1OrTeam2OrderByDateDesc(teamName,teamName,pageable);
        dto.setMatches(matches);
        return Optional.of(dto);
    }
}
