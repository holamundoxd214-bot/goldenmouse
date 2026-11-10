package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;

class RadialViewGroup extends ConstraintLayout {
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final float LEVEL_RADIUS_RATIO = 0.66f;
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context arg2) {
        this(arg2, null);
    }

    public RadialViewGroup(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public RadialViewGroup(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        LayoutInflater.from(arg3).inflate(layout.material_radial_view_group, ((ViewGroup)this));
        ViewCompat.setBackground(((View)this), this.createBackground());
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, styleable.RadialViewGroup, arg5, 0);
        this.radius = v3.getDimensionPixelSize(styleable.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new RadialViewGroup$$ExternalSyntheticLambda0(this);
        v3.recycle();
    }

    private void addConstraints(List arg4, ConstraintSet arg5, int arg6) {
        Iterator v3 = arg4.iterator();
        float v0;
        for(v0 = 0f; v3.hasNext(); v0 += 360f / (((float)arg4.size()))) {
            arg5.constrainCircle(v3.next().getId(), id.circle_center, arg6, v0);
        }
    }

    public void addView(View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        super.addView(arg1, arg2, arg3);
        if(arg1.getId() == -1) {
            arg1.setId(ViewCompat.generateViewId());
        }

        this.updateLayoutParamsAsync();
    }

    private Drawable createBackground() {
        MaterialShapeDrawable v0 = new MaterialShapeDrawable();
        this.background = v0;
        v0.setCornerSize(new RelativeCornerSize(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    int getLeveledRadius(int arg2) {
        int v1 = this.radius;
        if(arg2 == 2) {
            v1 = Math.round((((float)v1)) * 0.66f);
        }

        return v1;
    }

    public int getRadius() {
        return this.radius;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.updateLayoutParams();
    }

    public void onViewRemoved(View arg1) {
        super.onViewRemoved(arg1);
        this.updateLayoutParamsAsync();
    }

    public void setBackgroundColor(int arg1) {
        this.background.setFillColor(ColorStateList.valueOf(arg1));
    }

    public void setRadius(int arg1) {
        this.radius = arg1;
        this.updateLayoutParams();
    }

    private static boolean shouldSkipView(View arg1) {
        return "skip".equals(arg1.getTag());
    }

    protected void updateLayoutParams() {
        Integer v4_1;
        ConstraintSet v0 = new ConstraintSet();
        v0.clone(((ConstraintLayout)this));
        HashMap v1 = new HashMap();
        int v2;
        for(v2 = 0; v2 < this.getChildCount(); ++v2) {
            View v3 = this.getChildAt(v2);
            if(v3.getId() != id.circle_center) {
                if(RadialViewGroup.shouldSkipView(v3)) {
                }
                else {
                    Object v4 = v3.getTag(id.material_clock_level);
                    if(v4 == null) {
                        v4_1 = Integer.valueOf(1);
                    }

                    if(!((Map)v1).containsKey(v4_1)) {
                        ((Map)v1).put(v4_1, new ArrayList());
                    }

                    ((Map)v1).get(v4_1).add(v3);
                }
            }
        }

        Iterator v1_1 = ((Map)v1).entrySet().iterator();
        while(v1_1.hasNext()) {
            Object v2_1 = v1_1.next();
            this.addConstraints(((Map$Entry)v2_1).getValue(), v0, this.getLeveledRadius(((Map$Entry)v2_1).getKey().intValue()));
        }

        v0.applyTo(((ConstraintLayout)this));
    }

    private void updateLayoutParamsAsync() {
        Handler v0 = this.getHandler();
        if(v0 != null) {
            v0.removeCallbacks(this.updateLayoutParametersRunnable);
            v0.post(this.updateLayoutParametersRunnable);
        }
    }
}

