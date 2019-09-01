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
        Player p1=p.addPlayer("Luis");
        Player p2=p.addPlayer("Carlos");

        List<Player> game= Arrays.asList(p1,p2);
        String data="Luis";

        Player playerFound=p.existPlayer(game,data);
        assertEquals(playerFound,p1);

    }
}
