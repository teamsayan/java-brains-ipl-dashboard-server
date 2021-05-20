package com.sayan.dataloader.camel.processors;

import com.sayan.common.model.Match;
import com.sayan.common.repo.IMatchRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchInserterProcessor implements Processor {

    @Autowired
    IMatchRepository matchRepository;

    Logger logger = LoggerFactory.getLogger(MatchInserterProcessor.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        List<Match> matches = exchange.getIn().getBody(List.class);
        matchRepository.saveAll(matches);
        logger.info(matches.toString());
        exchange.getMessage().setBody(matches);
    }
}
