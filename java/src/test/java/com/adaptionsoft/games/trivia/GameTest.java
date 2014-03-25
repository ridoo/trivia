package com.adaptionsoft.games.trivia;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.adaptionsoft.games.trivia.Game;


public class GameTest {
    
    @Test public void
    newGame_addTwoPlayers_isPlayable() {
        Game game = new Game();
        game.addNewPlayer("aPlayer");
        game.addNewPlayer("anotherPlayer");
        assertThat(game.isPlayable(), is(true));
    }
    
    @Test public void
    havingEvenNumber_freshGame_checkReturnsTrue() {
        Game game = new Game();
        assertThat(game.isEvenNumber(6), is(true));
    }
    
    @Test public void
    havingOddNumber_freshGame_checkReturnsFalse() {
        Game game = new Game();
        assertThat(game.isEvenNumber(7), is(false));
    }
}
