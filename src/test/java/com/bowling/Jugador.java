package com.bowling;

import java.util.List;

public class Jugador {
    private String name;        //  Player name
    private Integer gamescore;  //  Total line score
    private List<Frame> line;   //  Represents the complete player line

    /**
     * Calculate the frame sum
     * @param  n:   Is the frame n
     * @return  frame sum
     */
    private Integer calcFrame(Integer n) {

    }

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

    public List<Frame> getLine() {
        return line;
    }

    public void setLine(List<Frame> line) {
        this.line = line;
    }
}
