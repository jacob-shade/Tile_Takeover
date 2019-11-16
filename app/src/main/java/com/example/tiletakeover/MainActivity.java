package com.example.tiletakeover;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;

/**
 * MainActivity class is the driver for the TileTakeover application.
 */
public class MainActivity extends AppCompatActivity {

    /**
     *
     */
    private final int COL = 7;
    private static Board gameBoard;
    public static final String UP = "up", DOWN = "down", RIGHT = "right", LEFT = "left";

    /**
     * Constructor for main activity class.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameBoard = new Board(this, getApplicationContext(), COL);
    }

    /**
     * Swaps two tiles allowing for 'walking' and 'sliding' moves.
     * @param context allows us to call the display method in the board class.
     * @param position the original position of the tile.
     * @param newPosition the position of the tile that is being swapped
     */
    private static void swap(Context context, int position, int newPosition) {
        System.out.println("position: "+ position + " newPos: " +newPosition);
        Tile oldTile = gameBoard.getBoardTiles()[position];
        Tile newTile = gameBoard.getBoardTiles()[newPosition];
        gameBoard.getBoardTiles()[newPosition] = oldTile;
        gameBoard.getBoardTiles()[position] = newTile;
        if(gameBoard.getPlayersTurn() == 1) {
            gameBoard.getPlayerOne().setPosition(newPosition);
        } else {
            gameBoard.getPlayerTwo().setPosition(newPosition);
        }
        gameBoard.display(context);
    }

    /**
     * Calls a function to move the tiles based on the direction given.
     * @param context allows us to call the display method in the board class.
     * @param direction the direction the user swiped to move their player piece.
     */
    public static void moveTiles(Context context, String direction) {
        int position = 0;
        if(gameBoard.getPlayersTurn() == 1) {
            position = gameBoard.getPlayerOne().getPosition();
        } else {
            position = gameBoard.getPlayerTwo().getPosition();
        }
        switch(direction) {
            case RIGHT:
                System.out.println("moving right");
                right(context, position);
                break;
            case LEFT:
                System.out.println("moving left");
                left(context, position);
                break;
            case UP:
                System.out.println("moving up");
                up(context, position);
                break;
            case DOWN:
                System.out.println("moving down");
                down(context, position);
                break;
        }
    }

    public static int right(Context context, int position) {
        int x1 = position;
        boolean walk = false;
        if (x1 == 6 || x1 == 13 || x1 == 20 || x1 == 27 || x1 == 34 || x1 == 41 || x1 == 48) {
            System.out.println("Wall is on next right");
            return 1;
        } else if (gameBoard.getBoardTiles()[position + 1].getIsPlatform()) {
            if (gameBoard.getBoardTiles()[position + 1].getHasPlayer()) {
                System.out.println("player to right");
                return 1;
            }
            System.out.println("walking...");
            walk = true;
        }
        if (walk) {
            swap(context, position, x1+1);
        } else {
            int z = findNext(x1, position);
            swap(context, position, z);
            gameBoard.endTurn();
        }
        return 0;
    }

    private static int findNext(int xn, int position) {
        int xn1 = position;
        System.out.println("position: " + position);
        if (xn1 == 5 || xn1 == 12 || xn1 == 19 || xn1 == 26 || xn1 == 33 ||
                xn1 == 40 || xn1 == 47) {
            xn1++;
            return xn1;
        }
        while (!gameBoard.getBoardTiles()[xn1 + 1].getIsPlatform()) {
            System.out.println(xn1 + ":");
            System.out.println(!gameBoard.getBoardTiles()[xn1 + 1].getIsPlatform());
            xn1++;
            if (xn1 == 6 || xn1 == 13 || xn1 == 20 || xn1 == 27 || xn1 == 34 ||
                    xn1 == 41 || xn1 == 48) {
                break;
            }
        }
        return xn1;
    }

