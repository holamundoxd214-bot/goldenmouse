package kotlin.math;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\b\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001A\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\n\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\f\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0012\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0012\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u001A\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001A\u0010\u0014\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0012\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0012\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u001A\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0012\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001A\u0010 \u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u00012\u0006\u0010\"\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001A\u0010#\u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u00012\u0006\u0010\"\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010$\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010%\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010%\u001A\u00020\u0001*\u00020\u00012\u0006\u0010&\u001A\u00020\'H\u0087\u0088\u0004\u001A\u0016\u0010(\u001A\u00020\u0001*\u00020\u00012\u0006\u0010)\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u00101\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u001F\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u00101\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u001F\u001A\u00020\'H\u0087\u0088\u0004\u001A\u000E\u00105\u001A\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004\u001A\u000E\u00106\u001A\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u00107\u001A\u00020\u0001*\u00020\u00012\u0006\u00108\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u000E\u00109\u001A\u00020\'*\u00020\u0001H\u0087\u0080\u0004\u001A\u000E\u0010:\u001A\u00020;*\u00020\u0001H\u0087\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0003\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0004\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0005\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0006\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0007\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u001A\u0010\b\u001A\u00020<2\u0006\u0010\t\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\n\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u000B\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\f\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u000E\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u000F\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u001A\u0010\u0010\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<2\u0006\u0010\t\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0011\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0012\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0013\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u001A\u0010\u0014\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<2\u0006\u0010\u0015\u001A\u00020<H\u0087\u0080\u0004\u001A\u0012\u0010\u0016\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0017\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u0018\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0080\u0004\u001A\u0012\u0010\u0019\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u001A\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u001B\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u001C\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0080\u0004\u001A\u0012\u0010\u001D\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u001E\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010\u001F\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u001A\u0010 \u001A\u00020<2\u0006\u0010!\u001A\u00020<2\u0006\u0010\"\u001A\u00020<H\u0087\u0088\u0004\u001A\u001A\u0010#\u001A\u00020<2\u0006\u0010!\u001A\u00020<2\u0006\u0010\"\u001A\u00020<H\u0087\u0088\u0004\u001A\u0012\u0010$\u001A\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0016\u0010%\u001A\u00020<*\u00020<2\u0006\u0010\u0002\u001A\u00020<H\u0087\u0088\u0004\u001A\u0016\u0010%\u001A\u00020<*\u00020<2\u0006\u0010&\u001A\u00020\'H\u0087\u0088\u0004\u001A\u0016\u0010(\u001A\u00020<*\u00020<2\u0006\u0010)\u001A\u00020<H\u0087\u0088\u0004\u001A\u0016\u00101\u001A\u00020<*\u00020<2\u0006\u0010\u001F\u001A\u00020<H\u0087\u0088\u0004\u001A\u0016\u00101\u001A\u00020<*\u00020<2\u0006\u0010\u001F\u001A\u00020\'H\u0087\u0088\u0004\u001A\u000E\u00105\u001A\u00020<*\u00020<H\u0087\u0088\u0004\u001A\u000E\u00106\u001A\u00020<*\u00020<H\u0087\u0088\u0004\u001A\u0016\u00107\u001A\u00020<*\u00020<2\u0006\u00108\u001A\u00020<H\u0087\u0088\u0004\u001A\u000E\u00109\u001A\u00020\'*\u00020<H\u0087\u0080\u0004\u001A\u000E\u0010:\u001A\u00020;*\u00020<H\u0087\u0080\u0004\u001A\u0012\u0010\u001E\u001A\u00020\'2\u0006\u0010&\u001A\u00020\'H\u0087\u0088\u0004\u001A\u001A\u0010 \u001A\u00020\'2\u0006\u0010!\u001A\u00020\'2\u0006\u0010\"\u001A\u00020\'H\u0087\u0088\u0004\u001A\u001A\u0010#\u001A\u00020\'2\u0006\u0010!\u001A\u00020\'2\u0006\u0010\"\u001A\u00020\'H\u0087\u0088\u0004\u001A\u0012\u0010\u001E\u001A\u00020;2\u0006\u0010&\u001A\u00020;H\u0087\u0088\u0004\u001A\u001A\u0010 \u001A\u00020;2\u0006\u0010!\u001A\u00020;2\u0006\u0010\"\u001A\u00020;H\u0087\u0088\u0004\u001A\u001A\u0010#\u001A\u00020;2\u0006\u0010!\u001A\u00020;2\u0006\u0010\"\u001A\u00020;H\u0087\u0088\u0004\" \u0010*\u001A\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b+\u0010,\u001A\u0004\b-\u0010.\" \u0010\u001F\u001A\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b/\u0010,\u001A\u0004\b0\u0010.\" \u00102\u001A\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b3\u0010,\u001A\u0004\b4\u0010.\" \u0010*\u001A\u00020<*\u00020<8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b+\u0010=\u001A\u0004\b-\u0010>\" \u0010\u001F\u001A\u00020<*\u00020<8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b/\u0010=\u001A\u0004\b0\u0010>\" \u00102\u001A\u00020<*\u00020<8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b3\u0010=\u001A\u0004\b4\u0010>\" \u0010*\u001A\u00020\'*\u00020\'8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b+\u0010?\u001A\u0004\b-\u0010@\"\u001F\u0010\u001F\u001A\u00020\'*\u00020\'8FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b/\u0010?\u001A\u0004\b0\u0010@\" \u0010*\u001A\u00020;*\u00020;8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b+\u0010A\u001A\u0004\b-\u0010B\"\u001F\u0010\u001F\u001A\u00020\'*\u00020;8FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b/\u0010A\u001A\u0004\b0\u0010C¨\u0006D"}, d2={"sin", "", "x", "cos", "tan", "asin", "acos", "atan", "atan2", "y", "sinh", "cosh", "tanh", "asinh", "acosh", "atanh", "hypot", "sqrt", "exp", "expm1", "log", "base", "ln", "log10", "log2", "ln1p", "ceil", "floor", "truncate", "round", "abs", "sign", "min", "a", "b", "max", "cbrt", "pow", "n", "", "IEEErem", "divisor", "absoluteValue", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "getSign$annotations", "getSign", "withSign", "ulp", "getUlp$annotations", "getUlp", "nextUp", "nextDown", "nextTowards", "to", "roundToInt", "roundToLong", "", "", "(F)V", "(F)F", "(I)V", "(I)I", "(J)V", "(J)J", "(J)I", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/math/MathKt") class MathKt__MathJVMKt extends MathKt__MathHKt {
    public MathKt__MathJVMKt() {
        super();
    }

    private static final double IEEErem(double arg0, double arg2) {
        return Math.IEEEremainder(arg0, arg2);
    }

    private static final float IEEErem(float arg2, float arg3) {
        return ((float)Math.IEEEremainder(((double)arg2), ((double)arg3)));
    }

    private static final double abs(double arg0) {
        return Math.abs(arg0);
    }

    private static final float abs(float arg0) {
        return Math.abs(arg0);
    }

    private static final int abs(int arg0) {
        return Math.abs(arg0);
    }

    private static final long abs(long arg0) {
        return Math.abs(arg0);
    }

    private static final double acos(double arg0) {
        return Math.acos(arg0);
    }

    private static final float acos(float arg2) {
        return ((float)Math.acos(((double)arg2)));
    }

    public static final double acosh(double arg6) {
        double v0 = 1;
        if(arg6 < v0) {
            return NaN;
        }

        if(arg6 > Constants.upper_taylor_2_bound) {
            return Math.log(arg6) + Constants.LN2;
        }

        double v2 = arg6 - v0;
        if(v2 >= Constants.taylor_n_bound) {
            return Math.log(arg6 + Math.sqrt(arg6 * arg6 - v0));
        }

        arg6 = Math.sqrt(v2);
        if(arg6 >= Constants.taylor_2_bound) {
            arg6 -= arg6 * arg6 * arg6 / 12;
        }

        return Math.sqrt(2) * arg6;
    }

    private static final float acosh(float arg2) {
        return ((float)MathKt.acosh(((double)arg2)));
    }

    private static final double asin(double arg0) {
        return Math.asin(arg0);
    }

    private static final float asin(float arg2) {
        return ((float)Math.asin(((double)arg2)));
    }

    public static final double asinh(double arg5) {
        if(arg5 >= Constants.taylor_n_bound) {
            double v1 = 1;
            if(Double.compare(arg5, Constants.upper_taylor_n_bound) > 0) {
                if(arg5 > Constants.upper_taylor_2_bound) {
                    return Math.log(arg5) + Constants.LN2;
                }

                arg5 *= 2;
                return Math.log(arg5 + v1 / arg5);
            }

            return Math.log(arg5 + Math.sqrt(arg5 * arg5 + v1));
        }

        if(arg5 <= -Constants.taylor_n_bound) {
            return -MathKt.asinh(-arg5);
        }

        if(Math.abs(arg5) >= Constants.taylor_2_bound) {
            arg5 -= arg5 * arg5 * arg5 / 6;
        }

        return arg5;
    }

    private static final float asinh(float arg2) {
        return ((float)MathKt.asinh(((double)arg2)));
    }

    private static final double atan(double arg0) {
        return Math.atan(arg0);
    }

    private static final float atan(float arg2) {
        return ((float)Math.atan(((double)arg2)));
    }

    private static final double atan2(double arg0, double arg2) {
        return Math.atan2(arg0, arg2);
    }

    private static final float atan2(float arg2, float arg3) {
        return ((float)Math.atan2(((double)arg2), ((double)arg3)));
    }

    public static final double atanh(double arg4) {
        if(Math.abs(arg4) < Constants.taylor_n_bound) {
            if(Math.abs(arg4) > Constants.taylor_2_bound) {
                arg4 += arg4 * arg4 * arg4 / 3;
            }

            return arg4;
        }

        return Math.log((1 + arg4) / (1 - arg4)) / 2;
    }

    private static final float atanh(float arg2) {
        return ((float)MathKt.atanh(((double)arg2)));
    }

    private static final double cbrt(double arg0) {
        return Math.cbrt(arg0);
    }

    private static final float cbrt(float arg2) {
        return ((float)Math.cbrt(((double)arg2)));
    }

    private static final double ceil(double arg0) {
        return Math.ceil(arg0);
    }

    private static final float ceil(float arg2) {
        return ((float)Math.ceil(((double)arg2)));
    }

    private static final double cos(double arg0) {
        return Math.cos(arg0);
    }

    private static final float cos(float arg2) {
        return ((float)Math.cos(((double)arg2)));
    }

    private static final double cosh(double arg0) {
        return Math.cosh(arg0);
    }

    private static final float cosh(float arg2) {
        return ((float)Math.cosh(((double)arg2)));
    }

    private static final double exp(double arg0) {
        return Math.exp(arg0);
    }

    private static final float exp(float arg2) {
        return ((float)Math.exp(((double)arg2)));
    }

    private static final double expm1(double arg0) {
        return Math.expm1(arg0);
    }

    private static final float expm1(float arg2) {
        return ((float)Math.expm1(((double)arg2)));
    }

    private static final double floor(double arg0) {
        return Math.floor(arg0);
    }

    private static final float floor(float arg2) {
        return ((float)Math.floor(((double)arg2)));
    }

    private static final double getAbsoluteValue(double arg0) {
        return Math.abs(arg0);
    }

    private static final float getAbsoluteValue(float arg0) {
        return Math.abs(arg0);
    }

    private static final int getAbsoluteValue(int arg0) {
        return Math.abs(arg0);
    }

    private static final long getAbsoluteValue(long arg0) {
        return Math.abs(arg0);
    }

    public static void getAbsoluteValue$annotations(double arg0) {
    }

    public static void getAbsoluteValue$annotations(float arg0) {
    }

    public static void getAbsoluteValue$annotations(int arg0) {
    }

    public static void getAbsoluteValue$annotations(long arg0) {
    }

    private static final double getSign(double arg0) {
        return Math.signum(arg0);
    }

    private static final float getSign(float arg0) {
        return Math.signum(arg0);
    }

    public static final int getSign(int arg0) {
        return Integer.signum(arg0);
    }

    public static final int getSign(long arg0) {
        return Long.signum(arg0);
    }

    public static void getSign$annotations(double arg0) {
    }

    public static void getSign$annotations(float arg0) {
    }

    public static void getSign$annotations(int arg0) {
    }

    public static void getSign$annotations(long arg0) {
    }

    private static final double getUlp(double arg0) {
        return Math.ulp(arg0);
    }

    private static final float getUlp(float arg0) {
        return Math.ulp(arg0);
    }

    public static void getUlp$annotations(double arg0) {
    }

    public static void getUlp$annotations(float arg0) {
    }

    private static final double hypot(double arg0, double arg2) {
        return Math.hypot(arg0, arg2);
    }

    private static final float hypot(float arg2, float arg3) {
        return ((float)Math.hypot(((double)arg2), ((double)arg3)));
    }

    private static final double ln(double arg0) {
        return Math.log(arg0);
    }

    private static final float ln(float arg2) {
        return ((float)Math.log(((double)arg2)));
    }

    private static final double ln1p(double arg0) {
        return Math.log1p(arg0);
    }

    private static final float ln1p(float arg2) {
        return ((float)Math.log1p(((double)arg2)));
    }

    public static final double log(double arg2, double arg4) {
        if(arg4 > 0) {
            if(arg4 == 1) {
            }
            else {
                return Math.log(arg2) / Math.log(arg4);
            }
        }

        return NaN;
    }

    public static final float log(float arg2, float arg3) {
        if(arg3 > 0f) {
            if(arg3 == 1f) {
            }
            else {
                return ((float)(Math.log(((double)arg2)) / Math.log(((double)arg3))));
            }
        }

        return NaNf;
    }

    private static final double log10(double arg0) {
        return Math.log10(arg0);
    }

    private static final float log10(float arg2) {
        return ((float)Math.log10(((double)arg2)));
    }

    public static final double log2(double arg2) {
        return Math.log(arg2) / Constants.LN2;
    }

    public static final float log2(float arg4) {
        return ((float)(Math.log(((double)arg4)) / Constants.LN2));
    }

    private static final double max(double arg0, double arg2) {
        return Math.max(arg0, arg2);
    }

    private static final float max(float arg0, float arg1) {
        return Math.max(arg0, arg1);
    }

    private static final int max(int arg0, int arg1) {
        return Math.max(arg0, arg1);
    }

    private static final long max(long arg0, long arg2) {
        return Math.max(arg0, arg2);
    }

    private static final double min(double arg0, double arg2) {
        return Math.min(arg0, arg2);
    }

    private static final float min(float arg0, float arg1) {
        return Math.min(arg0, arg1);
    }

    private static final int min(int arg0, int arg1) {
        return Math.min(arg0, arg1);
    }

    private static final long min(long arg0, long arg2) {
        return Math.min(arg0, arg2);
    }

    private static final double nextDown(double arg2) {
        return Math.nextAfter(arg2, -Infinity);
    }

    private static final float nextDown(float arg2) {
        return Math.nextAfter(arg2, -Infinity);
    }

    private static final double nextTowards(double arg0, double arg2) {
        return Math.nextAfter(arg0, arg2);
    }

    private static final float nextTowards(float arg2, float arg3) {
        return Math.nextAfter(arg2, ((double)arg3));
    }

    private static final double nextUp(double arg0) {
        return Math.nextUp(arg0);
    }

    private static final float nextUp(float arg0) {
        return Math.nextUp(arg0);
    }

    private static final double pow(double arg0, double arg2) {
        return Math.pow(arg0, arg2);
    }

    private static final double pow(double arg2, int arg4) {
        return Math.pow(arg2, ((double)arg4));
    }

    private static final float pow(float arg2, float arg3) {
        return ((float)Math.pow(((double)arg2), ((double)arg3)));
    }

    private static final float pow(float arg2, int arg3) {
        return ((float)Math.pow(((double)arg2), ((double)arg3)));
    }

    private static final double round(double arg0) {
        return Math.rint(arg0);
    }

    private static final float round(float arg2) {
        return ((float)Math.rint(((double)arg2)));
    }

    public static final int roundToInt(double arg2) {
        if(!Double.isNaN(arg2)) {
            if(arg2 > 2147483647) {
                return 0x7FFFFFFF;
            }

            if(arg2 < -2147483648) {
                return 0x80000000;
            }

            return ((int)Math.round(arg2));
        }

        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final int roundToInt(float arg1) {
        if(!Float.isNaN(arg1)) {
            return Math.round(arg1);
        }

        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long roundToLong(double arg1) {
        if(!Double.isNaN(arg1)) {
            return Math.round(arg1);
        }

        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long roundToLong(float arg2) {
        return MathKt.roundToLong(((double)arg2));
    }

    private static final double sign(double arg0) {
        return Math.signum(arg0);
    }

    private static final float sign(float arg0) {
        return Math.signum(arg0);
    }

    private static final double sin(double arg0) {
        return Math.sin(arg0);
    }

    private static final float sin(float arg2) {
        return ((float)Math.sin(((double)arg2)));
    }

    private static final double sinh(double arg0) {
        return Math.sinh(arg0);
    }

    private static final float sinh(float arg2) {
        return ((float)Math.sinh(((double)arg2)));
    }

    private static final double sqrt(double arg0) {
        return Math.sqrt(arg0);
    }

    private static final float sqrt(float arg2) {
        return ((float)Math.sqrt(((double)arg2)));
    }

    private static final double tan(double arg0) {
        return Math.tan(arg0);
    }

    private static final float tan(float arg2) {
        return ((float)Math.tan(((double)arg2)));
    }

    private static final double tanh(double arg0) {
        return Math.tanh(arg0);
    }

    private static final float tanh(float arg2) {
        return ((float)Math.tanh(((double)arg2)));
    }

    public static final double truncate(double arg2) {
        if(!Double.isNaN(arg2)) {
            if(Double.isInfinite(arg2)) {
            }
            else if(arg2 > 0) {
                return Math.floor(arg2);
            }
            else {
                arg2 = Math.ceil(arg2);
            }
        }

        return arg2;
    }

    public static final float truncate(float arg2) {
        if(!Float.isNaN(arg2)) {
            if(Float.isInfinite(arg2)) {
            }
            else {
                double v0 = arg2 > 0f ? Math.floor(((double)arg2)) : Math.ceil(((double)arg2));
                return ((float)v0);
            }
        }

        return arg2;
    }

    private static final double withSign(double arg0, double arg2) {
        return Math.copySign(arg0, arg2);
    }

    private static final double withSign(double arg2, int arg4) {
        return Math.copySign(arg2, ((double)arg4));
    }

    private static final float withSign(float arg0, float arg1) {
        return Math.copySign(arg0, arg1);
    }

    private static final float withSign(float arg0, int arg1) {
        return Math.copySign(arg0, ((float)arg1));
    }
}

