package com.example.tiletakeover;
import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.Button;
import java.util.ArrayList;

/**
 * Board class represents the game board with all Tiles and Players.
 */
class Board {

    /**
     *  COL         represents the columns of the Board.
     *  DIMENSIONS  represents the dimensions based on the columns*columns
     *  boardTiles  the array of Tiles that make up the Board.
     *  playerOne   represents the Player that starts the game.
     *  playerTwo   represents the other Player that follows playerOne.
     *  playersTurn represents the player whose turn it is.
     *  activity    Activity passed from the MainActivity so we can call findViewById(R.id.grid).
     *  mContext    used to update the View of the application.
     *  mGridView   takes input from the user(swipes).
     *  mTileWidth  width of each Tile to display according to the size of the screen.
     *  mTileHeight height of each Tile to display according to the size of the screen.
     */
    private final int COL;
    private int DIMENSIONS;
    private static Tile[] boardTiles;
    private Player playerOne;
    private Player playerTwo;
    private int playersTurn;
    private static boolean playerHasWon;
    private Activity activity;
    private Context mContext;
    private static GestureDetectGridView mGridView;
    private static int mTileWidth, mTileHeight;

    /**
     * Constructor for the Board class.
     */
    Board(Activity activity, Context context, int col) {
        this.COL = col;
        this.DIMENSIONS = col * col;
        boardTiles = new Tile[DIMENSIONS];
        this.activity = activity;
        this.mContext = context;
        this.playerOne = new Player("Player 1", 0);
        this.playerTwo = new Player("Player 2", 48);
        this.playersTurn = 1;
        this.playerHasWon = false;
        populateBoard();
        setDimensions();
    }

    /**
     * Resets some values to play another game.
     */
    void resetBoard() {
        this.playerOne = new Player("Player 1", 0);
        this.playerTwo = new Player("Player 2", 48);
        this.playersTurn = 1;
        this.playerHasWon = false;
        populateBoard();
        setDimensions();
    }

    /**
     * Populates the board with DIMENSIONS number of Tiles.
     */
    private void populateBoard() {
        mGridView = activity.findViewById(R.id.grid);
        mGridView.setNumColumns(COL);
        for(int i = 0; i < DIMENSIONS; i++) {
            boardTiles[i] = new Tile(i);
            if(i == 0) {
                boardTiles[i].setHasPlayer(true);
                boardTiles[i].setIsPlatform(true);
                boardTiles[i].setActivePlayer(playerOne);
            } else if(i == 48) {
                boardTiles[i].setHasPlayer(true);
                boardTiles[i].setIsPlatform(true);
                boardTiles[i].setActivePlayer(playerTwo);
            } else if (i == 24) {
                boardTiles[i].setWinningTile();
            } else if (i == 1 || i == 5 || i == 6 || i == 7 || i == 13 ||
                    i == 35 || i == 41 || i == 42 || i == 43 || i == 47) {
                boardTiles[i].setIsPlatform(true);
            }
        }
    }

    /**
     * Sets the dimensions of each tile and displays them.
     */
    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mTileWidth = mGridView.getMeasuredWidth() / COL;
                mTileHeight = (mGridView.getMeasuredHeight()-(2*getStatusBarHeight(mContext))) / COL;
                display(mContext);
            }
        });
    }

    /**
     * Gets the height of the status bar.
     * @param context allows access of the height of the status bar.
     * @return height of the status bar.
     */
    private int getStatusBarHeight(Context context) {
        int height = 0;
        int resourceId = context.getResources()
                .getIdentifier("status_bar_height", "dimien", "android");
        if(resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }

    /**
     * Displays the buttons according to their String value.
     * @param context used for adding the buttons to display to screen.
     */
    static void display(Context context) {
        int id;
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        for (Tile tile : boardTiles) {
            button = new Button(context);
            id = tile.getTileId();
            if(id == 0 || id == 48) {
                button.setBackgroundResource(R.drawable.player);
            } else if (id == 1 || id == 5 || id == 6 || id == 7 || id == 13 || id == 35 ||
                    id == 41 || id == 42 || id == 43 || id == 47) {
                button.setBackgroundResource(R.drawable.platform);
            } else if (id == 24) {
                if(playerHasWon) {
                    button.setBackgroundResource(R.drawable.empty);
                } else {
                    button.setBackgroundResource(R.drawable.win);
                }
            } else {
                button.setBackgroundResource(R.drawable.empty);
            }
            buttons.add(button);
        }
        mGridView.setAdapter(new CustomAdapter(buttons, mTileWidth, mTileHeight));
    }

    /**
     * Switches the active Player.
     */
    void endTurn() {
        if(this.playersTurn == 1) {
            this.playersTurn = 2;
        } else {
            this.playersTurn = 1;
        }
    }

    /**
     * A winner has been found.
     */
    void playerHasWon() {
        this.playerHasWon = true;
        if(playersTurn == 1) {
            playerOne.won();
        } else {
            playerTwo.won();
        }
    }

    /**
     * Gets the active Players turn.
     * @return playersTurn int representation of the active Player.
     */
    int getPlayersTurn() { return this.playersTurn; }

    /**
     * Gets Player one.
     * @return playerOne.
     */
    Player getPlayerOne() { return playerOne; }

    /**
     * Gets Player two.
     * @return playerTwo.
     */
    Player getPlayerTwo() { return playerTwo; }

    /**
     * Gets the array of Tiles that represents the board.
     * @return boardTiles
     */
    Tile[] getBoardTiles() {return boardTiles;}
}
