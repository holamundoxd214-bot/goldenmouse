package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\"\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 _2\u00020\u0001:\u0001_B]\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014BE\b\u0016\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001A\u00020\u0005\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0013\u0010\u0018B]\b\u0016\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u0013\u0010\u0019B%\b\u0016\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001A\u00020\u0005\u0012\u0006\u0010\u001A\u001A\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u001BB-\b\u0016\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\u001A\u001A\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u001CB1\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\u001A\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u001DB%\b\u0016\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001A\u00020\u0005\u0012\u0006\u0010\u001E\u001A\u00020\u0017¢\u0006\u0004\b\u0013\u0010\u001FB-\b\u0016\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\u001E\u001A\u00020\u0017¢\u0006\u0004\b\u0013\u0010 BA\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\u001E\u001A\u00020\u0017\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010!B!\b\u0010\u0012\u0006\u0010\"\u001A\u00020\u0000\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0013\u0010#J\b\u0010=\u001A\u00020\u0005H\u0007J\b\u0010>\u001A\u00020\u0005H\u0007J\b\u0010?\u001A\u00020\u0005H\u0007J\u0012\u0010=\u001A\u00020\u00052\b\b\u0001\u0010\u0004\u001A\u00020\u0005H\u0007J\u0012\u0010>\u001A\u00020\u00052\b\b\u0001\u0010\b\u001A\u00020\u0005H\u0007J\u0012\u0010?\u001A\u00020\u00052\b\b\u0001\u0010+\u001A\u00020\u0005H\u0007J\u0010\u0010@\u001A\u00020\r2\u0006\u0010A\u001A\u00020\u0012H\u0016J\u0010\u0010B\u001A\u00020\r2\u0006\u0010A\u001A\u00020\u0012H\u0016J \u0010C\u001A\u00020\u00052\u0006\u0010D\u001A\u00020\r2\u0006\u0010E\u001A\u00020\r2\u0006\u0010F\u001A\u00020\rH\u0007J\u0012\u0010C\u001A\u00020\u00052\b\b\u0001\u0010G\u001A\u00020\u0005H\u0007J \u0010H\u001A\u00020\u00052\u0006\u0010D\u001A\u00020\r2\u0006\u0010E\u001A\u00020\r2\u0006\u0010F\u001A\u00020\rH\u0007J\u0012\u0010H\u001A\u00020\u00052\b\b\u0001\u0010G\u001A\u00020\u0005H\u0007J\u0010\u0010I\u001A\u00020\u00052\u0006\u0010G\u001A\u00020\u0005H\u0016J%\u0010J\u001A\u00020K2\u0006\u0010L\u001A\u00020\r2\u0006\u0010M\u001A\u00020\r2\u0006\u0010N\u001A\u00020\rH\u0010¢\u0006\u0002\bOJ%\u0010P\u001A\u00020\r2\u0006\u0010L\u001A\u00020\r2\u0006\u0010M\u001A\u00020\r2\u0006\u0010N\u001A\u00020\rH\u0010¢\u0006\u0002\bQJ7\u0010R\u001A\u00020S2\u0006\u0010T\u001A\u00020\r2\u0006\u0010U\u001A\u00020\r2\u0006\u0010V\u001A\u00020\r2\u0006\u0010W\u001A\u00020\r2\u0006\u0010\"\u001A\u00020\u0001H\u0010¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001A\u00020\u00052\u0006\u0010G\u001A\u00020\u0005H\u0016J\u0013\u0010[\u001A\u00020:2\b\u0010\\\u001A\u0004\u0018\u00010]H\u0096\u0002J\b\u0010^\u001A\u00020\u0012H\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0014\u0010\b\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010)R\u0014\u0010+\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b,\u0010)R\u0014\u0010-\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u001D\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001A\u0004\b0\u00101R\u0014\u00102\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b3\u0010/R\u0014\u00104\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b5\u0010/R\u001D\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001A\u0004\b6\u00101R\u0014\u00107\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b8\u0010/R\u0014\u00109\u001A\u00020:X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b9\u0010;R\u0014\u0010<\u001A\u00020:X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b<\u0010;¨\u0006`"}, d2={"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "primaries", "", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "transform", "oetf", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "eotf", "min", "", "max", "transferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "id", "", "<init>", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "toXYZ", "Lkotlin/Function1;", "", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getPrimaries$ui_graphics", "()[F", "getTransform$ui_graphics", "inverseTransform", "getInverseTransform$ui_graphics", "oetfOrig", "getOetfOrig$ui_graphics", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "getOetf", "()Lkotlin/jvm/functions/Function1;", "oetfFunc", "getOetfFunc$ui_graphics", "eotfOrig", "getEotfOrig$ui_graphics", "getEotf", "eotfFunc", "getEotfFunc$ui_graphics", "isWideGamut", "", "()Z", "isSrgb", "getPrimaries", "getTransform", "getInverseTransform", "getMinValue", "component", "getMaxValue", "toLinear", "r", "g", "b", "v", "fromLinear", "toXyz", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "equals", "other", "", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Rgb extends ColorSpace {
    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0012H\u0002J \u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0005H\u0002J \u0010\u0018\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002J\u0010\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\tH\u0002J)\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0082\bJ\u0018\u0010\u001F\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\t2\u0006\u0010!\u001A\u00020\tH\u0002J\u0015\u0010\"\u001A\u00020\t2\u0006\u0010#\u001A\u00020\tH\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001A\u00020\u000B2\u0006\u0010#\u001A\u00020\tH\u0002J\u0010\u0010&\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0002J\u0018\u0010\'\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0002J\u0010\u0010(\u001A\u00020\u00052\u0006\u0010)\u001A\u00020*H\u0002J\u0010\u0010+\u001A\u00020\u00052\u0006\u0010)\u001A\u00020*H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2={"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "<init>", "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "isSrgb", "", "primaries", "", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "OETF", "EOTF", "min", "", "max", "id", "", "compare", "point", "", "a", "b", "isWideGamut", "area", "cross", "ax", "ay", "bx", "by", "contains", "p1", "p2", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics", "computeWhitePoint", "xyPrimaries", "computeXYZMatrix", "generateOetf", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "generateEotf", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final WhitePoint access$computeWhitePoint(Companion arg0, float[] arg1) {
            return arg0.computeWhitePoint(arg1);
        }

        public static final float[] access$computeXYZMatrix(Companion arg0, float[] arg1, WhitePoint arg2) {
            return arg0.computeXYZMatrix(arg1, arg2);
        }

        public static final DoubleFunction access$generateEotf(Companion arg0, TransferParameters arg1) {
            return arg0.generateEotf(arg1);
        }

        public static final DoubleFunction access$generateOetf(Companion arg0, TransferParameters arg1) {
            return arg0.generateOetf(arg1);
        }

        public static final boolean access$isSrgb(Companion arg0, float[] arg1, WhitePoint arg2, DoubleFunction arg3, DoubleFunction arg4, float arg5, float arg6, int arg7) {
            return arg0.isSrgb(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public static final boolean access$isWideGamut(Companion arg0, float[] arg1, float arg2, float arg3) {
            return arg0.isWideGamut(arg1, arg2, arg3);
        }

        public static final float[] access$xyPrimaries(Companion arg0, float[] arg1) {
            return arg0.xyPrimaries(arg1);
        }

        private final float area(float[] arg8) {
            if(arg8.length < 6) {
                return 0;
            }

            float v5 = (arg8[0] * arg8[3] + arg8[1] * arg8[4] + arg8[2] * arg8[5] - arg8[3] * arg8[4] - arg8[1] * arg8[2] - arg8[0] * arg8[5]) * 0.5f;
            if(v5 < 0f) {
                return -v5;
            }

            return v5;
        }

        private final boolean compare(double arg3, DoubleFunction arg5, DoubleFunction arg6) {
            if(Math.abs(arg5.invoke(arg3) - arg6.invoke(arg3)) <= 0.001) {
                return 1;
            }

            return 0;
        }

        public final float[] computePrimaries$ui_graphics(float[] arg13) {
            float[] v0 = ColorSpaceKt.mul3x3Float3(arg13, new float[]{1f, 0f, 0f});
            float[] v1 = ColorSpaceKt.mul3x3Float3(arg13, new float[]{0f, 1f, 0f});
            arg13 = ColorSpaceKt.mul3x3Float3(arg13, new float[]{0f, 0f, 1f});
            float v3 = v0[0];
            float v5 = v0[1];
            float v6 = v3 + v5 + v0[2];
            float v0_1 = v1[0];
            float v8 = v1[1];
            float v9 = v0_1 + v8 + v1[2];
            float v1_1 = arg13[0];
            float v10 = arg13[1];
            float v11 = v1_1 + v10 + arg13[2];
            return new float[]{v3 / v6, v5 / v6, v0_1 / v9, v8 / v9, v1_1 / v11, v10 / v11};
        }

        private final WhitePoint computeWhitePoint(float[] arg4) {
            float[] v3 = ColorSpaceKt.mul3x3Float3(arg4, new float[]{1f, 1f, 1f});
            float v0 = v3[0] + v3[1] + v3[2];
            return new WhitePoint(v3[0] / v0, v3[1] / v0);
        }

        private final float[] computeXYZMatrix(float[] arg23, WhitePoint arg24) {
            float v1 = arg23[0];
            float v3 = arg23[1];
            float v5 = arg23[2];
            float v7 = arg23[3];
            float v9 = arg23[4];
            float v11 = arg23[5];
            float v12 = arg24.getX();
            float v13 = arg24.getY();
            float v15 = (1f - v1) / v3;
            float v18 = (1f - v12) / v13;
            float v19 = v1 / v3;
            float v20 = v5 / v7 - v19;
            v12 = v12 / v13 - v19;
            float v16 = (1f - v5) / v7 - v15;
            float v21 = v9 / v11 - v19;
            v18 = ((v18 - v15) * v20 - v12 * v16) / (((1f - v9) / v11 - v15) * v20 - v16 * v21);
            v12 = (v12 - v21 * v18) / v20;
            v13 = 1f - v12 - v18;
            v15 = v13 / v3;
            v16 = v12 / v7;
            float v17 = v18 / v11;
            return new float[]{v15 * v1, v13, v15 * (1f - v1 - v3), v16 * v5, v12, v16 * (1f - v5 - v7), v17 * v9, v18, v17 * (1f - v9 - v11)};
        }

        private final boolean contains(float[] arg19, float[] arg20) {
            float v1 = arg19[0];
            float v2 = arg20[0];
            float v4 = arg19[1];
            float v5 = arg20[1];
            int v6 = 2;
            float v7 = arg19[v6];
            float v8 = arg20[v6];
            int v9 = 3;
            float v10 = arg19[v9];
            float v11 = arg20[v9];
            int v12 = 4;
            float v13 = arg19[v12];
            float v14 = arg20[v12];
            int v15 = 5;
            float v16 = arg19[v15];
            float v17 = arg20[v15];
            float[] v0 = new float[6];
            v0[0] = v1 - v2;
            v0[1] = v4 - v5;
            v0[v6] = v7 - v8;
            v0[v9] = v10 - v11;
            v0[v12] = v13 - v14;
            v0[v15] = v16 - v17;
            v1 = v0[0];
            v4 = v0[1];
            if((v5 - v17) * v1 - (v2 - v14) * v4 >= 0f) {
                if((v2 - v8) * v4 - (v5 - v11) * v1 < 0f) {
                }
                else {
                    v1 = v0[v6];
                    v4 = v0[v9];
                    if((v11 - v5) * v1 - (v8 - v2) * v4 >= 0f) {
                        if((v8 - v14) * v4 - (v11 - v17) * v1 < 0f) {
                        }
                        else {
                            v1 = v0[v12];
                            float v0_1 = v0[v15];
                            if((v17 - v11) * v1 - (v14 - v8) * v0_1 >= 0f && (v14 - v2) * v0_1 - (v17 - v5) * v1 >= 0f) {
                                return 1;
                            }
                        }
                    }
                }
            }

            return 0;
        }

        private final float cross(float arg1, float arg2, float arg3, float arg4) {
            return arg1 * arg4 - arg2 * arg3;
        }

        private final DoubleFunction generateEotf(TransferParameters arg5) {
            if(arg5.isHLGish$ui_graphics()) {
                return new Rgb$Companion$$ExternalSyntheticLambda0(arg5);
            }

            if(arg5.isPQish$ui_graphics()) {
                return new Rgb$Companion$$ExternalSyntheticLambda1(arg5);
            }

            double v2 = 0;
            if(arg5.getE() == v2 && arg5.getF() == v2) {
                return new Rgb$Companion$$ExternalSyntheticLambda2(arg5);
            }

            return new Rgb$Companion$$ExternalSyntheticLambda3(arg5);
        }

        static final double generateEotf$lambda$0(TransferParameters arg1, double arg2) {
            return ColorSpaces.INSTANCE.transferHlgEotf$ui_graphics(arg1, arg2);
        }

        static final double generateEotf$lambda$1(TransferParameters arg1, double arg2) {
            return ColorSpaces.INSTANCE.transferSt2048Eotf$ui_graphics(arg1, arg2);
        }

        static final double generateEotf$lambda$2(TransferParameters arg12, double arg13) {
            return ColorSpaceKt.response(arg13, arg12.getA(), arg12.getB(), arg12.getC(), arg12.getD(), arg12.getGamma());
        }

        static final double generateEotf$lambda$3(TransferParameters arg18, double arg19) {
            return ColorSpaceKt.response(arg19, arg18.getA(), arg18.getB(), arg18.getC(), arg18.getD(), arg18.getE(), arg18.getF(), arg18.getGamma());
        }

        private final DoubleFunction generateOetf(TransferParameters arg5) {
            if(arg5.isHLGish$ui_graphics()) {
                return new Rgb$Companion$$ExternalSyntheticLambda4(arg5);
            }

            if(arg5.isPQish$ui_graphics()) {
                return new Rgb$Companion$$ExternalSyntheticLambda5(arg5);
            }

            double v2 = 0;
            if(arg5.getE() == v2 && arg5.getF() == v2) {
                return new Rgb$Companion$$ExternalSyntheticLambda6(arg5);
            }

            return new Rgb$Companion$$ExternalSyntheticLambda7(arg5);
        }

        static final double generateOetf$lambda$0(TransferParameters arg1, double arg2) {
            return ColorSpaces.INSTANCE.transferHlgOetf$ui_graphics(arg1, arg2);
        }

        static final double generateOetf$lambda$1(TransferParameters arg1, double arg2) {
            return ColorSpaces.INSTANCE.transferSt2048Oetf$ui_graphics(arg1, arg2);
        }

        static final double generateOetf$lambda$2(TransferParameters arg12, double arg13) {
            return ColorSpaceKt.rcpResponse(arg13, arg12.getA(), arg12.getB(), arg12.getC(), arg12.getD(), arg12.getGamma());
        }

        static final double generateOetf$lambda$3(TransferParameters arg18, double arg19) {
            return ColorSpaceKt.rcpResponse(arg19, arg18.getA(), arg18.getB(), arg18.getC(), arg18.getD(), arg18.getE(), arg18.getF(), arg18.getGamma());
        }

        private final boolean isSrgb(float[] arg4, WhitePoint arg5, DoubleFunction arg6, DoubleFunction arg7, float arg8, float arg9, int arg10) {
            if(arg10 == 0) {
                return 1;
            }

            if(!ColorSpaceKt.compare(arg4, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics())) {
                return 0;
            }

            if(!ColorSpaceKt.compare(arg5, Illuminant.INSTANCE.getD65())) {
                return 0;
            }

            if(arg8 == 0f && arg9 == 1f) {
                Rgb v4 = ColorSpaces.INSTANCE.getSrgb();
                double v8 = 0;
                while(true) {
                    if(v8 > 1) {
                        return 1;
                    }
                    else if(!this.compare(v8, arg6, v4.getOetfOrig$ui_graphics())) {
                        return 0;
                    }
                    else if(!this.compare(v8, arg7, v4.getEotfOrig$ui_graphics())) {
                        return 0;
                    }
                    else {
                        v8 += 0.003922;
                        continue;
                    }

                    return 0;
                }

                return 1;
            }

            return 0;
        }

        private final boolean isWideGamut(float[] arg3, float arg4, float arg5) {
            if(this.area(arg3) / this.area(ColorSpaces.INSTANCE.getNtsc1953Primaries$ui_graphics()) > 0.9f && (this.contains(arg3, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics())) || arg4 < 0f && arg5 > 1f) {
                return 1;
            }

            return 0;
        }

        private final float[] xyPrimaries(float[] arg10) {
            int v9 = 6;
            float[] v1 = new float[v9];
            if(arg10.length == 9) {
                float v2 = arg10[0];
                float v4 = arg10[1];
                float v5 = v2 + v4 + arg10[2];
                v1[0] = v2 / v5;
                v1[1] = v4 / v5;
                v2 = arg10[3];
                v4 = arg10[4];
                v5 = v2 + v4 + arg10[5];
                v1[2] = v2 / v5;
                v1[3] = v4 / v5;
                float v9_1 = arg10[v9];
                float v0 = arg10[7];
                v2 = v9_1 + v0 + arg10[8];
                v1[4] = v9_1 / v2;
                v1[5] = v0 / v2;
                return v1;
            }

            ArraysKt.copyInto$default(arg10, v1, 0, 0, 6, 6, null);
            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final DoubleFunction DoubleIdentity;
    private final Function1 eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;
    private final Function1 oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    static {
        Rgb.Companion = new Companion(null);
        Rgb.$stable = 8;
        Rgb.DoubleIdentity = new Rgb$$ExternalSyntheticLambda2();
    }

    public Rgb(String arg12, float[] arg13, WhitePoint arg14, float[] arg15, DoubleFunction arg16, DoubleFunction arg17, float arg18, float arg19, TransferParameters arg20, int arg21) {
        float[] v8 = arg15;
        float v9 = arg18;
        float v10 = arg19;
        super(arg12, ColorModel.Companion.getRgb-xdoWZVw(), arg21, null);
        this.whitePoint = arg14;
        this.min = v9;
        this.max = v10;
        this.transferParameters = arg20;
        DoubleFunction v3 = arg16;
        this.oetfOrig = v3;
        this.oetf = new Rgb$oetf$1(this);
        this.oetfFunc = new Rgb$$ExternalSyntheticLambda0(this);
        DoubleFunction v4 = arg17;
        this.eotfOrig = v4;
        this.eotf = new Rgb$eotf$1(this);
        this.eotfFunc = new Rgb$$ExternalSyntheticLambda1(this);
        int v2 = 9;
        if(arg13.length != 6) {
            if(arg13.length == v2) {
            }
            else {
                throw new IllegalArgumentException("The color space\'s primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
            }
        }

        if(v9 >= v10) {
            goto label_74;
        }

        Companion v0 = Rgb.Companion;
        float[] v1 = Companion.access$xyPrimaries(v0, arg13);
        this.primaries = v1;
        if(v8 == null) {
            float[] v2_1 = Companion.access$computeXYZMatrix(v0, v1, arg14);
            this.transform = v2_1;
            v8 = v2_1;
        }
        else if(v8.length == v2) {
            this.transform = v8;
        }
        else {
            goto label_65;
        }

        this.inverseTransform = ColorSpaceKt.inverse3x3(v8);
        this.isWideGamut = Companion.access$isWideGamut(v0, v1, v9, v10);
        this.isSrgb = Companion.access$isSrgb(v0, v1, arg14, v3, v4, v9, v10, arg21);
        return;
    label_65:
        throw new IllegalArgumentException("Transform must have 9 entries! Has " + v8.length);
    label_74:
        throw new IllegalArgumentException("Invalid range: min=" + v9 + ", max=" + v10 + "; min must be strictly < max");
    }

    public Rgb(Rgb arg12, float[] arg13, WhitePoint arg14) {
        this(arg12.getName(), arg12.primaries, arg14, arg13, arg12.oetfOrig, arg12.eotfOrig, arg12.min, arg12.max, arg12.transferParameters, -1);
    }

    public Rgb(String arg12, float[] arg13, WhitePoint arg14, TransferParameters arg15, int arg16) {
        this(arg12, arg13, arg14, null, Companion.access$generateOetf(Rgb.Companion, arg15), Companion.access$generateEotf(Rgb.Companion, arg15), 0f, 1f, arg15, arg16);
    }

    public Rgb(String arg20, float[] arg21, WhitePoint arg22, double arg23, float arg25, float arg26, int arg27) {
        Rgb$$ExternalSyntheticLambda6 v0_2;
        DoubleFunction v3;
        double v1 = arg23;
        int v0 = Double.compare(v1, 1);
        if(v0 == 0) {
            v3 = Rgb.DoubleIdentity;
        }
        else {
            Rgb$$ExternalSyntheticLambda5 v3_1 = new Rgb$$ExternalSyntheticLambda5(v1);
        }

        DoubleFunction v17 = v3;
        if(v0 == 0) {
            DoubleFunction v0_1 = Rgb.DoubleIdentity;
        }
        else {
            v0_2 = new Rgb$$ExternalSyntheticLambda6(v1);
        }

        this(arg20, arg21, arg22, null, v17, ((DoubleFunction)v0_2), arg25, arg26, new TransferParameters(v1, 1, 0, 0, 0, 0, 0, 0x60, null), arg27);
    }

    public Rgb(String arg11, float[] arg12, double arg13) {
        this(arg11, Rgb.Companion.computePrimaries$ui_graphics(arg12), Companion.access$computeWhitePoint(Rgb.Companion, arg12), arg13, 0f, 1f, -1);
    }

    public Rgb(String arg8, float[] arg9, TransferParameters arg10) {
        this(arg8, Rgb.Companion.computePrimaries$ui_graphics(arg9), Companion.access$computeWhitePoint(Rgb.Companion, arg9), arg10, -1);
    }

    public Rgb(String arg10, float[] arg11, WhitePoint arg12, double arg13) {
        this(arg10, arg11, arg12, arg13, 0f, 1f, -1);
    }

    public Rgb(String arg7, float[] arg8, WhitePoint arg9, TransferParameters arg10) {
        this(arg7, arg8, arg9, arg10, -1);
    }

    public Rgb(String arg12, float[] arg13, WhitePoint arg14, Function1 arg15, Function1 arg16, float arg17, float arg18) {
        this(arg12, arg13, arg14, null, new Rgb$$ExternalSyntheticLambda7(arg15), new Rgb$$ExternalSyntheticLambda8(arg16), arg17, arg18, null, -1);
    }

    public Rgb(String arg13, float[] arg14, Function1 arg15, Function1 arg16) {
        this(arg13, Rgb.Companion.computePrimaries$ui_graphics(arg14), Companion.access$computeWhitePoint(Rgb.Companion, arg14), null, new Rgb$$ExternalSyntheticLambda3(arg15), new Rgb$$ExternalSyntheticLambda4(arg16), 0f, 1f, null, -1);
    }

    static final double DoubleIdentity$lambda$0(double arg0) {
        return arg0;
    }

    static final double _init_$lambda$0(Function1 arg0, double arg1) {
        return arg0.invoke(Double.valueOf(arg1)).doubleValue();
    }

    static final double _init_$lambda$1(Function1 arg0, double arg1) {
        return arg0.invoke(Double.valueOf(arg1)).doubleValue();
    }

    static final double _init_$lambda$2(Function1 arg0, double arg1) {
        return arg0.invoke(Double.valueOf(arg1)).doubleValue();
    }

    static final double _init_$lambda$3(Function1 arg0, double arg1) {
        return arg0.invoke(Double.valueOf(arg1)).doubleValue();
    }

    static final double _init_$lambda$4(double arg3, double arg5) {
        double v0 = 0;
        if(arg5 < v0) {
            arg5 = v0;
        }

        return Math.pow(arg5, 1 / arg3);
    }

    static final double _init_$lambda$5(double arg3, double arg5) {
        double v0 = 0;
        if(arg5 < v0) {
            arg5 = v0;
        }

        return Math.pow(arg5, arg3);
    }

    public static final float access$getMax$p(Rgb arg0) {
        return arg0.max;
    }

    public static final float access$getMin$p(Rgb arg0) {
        return arg0.min;
    }

    static final double eotfFunc$lambda$0(Rgb arg8, double arg9) {
        return arg8.eotfOrig.invoke(RangesKt.coerceIn(arg9, ((double)arg8.min), ((double)arg8.max)));
    }

    public boolean equals(Object arg5) {
        if(this == (((Rgb)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(!super.equals(arg5)) {
                return 0;
            }
            else if(Float.compare(((Rgb)arg5).min, this.min) != 0) {
                return 0;
            }
            else if(Float.compare(((Rgb)arg5).max, this.max) != 0) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.whitePoint, ((Rgb)arg5).whitePoint)) {
                return 0;
            }
            else if(!Arrays.equals(this.primaries, ((Rgb)arg5).primaries)) {
                return 0;
            }
            else {
                TransferParameters v2 = this.transferParameters;
                if(v2 != null) {
                    return Intrinsics.areEqual(v2, ((Rgb)arg5).transferParameters);
                }
                else if(((Rgb)arg5).transferParameters == null) {
                    return 1;
                }
                else if(!Intrinsics.areEqual(this.oetfOrig, ((Rgb)arg5).oetfOrig)) {
                    return 0;
                }
                else {
                    return Intrinsics.areEqual(this.eotfOrig, ((Rgb)arg5).eotfOrig);
                }
            }
        }

        return 0;
    }

    public final float[] fromLinear(float arg3, float arg4, float arg5) {
        return this.fromLinear(new float[]{arg3, arg4, arg5});
    }

    public final float[] fromLinear(float[] arg5) {
        if(arg5.length < 3) {
            return arg5;
        }

        arg5[0] = ((float)this.oetfFunc.invoke(((double)arg5[0])));
        arg5[1] = ((float)this.oetfFunc.invoke(((double)arg5[1])));
        arg5[2] = ((float)this.oetfFunc.invoke(((double)arg5[2])));
        return arg5;
    }

    public float[] fromXyz(float[] arg5) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, arg5);
        if(arg5.length < 3) {
            return arg5;
        }

        arg5[0] = ((float)this.oetfFunc.invoke(((double)arg5[0])));
        arg5[1] = ((float)this.oetfFunc.invoke(((double)arg5[1])));
        arg5[2] = ((float)this.oetfFunc.invoke(((double)arg5[2])));
        return arg5;
    }

    public final Function1 getEotf() {
        return this.eotf;
    }

    public final DoubleFunction getEotfFunc$ui_graphics() {
        return this.eotfFunc;
    }

    public final DoubleFunction getEotfOrig$ui_graphics() {
        return this.eotfOrig;
    }

    public final float[] getInverseTransform() {
        float[] v1 = Arrays.copyOf(this.inverseTransform, this.inverseTransform.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return v1;
    }

    public final float[] getInverseTransform(float[] arg8) {
        return ArraysKt.copyInto$default(this.inverseTransform, arg8, 0, 0, 0, 14, null);
    }

    public final float[] getInverseTransform$ui_graphics() {
        return this.inverseTransform;
    }

    public float getMaxValue(int arg1) {
        return this.max;
    }

    public float getMinValue(int arg1) {
        return this.min;
    }

    public final Function1 getOetf() {
        return this.oetf;
    }

    public final DoubleFunction getOetfFunc$ui_graphics() {
        return this.oetfFunc;
    }

    public final DoubleFunction getOetfOrig$ui_graphics() {
        return this.oetfOrig;
    }

    public final float[] getPrimaries() {
        float[] v1 = Arrays.copyOf(this.primaries, this.primaries.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return v1;
    }

    public final float[] getPrimaries(float[] arg8) {
        return ArraysKt.copyInto$default(this.primaries, arg8, 0, 0, 0, 14, null);
    }

    public final float[] getPrimaries$ui_graphics() {
        return this.primaries;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    public final float[] getTransform() {
        float[] v1 = Arrays.copyOf(this.transform, this.transform.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return v1;
    }

    public final float[] getTransform(float[] arg8) {
        return ArraysKt.copyInto$default(this.transform, arg8, 0, 0, 0, 14, null);
    }

    public final float[] getTransform$ui_graphics() {
        return this.transform;
    }

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public int hashCode() {
        int v0 = ((super.hashCode() * 0x1F + this.whitePoint.hashCode()) * 0x1F + Arrays.hashCode(this.primaries)) * 0x1F;
        float v1 = this.min;
        int v4 = 0;
        int v1_1 = Float.compare(v1, 0f) == 0 ? 0 : Float.floatToIntBits(v1);
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.max;
        v1_1 = v1 == 0f ? 0 : Float.floatToIntBits(v1);
        v0 = (v0 + v1_1) * 0x1F;
        TransferParameters v1_2 = this.transferParameters;
        if(v1_2 != null) {
            v4 = v1_2.hashCode();
        }

        v0 += v4;
        if(this.transferParameters == null) {
            v0 = (v0 * 0x1F + this.oetfOrig.hashCode()) * 0x1F + this.eotfOrig.hashCode();
        }

        return v0;
    }

    public boolean isSrgb() {
        return this.isSrgb;
    }

    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    static final double oetfFunc$lambda$0(Rgb arg7, double arg8) {
        return RangesKt.coerceIn(arg7.oetfOrig.invoke(arg8), ((double)arg7.min), ((double)arg7.max));
    }

    public final float[] toLinear(float arg3, float arg4, float arg5) {
        return this.toLinear(new float[]{arg3, arg4, arg5});
    }

    public final float[] toLinear(float[] arg5) {
        if(arg5.length < 3) {
            return arg5;
        }

        arg5[0] = ((float)this.eotfFunc.invoke(((double)arg5[0])));
        arg5[1] = ((float)this.eotfFunc.invoke(((double)arg5[1])));
        arg5[2] = ((float)this.eotfFunc.invoke(((double)arg5[2])));
        return arg5;
    }

    public long toXy$ui_graphics(float arg4, float arg5, float arg6) {
        arg4 = ((float)this.eotfFunc.invoke(((double)arg4)));
        arg5 = ((float)this.eotfFunc.invoke(((double)arg5)));
        arg6 = ((float)this.eotfFunc.invoke(((double)arg6)));
        float[] v3 = this.transform;
        if(v3.length < 9) {
            return 0;
        }

        return (((long)Float.floatToRawIntBits(v3[0] * arg4 + v3[3] * arg5 + v3[6] * arg6))) << 0x20 | (((long)Float.floatToRawIntBits(v3[1] * arg4 + v3[4] * arg5 + v3[7] * arg6))) & 0xFFFFFFFFL;
    }

    public float[] toXyz(float[] arg5) {
        if(arg5.length < 3) {
            return arg5;
        }

        arg5[0] = ((float)this.eotfFunc.invoke(((double)arg5[0])));
        arg5[1] = ((float)this.eotfFunc.invoke(((double)arg5[1])));
        arg5[2] = ((float)this.eotfFunc.invoke(((double)arg5[2])));
        return ColorSpaceKt.mul3x3Float3(this.transform, arg5);
    }

    public float toZ$ui_graphics(float arg4, float arg5, float arg6) {
        return this.transform[2] * (((float)this.eotfFunc.invoke(((double)arg4)))) + this.transform[5] * (((float)this.eotfFunc.invoke(((double)arg5)))) + this.transform[8] * (((float)this.eotfFunc.invoke(((double)arg6))));
    }

    public long xyzaToColor-JlNiLsg$ui_graphics(float arg5, float arg6, float arg7, float arg8, ColorSpace arg9) {
        return ColorKt.Color(((float)this.oetfFunc.invoke(((double)(this.inverseTransform[0] * arg5 + this.inverseTransform[3] * arg6 + this.inverseTransform[6] * arg7)))), ((float)this.oetfFunc.invoke(((double)(this.inverseTransform[1] * arg5 + this.inverseTransform[4] * arg6 + this.inverseTransform[7] * arg7)))), ((float)this.oetfFunc.invoke(((double)(this.inverseTransform[2] * arg5 + this.inverseTransform[5] * arg6 + this.inverseTransform[8] * arg7)))), arg8, arg9);
    }
}

