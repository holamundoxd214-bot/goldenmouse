package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final MotionTiming collapseTiming;
    private final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
        super();
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    public FabTransformationScrimBehavior(Context arg5, AttributeSet arg6) {
        super(arg5, arg6);
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    private void createScrimAnimation(View arg3, boolean arg4, boolean arg5, List arg6, List arg7) {
        ObjectAnimator v3;
        MotionTiming v2 = arg4 ? this.expandTiming : this.collapseTiming;
        if(arg4) {
            if(!arg5) {
                arg3.setAlpha(0f);
            }

            v3 = ObjectAnimator.ofFloat(arg3, View.ALPHA, new float[]{1f});
        }
        else {
            v3 = ObjectAnimator.ofFloat(arg3, View.ALPHA, new float[]{0f});
        }

        v2.apply(((Animator)v3));
        arg6.add(v3);
    }

    public boolean layoutDependsOn(CoordinatorLayout arg1, View arg2, View arg3) {
        return arg3 instanceof FloatingActionButton;
    }

    protected AnimatorSet onCreateExpandedStateChangeAnimation(View arg7, View arg8, boolean arg9, boolean arg10) {
        ArrayList v4 = new ArrayList();
        FabTransformationScrimBehavior v0 = this;
        v0.createScrimAnimation(arg8, arg9, arg10, ((List)v4), new ArrayList());
        AnimatorSet v6 = new AnimatorSet();
        AnimatorSetCompat.playTogether(v6, ((List)v4));
        v6.addListener(new AnimatorListenerAdapter(arg9, arg8) {
            public void onAnimationEnd(Animator arg1) {
                if(!this.val$expanded) {
                    this.val$child.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator arg1) {
                if(this.val$expanded) {
                    this.val$child.setVisibility(0);
                }
            }
        });
        return v6;
    }

    public boolean onTouchEvent(CoordinatorLayout arg1, View arg2, MotionEvent arg3) {
        return super.onTouchEvent(arg1, arg2, arg3);
    }
}

