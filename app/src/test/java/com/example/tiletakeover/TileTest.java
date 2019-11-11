package com.example.tiletakeover;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 *
 *
 * Test class that
 *
 */

public class TileTest {

    private Player P1 = new Player("Player1");
    private Player P2 = new Player("Player2");
    private Tile[]Board = new Tile[49];

    /**
     *
     * creates a array of tiles, and assigns some tiles as platforms, and 2 as platforms that
     * will hold players.
     */
    @Before
    public void setUp(){


        for (int i = 0; i < 49; i++){

            Tile t = new Tile();
            t.setPosition(i);

            if (i == 0){
                t.setActivePlayer(P1);
                t.setHasPlayer(true);
                t.setIsPlatform(true);

            }
            else if (i == 1 | i == 5 | i == 6
            | i == 7 | i == 13 | i ==35 | i == 41
                    | i == 42 | i == 43 | i == 47){

                t.setIsPlatform(true);
            }
            else if (i == 24){
                t.setWinningTile(true);

            }
            else if (i == 48){
                t.setActivePlayer(P2);
                t.setHasPlayer(true);
                t.setIsPlatform(true);
            }
            Board[i] = t;
        }

    }

    /**
     * tests whether or not the getActive player returns a player on the tile
     */
    @Test
    public void getActivePlayer() {
        assertEquals(P1, Board[0].getActivePlayer());
        assertNull(Board[1].getActivePlayer());
    }


    /**
     * tests whether or not we can set an active player onto a tile.
     * tests the get has player method, and both setActivePlayer and getActivePlayer
     */
    @Test
    public void setActivePlayer(){
        Board[0].setHasPlayer(false);
        Board[0].setActivePlayer(null);

        Board[1].setHasPlayer(true);
        Board[1].setActivePlayer(P1);


        assertEquals(P1, Board[1].getActivePlayer());
        assertTrue(Board[1].getHasPlayer());
    }


    /**
     * Tests whether or not a tile's position can be changed
     * uses setPosition and getPosition are tested
     * also tests setWinningTile getWinningTile by checking that getWinningTile returns true
     */
    @Test
    public void setPosition()
    {
        Tile testTile = new Tile();
        assertEquals(0, testTile.getPosition());
        testTile.setPosition(24);
        testTile.setWinningTile(true);
        assertEquals(24, testTile.getPosition());
        assertTrue(testTile.getWinningTile());


    }

    /**
     * tests getPlatform method. Iterates over the created array, searching for platforms
     * will add one to the counter if the loop encounters a platform.
     *
     * there are 12 total platforms
     */
    @Test
    public void getPlatform(){

        int counter = 0;

        for (int i = 0; i < Board.length; i++){
            if (Board[i].getIsPlatform()){
                counter++;
            }
        }

        assertEquals(12, counter);
    }
}