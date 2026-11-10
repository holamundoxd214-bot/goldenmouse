package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider extends BaseSlider {
    class com.google.android.material.slider.RangeSlider$1 {
    }

    public interface OnChangeListener extends BaseOnChangeListener {
        void onValueChange(RangeSlider arg1, float arg2, boolean arg3);

        default void onValueChange(Object arg1, float arg2, boolean arg3) {
            this.onValueChange(((RangeSlider)arg1), arg2, arg3);
        }
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener {
        void onStartTrackingTouch(RangeSlider arg1);

        default void onStartTrackingTouch(Object arg1) {
            this.onStartTrackingTouch(((RangeSlider)arg1));
        }

        void onStopTrackingTouch(RangeSlider arg1);

        default void onStopTrackingTouch(Object arg1) {
            this.onStopTrackingTouch(((RangeSlider)arg1));
        }
    }

    class RangeSliderState extends AbsSavedState {
        class com.google.android.material.slider.RangeSlider$RangeSliderState$1 implements Parcelable$Creator {
            com.google.android.material.slider.RangeSlider$RangeSliderState$1() {
                super();
            }

            public RangeSliderState createFromParcel(Parcel arg2) {
                return new RangeSliderState(arg2, null);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public RangeSliderState[] newArray(int arg1) {
                return new RangeSliderState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private float minSeparation;
        private int separationUnit;

        static {
            RangeSliderState.CREATOR = new com.google.android.material.slider.RangeSlider$RangeSliderState$1();
        }

        RangeSliderState(Parcelable arg1) {
            super(arg1);
        }

        private RangeSliderState(Parcel arg2) {
            super(arg2.readParcelable(RangeSliderState.class.getClassLoader()));
            this.minSeparation = arg2.readFloat();
            this.separationUnit = arg2.readInt();
        }

        RangeSliderState(Parcel arg1, com.google.android.material.slider.RangeSlider$1 arg2) {
            this(arg1);
        }

        static float access$000(RangeSliderState arg0) {
            return arg0.minSeparation;
        }

        static float access$002(RangeSliderState arg0, float arg1) {
            arg0.minSeparation = arg1;
            return arg1;
        }

        static int access$100(RangeSliderState arg0) {
            return arg0.separationUnit;
        }

        static int access$102(RangeSliderState arg0, int arg1) {
            arg0.separationUnit = arg1;
            return arg1;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeFloat(this.minSeparation);
            arg1.writeInt(this.separationUnit);
        }
    }

    private float minSeparation;
    private int separationUnit;

    public RangeSlider(Context arg2) {
        this(arg2, null);
    }

    public RangeSlider(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.sliderStyle);
    }

    public RangeSlider(Context arg8, AttributeSet arg9, int arg10) {
        super(arg8, arg9, arg10);
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(arg8, arg9, styleable.RangeSlider, arg10, RangeSlider.DEF_STYLE_RES, new int[0]);
        if(v8.hasValue(styleable.RangeSlider_values)) {
            this.setValues(RangeSlider.convertToFloat(v8.getResources().obtainTypedArray(v8.getResourceId(styleable.RangeSlider_values, 0))));
        }

        this.minSeparation = v8.getDimension(styleable.RangeSlider_minSeparation, 0f);
        v8.recycle();
    }

    public void addOnChangeListener(BaseOnChangeListener arg1) {
        super.addOnChangeListener(arg1);
    }

    public void addOnSliderTouchListener(BaseOnSliderTouchListener arg1) {
        super.addOnSliderTouchListener(arg1);
    }

    public void clearOnChangeListeners() {
        super.clearOnChangeListeners();
    }

    public void clearOnSliderTouchListeners() {
        super.clearOnSliderTouchListeners();
    }

    private static List convertToFloat(TypedArray arg3) {
        ArrayList v0 = new ArrayList();
        int v1;
        for(v1 = 0; v1 < arg3.length(); ++v1) {
            ((List)v0).add(Float.valueOf(arg3.getFloat(v1, -1f)));
        }

        return ((List)v0);
    }

    public boolean dispatchHoverEvent(MotionEvent arg1) {
        return super.dispatchHoverEvent(arg1);
    }

    public boolean dispatchKeyEvent(KeyEvent arg1) {
        return super.dispatchKeyEvent(arg1);
    }

    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    public int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    public int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    public int getHaloRadius() {
        return super.getHaloRadius();
    }

    public ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    public int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    public float getMinSeparation() {
        return this.minSeparation;
    }

    public float getStepSize() {
        return super.getStepSize();
    }

    public float getThumbElevation() {
        return super.getThumbElevation();
    }

    public int getThumbRadius() {
        return super.getThumbRadius();
    }

    public ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    public ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    public int getTickActiveRadius() {
        return super.getTickActiveRadius();
    }

    public ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    public int getTickInactiveRadius() {
        return super.getTickInactiveRadius();
    }

    public ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    public ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    public ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    public int getTrackHeight() {
        return super.getTrackHeight();
    }

    public ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    public int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    public ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    public int getTrackWidth() {
        return super.getTrackWidth();
    }

    public float getValueFrom() {
        return super.getValueFrom();
    }

    public float getValueTo() {
        return super.getValueTo();
    }

    public List getValues() {
        return super.getValues();
    }

    public boolean hasLabelFormatter() {
        return super.hasLabelFormatter();
    }

    public boolean isTickVisible() {
        return super.isTickVisible();
    }

    public boolean onKeyDown(int arg1, KeyEvent arg2) {
        return super.onKeyDown(arg1, arg2);
    }

    public boolean onKeyUp(int arg1, KeyEvent arg2) {
        return super.onKeyUp(arg1, arg2);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        super.onRestoreInstanceState(((RangeSliderState)arg2).getSuperState());
        this.minSeparation = RangeSliderState.access$000(((RangeSliderState)arg2));
        int v2 = RangeSliderState.access$100(((RangeSliderState)arg2));
        this.separationUnit = v2;
        this.setSeparationUnit(v2);
    }

    public Parcelable onSaveInstanceState() {
        RangeSliderState v1 = new RangeSliderState(super.onSaveInstanceState());
        RangeSliderState.access$002(v1, this.minSeparation);
        RangeSliderState.access$102(v1, this.separationUnit);
        return ((Parcelable)v1);
    }

    public boolean onTouchEvent(MotionEvent arg1) {
        return super.onTouchEvent(arg1);
    }

    public void removeOnChangeListener(BaseOnChangeListener arg1) {
        super.removeOnChangeListener(arg1);
    }

    public void removeOnSliderTouchListener(BaseOnSliderTouchListener arg1) {
        super.removeOnSliderTouchListener(arg1);
    }

    public void setCustomThumbDrawable(int arg1) {
        super.setCustomThumbDrawable(arg1);
    }

    public void setCustomThumbDrawable(Drawable arg1) {
        super.setCustomThumbDrawable(arg1);
    }

    public void setCustomThumbDrawablesForValues(int[] arg1) {
        super.setCustomThumbDrawablesForValues(arg1);
    }

    public void setCustomThumbDrawablesForValues(Drawable[] arg1) {
        super.setCustomThumbDrawablesForValues(arg1);
    }

    public void setEnabled(boolean arg1) {
        super.setEnabled(arg1);
    }

    public void setFocusedThumbIndex(int arg1) {
        super.setFocusedThumbIndex(arg1);
    }

    public void setHaloRadius(int arg1) {
        super.setHaloRadius(arg1);
    }

    public void setHaloRadiusResource(int arg1) {
        super.setHaloRadiusResource(arg1);
    }

    public void setHaloTintList(ColorStateList arg1) {
        super.setHaloTintList(arg1);
    }

    public void setLabelBehavior(int arg1) {
        super.setLabelBehavior(arg1);
    }

    public void setLabelFormatter(LabelFormatter arg1) {
        super.setLabelFormatter(arg1);
    }

    public void setMinSeparation(float arg1) {
        this.minSeparation = arg1;
        this.separationUnit = 0;
        this.setSeparationUnit(0);
    }

    public void setMinSeparationValue(float arg1) {
        this.minSeparation = arg1;
        this.separationUnit = 1;
        this.setSeparationUnit(1);
    }

    public void setStepSize(float arg1) {
        super.setStepSize(arg1);
    }

    public void setThumbElevation(float arg1) {
        super.setThumbElevation(arg1);
    }

    public void setThumbElevationResource(int arg1) {
        super.setThumbElevationResource(arg1);
    }

    public void setThumbRadius(int arg1) {
        super.setThumbRadius(arg1);
    }

    public void setThumbRadiusResource(int arg1) {
        super.setThumbRadiusResource(arg1);
    }

    public void setThumbStrokeColor(ColorStateList arg1) {
        super.setThumbStrokeColor(arg1);
    }

    public void setThumbStrokeColorResource(int arg1) {
        super.setThumbStrokeColorResource(arg1);
    }

    public void setThumbStrokeWidth(float arg1) {
        super.setThumbStrokeWidth(arg1);
    }

    public void setThumbStrokeWidthResource(int arg1) {
        super.setThumbStrokeWidthResource(arg1);
    }

    public void setThumbTintList(ColorStateList arg1) {
        super.setThumbTintList(arg1);
    }

    public void setTickActiveRadius(int arg1) {
        super.setTickActiveRadius(arg1);
    }

    public void setTickActiveTintList(ColorStateList arg1) {
        super.setTickActiveTintList(arg1);
    }

    public void setTickInactiveRadius(int arg1) {
        super.setTickInactiveRadius(arg1);
    }

    public void setTickInactiveTintList(ColorStateList arg1) {
        super.setTickInactiveTintList(arg1);
    }

    public void setTickTintList(ColorStateList arg1) {
        super.setTickTintList(arg1);
    }

    public void setTickVisible(boolean arg1) {
        super.setTickVisible(arg1);
    }

    public void setTrackActiveTintList(ColorStateList arg1) {
        super.setTrackActiveTintList(arg1);
    }

    public void setTrackHeight(int arg1) {
        super.setTrackHeight(arg1);
    }

    public void setTrackInactiveTintList(ColorStateList arg1) {
        super.setTrackInactiveTintList(arg1);
    }

    public void setTrackTintList(ColorStateList arg1) {
        super.setTrackTintList(arg1);
    }

    public void setValueFrom(float arg1) {
        super.setValueFrom(arg1);
    }

    public void setValueTo(float arg1) {
        super.setValueTo(arg1);
    }

    public void setValues(List arg1) {
        super.setValues(arg1);
    }

    public void setValues(Float[] arg1) {
        super.setValues(arg1);
    }
}

