package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

public final class Preconditions {
    private Preconditions() {
        super();
    }

    public static void checkArgument(boolean arg0) {
        if(arg0) {
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean arg0, Object arg1) {
        if(arg0) {
            return;
        }

        throw new IllegalArgumentException(String.valueOf(arg1));
    }

    public static void checkArgument(boolean arg0, String arg1, Object[] arg2) {
        if(arg0) {
            return;
        }

        throw new IllegalArgumentException(String.format(arg1, arg2));
    }

    public static float checkArgumentFinite(float arg1, String arg2) {
        if(!Float.isNaN(arg1)) {
            if(!Float.isInfinite(arg1)) {
                return arg1;
            }

            throw new IllegalArgumentException(arg2 + " must not be infinite");
        }

        throw new IllegalArgumentException(arg2 + " must not be NaN");
    }

    public static int checkArgumentInRange(int arg1, int arg2, int arg3, String arg4) {
        if(arg1 >= arg2) {
            if(arg1 <= arg3) {
                return arg1;
            }

            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", arg4, Integer.valueOf(arg2), Integer.valueOf(arg3)));
        }

        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", arg4, Integer.valueOf(arg2), Integer.valueOf(arg3)));
    }

    public static long checkArgumentInRange(long arg1, long arg3, long arg5, String arg7) {
        if(arg1 >= arg3) {
            if(arg1 <= arg5) {
                return arg1;
            }

            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", arg7, Long.valueOf(arg3), Long.valueOf(arg5)));
        }

        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", arg7, Long.valueOf(arg3), Long.valueOf(arg5)));
    }

    public static float checkArgumentInRange(float arg1, float arg2, float arg3, String arg4) {
        if(arg1 >= arg2) {
            if(arg1 <= arg3) {
                return arg1;
            }

            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", arg4, Float.valueOf(arg2), Float.valueOf(arg3)));
        }

        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", arg4, Float.valueOf(arg2), Float.valueOf(arg3)));
    }

    public static double checkArgumentInRange(double arg1, double arg3, double arg5, String arg7) {
        if(arg1 >= arg3) {
            if(arg1 <= arg5) {
                return arg1;
            }

            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", arg7, Double.valueOf(arg3), Double.valueOf(arg5)));
        }

        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", arg7, Double.valueOf(arg3), Double.valueOf(arg5)));
    }

    public static int checkArgumentNonnegative(int arg0, String arg1) {
        if(arg0 >= 0) {
            return arg0;
        }

        throw new IllegalArgumentException(arg1);
    }

    public static int checkArgumentNonnegative(int arg0) {
        if(arg0 >= 0) {
            return arg0;
        }

        throw new IllegalArgumentException();
    }

    public static int checkFlagsArgument(int arg3, int arg4) {
        if((arg3 & arg4) == arg3) {
            return arg3;
        }

        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(arg3) + ", but only 0x" + Integer.toHexString(arg4) + " are allowed");
    }

    public static Object checkNotNull(Object arg0) {
        arg0.getClass();
        return arg0;
    }

    public static Object checkNotNull(Object arg0, Object arg1) {
        if(arg0 != null) {
            return arg0;
        }

        throw new NullPointerException(String.valueOf(arg1));
    }

    public static void checkState(boolean arg1) {
        Preconditions.checkState(arg1, null);
    }

    public static void checkState(boolean arg0, String arg1) {
        if(arg0) {
            return;
        }

        throw new IllegalStateException(arg1);
    }

    public static CharSequence checkStringNotEmpty(CharSequence arg1, Object arg2) {
        if(!TextUtils.isEmpty(arg1)) {
            return arg1;
        }

        throw new IllegalArgumentException(String.valueOf(arg2));
    }

    public static CharSequence checkStringNotEmpty(CharSequence arg1) {
        if(!TextUtils.isEmpty(arg1)) {
            return arg1;
        }

        throw new IllegalArgumentException();
    }

    public static CharSequence checkStringNotEmpty(CharSequence arg1, String arg2, Object[] arg3) {
        if(!TextUtils.isEmpty(arg1)) {
            return arg1;
        }

        throw new IllegalArgumentException(String.format(arg2, arg3));
    }
}

