package com.bowling;

import java.util.List;

  interface AboutPlayer {


    /**
     * Verify if the player exist
     * @param game
     * @param data
     * @return null if not exist the player
     */
     Player existPlayer( List<Player> game, String data);

    /**
     *
     * @param data
     * @return Player
     */
     Player addPlayer(String data);

    /**
     *  Remove a player due to errors
     * @param game;  game that is running
     * @param name: player's name  will be removed
     *
     */
     void removePlayer(Game game,String name);



}
