package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi19 {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static float getTransitionAlpha(View arg0) {
            return arg0.getTransitionAlpha();
        }

        static void setTransitionAlpha(View arg0, float arg1) {
            arg0.setTransitionAlpha(arg1);
        }
    }

    private static final String TAG = "ViewUtilsApi19";
    private static final int VISIBILITY_MASK = 12;
    private float[] mMatrixValues;
    private static boolean sSetFrameFetched = false;
    private static Method sSetFrameMethod = null;
    private static boolean sTryHiddenTransitionAlpha = true;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;

    static {
    }

    ViewUtilsApi19() {
        super();
    }

    public void clearNonTransitionAlpha(View arg1) {
    }

    private void fetchSetFrame() {
        if(!ViewUtilsApi19.sSetFrameFetched) {
            try {
                Method v0_1 = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                ViewUtilsApi19.sSetFrameMethod = v0_1;
                v0_1.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setFrame method", ((Throwable)v0));
            }

            ViewUtilsApi19.sSetFrameFetched = true;
        }
    }

    public float getTransitionAlpha(View arg1) {
        if(ViewUtilsApi19.sTryHiddenTransitionAlpha) {
            try {
                return Api29Impl.getTransitionAlpha(arg1);
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi19.sTryHiddenTransitionAlpha = false;
            }
        }

        return arg1.getAlpha();
    }

    public void saveNonTransitionAlpha(View arg1) {
    }

    public void setAnimationMatrix(View arg9, Matrix arg10) {
        float v0 = 1f;
        int v1 = 2;
        if(arg10 != null) {
            if(arg10.isIdentity()) {
            }
            else {
                float[] v3 = this.mMatrixValues;
                if(v3 == null) {
                    v3 = new float[9];
                    this.mMatrixValues = v3;
                }

                arg10.getValues(v3);
                float v8 = v3[3];
                float v10 = ((float)Math.sqrt(((double)(v0 - v8 * v8))));
                int v4 = v3[0] < 0f ? -1 : 1;
                v10 *= ((float)v4);
                v8 = ((float)Math.toDegrees(Math.atan2(((double)v8), ((double)v10))));
                v0 = v3[0] / v10;
                float v4_1 = v3[4] / v10;
                v10 = v3[v1];
                float v1_1 = v3[5];
                arg9.setPivotX(0f);
                arg9.setPivotY(0f);
                arg9.setTranslationX(v10);
                arg9.setTranslationY(v1_1);
                arg9.setRotation(v8);
                arg9.setScaleX(v0);
                arg9.setScaleY(v4_1);
                return;
            }
        }

        arg9.setPivotX(((float)(arg9.getWidth() / v1)));
        arg9.setPivotY(((float)(arg9.getHeight() / v1)));
        arg9.setTranslationX(0f);
        arg9.setTranslationY(0f);
        arg9.setScaleX(v0);
        arg9.setScaleY(v0);
        arg9.setRotation(0f);
    }

    public void setLeftTopRightBottom(View arg1, int arg2, int arg3, int arg4, int arg5) {
        this.fetchSetFrame();
        Method v0 = ViewUtilsApi19.sSetFrameMethod;
        if(v0 == null) {
            return;
        }

        try {
            v0.invoke(arg1, Integer.valueOf(arg2), Integer.valueOf(arg3), Integer.valueOf(arg4), Integer.valueOf(arg5));
            return;
        }
        catch(IllegalAccessException ) {
            return;
        }
        catch(InvocationTargetException v0_1) {
            throw new RuntimeException(v0_1.getCause());
        }
    }

    public void setTransitionAlpha(View arg1, float arg2) {
        if(ViewUtilsApi19.sTryHiddenTransitionAlpha) {
            try {
                Api29Impl.setTransitionAlpha(arg1, arg2);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi19.sTryHiddenTransitionAlpha = false;
            }
        }

        arg1.setAlpha(arg2);
    }

    public void setTransitionVisibility(View arg3, int arg4) {
        if(!ViewUtilsApi19.sViewFlagsFieldFetched) {
            try {
                Field v0 = View.class.getDeclaredField("mViewFlags");
                ViewUtilsApi19.sViewFlagsField = v0;
                v0.setAccessible(true);
            }
            catch(NoSuchFieldException ) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }

            ViewUtilsApi19.sViewFlagsFieldFetched = true;
        }

        Field v2 = ViewUtilsApi19.sViewFlagsField;
        if(v2 != null) {
            try {
                ViewUtilsApi19.sViewFlagsField.setInt(arg3, v2.getInt(arg3) & -13 | arg4);
                return;
            }
            catch(IllegalAccessException ) {
                return;
            }
        }
    }

    public void transformMatrixToGlobal(View arg3, Matrix arg4) {
        ViewParent v0 = arg3.getParent();
        if((v0 instanceof View)) {
            this.transformMatrixToGlobal(((View)v0), arg4);
            arg4.preTranslate(((float)(-((View)v0).getScrollX())), ((float)(-((View)v0).getScrollY())));
        }

        arg4.preTranslate(((float)arg3.getLeft()), ((float)arg3.getTop()));
        Matrix v2 = arg3.getMatrix();
        if(!v2.isIdentity()) {
            arg4.preConcat(v2);
        }
    }

    public void transformMatrixToLocal(View arg3, Matrix arg4) {
        ViewParent v0 = arg3.getParent();
        if((v0 instanceof View)) {
            this.transformMatrixToLocal(((View)v0), arg4);
            arg4.postTranslate(((float)((View)v0).getScrollX()), ((float)((View)v0).getScrollY()));
        }

        arg4.postTranslate(((float)(-arg3.getLeft())), ((float)(-arg3.getTop())));
        Matrix v2 = arg3.getMatrix();
        if(!v2.isIdentity()) {
            Matrix v3 = new Matrix();
            if(v2.invert(v3)) {
                arg4.postConcat(v3);
            }
        }
    }
}

