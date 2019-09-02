package com.bowling;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FrameTest {
    @Test
    public void testIsSpare(){
        Frame frame=new Frame();
        frame.getRolls().add("2");
        frame.getRolls().add("8");

        assertTrue(frame.isSpare(frame));

        Frame frame2=new Frame();
        frame2.getRolls().add("2");
        frame2.getRolls().add("6");

        assertFalse(frame.isSpare(frame2));

    }

    @Test
    public void testSumMore10(){
        Frame frame=new Frame();
        frame.getRolls().add("2");
        frame.getRolls().add("9");

        assertTrue(frame.sumMore10(frame));

        Frame frame2=new Frame();
        frame2.getRolls().add("2");
        frame2.getRolls().add("6");

        assertFalse(frame.sumMore10(frame2));
    }
}
