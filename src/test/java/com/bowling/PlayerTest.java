package com.bowling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class PlayerTest {

    @Test
    public void testExistPlayer(){
        //System.out.println("testExistPlayer: ");
        Player p=new Player();
        Player p1=p.addPlayer("Jeff");
        Player p2=p.addPlayer("John");

        List<Player> game= Arrays.asList(p1,p2);
        String testCase="John";

        Player playerFound=p.existPlayer(game,testCase);
        assertEquals(playerFound,p2);

    }
}
