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
        //this.playerOne("One", 0);
        populateBoard();
        setDimensions();
    }

    /**
     * Populates the board with DIMENSIONS number of tiles.
     * Stores string values for each of the tiles.
     */
    private void populateBoard() {
        mGridView = activity.findViewById(R.id.grid);
        mGridView.setNumColumns(COL);

        for(int i = 0; i < DIMENSIONS; i++) {
            boardTiles[i] = new Tile(i);
            if(i == 0) {                                            //player 1
                boardTiles[i].setHasPlayer();
                boardTiles[i].setIsPlatform();
                //boardTiles[i].setActivePlayer();
            } else if(i == 48) {                                    //player2
                boardTiles[i].setHasPlayer();
                boardTiles[i].setIsPlatform();
                //boardTiles[i].setActivePlayer();
            } else if (i == 24) {
                boardTiles[i].setWinningTile();                     //winning tile
            } else if (i == 1 || i == 5 || i == 6 || i == 7 || i == 13 || i == 35 ||
                    i == 41 || i == 42 || i == 43 || i == 47) {     //platform tile
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
            int displayWidth = mGridView.getMeasuredWidth();
            int displayHeight = mGridView.getMeasuredHeight();

            int statusBarHeight = getStatusBarHeight(mContext);
            int requiredHeight = displayHeight - statusBarHeight;

            mTileWidth = displayWidth / COL;
            mTileHeight = requiredHeight / COL;

            display(mContext);
            }
        });
    }

    /**
     * Gets the height of the status bar.
     * @param context
     * @return height
     */
    private int getStatusBarHeight(Context context) {
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimien",
                "android");
        if(resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }

    /**
     * Displays the buttons according to their String value.
     * @param context
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

    /**
     * Gets the number of columns in the board.
     * @return this.COL
     */
    int getCOL() {return this.COL;}

    /**
     * Gets the dimensions of the board.
     * @return this.DIMENSIONS
     */
    int getDIMENSIONS() {return this.DIMENSIONS;}

    /**
     * Gets the array of board tiles.
     * @return this.boardTiles
     */
    Tile[] getBoardTiles() {return this.boardTiles;}
}

/*
i == 2 || i == 3 || i == 4 || i == 8 || i == 9 || i == 10 ||
                    i == 11 || i == 12 || i == 14 || i == 15 || i == 16 || i == 17 ||
                    i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 ||
                    i == 25 || i == 26 || i == 27 || i == 28 || i == 29 || i == 30 ||
                    i == 31 || i == 32 || i == 33 || i == 34 || i == 36 || i == 37 ||
                    i == 38 || i == 39 || i == 39 || i == 40 || i == 44 || i == 45 ||
                    i == 46)
 */