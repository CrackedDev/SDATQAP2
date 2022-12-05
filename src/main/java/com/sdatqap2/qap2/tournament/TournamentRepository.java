package com.sdatqap2.qap2.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository <Tournament, Long> {
    Optional<Tournament> findTournamentByName(String name);
}
