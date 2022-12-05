package com.sdatqap2.qap2.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tournament")
public class TournamentController {
    private final TournamentService tournamentService;
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentController(TournamentService tournamentService,
                                TournamentRepository tournamentRepository) {
        this.tournamentService = tournamentService;
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping
    public List<Tournament> getTournaments(){
        return tournamentService.getTournaments();
    }

    @PostMapping()
    public void registerNewTournament(@RequestBody Tournament tournament){
        tournamentService.addNewTournament(tournament);
    }
    @PatchMapping(path = "{tournamentId}")
    public void updateTournament(@PathVariable("tournamentId") Long tournamentId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) LocalDate startDate,
                                 @RequestParam(required = false) LocalDate endDate,
                                 @RequestParam(required = false) String location,
                                 @RequestParam(required = false) Double entryFee,
                                 @RequestParam(required = false) Double cashPrize){
        tournamentService.updateTournament(tournamentId, name, startDate, endDate, location, entryFee , cashPrize);
    }
    }




