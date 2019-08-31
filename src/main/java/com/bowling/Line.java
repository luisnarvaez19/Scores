package com.bowling;

import java.util.ArrayList;
import java.util.List;

public class Line implements AboutLine {
    private List<Frame> frames;   //  Represents the complete player line
    private Integer[] score;


    public Line(){
        this.frames=new ArrayList<>();
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
//        frame.getRolls().add(" ");
//        frame.getRolls().add(" ");
//        if (this.getFrames().size()==9)
//            frame.getRolls().add(" ");
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
        System.out.println("El nroTrows is: "+pos);
        Integer frames=this.getFrames().size();
        Frame frame=this.getFrames().get(frames-1);
        Integer num=Game.isNumeric(value);
        if ((pos==0) && (num!=null) && (num==10) && (frames!=10)) {
            frame.getRolls().add(" ");
            frame.getRolls().add("X");
            return null;
        } else {
            if ((pos==0) && (num!=null) && (num==10) && (frames==10)) {
                frame.getRolls().add("X");
                return null;
            }
            frame.getRolls().add(value);
            System.out.println("Add the value: "+value);
        }
        if (pos>0) {
            if ((frames != 10) && (frame.sumMore10(frame)) )
                return ("Error adding score the frame's sum is greater 10");
            if ((frames != 10) && (frame.isSpare(frame)) ) {
                frame.getRolls().remove(frame.getRolls().size()-1);
                frame.getRolls().add("/");
            }
            if (frames!=10) {
                return null;
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
                //.forEach(x->System.out.print(x.getRolls().size()+"\t"));
        System.out.println(" ");
    }

    /**
     * Calculate the score and print it
     *
     * @param player :  The player
     */
    @Override
    public void printScore(Player player) {

    }


}
