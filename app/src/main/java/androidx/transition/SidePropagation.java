package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed;
    private int mSide;

    public SidePropagation() {
        super();
        this.mPropagationSpeed = 3f;
        this.mSide = 80;
    }

    private int distance(View arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
        int v4 = this.mSide;
        int v2 = 5;
        int v3 = 3;
        if(v4 == 0x800003) {
            if(arg5.getLayoutDirection() != 1) {
                goto label_10;
            }

            goto label_8;
        }
        else if(v4 == 0x800005) {
            if(arg5.getLayoutDirection() == 1) {
            label_10:
                v4 = v3;
            }
            else {
            label_8:
                v4 = v2;
            }
        }

        if(v4 != v3) {
            if(v4 != v2) {
                if(v4 != 0x30) {
                    if(v4 != 80) {
                        return 0;
                    }

                    return arg7 - arg11 + Math.abs(arg8 - arg6);
                }

                return arg13 - arg7 + Math.abs(arg8 - arg6);
            }

            return arg6 - arg10 + Math.abs(arg9 - arg7);
        }

        return arg12 - arg6 + Math.abs(arg9 - arg7);
    }

    private int getMaxDistance(ViewGroup arg2) {
        int v1 = this.mSide;
        if(v1 != 3 && v1 != 5 && v1 != 0x800003 && v1 != 0x800005) {
            return arg2.getHeight();
        }

        return arg2.getWidth();
    }

    public long getStartDelay(ViewGroup arg15, Transition arg16, TransitionValues arg17, TransitionValues arg18) {
        int v4_1;
        int v7_1;
        ViewGroup v1_2;
        int v0;
        int v12;
        TransitionValues v1 = arg17;
        long v10 = 0;
        if(v1 == null && arg18 == null) {
            return v10;
        }

        Rect v2 = arg16.getEpicenter();
        if(arg18 == null || this.getViewVisibility(v1) == 0) {
            v12 = -1;
        }
        else {
            v1 = arg18;
            v12 = 1;
        }

        Rect v4 = v2;
        int v2_1 = this.getViewX(v1);
        int v1_1 = this.getViewY(v1);
        int v5 = 2;
        int[] v6 = new int[v5];
        ViewGroup v7 = arg15;
        arg15.getLocationOnScreen(v6);
        int v8 = v6[0] + Math.round(arg15.getTranslationX());
        int v3 = v6[1] + Math.round(arg15.getTranslationY());
        int v6_1 = arg15.getWidth() + v8;
        int v9 = arg15.getHeight() + v3;
        if(v4 != null) {
            v0 = v3;
            v3 = v1_1;
            v1_2 = v7;
            v7_1 = v0;
            v0 = v4.centerX();
            v5 = v4.centerY();
            v4_1 = v0;
        }
        else {
            v4_1 = (v8 + v6_1) / v5;
            v5 = (v3 + v9) / 2;
            v0 = v3;
            v3 = v1_1;
            v1_2 = v7;
            v7_1 = v0;
        }

        float v1_3 = (((float)this.distance(((View)v1_2), v2_1, v3, v4_1, v5, v8, v7_1, v6_1, v9))) / (((float)this.getMaxDistance(arg15)));
        long v2_2 = arg16.getDuration();
        if(v2_2 < v10) {
            v2_2 = 300;
        }

        return ((long)Math.round((((float)(v2_2 * (((long)v12))))) / this.mPropagationSpeed * v1_3));
    }

    public void setPropagationSpeed(float arg2) {
        if(arg2 != 0f) {
            this.mPropagationSpeed = arg2;
            return;
        }

        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int arg1) {
        this.mSide = arg1;
    }
}

