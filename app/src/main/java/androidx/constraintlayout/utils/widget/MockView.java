package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

public class MockView extends View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private Paint mPaintDiagonals;
    private Paint mPaintText;
    private Paint mPaintTextBackground;
    protected String mText;
    private int mTextBackgroundColor;
    private Rect mTextBounds;
    private int mTextColor;

    public MockView(Context arg4) {
        super(arg4);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(0xFF, 0, 0, 0);
        this.mTextColor = Color.argb(0xFF, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(0xFF, 50, 50, 50);
        this.mMargin = 4;
        this.init(arg4, null);
    }

    public MockView(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(0xFF, 0, 0, 0);
        this.mTextColor = Color.argb(0xFF, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(0xFF, 50, 50, 50);
        this.mMargin = 4;
        this.init(arg3, arg4);
    }

    public MockView(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(0xFF, 0, 0, 0);
        this.mTextColor = Color.argb(0xFF, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(0xFF, 50, 50, 50);
        this.mMargin = 4;
        this.init(arg2, arg3);
    }

    private void init(Context arg5, AttributeSet arg6) {
        if(arg6 != null) {
            TypedArray v6 = arg5.obtainStyledAttributes(arg6, styleable.MockView);
            int v0 = v6.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v6.getIndex(v1);
                if(v2 == styleable.MockView_mock_label) {
                    this.mText = v6.getString(v2);
                }
                else if(v2 == styleable.MockView_mock_showDiagonals) {
                    this.mDrawDiagonals = v6.getBoolean(v2, this.mDrawDiagonals);
                }
                else if(v2 == styleable.MockView_mock_diagonalsColor) {
                    this.mDiagonalsColor = v6.getColor(v2, this.mDiagonalsColor);
                }
                else if(v2 == styleable.MockView_mock_labelBackgroundColor) {
                    this.mTextBackgroundColor = v6.getColor(v2, this.mTextBackgroundColor);
                }
                else if(v2 == styleable.MockView_mock_labelColor) {
                    this.mTextColor = v6.getColor(v2, this.mTextColor);
                }
                else if(v2 == styleable.MockView_mock_showLabel) {
                    this.mDrawLabel = v6.getBoolean(v2, this.mDrawLabel);
                }
            }
        }

        if(this.mText == null) {
            try {
                this.mText = arg5.getResources().getResourceEntryName(this.getId());
                goto label_49;
            }
            catch(Exception ) {
            label_49:
                this.mPaintDiagonals.setColor(this.mDiagonalsColor);
                this.mPaintDiagonals.setAntiAlias(true);
                this.mPaintText.setColor(this.mTextColor);
                this.mPaintText.setAntiAlias(true);
                this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
                this.mMargin = Math.round((((float)this.mMargin)) * (this.getResources().getDisplayMetrics().xdpi / 160f));
                return;
            }
        }

        goto label_49;
    }

    public void onDraw(Canvas arg13) {
        Canvas v2;
        super.onDraw(arg13);
        int v0 = this.getWidth();
        int v1 = this.getHeight();
        if(this.mDrawDiagonals) {
            --v0;
            --v1;
            float v5 = ((float)v0);
            float v6 = ((float)v1);
            v2 = arg13;
            v2.drawLine(0f, 0f, v5, v6, this.mPaintDiagonals);
            v2.drawLine(0f, v6, v5, 0f, this.mPaintDiagonals);
            v2.drawLine(0f, 0f, v5, 0f, this.mPaintDiagonals);
            v2.drawLine(v5, 0f, v5, v6, this.mPaintDiagonals);
            v2.drawLine(v5, v6, 0f, v6, this.mPaintDiagonals);
            v2.drawLine(0f, v6, 0f, 0f, this.mPaintDiagonals);
        }
        else {
            v2 = arg13;
        }

        String v13 = this.mText;
        if(v13 != null && (this.mDrawLabel)) {
            this.mPaintText.getTextBounds(v13, 0, v13.length(), this.mTextBounds);
            float v13_1 = (((float)(v0 - this.mTextBounds.width()))) / 2f;
            float v1_1 = (((float)(v1 - this.mTextBounds.height()))) / 2f + (((float)this.mTextBounds.height()));
            this.mTextBounds.offset(((int)v13_1), ((int)v1_1));
            this.mTextBounds.set(this.mTextBounds.left - this.mMargin, this.mTextBounds.top - this.mMargin, this.mTextBounds.right + this.mMargin, this.mTextBounds.bottom + this.mMargin);
            v2.drawRect(this.mTextBounds, this.mPaintTextBackground);
            v2.drawText(this.mText, v13_1, v1_1, this.mPaintText);
        }
    }
}

