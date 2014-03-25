
package com.adaptionsoft.games.trivia;

import static com.adaptionsoft.games.trivia.player.Player.player;

import java.util.LinkedList;

import com.adaptionsoft.games.trivia.board.Board;
import com.adaptionsoft.games.trivia.board.Field;
import com.adaptionsoft.games.trivia.board.Question;
import com.adaptionsoft.games.trivia.player.Player;

public class Game {

    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private StatusPrinter printer = new StatusPrinter();

    private Board board = new Board();

    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();

    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add("Science Question " + i);
            sportsQuestions.add("Sports Question " + i);
            rockQuestions.add("Rock Question " + i);
        }
    }

    public boolean isPlayable() {
        return board.getNumberOfPlayers() >= MINIMUM_NUMBER_OF_PLAYERS;
    }

    public void addNewPlayer(String playerName) {
        Player player = player(playerName);

        board.add(player);
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + board.getNumberOfPlayers());
    }

    public Player performNextTurn(Player player) {

        Player currentPlayer = board.getPlayerNextTo(player);
        int roll = currentPlayer.roll();

        printer.printNextPlayer(currentPlayer);
        printer.printCurrentThrow(roll);

        if ( !currentPlayer.isInPenaltyBox()) {
            board.move(currentPlayer, roll);
            if (askQuestionTo(currentPlayer)) {
                printer.printAnswerCorrect();
                currentPlayer.addCredit();
                printer.printCurrentCreditOf(currentPlayer);
            } else {
                printer.printAnswerNotCorrect();
                printer.playerMovesToPenaltyBox(currentPlayer);
                currentPlayer.goToPenaltyBox();
            }
        } else  {
            if (isEvenNumber(roll)) {
                printer.playerStaysInPenaltyBox(currentPlayer);
            }
            else {
                printer.playerLeavesPenaltyBox(currentPlayer);

                board.move(currentPlayer, roll);
                if (askQuestionTo(currentPlayer)) {
                    printer.playerLeavesPenaltyBox(currentPlayer);
                    currentPlayer.leavePenaltyBox();
                    printer.printAnswerCorrect();
                    currentPlayer.addCredit();
                    printer.printCurrentCreditOf(currentPlayer);
                } else {
                    printer.printAnswerNotCorrect();
                    printer.playerMovesToPenaltyBox(currentPlayer);
                    currentPlayer.goToPenaltyBox();
                }
            }
        }
        
        return currentPlayer;

    }

    boolean isEvenNumber(int roll) {
        return roll % 2 == 0;
    }

    public boolean askQuestionTo(Player player) {
        Field currentField = player.getCurrentField();
        Question aQuestion = currentField.getAQuestion();
        printer.printAskQuestion(player, aQuestion);
        return player.isGivingWrongAnswerTo(aQuestion);
    }

    private static class StatusPrinter {
        void printCurrentCreditOf(Player player) {
            System.out.println(player.getCredit());
        }

        public void printCurrentThrow(int roll) {
            System.out.println("They have rolled a " + roll);
        }

        public void printNextPlayer(Player player) {
            System.out.println(player + " is the current player.");
        }

        public void playerMovesToPenaltyBox(Player playerOnTurn) {
            System.out.println(playerOnTurn + " was sent to the penalty box.");
        }

        public void playerLeavesPenaltyBox(Player playerOnTurn) {
            System.out.println(playerOnTurn + " is getting out of the penalty box.");
        }

        public void playerStaysInPenaltyBox(Player playerOnTurn) {
            System.out.println(playerOnTurn + " is not getting out of the penalty box.");
        }

        public void printAskQuestion(Player player, Question aQuestion) {
            System.out.println("Ask " + player + " " + aQuestion);
            
        }

        void printAnswerCorrect() {
            System.out.println("Answer was corrent!!!!");
        }

        void printAnswerNotCorrect() {
            System.out.println("Question was incorrectly answered");
        }
    }
}
