package com.example.tiletakeover;

import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.ArrayList;

public class Board {
    //comment
    private final int COL;
    private int DIMENSIONS;
    private static String[] boardTiles;
    private Activity activity;
    private Context mContext;
    private static GestureDetectGridView mGridView;
    private static int mTileWidth, mTileHeight;

    /*
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

    private void populateBoard() {
        mGridView = (GestureDetectGridView) activity.findViewById(R.id.grid);
        mGridView.setNumColumns(COL);


        for(int i = 0; i < DIMENSIONS; i++) {
            boardTiles[i] = String.valueOf(i);
        }
    }

    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(mContext);
                int requiredHeight = displayHeight - statusbarHeight;

                mTileWidth = displayWidth / COL;
                mTileHeight = requiredHeight / COL;

                display(mContext);
            }
        });
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimien",
                "android");
        if(resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;

        for(int i = 0; i < boardTiles.length; i++) {
            button = new Button(context);

            if(boardTiles[i].equals("0")) {
                button.setBackgroundResource(R.drawable.player_tile);
            } else if (boardTiles[i].equals("1")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("2")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("3")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("4")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("5")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("6")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("7")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("8")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("9")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("10")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("11")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("12")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("13")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("14")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("15")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("16")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("17")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("18")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("19")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("20")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("21")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("22")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("23")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("24")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("25")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("26")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("27")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            }else if (boardTiles[i].equals("28")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("29")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("30")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("31")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("32")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("33")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("34")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("35")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("36")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("37")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            }else if (boardTiles[i].equals("38")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("39")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("40")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("41")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("42")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("43")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("44")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("45")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("46")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("47")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            }else if (boardTiles[i].equals("48")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            } else if (boardTiles[i].equals("49")) {
                button.setBackgroundResource(R.drawable.blank_tile);
            }

            buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mTileWidth, mTileHeight));
    }

    int getCOL() {return this.COL;}
    int getDIMENSIONS() {return this.DIMENSIONS;}
    String[] getBoardTiles() {return this.boardTiles;}
}
