package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout$LayoutParams;
import androidx.appcompat.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    @Retention(value=RetentionPolicy.SOURCE) @public interface DividerMode {
    }

    public class LayoutParams extends LinearLayout$LayoutParams {
        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
        }

        public LayoutParams(int arg1, int arg2, float arg3) {
            super(arg1, arg2, arg3);
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface OrientationMode {
    }

    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public LinearLayoutCompat(Context arg2) {
        this(arg2, null);
    }

    public LinearLayoutCompat(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public LinearLayoutCompat(Context arg12, AttributeSet arg13, int arg14) {
        super(arg12, arg13, arg14);
        this.mBaselineAligned = true;
        int v1 = -1;
        this.mBaselineAlignedChildIndex = v1;
        this.mBaselineChildTop = 0;
        this.mGravity = 0x800033;
        TintTypedArray v3 = TintTypedArray.obtainStyledAttributes(arg12, arg13, styleable.LinearLayoutCompat, arg14, 0);
        LinearLayoutCompat v4 = this;
        ViewCompat.saveAttributeDataForStyleable(((View)v4), arg12, styleable.LinearLayoutCompat, arg13, v3.getWrappedTypeArray(), arg14, 0);
        int v11 = v3.getInt(styleable.LinearLayoutCompat_android_orientation, v1);
        if(v11 >= 0) {
            v4.setOrientation(v11);
        }

        v11 = v3.getInt(styleable.LinearLayoutCompat_android_gravity, v1);
        if(v11 >= 0) {
            v4.setGravity(v11);
        }

        boolean v11_1 = v3.getBoolean(styleable.LinearLayoutCompat_android_baselineAligned, true);
        if(!v11_1) {
            v4.setBaselineAligned(v11_1);
        }

        v4.mWeightSum = v3.getFloat(styleable.LinearLayoutCompat_android_weightSum, -1f);
        v4.mBaselineAlignedChildIndex = v3.getInt(styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, v1);
        v4.mUseLargestChild = v3.getBoolean(styleable.LinearLayoutCompat_measureWithLargestChild, false);
        v4.setDividerDrawable(v3.getDrawable(styleable.LinearLayoutCompat_divider));
        v4.mShowDividers = v3.getInt(styleable.LinearLayoutCompat_showDividers, 0);
        v4.mDividerPadding = v3.getDimensionPixelSize(styleable.LinearLayoutCompat_dividerPadding, 0);
        v3.recycle();
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas arg7) {
        int v1_1;
        int v0 = this.getVirtualChildCount();
        boolean v1 = ViewUtils.isLayoutRtl(((View)this));
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.getVirtualChildAt(v2);
            if(v3 != null && v3.getVisibility() != 8 && (this.hasDividerBeforeChildAt(v2))) {
                ViewGroup$LayoutParams v4 = v3.getLayoutParams();
                int v3_1 = v1 ? v3.getRight() + ((LayoutParams)v4).rightMargin : v3.getLeft() - ((LayoutParams)v4).leftMargin - this.mDividerWidth;
                this.drawVerticalDivider(arg7, v3_1);
            }
        }

        if(this.hasDividerBeforeChildAt(v0)) {
            View v0_1 = this.getVirtualChildAt(v0 - 1);
            if(v0_1 != null) {
                ViewGroup$LayoutParams v2_1 = v0_1.getLayoutParams();
                if(v1) {
                    v0 = v0_1.getLeft() - ((LayoutParams)v2_1).leftMargin;
                    v1_1 = this.mDividerWidth;
                label_44:
                    v0 -= v1_1;
                }
                else {
                    v0 = v0_1.getRight() + ((LayoutParams)v2_1).rightMargin;
                }
            }
            else if(v1) {
                v0 = this.getPaddingLeft();
            }
            else {
                v0 = this.getWidth() - this.getPaddingRight();
                v1_1 = this.mDividerWidth;
                goto label_44;
            }

            this.drawVerticalDivider(arg7, v0);
        }
    }

    void drawDividersVertical(Canvas arg6) {
        int v0 = this.getVirtualChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getVirtualChildAt(v1);
            if(v2 != null && v2.getVisibility() != 8 && (this.hasDividerBeforeChildAt(v1))) {
                this.drawHorizontalDivider(arg6, v2.getTop() - v2.getLayoutParams().topMargin - this.mDividerHeight);
            }
        }

        if(this.hasDividerBeforeChildAt(v0)) {
            View v0_1 = this.getVirtualChildAt(v0 - 1);
            v0 = v0_1 == null ? this.getHeight() - this.getPaddingBottom() - this.mDividerHeight : v0_1.getBottom() + v0_1.getLayoutParams().bottomMargin;
            this.drawHorizontalDivider(arg6, v0);
        }
    }

    void drawHorizontalDivider(Canvas arg5, int arg6) {
        this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, arg6, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, this.mDividerHeight + arg6);
        this.mDivider.draw(arg5);
    }

    void drawVerticalDivider(Canvas arg6, int arg7) {
        this.mDivider.setBounds(arg7, this.getPaddingTop() + this.mDividerPadding, this.mDividerWidth + arg7, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
        this.mDivider.draw(arg6);
    }

    private void forceUniformHeight(int arg10, int arg11) {
        int v4;
        LinearLayoutCompat v2;
        int v6 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0x40000000);
        int v0 = 0;
        while(v0 < arg10) {
            View v3 = this.getVirtualChildAt(v0);
            if(v3.getVisibility() != 8) {
                ViewGroup$LayoutParams v1 = v3.getLayoutParams();
                if(((LayoutParams)v1).height == -1) {
                    int v8 = ((LayoutParams)v1).width;
                    ((LayoutParams)v1).width = v3.getMeasuredWidth();
                    v2 = this;
                    v4 = arg11;
                    v2.measureChildWithMargins(v3, v4, 0, v6, 0);
                    ((LayoutParams)v1).width = v8;
                }
                else {
                    goto label_23;
                }
            }
            else {
            label_23:
                v2 = this;
                v4 = arg11;
            }

            ++v0;
            this = v2;
            arg11 = v4;
        }
    }

    private void forceUniformWidth(int arg10, int arg11) {
        int v6;
        LinearLayoutCompat v2;
        int v4 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
        int v0 = 0;
        while(v0 < arg10) {
            View v3 = this.getVirtualChildAt(v0);
            if(v3.getVisibility() != 8) {
                ViewGroup$LayoutParams v1 = v3.getLayoutParams();
                if(((LayoutParams)v1).width == -1) {
                    int v8 = ((LayoutParams)v1).height;
                    ((LayoutParams)v1).height = v3.getMeasuredHeight();
                    v2 = this;
                    v6 = arg11;
                    v2.measureChildWithMargins(v3, v4, 0, v6, 0);
                    ((LayoutParams)v1).height = v8;
                }
                else {
                    goto label_23;
                }
            }
            else {
            label_23:
                v2 = this;
                v6 = arg11;
            }

            ++v0;
            this = v2;
            arg11 = v6;
        }
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        int v2 = this.mOrientation;
        int v0 = -2;
        if(v2 == 0) {
            return new LayoutParams(v0, v0);
        }

        if(v2 == 1) {
            return new LayoutParams(-1, v0);
        }

        return null;
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateLayoutParams(arg1);
    }

    protected LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return new LayoutParams(arg1);
    }

    public int getBaseline() {
        if(this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }

        int v0 = this.getChildCount();
        int v1 = this.mBaselineAlignedChildIndex;
        if(v0 > v1) {
            View v0_1 = this.getChildAt(v1);
            v1 = v0_1.getBaseline();
            int v2 = -1;
            if(v1 == v2) {
                if(this.mBaselineAlignedChildIndex == 0) {
                    return v2;
                }

                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn\'t know how to get its baseline.");
            }

            v2 = this.mBaselineChildTop;
            if(this.mOrientation == 1) {
                int v3 = this.mGravity & 0x70;
                if(v3 != 0x30) {
                    if(v3 == 16) {
                        v2 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.mTotalLength) / 2;
                    }
                    else if(v3 != 80) {
                    }
                    else {
                        v2 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.mTotalLength;
                    }
                }
            }

            return v2 + v0_1.getLayoutParams().topMargin + v1;
        }

        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View arg1, int arg2) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View arg1) {
        return 0;
    }

    int getNextLocationOffset(View arg1) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int arg1) {
        return this.getChildAt(arg1);
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int arg5) {
        if(arg5 == 0) {
            if((this.mShowDividers & 1) != 0) {
                return 1;
            }

            return 0;
        }

        int v2 = this.getChildCount();
        int v3 = this.mShowDividers;
        if(arg5 == v2) {
            if((v3 & 4) != 0) {
                return 1;
            }

            return 0;
        }

        if((v3 & 2) != 0) {
            --arg5;
            while(arg5 >= 0) {
                if(this.getChildAt(arg5).getVisibility() != 8) {
                    return 1;
                }
                else {
                    --arg5;
                    continue;
                }

                return 0;
            }
        }

        return 0;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    void layoutHorizontal(int arg22, int arg23, int arg24, int arg25) {
        int v18;
        int v19;
        int v17;
        int v16;
        LinearLayoutCompat v0 = this;
        boolean v1 = ViewUtils.isLayoutRtl(((View)v0));
        int v6 = v0.getPaddingTop();
        int v2 = arg25 - arg23;
        int v7 = v2 - v0.getPaddingBottom();
        int v8 = v2 - v6 - v0.getPaddingBottom();
        int v9 = v0.getVirtualChildCount();
        int v3 = 0x800007 & v0.mGravity;
        int v10 = v0.mGravity & 0x70;
        boolean v11 = v0.mBaselineAligned;
        int[] v12 = v0.mMaxAscent;
        int[] v13 = v0.mMaxDescent;
        v2 = GravityCompat.getAbsoluteGravity(v3, ViewCompat.getLayoutDirection(((View)v0)));
        int v14 = 2;
        int v15 = 1;
        if(v2 == 1) {
            v2 = v0.getPaddingLeft() + (arg24 - arg22 - v0.mTotalLength) / v14;
        }
        else if(v2 != 5) {
            v2 = v0.getPaddingLeft();
        }
        else {
            v2 = v0.getPaddingLeft() + arg24 - arg22 - v0.mTotalLength;
        }

        if(v1) {
            v16 = v9 - 1;
            v17 = -1;
        }
        else {
            v16 = 0;
            v17 = 1;
        }

        int v1_1 = 0;
        while(v1_1 < v9) {
            v3 = v16 + v17 * v1_1;
            int v5 = v1_1;
            View v1_2 = v0.getVirtualChildAt(v3);
            if(v1_2 == null) {
                v2 += v0.measureNullChild(v3);
                v1_1 = v5;
                v19 = v6;
                arg23 = v14;
                arg25 = v15;
            }
            else {
                arg23 = v14;
                arg25 = v15;
                if(v1_2.getVisibility() != 8) {
                    v14 = v1_2.getMeasuredWidth();
                    v15 = v5;
                    v5 = v1_2.getMeasuredHeight();
                    ViewGroup$LayoutParams v4 = v1_2.getLayoutParams();
                    arg24 = v2;
                    if(v11) {
                        v18 = v5;
                        if(((LayoutParams)v4).height != -1) {
                            v5 = v1_2.getBaseline();
                        }
                        else {
                            goto label_80;
                        }
                    }
                    else {
                        v18 = v5;
                    label_80:
                        v5 = -1;
                    }

                    v2 = ((LayoutParams)v4).gravity;
                    if(v2 < 0) {
                        v2 = v10;
                    }

                    v2 &= 0x70;
                    v19 = v6;
                    if(v2 == 16) {
                        v2 = v19 + (v8 - v18) / 2 + ((LayoutParams)v4).topMargin;
                        v5 = ((LayoutParams)v4).bottomMargin;
                    label_120:
                        v2 -= v5;
                    }
                    else if(v2 == 0x30) {
                        v2 = v19 + ((LayoutParams)v4).topMargin;
                        if(v5 != -1) {
                            v2 += v12[arg25] - v5;
                        }
                    }
                    else if(v2 != 80) {
                        v2 = v19;
                    }
                    else {
                        v2 = v7 - v18 - ((LayoutParams)v4).bottomMargin;
                        if(v5 != -1) {
                            v5 = v13[arg23] - (v1_2.getMeasuredHeight() - v5);
                            goto label_120;
                        }
                    }

                    v5 = v0.hasDividerBeforeChildAt(v3) ? arg24 + v0.mDividerWidth : arg24;
                    v6 = ((LayoutParams)v4).leftMargin + v5;
                    v0.setChildFrame(v1_2, v0.getLocationOffset(v1_2) + v6, v2, v14, v18);
                    v6 += v4.rightMargin + v14 + v0.getNextLocationOffset(v1_2);
                    v1_1 = v0.getChildrenSkipCount(v1_2, v3) + v15;
                    v2 = v6;
                }
                else {
                    v19 = v6;
                    v1_1 = v5;
                }
            }

            ++v1_1;
            v14 = arg23;
            v15 = arg25;
            v6 = v19;
        }
    }

    void layoutVertical(int arg12, int arg13, int arg14, int arg15) {
        LinearLayoutCompat v3_1;
        int v5;
        int v0 = this.getPaddingLeft();
        arg14 -= arg12;
        arg12 = arg14 - this.getPaddingRight();
        arg14 = arg14 - v0 - this.getPaddingRight();
        int v1 = this.getVirtualChildCount();
        int v3 = this.mGravity & 0x70;
        int v2 = this.mGravity & 0x800007;
        if(v3 == 16) {
            arg13 = this.getPaddingTop() + (arg15 - arg13 - this.mTotalLength) / 2;
        }
        else if(v3 != 80) {
            arg13 = this.getPaddingTop();
        }
        else {
            arg13 = this.getPaddingTop() + arg15 - arg13 - this.mTotalLength;
        }

        arg15 = 0;
        while(arg15 < v1) {
            View v4 = this.getVirtualChildAt(arg15);
            if(v4 == null) {
                arg13 += this.measureNullChild(arg15);
                goto label_86;
            }
            else if(v4.getVisibility() != 8) {
                int v7 = v4.getMeasuredWidth();
                int v8 = v4.getMeasuredHeight();
                ViewGroup$LayoutParams v10 = v4.getLayoutParams();
                v3 = ((LayoutParams)v10).gravity;
                if(v3 < 0) {
                    v3 = v2;
                }

                v3 = GravityCompat.getAbsoluteGravity(v3, ViewCompat.getLayoutDirection(((View)this))) & 7;
                if(v3 == 1) {
                    v3 = (arg14 - v7) / 2 + v0 + ((LayoutParams)v10).leftMargin;
                    v5 = ((LayoutParams)v10).rightMargin;
                label_66:
                    v3 -= v5;
                }
                else if(v3 != 5) {
                    v3 = ((LayoutParams)v10).leftMargin + v0;
                }
                else {
                    v3 = arg12 - v7;
                    v5 = ((LayoutParams)v10).rightMargin;
                    goto label_66;
                }

                v5 = v3;
                if(this.hasDividerBeforeChildAt(arg15)) {
                    arg13 += this.mDividerHeight;
                }

                arg13 += ((LayoutParams)v10).topMargin;
                v3_1 = this;
                v3_1.setChildFrame(v4, v5, arg13 + this.getLocationOffset(v4), v7, v8);
                arg13 += v8 + ((LayoutParams)v10).bottomMargin + v3_1.getNextLocationOffset(v4);
                arg15 += v3_1.getChildrenSkipCount(v4, arg15);
            }
            else {
            label_86:
                v3_1 = this;
            }

            ++arg15;
            this = v3_1;
        }
    }

    void measureChildBeforeLayout(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        this.measureChildWithMargins(arg1, arg3, arg4, arg5, arg6);
    }

    void measureHorizontal(int arg39, int arg40) {
        int v7_1;
        int v36;
        View v4_1;
        int v12_1;
        int v5_1;
        int v13_1;
        int v4_2;
        boolean v6_1;
        float v32;
        boolean v27_1;
        int[] v28;
        int[] v34;
        int v33;
        int v35;
        boolean v30;
        int v27;
        int[] v2;
        LinearLayoutCompat v0 = this;
        v0.mTotalLength = 0;
        int v8 = v0.getVirtualChildCount();
        int v9 = View$MeasureSpec.getMode(arg39);
        int v10 = View$MeasureSpec.getMode(arg40);
        int[] v1 = v0.mMaxAscent;
        int v11 = 4;
        if(v1 != null) {
            v2 = v0.mMaxDescent;
            if(v2 == null) {
                goto label_11;
            }
        }
        else {
        label_11:
            v1 = new int[v11];
            v0.mMaxAscent = v1;
            v2 = new int[v11];
            v0.mMaxDescent = v2;
        }

        int[] v12 = v1;
        int[] v13 = v2;
        int v14 = 3;
        v12[v14] = -1;
        int v16 = 2;
        v12[v16] = -1;
        v12[1] = -1;
        v12[0] = -1;
        v13[v14] = -1;
        v13[v16] = -1;
        v13[1] = -1;
        v13[0] = -1;
        boolean v1_1 = v0.mBaselineAligned;
        boolean v2_1 = v0.mUseLargestChild;
        int v3 = 0x40000000;
        int v18 = v9 == v3 ? 1 : 0;
        boolean v4 = v2_1;
        int v2_2 = 0;
        int v6 = 0;
        int v15 = 0;
        int v22 = 0;
        int v24 = 0;
        int v26 = 0;
        int v21 = v14;
        int v25 = 1;
        float v5 = 0f;
        v11 = 0;
        v14 = 0;
        while(true) {
            v27 = v6;
            v6 = 8;
            if(v2_2 >= v8) {
                break;
            }

            v30 = v1_1;
            View v1_2 = v0.getVirtualChildAt(v2_2);
            if(v1_2 == null) {
                v0.mTotalLength += v0.measureNullChild(v2_2);
                goto label_60;
            }
            else if(v1_2.getVisibility() == v6) {
                v2_2 += v0.getChildrenSkipCount(v1_2, v2_2);
            label_60:
                v35 = v8;
                v33 = v9;
                v34 = v12;
                v28 = v13;
                v6 = v27;
                v27_1 = v4;
            }
            else {
                if(v0.hasDividerBeforeChildAt(v2_2)) {
                    v0.mTotalLength += v0.mDividerWidth;
                }

                ViewGroup$LayoutParams v7 = v1_2.getLayoutParams();
                v32 = v5 + ((LayoutParams)v7).weight;
                if(v9 != v3 || ((LayoutParams)v7).width != 0 || ((LayoutParams)v7).weight <= 0f) {
                    if(((LayoutParams)v7).width != 0 || ((LayoutParams)v7).weight <= 0f) {
                        v3 = -2;
                        v5_1 = 0x80000000;
                    }
                    else {
                        v3 = -2;
                        ((LayoutParams)v7).width = v3;
                        v5_1 = 0;
                    }

                    if(v32 == 0f) {
                        v6_1 = v4;
                        v4_2 = v0.mTotalLength;
                    }
                    else {
                        v6_1 = v4;
                        v4_2 = 0;
                    }

                    v35 = v8;
                    v33 = v9;
                    v34 = v12;
                    v12_1 = v27;
                    v8 = 0x40000000;
                    v27_1 = v6_1;
                    v28 = v13;
                    v13_1 = v5_1;
                    v0.measureChildBeforeLayout(v1_2, v2_2, arg39, v4_2, arg40, 0);
                    v4_1 = v1_2;
                    if(v13_1 != 0x80000000) {
                        ((LayoutParams)v7).width = v13_1;
                    }

                    v5_1 = v4_1.getMeasuredWidth();
                    v6 = v0.mTotalLength;
                    v0.mTotalLength = v18 != 0 ? v6 + (((LayoutParams)v7).leftMargin + v5_1 + ((LayoutParams)v7).rightMargin + v0.getNextLocationOffset(v4_1)) : Math.max(v6, v6 + v5_1 + ((LayoutParams)v7).leftMargin + ((LayoutParams)v7).rightMargin + v0.getNextLocationOffset(v4_1));
                    if(!v27_1) {
                        goto label_186;
                    }

                    v15 = Math.max(v5_1, v15);
                }
                else {
                    v5_1 = v0.mTotalLength;
                    v0.mTotalLength = v18 != 0 ? v5_1 + (((LayoutParams)v7).leftMargin + ((LayoutParams)v7).rightMargin) : Math.max(v5_1, ((LayoutParams)v7).leftMargin + v5_1 + ((LayoutParams)v7).rightMargin);
                    if(v30) {
                        v5_1 = View$MeasureSpec.makeMeasureSpec(0, 0);
                        v1_2.measure(v5_1, v5_1);
                        v35 = v8;
                        v33 = v9;
                        v34 = v12;
                        v28 = v13;
                    }
                    else {
                        v35 = v8;
                        v33 = v9;
                        v34 = v12;
                        v28 = v13;
                        v22 = 1;
                    }

                    v12_1 = v27;
                    v8 = 0x40000000;
                    v27_1 = v4;
                    v4_1 = v1_2;
                }

            label_186:
                if(v10 == v8 || ((LayoutParams)v7).height != -1) {
                    v5_1 = 0;
                }
                else {
                    v5_1 = 1;
                    v26 = 1;
                }

                v6 = ((LayoutParams)v7).topMargin + ((LayoutParams)v7).bottomMargin;
                v9 = v4_1.getMeasuredHeight() + v6;
                v24 = View.combineMeasuredStates(v24, v4_1.getMeasuredState());
                if(v30) {
                    v8 = v4_1.getBaseline();
                    if(v8 != -1) {
                        v13_1 = ((LayoutParams)v7).gravity < 0 ? v0.mGravity : ((LayoutParams)v7).gravity;
                        v13_1 = ((v13_1 & 0x70) >> 4 & -2) >> 1;
                        v36 = v5_1;
                        v34[v13_1] = Math.max(v34[v13_1], v8);
                        v28[v13_1] = Math.max(v28[v13_1], v9 - v8);
                    }
                    else {
                        goto label_224;
                    }
                }
                else {
                label_224:
                    v36 = v5_1;
                }

                v5_1 = Math.max(v12_1, v9);
                v25 = v25 == 0 || ((LayoutParams)v7).height != -1 ? 0 : 1;
                if(((LayoutParams)v7).weight > 0f) {
                    if(v36 != 0) {
                    }
                    else {
                        v6 = v9;
                    }

                    v14 = Math.max(v14, v6);
                }
                else {
                    if(v36 != 0) {
                    }
                    else {
                        v6 = v9;
                    }

                    v11 = Math.max(v11, v6);
                }

                v2_2 += v0.getChildrenSkipCount(v4_1, v2_2);
                v6 = v5_1;
                v5 = v32;
            }

            ++v2_2;
            v4 = v27_1;
            v13 = v28;
            v1_1 = v30;
            v9 = v33;
            v12 = v34;
            v8 = v35;
            v3 = 0x40000000;
        }

        v3 = arg39;
        v30 = v1_1;
        v35 = v8;
        v33 = v9;
        v34 = v12;
        v28 = v13;
        v8 = v24;
        v12_1 = v27;
        int v1_3 = arg40;
        v27_1 = v4;
        if(v0.mTotalLength > 0) {
            v2_2 = v35;
            if(v0.hasDividerBeforeChildAt(v2_2)) {
                v0.mTotalLength += v0.mDividerWidth;
            }
        }
        else {
            v2_2 = v35;
        }

        v4_2 = v34[1];
        v13_1 = -1;
        v6 = v4_2 != v13_1 || v34[0] != v13_1 || v34[v16] != v13_1 || v34[v21] != v13_1 ? Math.max(v12_1, Math.max(v34[v21], Math.max(v34[0], Math.max(v4_2, v34[v16]))) + Math.max(v28[v21], Math.max(v28[0], Math.max(v28[1], v28[v16])))) : v12_1;
        if(v27_1) {
            v4_2 = v33;
            if(v4_2 == 0x80000000 || v4_2 == 0) {
                v0.mTotalLength = 0;
                v7_1 = 0;
                goto label_321;
            }

            goto label_316;
        }
        else {
            v32 = v5;
            v4_2 = v33;
            goto label_365;
        label_321:
            while(v7_1 < v2_2) {
                View v9_1 = v0.getVirtualChildAt(v7_1);
                if(v9_1 == null) {
                    v0.mTotalLength += v0.measureNullChild(v7_1);
                    goto label_334;
                }
                else if(v9_1.getVisibility() == 8) {
                    v7_1 += v0.getChildrenSkipCount(v9_1, v7_1);
                label_334:
                    v32 = v5;
                }
                else {
                    ViewGroup$LayoutParams v12_2 = v9_1.getLayoutParams();
                    v13_1 = v0.mTotalLength;
                    if(v18 != 0) {
                        v32 = v5;
                        v0.mTotalLength = v13_1 + (((LayoutParams)v12_2).leftMargin + v15 + ((LayoutParams)v12_2).rightMargin + v0.getNextLocationOffset(v9_1));
                    }
                    else {
                        v32 = v5;
                        v0.mTotalLength = Math.max(v13_1, v13_1 + v15 + ((LayoutParams)v12_2).leftMargin + ((LayoutParams)v12_2).rightMargin + v0.getNextLocationOffset(v9_1));
                    }
                }

                ++v7_1;
                v5 = v32;
            }

        label_316:
            v32 = v5;
        }

    label_365:
        v5_1 = v0.mTotalLength + (v0.getPaddingLeft() + v0.getPaddingRight());
        v0.mTotalLength = v5_1;
        v5_1 = View.resolveSizeAndState(Math.max(v5_1, v0.getSuggestedMinimumWidth()), v3, 0);
        v7_1 = (0xFFFFFF & v5_1) - v0.mTotalLength;
        if(v22 == 0) {
            if(v7_1 != 0 && v32 > 0f) {
                goto label_409;
            }

            v7_1 = Math.max(v11, v14);
            if((v27_1) && v4_2 != 0x40000000) {
                for(v4_2 = 0; v4_2 < v2_2; ++v4_2) {
                    View v11_1 = v0.getVirtualChildAt(v4_2);
                    if(v11_1 != null) {
                        if(v11_1.getVisibility() == 8) {
                        }
                        else if(v11_1.getLayoutParams().weight > 0f) {
                            v11_1.measure(View$MeasureSpec.makeMeasureSpec(v15, 0x40000000), View$MeasureSpec.makeMeasureSpec(v11_1.getMeasuredHeight(), 0x40000000));
                        }
                    }
                }
            }

            v27 = v5_1;
            v22 = 0xFF000000;
        }
        else {
        label_409:
            float v6_2 = v0.mWeightSum;
            if(v6_2 > 0f) {
                v32 = v6_2;
            }

            v34[v21] = -1;
            v34[v16] = -1;
            v34[1] = -1;
            v34[0] = -1;
            v28[v21] = -1;
            v28[v16] = -1;
            v28[1] = -1;
            v28[0] = -1;
            v0.mTotalLength = 0;
            v6 = -1;
            v12_1 = 0;
            while(v12_1 < v2_2) {
                View v13_2 = v0.getVirtualChildAt(v12_1);
                if(v13_2 == null || v13_2.getVisibility() == 8) {
                    v27 = v5_1;
                }
                else {
                    ViewGroup$LayoutParams v14_1 = v13_2.getLayoutParams();
                    v22 = 0xFF000000;
                    float v9_2 = ((LayoutParams)v14_1).weight;
                    if(v9_2 > 0f) {
                        v15 = ((int)((((float)v7_1)) * v9_2 / v32));
                        v32 -= v9_2;
                        v7_1 -= v15;
                        v27 = v5_1;
                        v5_1 = LinearLayoutCompat.getChildMeasureSpec(v1_3, v0.getPaddingTop() + v0.getPaddingBottom() + ((LayoutParams)v14_1).topMargin + ((LayoutParams)v14_1).bottomMargin, ((LayoutParams)v14_1).height);
                        if(((LayoutParams)v14_1).width == 0) {
                            v9 = 0x40000000;
                            if(v4_2 != v9) {
                                goto label_464;
                            }
                            else {
                                if(v15 > 0) {
                                }
                                else {
                                    v15 = 0;
                                }

                                v13_2.measure(View$MeasureSpec.makeMeasureSpec(v15, v9), v5_1);
                            }
                        }
                        else {
                            v9 = 0x40000000;
                        label_464:
                            v15 = v13_2.getMeasuredWidth() + v15;
                            if(v15 < 0) {
                                v15 = 0;
                            }

                            v13_2.measure(View$MeasureSpec.makeMeasureSpec(v15, v9), v5_1);
                        }

                        v8 = View.combineMeasuredStates(v8, v13_2.getMeasuredState() & v22);
                    }
                    else {
                        v27 = v5_1;
                    }

                    v5_1 = v0.mTotalLength;
                    v0.mTotalLength = v18 != 0 ? v5_1 + (v13_2.getMeasuredWidth() + ((LayoutParams)v14_1).leftMargin + ((LayoutParams)v14_1).rightMargin + v0.getNextLocationOffset(v13_2)) : Math.max(v5_1, v13_2.getMeasuredWidth() + v5_1 + ((LayoutParams)v14_1).leftMargin + ((LayoutParams)v14_1).rightMargin + v0.getNextLocationOffset(v13_2));
                    v5_1 = v10 == 0x40000000 || ((LayoutParams)v14_1).height != -1 ? 0 : 1;
                    v9 = ((LayoutParams)v14_1).topMargin + ((LayoutParams)v14_1).bottomMargin;
                    v15 = v13_2.getMeasuredHeight() + v9;
                    v6 = Math.max(v6, v15);
                    if(v5_1 != 0) {
                    }
                    else {
                        v9 = v15;
                    }

                    v5_1 = Math.max(v11, v9);
                    if(v25 != 0) {
                        v11 = -1;
                        if(((LayoutParams)v14_1).height == v11) {
                            v9 = 1;
                        }
                        else {
                            goto label_522;
                        }
                    }
                    else {
                        v11 = -1;
                    label_522:
                        v9 = 0;
                    }

                    if(v30) {
                        v13_1 = v13_2.getBaseline();
                        if(v13_1 != v11) {
                            v11 = ((LayoutParams)v14_1).gravity < 0 ? v0.mGravity : ((LayoutParams)v14_1).gravity;
                            v11 = ((v11 & 0x70) >> 4 & -2) >> 1;
                            v34[v11] = Math.max(v34[v11], v13_1);
                            v28[v11] = Math.max(v28[v11], v15 - v13_1);
                        }
                    }

                    v11 = v5_1;
                    v25 = v9;
                }

                ++v12_1;
                v5_1 = v27;
            }

            v27 = v5_1;
            v22 = 0xFF000000;
            v0.mTotalLength += v0.getPaddingLeft() + v0.getPaddingRight();
            v4_2 = v34[1];
            v13_1 = -1;
            if(v4_2 != v13_1 || v34[0] != v13_1 || v34[v16] != v13_1 || v34[v21] != v13_1) {
                v6 = Math.max(v6, Math.max(v34[v21], Math.max(v34[0], Math.max(v4_2, v34[v16]))) + Math.max(v28[v21], Math.max(v28[0], Math.max(v28[1], v28[v16]))));
            }

            v7_1 = v11;
        }

        v24 = v8;
        if(v25 == 0 && v10 != 0x40000000) {
            v6 = v7_1;
        }

        v0.setMeasuredDimension(v27 | v24 & v22, View.resolveSizeAndState(Math.max(v6 + (v0.getPaddingTop() + v0.getPaddingBottom()), v0.getSuggestedMinimumHeight()), v1_3, v24 << 16));
        if(v26 != 0) {
            v0.forceUniformHeight(v2_2, v3);
        }
    }

    int measureNullChild(int arg1) {
        return 0;
    }

    void measureVertical(int arg28, int arg29) {
        int v23;
        int v12_1;
        int v13_1;
        int v1_2;
        boolean v25;
        int v24;
        int v26;
        int v22;
        float v21;
        int v14;
        int v7;
        LinearLayoutCompat v0 = this;
        v0.mTotalLength = 0;
        int v8 = v0.getVirtualChildCount();
        int v9 = View$MeasureSpec.getMode(arg28);
        int v10 = View$MeasureSpec.getMode(arg29);
        int v11 = v0.mBaselineAlignedChildIndex;
        boolean v12 = v0.mUseLargestChild;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v15 = 0;
        int v16 = 0;
        int v18 = 0;
        float v1 = 0f;
        int v17 = 1;
        while(true) {
            v7 = 8;
            v14 = 0x40000000;
            if(v2 >= v8) {
                break;
            }

            v21 = v1;
            View v1_1 = v0.getVirtualChildAt(v2);
            if(v1_1 == null) {
                v0.mTotalLength += v0.measureNullChild(v2);
                goto label_30;
            }
            else if(v1_1.getVisibility() == v7) {
                v2 += v0.getChildrenSkipCount(v1_1, v2);
            label_30:
                v22 = v4;
                v26 = v8;
                v24 = v10;
                v25 = v12;
                v1 = v21;
                v4 = v3;
                v10 = v5;
            }
            else {
                if(v0.hasDividerBeforeChildAt(v2)) {
                    v0.mTotalLength += v0.mDividerHeight;
                }

                ViewGroup$LayoutParams v7_1 = v1_1.getLayoutParams();
                float v13 = v21 + ((LayoutParams)v7_1).weight;
                if(v10 != v14 || ((LayoutParams)v7_1).height != 0 || ((LayoutParams)v7_1).weight <= 0f) {
                    View v24_1 = v1_1;
                    if(((LayoutParams)v7_1).height != 0 || ((LayoutParams)v7_1).weight <= 0f) {
                        v14 = 0x80000000;
                    }
                    else {
                        ((LayoutParams)v7_1).height = -2;
                        v14 = 0;
                    }

                    if(v13 == 0f) {
                        int v21_1 = v6;
                        v6 = v0.mTotalLength;
                        v1_2 = v21_1;
                    }
                    else {
                        v1_2 = v6;
                        v6 = 0;
                    }

                    v21 = v13;
                    v13_1 = v4;
                    v26 = v8;
                    v25 = v12;
                    v8 = v1_2;
                    v12_1 = v3;
                    v1_1 = v24_1;
                    v24 = v10;
                    v10 = v5;
                    v0.measureChildBeforeLayout(v1_1, v2, arg28, 0, arg29, v6);
                    if(v14 != 0x80000000) {
                        ((LayoutParams)v7_1).height = v14;
                    }

                    v4 = v1_1.getMeasuredHeight();
                    v0.mTotalLength = Math.max(v0.mTotalLength, v0.mTotalLength + v4 + ((LayoutParams)v7_1).topMargin + ((LayoutParams)v7_1).bottomMargin + v0.getNextLocationOffset(v1_1));
                    if(v25) {
                        v4 = Math.max(v4, v13_1);
                        goto label_133;
                    }

                    v4 = v13_1;
                }
                else {
                    v0.mTotalLength = Math.max(v0.mTotalLength, ((LayoutParams)v7_1).topMargin + v0.mTotalLength + ((LayoutParams)v7_1).bottomMargin);
                    v26 = v8;
                    v25 = v12;
                    v21 = v13;
                    v16 = 1;
                    v1_1 = v1_1;
                    v12_1 = v3;
                    v8 = v6;
                    v24 = v10;
                    v10 = v5;
                }

            label_133:
                if(v11 >= 0 && v11 == v2 + 1) {
                    v0.mBaselineChildTop = v0.mTotalLength;
                }

                if(v2 < v11) {
                    if(((LayoutParams)v7_1).weight <= 0f) {
                    }
                    else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won\'t work.  Either remove the weight, or don\'t set mBaselineAlignedChildIndex.");
                    }
                }

                if(v9 == 0x40000000 || ((LayoutParams)v7_1).width != -1) {
                    v6 = 0;
                }
                else {
                    v6 = 1;
                    v18 = 1;
                }

                v13_1 = ((LayoutParams)v7_1).leftMargin + ((LayoutParams)v7_1).rightMargin;
                v14 = v1_1.getMeasuredWidth() + v13_1;
                v10 = Math.max(v10, v14);
                v22 = v4;
                v4 = View.combineMeasuredStates(v8, v1_1.getMeasuredState());
                if(v17 != 0) {
                    v23 = v4;
                    if(((LayoutParams)v7_1).width == -1) {
                        v17 = 1;
                    }
                    else {
                        goto label_172;
                    }
                }
                else {
                    v23 = v4;
                label_172:
                    v17 = 0;
                }

                if(((LayoutParams)v7_1).weight > 0f) {
                    if(v6 != 0) {
                    }
                    else {
                        v13_1 = v14;
                    }

                    v4 = Math.max(v12_1, v13_1);
                }
                else {
                    if(v6 != 0) {
                    }
                    else {
                        v13_1 = v14;
                    }

                    v15 = Math.max(v15, v13_1);
                    v4 = v12_1;
                }

                v2 += v0.getChildrenSkipCount(v1_1, v2);
                v1 = v21;
                v6 = v23;
            }

            ++v2;
            v3 = v4;
            v5 = v10;
            v4 = v22;
            v10 = v24;
            v12 = v25;
            v8 = v26;
        }

        v21 = v1;
        v13_1 = v4;
        v26 = v8;
        v24 = v10;
        v25 = v12;
        v12_1 = v3;
        v10 = v5;
        v8 = v6;
        v3 = arg28;
        v5 = arg29;
        if(v0.mTotalLength > 0) {
            v1_2 = v26;
            if(v0.hasDividerBeforeChildAt(v1_2)) {
                v0.mTotalLength += v0.mDividerHeight;
            }
        }
        else {
            v1_2 = v26;
        }

        v2 = v24;
        if((v25) && (v2 == 0x80000000 || v2 == 0)) {
            v0.mTotalLength = 0;
            v4 = 0;
            while(v4 < v1_2) {
                View v6_1 = v0.getVirtualChildAt(v4);
                if(v6_1 == null) {
                    v0.mTotalLength += v0.measureNullChild(v4);
                }
                else if(v6_1.getVisibility() == v7) {
                    v4 += v0.getChildrenSkipCount(v6_1, v4);
                }
                else {
                    ViewGroup$LayoutParams v11_1 = v6_1.getLayoutParams();
                    v0.mTotalLength = Math.max(v0.mTotalLength, v0.mTotalLength + v13_1 + ((LayoutParams)v11_1).topMargin + ((LayoutParams)v11_1).bottomMargin + v0.getNextLocationOffset(v6_1));
                }

                ++v4;
                v7 = 8;
            }
        }

        v4 = v0.mTotalLength + (v0.getPaddingTop() + v0.getPaddingBottom());
        v0.mTotalLength = v4;
        v4 = View.resolveSizeAndState(Math.max(v4, v0.getSuggestedMinimumHeight()), v5, 0);
        v6 = (0xFFFFFF & v4) - v0.mTotalLength;
        if(v16 == 0) {
            if(v6 != 0 && v21 > 0f) {
                goto label_294;
            }

            v6 = Math.max(v15, v12_1);
            if(!v25) {
                goto label_398;
            }

            if(v2 == 0x40000000) {
                goto label_398;
            }

            for(v7 = 0; v7 < v1_2; ++v7) {
                View v2_1 = v0.getVirtualChildAt(v7);
                if(v2_1 != null) {
                    if(v2_1.getVisibility() == 8) {
                    }
                    else if(v2_1.getLayoutParams().weight > 0f) {
                        v2_1.measure(View$MeasureSpec.makeMeasureSpec(v2_1.getMeasuredWidth(), 0x40000000), View$MeasureSpec.makeMeasureSpec(v13_1, 0x40000000));
                    }
                }
            }
        }
        else {
        label_294:
            float v7_2 = v0.mWeightSum;
            if(v7_2 > 0f) {
                v21 = v7_2;
            }

            v0.mTotalLength = 0;
            v11 = v6;
            v6 = 0;
            while(v6 < v1_2) {
                View v12_2 = v0.getVirtualChildAt(v6);
                if(v12_2.getVisibility() == 8) {
                    v22 = v2;
                    v16 = v6;
                }
                else {
                    ViewGroup$LayoutParams v13_2 = v12_2.getLayoutParams();
                    v7_2 = ((LayoutParams)v13_2).weight;
                    if(v7_2 > 0f) {
                        v14 = ((int)((((float)v11)) * v7_2 / v21));
                        v21 -= v7_2;
                        v11 -= v14;
                        v16 = v6;
                        v6 = LinearLayoutCompat.getChildMeasureSpec(v3, v0.getPaddingLeft() + v0.getPaddingRight() + ((LayoutParams)v13_2).leftMargin + ((LayoutParams)v13_2).rightMargin, ((LayoutParams)v13_2).width);
                        if(((LayoutParams)v13_2).height == 0) {
                            v7 = 0x40000000;
                            if(v2 != v7) {
                                goto label_340;
                            }
                            else {
                                if(v14 > 0) {
                                }
                                else {
                                    v14 = 0;
                                }

                                v12_2.measure(v6, View$MeasureSpec.makeMeasureSpec(v14, v7));
                            }
                        }
                        else {
                            v7 = 0x40000000;
                        label_340:
                            v14 = v12_2.getMeasuredHeight() + v14;
                            if(v14 < 0) {
                                v14 = 0;
                            }

                            v12_2.measure(v6, View$MeasureSpec.makeMeasureSpec(v14, v7));
                        }

                        v8 = View.combineMeasuredStates(v8, v12_2.getMeasuredState() & 0xFFFFFF00);
                    }
                    else {
                        v16 = v6;
                    }

                    v6 = ((LayoutParams)v13_2).leftMargin + ((LayoutParams)v13_2).rightMargin;
                    v7 = v12_2.getMeasuredWidth() + v6;
                    v10 = Math.max(v10, v7);
                    if(v9 != 0x40000000) {
                        v22 = v2;
                        v2 = -1;
                        if(((LayoutParams)v13_2).width == v2) {
                        }
                        else {
                            goto label_366;
                        }
                    }
                    else {
                        v22 = v2;
                        v2 = -1;
                    label_366:
                        v6 = v7;
                    }

                    v6 = Math.max(v15, v6);
                    v7 = v17 == 0 || ((LayoutParams)v13_2).width != v2 ? 0 : 1;
                    v0.mTotalLength = Math.max(v0.mTotalLength, v12_2.getMeasuredHeight() + v0.mTotalLength + ((LayoutParams)v13_2).topMargin + ((LayoutParams)v13_2).bottomMargin + v0.getNextLocationOffset(v12_2));
                    v15 = v6;
                    v17 = v7;
                }

                v6 = v16 + 1;
                v2 = v22;
            }

            v0.mTotalLength += v0.getPaddingTop() + v0.getPaddingBottom();
            v6 = v15;
        }

    label_398:
        if(v17 == 0 && v9 != 0x40000000) {
            v10 = v6;
        }

        v0.setMeasuredDimension(View.resolveSizeAndState(Math.max(v10 + (v0.getPaddingLeft() + v0.getPaddingRight()), v0.getSuggestedMinimumWidth()), v3, v8), v4);
        if(v18 != 0) {
            v0.forceUniformWidth(v1_2, v5);
        }
    }

    protected void onDraw(Canvas arg3) {
        if(this.mDivider == null) {
            return;
        }

        if(this.mOrientation == 1) {
            this.drawDividersVertical(arg3);
            return;
        }

        this.drawDividersHorizontal(arg3);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg1) {
        super.onInitializeAccessibilityEvent(arg1);
        arg1.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
        super.onInitializeAccessibilityNodeInfo(arg1);
        arg1.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    protected void onLayout(boolean arg2, int arg3, int arg4, int arg5, int arg6) {
        if(this.mOrientation == 1) {
            this.layoutVertical(arg3, arg4, arg5, arg6);
            return;
        }

        this.layoutHorizontal(arg3, arg4, arg5, arg6);
    }

    protected void onMeasure(int arg3, int arg4) {
        if(this.mOrientation == 1) {
            this.measureVertical(arg3, arg4);
            return;
        }

        this.measureHorizontal(arg3, arg4);
    }

    public void setBaselineAligned(boolean arg1) {
        this.mBaselineAligned = arg1;
    }

    public void setBaselineAlignedChildIndex(int arg3) {
        if(arg3 >= 0 && arg3 < this.getChildCount()) {
            this.mBaselineAlignedChildIndex = arg3;
            return;
        }

        throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
    }

    private void setChildFrame(View arg1, int arg2, int arg3, int arg4, int arg5) {
        arg1.layout(arg2, arg3, arg4 + arg2, arg5 + arg3);
    }

    public void setDividerDrawable(Drawable arg3) {
        if(arg3 == this.mDivider) {
            return;
        }

        this.mDivider = arg3;
        boolean v0 = false;
        if(arg3 != null) {
            this.mDividerWidth = arg3.getIntrinsicWidth();
            this.mDividerHeight = arg3.getIntrinsicHeight();
        }
        else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }

        if(arg3 == null) {
            v0 = true;
        }

        this.setWillNotDraw(v0);
        this.requestLayout();
    }

    public void setDividerPadding(int arg1) {
        this.mDividerPadding = arg1;
    }

    public void setGravity(int arg2) {
        if(this.mGravity != arg2) {
            if((0x800007 & arg2) == 0) {
                arg2 |= 0x800003;
            }

            if((arg2 & 0x70) == 0) {
                arg2 |= 0x30;
            }

            this.mGravity = arg2;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int arg3) {
        arg3 &= 0x800007;
        int v1 = this.mGravity;
        if((0x800007 & v1) != arg3) {
            this.mGravity = arg3 | 0xFF7FFFF8 & v1;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean arg1) {
        this.mUseLargestChild = arg1;
    }

    public void setOrientation(int arg2) {
        if(this.mOrientation != arg2) {
            this.mOrientation = arg2;
            this.requestLayout();
        }
    }

    public void setShowDividers(int arg2) {
        if(arg2 != this.mShowDividers) {
            this.requestLayout();
        }

        this.mShowDividers = arg2;
    }

    public void setVerticalGravity(int arg3) {
        arg3 &= 0x70;
        int v0 = this.mGravity;
        if((v0 & 0x70) != arg3) {
            this.mGravity = arg3 | v0 & 0xFFFFFF8F;
            this.requestLayout();
        }
    }

    public void setWeightSum(float arg2) {
        this.mWeightSum = Math.max(0f, arg2);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

