package com.example.tiletakeover;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Board gameboard;
    private static Context mContext;

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        gameboard = new Board(this, mContext, 7);
    }

    private static void swap(Context context, int position, int swap) {
        String newPosition = gameboard.getBoardTiles()[position + swap];
        gameboard.getBoardTiles()[position + swap] = gameboard.getBoardTiles()[position];
        gameboard.getBoardTiles()[position] = newPosition;
        gameboard.display(context);
    }

    public static void moveTiles(Context context, String direction, int position) {
        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(RIGHT)) swap(context, position, gameboard.getCOL() - 1);
            else if (direction.equals(DOWN)) swap(context, position, gameboard.getDIMENSIONS() - gameboard.getCOL());
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < gameboard.getCOL() - 1) {
            if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(DOWN)) swap(context, position, gameboard.getCOL());
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == gameboard.getCOL() - 1) {
            if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(DOWN)) swap(context, position, gameboard.getCOL());
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > gameboard.getCOL() - 1 && position < gameboard.getDIMENSIONS() - gameboard.getCOL() &&
                position % gameboard.getCOL() == 0) {
            if (direction.equals(UP)) swap(context, position, -gameboard.getCOL());
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else if (direction.equals(DOWN)) swap(context, position, gameboard.getCOL());
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == gameboard.getCOL() * 2 - 1 || position == gameboard.getCOL() * 3 - 1) {
            if (direction.equals(UP)) swap(context, position, -gameboard.getCOL());
            else if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(DOWN)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= gameboard.getDIMENSIONS() - gameboard.getCOL() - 1) swap(context, position,
                        gameboard.getCOL());
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == gameboard.getDIMENSIONS() - gameboard.getCOL()) {
            if (direction.equals(UP)) swap(context, position, -gameboard.getCOL());
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < gameboard.getDIMENSIONS() - 1 && position > gameboard.getDIMENSIONS() - gameboard.getCOL()) {
            if (direction.equals(UP)) swap(context, position, -gameboard.getCOL());
            else if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(UP)) swap(context, position, -gameboard.getCOL());
            else if (direction.equals(LEFT)) swap(context, position, -1);
            else if (direction.equals(RIGHT)) swap(context, position, 1);
            else swap(context, position, gameboard.getCOL());
        }
    }
}
