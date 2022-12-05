package com.sdatqap2.qap2.tournament;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository){
        this.tournamentRepository = tournamentRepository;
    }
    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }
    public void addNewTournament(Tournament tournament){
        Optional<Tournament> tournamentByName = tournamentRepository.findTournamentByName(tournament.getName());
        if (tournamentByName.isPresent()) {
            throw new IllegalArgumentException("Tournament Name already exists");}
            tournamentRepository.save(tournament);
        }
    @Transactional
    public void updateTournament(Long id,
                                 String name,
                                 LocalDate startDate,
                                 LocalDate endDate,
                                 String location,
                                 Double entryFee,
                                 Double prize) {
        // checks to see if the id exist that is being updated
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tournament with id " + id + " does not exist"));
        // Tournament names should be unique and this checks for that
        if(name != null && name.length() > 0 && !Objects.equals(tournament.getName(), name)){
            Optional<Tournament> tournamentOptional = tournamentRepository.findTournamentByName(name);
            if(tournamentOptional.isPresent()){
                throw new IllegalArgumentException("Name Taken");
            }
            tournament.setName(name);
        }
        if(startDate != null && !startDate.equals(tournament.getStartDate()) ){
            tournament.setStartDate(startDate);
        }
        if(endDate != null && !endDate.equals(tournament.getEndDate())){
            tournament.setEndDate(endDate);
        }
        if(location != null && location.length() > 0 && Objects.equals(tournament.getLocation(), location)){
            tournament.setLocation(location);
        }
        if(entryFee != null && entryFee >=0 && Objects.equals(tournament.getEntryFee(), entryFee)){
            tournament.setEntryFee(entryFee);
        }
        if(prize != null && prize >=0 && Objects.equals(tournament.getPrize(), prize)){
            tournament.setPrize(prize);
        }

        }
        }



