package org.sportradar;

import lombok.Getter;

import java.util.List;

/**
 * Represents a scoreboard that manages games between teams.
 * It allows starting, finishing, updating scores, and getting a summary of games.
 */

@Getter
public class ScoreBoard {

    private List<Game> games;

    public void startGame(String homeTeam, String awayTeam) {
        //TODO:  Start a game. When a game starts, it should capture (being initial score 0-0)
        // a. Home team
        // b. Away Team
    }

    public void finishGame(String homeTeam, String awayTeam) {
        //TODO: Finish a game. It should remove the game from the scoreboard.
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        //TODO: Update score. Receiving the pair score; home team score and away team score updates a game score
    }

    public List<Game> getSummary() {
        //TODO: Get a summary of games by total score. Those games with the same total score
        // will be returned ordered by the most recently added to our system.
        return List.of();
    }
}
