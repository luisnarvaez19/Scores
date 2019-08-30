package com.bowling;

import java.util.List;

public class Frame {
    private List<String> rolls;   //  Rolls  in a frame


    public List<String> getRolls() {
        return rolls;
    }

    public void setRolls(List<String> rolls) {
        this.rolls = rolls;
    }

    /**
     *   Calculate if a frame is a spare
     * @return  true if is a spare
     */
    public Boolean isSpare(){
        String res=rolls.stream()
                .filter(x -> "F".equals(x))
                .findAny()
                .orElse(null);
        if (res==null)
            return false;
        else {
            if ("F".equals(rolls.get(2)))
                return false;
            else if (Integer.parseInt(rolls.get(2)) == 10)
                return true;
        }
        Integer result=rolls.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return (result==10);
    }

    /**
     *  Calculate if the frame is bad like:  negatives numbers, characters not allowed,
     *                                       sum more than 10
     * @return null is the frame is good else the reason why is wrong
     */
    public String isBadFrame(){
        return null;
    }


}
