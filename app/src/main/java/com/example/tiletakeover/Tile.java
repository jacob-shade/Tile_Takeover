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




}
