package com.bowling;

  interface AboutFrame {
    /**
     *  Verify if the sum > 10
     * @return true is the sum > 10
     */
      Boolean sumMore10(Frame frame);

    /**
     *   Calculate if a frame is a spare
     * @return  true if is a spare
     */
      Boolean isSpare(Frame frame);


    /**
     *  Calculate one frame in the position i
     *
     * @param line:     Line's values
     * @param i:        Calculate frame for the position i
     * @param previous  The value previous in the score
     * @param times     recursion's time
     * @return
     */
      Integer totFrame(Line line,Integer i,  Integer previous,  Integer times);

}
