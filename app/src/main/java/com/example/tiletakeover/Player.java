package com.example.tiletakeover;


public class Player {

    /**
     * the winning tile position is 25, within a array of 49 tiles
     * the total number of possible moves in any direction is 8, two for each direction
     */
    private final int WIN_TILE_POS = 24;
    private final int MAX_NUM_MOVES = 8;


    /**
     * playerName represents the name that will be displayed for each player
     * position represents the integer position of each player on the board
     * int[]posMoves represents all of the possible legal moves for the current player
     * winTile is a flag that will be used to show that the player has landed on the winning tile
     * pass is a flag that will determine when a player's turn ends
     */
    private String playerName;
    private int position;
    private int[] posMoves;
    private boolean winTile;


    /**
     * constructor for the player object
     * @param name: initializes the player's name when the object is created
     */
    public Player(String name) {

        this.playerName = name;
        this.position = 0;
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
    public boolean checkWin() {

        if (this.position == WIN_TILE_POS) {
            this.winTile = true;
        }
        return this.winTile;
    }


    /**
     * used to update the possible moves for a player
     * @param moveSet is the list of new moves
     */
    public void setPosMoves(int[] moveSet){

    }


    public void move(){

    }


    /**
     *  method used to get player's name
     * @return player's assigned name
     */
    public String getPlayerName(){

        return this.playerName;

    }


    /**
     * used to set the active player's position.
     * @param pos the number that will represent the position of the player
     */
    public void setPosition(int pos){

        this.position = pos;
    }


    /**
    /**
     * @return the player's current position on the board
     */
    public int getPosition(){

        return this.position;
    }

    /**
     *
     * sets the player's name
     */

    public void setName(String newName){
        this.playerName = newName;
    }
}