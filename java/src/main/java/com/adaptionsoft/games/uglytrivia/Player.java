package com.adaptionsoft.games.uglytrivia;

public class Player {

    private String name = "Unknown!";

    private Purse purse = new Purse();
    
    public Player aPlayer(String name) {
        return new Player(name);
    }
    
    private Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void earnsACoin() {
        purse.addACoin();
    }
    
    public void earnsCoins(int coins) {
        purse.add(coins);
    }

    @Override
    public String toString() {
        return "Player " + name;
    }
    
}
    
