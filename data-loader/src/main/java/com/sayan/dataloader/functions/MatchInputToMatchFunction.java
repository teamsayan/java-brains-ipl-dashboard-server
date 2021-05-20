package com.sayan.dataloader.functions;

import com.sayan.common.model.Match;
import com.sayan.dataloader.dto.MatchInput;

import java.time.LocalDate;
import java.util.function.Function;

public class MatchInputToMatchFunction implements Function<MatchInput, Match> {
    @Override
    public Match apply(MatchInput input) {
        Match match = new Match();
        match.setId(Long.parseLong(input.getId()));
        match.setCity(input.getCity());
        match.setDate(LocalDate.parse(input.getDate()));
        match.setPlayerOfMatch(input.getPlayerOfMatch());
        match.setVenue(input.getVenue());
        if("bat".equalsIgnoreCase(input.getTossDecision())){
            match.setTeam1(input.getTossWinner());
            match.setTeam2(input.getTossWinner().equalsIgnoreCase(input.getTeam1())?input.getTeam2():input.getTeam1());
        } else {
            match.setTeam1(input.getTossWinner().equalsIgnoreCase(input.getTeam1())?input.getTeam2():input.getTeam1());
            match.setTeam2(input.getTossWinner());
        }
        match.setTossWinner(input.getTossWinner());
        match.setTossDecision(input.getTossDecision());
        match.setWinner(input.getWinner());
        match.setResult(input.getResult());
        match.setResultMargin(input.getResultMargin());
        match.setEliminator(input.getEliminator());
        match.setMethod(input.getMethod());
        match.setUmpire1(input.getUmpire1());
        match.setUmpire2(input.getUmpire2());

        return match;
    }
}
