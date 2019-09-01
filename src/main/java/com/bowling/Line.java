package com.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line implements AboutLine {
    private List<Frame> frames;   //  Represents the complete player line
    private Integer[] score;


    public Line(){
        this.frames=new ArrayList<>();
        this.score= new Integer[10];
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }


    /**
     * Add a frame to the line
     */
    @Override
    public void addFrame() {
        Frame frame= new Frame();
        this.getFrames().add(frame);
    }

    /**
     * Add a score to the last frame in a line
     *
     * @param player   :   The frame can have three positions
     * @param value Value to add
     * @return null if add good else the message
     */
    @Override
    public String addScore(Player player,  String value) {
        Integer pos=player.getNroThrows();
        //  Player's turns.  Max: 10 turns
        Integer frames=this.getFrames().size();
        // The frame or turn of the player
        Frame frame=this.getFrames().get(frames-1);
        Integer num=Game.isNumeric(value);
        // The player made a strike
        if ((pos==0) && (num!=null) && (num==10) && (frames!=10)) {
            frame.getRolls().add(" ");
            frame.getRolls().add("X");
            return null;
        } else {
            // The player made a strike in the last turn
            if ((num!=null) && (num==10) && (frames==10)) {
                frame.getRolls().add("X");
                return null;
            }
            frame.getRolls().add(value);
        }
        // Is the second row in a frame. Check special cases like sumMore10
        if (pos>0) {
            if ((frames != 10) && (frame.sumMore10(frame)) )
                return ("Error adding score to: "+player.getName()+" the frame's sum is greater 10");
            if ((frames != 10) && (frame.isSpare(frame)) ) {
                frame.getRolls().remove(frame.getRolls().size()-1);
                frame.getRolls().add("/");
            }
            pos=player.getNroThrows();
            // Check if number of throws is correct
            if (((frames!=10) && (pos>2)) || ((frames==10) && (pos>3))){
                return ("The player: "+player.getName()+" has a lot of throws for a frame");
            }
        }
        return null;
    }

    /**
     * Print the line of the player
     *
     * @param player :  The player
     */
    @Override
    public void printMe(Player player) {
        System.out.println(player.getName());
        System.out.print("Pinfalls\t");
        this.getFrames().stream()
                .forEach(x->{
                                if (x.getRolls().size()==2)
                                    System.out.print(x.getRolls().get(0)+"\t"+x.getRolls().get(1)+"\t");
                                else
                                    System.out.print(x.getRolls().get(0)+"\t"+x.getRolls().get(1)+"\t"+x.getRolls().get(2)+"\t");
                            });
//                .forEach(x->System.out.print(x.getRolls().size()+"\t"));
        System.out.println(" ");
        printScore(player);
    }

    /**
     * Calculate the score and print it
     *
     * @param player :  The player
     */
    @Override
    public void printScore(Player player) {

        for (int i=0;i < 10; i++){
            Frame frame=this.getFrames().get(i);
            Integer size=frame.getRolls().size();
            if (i==0)
                //score[i]=frame.sumFrame(this,i, 0);
                score[i]=frame.totFrame(this,i,0,0);
            else {
                if (i<9)
                    //score[i]=frame.sumFrame(this,i, score[i-1] );
                    score[i]=frame.totFrame(this,i,score[i-1] ,0);
                else {
                    Integer num0, num1;
                    String value0=getFrames().get(i).getRolls().get(0);
                    String value1=getFrames().get(i).getRolls().get(1);
                    String value2="0";
                    if (value0.equals("X"))
                        value2=getFrames().get(i).getRolls().get(2);
                    if ((value0.equals("X")) && (value1.equals("X")) && (value2.equals("X")))
                        score[i] = 30+score[i-1];
                    else {
                        if (value0.equals("X")) {
                            num0 = Game.isNumeric(value1);
                            num1 = Game.isNumeric(value2);
                            score[i] = 10 + num0  + num1 + score[i-1];
                        } else {
                            num0 = Game.isNumeric(value0);
                            num1 = Game.isNumeric(value1);
                            score[i] = num0  + num1 + score[i-1];
                        }
                    }
                }

            }


//            if (i==0)
//                System.out.println("Score "+i+" es: "+score[i]+" anterior "+0);
//            else
//                System.out.println("Score "+i+" es: "+score[i]+" anterior "+score[i-1]);

        }
        System.out.print("Score\t\t");
        Arrays.stream(this.score)
                .forEach(x->System.out.print(x+"\t\t"));
        System.out.println(" ");
    }


}
