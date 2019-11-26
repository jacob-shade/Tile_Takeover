package com.example.tiletakeover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 *
 * Test class that
 *
 */

public class PlayerTest {


    /**
     * created to test multiple player Class methods
     */
    private Player P1 = new Player("Player 1", 0);


    /**
     * tests to see if the method returns the correct playerID
     */
    @Test
    public void testGetPlayerID()
    {
        assertEquals("Player 1", P1.getPlayerID());
    }

    /**
     * tests whether or not the correct position is returned
     */
    @Test
    public void testGetPosition()
    {
        assertEquals(0, P1.getPosition());
    }

    /**
     * tests the setPosition method.
     * changes the position and checks for the changed position
     */
    @Test
    public void testSetPosition()
    {
        assertEquals(0,P1.getPosition());
        P1.setPosition(1);
        assertEquals(1, P1.getPosition());
    }


    /**
     *  test whether or not the wins have been correctly
     *  initialized and incremented.
     */
    @Test
    public void testWon(){
        assertEquals(0, P1.getScore());
        P1.won();
        P1.won();
        assertEquals(2, P1.getScore());
    }

}