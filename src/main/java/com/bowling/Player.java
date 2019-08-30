package com.bowling;

import java.util.List;

public class Player implements aboutPlayer {
    private String name;        //  Player name
    private Integer gamescore;  //  Total line score
    private Line line;
    private List<String> blackList;
    private Integer nroThrows;  // Check the number of throws of the player
    private Integer frames;     // Check the number of frames of the player

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


    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    public Integer getNroThrows() {
        return nroThrows;
    }

    public void setNroThrows(Integer nroThrows) {
        this.nroThrows = nroThrows;
    }

    public Integer getFrames() {
        return frames;
    }

    public void setFrames(Integer frames) {
        this.frames = frames;
    }

    @Override
    public String areBadFields(String data) {
        return null;
    }

    @Override
    public String isBadScore(String data) {
        return null;
    }

    @Override
    public Boolean isInBlackList(String data) {
        return null;
    }

    @Override
    public Boolean hasMoreThrows(String data) {
        return null;
    }

}
