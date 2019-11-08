package com.example.tiletakeover;


import org.junit.Before;
import org.junit.Test;

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
    private Tile[]Board = new Tile[48];

    @Before
    public void setUp(){


        for (int i = 0; i <= 48; i++){

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
     * tests both setActivePlayer and getActivePlayer
     */
    @Test
    public void setActivePlayer(){
        Board[0].setHasPlayer(false);
        Board[0].setActivePlayer(null);

        Board[1].setHasPlayer(true);
        Board[1].setActivePlayer(P1);

        assertEquals(P1, Board[1].getActivePlayer());
    }

}