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
    private String playerID;
    private int position;
    private int score;

    /**
     * Constructor for the Player class.
     */
    Player(String playerID, int pos) {
        this.playerID = playerID;
        this.position = pos;
        this.score    = 0;
    }

    /**
     * gives the player's ID
     * (For testing purposes)
     * @return the playerID field
     */
    String getPlayerID(){return this.playerID; }



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

    /**
     * This player has won a game so their score goes up by one.
     */
    void won() { this.score++; }


    /**
     *  returns the player's total round score
     * @return score field
     */
    int getScore() { return this.score;}
}
