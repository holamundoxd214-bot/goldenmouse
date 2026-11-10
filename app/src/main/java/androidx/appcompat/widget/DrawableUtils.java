package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DrawableUtils {
    class Api18Impl {
        private static final Field sBottom;
        private static final Method sGetOpticalInsets;
        private static final Field sLeft;
        private static final boolean sReflectionSuccessful;
        private static final Field sRight;
        private static final Field sTop;

        static {
            int v8;
            Field v3_1;
            Field v6;
            Field v5;
            Method v4;
            Class v3;
            Method v1 = null;
            try {
                v3 = Class.forName("android.graphics.Insets");
                v4 = Drawable.class.getMethod("getOpticalInsets");
            }
            catch(NoSuchFieldException ) {
                v4 = v1;
                v5 = ((Field)v4);
                goto label_35;
            }
            catch(ClassNotFoundException ) {
                v4 = v1;
                v5 = ((Field)v4);
                goto label_39;
            }
            catch(NoSuchMethodException ) {
                v4 = v1;
                v5 = ((Field)v4);
                goto label_43;
            }

            try {
                v5 = v3.getField("left");
                goto label_11;
            }
            catch(NoSuchFieldException ) {
                v5 = ((Field)v1);
            }
            catch(ClassNotFoundException ) {
                v5 = ((Field)v1);
            label_39:
                v6 = v5;
                goto label_44;
            }
            catch(NoSuchMethodException ) {
                v5 = ((Field)v1);
            label_43:
                v6 = v5;
                goto label_44;
            }

        label_35:
            v6 = v5;
            goto label_44;
            try {
            label_11:
                v6 = v3.getField("top");
                goto label_13;
            }
            catch(NoSuchFieldException ) {
                v6 = ((Field)v1);
            }
            catch(ClassNotFoundException ) {
                v6 = ((Field)v1);
            }
            catch(NoSuchMethodException ) {
                v6 = ((Field)v1);
            }

        label_44:
            Field v7 = v6;
            goto label_45;
            try {
            label_13:
                v7 = v3.getField("right");
            }
            catch(NoSuchFieldException ) {
                v7 = ((Field)v1);
                goto label_45;
            }

            try {
                v3_1 = v3.getField("bottom");
                v8 = 1;
            }
            catch(NoSuchFieldException ) {
            label_45:
                v3_1 = ((Field)v1);
                v8 = 0;
            }

            if(v8 != 0) {
                Api18Impl.sGetOpticalInsets = v4;
                Api18Impl.sLeft = v5;
                Api18Impl.sTop = v6;
                Api18Impl.sRight = v7;
                Api18Impl.sBottom = v3_1;
                Api18Impl.sReflectionSuccessful = true;
            }
            else {
                Api18Impl.sGetOpticalInsets = v1;
                Api18Impl.sLeft = ((Field)v1);
                Api18Impl.sTop = ((Field)v1);
                Api18Impl.sRight = ((Field)v1);
                Api18Impl.sBottom = ((Field)v1);
                Api18Impl.sReflectionSuccessful = false;
            }
        }

        private Api18Impl() {
            super();
        }

        static Rect getOpticalInsets(Drawable arg5) {
            if(Build$VERSION.SDK_INT < 29 && (Api18Impl.sReflectionSuccessful)) {
                try {
                    Object v5 = Api18Impl.sGetOpticalInsets.invoke(arg5);
                    if(v5 != null) {
                        return new Rect(Api18Impl.sLeft.getInt(v5), Api18Impl.sTop.getInt(v5), Api18Impl.sRight.getInt(v5), Api18Impl.sBottom.getInt(v5));
                    }

                    goto label_21;
                }
                catch(InvocationTargetException ) {
                label_21:
                    return DrawableUtils.INSETS_NONE;
                }
            }

            goto label_21;
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static Insets getOpticalInsets(Drawable arg0) {
            return arg0.getOpticalInsets();
        }
    }

    private static final int[] CHECKED_STATE_SET;
    private static final int[] EMPTY_STATE_SET;
    public static final Rect INSETS_NONE;

    static {
        DrawableUtils.CHECKED_STATE_SET = new int[]{0x10100A0};
        DrawableUtils.EMPTY_STATE_SET = new int[0];
        DrawableUtils.INSETS_NONE = new Rect();
    }

    private DrawableUtils() {
        super();
    }

    public static boolean canSafelyMutateDrawable(Drawable arg0) {
        return 1;
    }

    static void fixDrawable(Drawable arg3) {
        String v0 = arg3.getClass().getName();
        if(Build$VERSION.SDK_INT >= 29 && Build$VERSION.SDK_INT < 0x1F && ("android.graphics.drawable.ColorStateListDrawable".equals(v0))) {
            DrawableUtils.forceDrawableStateChange(arg3);
        }
    }

    private static void forceDrawableStateChange(Drawable arg2) {
        int[] v0 = arg2.getState();
        if(v0 == null || v0.length == 0) {
            arg2.setState(DrawableUtils.CHECKED_STATE_SET);
        }
        else {
            arg2.setState(DrawableUtils.EMPTY_STATE_SET);
        }

        arg2.setState(v0);
    }

    public static Rect getOpticalBounds(Drawable arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            Insets v4 = Api29Impl.getOpticalInsets(arg4);
            return new Rect(v4.left, v4.top, v4.right, v4.bottom);
        }

        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(arg4));
    }

    public static PorterDuff$Mode parseTintMode(int arg1, PorterDuff$Mode arg2) {
        if(arg1 == 3) {
            goto label_18;
        }

        if(arg1 == 5) {
            goto label_16;
        }

        if(arg1 == 9) {
            goto label_14;
        }

        switch(arg1) {
            case 14: {
                goto label_12;
            }
            case 15: {
                goto label_10;
            }
            case 16: {
                goto label_8;
            }
        }

        return arg2;
    label_8:
        return PorterDuff$Mode.ADD;
    label_10:
        return PorterDuff$Mode.SCREEN;
    label_12:
        return PorterDuff$Mode.MULTIPLY;
    label_14:
        return PorterDuff$Mode.SRC_ATOP;
    label_16:
        return PorterDuff$Mode.SRC_IN;
    label_18:
        return PorterDuff$Mode.SRC_OVER;
    }
}

