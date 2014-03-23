package com.adaptionsoft.games.uglytrivia;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class GameTest {
    
    @Test public void
    havingOddNumber_freshGame_checkReturnsTrue() {
        Game game = new Game();
        assertThat(game.isOddNumber(7), is(true));
    }
    
    @Test public void
    havingEvenNumber_freshGame_checkReturnsFalse() {
        Game game = new Game();
        assertThat(game.isOddNumber(6), is(false));
    }
}
