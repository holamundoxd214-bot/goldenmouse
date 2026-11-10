package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    private AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
        super();
    }

    public ExpandableTransformationBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    static AnimatorSet access$002(ExpandableTransformationBehavior arg0, AnimatorSet arg1) {
        arg0.currentAnimation = arg1;
        return arg1;
    }

    protected abstract AnimatorSet onCreateExpandedStateChangeAnimation(View arg1, View arg2, boolean arg3, boolean arg4);

    protected boolean onExpandedStateChange(View arg4, View arg5, boolean arg6, boolean arg7) {
        AnimatorSet v0 = this.currentAnimation;
        boolean v2 = v0 != null ? true : false;
        if(v2) {
            v0.cancel();
        }

        AnimatorSet v4 = this.onCreateExpandedStateChangeAnimation(arg4, arg5, arg6, v2);
        this.currentAnimation = v4;
        v4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                ExpandableTransformationBehavior.this.currentAnimation = null;
            }
        });
        this.currentAnimation.start();
        if(!arg7) {
            this.currentAnimation.end();
        }

        return 1;
    }
}

