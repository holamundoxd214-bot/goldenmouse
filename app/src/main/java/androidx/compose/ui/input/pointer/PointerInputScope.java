package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J=\u0010\u0016\u001A\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\'\u0010\u0018\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\u0019¢\u0006\u0002\b\u001DH¦@¢\u0006\u0002\u0010\u001ER\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001A\u00020\nX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR*\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E8V@VX\u0097\u000E¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001FÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "_", "", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents$annotations", "()V", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PointerInputScope extends Density {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static long getExtendedTouchPadding-NH-jbRc(PointerInputScope arg2) {
            return arg2.getExtendedTouchPadding-NH-jbRc();
        }

        @Deprecated public static boolean getInterceptOutOfBoundsChildEvents(PointerInputScope arg0) {
            return arg0.getInterceptOutOfBoundsChildEvents();
        }

        public static void getInterceptOutOfBoundsChildEvents$annotations() {
        }

        @Deprecated public static int roundToPx--R2X_6o(PointerInputScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(PointerInputScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static void setInterceptOutOfBoundsChildEvents(PointerInputScope arg0, boolean arg1) {
            arg0.setInterceptOutOfBoundsChildEvents(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(PointerInputScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(PointerInputScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(PointerInputScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(PointerInputScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(PointerInputScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(PointerInputScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(PointerInputScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(PointerInputScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(PointerInputScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(PointerInputScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(PointerInputScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    static long access$getExtendedTouchPadding-NH-jbRc$jd(PointerInputScope arg2) {
        return super.getExtendedTouchPadding-NH-jbRc();
    }

    static boolean access$getInterceptOutOfBoundsChildEvents$jd(PointerInputScope arg0) {
        return super.getInterceptOutOfBoundsChildEvents();
    }

    static int access$roundToPx--R2X_6o$jd(PointerInputScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(PointerInputScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static void access$setInterceptOutOfBoundsChildEvents$jd(PointerInputScope arg0, boolean arg1) {
        super.setInterceptOutOfBoundsChildEvents(arg1);
    }

    static float access$toDp-GaN1DYA$jd(PointerInputScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(PointerInputScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(PointerInputScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(PointerInputScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(PointerInputScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(PointerInputScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(PointerInputScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(PointerInputScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(PointerInputScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(PointerInputScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(PointerInputScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    Object awaitPointerEventScope(Function2 arg1, Continuation arg2);

    default long getExtendedTouchPadding-NH-jbRc() {
        return Size.Companion.getZero-NH-jbRc();
    }

    default boolean getInterceptOutOfBoundsChildEvents() {
        return 0;
    }

    long getSize-YbymL2g();

    ViewConfiguration getViewConfiguration();

    default void setInterceptOutOfBoundsChildEvents(boolean arg1) {
    }
}

