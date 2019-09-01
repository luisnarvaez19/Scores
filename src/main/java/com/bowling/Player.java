package com.bowling;

import java.util.List;
import java.util.Objects;

public class Player implements AboutPlayer {
    private String name;        //  Player name
    private Line line;

    // Check the number of throws of the player. There are two throws in each frame. Except in the 10 frame
    private Integer nroThrows;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }


    public Integer getNroThrows() {
        Integer size=this.line.getFrames().size();  // Number of frames
        Frame frame=this.line.getFrames().get(size-1);  // The last frame
        return frame.getRolls().size();
    }

    public void setNroThrows(Integer nroThrows) {
        this.nroThrows = nroThrows;
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
     * Remove a player due to errors
     *
     * @param game ;  game that is running
     * @param name : player's name  will be removed
     */
    @Override
    public void removePlayer(Game game, String name) {
        Player player=existPlayer(game.getGame(),name);
        if (player!=null) game.getGame().remove(player);
        if (!(game.existBlackList(name))) game.getBlackList().add(name);
        game.setCurrentPlayer("");
    }

    @Override
    public String toString() {
        String mensaje="The player is: "+this.getName();
        return mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player user = (Player) o;
        return  Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
