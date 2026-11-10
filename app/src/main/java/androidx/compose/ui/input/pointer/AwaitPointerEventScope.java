package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001A\u00020\n2\b\b\u0002\u0010\u0012\u001A\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014JG\u0010\u0015\u001A\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001A\u00020\u00182\'\u0010\u0019\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\u001A¢\u0006\u0002\b\u001DH\u0096@¢\u0006\u0002\u0010\u001EJE\u0010\u001F\u001A\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001A\u00020\u00182\'\u0010\u0019\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\u001A¢\u0006\u0002\b\u001DH\u0096@¢\u0006\u0002\u0010\u001ER\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001A\u00020\nX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0012\u0010\r\u001A\u00020\u000EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2={"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AwaitPointerEventScope extends Density {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static Object awaitPointerEvent$default(AwaitPointerEventScope arg0, PointerEventPass arg1, Continuation arg2, int arg3, Object arg4) {
            return AwaitPointerEventScope.awaitPointerEvent$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static long getExtendedTouchPadding-NH-jbRc(AwaitPointerEventScope arg2) {
            return arg2.getExtendedTouchPadding-NH-jbRc();
        }

        @Deprecated public static int roundToPx--R2X_6o(AwaitPointerEventScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(AwaitPointerEventScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(AwaitPointerEventScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(AwaitPointerEventScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(AwaitPointerEventScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(AwaitPointerEventScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(AwaitPointerEventScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(AwaitPointerEventScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(AwaitPointerEventScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(AwaitPointerEventScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(AwaitPointerEventScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(AwaitPointerEventScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(AwaitPointerEventScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static Object withTimeout(AwaitPointerEventScope arg0, long arg1, Function2 arg3, Continuation arg4) {
            return arg0.withTimeout(arg1, arg3, arg4);
        }

        @Deprecated public static Object withTimeoutOrNull(AwaitPointerEventScope arg0, long arg1, Function2 arg3, Continuation arg4) {
            return arg0.withTimeoutOrNull(arg1, arg3, arg4);
        }
    }

    static long access$getExtendedTouchPadding-NH-jbRc$jd(AwaitPointerEventScope arg2) {
        return super.getExtendedTouchPadding-NH-jbRc();
    }

    static int access$roundToPx--R2X_6o$jd(AwaitPointerEventScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(AwaitPointerEventScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static float access$toDp-GaN1DYA$jd(AwaitPointerEventScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(AwaitPointerEventScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(AwaitPointerEventScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(AwaitPointerEventScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(AwaitPointerEventScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(AwaitPointerEventScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(AwaitPointerEventScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(AwaitPointerEventScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(AwaitPointerEventScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(AwaitPointerEventScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(AwaitPointerEventScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static Object access$withTimeout$jd(AwaitPointerEventScope arg0, long arg1, Function2 arg3, Continuation arg4) {
        return super.withTimeout(arg1, arg3, arg4);
    }

    static Object access$withTimeoutOrNull$jd(AwaitPointerEventScope arg0, long arg1, Function2 arg3, Continuation arg4) {
        return super.withTimeoutOrNull(arg1, arg3, arg4);
    }

    Object awaitPointerEvent(PointerEventPass arg1, Continuation arg2);

    static Object awaitPointerEvent$default(AwaitPointerEventScope arg0, PointerEventPass arg1, Continuation arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = PointerEventPass.Main;
            }

            return arg0.awaitPointerEvent(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
    }

    PointerEvent getCurrentEvent();

    default long getExtendedTouchPadding-NH-jbRc() {
        return Size.Companion.getZero-NH-jbRc();
    }

    long getSize-YbymL2g();

    ViewConfiguration getViewConfiguration();

    default Object withTimeout(long arg1, Function2 arg3, Continuation arg4) {
        return AwaitPointerEventScope.withTimeout$suspendImpl(this, arg1, arg3, arg4);
    }

    static Object withTimeout$suspendImpl(AwaitPointerEventScope arg0, long arg1, Function2 arg3, Continuation arg4) {
        return arg3.invoke(arg0, arg4);
    }

    default Object withTimeoutOrNull(long arg1, Function2 arg3, Continuation arg4) {
        return AwaitPointerEventScope.withTimeoutOrNull$suspendImpl(this, arg1, arg3, arg4);
    }

    static Object withTimeoutOrNull$suspendImpl(AwaitPointerEventScope arg0, long arg1, Function2 arg3, Continuation arg4) {
        return arg3.invoke(arg0, arg4);
    }
}

