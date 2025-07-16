package org.sportradar;

import lombok.Getter;

import java.util.Date;

/**
 * Represents a game between two teams.
 * It captures the home team, away team, their scores, and the creation date of the game.
 */

@Getter
public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final Date created;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.created = new Date();
    }
}
