package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View$OnLongClickListener;
import android.view.View$OnTouchListener;
import android.view.View;

public class DragStartHelper {
    public interface OnDragStartListener {
        boolean onDragStart(View arg1, DragStartHelper arg2);
    }

    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View$OnLongClickListener mLongClickListener;
    private final View$OnTouchListener mTouchListener;
    private final View mView;

    public DragStartHelper(View arg2, OnDragStartListener arg3) {
        super();
        this.mLongClickListener = new DragStartHelper$$ExternalSyntheticLambda0(this);
        this.mTouchListener = new DragStartHelper$$ExternalSyntheticLambda1(this);
        this.mView = arg2;
        this.mListener = arg3;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point arg2) {
        arg2.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View arg2) {
        if(this.mDragging) {
            return 1;
        }

        boolean v2 = this.mListener.onDragStart(arg2, this);
        this.mDragging = v2;
        return v2;
    }

    public boolean onTouch(View arg7, MotionEvent arg8) {
        int v0 = ((int)arg8.getX());
        int v1 = ((int)arg8.getY());
        int v2 = arg8.getAction();
        if(v2 != 0) {
            if(v2 != 1) {
                if(v2 != 2) {
                    if(v2 != 3) {
                        return 0;
                    }
                }
                else if(!MotionEventCompat.isFromSource(arg8, 0x2002)) {
                    return 0;
                }
                else if((arg8.getButtonState() & 1) == 0) {
                    return 0;
                }
                else if(this.mDragging) {
                    return 0;
                }
                else {
                    if(this.mLastTouchX == v0 && this.mLastTouchY == v1) {
                        return 0;
                    }

                    this.mLastTouchX = v0;
                    this.mLastTouchY = v1;
                    boolean v7 = this.mListener.onDragStart(arg7, this);
                    this.mDragging = v7;
                    return v7;
                }
            }

            this.mDragging = false;
        }
        else {
            this.mLastTouchX = v0;
            this.mLastTouchY = v1;
        }

        return 0;
    }
}

