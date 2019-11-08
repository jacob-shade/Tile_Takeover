import javax.swing.*;

public class Player extends JButton {

    /**
     * the winning tile position is 25, within a array of 49 tiles
     * the total number of possible moves in any direction is 8, two for each direction
     */
    final int WIN_TILE_POS = 24;
    final int MAX_NUM_MOVES = 8;


    private String playerName;
    private int position;
    private int[] posMoves;
    private boolean winTile;
    private boolean pass;

    /**
     * playerName represents the name that will be displayed for each player
     * position represents the integer position of each player on the board
     * int[]posMoves represents all of the possible legal moves for the current player
     * winTile is a flag that will be used to show that the player has landed on the winning tile
     * pass is a flag that will determine when a player's turn ends
     */


    public Player(String name) {
        this.playerName = name;
        this.position = 0;
        this.posMoves = new int [8];
        this.winTile = false;
        this.pass = false;
    }
    /**
     * checks the winTile flag, which indicates if the winning tile has been acheived
     * if the winning tile has been acheived, winTile will be set to true, ptherwise,
     * it will be set to false
     *
     * @return the updated winTile flag
     */
    public boolean checkWin() {

        if (this.position == WIN_TILE_POS) {
            this.winTile = true;

        }
        else{
            this.winTile = false;
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

        pass = true;
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
     * @param pos
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

//    public static void main(String[]args){
//
//        Player p1 = new Player("Player 1");
//        p1.setPosition(12);
//        //Log.d("infoTag 1","Player position: "+String.valueOf(p1.getPosition()) );
//    }
}