package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint$Align;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public Placeholder(Context arg2) {
        super(arg2);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        this.init(null);
    }

    public Placeholder(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        this.init(arg2);
    }

    public Placeholder(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        this.init(arg2);
    }

    public Placeholder(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        this.init(arg2);
    }

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    private void init(AttributeSet arg5) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if(arg5 != null) {
            TypedArray v5 = this.getContext().obtainStyledAttributes(arg5, styleable.ConstraintLayout_placeholder);
            int v0 = v5.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v5.getIndex(v1);
                if(v2 == styleable.ConstraintLayout_placeholder_content) {
                    this.mContentId = v5.getResourceId(v2, this.mContentId);
                }
                else if(v2 == styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.mEmptyVisibility = v5.getInt(v2, this.mEmptyVisibility);
                }
            }
        }
    }

    public void onDraw(Canvas arg7) {
        if(this.isInEditMode()) {
            arg7.drawRGB(0xDF, 0xDF, 0xDF);
            Paint v6 = new Paint();
            v6.setARGB(0xFF, 210, 210, 210);
            v6.setTextAlign(Paint$Align.CENTER);
            v6.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect v0 = new Rect();
            arg7.getClipBounds(v0);
            v6.setTextSize(((float)v0.height()));
            int v2 = v0.height();
            int v3 = v0.width();
            v6.setTextAlign(Paint$Align.LEFT);
            v6.getTextBounds("?", 0, "?".length(), v0);
            arg7.drawText("?", (((float)v3)) / 2f - (((float)v0.width())) / 2f - (((float)v0.left)), (((float)v2)) / 2f + (((float)v0.height())) / 2f - (((float)v0.bottom)), v6);
        }
    }

    public void setContentId(int arg3) {
        if(this.mContentId == arg3) {
        }
        else {
            View v0 = this.mContent;
            if(v0 != null) {
                v0.setVisibility(0);
                this.mContent.getLayoutParams().isInPlaceholder = false;
                this.mContent = null;
            }

            this.mContentId = arg3;
            if(arg3 == -1) {
                return;
            }

            View v2 = this.getParent().findViewById(arg3);
            if(v2 == null) {
                return;
            }

            v2.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int arg1) {
        this.mEmptyVisibility = arg1;
    }

    public void updatePostMeasure(ConstraintLayout arg3) {
        if(this.mContent == null) {
            return;
        }

        ViewGroup$LayoutParams v3 = this.getLayoutParams();
        ViewGroup$LayoutParams v2 = this.mContent.getLayoutParams();
        ((LayoutParams)v2).widget.setVisibility(0);
        if(((LayoutParams)v3).widget.getHorizontalDimensionBehaviour() != DimensionBehaviour.FIXED) {
            ((LayoutParams)v3).widget.setWidth(((LayoutParams)v2).widget.getWidth());
        }

        if(((LayoutParams)v3).widget.getVerticalDimensionBehaviour() != DimensionBehaviour.FIXED) {
            ((LayoutParams)v3).widget.setHeight(((LayoutParams)v2).widget.getHeight());
        }

        ((LayoutParams)v2).widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout arg3) {
        if(this.mContentId == -1 && !this.isInEditMode()) {
            this.setVisibility(this.mEmptyVisibility);
        }

        View v3 = arg3.findViewById(this.mContentId);
        this.mContent = v3;
        if(v3 != null) {
            v3.getLayoutParams().isInPlaceholder = true;
            this.mContent.setVisibility(0);
            this.setVisibility(0);
        }
    }
}

