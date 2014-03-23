package com.adaptionsoft.games.uglytrivia;

public class Purse {
    
    private int coins = 0;
    
    public void addACoin() {
        coins++;
    }
    
    public void add(int coins) {
        this.coins += coins;
    }
    
    public int getCoins() {
        return coins;
    }

}
