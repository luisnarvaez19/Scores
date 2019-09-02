package com.bowling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class PlayerTest {

    @Test
    public void testExistPlayer(){
        Player p=new Player();
        Player p1=p.addPlayer("Jeff");
        Player p2=p.addPlayer("John");

        List<Player> game= Arrays.asList(p1,p2);
        String testCase="John";

        Player playerFound=p.existPlayer(game,testCase);
        assertEquals(playerFound,p2);

    }

    @Test
    public void testAddPlayer(){
        String name="Carl";
        String message;
        Game game=new Game();
        Player p=new Player();

        Player p1=p.addPlayer(name);
        game.getGame().add(p1);
        assertEquals(p1,p.existPlayer(game.getGame(),"Carl"));  // Player added
    }

    @Test
    public void testRemovePlayer(){
        String name1="Carl";
        String name2="Jeff";
        String message;
        Game game=new Game();
        Player p=new Player();

        Player p1=p.addPlayer(name1);
        game.getGame().add(p1);
        assertEquals(p1,p.existPlayer(game.getGame(),"Carl"));  // Player 1 added

        Player p2=p.addPlayer(name2);
        game.getGame().add(p2);
        assertEquals(p2,p.existPlayer(game.getGame(),"Jeff"));  // Player 2 added

        p.removePlayer(game,"Carl");
        assertNull(p.existPlayer(game.getGame(),"Carl"));
    }

}
