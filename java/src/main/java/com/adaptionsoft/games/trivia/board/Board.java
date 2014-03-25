package com.adaptionsoft.games.trivia.board;

import static com.adaptionsoft.games.trivia.board.Category.POP;
import static com.adaptionsoft.games.trivia.board.Category.ROCK;
import static com.adaptionsoft.games.trivia.board.Category.SCIENCE;
import static com.adaptionsoft.games.trivia.board.Category.SPORTS;

import java.util.ArrayList;
import java.util.List;

import com.adaptionsoft.games.trivia.player.Player;

public class Board {
    
    private static final int NUMBER_OF_FIELDS = 12;
    
    private static final Field[] fields = new Field[NUMBER_OF_FIELDS];
    
    static {
        for (int i = 0; i < NUMBER_OF_FIELDS ; i++) {
            fields[i] = new Field(i, getCategoryAt(i));
        }
    }

    private static Category getCategoryAt(int index) {
        switch (index) {
        case 0:
        case 4:
        case 8:
            return POP;
        case 1:
        case 5:
        case 9:
            return SCIENCE;
        case 2:
        case 6:
        case 10:
            return SPORTS;
        default:
            return ROCK;
        }
    }

    private List<Player> players = new ArrayList<Player>();
    
    public Board() {
        
    }
    
    public void move(Player player, int numberOfFields) {
        Field currentField = player.getCurrentField();
        Field nextField = getNthNextField(currentField, numberOfFields);
        currentField.remove(player);
        nextField.put(player);
    }

    private Field getNthNextField(Field currentField, int n) {
        int currentFieldIndex = currentField.getIndex();
        int linearIndex = currentFieldIndex + n;
        int cyclicIndex = linearIndex % NUMBER_OF_FIELDS;
        return getField(cyclicIndex);
    }

    public void add(Player player) {
        Field startField = getField(0);
        startField.put(player);
        players.add(player);
    }

    private Field getField(int number) {
        return fields[number];
    }
    
    public Player getPlayerNextTo(Player currentPlayer) {
        int indexOfCurrent = players.indexOf(currentPlayer);
        int indexOfNext = ++indexOfCurrent % getNumberOfPlayers();
        return players.get(indexOfNext);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }
    
}
