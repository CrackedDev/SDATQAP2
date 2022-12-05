package com.sdatqap2.qap2.tournament;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TournamentConfig {
    @Bean
    CommandLineRunner commandLineRunner(TournamentRepository repository) {
        return args -> {
            Tournament newYear = new Tournament(1L, "New Years", "Home Town", LocalDate.of(2023, 07, 25), LocalDate.of(2023, 10, 25), 200, 10000);
            Tournament christmas = new Tournament(2L, "Christmas", "Home Town", LocalDate.of(2023, 12, 25), LocalDate.of(2024, 01, 19), 200, 10000);

            repository.saveAll(List.of(newYear, christmas));
        };
    }
}
