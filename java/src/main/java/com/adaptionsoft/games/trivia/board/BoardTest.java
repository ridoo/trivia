package com.adaptionsoft.games.trivia.board;

import static com.adaptionsoft.games.trivia.player.Player.player;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.adaptionsoft.games.trivia.board.Board;
import com.adaptionsoft.games.trivia.player.Player;

public class BoardTest {
    
    @Test public void
    newGame_hasNoPlayer() {
        assertThat(new Board().getNumberOfPlayers(), is(0));
    }
    
    @Test public void
    newGame_addingAPlayer_hasOnePlayers() {
        Board board = new Board();
        board.add(player("aPlayer"));
        assertThat(board.getNumberOfPlayers(), is(1));
    }
    
    @Test public void
    newGame_addingAPlayer_isOnStartField() {
        Board board = new Board();
        Player player = player("aPlayer");
        board.add(player);
        assertThat(player.getCurrentField().getIndex(), is(0));
    }
    
    @Test public void
    havingTwoPlayers_getNextPlayer_returnNext() {
        Board board = new Board();
        Player playerA = player("aPlayer");
        board.add(playerA);
        board.add(player("bPlayer"));
        Player playerB = board.getPlayerNextTo(playerA);
        assertThat(playerB.getName(), is("bPlayer"));
    }
}
