package com.sayan.dataloader.camel.processors;

import com.sayan.common.model.Match;
import com.sayan.dataloader.converters.MatchInputStringToMatchInputConverter;
import com.sayan.dataloader.converters.MatchInputToMatchConverter;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MatchDataReaderProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(MatchDataReaderProcessor.class);

    @Autowired
    MatchInputStringToMatchInputConverter matchInputStringToMatchInputConverter;

    @Autowired
    MatchInputToMatchConverter matchInputToMatchConverter;

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Inside MatchDataReaderProcessor");
        String input = exchange.getIn().getBody(String.class);
        List<Match> matches =  Stream.of(StringUtils.split(input,System.lineSeparator()))
                                .skip(1)
                                .map(s->matchInputStringToMatchInputConverter.fromTypeA(s))
                                .map(m->matchInputToMatchConverter.fromTypeA(m))
                                .collect(Collectors.toList());

        logger.info("Conversion completed from File to Match Object");
        exchange.getMessage().setBody(matches);
    }
}
