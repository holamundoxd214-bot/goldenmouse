package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

class TransitionUtils {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Bitmap createBitmap(Picture arg0) {
            return Bitmap.createBitmap(arg0);
        }
    }

    class MatrixEvaluator implements TypeEvaluator {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues;

        MatrixEvaluator() {
            super();
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        public Matrix evaluate(float arg3, Matrix arg4, Matrix arg5) {
            arg4.getValues(this.mTempStartValues);
            arg5.getValues(this.mTempEndValues);
            int v4;
            for(v4 = 0; v4 < 9; ++v4) {
                this.mTempEndValues[v4] = this.mTempStartValues[v4] + (this.mTempEndValues[v4] - this.mTempStartValues[v4]) * arg3;
            }

            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }

        public Object evaluate(float arg1, Object arg2, Object arg3) {
            return this.evaluate(arg1, ((Matrix)arg2), ((Matrix)arg3));
        }
    }

    private static final boolean HAS_PICTURE_BITMAP = false;
    private static final int MAX_IMAGE_SIZE = 0x100000;

    static {
        boolean v0 = Build$VERSION.SDK_INT >= 28 ? true : false;
        TransitionUtils.HAS_PICTURE_BITMAP = v0;
    }

    private TransitionUtils() {
        super();
    }

    static View copyViewImage(ViewGroup arg7, View arg8, View arg9) {
        Matrix v0 = new Matrix();
        v0.setTranslate(((float)(-arg9.getScrollX())), ((float)(-arg9.getScrollY())));
        ViewUtils.transformMatrixToGlobal(arg8, v0);
        ViewUtils.transformMatrixToLocal(((View)arg7), v0);
        RectF v9 = new RectF(0f, 0f, ((float)arg8.getWidth()), ((float)arg8.getHeight()));
        v0.mapRect(v9);
        int v1 = Math.round(v9.left);
        int v2 = Math.round(v9.top);
        int v3 = Math.round(v9.right);
        int v4 = Math.round(v9.bottom);
        ImageView v5 = new ImageView(arg8.getContext());
        v5.setScaleType(ImageView$ScaleType.CENTER_CROP);
        Bitmap v7 = TransitionUtils.createViewBitmap(arg8, v0, v9, arg7);
        if(v7 != null) {
            v5.setImageBitmap(v7);
        }

        v5.measure(View$MeasureSpec.makeMeasureSpec(v3 - v1, 0x40000000), View$MeasureSpec.makeMeasureSpec(v4 - v2, 0x40000000));
        v5.layout(v1, v2, v3, v4);
        return ((View)v5);
    }

    private static Bitmap createViewBitmap(View arg7, Matrix arg8, RectF arg9, ViewGroup arg10) {
        ViewParent v1;
        boolean v0 = arg7.isAttachedToWindow();
        int v2 = arg10 == null || !arg10.isAttachedToWindow() ? 0 : 1;
        Bitmap v3 = null;
        if(v0) {
            v2 = 0;
            ViewGroup v1_1 = ((ViewGroup)v3);
        }
        else if(v2 == 0) {
            return v3;
        }
        else {
            v1 = arg7.getParent();
            v2 = ((ViewGroup)v1).indexOfChild(arg7);
            ViewCompat.addOverlayView(arg10, arg7);
        }

        int v4 = Math.round(arg9.width());
        int v5 = Math.round(arg9.height());
        if(v4 > 0 && v5 > 0) {
            float v3_1 = Math.min(1f, 1048576f / (((float)(v4 * v5))));
            v4 = Math.round((((float)v4)) * v3_1);
            v5 = Math.round((((float)v5)) * v3_1);
            arg8.postTranslate(-arg9.left, -arg9.top);
            arg8.postScale(v3_1, v3_1);
            if(TransitionUtils.HAS_PICTURE_BITMAP) {
                Picture v9 = new Picture();
                Canvas v3_2 = v9.beginRecording(v4, v5);
                v3_2.concat(arg8);
                arg7.draw(v3_2);
                v9.endRecording();
                v3 = Api28Impl.createBitmap(v9);
            }
            else {
                v3 = Bitmap.createBitmap(v4, v5, Bitmap$Config.ARGB_8888);
                Canvas v9_1 = new Canvas(v3);
                v9_1.concat(arg8);
                arg7.draw(v9_1);
            }
        }

        if(!v0) {
            arg10.getOverlay().remove(arg7);
            ((ViewGroup)v1).addView(arg7, v2);
        }

        return v3;
    }

    static Animator mergeAnimators(Animator arg3, Animator arg4) {
        if(arg3 == null) {
            return arg4;
        }

        if(arg4 == null) {
            return arg3;
        }

        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{arg3, arg4});
        return ((Animator)v0);
    }
}

