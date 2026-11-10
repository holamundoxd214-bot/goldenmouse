package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\u001A0\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004H\u0007\u001A0\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0007\u001A8\u0010\u0002\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0007\u001A0\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0002\u001A(\u0010\u0012\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0002\u001A0\u0010\u0013\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0002\u001A@\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0002\u001A9\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\t2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001A2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001AH\u0082\b\u001A\r\u0010\u001C\u001A\u00020\u001D*\u00020\tH\u0082\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "", "springConstant", "dampingCoefficient", "mass", "estimateUnderDamped", "firstRootReal", "firstRootImaginary", "p0", "v0", "estimateCriticallyDamped", "estimateOverDamped", "secondRootReal", "estimateDurationInternal", "initialPosition", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 0x8637BD05AF6L;

    public static final long estimateAnimationDurationMillis(float arg10, float arg11, float arg12, float arg13, float arg14) {
        if(arg11 == 0f) {
            return 0x8637BD05AF6L;
        }

        return SpringEstimationKt.estimateAnimationDurationMillis(((double)arg10), ((double)arg11), ((double)arg12), ((double)arg13), ((double)arg14));
    }

    public static final long estimateAnimationDurationMillis(double arg25, double arg27, double arg29, double arg31, double arg33) {
        double v0 = 2 * arg27 * Math.sqrt(arg25);
        double v2 = v0 * v0 - 4 * arg25;
        double v4 = 0;
        int v6 = Double.compare(v2, v4);
        double v7 = v6 < 0 ? v4 : Math.sqrt(v2);
        if(v6 < 0) {
            v4 = Math.sqrt(Math.abs(v2));
        }

        v0 = -v0;
        return SpringEstimationKt.estimateDurationInternal((v0 + v7) * 0.5, v4 * 0.5, (v0 - v7) * 0.5, arg27, arg29, arg31, arg33);
    }

    public static final long estimateAnimationDurationMillis(double arg20, double arg22, double arg24, double arg26, double arg28, double arg30) {
        double v0 = arg22;
        double v12 = v0 / (Math.sqrt(arg20 * arg24) * 2);
        double v2 = v0 * v0 - 4 * arg24 * arg20;
        double v6 = 1 / (2 * arg24);
        double v4 = 0;
        int v8 = Double.compare(v2, v4);
        double v9 = v8 < 0 ? v4 : Math.sqrt(v2);
        if(v8 < 0) {
            v4 = Math.sqrt(Math.abs(v2));
        }

        v0 = -v0;
        return SpringEstimationKt.estimateDurationInternal((v0 + v9) * v6, v4 * v6, (v0 - v9) * v6, v12, arg26, arg28, arg30);
    }

    private static final double estimateCriticallyDamped(double arg22, double arg24, double arg26, double arg28) {
        double v0 = arg28;
        double v2 = arg22 * arg24;
        double v4 = arg26 - v2;
        double v6 = Math.log(Math.abs(v0 / arg24)) / arg22;
        double v8 = Math.log(Math.abs(v0 / v4));
        int v10 = 0;
        double v12 = v8;
        int v11;
        for(v11 = 0; v11 < 6; ++v11) {
            v12 = v8 - Math.log(Math.abs(v12 / arg22));
        }

        v12 /= arg22;
        long v14 = 0x7FFFFFFFFFFFFFFFL;
        long v16 = 0x7FF0000000000000L;
        int v9 = 1;
        int v8_1 = Long.compare(Double.doubleToRawLongBits(v6) & v14, v16) < 0 ? 1 : 0;
        if(v8_1 == 0) {
            v6 = v12;
        }
        else {
            if((Double.doubleToRawLongBits(v12) & v14) < v16) {
            }
            else {
                v9 = 0;
            }

            if(v9 == 0) {
                goto label_43;
            }

            v6 = Math.max(v6, v12);
        }

    label_43:
        v8 = -(v2 + v4) / (arg22 * v4);
        double v11_1 = arg22 * v8;
        double v13 = Math.exp(v11_1) * arg24 + v4 * v8 * Math.exp(v11_1);
        if(!Double.isNaN(v8)) {
            v11_1 = 0;
            if(v8 <= v11_1) {
                goto label_72;
            }
            else {
                if(v8 > v11_1 && -v13 < v0) {
                    if(v4 >= v11_1) {
                    }
                    else if(arg24 > v11_1) {
                        v6 = v11_1;
                    }
                    else {
                    }

                    goto label_72;
                }

                v6 = -(2 / arg22) - arg24 / v4;
            }
        }
        else {
        label_72:
            v0 = -v0;
        }

        v8 = 1.797693E+308;
        while(v8 > 0.001) {
            if(v10 >= 100) {
                return v6;
            }

            ++v10;
            v11_1 = arg22 * v6;
            v8 = v6 - ((arg24 + v4 * v6) * Math.exp(v11_1) + v0) / (((1 + v11_1) * v4 + v2) * Math.exp(v11_1));
            double v20 = v8;
            v8 = Math.abs(v6 - v8);
            v6 = v20;
        }

        return v6;
    }

    private static final long estimateDurationInternal(double arg12, double arg14, double arg16, double arg18, double arg20, double arg22, double arg24) {
        double v0 = arg20;
        double v2 = 0;
        int v4 = Double.compare(arg22, v2);
        if(v4 == 0 && v0 == v2) {
            return 0;
        }

        if(v4 < 0) {
            v0 = -v0;
        }

        double v8 = v0;
        double v6 = Math.abs(arg22);
        v0 = 1;
        if(arg18 > v0) {
            arg12 = SpringEstimationKt.estimateOverDamped(arg12, arg16, v6, v8, arg24);
        }
        else if(arg18 < v0) {
            arg12 = SpringEstimationKt.estimateUnderDamped(arg12, arg14, v6, v8, arg24);
        }
        else {
            arg12 = SpringEstimationKt.estimateCriticallyDamped(arg12, v6, v8, arg24);
        }

        return ((long)(arg12 * 1000));
    }

    private static final double estimateOverDamped(double arg24, double arg26, double arg28, double arg30, double arg32) {
        double v0 = arg32;
        double v4 = arg24 - arg26;
        double v12 = (arg24 * arg28 - arg30) / v4;
        double v6 = arg28 - v12;
        double v2 = Math.log(Math.abs(v0 / v6)) / arg24;
        double v8 = Math.log(Math.abs(v0 / v12)) / arg26;
        long v14 = 0x7FFFFFFFFFFFFFFFL;
        long v16 = 0x7FF0000000000000L;
        int v11 = 1;
        int v10 = Long.compare(Double.doubleToRawLongBits(v2) & v14, v16) < 0 ? 1 : 0;
        if(v10 == 0) {
            v2 = v8;
        }
        else {
            if((Double.doubleToRawLongBits(v8) & v14) < v16) {
            }
            else {
                v11 = 0;
            }

            if(v11 == 0) {
                goto label_36;
            }

            v2 = Math.max(v2, v8);
        }

    label_36:
        double v16_1 = v6 * arg24;
        double v10_1 = Math.log(v16_1 / (-v12 * arg26)) / (arg26 - arg24);
        if(!Double.isNaN(v10_1)) {
            double v19 = 0;
            if(v10_1 <= v19) {
                goto label_66;
            }
            else {
                if(v10_1 > v19 && -SpringEstimationKt.estimateOverDamped$xInflection(v6, arg24, v10_1, v12, arg26) < v0) {
                    if(v12 <= v19) {
                    }
                    else if(v6 < v19) {
                        v2 = v19;
                    }
                    else {
                    }

                    goto label_66;
                }

                v2 = Math.log(-(v12 * arg26 * arg26) / (v16_1 * arg24)) / v4;
            }
        }
        else {
        label_66:
            v0 = -v0;
        }

        v8 = v12 * arg26;
        if(Math.abs(Math.exp(arg24 * v2) * v16_1 + Math.exp(arg26 * v2) * v8) < 0.0001) {
            return v2;
        }

        v4 = 1.797693E+308;
        v10 = 0;
        while(v4 > 0.001) {
            if(v10 >= 100) {
                return v2;
            }

            ++v10;
            v4 = arg24 * v2;
            double v18 = arg26 * v2;
            v4 = v2 - (Math.exp(v4) * v6 + Math.exp(v18) * v12 + v0) / (Math.exp(v4) * v16_1 + Math.exp(v18) * v8);
            double v22 = v4;
            v4 = Math.abs(v2 - v4);
            v2 = v22;
        }

        return v2;
    }

    private static final double estimateOverDamped$xInflection(double arg0, double arg2, double arg4, double arg6, double arg8) {
        return arg0 * Math.exp(arg2 * arg4) + arg6 * Math.exp(arg8 * arg4);
    }

    private static final double estimateUnderDamped(double arg2, double arg4, double arg6, double arg8, double arg10) {
        arg8 = (arg8 - arg2 * arg6) / arg4;
        return Math.log(arg10 / Math.sqrt(arg6 * arg6 + arg8 * arg8)) / arg2;
    }

    private static final boolean isNotFinite(double arg2) {
        int v2 = Long.compare(Double.doubleToRawLongBits(arg2) & 0x7FFFFFFFFFFFFFFFL, 0x7FF0000000000000L) < 0 ? 1 : 0;
        return v2 ^ 1;
    }

    private static final double iterateNewtonsMethod(double arg2, Function1 arg4, Function1 arg5) {
        return arg2 - arg4.invoke(Double.valueOf(arg2)).doubleValue() / arg5.invoke(Double.valueOf(arg2)).doubleValue();
    }
}

