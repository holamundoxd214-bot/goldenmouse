package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\bf\u0018\u00002\u00020\u0001J\u000E\u0010\u0002\u001A\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000E\u0010\u0005\u001A\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2={"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PressGestureScope extends Density {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static int roundToPx--R2X_6o(PressGestureScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(PressGestureScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(PressGestureScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(PressGestureScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(PressGestureScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(PressGestureScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(PressGestureScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(PressGestureScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(PressGestureScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(PressGestureScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(PressGestureScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(PressGestureScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(PressGestureScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    static int access$roundToPx--R2X_6o$jd(PressGestureScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(PressGestureScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static float access$toDp-GaN1DYA$jd(PressGestureScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(PressGestureScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(PressGestureScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(PressGestureScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(PressGestureScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(PressGestureScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(PressGestureScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(PressGestureScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(PressGestureScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(PressGestureScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(PressGestureScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    Object awaitRelease(Continuation arg1);

    Object tryAwaitRelease(Continuation arg1);
}

