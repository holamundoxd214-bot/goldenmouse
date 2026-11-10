package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed;

    public CircularPropagation() {
        super();
        this.mPropagationSpeed = 3f;
    }

    private static float distance(float arg0, float arg1, float arg2, float arg3) {
        arg2 -= arg0;
        arg3 -= arg1;
        return ((float)Math.sqrt(((double)(arg2 * arg2 + arg3 * arg3))));
    }

    public long getStartDelay(ViewGroup arg9, Transition arg10, TransitionValues arg11, TransitionValues arg12) {
        int v4_1;
        int v2;
        int v12;
        long v0 = 0;
        if(arg11 == null && arg12 == null) {
            return v0;
        }

        if(arg12 == null || this.getViewVisibility(arg11) == 0) {
            v12 = -1;
        }
        else {
            arg11 = arg12;
            v12 = 1;
        }

        int v3 = this.getViewX(arg11);
        int v11 = this.getViewY(arg11);
        Rect v4 = arg10.getEpicenter();
        if(v4 != null) {
            v2 = v4.centerX();
            v4_1 = v4.centerY();
        }
        else {
            int[] v5 = new int[2];
            arg9.getLocationOnScreen(v5);
            int v6 = Math.round((((float)(v5[0] + arg9.getWidth() / 2))) + arg9.getTranslationX());
            v4_1 = Math.round((((float)(v5[1] + arg9.getHeight() / 2))) + arg9.getTranslationY());
            v2 = v6;
        }

        float v11_1 = CircularPropagation.distance(((float)v3), ((float)v11), ((float)v2), ((float)v4_1)) / CircularPropagation.distance(0f, 0f, ((float)arg9.getWidth()), ((float)arg9.getHeight()));
        long v9 = arg10.getDuration();
        if(v9 < v0) {
            v9 = 300;
        }

        return ((long)Math.round((((float)(v9 * (((long)v12))))) / this.mPropagationSpeed * v11_1));
    }

    public void setPropagationSpeed(float arg2) {
        if(arg2 != 0f) {
            this.mPropagationSpeed = arg2;
            return;
        }

        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}

