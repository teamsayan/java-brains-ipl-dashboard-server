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
public class TestInsertProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(TestInsertProcessor.class);

    @Autowired
    IMatchRepository matchRepository;
    @Override
    public void process(Exchange exchange) throws Exception {
        List<Match> matches = exchange.getIn().getBody(List.class);
        logger.info("inside Test Insert");

        Match match = matchRepository.findById(Long.parseLong("335982")).get();

        logger.info("Match fetched from match table: [{}]",match.toString());

        exchange.getMessage().setBody(matches);
    }
}
