package com.example.tiletakeover;

/**
 * Player class holds information about each player.
 */
class Player {

    /**
     * playerId represents the name that will be displayed for each player.
     * position represents the players position on the Board.
     * score    represents the players number of games won.
     */
    private int position;
    private int score;

    /**
     * Constructor for the Player class.
     */
    Player(int tileId, int pos) {
        this.position = pos;
        this.score    = 0;
    }

    /**
     * Gets the Player's position.
     * @return position of this Player.
     */
    int getPosition() { return  this.position; }

    /**
     * Sets the new position of the player after movement.
     * @param pos new position of the Player.
     */
    void setPosition(int pos) { this.position = pos; }
}
