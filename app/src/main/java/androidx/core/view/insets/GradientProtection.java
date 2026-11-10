package androidx.core.view.insets;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable$Orientation;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.PathInterpolator;

public class GradientProtection extends Protection {
    private static final float[] ALPHAS;
    private int mColor;
    private final int[] mColors;
    private final GradientDrawable mDrawable;
    private boolean mHasColor;
    private float mScale;

    static {
        float[] v0 = new float[100];
        GradientProtection.ALPHAS = v0;
        PathInterpolator v1 = new PathInterpolator(0.42f, 0f, 0.58f, 1f);
        int v0_1 = v0.length - 1;
        int v2;
        for(v2 = v0_1; v2 >= 0; --v2) {
            GradientProtection.ALPHAS[v2] = v1.getInterpolation((((float)(v0_1 - v2))) / (((float)v0_1)));
        }
    }

    public GradientProtection(int arg3) {
        super(arg3);
        GradientDrawable v0 = new GradientDrawable();
        this.mDrawable = v0;
        this.mColors = new int[GradientProtection.ALPHAS.length];
        this.mColor = 0;
        this.mScale = 1.2f;
        if(arg3 != 1) {
            if(arg3 != 2) {
                if(arg3 != 4) {
                    if(arg3 != 8) {
                        return;
                    }

                    v0.setOrientation(GradientDrawable$Orientation.BOTTOM_TOP);
                    return;
                }

                v0.setOrientation(GradientDrawable$Orientation.RIGHT_LEFT);
                return;
            }

            v0.setOrientation(GradientDrawable$Orientation.TOP_BOTTOM);
            return;
        }

        v0.setOrientation(GradientDrawable$Orientation.LEFT_RIGHT);
    }

    public GradientProtection(int arg1, int arg2) {
        this(arg1);
        this.setColor(arg2);
    }

    void dispatchColorHint(int arg2) {
        if(!this.mHasColor) {
            this.setColorInner(arg2);
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public float getScale() {
        return this.mScale;
    }

    int getThickness(int arg1) {
        return ((int)(this.mScale * (((float)arg1))));
    }

    public void setColor(int arg2) {
        this.mHasColor = true;
        this.setColorInner(arg2);
    }

    private void setColorInner(int arg2) {
        if(this.mColor != arg2) {
            this.mColor = arg2;
            GradientProtection.toColors(arg2, this.mColors);
            this.mDrawable.setColors(this.mColors);
            this.setDrawable(this.mDrawable);
        }
    }

    public void setScale(float arg2) {
        if(arg2 >= 0f) {
            this.mScale = arg2;
            this.updateLayout();
            return;
        }

        throw new IllegalArgumentException("Scale must not be negative.");
    }

    private static void toColors(int arg5, int[] arg6) {
        int v0;
        for(v0 = arg6.length - 1; v0 >= 0; --v0) {
            arg6[v0] = Color.argb(((int)(GradientProtection.ALPHAS[v0] * (((float)Color.alpha(arg5))))), Color.red(arg5), Color.green(arg5), Color.blue(arg5));
        }
    }
}

