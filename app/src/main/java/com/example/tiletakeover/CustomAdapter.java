package com.example.tiletakeover;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import java.util.ArrayList;

/**
 * CustomAdapter class allows for the creation of each Button at the specified dimensions.
 */
public class CustomAdapter extends BaseAdapter {

    /**
     * mButtons    represents an ArrayList of all Buttons.
     * mTileWidth  represents the Button width according to the number of buttons and screen size.
     * mTileHeight represents the Button height according to the number of buttons and screen size.
     */
    private ArrayList<Button> mButtons;
    private int mTileWidth, mTileHeight;

    /**
     * Constructor for the CustomAdapter class.
     * @param buttons ArrayList of buttons.
     * @param tileWidth the width of each tile.
     * @param tileHeight the height of each tile.
     */
    public CustomAdapter(ArrayList<Button> buttons, int tileWidth, int tileHeight) {
        mButtons    = buttons;
        mTileWidth  = tileWidth;
        mTileHeight = tileHeight;
    }

    /**
     * Gets the number of buttons in the ArrayList.
     * @return the number of buttons.
     */
    @Override
    public int getCount() {
        return mButtons.size();
    }

    /**
     * Gets a Button at the desired position.
     * @param position of the requested button.
     * @return a Button at position.
     */
    @Override
    public Object getItem(int position) {
        return mButtons.get(position);
    }

    /**
     * The id of each position is the position itself.
     * @param position item id.
     * @return the position given.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Gets the Button at a desired position. Sets the Button's dimensions for viewing.
     * @param position of the Button.
     * @param convertView old view to be converted.
     * @param parent not used in this implementation.
     * @return the new View of a Button.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView == null) {
            button = mButtons.get(position);
        } else {
            button = (Button) convertView;
        }
        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(mTileWidth, mTileHeight);
        button.setLayoutParams(params);
        return button;
    }
}

