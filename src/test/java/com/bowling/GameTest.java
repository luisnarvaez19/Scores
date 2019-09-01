package com.bowling;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GameTest {
    @Test
    public void testAreBadFields(){
        String test1="Jeff\t5";

        Game g=new Game();
        String testReady1=g.areBadFields(test1);
        assertNull(testReady1);

        

    }
}
