package com.google.android.material.floatingactionbutton;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;
    private MotionSpec defaultMotionSpec;
    private final ExtendedFloatingActionButton fab;
    private final ArrayList listeners;
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    BaseMotionStrategy(ExtendedFloatingActionButton arg2, AnimatorTracker arg3) {
        super();
        this.listeners = new ArrayList();
        this.fab = arg2;
        this.context = arg2.getContext();
        this.tracker = arg3;
    }

    static ExtendedFloatingActionButton access$000(BaseMotionStrategy arg0) {
        return arg0.fab;
    }

    public final void addAnimationListener(Animator$AnimatorListener arg1) {
        this.listeners.add(arg1);
    }

    public AnimatorSet createAnimator() {
        return this.createAnimator(this.getCurrentMotionSpec());
    }

    AnimatorSet createAnimator(MotionSpec arg7) {
        ArrayList v0 = new ArrayList();
        String v1 = "opacity";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, View.ALPHA));
        }

        v1 = "scale";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, View.SCALE_Y));
            ((List)v0).add(arg7.getAnimator(v1, this.fab, View.SCALE_X));
        }

        v1 = "width";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, ExtendedFloatingActionButton.WIDTH));
        }

        v1 = "height";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, ExtendedFloatingActionButton.HEIGHT));
        }

        v1 = "paddingStart";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, ExtendedFloatingActionButton.PADDING_START));
        }

        v1 = "paddingEnd";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, ExtendedFloatingActionButton.PADDING_END));
        }

        v1 = "labelOpacity";
        if(arg7.hasPropertyValues(v1)) {
            ((List)v0).add(arg7.getAnimator(v1, this.fab, new Property(Float.class, "LABEL_OPACITY_PROPERTY") {
                public Float get(ExtendedFloatingActionButton arg3) {
                    return Float.valueOf(AnimationUtils.lerp(0f, 1f, (((float)Color.alpha(arg3.getCurrentTextColor()))) / 255f / (((float)Color.alpha(arg3.originalTextCsl.getColorForState(arg3.getDrawableState(), BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor()))))));
                }

                public Object get(Object arg1) {
                    return this.get(((ExtendedFloatingActionButton)arg1));
                }

                public void set(ExtendedFloatingActionButton arg5, Float arg6) {
                    int v4 = arg5.originalTextCsl.getColorForState(arg5.getDrawableState(), BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor());
                    ColorStateList v4_1 = ColorStateList.valueOf(Color.argb(((int)(AnimationUtils.lerp(0f, (((float)Color.alpha(v4))) / 255f, arg6.floatValue()) * 255f)), Color.red(v4), Color.green(v4), Color.blue(v4)));
                    if(arg6.floatValue() == 1f) {
                        arg5.silentlyUpdateTextColor(arg5.originalTextCsl);
                        return;
                    }

                    arg5.silentlyUpdateTextColor(v4_1);
                }

                public void set(Object arg1, Object arg2) {
                    this.set(((ExtendedFloatingActionButton)arg1), ((Float)arg2));
                }
            }));
        }

        AnimatorSet v6 = new AnimatorSet();
        AnimatorSetCompat.playTogether(v6, ((List)v0));
        return v6;
    }

    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec v0 = this.motionSpec;
        if(v0 != null) {
            return v0;
        }

        v0 = this.defaultMotionSpec;
        if(v0 == null) {
            v0 = MotionSpec.createFromResource(this.context, this.getDefaultMotionSpecResource());
            this.defaultMotionSpec = v0;
        }

        return Preconditions.checkNotNull(v0);
    }

    public final List getListeners() {
        return this.listeners;
    }

    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    public void onAnimationCancel() {
        this.tracker.clear();
    }

    public void onAnimationEnd() {
        this.tracker.clear();
    }

    public void onAnimationStart(Animator arg1) {
        this.tracker.onNextAnimationStart(arg1);
    }

    public final void removeAnimationListener(Animator$AnimatorListener arg1) {
        this.listeners.remove(arg1);
    }

    public final void setMotionSpec(MotionSpec arg1) {
        this.motionSpec = arg1;
    }
}

