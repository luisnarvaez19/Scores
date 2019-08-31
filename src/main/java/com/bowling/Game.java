package com.bowling;


import java.util.ArrayList;
import java.util.List;

/**
 *   Represents a game with several players
 */
public class Game implements AboutGame {
    private List<Player> game;

    private List<String> blackList;

    public Game(){
        this.game=new ArrayList<>();
        this.blackList=new ArrayList<>();
        currentPlayer=" ";
    }

    private  String currentPlayer;    // Verify if the player made two throws

    public List<Player> getGame() {
        return game;
    }

    public void setGame(List<Player> game) {
        this.game = game;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     *  Process the lines of the game
     *  @param line:  The line
     */
    public void processData(String line){

        System.out.println("La linea es: "+line);
        String[] splitted = line.split("\t");
        //System.out.println("RL: "+linea+" tam: "+splitted.length+" name: "+splitted[0]);

        //  areBadFields is null there is not bad fields
        //  existBlackList is null the player was not removed previously
        String message=areBadFields(line);
        String name = splitted[0];
        if ((message==null) && (!(existBlackList(name)))){
            String athrow=addThrow(splitted[0],splitted[1]);
            if (athrow!=null)
                System.out.println(athrow);
        } else {
            if (message!=null) {
                System.out.println(message);
                this.blackList.add(name);
            } else
                System.out.println("The player:  "+name+" have bad records.  It was deleted.");
        }

    }


    /**
     * Print the score game for the players
     */
    @Override
    public void scoreGame() {
        System.out.println("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t\t\t7\t\t8\t\t9\t\t10");
        game.stream()
                .forEach(x->x.getLine().printMe(x));

    }

    /**
     * Check if the player has already been ruled out due to a previous error
     *
     * @param data
     * @return
     */
    @Override
    public Boolean existBlackList(String data) {
        String blackList=this.blackList.stream()
                .filter(x -> x.equals(data))
                .findAny()
                .orElse(null);
        return (blackList!=null);
    }



    /**
     * Verify data line has only two fields
     * Verify data line first field is String, second field is a integer or a F
     *
     * @param linea data player's line
     * @return null if the fields are good else the reason why is wrong
     */
    @Override
    public String areBadFields(String linea) {
        String[] splitted = linea.split("\t");

        if (splitted.length!=2)
            return("Error in the line: "+linea+". Error with the player: "+splitted[0]+", the data is not good, must be two fields ");
        else {
            String value2=splitted[1];
            Integer num=isNumeric(value2);
            if (num!=null) {
              if (num>10)  return("Error in the line:  "+linea+". Error in the number of pines. It cannot be greater than 10");
            } else {
                if (!("F".equals(value2)))
                    return("Error in the line:  "+linea+". Only the character F is accepted. No other character");
            }
        }
        return null;
    }

    /**
     *
     * @param name:  Name of the player
     * @param val
     * @return  null if add a throw good
     */
    @Override
    public String addThrow(String name, String val) {
        Player p=new Player();
        Player player=p.existPlayer(this.game,name);
        System.out.println("Current is: "+currentPlayer);
        if (!(this.currentPlayer.equals(name))) {
             if (player==null) {
                 //  The player is created
                 player=p.addPlayer(name);
                 this.game.add(player);
             }
             player.getLine().addFrame();
             this.currentPlayer=name;
        }
        String message= player.getLine().addScore(player,val);
        if (message!=null) {
            System.out.println(message);
            this.blackList.add(player.getName());
        }
        return null;

    }

    /**
     *    Check if a String is a number
     * @param strNum:  The String to verify
     * @return the number else null
     */
    public static Integer isNumeric(String strNum) {
        Integer d = null;
        try {
            d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
        return d;
    }


}
