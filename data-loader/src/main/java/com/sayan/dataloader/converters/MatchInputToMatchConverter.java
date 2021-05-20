package com.sayan.dataloader.converters;

import com.sayan.common.model.Match;
import com.sayan.dataloader.dto.MatchInput;
import com.sayan.dataloader.functions.MatchInputToMatchFunction;
import com.sayan.dataloader.functions.MatchToMatchInputFunction;
import org.springframework.stereotype.Component;

@Component
public class MatchInputToMatchConverter extends Converter<MatchInput, Match>{
    public MatchInputToMatchConverter() {
        super(MatchInputToMatchConverter::convertToMatch, MatchInputToMatchConverter::convertToMatchInput);
    }

    private static Match convertToMatch(MatchInput dto){
        Match match = new MatchInputToMatchFunction().apply(dto);
        return match;
    }

    private static MatchInput convertToMatchInput(Match match){
        MatchInput matchInput = new MatchToMatchInputFunction().apply(match);
        return matchInput;
    }
}
