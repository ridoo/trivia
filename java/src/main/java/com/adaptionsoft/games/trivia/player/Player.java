package com.adaptionsoft.games.trivia.player;

import java.util.Random;

import com.adaptionsoft.games.trivia.board.Field;
import com.adaptionsoft.games.trivia.board.Question;

public class Player {

    private String name = "Unknown!";
    
    private Field currentField;
    
    private boolean inPenaltyBox = false;

    private Purse purse = new Purse();
    
    private Random rand = new Random();

    public static Player player(String name) {
        return new Player(name);
    }
    
    private Player(String name) {
        this.name = name;
    }
    
    public int roll() {
        return rand.nextInt(5) + 1;
    }
    
    public void setCurrentField(Field field) {
        this.currentField = field;
    }
    
    public Field getCurrentField() {
        return currentField;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }
    
    public void goToPenaltyBox() {
        inPenaltyBox = true;
    }
    
    public void leavePenaltyBox() {
        inPenaltyBox = false;
    }
    
    public void addCredit() {
        purse.addACoin();
    }

    public boolean isGivingWrongAnswerTo(Question aQuestion) {
        return rand.nextInt(9) == 7;
    }

    public boolean isWinner() {
        return purse.getCoins() == 6;
    }

    @Override
    public String toString() {
        return "Player " + name;
    }
    
    public String getCredit() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append(" has now ");
        sb.append(purse.getCoins()).append(" Gold Coins.");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if ( ! (obj instanceof Player)) {
            return false;
        }
        Player other = (Player) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if ( !name.equals(other.name)) {
            return false;
        }
        return true;
    }

    
}
    
