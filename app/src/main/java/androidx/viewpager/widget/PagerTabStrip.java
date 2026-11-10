package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;

public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 0x20;
    private static final int MIN_TEXT_SPACING = 0x40;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 0x20;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(Context arg2) {
        this(arg2, null);
    }

    public PagerTabStrip(Context arg4, AttributeSet arg5) {
        super(arg4, arg5);
        Paint v5 = new Paint();
        this.mTabPaint = v5;
        this.mTempRect = new Rect();
        this.mTabAlpha = 0xFF;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int v1 = this.mTextColor;
        this.mIndicatorColor = v1;
        v5.setColor(v1);
        float v5_1 = arg4.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = ((int)(3f * v5_1 + 0.5f));
        this.mMinPaddingBottom = ((int)(6f * v5_1 + 0.5f));
        this.mMinTextSpacing = ((int)(64f * v5_1));
        this.mTabPadding = ((int)(16f * v5_1 + 0.5f));
        this.mFullUnderlineHeight = ((int)(1f * v5_1 + 0.5f));
        this.mMinStripHeight = ((int)(v5_1 * 32f + 0.5f));
        this.mTouchSlop = ViewConfiguration.get(arg4).getScaledTouchSlop();
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        this.setTextSpacing(this.getTextSpacing());
        this.setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg1) {
                PagerTabStrip.this.mPager.setCurrentItem(PagerTabStrip.this.mPager.getCurrentItem() - 1);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg1) {
                PagerTabStrip.this.mPager.setCurrentItem(PagerTabStrip.this.mPager.getCurrentItem() + 1);
            }
        });
        if(this.getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    protected void onDraw(Canvas arg15) {
        super.onDraw(arg15);
        int v0 = this.getHeight();
        int v1 = this.mCurrText.getLeft() - this.mTabPadding;
        int v2 = this.mCurrText.getRight() + this.mTabPadding;
        int v3 = v0 - this.mIndicatorHeight;
        int v7 = 0xFFFFFF;
        this.mTabPaint.setColor(this.mTabAlpha << 24 | this.mIndicatorColor & v7);
        float v5 = ((float)v0);
        arg15.drawRect(((float)v1), ((float)v3), ((float)v2), v5, this.mTabPaint);
        Canvas v1_1 = arg15;
        if(this.mDrawFullUnderline) {
            this.mTabPaint.setColor(this.mIndicatorColor & v7 | 0xFF000000);
            v1_1.drawRect(((float)this.getPaddingLeft()), ((float)(v0 - this.mFullUnderlineHeight)), ((float)(this.getWidth() - this.getPaddingRight())), v5, this.mTabPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        int v0 = arg5.getAction();
        if(v0 != 0 && (this.mIgnoreTap)) {
            return 0;
        }

        float v2 = arg5.getX();
        float v5 = arg5.getY();
        if(v0 == 0) {
            this.mInitialMotionX = v2;
            this.mInitialMotionY = v5;
            this.mIgnoreTap = false;
        }
        else if(v0 == 1) {
            if(v2 < (((float)(this.mCurrText.getLeft() - this.mTabPadding)))) {
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
                return 1;
            }

            if(v2 <= (((float)(this.mCurrText.getRight() + this.mTabPadding)))) {
                return 1;
            }

            this.mPager.setCurrentItem(this.mPager.getCurrentItem() + 1);
        }
        else if(v0 != 2) {
        }
        else {
            if(Math.abs(v2 - this.mInitialMotionX) <= (((float)this.mTouchSlop)) && Math.abs(v5 - this.mInitialMotionY) <= (((float)this.mTouchSlop))) {
                return 1;
            }

            this.mIgnoreTap = true;
        }

        return 1;
    }

    public void setBackgroundColor(int arg2) {
        super.setBackgroundColor(arg2);
        if(!this.mDrawFullUnderlineSet) {
            boolean v2 = (arg2 & 0xFF000000) == 0 ? true : false;
            this.mDrawFullUnderline = v2;
        }
    }

    public void setBackgroundDrawable(Drawable arg2) {
        super.setBackgroundDrawable(arg2);
        if(!this.mDrawFullUnderlineSet) {
            boolean v2 = arg2 == null ? true : false;
            this.mDrawFullUnderline = v2;
        }
    }

    public void setBackgroundResource(int arg2) {
        super.setBackgroundResource(arg2);
        if(!this.mDrawFullUnderlineSet) {
            boolean v2 = arg2 == 0 ? true : false;
            this.mDrawFullUnderline = v2;
        }
    }

    public void setDrawFullUnderline(boolean arg1) {
        this.mDrawFullUnderline = arg1;
        this.mDrawFullUnderlineSet = true;
        this.invalidate();
    }

    public void setPadding(int arg2, int arg3, int arg4, int arg5) {
        int v0 = this.mMinPaddingBottom;
        if(arg5 < v0) {
            arg5 = v0;
        }

        super.setPadding(arg2, arg3, arg4, arg5);
    }

    public void setTabIndicatorColor(int arg2) {
        this.mIndicatorColor = arg2;
        this.mTabPaint.setColor(arg2);
        this.invalidate();
    }

    public void setTabIndicatorColorResource(int arg2) {
        this.setTabIndicatorColor(ContextCompat.getColor(this.getContext(), arg2));
    }

    public void setTextSpacing(int arg2) {
        int v0 = this.mMinTextSpacing;
        if(arg2 < v0) {
            arg2 = v0;
        }

        super.setTextSpacing(arg2);
    }

    void updateTextPositions(int arg6, float arg7, boolean arg8) {
        Rect v0 = this.mTempRect;
        int v1 = this.getHeight();
        int v2 = this.mCurrText.getLeft() - this.mTabPadding;
        int v3 = this.mCurrText.getRight() + this.mTabPadding;
        int v4 = v1 - this.mIndicatorHeight;
        v0.set(v2, v4, v3, v1);
        super.updateTextPositions(arg6, arg7, arg8);
        this.mTabAlpha = ((int)(Math.abs(arg7 - 0.5f) * 2f * 255f));
        v0.union(this.mCurrText.getLeft() - this.mTabPadding, v4, this.mCurrText.getRight() + this.mTabPadding, v1);
        this.invalidate(v0);
    }
}

