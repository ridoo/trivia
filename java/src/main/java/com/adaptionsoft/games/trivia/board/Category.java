package com.adaptionsoft.games.trivia.board;

public enum Category {
    
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");
    
    private String categoryName;
    
    private Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
    
    
    
}
