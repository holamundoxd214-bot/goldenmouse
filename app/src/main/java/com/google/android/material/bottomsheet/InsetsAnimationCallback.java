package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

class InsetsAnimationCallback extends Callback {
    private int startTranslationY;
    private int startY;
    private final int[] tmpLocation;
    private final View view;

    public InsetsAnimationCallback(View arg2) {
        super(0);
        this.tmpLocation = new int[2];
        this.view = arg2;
    }

    public void onEnd(WindowInsetsAnimationCompat arg1) {
        this.view.setTranslationY(0f);
    }

    public void onPrepare(WindowInsetsAnimationCompat arg2) {
        this.view.getLocationOnScreen(this.tmpLocation);
        this.startY = this.tmpLocation[1];
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat arg4, List arg5) {
        Object v0;
        Iterator v5 = arg5.iterator();
        do {
            if(v5.hasNext()) {
                v0 = v5.next();
                if((((WindowInsetsAnimationCompat)v0).getTypeMask() & Type.ime()) == 0) {
                    continue;
                }

                break;
            }

            return arg4;
        }
        while(true);

        this.view.setTranslationY(((float)AnimationUtils.lerp(this.startTranslationY, 0, ((WindowInsetsAnimationCompat)v0).getInterpolatedFraction())));
        return arg4;
    }

    public BoundsCompat onStart(WindowInsetsAnimationCompat arg2, BoundsCompat arg3) {
        this.view.getLocationOnScreen(this.tmpLocation);
        int v0 = this.startY - this.tmpLocation[1];
        this.startTranslationY = v0;
        this.view.setTranslationY(((float)v0));
        return arg3;
    }
}

