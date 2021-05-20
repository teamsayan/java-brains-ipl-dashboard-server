package com.sayan.common.repo;

import com.sayan.common.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByTeamName(String teamName);

}
