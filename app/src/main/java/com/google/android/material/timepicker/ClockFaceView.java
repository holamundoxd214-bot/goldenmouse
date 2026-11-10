package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;

class ClockFaceView extends RadialViewGroup implements OnRotateListener {
    private static final float EPSILON = 0.001f;
    private static final int INITIAL_CAPACITY = 12;
    private static final String VALUE_PLACEHOLDER = "";
    private final int clockHandPadding;
    private final ClockHandView clockHandView;
    private final int clockSize;
    private float currentHandRotation;
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private final int minimumHeight;
    private final int minimumWidth;
    private final RectF scratch;
    private final Rect scratchLineBounds;
    private final ColorStateList textColor;
    private final SparseArray textViewPool;
    private final Rect textViewRect;
    private final AccessibilityDelegateCompat valueAccessibilityDelegate;
    private String[] values;

    public ClockFaceView(Context arg2) {
        this(arg2, null);
    }

    public ClockFaceView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialClockStyle);
    }

    public ClockFaceView(Context arg6, AttributeSet arg7, int arg8) {
        super(arg6, arg7, arg8);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.scratchLineBounds = new Rect();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0f, 0.9f, 1f};
        TypedArray v7 = arg6.obtainStyledAttributes(arg7, styleable.ClockFaceView, arg8, style.Widget_MaterialComponents_TimePicker_Clock);
        Resources v8 = this.getResources();
        ColorStateList v0 = MaterialResources.getColorStateList(arg6, v7, styleable.ClockFaceView_clockNumberTextColor);
        this.textColor = v0;
        LayoutInflater.from(arg6).inflate(layout.material_clockface_view, ((ViewGroup)this), true);
        View v1 = this.findViewById(id.material_clock_hand);
        this.clockHandView = ((ClockHandView)v1);
        this.clockHandPadding = v8.getDimensionPixelSize(dimen.material_clock_hand_padding);
        int v2 = v0.getColorForState(new int[]{0x10100A1}, v0.getDefaultColor());
        this.gradientColors = new int[]{v2, v2, v0.getDefaultColor()};
        ((ClockHandView)v1).addOnRotateListener(((OnRotateListener)this));
        int v0_1 = AppCompatResources.getColorStateList(arg6, color.material_timepicker_clockface).getDefaultColor();
        ColorStateList v6 = MaterialResources.getColorStateList(arg6, v7, styleable.ClockFaceView_clockFaceBackgroundColor);
        if(v6 == null) {
        }
        else {
            v0_1 = v6.getDefaultColor();
        }

        this.setBackgroundColor(v0_1);
        this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListener() {
            public boolean onPreDraw() {
                if(!ClockFaceView.this.isShown()) {
                    return 1;
                }

                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
                ClockFaceView.this.setRadius(ClockFaceView.this.getHeight() / 2 - ClockFaceView.access$000(ClockFaceView.this).getSelectorRadius() - ClockFaceView.access$100(ClockFaceView.this));
                return 1;
            }
        });
        this.setFocusable(true);
        v7.recycle();
        this.valueAccessibilityDelegate = new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg8, AccessibilityNodeInfoCompat arg9) {
                super.onInitializeAccessibilityNodeInfo(arg8, arg9);
                int v3 = arg8.getTag(id.material_value_index).intValue();
                if(v3 > 0) {
                    arg9.setTraversalAfter(ClockFaceView.access$200(ClockFaceView.this).get(v3 - 1));
                }

                arg9.setCollectionItemInfo(CollectionItemInfoCompat.obtain(0, 1, v3, 1, false, arg8.isSelected()));
                arg9.setClickable(true);
                arg9.addAction(AccessibilityActionCompat.ACTION_CLICK);
            }

            public boolean performAccessibilityAction(View arg10, int arg11, Bundle arg12) {
                if(arg11 == 16) {
                    long v1 = SystemClock.uptimeMillis();
                    arg10.getHitRect(ClockFaceView.access$300(ClockFaceView.this));
                    float v6 = ((float)ClockFaceView.access$300(ClockFaceView.this).centerX());
                    float v7 = ((float)ClockFaceView.access$300(ClockFaceView.this).centerY());
                    ClockFaceView.access$000(ClockFaceView.this).onTouchEvent(MotionEvent.obtain(v1, v1, 0, v6, v7, 0));
                    ClockFaceView.access$000(ClockFaceView.this).onTouchEvent(MotionEvent.obtain(v1, v1, 1, v6, v7, 0));
                    return 1;
                }

                return super.performAccessibilityAction(arg10, arg11, arg12);
            }
        };
        String[] v6_1 = new String[12];
        Arrays.fill(((Object[])v6_1), "");
        this.setValues(v6_1, 0);
        this.minimumHeight = v8.getDimensionPixelSize(dimen.material_time_picker_minimum_screen_height);
        this.minimumWidth = v8.getDimensionPixelSize(dimen.material_time_picker_minimum_screen_width);
        this.clockSize = v8.getDimensionPixelSize(dimen.material_clock_size);
    }

    static ClockHandView access$000(ClockFaceView arg0) {
        return arg0.clockHandView;
    }

    static int access$100(ClockFaceView arg0) {
        return arg0.clockHandPadding;
    }

    static SparseArray access$200(ClockFaceView arg0) {
        return arg0.textViewPool;
    }

    static Rect access$300(ClockFaceView arg0) {
        return arg0.textViewRect;
    }

    private void findIntersectingTextView() {
        RectF v0 = this.clockHandView.getCurrentSelectorBox();
        TextView v1 = this.getSelectedTextView(v0);
        int v3;
        for(v3 = 0; v3 < this.textViewPool.size(); ++v3) {
            Object v4 = this.textViewPool.get(v3);
            if(v4 == null) {
            }
            else {
                boolean v5 = (((TextView)v4)) == v1 ? true : false;
                ((TextView)v4).setSelected(v5);
                ((TextView)v4).getPaint().setShader(this.getGradientForTextView(v0, ((TextView)v4)));
                ((TextView)v4).invalidate();
            }
        }
    }

    int getCurrentLevel() {
        return this.clockHandView.getCurrentLevel();
    }

    private RadialGradient getGradientForTextView(RectF arg8, TextView arg9) {
        arg9.getHitRect(this.textViewRect);
        this.scratch.set(this.textViewRect);
        arg9.getLineBounds(0, this.scratchLineBounds);
        this.scratch.inset(((float)this.scratchLineBounds.left), ((float)this.scratchLineBounds.top));
        if(!RectF.intersects(arg8, this.scratch)) {
            return null;
        }

        return new RadialGradient(arg8.centerX() - this.scratch.left, arg8.centerY() - this.scratch.top, arg8.width() * 0.5f, this.gradientColors, this.gradientPositions, Shader$TileMode.CLAMP);
    }

    private TextView getSelectedTextView(RectF arg7) {
        Object v1_1;
        float v0 = 3.402823E+38f;
        TextView v1 = null;
        int v2;
        for(v2 = 0; v2 < this.textViewPool.size(); ++v2) {
            Object v3 = this.textViewPool.get(v2);
            if(v3 == null) {
            }
            else {
                ((TextView)v3).getHitRect(this.textViewRect);
                this.scratch.set(this.textViewRect);
                this.scratch.union(arg7);
                float v4 = this.scratch.width() * this.scratch.height();
                if(v4 < v0) {
                    v1_1 = v3;
                    v0 = v4;
                }
            }
        }

        return ((TextView)v1_1);
    }

    private static float max3(float arg0, float arg1, float arg2) {
        return Math.max(Math.max(arg0, arg1), arg2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg3) {
        super.onInitializeAccessibilityNodeInfo(arg3);
        AccessibilityNodeInfoCompat.wrap(arg3).setCollectionInfo(CollectionInfoCompat.obtain(1, this.values.length, false, 1));
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        this.findIntersectingTextView();
    }

    protected void onMeasure(int arg3, int arg4) {
        DisplayMetrics v3 = this.getResources().getDisplayMetrics();
        arg3 = ((int)((((float)this.clockSize)) / ClockFaceView.max3((((float)this.minimumHeight)) / (((float)v3.heightPixels)), (((float)this.minimumWidth)) / (((float)v3.widthPixels)), 1f)));
        arg4 = View$MeasureSpec.makeMeasureSpec(arg3, 0x40000000);
        this.setMeasuredDimension(arg3, arg3);
        super.onMeasure(arg4, arg4);
    }

    public void onRotate(float arg2, boolean arg3) {
        if(Math.abs(this.currentHandRotation - arg2) > 0.001f) {
            this.currentHandRotation = arg2;
            this.findIntersectingTextView();
        }
    }

    void setCurrentLevel(int arg1) {
        this.clockHandView.setCurrentLevel(arg1);
    }

    public void setHandRotation(float arg2) {
        this.clockHandView.setHandRotation(arg2);
        this.findIntersectingTextView();
    }

    public void setRadius(int arg2) {
        if(arg2 != this.getRadius()) {
            super.setRadius(arg2);
            this.clockHandView.setCircleRadius(this.getRadius());
        }
    }

    public void setValues(String[] arg1, int arg2) {
        this.values = arg1;
        this.updateTextViews(arg2);
    }

    protected void updateLayoutParams() {
        super.updateLayoutParams();
        int v1;
        for(v1 = 0; v1 < this.textViewPool.size(); ++v1) {
            this.textViewPool.get(v1).setVisibility(0);
        }
    }

    private void updateTextViews(int arg11) {
        LayoutInflater v0 = LayoutInflater.from(this.getContext());
        int v1 = this.textViewPool.size();
        int v3 = 0;
        boolean v4 = false;
        while(v3 < Math.max(this.values.length, v1)) {
            Object v5 = this.textViewPool.get(v3);
            if(v3 >= this.values.length) {
                this.removeView(((View)v5));
                this.textViewPool.remove(v3);
            }
            else {
                if(v5 == null) {
                    View v5_1 = v0.inflate(layout.material_clockface_textview, ((ViewGroup)this), false);
                    this.textViewPool.put(v3, v5_1);
                    this.addView(v5_1);
                }

                ((TextView)v5).setText(this.values[v3]);
                ((TextView)v5).setTag(id.material_value_index, Integer.valueOf(v3));
                int v6 = v3 / 12 + 1;
                ((TextView)v5).setTag(id.material_clock_level, Integer.valueOf(v6));
                if(v6 > 1) {
                    v4 = true;
                }

                ViewCompat.setAccessibilityDelegate(((View)v5), this.valueAccessibilityDelegate);
                ((TextView)v5).setTextColor(this.textColor);
                if(arg11 == 0) {
                    goto label_51;
                }

                ((TextView)v5).setContentDescription(this.getResources().getString(arg11, new Object[]{this.values[v3]}));
            }

        label_51:
            ++v3;
        }

        this.clockHandView.setMultiLevel(v4);
    }
}

