package com.sayan.dataloader.camel.routes;

import com.sayan.dataloader.camel.processors.MatchInserterProcessor;
import com.sayan.dataloader.camel.processors.TestInsertProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchInsertRoute extends RouteBuilder {

    @Autowired
    MatchInserterProcessor matchInserterProcessor;

    @Autowired
    TestInsertProcessor testInsertProcessor;
    @Override
    public void configure() throws Exception {
        from("direct:matchDataInserter")
                .log("Getting data from matchDataInserter")
                .process(matchInserterProcessor)
                .log("Completed Inserting Data")
        .to("direct:testRepo");

        from("direct:testRepo").process(testInsertProcessor).log("Tested").to("direct:insertTeams");
    }
}
