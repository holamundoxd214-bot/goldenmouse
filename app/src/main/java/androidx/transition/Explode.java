package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private int[] mTempLoc;
    private static final TimeInterpolator sAccelerate;
    private static final TimeInterpolator sDecelerate;

    static {
        Explode.sDecelerate = new DecelerateInterpolator();
        Explode.sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        super();
        this.mTempLoc = new int[2];
        this.setPropagation(new CircularPropagation());
    }

    public Explode(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mTempLoc = new int[2];
        this.setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float arg0, float arg1) {
        return ((float)Math.sqrt(((double)(arg0 * arg0 + arg1 * arg1))));
    }

    private static float calculateMaxDistance(View arg1, int arg2, int arg3) {
        return Explode.calculateDistance(((float)Math.max(arg2, arg1.getWidth() - arg2)), ((float)Math.max(arg3, arg1.getHeight() - arg3)));
    }

    private void calculateOut(View arg13, Rect arg14, int[] arg15) {
        int v4;
        int v12_1;
        arg13.getLocationOnScreen(this.mTempLoc);
        int[] v0 = this.mTempLoc;
        int v2 = v0[0];
        int v0_1 = v0[1];
        Rect v12 = this.getEpicenter();
        if(v12 == null) {
            v12_1 = arg13.getWidth() / 2 + v2 + Math.round(arg13.getTranslationX());
            v4 = arg13.getHeight() / 2 + v0_1 + Math.round(arg13.getTranslationY());
        }
        else {
            int v11 = v12.centerX();
            v4 = v12.centerY();
            v12_1 = v11;
        }

        float v5 = ((float)(arg14.centerX() - v12_1));
        float v14 = ((float)(arg14.centerY() - v4));
        if(v5 == 0f && v14 == 0f) {
            v5 = (((float)(Math.random() * 2))) - 1f;
            v14 = (((float)(Math.random() * 2))) - 1f;
        }

        float v6 = Explode.calculateDistance(v5, v14);
        float v12_2 = Explode.calculateMaxDistance(arg13, v12_1 - v2, v4 - v0_1);
        arg15[0] = Math.round(v5 / v6 * v12_2);
        arg15[1] = Math.round(v12_2 * (v14 / v6));
    }

    public void captureEndValues(TransitionValues arg1) {
        super.captureEndValues(arg1);
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg1) {
        super.captureStartValues(arg1);
        this.captureValues(arg1);
    }

    private void captureValues(TransitionValues arg5) {
    }

    public boolean isSeekingSupported() {
        return 1;
    }

    public Animator onAppear(ViewGroup arg11, View arg12, TransitionValues arg13, TransitionValues arg14) {
        if(arg14 == null) {
            return null;
        }

        Object v13 = arg14.values.get("android:explode:screenBounds");
        float v6 = arg12.getTranslationX();
        float v7 = arg12.getTranslationY();
        this.calculateOut(((View)arg11), ((Rect)v13), this.mTempLoc);
        return TranslationAnimationCreator.createAnimation(arg12, arg14, ((Rect)v13).left, ((Rect)v13).top, v6 + (((float)this.mTempLoc[0])), v7 + (((float)this.mTempLoc[1])), v6, v7, Explode.sDecelerate, this);
    }

    public Animator onDisappear(ViewGroup arg11, View arg12, TransitionValues arg13, TransitionValues arg14) {
        float v8;
        float v7;
        if(arg13 == null) {
            return null;
        }

        Object v14 = arg13.values.get("android:explode:screenBounds");
        int v2 = ((Rect)v14).left;
        int v3 = ((Rect)v14).top;
        float v4 = arg12.getTranslationX();
        float v5 = arg12.getTranslationY();
        Object v0 = arg13.view.getTag(id.transition_position);
        if(v0 != null) {
            v7 = (((float)(v0[0] - ((Rect)v14).left))) + v4;
            v8 = (((float)(v0[1] - ((Rect)v14).top))) + v5;
            ((Rect)v14).offsetTo(v0[0], v0[1]);
        }
        else {
            v7 = v4;
            v8 = v5;
        }

        this.calculateOut(((View)arg11), ((Rect)v14), this.mTempLoc);
        return TranslationAnimationCreator.createAnimation(arg12, arg13, v2, v3, v4, v5, v7 + (((float)this.mTempLoc[0])), v8 + (((float)this.mTempLoc[1])), Explode.sAccelerate, this);
    }
}

