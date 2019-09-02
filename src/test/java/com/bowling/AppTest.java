package com.bowling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test for perfect score
     */
    @Test
    public void testPerfectScore()
    {
        List<String> perfectScore= Arrays.asList("10","10","10","10","10","10","10","10","10","10","10","10");
        String name="Carl";
        String message;
        Game game=new Game();
        Player p=new Player();

        Player p1=p.addPlayer(name);
        game.getGame().add(p1);
        assertEquals(p1,p.existPlayer(game.getGame(),"Carl"));  // Player added


        for (String value:perfectScore) {
            Integer size=p1.getLine().getFrames().size();
            if (size<10)
                p1.getLine().addFrame();
            message=p1.getLine().addScore(p1,value);
            assertNull(message);   //  There are no messages adding the scores
        }

        for (int i=0;i < 2; i++) {
            Line line = p1.getLine();
            Frame frame = line.getFrames().get(i);
            Integer size = frame.getRolls().size();
            if (i == 0)
                line.getScore()[i] = frame.totFrame(line, i, 0, 0);
            else
                line.getScore()[i] = frame.totFrame(line, i,line.getScore()[i-1] , 0);
            assertTrue(line.getScore()[i]==(i+1)*30);  // The score is  well calculated
        }

        System.out.println("\n\nFrame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        p1.getLine().printMe(p1);
    }

    /**
     * Test for zero score
     */
    @Test
    public void testZeroScore()
    {
        List<String> zeroScore= Arrays.asList("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
        String name="Carl";
        String message;
        Game game=new Game();
        Player p=new Player();

        Player p1=p.addPlayer(name);
        game.getGame().add(p1);
        assertEquals(p1,p.existPlayer(game.getGame(),"Carl"));  // Player added

        p1.getLine().addFrame();

        for (String value:zeroScore) {
            Integer size=p1.getLine().getFrames().size();
            Integer pos=p1.getNroThrows();
            if ((size<10)&&(pos==2)) {
                p1.getLine().addFrame();
            }
            message=p1.getLine().addScore(p1,value);
            assertNull(message);   //  There are no messages adding the scores
        }

        for (int i=0;i < 2; i++) {
            Line line = p1.getLine();
            Frame frame = line.getFrames().get(i);
            Integer size = frame.getRolls().size();
            if (i == 0)
                line.getScore()[i] = frame.totFrame(line, i, 0, 0);
            else
                line.getScore()[i] = frame.totFrame(line, i,line.getScore()[i-1] , 0);
            assertTrue(line.getScore()[i]==(i+1)*0);  //  The score is  well calculated
        }

        System.out.println("\n\nFrame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        p1.getLine().printMe(p1);
    }


    @Test
    public void testTwoPlayers()
    {
        String message;
        Game game=new Game();
        Player p=new Player();
        List<String> gameScore= Arrays.asList("Jeff\t5","Jeff\t4","John\t10","Jeff\t10","John\t10","Jeff\t7","Jeff\t3","John\t7","John\t2","Jeff\t10","John\t10","Jeff\t10","John\t8","John\t2","Jeff\t6","Jeff\t3","John\t6","John\t2","Jeff\t10","John\t10","Jeff\t10","John\t9","John\t0","Jeff\t9","Jeff\t0","John\t8","John\t2","Jeff\t5","Jeff\t3","John\t8","John\t1");

        for (String row:gameScore) {
            String[] splitted = row.split("\t");
            message=game.addThrow(splitted[0],splitted[1]);
            assertNull(message);
        }

        game.scoreGame();

    }




}
