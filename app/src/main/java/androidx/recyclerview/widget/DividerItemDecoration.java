package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {
    private static final int[] ATTRS = null;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds;
    private Drawable mDivider;
    private int mOrientation;

    static {
        DividerItemDecoration.ATTRS = new int[]{0x1010214};
    }

    public DividerItemDecoration(Context arg3, int arg4) {
        super();
        this.mBounds = new Rect();
        TypedArray v3 = arg3.obtainStyledAttributes(DividerItemDecoration.ATTRS);
        Drawable v0 = v3.getDrawable(0);
        this.mDivider = v0;
        if(v0 == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }

        v3.recycle();
        this.setOrientation(arg4);
    }

    private void drawHorizontal(Canvas arg8, RecyclerView arg9) {
        int v2;
        int v0;
        arg8.save();
        int v1 = 0;
        if(arg9.getClipToPadding()) {
            v0 = arg9.getPaddingTop();
            v2 = arg9.getHeight() - arg9.getPaddingBottom();
            arg8.clipRect(arg9.getPaddingLeft(), v0, arg9.getWidth() - arg9.getPaddingRight(), v2);
        }
        else {
            v2 = arg9.getHeight();
            v0 = 0;
        }

        int v3 = arg9.getChildCount();
        while(v1 < v3) {
            View v4 = arg9.getChildAt(v1);
            arg9.getLayoutManager().getDecoratedBoundsWithMargins(v4, this.mBounds);
            int v5 = this.mBounds.right + Math.round(v4.getTranslationX());
            this.mDivider.setBounds(v5 - this.mDivider.getIntrinsicWidth(), v0, v5, v2);
            this.mDivider.draw(arg8);
            ++v1;
        }

        arg8.restore();
    }

    private void drawVertical(Canvas arg8, RecyclerView arg9) {
        int v2;
        int v0;
        arg8.save();
        int v1 = 0;
        if(arg9.getClipToPadding()) {
            v0 = arg9.getPaddingLeft();
            v2 = arg9.getWidth() - arg9.getPaddingRight();
            arg8.clipRect(v0, arg9.getPaddingTop(), v2, arg9.getHeight() - arg9.getPaddingBottom());
        }
        else {
            v2 = arg9.getWidth();
            v0 = 0;
        }

        int v3 = arg9.getChildCount();
        while(v1 < v3) {
            View v4 = arg9.getChildAt(v1);
            arg9.getDecoratedBoundsWithMargins(v4, this.mBounds);
            int v5 = this.mBounds.bottom + Math.round(v4.getTranslationY());
            this.mDivider.setBounds(v0, v5 - this.mDivider.getIntrinsicHeight(), v2, v5);
            this.mDivider.draw(arg8);
            ++v1;
        }

        arg8.restore();
    }

    public Drawable getDrawable() {
        return this.mDivider;
    }

    public void getItemOffsets(Rect arg1, View arg2, RecyclerView arg3, State arg4) {
        Drawable v2 = this.mDivider;
        if(v2 == null) {
            arg1.set(0, 0, 0, 0);
            return;
        }

        if(this.mOrientation == 1) {
            arg1.set(0, 0, 0, v2.getIntrinsicHeight());
            return;
        }

        arg1.set(0, 0, v2.getIntrinsicWidth(), 0);
    }

    public void onDraw(Canvas arg2, RecyclerView arg3, State arg4) {
        if(arg3.getLayoutManager() != null) {
            if(this.mDivider == null) {
            }
            else if(this.mOrientation == 1) {
                this.drawVertical(arg2, arg3);
                return;
            }
            else {
                this.drawHorizontal(arg2, arg3);
            }
        }
    }

    public void setDrawable(Drawable arg1) {
        if(arg1 != null) {
            this.mDivider = arg1;
            return;
        }

        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int arg2) {
        if(arg2 != 0) {
            if(arg2 == 1) {
            }
            else {
                throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
            }
        }

        this.mOrientation = arg2;
    }
}

