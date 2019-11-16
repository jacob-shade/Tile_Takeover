package com.example.tiletakeover;

public class Player {

    /**
     * the winning tile position is 25, within a array of 49 tiles
     * the total number of possible moves in any direction is 8, two for each direction
     */

    /**
     * playerName represents the name that will be displayed for each player
     * position represents the integer position of each player on the board
     * int[]posMoves represents all of the possible legal moves for the current player
     * winTile is a flag that will be used to show that the player has landed on the winning tile
     * pass is a flag that will determine when a player's turn ends
     */
    private int playerId;
    private int tileId;
    private int[] posMoves;
    private boolean winTile;

    /**
     * constructor for the player object
     */
    public Player(int playerId, int tileId) {
        this.playerId = playerId;
        this.tileId = tileId;
        posMoves = new int [8];
        winTile = false;
    }

    /**
     * checks the winTile flag, which indicates if the winning tile has been achieved
     * if the winning tile has been achieved, winTile will be set to true, otherwise,
     * it will be set to false
     *
     * @return the updated winTile flag
     */
    /*public boolean checkWin() {
        if (this.position == WIN_TILE_POS) {
            this.winTile = true;
        }
        return this.winTile;
    }*/

    /**
     *  method used to get player's name
     * @return player's assigned name
     */
    public int getPlayerId(){
        return this.playerId;
    }

    /**
    /**
     * @return the player's current position on the board
     */
    public int getTileId(){
        return this.tileId;
    }
}
