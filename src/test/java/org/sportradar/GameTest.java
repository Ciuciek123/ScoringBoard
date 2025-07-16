package org.sportradar;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {

     @Test
     public void shouldCreateGameWithZeroScores() {
         Game game = new Game("Team A", "Team B");
         assertEquals("Team A", game.getHomeTeam());
         assertEquals("Team B", game.getAwayTeam());
         assertEquals(0, game.getHomeScore());
         assertEquals(0, game.getAwayScore());
     }
}