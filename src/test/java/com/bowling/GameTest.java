package com.bowling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    /**
     *    areBadFields return null if the line is good
     *
     */
    public void testAreBadFields(){
        String testCase="Jeff\t5";

        Game g=new Game();
        String testReady1=g.areBadFields(testCase);
        assertNull(testReady1);

        testCase = "Jeff";
        testReady1=g.areBadFields(testCase);
        assertNotNull(testReady1);

        testCase = "Jeff\tG";
        testReady1=g.areBadFields(testCase);
        assertNotNull(testReady1);

        testCase = "Jeff 5";
        testReady1=g.areBadFields(testCase);
        assertNotNull(testReady1);

        testCase = "Jeff\t5\t3";
        testReady1=g.areBadFields(testCase);
        assertNotNull(testReady1);

        testCase = "Jeff\t1200";
        testReady1=g.areBadFields(testCase);
        assertNotNull(testReady1);

        testCase = "Jeff\t-3";
        testReady1=g.areBadFields(testCase);
        assertNotNull(testReady1);
    }

    @Test
    public void testIsNumeric(){
        Game game=new Game();
        String testCase="P";
        Integer testReady=game.isNumeric(testCase);

        assertNull(testReady);

        testCase="8";
        testReady=game.isNumeric(testCase);

        assert(testReady == 8);

    }

    //public Boolean existBlackList(String data) {
    @Test
    public void testExistBlackList(){
        Game game=new Game();
        String testCase="Jeff";
        List<String> blackList= Arrays.asList("Jeff","John");

        game.setBlackList(blackList);
        Boolean testReady= game.existBlackList(testCase);

        assertEquals(testReady, true);
    }


}
