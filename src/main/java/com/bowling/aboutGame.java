package com.bowling;

public interface aboutGame {
    public Boolean existPlayer(String data);
    public Player addPlayer(String data);
    public Boolean removePlayer(Player player);
    public void scoreGame();

}
