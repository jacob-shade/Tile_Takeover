package com.example.tiletakeover;

/**
 * Player class holds information about each player.
 */
public class Player {

    /**
     * playerId represents the name that will be displayed for each player.
     * tileId   represents the integer id of each player on the board.
     * score    represents the players number of games won.
     */
    private int playerId;
    private int tileId;
    private int position;
    private int score;

    /**
     * Constructor for the Player class.
     */
    public Player(int playerId, int tileId, int pos) {
        this.playerId = playerId;
        this.tileId   = tileId;
        this.position = pos;
        this.score    = 0;
    }

    /**
     * Gets the Player's id.
     * @return player's id.
     */
    public int getPlayerId(){ return this.playerId; }

    /**
     * Gets the Player's Tile id.
     * @return the Player's Tile id.
     */
    public int getTileId(){ return this.tileId; }

    public int getPosition() { return  this.position; }
    public void setPosition(int pos) { this.position = pos; }
}
