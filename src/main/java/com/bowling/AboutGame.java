package com.bowling;

  interface AboutGame {

    /**
     *    Print the score game for the players
     */
      void scoreGame();

    /**
     * Check if the player has already been ruled out due to a previous error
     * @param data
     * @return
     */
      Boolean existBlackList(String data);


    /**
     * Verify data line has only two fields
     * Verify data line first field is String, second field is a integer or a F
     *
     * @param data data player's line
     * @return null if the fields are good else the reason why is wrong
     */
      String areBadFields( String linea);

    /**
     *
     * @param name:  Name of the player
     * @param val
     * @return  null if add a throw good
     */
      String addThrow(String name, String val);


}
