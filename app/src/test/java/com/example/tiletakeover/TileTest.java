package com.example.tiletakeover;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;

/**
 *
 *
 * Test class that
 *
 */

public class TileTest {


    /**
     * creates two players, and a board that will simulate our actual gameBoard
     */
    private Player P1 = new Player("Player1", 0);
    private Player P2 = new Player("Player2", 48);
    private Tile[]Board = new Tile[49];

    /**
     *
     * creates a array of tiles, and assigns some tiles as platforms, and 2 as platforms that
     * will hold players
     */
    @Before
    public void setUp(){


        for (int i = 0; i < 49; i++){

            Tile t = new Tile(i);
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
                t.setWinningTile();

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

        Board[0].setActivePlayer(null);

        Board[1].setHasPlayer(true);
        Board[1].setActivePlayer(P1);


        assertEquals(P1, Board[1].getActivePlayer());
        assertTrue(Board[1].getHasPlayer());
    }



    /**
     * tests whether or not we get the correct tileID
     */
    @Test
    public void testGetTileID()
    {
        Tile t = Board[23];
        assertEquals(23,t.getTileId() );
    }


    /**
     * tests whether or not we can set the specific position of a tile
     * another method tested is the get position.
     * Test will pass if and only if both methods work correctly.
     */
    @Test
    public void setPosition()
    {
        Tile testTile = new Tile(0);
        assertEquals(0, testTile.getPosition());
        testTile.setPosition(24);
        testTile.setWinningTile();
        assertEquals(24, testTile.getPosition());
        //assertTrue(testTile.getWinningTile());


    }

    /**
     *  tests to see if the winning tile in the setUp method had been
     *  established as the winning tile
     */
    @Test
    public void testSetWinningTile(){

        Tile testTile = Board[24];
        assertTrue( testTile.winningTile());
    }

    /**
     * test whether or not the tile has an active player on it
     */
    @Test
    public void testGetHaPlayer(){
        assertTrue(Board[0].getHasPlayer());
    }


    /**
     * simulates moving a player from one platform to another
     * then tests whether or not the former platform has a player
     * test whether or not the new platform has a player
     */
    @Test
    public void testSetHasPlayer(){
        P2.setPosition(47);
        Board[48].setActivePlayer(null);
        Board[48].setHasPlayer(false);
        Board[48].setIsPlatform(false);

        Board[47].setActivePlayer(P2);
        Board[47].setHasPlayer(true);
        Board[47].setIsPlatform(true);

        assertTrue(Board[47].getHasPlayer());
        assertFalse(Board[48].getHasPlayer());

    }
    /**
     * tests getIsPlatform method. Iterates over the created array, searching for platforms
     * will add one to the counter if the loop encounters a platform.
     *
     * there are 12 total platforms
     */
    @Test
    public void getIsPlatform(){

        int counter = 0;

        for (int i = 0; i < Board.length; i++){
            if (Board[i].getIsPlatform()){
                counter++;
            }
        }

        assertEquals(12, counter);
    }
}