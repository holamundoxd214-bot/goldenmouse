package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public class DrawableAlphaProperty extends Property {
    public static final Property DRAWABLE_ALPHA_COMPAT;
    private final WeakHashMap alphaCache;

    static {
        DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    }

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.alphaCache = new WeakHashMap();
    }

    public Integer get(Drawable arg1) {
        return Integer.valueOf(arg1.getAlpha());
    }

    public Object get(Object arg1) {
        return this.get(((Drawable)arg1));
    }

    public void set(Drawable arg1, Integer arg2) {
        arg1.setAlpha(arg2.intValue());
    }

    public void set(Object arg1, Object arg2) {
        this.set(((Drawable)arg1), ((Integer)arg2));
    }
}

