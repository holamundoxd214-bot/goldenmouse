package androidx.compose.ui.graphics;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010\u0002\n\u0002\b\u001D\u001A\u0018\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001A\u0018\u0010\t\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0004H\u0007\u001A \u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001A(\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001A0\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001A \u0010\u0011\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004H\u0007\u001A\u0018\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0004H\u0007\u001A\u0019\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0004H\u0082\b\u001A \u0010\u0016\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0004H\u0002\u001A(\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u0004H\u0007\u001A+\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0019H\u0082\b\u001A2\u0010\u001D\u001A\u00020\u00192\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0019H\u0002\u001A(\u0010\u001E\u001A\u00020\u00192\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0019H\u0002\u001A\'\u0010!\u001A\u00020\"2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0019H\u0007¢\u0006\u0002\u0010#\u001A\'\u0010$\u001A\u00020\"2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0019H\u0000¢\u0006\u0002\u0010#\u001A?\u0010%\u001A\u00020\"2\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u00042\u0006\u0010\'\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0019H\u0007¢\u0006\u0002\u0010(\u001A\u0015\u0010)\u001A\u00020 *\u00020\u00012\u0006\u0010*\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010)\u001A\u00020 *\u00020\u00042\u0006\u0010*\u001A\u00020\u0004H\u0080\b\u001A\u0011\u0010+\u001A\u00020\u00042\u0006\u0010,\u001A\u00020\u0004H\u0082\b\u001A \u0010-\u001A\u00020\u00192\u0006\u0010,\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0019H\u0002\u001A \u0010.\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u001B2\u0006\u00100\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u0004H\u0000\u001A \u00102\u001A\u00020 2\u0006\u00103\u001A\u00020\u00042\u0006\u00104\u001A\u00020\u00042\u0006\u00105\u001A\u00020\u0004H\u0002\u001A0\u00106\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u001B2\u0006\u00100\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u001B2\u0006\u00108\u001A\u00020\u001BH\u0000\u001A0\u00109\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u001B2\u0006\u0010:\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u00042\u0006\u00108\u001A\u00020\u001BH\u0002\u001A\u0018\u0010;\u001A\u00020\u00192\u0006\u0010<\u001A\u00020\u001B2\u0006\u0010=\u001A\u00020\u001BH\u0002\u001A \u0010>\u001A\u00020?2\u0006\u0010@\u001A\u00020\u001B2\u0006\u0010=\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001A\u0018\u0010A\u001A\u00020\u00042\u0006\u00100\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u0004H\u0002\u001A0\u0010B\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u001B2\u0006\u00100\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u00042\u0006\u0010C\u001A\u00020\u001B2\u0006\u00108\u001A\u00020\u001BH\u0000\u001A(\u0010D\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u001B2\u0006\u0010:\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u0004H\u0002\u001A \u0010E\u001A\u00020\u00192\u0006\u0010F\u001A\u00020\u001B2\u0006\u0010=\u001A\u00020\u001B2\u0006\u0010G\u001A\u00020\u001BH\u0002\u001A\u0018\u0010H\u001A\u00020\u00192\u0006\u0010F\u001A\u00020\u001B2\u0006\u0010I\u001A\u00020\u001BH\u0002\u001A0\u0010J\u001A\u00020?2\u0006\u0010@\u001A\u00020\u001B2\u0006\u0010K\u001A\u00020\u00192\u0006\u0010=\u001A\u00020\u001B2\u0006\u0010L\u001A\u00020\u00192\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001AH\u0010M\u001A\u00020\u00042\u0006\u0010N\u001A\u00020\u00042\u0006\u00103\u001A\u00020\u00042\u0006\u0010O\u001A\u00020\u00042\u0006\u00104\u001A\u00020\u00042\u0006\u0010P\u001A\u00020\u00042\u0006\u00105\u001A\u00020\u00042\u0006\u0010Q\u001A\u00020\u00042\u0006\u0010R\u001A\u00020\u0004H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010S\u001A\u00020\u0004*\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\bT\u0010U\"\u0018\u0010V\u001A\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bW\u0010U\"\u0019\u0010X\u001A\u00020\u0004*\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\bY\u0010U\"\u0018\u0010Z\u001A\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b[\u0010U¨\u0006\\"}, d2={"Tau", "", "Epsilon", "FloatEpsilon", "", "evaluateX", "segment", "Landroidx/compose/ui/graphics/PathSegment;", "t", "evaluateY", "evaluateLine", "p0y", "p1y", "evaluateQuadratic", "p0", "p1", "p2", "evaluateCubic", "p3", "findFirstRoot", "fraction", "findFirstLineRoot", "findFirstQuadraticRoot", "findFirstCubicRoot", "findLineRoot", "", "roots", "", "index", "findQuadraticRoots", "findDerivativeRoots", "horizontal", "", "computeHorizontalBounds", "Landroidx/collection/FloatFloatPair;", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "computeCubicVerticalBounds", "p2y", "p3y", "(FFFF[FI)J", "closeTo", "b", "clampValidRootInUnitRange", "r", "writeValidRootInUnitRange", "lineWinding", "points", "x", "y", "isQuadraticMonotonic", "y0", "y1", "y2", "quadraticWinding", "tmpQuadratics", "tmpRoots", "monotonicQuadraticWinding", "offset", "quadraticToMonotonicQuadratics", "quadratic", "dst", "splitQuadraticAt", "", "src", "unitDivide", "cubicWinding", "tmpCubics", "monotonicCubicWinding", "cubicToMonotonicCubics", "cubic", "tmpRoot", "findCubicExtremaY", "dstRoots", "splitCubicAt", "srcOffset", "dstOffset", "cubicArea", "x0", "x1", "x2", "x3", "y3", "startX", "getStartX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "endX", "getEndX", "startY", "getStartY", "endY", "getEndY", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BezierKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Type.values().length];
            try {
                v0[Type.Move.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Type.Line.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Type.Quadratic.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Type.Cubic.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[Type.Conic.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[Type.Close.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[Type.Done.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final double Epsilon = 1.000000E-07;
    private static final float FloatEpsilon = 0.000001f;
    private static final double Tau = 6.283185;

    public static final int access$writeValidRootInUnitRange(float arg0, float[] arg1, int arg2) {
        return BezierKt.writeValidRootInUnitRange(arg0, arg1, arg2);
    }

    private static final float clampValidRootInUnitRange(float arg3) {
        float v0 = 0f;
        if(arg3 < 0f) {
        }
        else {
            v0 = arg3;
        }

        float v1 = 1f;
        if(v0 > v1) {
            v0 = v1;
        }

        if(Math.abs(v0 - arg3) > 0.000001f) {
            return NaNf;
        }

        return v0;
    }

    public static final boolean closeTo(double arg0, double arg2) {
        if(Math.abs(arg0 - arg2) < 1.000000E-07) {
            return 1;
        }

        return 0;
    }

    public static final boolean closeTo(float arg0, float arg1) {
        if(Math.abs(arg0 - arg1) < 0.000001f) {
            return 1;
        }

        return 0;
    }

    public static final long computeCubicVerticalBounds(float arg5, float arg6, float arg7, float arg8, float[] arg9, int arg10) {
        float v0 = (arg6 - arg5) * 3f;
        float v2 = (arg7 - arg6) * 3f;
        float v3 = (arg8 - arg7) * 3f;
        int v1 = BezierKt.findQuadraticRoots(v0, v2, v3, arg9, arg10);
        v0 = (v2 - v0) * 2f;
        v1 += BezierKt.writeValidRootInUnitRange(-v0 / ((v3 - v2) * 2f - v0), arg9, arg10 + v1);
        float v10 = Math.min(arg5, arg8);
        v0 = Math.max(arg5, arg8);
        int v2_1;
        for(v2_1 = 0; v2_1 < v1; ++v2_1) {
            v3 = BezierKt.evaluateCubic(arg5, arg6, arg7, arg8, arg9[v2_1]);
            v10 = Math.min(v10, v3);
            v0 = Math.max(v0, v3);
        }

        return FloatFloatPair.constructor-impl(v10, v0);
    }

    public static long computeCubicVerticalBounds$default(float arg6, float arg7, float arg8, float arg9, float[] arg10, int arg11, int arg12, Object arg13) {
        return BezierKt.computeCubicVerticalBounds(arg6, arg7, arg8, arg9, arg10, 0);
    }

    public static final long computeHorizontalBounds(PathSegment arg4, float[] arg5, int arg6) {
        arg6 = BezierKt.findDerivativeRoots(arg4, true, arg5, arg6);
        int v1 = 0;
        float v0 = Math.min(arg4.getPoints()[0], BezierKt.getEndX(arg4));
        float v2 = Math.max(arg4.getPoints()[0], BezierKt.getEndX(arg4));
        while(v1 < arg6) {
            float v3 = BezierKt.evaluateX(arg4, arg5[v1]);
            v0 = Math.min(v0, v3);
            v2 = Math.max(v2, v3);
            ++v1;
        }

        return FloatFloatPair.constructor-impl(v0, v2);
    }

    public static long computeHorizontalBounds$default(PathSegment arg0, float[] arg1, int arg2, int arg3, Object arg4) {
        return BezierKt.computeHorizontalBounds(arg0, arg1, 0);
    }

    public static final long computeVerticalBounds(PathSegment arg4, float[] arg5, int arg6) {
        int v0 = 0;
        arg6 = BezierKt.findDerivativeRoots(arg4, false, arg5, arg6);
        float v1 = Math.min(arg4.getPoints()[1], BezierKt.getEndY(arg4));
        float v2 = Math.max(arg4.getPoints()[1], BezierKt.getEndY(arg4));
        while(v0 < arg6) {
            float v3 = BezierKt.evaluateY(arg4, arg5[v0]);
            v1 = Math.min(v1, v3);
            v2 = Math.max(v2, v3);
            ++v0;
        }

        return FloatFloatPair.constructor-impl(v1, v2);
    }

    public static long computeVerticalBounds$default(PathSegment arg0, float[] arg1, int arg2, int arg3, Object arg4) {
        return BezierKt.computeVerticalBounds(arg0, arg1, 0);
    }

    public static final float cubicArea(float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10) {
        return ((arg10 - arg4) * (arg5 + arg7) - (arg9 - arg3) * (arg6 + arg8) + arg6 * (arg3 - arg7) - arg5 * (arg4 - arg8) + arg10 * (arg7 + arg3 / 3f) - arg9 * (arg8 + arg4 / 3f)) * 3f / 20f;
    }

    private static final int cubicToMonotonicCubics(float[] arg7, float[] arg8, float[] arg9) {
        int v0 = BezierKt.findCubicExtremaY(arg7, arg9);
        int v1 = 0;
        if(v0 == 0) {
            int v2 = 8;
            if(arg8.length < v2) {
                return 0;
            }

            ArraysKt.copyInto(arg7, arg8, 0, 0, v2);
            return v0;
        }

        int v3 = 0;
        float v4 = 0f;
        while(v1 < v0) {
            float v6 = 1f;
            float v5 = (arg9[v1] - v4) / (v6 - v4);
            if(v5 < 0f) {
                v5 = 0f;
            }

            v4 = v5 > v6 ? v6 : v5;
            BezierKt.splitCubicAt(arg7, v3, arg8, v3, v4);
            v3 += 6;
            ++v1;
            arg7 = arg8;
        }

        return v0;
    }

    public static final int cubicWinding(float[] arg2, float arg3, float arg4, float[] arg5, float[] arg6) {
        int v2 = BezierKt.cubicToMonotonicCubics(arg2, arg5, arg6);
        int v6 = 0;
        if(v2 >= 0) {
            int v0 = 0;
            while(true) {
                v6 += BezierKt.monotonicCubicWinding(arg5, v0 * 6, arg3, arg4);
                if(v0 != v2) {
                    ++v0;
                    continue;
                }

                return v6;
            }
        }

        return v6;
    }

    public static final float evaluateCubic(float arg2, float arg3, float arg4) {
        return (((arg2 - arg3 + 0.333333f) * arg4 + (arg3 - 2f * arg2)) * arg4 + arg2) * 3f * arg4;
    }

    private static final float evaluateCubic(float arg2, float arg3, float arg4, float arg5, float arg6) {
        return (((arg5 + (arg3 - arg4) * 3f - arg2) * arg6 + (arg4 - 2f * arg3 + arg2) * 3f) * arg6 + (arg3 - arg2) * 3f) * arg6 + arg2;
    }

    private static final float evaluateLine(float arg0, float arg1, float arg2) {
        return (arg1 - arg0) * arg2 + arg0;
    }

    private static final float evaluateQuadratic(float arg2, float arg3, float arg4, float arg5) {
        return ((arg4 - arg3 * 2f + arg2) * arg5 + (arg3 - arg2) * 2f) * arg5 + arg2;
    }

    private static final float evaluateX(PathSegment arg5, float arg6) {
        float[] v0 = arg5.getPoints();
        int v5 = WhenMappings.$EnumSwitchMapping$0[arg5.getType().ordinal()];
        if(v5 != 1) {
            int v1 = 2;
            if(v5 != v1) {
                int v4 = 4;
                if(v5 != 3) {
                    if(v5 != v4) {
                        return NaNf;
                    }

                    return BezierKt.evaluateCubic(v0[0], v0[v1], v0[v4], v0[6], arg6);
                }

                return BezierKt.evaluateQuadratic(v0[0], v0[v1], v0[v4], arg6);
            }

            return BezierKt.evaluateLine(v0[0], v0[v1], arg6);
        }

        return v0[0];
    }

    public static final float evaluateY(PathSegment arg5, float arg6) {
        float[] v0 = arg5.getPoints();
        int v5 = WhenMappings.$EnumSwitchMapping$0[arg5.getType().ordinal()];
        if(v5 != 1) {
            int v3 = 3;
            if(v5 != 2) {
                int v2 = 5;
                if(v5 != v3) {
                    if(v5 != 4) {
                        return NaNf;
                    }

                    return BezierKt.evaluateCubic(v0[1], v0[v3], v0[v2], v0[7], arg6);
                }

                return BezierKt.evaluateQuadratic(v0[1], v0[v3], v0[v2], arg6);
            }

            return BezierKt.evaluateLine(v0[1], v0[v3], arg6);
        }

        return v0[1];
    }

    private static final int findCubicExtremaY(float[] arg5, float[] arg6) {
        return BezierKt.findQuadraticRoots(arg5[7] - arg5[1] + (arg5[3] - arg5[5]) * 3f, (arg5[1] - arg5[3] - arg5[3] - arg5[5]) * 2f, arg5[3] - arg5[1], arg6, 0);
    }

    private static final int findDerivativeRoots(PathSegment arg5, boolean arg6, float[] arg7, int arg8) {
        float v1;
        float v5_1;
        int v6 = (((int)arg6)) ^ 1;
        float[] v0 = arg5.getPoints();
        int v5 = WhenMappings.$EnumSwitchMapping$0[arg5.getType().ordinal()];
        float v2 = 2f;
        int v3 = 4;
        if(v5 != 3) {
            if(v5 != v3) {
                return 0;
            }

            v5_1 = v0[v6 + 2];
            v1 = (v5_1 - v0[v6]) * 3f;
            v5_1 = (v0[v6 + 4] - v5_1) * 3f;
            float v6_1 = (v0[v6 + 6] - v0[v6 + 4]) * 3f;
            int v0_1 = BezierKt.findQuadraticRoots(v1, v5_1, v6_1, arg7, arg8);
            v1 = (v5_1 - v1) * v2;
            return v0_1 + BezierKt.writeValidRootInUnitRange(-v1 / ((v6_1 - v5_1) * v2 - v1), arg7, arg8 + v0_1);
        }

        v5_1 = v0[v6 + 2];
        v1 = (v5_1 - v0[v6]) * v2;
        return BezierKt.writeValidRootInUnitRange(-v1 / (v2 * (v0[v6 + v3] - v5_1) - v1), arg7, arg8);
    }

    public static final float findFirstCubicRoot(float arg21, float arg22, float arg23, float arg24) {
        float v3_1;
        float v2;
        float v0_1;
        double v3 = ((double)arg21);
        double v7 = 2;
        double v9 = 3;
        double v5 = (v3 - (((double)arg22)) * v7 + (((double)arg23))) * v9;
        double v11 = (((double)(arg22 - arg21))) * v9;
        double v13 = (((double)(-arg21))) + (((double)(arg22 - arg23))) * v9 + (((double)arg24));
        double v0 = 0;
        double v17 = 1.000000E-07;
        float v15 = 0.000001f;
        float v16 = 1f;
        float v19 = 0f;
        float v20 = NaNf;
        if(Double.compare(Math.abs(v13 - v0), v17) < 0) {
            if(Math.abs(v5 - v0) < v17) {
                if(Math.abs(v11 - v0) < v17) {
                    return v20;
                }

                v0_1 = ((float)(-v3 / v11));
                if(v0_1 < 0f) {
                }
                else {
                    v19 = v0_1;
                }

                if(v19 > v16) {
                }
                else {
                    v16 = v19;
                }

                if(Math.abs(v16 - v0_1) > v15) {
                    return v20;
                }

                return v16;
            }

            v0 = Math.sqrt(v11 * v11 - 4 * v5 * v3);
            v5 *= v7;
            v2 = ((float)((v0 - v11) / v5));
            v3_1 = v2 < 0f ? 0f : v2;
            if(v3_1 > v16) {
                v3_1 = v16;
            }

            if(Math.abs(v3_1 - v2) > v15) {
                v3_1 = v20;
            }

            if(!Float.isNaN(v3_1)) {
                return v3_1;
            }

            v0_1 = ((float)((-v11 - v0) / v5));
            if(v0_1 < 0f) {
            }
            else {
                v19 = v0_1;
            }

            if(v19 > v16) {
            }
            else {
                v16 = v19;
            }

            if(Math.abs(v16 - v0_1) > v15) {
                return v20;
            }

            return v16;
        }

        v5 /= v13;
        v11 /= v13;
        v3 /= v13;
        v13 = (v11 * v9 - v5 * v5) / 9;
        v7 = (v7 * v5 * v5 * v5 - 9 * v5 * v11 + v3 * 27) / 54;
        v11 = v13 * v13 * v13;
        double v2_1 = v7 * v7 + v11;
        v5 /= v9;
        int v0_2 = Double.compare(v2_1, v0);
        float v1 = 2f;
        if(v0_2 < 0) {
            v2_1 = Math.sqrt(-v11);
            v7 = -v7 / v2_1;
            v11 = -1;
            if(v7 < v11) {
                v7 = v11;
            }

            v11 = 1;
            if(v7 > v11) {
                v7 = v11;
            }

            v7 = Math.acos(v7);
            v0 = ((double)(MathHelpersKt.fastCbrt(((float)v2_1)) * v1));
            v2 = ((float)(Math.cos(v7 / v9) * v0 - v5));
            v3_1 = v2 < 0f ? 0f : v2;
            if(v3_1 > v16) {
                v3_1 = v16;
            }

            if(Math.abs(v3_1 - v2) > v15) {
                v3_1 = v20;
            }

            if(!Float.isNaN(v3_1)) {
                return v3_1;
            }

            v2 = ((float)(Math.cos((6.283185 + v7) / v9) * v0 - v5));
            v3_1 = v2 < 0f ? 0f : v2;
            if(v3_1 > v16) {
                v3_1 = v16;
            }

            if(Math.abs(v3_1 - v2) > v15) {
                v3_1 = v20;
            }

            if(!Float.isNaN(v3_1)) {
                return v3_1;
            }

            v0_1 = ((float)(v0 * Math.cos((v7 + 12.566371) / v9) - v5));
            if(v0_1 < 0f) {
            }
            else {
                v19 = v0_1;
            }

            if(v19 > v16) {
            }
            else {
                v16 = v19;
            }

            if(Math.abs(v16 - v0_1) > v15) {
                return v20;
            }

            return v16;
        }

        if(v0_2 == 0) {
            v0_1 = -MathHelpersKt.fastCbrt(((float)v7));
            v2 = ((float)v5);
            v1 = v1 * v0_1 - v2;
            v3_1 = v1 < 0f ? 0f : v1;
            if(v3_1 > v16) {
                v3_1 = v16;
            }

            if(Math.abs(v3_1 - v1) > v15) {
                v3_1 = v20;
            }

            if(!Float.isNaN(v3_1)) {
                return v3_1;
            }

            v0_1 = -v0_1 - v2;
            if(v0_1 < 0f) {
            }
            else {
                v19 = v0_1;
            }

            if(v19 > v16) {
            }
            else {
                v16 = v19;
            }

            if(Math.abs(v16 - v0_1) > v15) {
                return v20;
            }

            return v16;
        }

        v0 = Math.sqrt(v2_1);
        v0_1 = ((float)((((double)(MathHelpersKt.fastCbrt(((float)(-v7 + v0))) - MathHelpersKt.fastCbrt(((float)(v7 + v0)))))) - v5));
        if(v0_1 < 0f) {
        }
        else {
            v19 = v0_1;
        }

        if(v19 > v16) {
        }
        else {
            v16 = v19;
        }

        if(Math.abs(v16 - v0_1) > v15) {
            return v20;
        }

        return v16;
    }

    private static final float findFirstLineRoot(float arg2, float arg3) {
        float v0 = -arg2 / (arg3 - arg2);
        arg2 = 0f;
        if(v0 < 0f) {
        }
        else {
            arg2 = v0;
        }

        arg3 = 1f;
        if(arg2 > arg3) {
            arg2 = arg3;
        }

        if(Math.abs(arg2 - v0) > 0.000001f) {
            arg2 = NaNf;
        }

        return arg2;
    }

    private static final float findFirstQuadraticRoot(float arg17, float arg18, float arg19) {
        float v0_1;
        double v0 = ((double)arg17);
        double v2 = ((double)arg18);
        double v4 = ((double)arg19);
        double v6 = 2;
        double v8 = v2 * v6;
        double v10 = v0 - v8 + v4;
        float v13 = 0.000001f;
        float v14 = 1f;
        float v15 = 0f;
        float v16 = NaNf;
        if(Double.compare(v10, 0) == 0) {
            if(v2 == v4) {
                return v16;
            }

            v0_1 = ((float)((v8 - v4) / (v8 - v4 * v6)));
            if(v0_1 < 0f) {
            }
            else {
                v15 = v0_1;
            }

            if(v15 > v14) {
            }
            else {
                v14 = v15;
            }

            if(Math.abs(v14 - v0_1) > v13) {
                return v16;
            }

            return v14;
        }

        v4 = -Math.sqrt(v2 * v2 - v4 * v0);
        v0 = -v0 + v2;
        float v2_1 = ((float)(-(v4 + v0) / v10));
        float v3 = v2_1 < 0f ? 0f : v2_1;
        if(v3 > v14) {
            v3 = v14;
        }

        if(Math.abs(v3 - v2_1) > v13) {
            v3 = v16;
        }

        if(!Float.isNaN(v3)) {
            return v3;
        }

        v0_1 = ((float)((v4 - v0) / v10));
        if(v0_1 < 0f) {
        }
        else {
            v15 = v0_1;
        }

        if(v15 > v14) {
        }
        else {
            v14 = v15;
        }

        if(Math.abs(v14 - v0_1) > v13) {
            return v16;
        }

        return v14;
    }

    public static final float findFirstRoot(PathSegment arg5, float arg6) {
        float[] v0 = arg5.getPoints();
        int v1 = 4;
        int v2 = 2;
        float v4 = NaNf;
        switch(WhenMappings.$EnumSwitchMapping$0[arg5.getType().ordinal()]) {
            case 1: {
                return v4;
            }
            case 2: {
                goto label_33;
            }
            case 3: {
                goto label_25;
            }
            case 4: {
                goto label_14;
            }
            case 5: 
            case 6: 
            case 7: {
                return v4;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_33:
        float v5 = v0[0] - arg6;
        arg6 = -v5 / (v0[v2] - arg6 - v5);
        v5 = 0f;
        if(arg6 < 0f) {
        }
        else {
            v5 = arg6;
        }

        float v0_1 = 1f;
        if(v5 > v0_1) {
            v5 = v0_1;
        }

        if(Math.abs(v5 - arg6) > 0.000001f) {
            return v4;
        }

        return v5;
    label_25:
        return BezierKt.findFirstQuadraticRoot(v0[0] - arg6, v0[v2] - arg6, v0[v1] - arg6);
    label_14:
        return BezierKt.findFirstCubicRoot(v0[0] - arg6, v0[v2] - arg6, v0[v1] - arg6, v0[6] - arg6);
    }

    private static final int findLineRoot(float arg1, float arg2, float[] arg3, int arg4) {
        return BezierKt.writeValidRootInUnitRange(-arg1 / (arg2 - arg1), arg3, arg4);
    }

    static int findLineRoot$default(float arg0, float arg1, float[] arg2, int arg3, int arg4, Object arg5) {
        return BezierKt.writeValidRootInUnitRange(-arg0 / (arg1 - arg0), arg2, 0);
    }

    private static final int findQuadraticRoots(float arg17, float arg18, float arg19, float[] arg20, int arg21) {
        float[] v0 = arg20;
        int v2 = arg21;
        double v3 = ((double)arg17);
        double v5 = ((double)arg18);
        double v7 = ((double)arg19);
        double v9 = 2;
        double v11 = v5 * v9;
        double v13 = v3 - v11 + v7;
        if(v13 == 0) {
            if(v5 == v7) {
                return 0;
            }

            return BezierKt.writeValidRootInUnitRange(((float)((v11 - v7) / (v11 - v7 * v9))), v0, v2);
        }

        v7 = -Math.sqrt(v5 * v5 - v7 * v3);
        v3 = -v3 + v5;
        int v1 = BezierKt.writeValidRootInUnitRange(((float)(-(v7 + v3) / v13)), v0, v2);
        v1 += BezierKt.writeValidRootInUnitRange(((float)((v7 - v3) / v13)), v0, v2 + v1);
        if(v1 > 1) {
            float v3_1 = v0[v2];
            int v4 = v2 + 1;
            float v5_1 = v0[v4];
            if(v3_1 > v5_1) {
                v0[v2] = v5_1;
                v0[v4] = v3_1;
                return v1;
            }
            else if(v3_1 == v5_1) {
                --v1;
            }
        }

        return v1;
    }

    static int findQuadraticRoots$default(float arg0, float arg1, float arg2, float[] arg3, int arg4, int arg5, Object arg6) {
        return BezierKt.findQuadraticRoots(arg0, arg1, arg2, arg3, 0);
    }

    private static final float getEndX(PathSegment arg3) {
        float[] v0 = arg3.getPoints();
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.getType().ordinal()];
        int v1 = 2;
        if(v3 != v1) {
            int v2 = 4;
            if(v3 != 3) {
                if(v3 == v2) {
                    v1 = 6;
                    goto label_18;
                }
                else if(v3 != 5) {
                    v1 = 0;
                    goto label_18;
                }
            }

            v1 = v2;
        }

    label_18:
        return v0[v1];
    }

    private static final float getEndY(PathSegment arg3) {
        float[] v0 = arg3.getPoints();
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.getType().ordinal()];
        int v2 = 3;
        if(v3 != 2) {
            int v1 = 5;
            if(v3 != v2) {
                if(v3 == 4) {
                    v2 = 7;
                    goto label_18;
                }
                else if(v3 != v1) {
                    v2 = 0;
                    goto label_18;
                }
            }

            v2 = v1;
        }

    label_18:
        return v0[v2];
    }

    private static final float getStartX(PathSegment arg1) {
        return arg1.getPoints()[0];
    }

    private static final float getStartY(PathSegment arg1) {
        return arg1.getPoints()[1];
    }

    private static final boolean isQuadraticMonotonic(float arg0, float arg1, float arg2) {
        int v0 = Float.compare(Math.signum(arg0 - arg1) + Math.signum(arg1 - arg2), 0f) == 0 ? 1 : 0;
        return v0 ^ 1;
    }

    public static final int lineWinding(float[] arg7, float arg8, float arg9) {
        float v1;
        int v6;
        if(arg7.length < 4) {
            return 0;
        }

        float v0 = arg7[0];
        float v3 = arg7[1];
        float v4 = arg7[2];
        float v7 = arg7[3];
        float v5 = v7 - v3;
        if(v3 > v7) {
            v6 = -1;
            v1 = v3;
        }
        else {
            v6 = 1;
            v1 = v7;
            v7 = v3;
        }

        if(arg9 >= v7) {
            if(arg9 >= v1) {
            }
            else {
                v4 = (v4 - v0) * (arg9 - v3) - v5 * (arg8 - v0);
                if(v4 == 0f) {
                    return 0;
                }
                else if((((int)Math.signum(v4))) == v6) {
                    return 0;
                }
                else {
                    return v6;
                }
            }
        }

        return 0;
    }

    private static final int monotonicCubicWinding(float[] arg10, int arg11, float arg12, float arg13) {
        int v4;
        int v0 = arg11 + 1;
        float v1 = arg10[v0];
        int v2 = arg11 + 7;
        float v3 = arg10[v2];
        if(v1 > v3) {
            v4 = -1;
            float v9 = v3;
            v3 = v1;
            v1 = v9;
        }
        else {
            v4 = 1;
        }

        if(Float.compare(arg13, v1) >= 0) {
            if(arg13 >= v3) {
            }
            else {
                v1 = arg10[arg11];
                v3 = arg10[arg11 + 2];
                float v6 = arg10[arg11 + 4];
                float v7 = arg10[arg11 + 6];
                if(arg12 < Math.min(v1, Math.min(v3, Math.min(v6, v7)))) {
                    return 0;
                }
                else {
                    if(arg12 > Math.max(v1, Math.max(v3, Math.max(v6, v7)))) {
                    }
                    else {
                        float v0_1 = arg10[v0];
                        float v8 = arg10[arg11 + 3];
                        float v11 = arg10[arg11 + 5];
                        float v10 = arg10[v2];
                        v11 = BezierKt.findFirstCubicRoot(v0_1 - arg13, v8 - arg13, v11 - arg13, v10 - arg13);
                        if(Float.isNaN(v11)) {
                            return 0;
                        }
                        else {
                            v11 = BezierKt.evaluateCubic(v1, v3, v6, v7, v11);
                            if(Math.abs(v11 - arg12) < 0.000001f && (arg12 != v7 || arg13 != v10)) {
                                return 0;
                            }

                            if(v11 >= arg12) {
                                return 0;
                            }
                        }
                    }

                    return v4;
                }
            }
        }

        return 0;
    }

    private static final int monotonicQuadraticWinding(float[] arg13, int arg14, float arg15, float arg16, float[] arg17) {
        float v3;
        float v4;
        int v2;
        float v0 = arg13[arg14 + 1];
        float v1 = arg13[arg14 + 5];
        if(v0 > v1) {
            v2 = -1;
            v4 = v0;
            v3 = v1;
        }
        else {
            v2 = 1;
            v3 = v0;
            v4 = v1;
        }

        if(Float.compare(arg16, v3) >= 0) {
            if(arg16 >= v4) {
            }
            else {
                arg14 = BezierKt.findQuadraticRoots$default(v0 - arg13[arg14 + 3] * 2f + v1, (arg13[arg14 + 3] - v0) * 2f, v0 - arg16, arg17, 0, 16, null);
                int v0_1 = 4;
                int v3_1 = 2;
                float v14 = arg14 == 0 ? arg13[(1 - v2) * v3_1] : BezierKt.evaluateQuadratic(arg13[0], arg13[v3_1], arg13[v0_1], arg17[0]);
                if(Math.abs(v14 - arg15) < 0.000001f && (arg15 != arg13[v0_1] || arg16 != v1)) {
                    return 0;
                }

                if(v14 >= arg15) {
                    return 0;
                }

                return v2;
            }
        }

        return 0;
    }

    private static final int quadraticToMonotonicQuadratics(float[] arg10, float[] arg11) {
        int v2 = 6;
        if(arg10.length < v2) {
            return 0;
        }

        if(arg11.length < v2) {
            return 0;
        }

        float v3 = arg10[1];
        int v4 = 3;
        float v5 = arg10[v4];
        float v6 = arg10[5];
        if(!BezierKt.isQuadraticMonotonic(v3, v5, v6)) {
            float v7 = v3 - v5;
            float v8 = BezierKt.unitDivide(v7, v7 - v5 + v6);
            if(!Float.isNaN(v8)) {
                BezierKt.splitQuadraticAt(arg10, arg11, v8);
                return 1;
            }
            else {
                if(Math.abs(v7) < Math.abs(v5 - v6)) {
                }
                else {
                    v3 = v6;
                }

                v5 = v3;
            }
        }

        ArraysKt.copyInto(arg10, arg11, 0, 0, v2);
        arg11[v4] = v5;
        return 0;
    }

    public static final int quadraticWinding(float[] arg3, float arg4, float arg5, float[] arg6, float[] arg7) {
        if(BezierKt.isQuadraticMonotonic(arg3[1], arg3[3], arg3[5])) {
            return BezierKt.monotonicQuadraticWinding(arg3, 0, arg4, arg5, arg7);
        }

        int v3 = BezierKt.quadraticToMonotonicQuadratics(arg3, arg6);
        int v0 = BezierKt.monotonicQuadraticWinding(arg6, 0, arg4, arg5, arg7);
        if(v3 > 0) {
            v0 += BezierKt.monotonicQuadraticWinding(arg6, 4, arg4, arg5, arg7);
        }

        return v0;
    }

    private static final void splitCubicAt(float[] arg7, int arg8, float[] arg9, int arg10, float arg11) {
        float v7;
        if(arg7.length < arg8 + 8) {
        }
        else {
            if(arg9.length < arg10 + 14) {
                return;
            }

            goto label_8;
        }

        return;
    label_8:
        if(arg11 >= 1f) {
            ArraysKt.copyInto(arg7, arg9, arg10, arg8, 8);
            arg11 = arg7[arg8 + 6];
            v7 = arg7[arg8 + 7];
            arg9[arg10 + 8] = arg11;
            arg9[arg10 + 9] = v7;
            arg9[arg10 + 10] = arg11;
            arg9[arg10 + 11] = v7;
            arg9[arg10 + 12] = arg11;
            arg9[arg10 + 13] = v7;
            return;
        }

        float v0 = arg7[arg8];
        float v1 = arg7[arg8 + 1];
        arg9[arg10] = v0;
        arg9[arg10 + 1] = v1;
        float v2 = arg7[arg8 + 2];
        float v3 = arg7[arg8 + 3];
        v0 = MathHelpersKt.lerp(v0, v2, arg11);
        v1 = MathHelpersKt.lerp(v1, v3, arg11);
        arg9[arg10 + 2] = v0;
        arg9[arg10 + 3] = v1;
        float v4 = arg7[arg8 + 4];
        float v5 = arg7[arg8 + 5];
        v2 = MathHelpersKt.lerp(v2, v4, arg11);
        v3 = MathHelpersKt.lerp(v3, v5, arg11);
        v0 = MathHelpersKt.lerp(v0, v2, arg11);
        v1 = MathHelpersKt.lerp(v1, v3, arg11);
        arg9[arg10 + 4] = v0;
        arg9[arg10 + 5] = v1;
        float v6 = arg7[arg8 + 6];
        v7 = arg7[arg8 + 7];
        float v8 = MathHelpersKt.lerp(v4, v6, arg11);
        v4 = MathHelpersKt.lerp(v5, v7, arg11);
        v2 = MathHelpersKt.lerp(v2, v8, arg11);
        v3 = MathHelpersKt.lerp(v3, v4, arg11);
        v0 = MathHelpersKt.lerp(v0, v2, arg11);
        arg11 = MathHelpersKt.lerp(v1, v3, arg11);
        arg9[arg10 + 6] = v0;
        arg9[arg10 + 7] = arg11;
        arg9[arg10 + 8] = v2;
        arg9[arg10 + 9] = v3;
        arg9[arg10 + 10] = v8;
        arg9[arg10 + 11] = v4;
        arg9[arg10 + 12] = v6;
        arg9[arg10 + 13] = v7;
    }

    private static final void splitQuadraticAt(float[] arg17, float[] arg18, float arg19) {
        float[] v0 = arg17;
        float[] v1 = arg18;
        float v2 = arg19;
        int v4 = 6;
        if(v0.length < v4) {
        }
        else {
            if(v1.length < 10) {
                return;
            }

            goto label_11;
        }

        return;
    label_11:
        float v5 = v0[0];
        float v7 = v0[1];
        float v9 = v0[2];
        float v11 = v0[3];
        float v13 = v0[4];
        float v0_1 = v0[5];
        float v15 = MathHelpersKt.lerp(v5, v9, v2);
        float v3 = MathHelpersKt.lerp(v7, v11, v2);
        v1[0] = v5;
        v1[1] = v7;
        v1[2] = v15;
        v1[3] = v3;
        v5 = MathHelpersKt.lerp(v9, v13, v2);
        float v6 = MathHelpersKt.lerp(v11, v0_1, v2);
        v7 = MathHelpersKt.lerp(v15, v5, v2);
        v2 = MathHelpersKt.lerp(v3, v6, v2);
        v1[4] = v7;
        v1[5] = v2;
        v1[v4] = v5;
        v1[7] = v6;
        v1[8] = v13;
        v1[9] = v0_1;
    }

    private static final float unitDivide(float arg3, float arg4) {
        if(arg3 < 0f) {
            arg3 = -arg3;
            arg4 = -arg4;
        }

        float v2 = NaNf;
        if(Float.compare(arg4, 0f) == 0) {
        }
        else if(arg3 == 0f) {
        }
        else {
            if(arg3 >= arg4) {
                return v2;
            }

            goto label_12;
        }

        return v2;
    label_12:
        arg3 /= arg4;
        if(arg3 == 0f) {
            return v2;
        }

        return arg3;
    }

    private static final int writeValidRootInUnitRange(float arg3, float[] arg4, int arg5) {
        float v0 = 0f;
        if(arg3 < 0f) {
        }
        else {
            v0 = arg3;
        }

        float v1 = 1f;
        if(v0 > v1) {
            v0 = v1;
        }

        if(Math.abs(v0 - arg3) > 0.000001f) {
            v0 = NaNf;
        }

        arg4[arg5] = v0;
        return Float.isNaN(v0) ^ 1;
    }
}