    public static int left(Context context, int position) {
        int x1 = position;
        boolean walk = false;
        if (x1 == 0 || x1 == 7 || x1 == 14 || x1 == 21 || x1 == 28 || x1 == 35 || x1 == 42) {
            System.out.println("Wall is on next left");
            return 1;
        } else if (gameBoard.getBoardTiles()[position - 1].getIsPlatform()) {
            if (gameBoard.getBoardTiles()[position - 1].getHasPlayer()) {
                return 1;
            }
            walk = true;
            System.out.println("walking...");
        }
        if (walk) {
            swap(context, position, x1-1);
        } else {
            int z = findPrev(x1, position);
            System.out.println("z: " + z);
            swap(context, position, z);
            gameBoard.endTurn();
        }
        return 0;
    }

    private static int findPrev(int xn, int position) {
        int xn1 = position;
        if (xn1 == 1 || xn1 == 8 || xn1 == 15 || xn1 == 22 || xn1 == 29 || xn1 == 36 || xn1 == 43) {
            xn1--;
            return xn1;
        }
        while (!gameBoard.getBoardTiles()[xn1 - 1].getIsPlatform()) {
            System.out.println(xn1 + ":" + !gameBoard.getBoardTiles()[xn1 - 1].getIsPlatform());
            xn1--;
            if (xn1 == 0 || xn1 == 7 || xn1 == 14 || xn1 == 21 || xn1 == 28 || xn1 == 35 || xn1 == 42) {
                break;
            }
        };
        return xn1;
    }

    public static int up(Context context, int position) {
        int x1 = position;
        boolean walk = false;
        if (x1 == 0 || x1 == 1 || x1 == 2 || x1 == 3 || x1 == 4 || x1 == 5 || x1 == 6) {
            System.out.println("Wall is on next up");
            return 1;
        } else if (gameBoard.getBoardTiles()[position - 7].getIsPlatform()) {
            if (gameBoard.getBoardTiles()[position - 7].getHasPlayer()) {
                return 1;
            }
            walk = true;
        }
        if (walk) {
            System.out.println("Destination: " + (x1-7));
            swap(context, position, x1-7);
        } else {
            int z = findUpper(x1, position);
            swap(context, position, z);
            gameBoard.endTurn();
        }
        return 0;
    }

    private static int findUpper(int xn, int position) {
        int xn1 = position;
        if (xn1 == 7 || xn1 == 8 || xn1 == 9 || xn1 == 10 || xn1 == 11 || xn1 == 12 || xn1 == 13) {
            xn1 -= 7;
            return xn1;
        }
        while (!gameBoard.getBoardTiles()[xn1 - 7].getIsPlatform()) {
            System.out.println(xn1 + ":");
            System.out.println(!gameBoard.getBoardTiles()[xn1 - 7].getIsPlatform());
            xn1 -= 7;
            if (xn1 < 7) {
                break;
            }
        }
        return xn1;
    }

    public static int down(Context context, int position) {
        int x1 = position;
        boolean walk = false;
        if (x1 == 42 || x1 == 43 || x1 == 44 || x1 == 45 || x1 == 46 || x1 == 47 || x1 == 48) {
            System.out.println("Wall is on next down");
            return 1;
        } else if (gameBoard.getBoardTiles()[position + 7].getIsPlatform()) {
            if (gameBoard.getBoardTiles()[position + 7].getHasPlayer()) {
                return 1;
            }
            walk = true;
        }
        if (walk) {
            swap(context, position, x1+7);
        } else {
            int z = findBelow(x1, position);
            swap(context, position, z);
            gameBoard.endTurn();
        }
        return 0;
    }

    private static int findBelow(int xn, int position) {
        int xn1 = position;
        if (xn1 == 35 || xn1 == 36 || xn1 == 37 || xn1 == 38 || xn1 == 39 || xn1 == 40 || xn1 == 41) {
            xn1 += 7;
            return xn1;
        }
        while (!gameBoard.getBoardTiles()[xn1 + 7].getIsPlatform()) {
            System.out.println(xn1 + ":");
            System.out.println(!gameBoard.getBoardTiles()[xn1 + 7].getIsPlatform());
            xn1 += 7;
            if (xn1 > 41) {
                break;
            }
        }
        return xn1;
    }
}
