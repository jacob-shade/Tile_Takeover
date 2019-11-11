package com.example.tiletakeover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 *
 * Test class that
 *
 */

public class PlayerTest {


    private Player P1 = new Player("rob");


    /**
     * tests the method that checks for winning condition
     * in this case there is no win
     */
    @Test
    public void checkWin()
    {

        assertFalse( P1.checkWin());
    }

    /**
     * tests the method that checks for winning condition
     * in this case there is a win, the player is on the winning tile
     */
    @Test
    public void checkWin2()
    {
        P1.setPosition(24);
        assertTrue(P1.checkWin());
    }

    /**
     * tests the method that returns the player's current position
     */
    @Test
    public void getPosition()
    {

        assertEquals(0, P1.getPosition());
    }

    /**
     * tests the method that sets the player's position
     */
   @Test
   public void setPosition()
   {
        P1.setPosition(25);
        assertEquals(24, P1.getPosition());
   }

    /**
     * tests the moethod that returns the player's name
     */
    @Test
    public void getPlayerName()
    {
        assertEquals("rob", P1.getPlayerName());
    }



//    @Test
////    public void addition_isCorrect() {
////        assertEquals(4, 2 + 2);
////    }


}