package com.example.tiletakeover;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * GestureDetectGridView class takes the directional input from the user.
 */
public class GestureDetectGridView extends GridView {

    /**
     *  gDetector                represents the gesture or swipe detector.
     *  mFlingConfirmed          represents whether or not the input counts as a swipe or fling.
     *  mTouchX                  represents the horizontal input from the user.
     *  mTouchY                  represents the vertical input from the user.
     *  SWIPE_MIN_DISTANCE       represents the distance the user must swipe to count as a fling.
     *  WIPE_MAX_OFF_PATH        represents the error distance allowed of a swipe in a direction.
     *  SWIPE_THRESHOLD_VELOCITY represents the velocity the user must input to count as a fling.
     */
    private GestureDetector gDetector;
    private boolean mFlingConfirmed = false;
    private float mTouchX;
    private float mTouchY;
    private static final int SWIPE_MIN_DISTANCE = 65;
    private static final int SWIPE_MAX_OFF_PATH = 100;
    private static final int SWIPE_THRESHOLD_VELOCITY = 50;

    /**
     * Constructor for GestureDetectGridView class.
     * @param context of the screen.
     */
    public GestureDetectGridView(Context context) {
        super(context);
        init(context);
    }

    /**
     * Constructor for GestureDetectGridView class.
     * @param context of the screen.
     */
    public GestureDetectGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * Constructor for GestureDetectGridView class.
     * @param context of the screen.
     */
    public GestureDetectGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * Finds the direction the user is swiping.
     * @param context current context of the screen.
     */
    private void init(final Context context) {
        gDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent event) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                   float velocityY) {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                    if (Math.abs(e1.getX() - e2.getX()) > SWIPE_MAX_OFF_PATH
                            || Math.abs(velocityY) < SWIPE_THRESHOLD_VELOCITY) {
                        return false;
                    }
                    if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE) {
                        MainActivity.moveTiles(context, MainActivity.UP);
                    } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE) {
                        MainActivity.moveTiles(context, MainActivity.DOWN);
                    }
                } else {
                    if (Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY) {
                        return false;
                    }
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE) {
                        MainActivity.moveTiles(context, MainActivity.LEFT);
                    } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE) {
                        MainActivity.moveTiles(context, MainActivity.RIGHT);
                    }
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }

    /**
     * Determines if a user has tried to swipe or fling.
     * @param ev swipe input from user.
     * @return true if a fling has been confirmed.
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        gDetector.onTouchEvent(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mFlingConfirmed = false;
        } else if (action == MotionEvent.ACTION_DOWN) {
            mTouchX = ev.getX();
            mTouchY = ev.getY();
        } else {
            if (mFlingConfirmed) {
                return true;
            }
            float dX = (Math.abs(ev.getX() - mTouchX));
            float dY = (Math.abs(ev.getY() - mTouchY));
            if ((dX > SWIPE_MIN_DISTANCE) || (dY > SWIPE_MIN_DISTANCE)) {
                mFlingConfirmed = true;
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * Checks if an input event happened.
     * @param ev input event from user
     * @return true if an event happened.
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) { return gDetector.onTouchEvent(ev); }
}

