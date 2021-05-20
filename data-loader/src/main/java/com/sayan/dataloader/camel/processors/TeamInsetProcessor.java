package com.sayan.dataloader.camel.processors;

import com.sayan.common.model.Match;
import com.sayan.common.model.Team;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TeamInsetProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(TeamInsetProcessor.class);

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void process(Exchange exchange) throws Exception {
        List<Match> matches = exchange.getIn().getBody(List.class);
        Map<String, Team> teams = new HashMap<>();

        entityManager.createQuery("select m.team1, count(m) from Match m group by m.team1",Object[].class).getResultList()
                .stream()
                .map(e -> new Team((String)e[0],(long)e[1]))
                .forEach(t-> teams.put(t.getTeamName(), t));

        entityManager.createQuery("select m.team2, count(m) from Match m group by m.team2",Object[].class).getResultList()
                .stream()
                .forEach(e -> {
                    Team team = teams.get((String) e[0]);
                    team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
                });

        entityManager.createQuery("select m.winner, count(m) from Match m group by m.winner",Object[].class).getResultList()
                .stream()
                .forEach(e -> {
                    Team team = teams.get((String) e[0]);
                    if(team !=null) team.setTotalWins((long)e[1]);
                });

        teams.values().forEach(team -> entityManager.persist(team));

    }
}
