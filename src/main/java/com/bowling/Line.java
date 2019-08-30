package com.bowling;

import java.util.List;

public class Line {
    private List<Frame> line;   //  Represents the complete player line

    /**
     * Calculate the frame sum
     * @param  n:   Is the frame n
     * @return  frame sum
     */
    public Integer calcFrame(Integer n) {
        return null;
    }

    /**
     *
     * @return  null if the line is good else the reason why is wrong
     */
    public String isBadLine() {
        return null;
    }

    public List<Frame> getLine() {
        return line;
    }

    public void setLine(List<Frame> line) {
        this.line = line;
    }


}
