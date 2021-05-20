package com.sayan.dataloader.camel.routes;

import com.sayan.dataloader.camel.processors.TeamInsetProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamInsertRoute extends RouteBuilder {

    @Autowired
    TeamInsetProcessor teamInsetProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:insertTeams")
                .process(teamInsetProcessor)
                .log("Teams Inserted");
    }
}
