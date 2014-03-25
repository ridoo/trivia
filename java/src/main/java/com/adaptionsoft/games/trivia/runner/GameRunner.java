
package com.adaptionsoft.games.trivia.runner;
import com.adaptionsoft.games.trivia.Game;
import com.adaptionsoft.games.trivia.player.Player;


public class GameRunner {

	public static void main(String[] args) {
		Game aGame = new Game();
		Player currentPlayer = null;
		
		aGame.addNewPlayer("Chet");
		aGame.addNewPlayer("Pat");
		aGame.addNewPlayer("Sue");
		
		do {
			currentPlayer = aGame.performNextTurn(currentPlayer);
		} while ( !currentPlayer.isWinner());
		System.out.println(currentPlayer + " wins the game!");
	}

}
