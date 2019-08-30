package com.bowling;

import java.util.List;

/**
 *   Represents a game with several players
 */
public class Game {
    private List<Player> game;

    public List<Player> getGame() {
        return game;
    }

    public void setGame(List<Player> game) {
        this.game = game;
    }

    public static void readLineFile(String linea){
        System.out.println("RL: "+linea);
    }
}
