package com.sayan.dataloader.functions;

import com.sayan.dataloader.dto.MatchInput;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class MatchInputStringToMatchInputFunction implements Function<String, MatchInput> {
    @Override
    public MatchInput apply(String s) {
        String[] input = StringUtils.splitPreserveAllTokens(s,",");
        MatchInput matchInput = new MatchInput();
        matchInput.setId(input[0]);
        matchInput.setCity(input[1]);
        matchInput.setDate(input[2]);
        matchInput.setPlayerOfMatch(input[3]);
        matchInput.setVenue(input[4]);
        matchInput.setNeutralVenue(input[5]);
        matchInput.setTeam1(input[6]);
        matchInput.setTeam2(input[7]);
        matchInput.setTossWinner(input[8]);
        matchInput.setTossDecision(input[9]);
        matchInput.setWinner(input[10]);
        matchInput.setResult(input[11]);
        matchInput.setResultMargin(input[12]);
        matchInput.setEliminator(input[13]);
        matchInput.setMethod(input[14]);
        matchInput.setUmpire1(input[15]);
        matchInput.setUmpire2(input[16]);

        return matchInput;
    }
}
