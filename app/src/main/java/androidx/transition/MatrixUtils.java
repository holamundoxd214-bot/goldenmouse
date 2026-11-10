package androidx.transition;

import android.graphics.Matrix$ScaleToFit;
import android.graphics.Matrix;
import android.graphics.RectF;

class MatrixUtils {
    class androidx.transition.MatrixUtils$1 extends Matrix {
        androidx.transition.MatrixUtils$1() {
            super();
        }

        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix arg1) {
            this.oops();
            return 0;
        }

        public boolean postRotate(float arg1) {
            this.oops();
            return 0;
        }

        public boolean postRotate(float arg1, float arg2, float arg3) {
            this.oops();
            return 0;
        }

        public boolean postScale(float arg1, float arg2) {
            this.oops();
            return 0;
        }

        public boolean postScale(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
            return 0;
        }

        public boolean postSkew(float arg1, float arg2) {
            this.oops();
            return 0;
        }

        public boolean postSkew(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
            return 0;
        }

        public boolean postTranslate(float arg1, float arg2) {
            this.oops();
            return 0;
        }

        public boolean preConcat(Matrix arg1) {
            this.oops();
            return 0;
        }

        public boolean preRotate(float arg1) {
            this.oops();
            return 0;
        }

        public boolean preRotate(float arg1, float arg2, float arg3) {
            this.oops();
            return 0;
        }

        public boolean preScale(float arg1, float arg2) {
            this.oops();
            return 0;
        }

        public boolean preScale(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
            return 0;
        }

        public boolean preSkew(float arg1, float arg2) {
            this.oops();
            return 0;
        }

        public boolean preSkew(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
            return 0;
        }

        public boolean preTranslate(float arg1, float arg2) {
            this.oops();
            return 0;
        }

        public void reset() {
            this.oops();
        }

        public void set(Matrix arg1) {
            this.oops();
        }

        public boolean setConcat(Matrix arg1, Matrix arg2) {
            this.oops();
            return 0;
        }

        public boolean setPolyToPoly(float[] arg1, int arg2, float[] arg3, int arg4, int arg5) {
            this.oops();
            return 0;
        }

        public boolean setRectToRect(RectF arg1, RectF arg2, Matrix$ScaleToFit arg3) {
            this.oops();
            return 0;
        }

        public void setRotate(float arg1) {
            this.oops();
        }

        public void setRotate(float arg1, float arg2, float arg3) {
            this.oops();
        }

        public void setScale(float arg1, float arg2) {
            this.oops();
        }

        public void setScale(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
        }

        public void setSinCos(float arg1, float arg2) {
            this.oops();
        }

        public void setSinCos(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
        }

        public void setSkew(float arg1, float arg2) {
            this.oops();
        }

        public void setSkew(float arg1, float arg2, float arg3, float arg4) {
            this.oops();
        }

        public void setTranslate(float arg1, float arg2) {
            this.oops();
        }

        public void setValues(float[] arg1) {
            this.oops();
        }
    }

    static final Matrix IDENTITY_MATRIX;

    static {
        MatrixUtils.IDENTITY_MATRIX = new androidx.transition.MatrixUtils$1();
    }

    private MatrixUtils() {
        super();
    }
}

