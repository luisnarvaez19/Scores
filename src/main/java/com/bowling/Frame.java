package com.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame implements AboutFrame {
    private List<String> rolls;   //  Rolls  in a frame

    public Frame(){
        this.rolls=new ArrayList<>();
    }

    public List<String> getRolls() {
        return rolls;
    }

    public void setRolls(List<String> rolls) {
        this.rolls = rolls;
    }


    /**
     *  Verify if the sum > 10
     * @return true is the sum > 10
     */
    @Override
    public Boolean sumMore10(Frame frame) {
        if ("F".equals(frame.getRolls().get(0))) {
            if ("F".equals(frame.getRolls().get(1))) return false;
            if (Integer.parseInt(frame.getRolls().get(1)) < 10) return false;
        }
        Integer result=frame.getRolls().stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return (result>10);
    }

    /**
     *   Calculate if a frame is a spare
     * @return  true if is a spare
     */
    @Override
    public Boolean isSpare(Frame frame) {

        if ("F".equals(frame.getRolls().get(1)))
            return false;
        if ("F".equals(frame.getRolls().get(0))) {
          if (Integer.parseInt(frame.getRolls().get(1)) == 10)
            return true;
          else return false;
        }
        Integer result=frame.getRolls().stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return (result==10);
    }

    /**
     * Add a frame with one number num
     *
     * @param num
     * @return
     */
    @Override
    public Frame addFrame(String num) {
        this.getRolls().add(num);
        return this;
    }
}
