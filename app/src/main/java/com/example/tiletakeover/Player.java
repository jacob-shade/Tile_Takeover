package com.example.tiletakeover;

public class Player {

    String playerName;
    int position;
    int[]posMoves;
    boolean winTile;
    boolean pass;
    /**
     * playerName represents the name that will be displayed for each player
     * position represents the integer position of each player on the board
     * int[]posMoves represents all of the possible legal moves for the current player
     * winTile is a flag that will be used to show that the player has landed on the winning tile
     * pass is a flag that will determine when a player's turn ends
     */


    public Player(){

    }
}
