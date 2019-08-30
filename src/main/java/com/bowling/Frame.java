package com.bowling;

import java.util.List;

public class Frame implements aboutFrame {
    private List<String> rolls;   //  Rolls  in a frame


    public List<String> getRolls() {
        return rolls;
    }

    public void setRolls(List<String> rolls) {
        this.rolls = rolls;
    }


    @Override
    public Boolean sumMore10(Frame frame) {
        return null;
    }

    @Override
    public Boolean isSpare(Frame frame) {
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
}
