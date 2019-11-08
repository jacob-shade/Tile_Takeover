package com.example.tiletakeover;

public class Tile {

    /**
     * activePlayer represents the player currently residing on a tile
     * hasPlayer is a flag that is set to true if there is a player on a tile, else false.
     * winningTile is a flag that is set only when the tile is in the winning position.
     *
     * isPlatform is a flag that indicates whether or not a tile is just a tile (no active player
     * and not a platform) or a platform (has active player)
     */
    private Player activePlayer;
    private boolean hasPlayer;
    private boolean winningTile;
    private boolean isPlatform;
    private int position;


    /**
     * initializes the tile object, to later be modified as needed throughout the game
     *
     */
    public Tile(){
        this.activePlayer = null;
        this.hasPlayer = false;
        this.winningTile = false;
        this.isPlatform = false;

    }

    /**
     * returns the active player currently on the tile
     */
    Player getActivePlayer(){
        return this.activePlayer;
    }


    /**
     * sets the Active player for the tile
     * @param P is the player who will become active on the tile
     */
    void setActivePlayer(Player P){
        this.activePlayer = P;
    }

    /**
     * sets the position that the tile holds on the board
     * @param pos is the position that is assigned to the tile, given from the board
     */
    void setPosition(int pos){
        this.position = pos;
    }


    /**
     *
     * @return the position of the tile
     */
    int getPosition(){
        return this.position;
    }

    /**
     * sets the flag of wining tile dependent on what is passed in
     * @param t boolean that represents whether or not the tile is the wining tile or not
     */
    void setWinningTile(boolean t){
        this.winningTile = t;
    }

    /**
     *
     * @return whether or not the tile is a winning tile
     */
    boolean getWinningTile(){
        return this.winningTile;
    }
    /**
     *
     * @return whether or not the tile has a player currently on it
     */
    boolean getHasPlayer(){
        return this.hasPlayer;
    }

    /**
     * sets the hasPlayer flag to indicate whether or not there is a player on the tile
     * @param t boolean variable that updates the hasPlayer flag
     */
    void setHasPlayer(boolean t){
        this.hasPlayer = t;
    }

    /**
     * sets the isPlatform flag to indicate whether or not the tile is a platform
     * @param t the boolean that will update our flag
     */
    void setIsPlatform(boolean t){
        this.isPlatform = t;
    }


    /**
     *
     * @return whether or not a tile is a platform
     */
    boolean getIsPlatform(){
        return this.isPlatform;
    }

}
