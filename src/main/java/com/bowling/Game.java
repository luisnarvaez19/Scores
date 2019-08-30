package com.bowling;

import java.util.List;

/**
 *   Represents a game with several players
 */
public class Game implements aboutGame{
    private List<Player> game;

    private Player currentPlayer;    // Verify if the player made two throws

    public List<Player> getGame() {
        return game;
    }

    public void setGame(List<Player> game) {
        this.game = game;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public static void readLineFile(String linea){
        System.out.println("RL: "+linea);

    }

    @Override
    public Boolean existPlayer(String data) {
        return null;
    }

    @Override
    public Player addPlayer(String data) {
        return null;
    }

    @Override
    public Boolean removePlayer(Player player) {
        return null;
    }

    @Override
    public void scoreGame() {

    }


}
