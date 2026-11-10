package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b)\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0086\n¢\u0006\u0004\b\r\u0010\u000EJ(\u0010\u000F\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\tH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0014\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019¢\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u001D¢\u0006\u0004\b\u001B\u0010\u001EJ\u0018\u0010\u001F\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u0000H\u0086\u0002¢\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\r\u0010\'\u001A\u00020\u0010¢\u0006\u0004\b(\u0010)J\r\u0010*\u001A\u00020\u0010¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001A\u00020\u00102\u0006\u0010-\u001A\u00020\u0000¢\u0006\u0004\b.\u0010\"J\u0015\u0010/\u001A\u00020\u00102\u0006\u00100\u001A\u00020\t¢\u0006\u0004\b1\u00102J\u0015\u00103\u001A\u00020\u00102\u0006\u00100\u001A\u00020\t¢\u0006\u0004\b4\u00102J\u0015\u00105\u001A\u00020\u00102\u0006\u00100\u001A\u00020\t¢\u0006\u0004\b6\u00102J+\u00107\u001A\u00020\u00102\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\t2\b\b\u0002\u0010:\u001A\u00020\t¢\u0006\u0004\b;\u0010<J+\u0010=\u001A\u00020\u00102\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\t2\b\b\u0002\u0010:\u001A\u00020\t¢\u0006\u0004\b>\u0010<J{\u0010?\u001A\u00020\u00102\b\b\u0002\u0010@\u001A\u00020\t2\b\b\u0002\u0010A\u001A\u00020\t2\b\b\u0002\u0010B\u001A\u00020\t2\b\b\u0002\u0010C\u001A\u00020\t2\b\b\u0002\u0010D\u001A\u00020\t2\b\b\u0002\u0010E\u001A\u00020\t2\b\b\u0002\u0010F\u001A\u00020\t2\b\b\u0002\u0010G\u001A\u00020\t2\b\b\u0002\u0010H\u001A\u00020\t2\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001A\u00020N2\b\u0010O\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001A\u00020\u000BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006R"}, d2={"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "get", "", "row", "", "column", "get-impl", "([FII)F", "set", "", "v", "set-impl", "([FIIF)V", "map", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "rect", "map-impl", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "timesAssign", "m", "timesAssign-58bKbWc", "([F[F)V", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "invert", "invert-impl", "([F)V", "reset", "reset-impl", "setFrom", "matrix", "setFrom-58bKbWc", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "translate", "translate-impl", "resetToPivotedTransform", "pivotX", "pivotY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "scaleZ", "resetToPivotedTransform-impl", "([FFFFFFFFFFFF)V", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Matrix {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/ui/graphics/Matrix$Companion;", "", "<init>", "()V", "ScaleX", "", "SkewY", "Perspective0", "SkewX", "ScaleY", "Perspective1", "ScaleZ", "TranslateX", "TranslateY", "TranslateZ", "Perspective2", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    static {
        Matrix.Companion = new Companion(null);
    }

    private Matrix(float[] arg1) {
        super();
        this.values = arg1;
    }

    public static final Matrix box-impl(float[] arg1) {
        return new Matrix(arg1);
    }

    public static float[] constructor-impl(float[] arg0) {
        return arg0;
    }

    public static float[] constructor-impl$default(float[] arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new float[]{1f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1f};
        }

        return Matrix.constructor-impl(arg1);
    }

    public boolean equals(Object arg1) {
        return Matrix.equals-impl(this.values, arg1);
    }

    public static boolean equals-impl(float[] arg2, Object arg3) {
        if(!(arg3 instanceof Matrix)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((Matrix)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(float[] arg0, float[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final float get-impl(float[] arg0, int arg1, int arg2) {
        return arg0[arg1 * 4 + arg2];
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return Matrix.hashCode-impl(this.values);
    }

    public static int hashCode-impl(float[] arg0) {
        return Arrays.hashCode(arg0);
    }

    public static final void invert-impl(float[] arg48) {
        float[] v0 = arg48;
        if(v0.length < 16) {
            return;
        }

        float v2 = v0[0];
        float v4 = v0[1];
        float v6 = v0[2];
        int v7 = 3;
        float v8 = v0[v7];
        int v9 = 4;
        float v10 = v0[v9];
        int v11 = 5;
        float v12 = v0[v11];
        int v13 = 6;
        float v14 = v0[v13];
        int v15 = 7;
        float v16 = v0[v15];
        int v17 = 8;
        float v1 = v0[v17];
        int v19 = 9;
        float v3 = v0[v19];
        int v21 = 10;
        float v22 = v0[v21];
        int v23 = 11;
        float v24 = v0[v23];
        int v25 = 12;
        int v26 = 2;
        float v5 = v0[v25];
        int v27 = 13;
        float v28 = v0[v27];
        int v29 = 14;
        float v30 = v0[v29];
        int v31 = 15;
        float v32 = v0[v31];
        float v33 = v2 * v12 - v4 * v10;
        float v34 = v2 * v14 - v6 * v10;
        float v35 = v2 * v16 - v8 * v10;
        float v36 = v4 * v14 - v6 * v12;
        float v37 = v4 * v16 - v8 * v12;
        float v38 = v6 * v16 - v8 * v14;
        float v39 = v1 * v28 - v3 * v5;
        float v40 = v1 * v30 - v22 * v5;
        float v41 = v1 * v32 - v24 * v5;
        float v42 = v3 * v30 - v22 * v28;
        float v43 = v3 * v32 - v24 * v28;
        float v44 = v22 * v32 - v24 * v30;
        float v45 = v33 * v44 - v34 * v43 + v35 * v42 + v36 * v41 - v37 * v40 + v38 * v39;
        if(v45 == 0f) {
            return;
        }

        float v46 = 1f / v45;
        v0[0] = (v12 * v44 - v14 * v43 + v16 * v42) * v46;
        v0[1] = (-v4 * v44 + v6 * v43 - v8 * v42) * v46;
        v0[v26] = (v28 * v38 - v30 * v37 + v32 * v36) * v46;
        v0[v7] = (-v3 * v38 + v22 * v37 - v24 * v36) * v46;
        float v7_1 = -v10;
        v0[v9] = (v7_1 * v44 + v14 * v41 - v16 * v40) * v46;
        v0[v11] = (v44 * v2 - v6 * v41 + v8 * v40) * v46;
        float v9_1 = -v5;
        v0[v13] = (v9_1 * v38 + v30 * v35 - v32 * v34) * v46;
        v0[v15] = (v38 * v1 - v22 * v35 + v24 * v34) * v46;
        v0[v17] = (v10 * v43 - v12 * v41 + v16 * v39) * v46;
        v0[v19] = (-v2 * v43 + v41 * v4 - v8 * v39) * v46;
        v0[v21] = (v5 * v37 - v28 * v35 + v32 * v33) * v46;
        v0[v23] = (-v1 * v37 + v35 * v3 - v24 * v33) * v46;
        v0[v25] = (v7_1 * v42 + v12 * v40 - v14 * v39) * v46;
        v0[v27] = (v2 * v42 - v4 * v40 + v6 * v39) * v46;
        v0[v29] = (v9_1 * v36 + v28 * v34 - v30 * v33) * v46;
        v0[v31] = (v1 * v36 - v3 * v34 + v22 * v33) * v46;
    }

    public static final long map-MK-Hz9U(float[] arg12, long arg13) {
        if(arg12.length < 16) {
            return arg13;
        }

        float v0 = arg12[0];
        float v1 = arg12[1];
        float v2 = arg12[3];
        float v3 = arg12[4];
        float v4 = arg12[5];
        float v5 = arg12[7];
        float v6 = arg12[12];
        float v7 = arg12[13];
        float v12 = arg12[15];
        int v8 = 0x20;
        float v9 = Float.intBitsToFloat(((int)(arg13 >> v8)));
        long v10 = 0xFFFFFFFFL;
        float v13 = Float.intBitsToFloat(((int)(arg13 & v10)));
        v12 = 1f / (v2 * v9 + v5 * v13 + v12);
        if((Float.floatToRawIntBits(v12) & 0x7FFFFFFF) < 0x7F800000) {
        }
        else {
            v12 = 0f;
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits((v0 * v9 + v3 * v13 + v6) * v12))) << v8 | (((long)Float.floatToRawIntBits(v12 * (v1 * v9 + v4 * v13 + v7)))) & v10);
    }

    public static final Rect map-impl(float[] arg23, Rect arg24) {
        float[] v0 = arg23;
        if(v0.length < 16) {
            return arg24;
        }

        float v1 = v0[0];
        float v2 = v0[1];
        float v3 = v0[3];
        float v4 = v0[4];
        float v5 = v0[5];
        float v6 = v0[7];
        float v7 = v0[12];
        float v8 = v0[13];
        float v0_1 = v0[15];
        float v9 = arg24.getLeft();
        float v10 = arg24.getTop();
        float v11 = arg24.getRight();
        float v12 = arg24.getBottom();
        float v13 = v3 * v9;
        float v14 = v6 * v10;
        float v16 = 1f;
        float v15 = v16 / (v13 + v14 + v0_1);
        int v18 = 0x7FFFFFFF;
        float v23 = v0_1;
        float v17 = 0f;
        float v19 = v1;
        if((Float.floatToRawIntBits(v15) & v18) < 0x7F800000) {
        }
        else {
            v15 = 0f;
        }

        v0_1 = v19 * v9;
        float v20 = v4 * v10;
        v1 = v15 * (v0_1 + v20 + v7);
        v9 *= v2;
        v10 *= v5;
        v15 *= v9 + v10 + v8;
        v6 *= v12;
        v13 = v16 / (v13 + v6 + v23);
        float v22 = v0_1;
        float v21 = v2;
        if((Float.floatToRawIntBits(v13) & v18) < 0x7F800000) {
        }
        else {
            v13 = 0f;
        }

        v4 *= v12;
        v0_1 = (v22 + v4 + v7) * v13;
        v5 *= v12;
        v13 *= v9 + v5 + v8;
        v3 *= v11;
        v2 = v16 / (v14 + v3 + v23);
        if((Float.floatToRawIntBits(v2) & v18) < 0x7F800000) {
        }
        else {
            v2 = 0f;
        }

        v9 = v19 * v11;
        v12 = v2 * (v9 + v20 + v7);
        v11 *= v21;
        v2 *= v10 + v11 + v8;
        v16 /= v3 + v6 + v23;
        if((Float.floatToRawIntBits(v16) & v18) < 0x7F800000) {
            v17 = v16;
        }

        v9 = (v9 + v4 + v7) * v17;
        v3 = v17 * (v11 + v5 + v8);
        return new Rect(Math.min(v1, Math.min(v0_1, Math.min(v12, v9))), Math.min(v15, Math.min(v13, Math.min(v2, v3))), Math.max(v1, Math.max(v0_1, Math.max(v12, v9))), Math.max(v15, Math.max(v13, Math.max(v2, v3))));
    }

    public static final void map-impl(float[] arg24, MutableRect arg25) {
        float[] v0 = arg24;
        MutableRect v1 = arg25;
        if(v0.length < 16) {
            return;
        }

        float v2 = v0[0];
        float v3 = v0[1];
        float v4 = v0[3];
        float v5 = v0[4];
        float v6 = v0[5];
        float v7 = v0[7];
        float v8 = v0[12];
        float v9 = v0[13];
        float v0_1 = v0[15];
        float v10 = v1.getLeft();
        float v11 = v1.getTop();
        float v12 = v1.getRight();
        float v13 = v1.getBottom();
        float v14 = v4 * v10;
        float v15 = v7 * v11;
        float v17 = 1f;
        float v16 = v17 / (v14 + v15 + v0_1);
        int v19 = 0x7FFFFFFF;
        float v24 = v0_1;
        float v18 = 0f;
        float v20 = v2;
        if((Float.floatToRawIntBits(v16) & v19) < 0x7F800000) {
        }
        else {
            v16 = 0f;
        }

        v0_1 = v20 * v10;
        float v21 = v5 * v11;
        v2 = v16 * (v0_1 + v21 + v8);
        v10 *= v3;
        v11 *= v6;
        float v23 = v0_1;
        v0_1 = v16 * (v10 + v11 + v9);
        v7 *= v13;
        v14 = v17 / (v14 + v7 + v24);
        float v22 = v3;
        v16 = v4;
        if((Float.floatToRawIntBits(v14) & v19) < 0x7F800000) {
        }
        else {
            v14 = 0f;
        }

        v5 *= v13;
        v3 = (v23 + v5 + v8) * v14;
        v6 *= v13;
        v14 *= v10 + v6 + v9;
        v4 = v16 * v12;
        v10 = v17 / (v15 + v4 + v24);
        if((Float.floatToRawIntBits(v10) & v19) < 0x7F800000) {
        }
        else {
            v10 = 0f;
        }

        v13 = v20 * v12;
        v15 = v10 * (v13 + v21 + v8);
        v12 *= v22;
        v10 *= v11 + v12 + v9;
        v17 /= v4 + v7 + v24;
        if((Float.floatToRawIntBits(v17) & v19) < 0x7F800000) {
            v18 = v17;
        }

        v13 = (v13 + v5 + v8) * v18;
        v4 = v18 * (v12 + v6 + v9);
        v1.setLeft(Math.min(v2, Math.min(v3, Math.min(v15, v13))));
        v1.setTop(Math.min(v0_1, Math.min(v14, Math.min(v10, v4))));
        v1.setRight(Math.max(v2, Math.max(v3, Math.max(v15, v13))));
        v1.setBottom(Math.max(v0_1, Math.max(v14, Math.max(v10, v4))));
    }

    public static final void reset-impl(float[] arg3) {
        if(arg3.length < 16) {
            return;
        }

        arg3[0] = 1f;
        arg3[1] = 0f;
        arg3[2] = 0f;
        arg3[3] = 0f;
        arg3[4] = 0f;
        arg3[5] = 1f;
        arg3[6] = 0f;
        arg3[7] = 0f;
        arg3[8] = 0f;
        arg3[9] = 0f;
        arg3[10] = 1f;
        arg3[11] = 0f;
        arg3[12] = 0f;
        arg3[13] = 0f;
        arg3[14] = 0f;
        arg3[15] = 1f;
    }

    public static final void resetToPivotedTransform-impl(float[] arg19, float arg20, float arg21, float arg22, float arg23, float arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30) {
        float[] v0 = arg19;
        float v1 = arg20;
        double v3 = (((double)arg25)) * 0.017453;
        float v7 = ((float)Math.sin(v3));
        float v3_1 = ((float)Math.cos(v3));
        float v4 = -v7;
        float v8 = arg23 * v3_1 - arg24 * v7;
        float v9 = arg23 * v7 + arg24 * v3_1;
        double v10 = (((double)arg26)) * 0.017453;
        float v12 = ((float)Math.sin(v10));
        float v10_1 = ((float)Math.cos(v10));
        float v11 = -v12;
        float v13 = v7 * v12;
        v7 *= v10_1;
        float v14 = v3_1 * v12;
        float v15 = v3_1 * v10_1;
        float v16 = arg22 * v10_1 + v9 * v12;
        double v5 = (((double)arg27)) * 0.017453;
        arg22 = -arg22 * v12 + v9 * v10_1;
        v9 = v3_1;
        float v2 = ((float)Math.sin(v5));
        v3_1 = ((float)Math.cos(v5));
        float v5_1 = -v2;
        float v6 = v5_1 * v10_1 + v3_1 * v13;
        v12 = v2 * v9;
        v9 *= v3_1;
        v5_1 = v5_1 * v11 + v3_1 * v7;
        v10_1 = (v10_1 * v3_1 + v13 * v2) * arg28;
        v12 *= arg28;
        v3_1 = (v3_1 * v11 + v2 * v7) * arg28;
        v6 *= arg29;
        v9 *= arg29;
        v5_1 *= arg29;
        v14 *= arg30;
        v4 *= arg30;
        v15 *= arg30;
        if(v0.length < 16) {
            return;
        }

        v0[0] = v10_1;
        v0[1] = v12;
        v0[2] = v3_1;
        v0[3] = 0f;
        v0[4] = v6;
        v0[5] = v9;
        v0[6] = v5_1;
        v0[7] = 0f;
        v0[8] = v14;
        v0[9] = v4;
        v0[10] = v15;
        v0[11] = 0f;
        v2 = -v1;
        v0[12] = v10_1 * v2 - v6 * arg21 + v16 + v1;
        v0[13] = v12 * v2 - v9 * arg21 + v8 + arg21;
        v0[14] = v2 * v3_1 - arg21 * v5_1 + arg22;
        v0[15] = 1f;
    }

    public static void resetToPivotedTransform-impl$default(float[] arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, float arg11, float arg12, int arg13, Object arg14) {
        float v0 = 1f;
        if((arg13 & 0x100) != 0) {
            arg10 = v0;
        }

        if((arg13 & 0x200) != 0) {
            arg11 = v0;
        }

        if((arg13 & 0x400) != 0) {
            arg12 = v0;
        }

        Matrix.resetToPivotedTransform-impl(arg1, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, arg10, arg11, arg12);
    }

    public static final void rotateX-impl(float[] arg21, float arg22) {
        float[] v0 = arg21;
        if(v0.length < 16) {
            return;
        }

        double v1 = (((double)arg22)) * 0.017453;
        float v3 = ((float)Math.sin(v1));
        float v1_1 = ((float)Math.cos(v1));
        float v4 = v0[1];
        float v7 = v4 * v1_1 - v0[2] * v3;
        v4 = v4 * v3 + v0[2] * v1_1;
        float v8 = v0[5];
        float v11 = v8 * v1_1 - v0[6] * v3;
        v8 = v8 * v3 + v0[6] * v1_1;
        float v12 = v0[9];
        float v15 = v12 * v1_1 - v0[10] * v3;
        v12 = v12 * v3 + v0[10] * v1_1;
        float v16 = v0[13];
        float v19 = v16 * v1_1 - v0[14] * v3;
        v16 = v16 * v3 + v0[14] * v1_1;
        v0[1] = v7;
        v0[2] = v4;
        v0[5] = v11;
        v0[6] = v8;
        v0[9] = v15;
        v0[10] = v12;
        v0[13] = v19;
        v0[14] = v16;
    }

    public static final void rotateY-impl(float[] arg20, float arg21) {
        float[] v0 = arg20;
        if(v0.length < 16) {
            return;
        }

        double v1 = (((double)arg21)) * 0.017453;
        float v3 = ((float)Math.sin(v1));
        float v1_1 = ((float)Math.cos(v1));
        float v4 = v0[0];
        float v7 = v4 * v1_1 + v0[2] * v3;
        v4 = -v4 * v3 + v0[2] * v1_1;
        float v8 = v0[4];
        float v11 = v8 * v1_1 + v0[6] * v3;
        v8 = -v8 * v3 + v0[6] * v1_1;
        float v12 = v0[8];
        float v15 = v12 * v1_1 + v0[10] * v3;
        v12 = -v12 * v3 + v0[10] * v1_1;
        float v2 = v0[12];
        float v18 = v2 * v1_1 + v0[14] * v3;
        v2 = -v2 * v3 + v0[14] * v1_1;
        v0[0] = v7;
        v0[2] = v4;
        v0[4] = v11;
        v0[6] = v8;
        v0[8] = v15;
        v0[10] = v12;
        v0[12] = v18;
        v0[14] = v2;
    }

    public static final void rotateZ-impl(float[] arg21, float arg22) {
        float[] v0 = arg21;
        if(v0.length < 16) {
            return;
        }

        double v1 = (((double)arg22)) * 0.017453;
        float v3 = ((float)Math.sin(v1));
        float v1_1 = ((float)Math.cos(v1));
        float v4 = v0[0];
        float v7 = v1_1 * v4 + v3 * v0[4];
        float v8 = -v3;
        v4 = v4 * v8 + v0[4] * v1_1;
        float v9 = v0[1];
        float v12 = v1_1 * v9 + v3 * v0[5];
        v9 = v9 * v8 + v0[5] * v1_1;
        float v13 = v0[2];
        float v16 = v1_1 * v13 + v3 * v0[6];
        v13 = v13 * v8 + v0[6] * v1_1;
        float v17 = v0[3];
        float v20 = v1_1 * v17 + v3 * v0[7];
        v8 = v8 * v17 + v1_1 * v0[7];
        v0[0] = v7;
        v0[1] = v12;
        v0[2] = v16;
        v0[3] = v20;
        v0[4] = v4;
        v0[5] = v9;
        v0[6] = v13;
        v0[7] = v8;
    }

    public static final void scale-impl(float[] arg2, float arg3, float arg4, float arg5) {
        if(arg2.length < 16) {
            return;
        }

        arg2[0] *= arg3;
        arg2[1] *= arg3;
        arg2[2] *= arg3;
        arg2[3] *= arg3;
        arg2[4] *= arg4;
        arg2[5] *= arg4;
        arg2[6] *= arg4;
        arg2[7] *= arg4;
        arg2[8] *= arg5;
        arg2[9] *= arg5;
        arg2[10] *= arg5;
        arg2[11] *= arg5;
    }

    public static void scale-impl$default(float[] arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        float v0 = 1f;
        if((arg5 & 1) != 0) {
            arg2 = v0;
        }

        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = v0;
        }

        Matrix.scale-impl(arg1, arg2, arg3, arg4);
    }

    public static final void set-impl(float[] arg0, int arg1, int arg2, float arg3) {
        arg0[arg1 * 4 + arg2] = arg3;
    }

    public static final void setFrom-58bKbWc(float[] arg2, float[] arg3) {
        int v1 = 16;
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
    }

    public static final void timesAssign-58bKbWc(float[] arg49, float[] arg50) {
        float[] v0 = arg49;
        float[] v1 = arg50;
        int v3 = 16;
        if(v0.length < v3) {
        }
        else {
            if(v1.length < v3) {
                return;
            }

            goto label_9;
        }

        return;
    label_9:
        float v3_1 = v0[0];
        float v4 = v1[0];
        float v7 = v0[1];
        float v9 = v1[4];
        float v11 = v0[2];
        float v13 = v1[8];
        float v15 = v0[3];
        float v17 = v1[12];
        float v5 = v3_1 * v4 + v7 * v9 + v11 * v13 + v15 * v17;
        float v18 = v1[1];
        float v21 = v1[5];
        float v23 = v1[9];
        float v25 = v1[13];
        float v19 = v3_1 * v18 + v7 * v21 + v11 * v23 + v15 * v25;
        float v26 = v1[2];
        float v29 = v1[6];
        float v31 = v1[10];
        float v33 = v1[14];
        float v27 = v3_1 * v26 + v7 * v29 + v11 * v31 + v15 * v33;
        float v34 = v1[3];
        float v36 = v1[7];
        float v37 = v1[11];
        float v1_1 = v1[15];
        v3_1 = v3_1 * v34 + v7 * v36 + v11 * v37 + v15 * v1_1;
        v15 = v0[4];
        float v39 = v0[5];
        float v40 = v0[6];
        float v38 = v15 * v4 + v39 * v9 + v40 * v13 + v0[7] * v17;
        float v42 = v15 * v18 + v39 * v21 + v40 * v23 + v0[7] * v25;
        float v43 = v15 * v26 + v39 * v29 + v40 * v31 + v0[7] * v33;
        v15 = v15 * v34 + v39 * v36 + v40 * v37 + v0[7] * v1_1;
        v39 = v0[8];
        float v41 = v0[9];
        float v44 = v0[10];
        v40 = v39 * v4 + v41 * v9 + v44 * v13 + v0[11] * v17;
        float v46 = v39 * v18 + v41 * v21 + v44 * v23 + v0[11] * v25;
        float v47 = v39 * v26 + v41 * v29 + v44 * v31 + v0[11] * v33;
        v39 = v39 * v34 + v41 * v36 + v44 * v37 + v0[11] * v1_1;
        v41 = v0[12];
        v44 = v0[13];
        v4 = v4 * v41 + v9 * v44;
        v9 = v0[14];
        v4 = v4 + v13 * v9 + v17 * v0[15];
        v18 = v18 * v41 + v21 * v44 + v23 * v9 + v25 * v0[15];
        v26 = v26 * v41 + v29 * v44 + v31 * v9 + v33 * v0[15];
        v41 = v41 * v34 + v44 * v36 + v9 * v37 + v0[15] * v1_1;
        v0[0] = v5;
        v0[1] = v19;
        v0[2] = v27;
        v0[3] = v3_1;
        v0[4] = v38;
        v0[5] = v42;
        v0[6] = v43;
        v0[7] = v15;
        v0[8] = v40;
        v0[9] = v46;
        v0[10] = v47;
        v0[11] = v39;
        v0[12] = v4;
        v0[13] = v18;
        v0[14] = v26;
        v0[15] = v41;
    }

    public String toString() {
        return Matrix.toString-impl(this.values);
    }

    public static String toString-impl(float[] arg5) {
        StringBuilder v0 = new StringBuilder("\n            |");
        v0.append(arg5[0]).append(' ').append(arg5[1]).append(' ').append(arg5[2]).append(' ').append(arg5[3]).append("|\n            |").append(arg5[4]).append(' ').append(arg5[5]).append(' ').append(arg5[6]).append(' ').append(arg5[7]).append("|\n            |").append(arg5[8]).append(' ').append(arg5[9]).append(' ').append(arg5[10]).append(' ');
        v0.append(arg5[11]).append("|\n            |").append(arg5[12]).append(' ').append(arg5[13]).append(' ').append(arg5[14]).append(' ').append(arg5[15]).append("|\n        ");
        return StringsKt.trimIndent(v0.toString());
    }

    public static final void translate-impl(float[] arg7, float arg8, float arg9, float arg10) {
        if(arg7.length < 16) {
            return;
        }

        float v0 = arg7[0] * arg8 + arg7[4] * arg9 + arg7[8] * arg10 + arg7[12];
        float v2 = arg7[1] * arg8 + arg7[5] * arg9 + arg7[9] * arg10 + arg7[13];
        float v4 = arg7[2] * arg8 + arg7[6] * arg9 + arg7[10] * arg10 + arg7[14];
        float v6 = arg7[3] * arg8 + arg7[7] * arg9 + arg7[11] * arg10 + arg7[15];
        arg7[12] = v0;
        arg7[13] = v2;
        arg7[14] = v4;
        arg7[15] = v6;
    }

    public static void translate-impl$default(float[] arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        Matrix.translate-impl(arg1, 0f, 0f, 0f);
    }

    public final float[] unbox-impl() {
        return this.values;
    }
}

