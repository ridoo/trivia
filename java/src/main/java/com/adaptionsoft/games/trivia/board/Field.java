package com.adaptionsoft.games.trivia.board;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.adaptionsoft.games.trivia.player.Player;

public class Field {
    
    private static final int NUMBER_OF_QUESTIONS = 50;

    private int index;
    
    private Category category;
    
    private Set<Player> players = new HashSet<Player>();
    
    private Stack<Question> questions = new Stack<Question>();
    
    public Field(int index, Category category) {
        this.index = index;
        this.category = category;
        putFieldQuestions(category);
    }
    
    private void putFieldQuestions(Category category) {
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            questions.push(new Question(category));
        }
    }

    public void put(Player player) {
        printLocationOf(player);
        player.setCurrentField(this);
        players.add(player);
    }
    
    public void remove(Player player) {
        players.remove(player);
    }

    private void printLocationOf(Player player) {
        StringBuilder sb = new StringBuilder(player.toString());
        sb.append("'s new location is ").append(index);
        System.out.println(sb.append(".").toString());
    }
    
    public int getIndex() {
        return index;
    }
    
    public Question getAQuestion() {
        if (questions.isEmpty()) {
            putFieldQuestions(category);
        }
        return questions.pop();
    }

}
