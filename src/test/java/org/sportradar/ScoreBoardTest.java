package org.sportradar;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ScoreBoardTest {

    @Test
    public void shouldStartGameWithZeroScore() {
        ScoreBoard board = new ScoreBoard();
        board.startGame("Mexico", "Canada");

        List<Game> games = board.getGames();
        assertEquals(1, games.size());
        Game game = games.getFirst();
        assertEquals("Mexico", game.getHomeTeam());
        assertEquals("Canada", game.getAwayTeam());
        assertEquals(0, game.getHomeScore());
        assertEquals(0, game.getAwayScore());
    }

    @Test
    public void shouldUpdateGameScore() {
        ScoreBoard board = new ScoreBoard();
        board.startGame("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);

        Game game = board.getGames().getFirst();
        assertEquals(10, game.getHomeScore());
        assertEquals(2, game.getAwayScore());
    }

    @Test
    public void shouldRemoveGameWhenFinished() {
        ScoreBoard board = new ScoreBoard();
        board.startGame("Germany", "France");
        board.finishGame("Germany", "France");

        assertTrue(board.getGames().isEmpty());
    }

    @Test
    public void shouldReturnGamesSortedByTotalScoreAndRecency() {
        ScoreBoard board = getScoreBoardFromExercise();

        List<Game> summary = board.getSummary();

        assertEquals("Uruguay", summary.get(0).getHomeTeam());
        assertEquals("Spain", summary.get(1).getHomeTeam());
        assertEquals("Mexico", summary.get(2).getHomeTeam());
        assertEquals("Argentina", summary.get(3).getHomeTeam());
        assertEquals("Germany", summary.get(4).getHomeTeam());
    }

    private static ScoreBoard getScoreBoardFromExercise() {
        ScoreBoard board = new ScoreBoard();
        board.startGame("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);

        board.startGame("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);

        board.startGame("Germany", "France");
        board.updateScore("Germany", "France", 2, 2);

        board.startGame("Uruguay", "Italy");
        board.updateScore("Uruguay", "Italy", 6, 6);

        board.startGame("Argentina", "Australia");
        board.updateScore("Argentina", "Australia", 3, 1);
        return board;
    }


}