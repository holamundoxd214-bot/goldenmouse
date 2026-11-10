package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    static {
    }

    public VelocityMatrix() {
        super();
    }

    public void applyTransform(float arg18, float arg19, int arg20, int arg21, float[] arg22) {
        float v3 = arg22[0];
        float v5 = arg22[1];
        float v7 = (arg18 - 0.5f) * 2f;
        float v6 = (arg19 - 0.5f) * 2f;
        v3 += this.mDTranslateX;
        v5 += this.mDTranslateY;
        v3 += this.mDScaleX * v7;
        v5 += this.mDScaleY * v6;
        float v8 = ((float)Math.toRadians(((double)this.mRotate)));
        float v0 = ((float)Math.toRadians(((double)this.mDRotate)));
        double v11 = ((double)v8);
        double v13 = ((double)((((float)arg21)) * v6));
        v3 += (((float)((((double)((((float)(-arg20))) * v7))) * Math.sin(v11) - Math.cos(v11) * v13))) * v0;
        v5 += v0 * (((float)((((double)((((float)arg20)) * v7))) * Math.cos(v11) - v13 * Math.sin(v11))));
        arg22[0] = v3;
        arg22[1] = v5;
    }

    public void clear() {
        this.mDRotate = 0f;
        this.mDTranslateY = 0f;
        this.mDTranslateX = 0f;
        this.mDScaleY = 0f;
        this.mDScaleX = 0f;
    }

    public void setRotationVelocity(KeyCycleOscillator arg1, float arg2) {
        if(arg1 != null) {
            this.mDRotate = arg1.getSlope(arg2);
        }
    }

    public void setRotationVelocity(SplineSet arg2, float arg3) {
        if(arg2 != null) {
            this.mDRotate = arg2.getSlope(arg3);
            this.mRotate = arg2.get(arg3);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator arg1, KeyCycleOscillator arg2, float arg3) {
        if(arg1 != null || arg2 != null) {
            if(arg1 == null) {
                this.mDScaleX = arg1.getSlope(arg3);
            }

            if(arg2 != null) {
                return;
            }

            this.mDScaleY = arg2.getSlope(arg3);
        }
        else {
        }
    }

    public void setScaleVelocity(SplineSet arg1, SplineSet arg2, float arg3) {
        if(arg1 != null) {
            this.mDScaleX = arg1.getSlope(arg3);
        }

        if(arg2 != null) {
            this.mDScaleY = arg2.getSlope(arg3);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator arg1, KeyCycleOscillator arg2, float arg3) {
        if(arg1 != null) {
            this.mDTranslateX = arg1.getSlope(arg3);
        }

        if(arg2 != null) {
            this.mDTranslateY = arg2.getSlope(arg3);
        }
    }

    public void setTranslationVelocity(SplineSet arg1, SplineSet arg2, float arg3) {
        if(arg1 != null) {
            this.mDTranslateX = arg1.getSlope(arg3);
        }

        if(arg2 != null) {
            this.mDTranslateY = arg2.getSlope(arg3);
        }
    }
}

