package com.sayan.dataloader.converters;

import com.sayan.dataloader.dto.MatchInput;
import com.sayan.dataloader.functions.MatchInputStringToMatchInputFunction;
import com.sayan.dataloader.functions.MatchInputToMatchInputStringFunction;
import org.springframework.stereotype.Component;

@Component
public class MatchInputStringToMatchInputConverter extends Converter<String, MatchInput>{


    public MatchInputStringToMatchInputConverter() {
        super(MatchInputStringToMatchInputConverter::convertToMatchInput, MatchInputStringToMatchInputConverter::convertToMatchInputString);
    }

    private static MatchInput convertToMatchInput(String matchInputString){
        MatchInput matchInput = new MatchInputStringToMatchInputFunction().apply(matchInputString);
        return matchInput;
    }

    private static String convertToMatchInputString(MatchInput matchInput){
        String matchInputString = new MatchInputToMatchInputStringFunction().apply(matchInput);
        return matchInputString;
    }
}
