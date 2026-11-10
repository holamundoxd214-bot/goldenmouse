package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
        super();
    }

    public void captureEndValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    private void captureValues(TransitionValues arg2) {
        if((arg2.view instanceof TextView)) {
            arg2.values.put("android:textscale:scale", Float.valueOf(arg2.view.getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup arg5, TransitionValues arg6, TransitionValues arg7) {
        Animator v5 = null;
        if(arg6 != null && arg7 != null && ((arg6.view instanceof TextView))) {
            if(!(arg7.view instanceof TextView)) {
            }
            else {
                View v0 = arg7.view;
                Map v6 = arg6.values;
                Map v7 = arg7.values;
                String v1 = "android:textscale:scale";
                float v3 = 1f;
                float v6_1 = v6.get(v1) != null ? v6.get(v1).floatValue() : v3;
                if(v7.get(v1) != null) {
                    v3 = v7.get(v1).floatValue();
                }

                if(v6_1 == v3) {
                    return v5;
                }

                ValueAnimator v5_1 = ValueAnimator.ofFloat(new float[]{v6_1, v3});
                v5_1.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(((TextView)v0)) {
                    public void onAnimationUpdate(ValueAnimator arg2) {
                        float v2 = arg2.getAnimatedValue().floatValue();
                        this.val$view.setScaleX(v2);
                        this.val$view.setScaleY(v2);
                    }
                });
            }
        }

        return v5;
    }
}

