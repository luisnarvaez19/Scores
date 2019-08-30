package com.bowling;

import java.util.List;

public class Player {
    private String name;        //  Player name
    private Integer gamescore;  //  Total line score
    private Line line;


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
}
