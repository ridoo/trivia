package com.adaptionsoft.games.trivia.board;

public class Question {

    private Category category;

    public Question(Category category) {
        this.category = category;
    }
    
    public Category getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        return "Question of " + category.toString();
    }

}
