package androidx.core.math;

public class MathUtils {
    private MathUtils() {
        super();
    }

    public static int addExact(int arg4, int arg5) {
        int v0 = arg4 + arg5;
        int v1 = 1;
        int v3 = arg4 >= 0 ? 1 : 0;
        arg5 = arg5 >= 0 ? 1 : 0;
        if(v3 == arg5) {
            arg4 = arg4 >= 0 ? 1 : 0;
            if(v0 >= 0) {
            }
            else {
                v1 = 0;
            }

            if(arg4 == v1) {
                return v0;
            }

            throw new ArithmeticException("integer overflow");
        }

        return v0;
    }

    public static long addExact(long arg6, long arg8) {
        long v0 = arg6 + arg8;
        long v2 = 0;
        int v6 = Long.compare(arg6, v2);
        int v7 = 1;
        int v5 = v6 >= 0 ? 1 : 0;
        int v8 = arg8 >= v2 ? 1 : 0;
        if(v5 == v8) {
            v6 = v6 >= 0 ? 1 : 0;
            if(v0 >= v2) {
            }
            else {
                v7 = 0;
            }

            if(v6 == v7) {
                return v0;
            }

            throw new ArithmeticException("integer overflow");
        }

        return v0;
    }

    public static int clamp(int arg0, int arg1, int arg2) {
        if(arg0 < arg1) {
            return arg1;
        }

        if(arg0 > arg2) {
            return arg2;
        }

        return arg0;
    }

    public static double clamp(double arg1, double arg3, double arg5) {
        if(arg1 < arg3) {
            return arg3;
        }

        if(arg1 > arg5) {
            return arg5;
        }

        return arg1;
    }

    public static float clamp(float arg1, float arg2, float arg3) {
        if(arg1 < arg2) {
            return arg2;
        }

        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    public static long clamp(long arg1, long arg3, long arg5) {
        if(arg1 < arg3) {
            return arg3;
        }

        if(arg1 > arg5) {
            return arg5;
        }

        return arg1;
    }

    public static int decrementExact(int arg1) {
        if(arg1 != 0x80000000) {
            return arg1 - 1;
        }

        throw new ArithmeticException("integer overflow");
    }

    public static long decrementExact(long arg2) {
        if(arg2 != -9223372036854775808L) {
            return arg2 - 1;
        }

        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int arg1) {
        if(arg1 != 0x7FFFFFFF) {
            return arg1 + 1;
        }

        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long arg2) {
        if(arg2 != 0x7FFFFFFFFFFFFFFFL) {
            return arg2 + 1;
        }

        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int arg2, int arg3) {
        int v0 = arg2 * arg3;
        if(arg2 != 0 && arg3 != 0 && (v0 / arg2 != arg3 || v0 / arg3 != arg2)) {
            throw new ArithmeticException("integer overflow");
        }

        return v0;
    }

    public static long multiplyExact(long arg5, long arg7) {
        long v0 = arg5 * arg7;
        long v2 = 0;
        if(arg5 != v2 && arg7 != v2 && (v0 / arg5 != arg7 || v0 / arg7 != arg5)) {
            throw new ArithmeticException("integer overflow");
        }

        return v0;
    }

    public static int negateExact(int arg1) {
        if(arg1 != 0x80000000) {
            return -arg1;
        }

        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long arg2) {
        if(arg2 != -9223372036854775808L) {
            return -arg2;
        }

        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int arg4, int arg5) {
        int v0 = arg4 - arg5;
        int v1 = 1;
        int v3 = arg4 < 0 ? 1 : 0;
        arg5 = arg5 < 0 ? 1 : 0;
        if(v3 != arg5) {
            arg4 = arg4 < 0 ? 1 : 0;
            if(v0 < 0) {
            }
            else {
                v1 = 0;
            }

            if(arg4 == v1) {
                return v0;
            }

            throw new ArithmeticException("integer overflow");
        }

        return v0;
    }

    public static long subtractExact(long arg6, long arg8) {
        long v0 = arg6 - arg8;
        long v2 = 0;
        int v6 = Long.compare(arg6, v2);
        int v7 = 1;
        int v5 = v6 < 0 ? 1 : 0;
        int v8 = arg8 < v2 ? 1 : 0;
        if(v5 != v8) {
            v6 = v6 < 0 ? 1 : 0;
            if(v0 < v2) {
            }
            else {
                v7 = 0;
            }

            if(v6 == v7) {
                return v0;
            }

            throw new ArithmeticException("integer overflow");
        }

        return v0;
    }

    public static int toIntExact(long arg2) {
        if(arg2 <= 0x7FFFFFFF && arg2 >= -2147483648) {
            return ((int)arg2);
        }

        throw new ArithmeticException("integer overflow");
    }
}

