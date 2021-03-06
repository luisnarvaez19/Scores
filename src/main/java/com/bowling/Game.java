package com.bowling;


import java.util.ArrayList;
import java.util.List;

/**
 *   Represents a game with several players
 */
public class Game implements AboutGame {
    private List<Player> game;

    private List<String> blackList;

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

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

        String[] splitted = line.split("\t");
        //System.out.println("RL: "+linea+" tam: "+splitted.length+" name: "+splitted[0]);
        Player p=new Player();
        //  areBadFields is null there is not bad fields
        //  existBlackList is null the player was not removed previously
        String message=areBadFields(line);
        String name = splitted[0];
        if ((message==null) && (!(existBlackList(name)))){
            String athrow=addThrow(splitted[0],splitted[1]);
            if (athrow!=null) {
                System.out.println(athrow);
                p.removePlayer(this,name);
            }

        } else {
            if (message!=null) {
                System.out.println(message);
            } else {
                System.out.println("The player:  "+name+" have bad records.  It was deleted.");
            }
            p.removePlayer(this,name);
        }

    }


    /**
     * Print the score game for the players
     */
    @Override
    public void scoreGame() {
        System.out.println("\n\nFrame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        game.stream()
                .forEach(player->player.getLine().printMe(player));
    }

    /**
     * Check if the player has already been ruled out due to a previous error
     *
     * @param exist
     * @return
     */
    @Override
    public Boolean existBlackList(String exist) {
        String result=blackList.stream()
                .filter(name -> name.equals(exist))
                .findAny()
                .orElse(null);
        return (result!=null);
    }



    /**
     * Verify data line has only two fields
     * Verify data line first field is String, second field is a integer or a F
     *
     * @param line data player's line
     * @return null if the fields are good else the reason why is wrong
     */
    @Override
    public String areBadFields(String line) {
        String[] splitted = line.split("\t");

        if (splitted.length!=2)
            return("Error in the line: "+line+". Error with the player: "+splitted[0]+", the data is not good, must be two fields or the rows are not tab-separated ");
        else {
            String value2=splitted[1];
            Integer num=isNumeric(value2);
            if (num!=null) {
              if (num>10)  return("Error in the line:  "+line+". Error in the number of pines. It cannot be greater than 10");
              if (num<0)  return("Error in the line:  "+line+". Error in the number of pines. It cannot be negative");
            } else {
                if (!("F".equals(value2)))
                    return("Error in the line:  "+line+". Only the character F is accepted. No other character");
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
        Integer frames=player.getLine().getFrames().size();
        if (frames>10) {
            this.currentPlayer="";
            return ("The player: "+player.getName()+" made more than 10 frames");
        }
        Integer pos=player.getNroThrows();
        if ((pos==2) && (frames!=10)) this.currentPlayer="";
        if (message!=null) {
            System.out.println(message);
            p.removePlayer(this,name);
        }
        return null;

    }

    /**
     *    Check if a String is a number
     * @param strNum:  The String to verify
     * @return the number else null
     */
    public static Integer isNumeric(String strNum) {
        if (strNum.equals("F")) return(0);
        Integer d;
        try {
            d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
        return d;
    }


}
