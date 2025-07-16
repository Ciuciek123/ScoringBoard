package org.sportradar;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a scoreboard that manages games between teams.
 * It allows starting, finishing, updating scores, and getting a summary of games.
 */

@Getter
public class ScoreBoard {

    private final List<Game> games = new ArrayList<>();

    public void startGame(String homeTeam, String awayTeam) {
        Game newGame = new Game(homeTeam, awayTeam);
        if (games.stream().anyMatch(game -> game.getHomeTeam().equals(homeTeam) || game.getAwayTeam().equals(awayTeam))) {
            // It is possible to not find anything if homeTeam will be set as awayTeam and vice versa,
            // but we can assume that user is not going to do that.
            throw new IllegalArgumentException("A game with one of the teams already exists.");
        }
        games.add(newGame);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Game game = games.stream()
                .filter(g -> g.getHomeTeam().equals(homeTeam) && g.getAwayTeam().equals(awayTeam))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No game found with the specified teams."));

        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        if (!games.removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))) {
            throw new IllegalArgumentException("No game found with the specified teams.");
        }
    }

    public List<Game> getSummary() {
        return games.stream()
                .sorted((g1, g2) -> {
                    int scoreComparison = Integer.compare(
                            g2.getHomeScore() + g2.getAwayScore(),
                            g1.getHomeScore() + g1.getAwayScore()
                    );
                    if (scoreComparison != 0) {
                        return scoreComparison;
                    }
                    return Long.compare(g2.getCreated(), g1.getCreated()); // The more recent game comes first
                })
                .toList();
    }
}
