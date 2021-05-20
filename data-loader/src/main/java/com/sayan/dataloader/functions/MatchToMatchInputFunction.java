package com.sayan.dataloader.functions;

import com.sayan.common.model.Match;
import com.sayan.dataloader.dto.MatchInput;

import java.util.function.Function;

public class MatchToMatchInputFunction implements Function<Match, MatchInput> {
    @Override
    public MatchInput apply(Match match) {
        MatchInput matchInput = new MatchInput();
        matchInput.setId(Long.toString(match.getId()));
        return matchInput;
    }
}
