package com.sdatqap2.qap2.tournament;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Tournament {
    @Id
    @SequenceGenerator(name= "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tournament_sequence")

    private Long id;
    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private double entryFee;
    private double prize;

    public Tournament() {
    }

    public Tournament(String name, String location, LocalDate startDate, LocalDate endDate, double entryFee, double prize ){
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.entryFee = entryFee;
        this.prize = prize;
    }

    public Tournament(Long id, String name, String location, LocalDate startDate, LocalDate endDate, double entryFee, double prize) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.entryFee = entryFee;
        this.prize = prize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDate getStartDate(){
        this.startDate = startDate;
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", entryFee=" + entryFee +
                ", prize=" + prize +
                '}';
    }
}
