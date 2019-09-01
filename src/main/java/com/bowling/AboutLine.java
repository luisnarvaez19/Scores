package com.bowling;

  interface AboutLine {
    /**
     * Add a frame to the line
     */
      void addFrame();

    /**
     * Add a score to the last frame in a line
     * @param player:   The player
     * @param value  Value to add
     * @return  null if add good else the message
     */
      String addScore(Player player, String value);


    /**
     * Print the line of the player
     * @param player:  The player
     */
      void printMe(Player player);


    /**
     * Calculate the score and print it
     * @param player:  The player
     */
      void printScore(Player player);
}
