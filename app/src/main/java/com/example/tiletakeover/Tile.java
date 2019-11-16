package com.example.tiletakeover;

/**
 * Tile class handles information about each individual tile and holds a Player if needed.
 */
class Tile {

    /**
     * activePlayer represents the player currently residing on a Tile.
     * hasPlayer    is a flag that is set to true if there is a player on a tile, else false.
     * winningTile  is a flag that is set only when the tile is in the winning position.
     * isPlatform   is a flag that indicates whether or not a Tile is a platform or empty.
     * tileId       represents an id for each tile.
     * position     represents a position on the Board for this Tile.
     */
    private Player activePlayer;
    private boolean hasPlayer;
    private boolean winningTile;
    private boolean isPlatform;
    private int tileId;
    private int position;


    /**
     * Constructor for Tile class.
     * Everything is set to false upon initialization.
     */
    Tile(int tileId){
        this.activePlayer = null;
        this.hasPlayer = false;
        this.winningTile = false;
        this.isPlatform = false;
        this.tileId = tileId;
    }

    /**
     * Gets the Player that is on this Tile.
     * @return activePlayer Player that is on this Tile.
     */
    Player getActivePlayer(){ return this.activePlayer; }

    /**
     * Sets the active Player for the Tile.
     * @param P is the Player who will become active on this Tile.
     */
    void setActivePlayer(Player P){ this.activePlayer = P; }

    /**
     * Gets the id of this Tile.
     * @return tileId the id of this Tile.
     */
    int getTileId() { return this.tileId; }

    /**
     * Sets the position that the Tile holds on the Board.
     * @param pos is the position that is assigned to the Tile.
     */
    void setPosition(int pos){ this.position = pos; }

    /**
     * Gets the position of this Tile.
     * @return the position of this Tile.
     */
    int getPosition(){ return this.position; }

    /**
     * Makes the current Tile the winning Tile.
     */
    void setWinningTile(){ this.winningTile = true; }

    /**
     * Determines if this Tile is the winning Tile.
     * @return true if this is the winning Tile.
     */
    boolean isWinningTile(){ return this.winningTile; }

    /**
     * Determines if this Tile has a Player on it.
     * @return true if this Tile currently has a Player on it.
     */
    boolean getHasPlayer(){ return this.hasPlayer; }

    /**
     * Sets this Tile as a Player Tile.
     */
    void setHasPlayer(){ this.hasPlayer = true; }

    /**
     * Sets this Tile as a platform Tile.
     */
    void setIsPlatform(){ this.isPlatform = true; }

    /**
     * Determines if this Tile is a platform Tile.
     * @return true if this Tile is a platform Tile.
     */
    boolean getIsPlatform(){ return this.isPlatform; }
}
