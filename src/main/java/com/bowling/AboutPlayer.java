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
     *   Remove a player if his data is bad
     * @param player
     * @return  true if remove was right
     */
      Boolean removePlayer(Player player);



}
