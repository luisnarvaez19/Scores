package com.bowling;

public interface AboutLine {
    /**
     * Add a frame to the line
     */
    public void addFrame();

    /**
     * Add a score to the last frame in a line
     * @param player:   The player
     * @param value  Value to add
     * @return  null if add good else the message
     */
    public String addScore(Player player, String value);


    /**
     * Print the line of the player
     * @param player:  The player
     */
    public void printMe(Player player);


    /**
     * Calculate the score and print it
     * @param player:  The player
     */
    public void printScore(Player player);
}
