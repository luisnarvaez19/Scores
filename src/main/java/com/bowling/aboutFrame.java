package com.bowling;

public interface aboutFrame {
    /**
     *  Verify if the sum > 10
     * @return true is the sum > 10
     */
    public Boolean sumMore10(Frame frame);

    /**
     *   Calculate if a frame is a spare
     * @return  true if is a spare
     */
    public Boolean isSpare(Frame frame);

}
