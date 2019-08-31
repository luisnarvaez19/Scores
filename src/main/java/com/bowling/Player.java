package com.bowling;

import java.util.List;

public class Player implements AboutPlayer {
    private String name;        //  Player name
    private Integer gamescore;  //  Total line score
    private Line line;

    // Check the number of throws of the player. There are two throws in each frame. Except in the 10 frame
    private Integer nroThrows;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getGamescore() {
        return gamescore;
    }

    public void setGamescore(Integer gamescore) {
        this.gamescore = gamescore;
    }


    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }


    public Integer getNroThrows() {
        Integer size=this.line.getFrames().size();
        Frame frame=this.line.getFrames().get(size-1);
        return frame.getRolls().size();
    }

    public void setNroThrows(Integer nroThrows) {
        this.nroThrows = nroThrows;
    }


    /**
     * Verify if the second field is Negative
     * Verify if the second field is > 10
     *
     * @param data
     * @return null if the field is good else the reason why is wrong
     */
    @Override
    public String isBadScore(String data) {
        return null;
    }

    /**
     * Verify if he Player is in the BlackList for no read more his registers
     *
     * @param data
     * @return true if he is in BlackList
     */
    @Override
    public Boolean isInBlackList(String data) {
        return null;
    }

    /**
     * @param data
     * @return
     */
    @Override
    public Boolean hasMoreThrows(String data) {
        return null;
    }

    /**
     * Verify if the player exist
     * @param game
     * @param data
     * @return
     */
    @Override
    public  Player existPlayer( List<Player> game, String data) {
        if (game==null) return null;
        Player player=game.stream()
                .filter(x -> x.getName().equals(data))
                .findAny()
                .orElse(null);
        return (player);
    }

    /**
     * @param name
     * @return Player
     */
    @Override
    public  Player addPlayer(String name) {
        Player player=new Player();
        player.setName(name);
        player.setNroThrows(0);
        Line line=new Line();
        player.line=line;
        return player;
    }

    /**
     * Remove a player if his data is bad
     *
     * @param player
     * @return true if remove was right
     */
    @Override
    public Boolean removePlayer(Player player) {
        return null;
    }

    @Override
    public String toString() {
        String mensaje="The player is: "+this.getName();
        return mensaje;
    }


}
