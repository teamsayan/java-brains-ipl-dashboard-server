package com.sayan.dataloader.camel.routes;

import com.sayan.dataloader.camel.processors.MatchDataReaderProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvReaderRoute extends RouteBuilder {

    @Autowired
    private MatchDataReaderProcessor matchDataReaderProcessor;

    @Override
    public void configure() throws Exception {
        from("timer://loadMatchData?repeatCount=1")
                .setBody()
                .simple("resource:classpath:match-data.csv")
                .log("Reading Data")
                .process(matchDataReaderProcessor)
                .to("direct:matchDataInserter");
    }
}
