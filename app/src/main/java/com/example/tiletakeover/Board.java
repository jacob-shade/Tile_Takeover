package com.example.tiletakeover;

import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.ArrayList;

public class Board {

    private final int COL;
    private int DIMENSIONS;
    private static String[] boardTiles;
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
        this.boardTiles = new String[DIMENSIONS];
        this.activity = activity;
        this.mContext = context;
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
            boardTiles[i] = String.valueOf(i);
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
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        for(int i = 0; i < boardTiles.length; i++) {
            button = new Button(context);
            if(boardTiles[i].equals("0") || boardTiles[i].equals("48")) {
                button.setBackgroundResource(R.drawable.player);
            } else if (boardTiles[i].equals("1") || boardTiles[i].equals("5") ||
                    boardTiles[i].equals("6") || boardTiles[i].equals("7") ||
                    boardTiles[i].equals("13") || boardTiles[i].equals("35") ||
                    boardTiles[i].equals("41") || boardTiles[i].equals("42") ||
                    boardTiles[i].equals("43") || boardTiles[i].equals("47")) {
                button.setBackgroundResource(R.drawable.platform);
            } else if (boardTiles[i].equals("2") || boardTiles[i].equals("3") ||
                    boardTiles[i].equals("4") || boardTiles[i].equals("8") ||
                    boardTiles[i].equals("9") || boardTiles[i].equals("10") ||
                    boardTiles[i].equals("11") || boardTiles[i].equals("12") ||
                    boardTiles[i].equals("14") || boardTiles[i].equals("15") ||
                    boardTiles[i].equals("16") || boardTiles[i].equals("17") ||
                    boardTiles[i].equals("18") || boardTiles[i].equals("19") ||
                    boardTiles[i].equals("20") || boardTiles[i].equals("21") ||
                    boardTiles[i].equals("22") || boardTiles[i].equals("23") ||
                    boardTiles[i].equals("24") || boardTiles[i].equals("25") ||
                    boardTiles[i].equals("26") || boardTiles[i].equals("27") ||
                    boardTiles[i].equals("28") || boardTiles[i].equals("29") ||
                    boardTiles[i].equals("30") || boardTiles[i].equals("31") ||
                    boardTiles[i].equals("32") || boardTiles[i].equals("33") ||
                    boardTiles[i].equals("34") || boardTiles[i].equals("36") ||
                    boardTiles[i].equals("37") || boardTiles[i].equals("38") ||
                    boardTiles[i].equals("39") || boardTiles[i].equals("40") ||
                    boardTiles[i].equals("44") || boardTiles[i].equals("45") ||
                    boardTiles[i].equals("46")){
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
    String[] getBoardTiles() {return this.boardTiles;}
}
