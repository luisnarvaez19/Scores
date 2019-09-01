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
          return (Integer.parseInt(frame.getRolls().get(1)) == 10);
        }
        Integer result=frame.getRolls().stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return (result==10);
    }

    /**
     *  Calculate one frame in the position i
     *
     * @param line:     Line's values
     * @param i:        Calculate frame for the position i
     * @param previous  The value previous in the score
     * @param times     recursion's time
     * @return
     */
    @Override
    public Integer totFrame(Line line, Integer i, Integer previous,  Integer times) {
        Integer result=0;
        Integer num0,num1;
        Frame frame=line.getFrames().get(i);
        String value0, value1;
        String value=frame.getRolls().get(1);

        //System.out.println("La i  es: "+i+" el valor es: "+value);

        //  Check that the value is a number
        if ((!(value.equals("X"))) && (!(value.equals(" "))) &&  (!(value.equals("/")))) {
            if (times==2) return Game.isNumeric(frame.getRolls().get(0));
            num0=Game.isNumeric(frame.getRolls().get(0));
            num1=Game.isNumeric(frame.getRolls().get(1));
            result = num0+num1;
        } else {
            if (value.equals("/")) {
                if (times==1) return 10;   //  Recursion for X first time
                if (times==2) return Game.isNumeric(frame.getRolls().get(0));
                // It is not the last turn
                if (i!=9) {
                    value=line.getFrames().get(i+1).getRolls().get(0);
                    num0=Game.isNumeric(value);
                    if (num0!=null)
                        result =  num0+10;
                    else
                        result = 20;  //  It is X
                }
            } else {   //  value is X
                if (i<8) {
                    if  (times<2)
                        result += 10 + totFrame(line,i+1,0,times+1);
                    else
                        return result+10;
                } else {
                    if ((i==8) && (times==1)) {   //  Recursion for X first time
                        value0=line.getFrames().get(i+1).getRolls().get(0);
                        if (value0.equals("X")) return 20;
                        else return 10+Game.isNumeric(value0);
                    }
                    if (i==8) {
                        value0=line.getFrames().get(i+1).getRolls().get(0);
                        value1=line.getFrames().get(i+1).getRolls().get(1);
                        if ((value0.equals("X")) && (value1.equals("X")) ) result = 20;
                        else {
                            if (value0.equals("X")) result = 20 + Game.isNumeric(value1);
                            else result += 10+Game.isNumeric(value0)+Game.isNumeric(value1);
                        }
                    }
                }
            }
        }
        if (i==0)
            return result;
        else
            return previous+result;
    }


}
