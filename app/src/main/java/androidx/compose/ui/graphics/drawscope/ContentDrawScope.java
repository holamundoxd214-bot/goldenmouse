package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ContentDrawScope extends DrawScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static void drawImage-AZ2fEMs(ContentDrawScope arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14) {
            arg0.drawImage-AZ2fEMs(arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14);
        }

        @Deprecated public static long getCenter-F1C5BW0(ContentDrawScope arg2) {
            return arg2.getCenter-F1C5BW0();
        }

        @Deprecated public static long getSize-NH-jbRc(ContentDrawScope arg2) {
            return arg2.getSize-NH-jbRc();
        }

        @Deprecated public static void record-JVtK1S4(ContentDrawScope arg0, GraphicsLayer arg1, long arg2, Function1 arg4) {
            arg0.record-JVtK1S4(arg1, arg2, arg4);
        }

        @Deprecated public static int roundToPx--R2X_6o(ContentDrawScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(ContentDrawScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(ContentDrawScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(ContentDrawScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(ContentDrawScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(ContentDrawScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(ContentDrawScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(ContentDrawScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(ContentDrawScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(ContentDrawScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(ContentDrawScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(ContentDrawScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(ContentDrawScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    static void access$drawImage-AZ2fEMs$jd(ContentDrawScope arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14) {
        super.drawImage-AZ2fEMs(arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14);
    }

    static long access$getCenter-F1C5BW0$jd(ContentDrawScope arg2) {
        return super.getCenter-F1C5BW0();
    }

    static long access$getSize-NH-jbRc$jd(ContentDrawScope arg2) {
        return super.getSize-NH-jbRc();
    }

    static void access$record-JVtK1S4$jd(ContentDrawScope arg0, GraphicsLayer arg1, long arg2, Function1 arg4) {
        super.record-JVtK1S4(arg1, arg2, arg4);
    }

    static int access$roundToPx--R2X_6o$jd(ContentDrawScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(ContentDrawScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static float access$toDp-GaN1DYA$jd(ContentDrawScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(ContentDrawScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(ContentDrawScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(ContentDrawScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(ContentDrawScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(ContentDrawScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(ContentDrawScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(ContentDrawScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(ContentDrawScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(ContentDrawScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(ContentDrawScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    void drawContent();
}

