package com.adaptionsoft.games.uglytrivia;

public enum Category {
    
    POP,
    SCIENCE,
    SPORTS,
    ROCK;
    
    private int[] places = {};
    
    private Category(int... places) {
        if (places == null || places.length == 0) {
            throw new RuntimeException("Category has to be assigned to place(s).");
        }
        this.places = places;
    }
    
}
