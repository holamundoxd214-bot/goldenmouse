package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.Collection;
import java.util.List;

public class AnimatorSetCompat {
    public AnimatorSetCompat() {
        super();
    }

    public static void playTogether(AnimatorSet arg10, List arg11) {
        int v0 = arg11.size();
        long v1 = 0;
        int v4;
        for(v4 = 0; v4 < v0; ++v4) {
            Object v5 = arg11.get(v4);
            v1 = Math.max(v1, ((Animator)v5).getStartDelay() + ((Animator)v5).getDuration());
        }

        ValueAnimator v0_1 = ValueAnimator.ofInt(new int[]{0, 0});
        ((Animator)v0_1).setDuration(v1);
        arg11.add(0, v0_1);
        arg10.playTogether(((Collection)arg11));
    }
}

