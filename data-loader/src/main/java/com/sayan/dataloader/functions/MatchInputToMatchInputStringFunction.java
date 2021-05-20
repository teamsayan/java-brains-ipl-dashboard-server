package com.sayan.dataloader.functions;

import com.sayan.dataloader.dto.MatchInput;

import java.util.function.Function;

public class MatchInputToMatchInputStringFunction implements Function<MatchInput, String> {
    @Override
    public String apply(MatchInput matchInput) {
        return matchInput.toString();
    }
}
