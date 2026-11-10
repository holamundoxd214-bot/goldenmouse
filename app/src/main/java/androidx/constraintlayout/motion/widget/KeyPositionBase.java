package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20f;
    int mCurveFit;

    KeyPositionBase() {
        super();
        this.mCurveFit = KeyPositionBase.UNSET;
    }

    abstract void calcPosition(int arg1, int arg2, float arg3, float arg4, float arg5, float arg6);

    void getAttributeNames(HashSet arg1) {
    }

    abstract float getPositionX();

    abstract float getPositionY();

    public abstract boolean intersects(int arg1, int arg2, RectF arg3, RectF arg4, float arg5, float arg6);

    abstract void positionAttributes(View arg1, RectF arg2, RectF arg3, float arg4, float arg5, String[] arg6, float[] arg7);
}

