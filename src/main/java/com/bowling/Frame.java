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
     * Calculate one frame in the position i
     *
     * @param line  Line's values
     * @param i :  Calculate frame for the position i
     * @param anterior:  Value before i
     * @return value of position i
     */
    @Override
    public Integer sumFrame(Line line, Integer i, Integer anterior) {
        Integer resultado=0;
        Integer num0;
        Integer num1;
        Frame frame=line.getFrames().get(i);
        String value0;
        String value1;
        String value=frame.getRolls().get(1);

        //System.out.println("La i  es: "+i+" el valor es: "+value);

        if (i==9) {
            value0=line.getFrames().get(i).getRolls().get(0);
            value1=line.getFrames().get(i).getRolls().get(1);
            String value2="0";
            if (value0.equals("X"))
                value2=line.getFrames().get(i).getRolls().get(2);
            if ((value0.equals("X")) && (value1.equals("X")) && (value2.equals("X")))
                return 30+anterior;
            else {
                if (value0.equals("X")) {
                    num0 = Game.isNumeric(value1);
                    num1 = Game.isNumeric(value2);
                    return 10 + num0  + num1 + anterior;
                } else {
                    num0 = Game.isNumeric(value0);
                    num1 = Game.isNumeric(value1);
                    return num0  + num1 + anterior;
                }
            }

        }

        if ((!(value.equals("X"))) &&  (!(value.equals("/")))) {
            num0=Game.isNumeric(frame.getRolls().get(0));
            num1=Game.isNumeric(frame.getRolls().get(1));
            resultado = num0+num1;
        } else {
            if (value.equals("/")) {
                if (i!=9) {
                    value=line.getFrames().get(i+1).getRolls().get(0);
                    num0=Game.isNumeric(value);
                    if (num0!=null)
                        resultado =  num0+10;
                    else
                        resultado = 20;  //  Is X
                }
            } else {   //  value is X
                if (i<8) {
                    resultado += calculaX(line,i+1, 1);
                } else {
                    if (i==8) {
                        value0=line.getFrames().get(i+1).getRolls().get(0);
                        value1=line.getFrames().get(i+1).getRolls().get(1);
                        if ((value0.equals("X")) && (value1.equals("X")) )
                            resultado = 20;
                        else {
                            if (value0.equals("X")) {
                                num0 = Game.isNumeric(value1);
                                resultado = 20 + num0  ;
                            }
                        }
                    }
                }
            }
        }
        if (i==0)
            return resultado;
        else
            return anterior+resultado;
    }

    /**
     * Calculate when is strike
     * @param line
     * @param i
     * @return
     */
    private Integer calculaX(Line line, Integer i, Integer times){
        Integer resultado=10;
        String value0="";
        String value=line.getFrames().get(i).getRolls().get(1);
        Integer num0=Game.isNumeric(value);
        if (num0!=null)
            resultado +=  sumFrame(line,i,0);
        else {
            if (value.equals("/"))
                resultado += 10;
            else {  // is X
                if (i+1==9) {
                    value0=line.getFrames().get(i+1).getRolls().get(0);
                    if (value0.equals("X"))
                        resultado += 20 ;
                    else {
                        num0=Game.isNumeric(value0);
                        resultado += 10 + num0;
                    }
                } else {
                    if  (times==1)
                        resultado += calculaX(line, i+1, 2);
                    else
                        return resultado+10;

                }

            }
        }
        return resultado;
    }


}
