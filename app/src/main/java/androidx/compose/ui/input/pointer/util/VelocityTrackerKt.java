package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u001A\u0012\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b\u001A!\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\f\u001A1\u0010\r\u001A\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000E2\u0006\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001A2\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u00012\b\b\u0002\u0010\u001D\u001A\u00020\u0018H\u0000\u001A(\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0011\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u00012\u0006\u0010 \u001A\u00020!H\u0002\u001A\u0011\u0010\"\u001A\u00020\u00142\u0006\u0010#\u001A\u00020\u0014H\u0082\b\u001A\u0014\u0010%\u001A\u00020\u0014*\u00020\u00182\u0006\u0010&\u001A\u00020\u0018H\u0002\u001A\r\u0010\'\u001A\u00020\u0014*\u00020\u0018H\u0082\b\u001A(\u0010(\u001A\f\u0012\b\u0012\u00060\u0018j\u0002`)0\u000E2\u0006\u0010*\u001A\u00020\u00012\u0006\u0010+\u001A\u00020\u0001H\u0082\b¢\u0006\u0002\u0010,\u001A,\u0010-\u001A\u00020\u0014*\f\u0012\u0004\u0012\u00020\u00180\u000Ej\u0002`.2\u0006\u0010/\u001A\u00020\u00012\u0006\u00100\u001A\u00020\u0001H\u0082\n¢\u0006\u0002\u00101\u001A4\u0010\r\u001A\u00020\u0005*\f\u0012\u0004\u0012\u00020\u00180\u000Ej\u0002`.2\u0006\u0010/\u001A\u00020\u00012\u0006\u00100\u001A\u00020\u00012\u0006\u00102\u001A\u00020\u0014H\u0082\n¢\u0006\u0002\u00103\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0016\u001A\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"$\u00104\u001A\u00020!8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b5\u00106\u001A\u0004\b7\u00108\"\u0004\b9\u0010:*\f\b\u0002\u0010$\"\u00020\u00182\u00020\u0018*\u0018\b\u0002\u0010(\"\b\u0012\u0004\u0012\u00020\u00180\u000E2\b\u0012\u0004\u0012\u00020\u00180\u000E¨\u0006;"}, d2={"AssumePointerMoveStoppedMilliseconds", "", "HistorySize", "HorizonMilliseconds", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange-0AR0LA0", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "set", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "time", "", "dataPoint", "", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "DefaultWeight", "polyFitLeastSquares", "", "x", "y", "sampleCount", "degree", "coefficients", "calculateImpulseVelocity", "dataPoints", "isDataDifferential", "", "kineticEnergyToVelocity", "kineticEnergy", "Vector", "dot", "a", "norm", "Matrix", "Landroidx/compose/ui/input/pointer/util/Vector;", "rows", "cols", "(II)[[F", "get", "Landroidx/compose/ui/input/pointer/util/Matrix;", "row", "col", "([[FII)F", "value", "([[FIIF)V", "VelocityTrackerAddPointsFix", "getVelocityTrackerAddPointsFix$annotations", "()V", "getVelocityTrackerAddPointsFix", "()Z", "setVelocityTrackerAddPointsFix", "(Z)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static boolean VelocityTrackerAddPointsFix = true;

    static {
    }

    private static final float[][] Matrix(int arg3, int arg4) {
        float[][] v0 = new float[arg3][];
        int v1;
        for(v1 = 0; v1 < arg3; ++v1) {
            v0[v1] = new float[arg4];
        }

        return v0;
    }

    public static final float access$calculateImpulseVelocity(float[] arg0, float[] arg1, int arg2, boolean arg3) {
        return VelocityTrackerKt.calculateImpulseVelocity(arg0, arg1, arg2, arg3);
    }

    public static final void access$set(DataPointAtTime[] arg0, int arg1, long arg2, float arg4) {
        VelocityTrackerKt.set(arg0, arg1, arg2, arg4);
    }

    public static final void addPointerInputChange(VelocityTracker arg2, PointerInputChange arg3) {
        VelocityTrackerKt.addPointerInputChange-0AR0LA0(arg2, arg3, Offset.Companion.getZero-F1C5BW0());
    }

    public static final void addPointerInputChange-0AR0LA0(VelocityTracker arg0, PointerInputChange arg1, long arg2) {
        arg0.getPlatformVelocityTracker$ui().addPointerInputChange-Uv8p0NA(arg1, arg2);
    }

    private static final float calculateImpulseVelocity(float[] arg8, float[] arg9, int arg10, boolean arg11) {
        float v3;
        --arg10;
        float v0 = arg9[arg10];
        float v1 = 0f;
        int v2 = arg10;
        while(true) {
            v3 = 2f;
            if(v2 <= 0) {
                break;
            }

            int v4 = v2 - 1;
            float v5 = arg9[v4];
            if(v0 == v5) {
            }
            else {
                float v4_1 = arg11 ? -arg8[v4] : arg8[v2] - arg8[v4];
                v4_1 /= v0 - v5;
                v1 += (v4_1 - Math.signum(v1) * (((float)Math.sqrt(((double)(v3 * Math.abs(v1))))))) * Math.abs(v4_1);
                if(v2 != arg10) {
                    goto label_33;
                }

                v1 *= 0.5f;
            }

        label_33:
            --v2;
            v0 = v5;
        }

        return Math.signum(v1) * (((float)Math.sqrt(((double)(v3 * Math.abs(v1))))));
    }

    private static final float dot(float[] arg5, float[] arg6) {
        int v0 = arg5.length;
        float v1 = 0f;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1 += arg5[v2] * arg6[v2];
        }

        return v1;
    }

    private static final float get(float[][] arg0, int arg1, int arg2) {
        return arg0[arg1][arg2];
    }

    public static final boolean getVelocityTrackerAddPointsFix() {
        return VelocityTrackerKt.VelocityTrackerAddPointsFix;
    }

    public static void getVelocityTrackerAddPointsFix$annotations() {
    }

    private static final float kineticEnergyToVelocity(float arg3) {
        return Math.signum(arg3) * (((float)Math.sqrt(((double)(2f * Math.abs(arg3))))));
    }

    private static final float norm(float[] arg2) {
        return ((float)Math.sqrt(((double)VelocityTrackerKt.dot(arg2, arg2))));
    }

    public static final float[] polyFitLeastSquares(float[] arg16, float[] arg17, int arg18, int arg19, float[] arg20) {
        float v12;
        float v7;
        int v0 = arg18;
        int v1 = arg19;
        if(v1 < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("The degree must be at positive integer");
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
        }

        if(v1 >= v0) {
            v1 = v0 - 1;
        }

        int v3 = v1 + 1;
        float[][] v4 = new float[v3][];
        int v6;
        for(v6 = 0; v6 < v3; ++v6) {
            v4[v6] = new float[v0];
        }

        for(v6 = 0; true; ++v6) {
            v7 = 1f;
            if(v6 >= v0) {
                break;
            }

            v4[0][v6] = v7;
            int v7_1;
            for(v7_1 = 1; v7_1 < v3; ++v7_1) {
                v4[v7_1][v6] = v4[v7_1 - 1][v6] * arg16[v6];
            }
        }

        float[][] v2 = new float[v3][];
        for(v6 = 0; v6 < v3; ++v6) {
            v2[v6] = new float[v0];
        }

        float[][] v6_1 = new float[v3][];
        int v8;
        for(v8 = 0; v8 < v3; ++v8) {
            v6_1[v8] = new float[v3];
        }

        for(v8 = 0; v8 < v3; ++v8) {
            float[] v9 = v2[v8];
            ArraysKt.copyInto(v4[v8], v9, 0, 0, v0);
            int v10;
            for(v10 = 0; v10 < v8; ++v10) {
                float[] v11 = v2[v10];
                v12 = VelocityTrackerKt.dot(v9, v11);
                int v13;
                for(v13 = 0; v13 < v0; ++v13) {
                    v9[v13] -= v11[v13] * v12;
                }
            }

            float v10_1 = ((float)Math.sqrt(((double)VelocityTrackerKt.dot(v9, v9))));
            float v11_1 = 0.000001f;
            if(v10_1 < v11_1) {
                v10_1 = v11_1;
            }

            v10_1 = v7 / v10_1;
            int v11_2;
            for(v11_2 = 0; v11_2 < v0; ++v11_2) {
                v9[v11_2] *= v10_1;
            }

            float[] v10_2 = v6_1[v8];
            for(v11_2 = 0; v11_2 < v3; ++v11_2) {
                v12 = v11_2 < v8 ? 0f : VelocityTrackerKt.dot(v9, v4[v11_2]);
                v10_2[v11_2] = v12;
            }
        }

        for(v0 = v1; -1 < v0; --v0) {
            float v3_1 = VelocityTrackerKt.dot(v2[v0], arg17);
            float[] v5 = v6_1[v0];
            v7_1 = v0 + 1;
            if(v7_1 <= v1) {
                v8 = v1;
                while(true) {
                    v3_1 -= v5[v8] * arg20[v8];
                    if(v8 != v7_1) {
                        --v8;
                        continue;
                    }

                    break;
                }
            }

            arg20[v0] = v3_1 / v5[v0];
        }

        return arg20;
    }

    public static float[] polyFitLeastSquares$default(float[] arg0, float[] arg1, int arg2, int arg3, float[] arg4, int arg5, Object arg6) {
        if((arg5 & 16) != 0) {
            arg4 = new float[RangesKt.coerceAtLeast(arg3 + 1, 0)];
        }

        return VelocityTrackerKt.polyFitLeastSquares(arg0, arg1, arg2, arg3, arg4);
    }

    private static final void set(DataPointAtTime[] arg1, int arg2, long arg3, float arg5) {
        DataPointAtTime v0 = arg1[arg2];
        if(v0 == null) {
            arg1[arg2] = new DataPointAtTime(arg3, arg5);
            return;
        }

        v0.setTime(arg3);
        v0.setDataPoint(arg5);
    }

    private static final void set(float[][] arg0, int arg1, int arg2, float arg3) {
        arg0[arg1][arg2] = arg3;
    }

    public static final void setVelocityTrackerAddPointsFix(boolean arg0) {
        VelocityTrackerKt.VelocityTrackerAddPointsFix = arg0;
    }
}

