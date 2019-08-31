package com.bowling;

import java.util.List;

public interface AboutPlayer {


    /**
     * Verify if the second field is Negative
     * Verify if the second field is > 10
     * @param data
     * @return null if the field is good else the reason why is wrong
     */
    public String isBadScore(String data);


    /**
     * Verify if he Player is in the BlackList for no read more his registers
     * @param data
     * @return true if he is in BlackList
     */
    public Boolean isInBlackList(String data);

    /**
     *
     * @param data
     * @return
     */
    public Boolean hasMoreThrows(String data);


    /**
     * Verify if the player exist
     * @param game
     * @param data
     * @return null if not exist the player
     */
    public Player existPlayer( List<Player> game, String data);

    /**
     *
     * @param data
     * @return Player
     */
    public Player addPlayer(String data);

    /**
     *   Remove a player if his data is bad
     * @param player
     * @return  true if remove was right
     */
    public Boolean removePlayer(Player player);



}
