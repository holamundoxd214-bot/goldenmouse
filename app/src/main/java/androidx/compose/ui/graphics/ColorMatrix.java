package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0086\n¢\u0006\u0004\b\r\u0010\u000EJ(\u0010\u000F\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\tH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0010H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019JP\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\t26\u0010\u001C\u001A2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\u001DH\u0082\b¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001A\u00020\u00102\u0006\u0010%\u001A\u00020\u0000H\u0086\u0002¢\u0006\u0004\b&\u0010\u0019J\u0015\u0010\'\u001A\u00020\u00102\u0006\u0010(\u001A\u00020\t¢\u0006\u0004\b)\u0010*J-\u0010+\u001A\u00020\u00102\u0006\u0010,\u001A\u00020\t2\u0006\u0010-\u001A\u00020\t2\u0006\u0010.\u001A\u00020\t2\u0006\u0010/\u001A\u00020\t¢\u0006\u0004\b0\u00101J\u0015\u00102\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\t¢\u0006\u0004\b3\u0010*J\u0015\u00104\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\t¢\u0006\u0004\b5\u0010*J\u0015\u00106\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\t¢\u0006\u0004\b7\u0010*J\r\u00108\u001A\u00020\u0010¢\u0006\u0004\b9\u0010\u0016J\r\u0010:\u001A\u00020\u0010¢\u0006\u0004\b;\u0010\u0016J\u0013\u0010<\u001A\u00020=2\b\u0010>\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001A\u00020\u000BHÖ\u0001J\t\u0010@\u001A\u00020AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006B"}, d2={"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "get", "", "row", "", "column", "get-impl", "([FII)F", "set", "", "v", "set-impl", "([FIIF)V", "reset", "reset-impl", "([F)V", "src", "set-jHG-Opc", "([F[F)V", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "setToSaturation", "sat", "setToSaturation-impl", "([FF)V", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "setToRotateRed", "setToRotateRed-impl", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateBlue", "setToRotateBlue-impl", "convertRgbToYuv", "convertRgbToYuv-impl", "convertYuvToRgb", "convertYuvToRgb-impl", "equals", "", "other", "hashCode", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ColorMatrix {
    private final float[] values;

    private ColorMatrix(float[] arg1) {
        super();
        this.values = arg1;
    }

    public static final ColorMatrix box-impl(float[] arg1) {
        return new ColorMatrix(arg1);
    }

    public static float[] constructor-impl(float[] arg0) {
        return arg0;
    }

    public static float[] constructor-impl$default(float[] arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new float[]{1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f};
        }

        return ColorMatrix.constructor-impl(arg1);
    }

    public static final void convertRgbToYuv-impl(float[] arg12) {
        if(arg12.length < 20) {
            return;
        }

        arg12[0] = 1f;
        arg12[1] = 0f;
        arg12[2] = 0f;
        arg12[3] = 0f;
        arg12[4] = 0f;
        arg12[5] = 0f;
        arg12[6] = 1f;
        arg12[7] = 0f;
        arg12[8] = 0f;
        arg12[9] = 0f;
        arg12[10] = 0f;
        arg12[11] = 0f;
        arg12[12] = 1f;
        arg12[13] = 0f;
        arg12[14] = 0f;
        arg12[15] = 0f;
        arg12[16] = 0f;
        arg12[17] = 0f;
        arg12[18] = 1f;
        arg12[19] = 0f;
        arg12[0] = 0.299f;
        arg12[1] = 0.587f;
        arg12[2] = 0.114f;
        arg12[5] = -0.16874f;
        arg12[6] = -0.33126f;
        arg12[7] = 0.5f;
        arg12[10] = 0.5f;
        arg12[11] = -0.41869f;
        arg12[12] = -0.08131f;
    }

    public static final void convertYuvToRgb-impl(float[] arg10) {
        if(arg10.length < 20) {
            return;
        }

        arg10[0] = 1f;
        arg10[1] = 0f;
        arg10[2] = 0f;
        arg10[3] = 0f;
        arg10[4] = 0f;
        arg10[5] = 0f;
        arg10[6] = 1f;
        arg10[7] = 0f;
        arg10[8] = 0f;
        arg10[9] = 0f;
        arg10[10] = 0f;
        arg10[11] = 0f;
        arg10[12] = 1f;
        arg10[13] = 0f;
        arg10[14] = 0f;
        arg10[15] = 0f;
        arg10[16] = 0f;
        arg10[17] = 0f;
        arg10[18] = 1f;
        arg10[19] = 0f;
        arg10[2] = 1.402f;
        arg10[5] = 1f;
        arg10[6] = -0.34414f;
        arg10[7] = -0.71414f;
        arg10[10] = 1f;
        arg10[11] = 1.772f;
        arg10[12] = 0f;
    }

    public boolean equals(Object arg1) {
        return ColorMatrix.equals-impl(this.values, arg1);
    }

    public static boolean equals-impl(float[] arg2, Object arg3) {
        if(!(arg3 instanceof ColorMatrix)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((ColorMatrix)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(float[] arg0, float[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final float get-impl(float[] arg0, int arg1, int arg2) {
        return arg0[arg1 * 5 + arg2];
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return ColorMatrix.hashCode-impl(this.values);
    }

    public static int hashCode-impl(float[] arg0) {
        return Arrays.hashCode(arg0);
    }

    public static final void reset-impl(float[] arg3) {
        arg3[0] = 1f;
        arg3[1] = 0f;
        arg3[2] = 0f;
        arg3[3] = 0f;
        arg3[4] = 0f;
        arg3[5] = 0f;
        arg3[6] = 1f;
        arg3[7] = 0f;
        arg3[8] = 0f;
        arg3[9] = 0f;
        arg3[10] = 0f;
        arg3[11] = 0f;
        arg3[12] = 1f;
        arg3[13] = 0f;
        arg3[14] = 0f;
        arg3[15] = 0f;
        arg3[16] = 0f;
        arg3[17] = 0f;
        arg3[18] = 1f;
        arg3[19] = 0f;
    }

    private static final void rotateInternal-impl(float[] arg8, float arg9, Function2 arg10) {
        arg8[0] = 1f;
        arg8[1] = 0f;
        arg8[2] = 0f;
        arg8[3] = 0f;
        arg8[4] = 0f;
        arg8[5] = 0f;
        arg8[6] = 1f;
        arg8[7] = 0f;
        arg8[8] = 0f;
        arg8[9] = 0f;
        arg8[10] = 0f;
        arg8[11] = 0f;
        arg8[12] = 1f;
        arg8[13] = 0f;
        arg8[14] = 0f;
        arg8[15] = 0f;
        arg8[16] = 0f;
        arg8[17] = 0f;
        arg8[18] = 1f;
        arg8[19] = 0f;
        arg9 *= 0.002778f;
        float v8 = 0.25f + arg9;
        v8 -= ((float)Math.floor(((double)(v8 + 0.5f))));
        float v2 = Math.abs(v8) * 2f;
        float v4 = 1f - v2;
        arg9 -= ((float)Math.floor(((double)(0.5f + arg9))));
        float v0 = Math.abs(arg9) * 2f;
        float v1 = 1f - v0;
        arg10.invoke(Float.valueOf(v8 * 8f * v4 / (1.25f - v2 * v4)), Float.valueOf(arg9 * 8f * v1 / (1.25f - v0 * v1)));
    }

    public static final void set-impl(float[] arg0, int arg1, int arg2, float arg3) {
        arg0[arg1 * 5 + arg2] = arg3;
    }

    public static final void set-jHG-Opc(float[] arg2, float[] arg3) {
        int v1 = 20;
        if(arg2.length < v1) {
        }
        else {
            if(arg3.length < v1) {
                return;
            }

            goto label_7;
        }

        return;
    label_7:
        arg2[0] = arg3[0];
        arg2[1] = arg3[1];
        arg2[2] = arg3[2];
        arg2[3] = arg3[3];
        arg2[4] = arg3[4];
        arg2[5] = arg3[5];
        arg2[6] = arg3[6];
        arg2[7] = arg3[7];
        arg2[8] = arg3[8];
        arg2[9] = arg3[9];
        arg2[10] = arg3[10];
        arg2[11] = arg3[11];
        arg2[12] = arg3[12];
        arg2[13] = arg3[13];
        arg2[14] = arg3[14];
        arg2[15] = arg3[15];
        arg2[16] = arg3[16];
        arg2[17] = arg3[17];
        arg2[18] = arg3[18];
        arg2[19] = arg3[19];
    }

    public static final void setToRotateBlue-impl(float[] arg11, float arg12) {
        if(arg11.length < 20) {
            return;
        }

        arg11[0] = 1f;
        arg11[1] = 0f;
        arg11[2] = 0f;
        arg11[3] = 0f;
        arg11[4] = 0f;
        arg11[5] = 0f;
        arg11[6] = 1f;
        arg11[7] = 0f;
        arg11[8] = 0f;
        arg11[9] = 0f;
        arg11[10] = 0f;
        arg11[11] = 0f;
        arg11[12] = 1f;
        arg11[13] = 0f;
        arg11[14] = 0f;
        arg11[15] = 0f;
        arg11[16] = 0f;
        arg11[17] = 0f;
        arg11[18] = 1f;
        arg11[19] = 0f;
        arg12 *= 0.002778f;
        float v3 = 0.25f + arg12;
        v3 -= ((float)Math.floor(((double)(v3 + 0.5f))));
        float v7 = Math.abs(v3) * 2f;
        float v9 = 1f - v7;
        v3 = v3 * 8f * v9 / (1.25f - v7 * v9);
        arg12 -= ((float)Math.floor(((double)(0.5f + arg12))));
        float v6 = Math.abs(arg12) * 2f;
        float v1 = 1f - v6;
        arg12 = arg12 * 8f * v1 / (1.25f - v6 * v1);
        arg11[0] = v3;
        arg11[1] = arg12;
        arg11[5] = -arg12;
        arg11[6] = v3;
    }

    public static final void setToRotateGreen-impl(float[] arg11, float arg12) {
        if(arg11.length < 20) {
            return;
        }

        arg11[0] = 1f;
        arg11[1] = 0f;
        arg11[2] = 0f;
        arg11[3] = 0f;
        arg11[4] = 0f;
        arg11[5] = 0f;
        arg11[6] = 1f;
        arg11[7] = 0f;
        arg11[8] = 0f;
        arg11[9] = 0f;
        arg11[10] = 0f;
        arg11[11] = 0f;
        arg11[12] = 1f;
        arg11[13] = 0f;
        arg11[14] = 0f;
        arg11[15] = 0f;
        arg11[16] = 0f;
        arg11[17] = 0f;
        arg11[18] = 1f;
        arg11[19] = 0f;
        arg12 *= 0.002778f;
        float v3 = 0.25f + arg12;
        v3 -= ((float)Math.floor(((double)(v3 + 0.5f))));
        float v7 = Math.abs(v3) * 2f;
        float v9 = 1f - v7;
        v3 = v3 * 8f * v9 / (1.25f - v7 * v9);
        arg12 -= ((float)Math.floor(((double)(0.5f + arg12))));
        float v6 = Math.abs(arg12) * 2f;
        float v1 = 1f - v6;
        arg12 = arg12 * 8f * v1 / (1.25f - v6 * v1);
        arg11[0] = v3;
        arg11[2] = -arg12;
        arg11[10] = arg12;
        arg11[12] = v3;
    }

    public static final void setToRotateRed-impl(float[] arg11, float arg12) {
        if(arg11.length < 20) {
            return;
        }

        arg11[0] = 1f;
        arg11[1] = 0f;
        arg11[2] = 0f;
        arg11[3] = 0f;
        arg11[4] = 0f;
        arg11[5] = 0f;
        arg11[6] = 1f;
        arg11[7] = 0f;
        arg11[8] = 0f;
        arg11[9] = 0f;
        arg11[10] = 0f;
        arg11[11] = 0f;
        arg11[12] = 1f;
        arg11[13] = 0f;
        arg11[14] = 0f;
        arg11[15] = 0f;
        arg11[16] = 0f;
        arg11[17] = 0f;
        arg11[18] = 1f;
        arg11[19] = 0f;
        arg12 *= 0.002778f;
        float v2 = 0.25f + arg12;
        v2 -= ((float)Math.floor(((double)(v2 + 0.5f))));
        float v7 = Math.abs(v2) * 2f;
        float v9 = 1f - v7;
        v2 = v2 * 8f * v9 / (1.25f - v7 * v9);
        arg12 -= ((float)Math.floor(((double)(0.5f + arg12))));
        float v6 = Math.abs(arg12) * 2f;
        float v1 = 1f - v6;
        arg12 = arg12 * 8f * v1 / (1.25f - v6 * v1);
        arg11[6] = v2;
        arg11[7] = arg12;
        arg11[11] = -arg12;
        arg11[12] = v2;
    }

    public static final void setToSaturation-impl(float[] arg13, float arg14) {
        if(arg13.length < 20) {
            return;
        }

        arg13[0] = 1f;
        arg13[1] = 0f;
        arg13[2] = 0f;
        arg13[3] = 0f;
        arg13[4] = 0f;
        arg13[5] = 0f;
        arg13[6] = 1f;
        arg13[7] = 0f;
        arg13[8] = 0f;
        arg13[9] = 0f;
        arg13[10] = 0f;
        arg13[11] = 0f;
        arg13[12] = 1f;
        arg13[13] = 0f;
        arg13[14] = 0f;
        arg13[15] = 0f;
        arg13[16] = 0f;
        arg13[17] = 0f;
        arg13[18] = 1f;
        arg13[19] = 0f;
        float v1 = 1f - arg14;
        float v3 = 0.213f * v1;
        float v11 = 0.715f * v1;
        v1 *= 0.072f;
        arg13[0] = v3 + arg14;
        arg13[1] = v11;
        arg13[2] = v1;
        arg13[5] = v3;
        arg13[6] = v11 + arg14;
        arg13[7] = v1;
        arg13[10] = v3;
        arg13[11] = v11;
        arg13[12] = v1 + arg14;
    }

    public static final void setToScale-impl(float[] arg6, float arg7, float arg8, float arg9, float arg10) {
        if(arg6.length < 20) {
            return;
        }

        arg6[0] = 1f;
        arg6[1] = 0f;
        arg6[2] = 0f;
        arg6[3] = 0f;
        arg6[4] = 0f;
        arg6[5] = 0f;
        arg6[6] = 1f;
        arg6[7] = 0f;
        arg6[8] = 0f;
        arg6[9] = 0f;
        arg6[10] = 0f;
        arg6[11] = 0f;
        arg6[12] = 1f;
        arg6[13] = 0f;
        arg6[14] = 0f;
        arg6[15] = 0f;
        arg6[16] = 0f;
        arg6[17] = 0f;
        arg6[18] = 1f;
        arg6[19] = 0f;
        arg6[0] = arg7;
        arg6[6] = arg8;
        arg6[12] = arg9;
        arg6[18] = arg10;
    }

    public static final void timesAssign-jHG-Opc(float[] arg60, float[] arg61) {
        float[] v0 = arg60;
        if(v0.length < 20) {
            return;
        }

        float v2 = v0[0];
        float v3 = arg61[0];
        float v6 = v0[1];
        float v8 = arg61[5];
        float v10 = v0[2];
        float v12 = arg61[10];
        float v14 = v0[3];
        float v16 = arg61[15];
        float v4 = v2 * v3 + v6 * v8 + v10 * v12 + v14 * v16;
        float v17 = arg61[1];
        float v20 = arg61[6];
        float v22 = arg61[11];
        float v24 = arg61[16];
        float v18 = v2 * v17 + v6 * v20 + v10 * v22 + v14 * v24;
        float v25 = arg61[2];
        float v28 = arg61[7];
        float v30 = arg61[12];
        float v32 = arg61[17];
        float v26 = v2 * v25 + v6 * v28 + v10 * v30 + v14 * v32;
        float v33 = arg61[3];
        float v36 = arg61[8];
        float v38 = arg61[13];
        float v40 = arg61[18];
        float v34 = v2 * v33 + v6 * v36 + v10 * v38 + v14 * v40;
        float v42 = arg61[4];
        float v44 = arg61[9];
        float v45 = arg61[14];
        float v46 = arg61[19];
        v2 = v2 * v42 + v6 * v44 + v10 * v45 + v14 * v46 + v0[4];
        v14 = v0[5];
        float v48 = v0[6];
        float v49 = v0[7];
        float v47 = v14 * v3 + v48 * v8 + v49 * v12 + v0[8] * v16;
        float v51 = v14 * v17 + v48 * v20 + v49 * v22 + v0[8] * v24;
        float v52 = v14 * v25 + v48 * v28 + v49 * v30 + v0[8] * v32;
        float v53 = v14 * v33 + v48 * v36 + v49 * v38 + v0[8] * v40;
        v14 = v14 * v42 + v48 * v44 + v49 * v45 + v0[8] * v46 + v0[9];
        v48 = v0[10];
        float v50 = v0[11];
        float v54 = v0[12];
        v49 = v48 * v3 + v50 * v8 + v54 * v12 + v0[13] * v16;
        float v56 = v48 * v17 + v50 * v20 + v54 * v22 + v0[13] * v24;
        float v57 = v48 * v25 + v50 * v28 + v54 * v30 + v0[13] * v32;
        float v58 = v48 * v33 + v50 * v36 + v54 * v38 + v0[13] * v40;
        v48 = v48 * v42 + v50 * v44 + v54 * v45 + v0[13] * v46 + v0[14];
        v50 = v0[15];
        v54 = v0[16];
        v3 = v3 * v50 + v8 * v54;
        v8 = v0[17];
        v3 = v3 + v12 * v8 + v16 * v0[18];
        v17 = v17 * v50 + v20 * v54 + v22 * v8 + v24 * v0[18];
        v25 = v25 * v50 + v28 * v54 + v30 * v8 + v32 * v0[18];
        v33 = v33 * v50 + v36 * v54 + v38 * v8 + v40 * v0[18];
        v50 = v50 * v42 + v54 * v44 + v8 * v45 + v0[18] * v46 + v0[19];
        v0[0] = v4;
        v0[1] = v18;
        v0[2] = v26;
        v0[3] = v34;
        v0[4] = v2;
        v0[5] = v47;
        v0[6] = v51;
        v0[7] = v52;
        v0[8] = v53;
        v0[9] = v14;
        v0[10] = v49;
        v0[11] = v56;
        v0[12] = v57;
        v0[13] = v58;
        v0[14] = v48;
        v0[15] = v3;
        v0[16] = v17;
        v0[17] = v25;
        v0[18] = v33;
        v0[19] = v50;
    }

    public String toString() {
        return ColorMatrix.toString-impl(this.values);
    }

    public static String toString-impl(float[] arg2) {
        return "ColorMatrix(values=" + Arrays.toString(arg2) + ')';
    }

    public final float[] unbox-impl() {
        return this.values;
    }
}

