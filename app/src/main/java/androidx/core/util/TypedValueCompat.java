package androidx.core.util;

import android.os.Build$VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {
    class Api34Impl {
        private Api34Impl() {
            super();
        }

        public static float deriveDimension(int arg0, float arg1, DisplayMetrics arg2) {
            return TypedValue.deriveDimension(arg0, arg1, arg2);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ComplexDimensionUnit {
    }

    private static final float INCHES_PER_MM = 0.03937f;
    private static final float INCHES_PER_PT = 0.013889f;

    private TypedValueCompat() {
        super();
    }

    public static float deriveDimension(int arg2, float arg3, DisplayMetrics arg4) {
        float v2;
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(arg2, arg3, arg4);
        }

        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 != 2) {
                    if(arg2 != 3) {
                        if(arg2 != 4) {
                            if(arg2 != 5) {
                                throw new IllegalArgumentException("Invalid unitToConvertTo " + arg2);
                            }
                            else if(arg4.xdpi == 0f) {
                                return 0;
                            }
                            else {
                                arg3 /= arg4.xdpi;
                                v2 = 0.03937f;
                            }
                        }
                        else if(arg4.xdpi == 0f) {
                            return 0;
                        }
                        else {
                            v2 = arg4.xdpi;
                        }
                    }
                    else if(arg4.xdpi == 0f) {
                        return 0;
                    }
                    else {
                        arg3 /= arg4.xdpi;
                        v2 = 0.013889f;
                    }
                }
                else if(arg4.scaledDensity == 0f) {
                    return 0;
                }
                else {
                    v2 = arg4.scaledDensity;
                }
            }
            else if(arg4.density == 0f) {
                return 0;
            }
            else {
                v2 = arg4.density;
            }

            return arg3 / v2;
        }

        return arg3;
    }

    public static float dpToPx(float arg1, DisplayMetrics arg2) {
        return TypedValue.applyDimension(1, arg1, arg2);
    }

    public static int getUnitFromComplexDimension(int arg0) {
        return arg0 & 15;
    }

    public static float pxToDp(float arg1, DisplayMetrics arg2) {
        return TypedValueCompat.deriveDimension(1, arg1, arg2);
    }

    public static float pxToSp(float arg1, DisplayMetrics arg2) {
        return TypedValueCompat.deriveDimension(2, arg1, arg2);
    }

    public static float spToPx(float arg1, DisplayMetrics arg2) {
        return TypedValue.applyDimension(2, arg1, arg2);
    }
}

