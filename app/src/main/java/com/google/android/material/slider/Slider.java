package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.google.android.material.R$attr;

public class Slider extends BaseSlider {
    public interface OnChangeListener extends BaseOnChangeListener {
        void onValueChange(Slider arg1, float arg2, boolean arg3);

        default void onValueChange(Object arg1, float arg2, boolean arg3) {
            this.onValueChange(((Slider)arg1), arg2, arg3);
        }
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener {
        void onStartTrackingTouch(Slider arg1);

        default void onStartTrackingTouch(Object arg1) {
            this.onStartTrackingTouch(((Slider)arg1));
        }

        void onStopTrackingTouch(Slider arg1);

        default void onStopTrackingTouch(Object arg1) {
            this.onStopTrackingTouch(((Slider)arg1));
        }
    }

    public Slider(Context arg2) {
        this(arg2, null);
    }

    public Slider(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.sliderStyle);
    }

    public Slider(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, new int[]{0x1010024});
        if(v1.hasValue(0)) {
            this.setValue(v1.getFloat(0, 0f));
        }

        v1.recycle();
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

    public float getValue() {
        return this.getValues().get(0).floatValue();
    }

    public float getValueFrom() {
        return super.getValueFrom();
    }

    public float getValueTo() {
        return super.getValueTo();
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

    public boolean onTouchEvent(MotionEvent arg1) {
        return super.onTouchEvent(arg1);
    }

    protected boolean pickActiveThumb() {
        if(this.getActiveThumbIndex() != -1) {
            return 1;
        }

        this.setActiveThumbIndex(0);
        return 1;
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

    public void setValue(float arg3) {
        this.setValues(new Float[]{Float.valueOf(arg3)});
    }

    public void setValueFrom(float arg1) {
        super.setValueFrom(arg1);
    }

    public void setValueTo(float arg1) {
        super.setValueTo(arg1);
    }
}

