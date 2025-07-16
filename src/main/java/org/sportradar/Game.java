package org.sportradar;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Represents a game between two teams.
 * It captures the home team, away team, their scores, and the creation date of the game.
 */

@Getter
@Setter
public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final long created;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.created = System.nanoTime();
        // Using System.nanoTime() for high precision timestamp so it will be easier to compare recency
    }
}
