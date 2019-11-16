package com.example.tiletakeover;

import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.ArrayList;

public class Board {

    private final int COL;
    private int DIMENSIONS;
    private static Tile[] boardTiles;
    private Player playerOne;
    private Player playerTwo;
    private int playersTurn;
    private int currentPlayerPosition;
    private Activity activity;
    private Context mContext;
    private static GestureDetectGridView mGridView;
    private static int mTileWidth, mTileHeight;

    /**
     * Constructor for the Gameboard class.
     */
    public Board(Activity activity, Context context, int col) {
        this.COL = col;
        this.DIMENSIONS = col * col;
        this.boardTiles = new Tile[DIMENSIONS];
        this.activity = activity;
        this.mContext = context;
        this.playerOne = new Player(1, 0, 0);
        this.playerTwo = new Player(2, 1, 48);
        this.playersTurn = 1;
        this.currentPlayerPosition = 0;
        populateBoard();
        setDimensions();
    }

    /**
     * Populates the board with DIMENSIONS number of Tile.
     */
    private void populateBoard() {
        mGridView = activity.findViewById(R.id.grid);
        mGridView.setNumColumns(COL);
        for(int i = 0; i < DIMENSIONS; i++) {
            boardTiles[i] = new Tile(i);
            if(i == 0) {
                boardTiles[i].setHasPlayer();
                boardTiles[i].setIsPlatform();
                boardTiles[i].setActivePlayer(playerOne);
            } else if(i == 48) {
                boardTiles[i].setHasPlayer();
                boardTiles[i].setIsPlatform();
                boardTiles[i].setActivePlayer(playerTwo);
            } else if (i == 24) {
                boardTiles[i].setWinningTile();
            } else if (i == 1 || i == 5 || i == 6 || i == 7 || i == 13 ||
                    i == 35 || i == 41 || i == 42 || i == 43 || i == 47) {
                boardTiles[i].setIsPlatform();
            }
        }
    }

    /**
     * Sets the dimensions of each tile and displays them
     */
    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mTileWidth = mGridView.getMeasuredWidth() / COL;
                mTileHeight = (mGridView.getMeasuredHeight()-getStatusBarHeight(mContext)) / COL;
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
    public static void display(Context context) {
        int id = 0;
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        for(int i = 0; i < boardTiles.length; i++) {
            button = new Button(context);
            id = boardTiles[i].getTileId();
            if(id == 0 || id == 48) {                                    //players
                button.setBackgroundResource(R.drawable.player);
            } else if (id == 1 || id == 5 || id == 6 || id == 7 || id == 13 || id == 35 ||
                    id == 41 || id == 42 || id == 43 || id == 47) {     //platform tile
                button.setBackgroundResource(R.drawable.platform);
            } else if (id == 24) {
                button.setBackgroundResource(R.drawable.win);
            } else {                                      //empty tile
                button.setBackgroundResource(R.drawable.empty);
            }
            buttons.add(button);
        }
        mGridView.setAdapter(new CustomAdapter(buttons, mTileWidth, mTileHeight));
    }

    public void endTurn() {
        if(this.playersTurn == 1) {
            this.playersTurn = 2;
            this.currentPlayerPosition = playerTwo.getPosition();
        } else {
            this.playersTurn = 1;
            this.currentPlayerPosition = playerOne.getPosition();
        }
    }

    public int getPlayersTurn() { return this.playersTurn; }

    public int getCurrentPlayerPosition() {
        return this.currentPlayerPosition;
    }

    public Player getPlayerOne() { return playerOne; }
    public Player getPlayerTwo() { return playerTwo; }

    /**
     * Gets the array of board tiles.
     * @return this.boardTiles
     */
    public Tile[] getBoardTiles() {return this.boardTiles;}
}
