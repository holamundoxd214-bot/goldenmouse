package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001A/\u0010\n\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\u000B\u0010\t\u001A&\u0010\f\u001A\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000E2\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000\u001A7\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000F\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"toMotionEventScope", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "offset", "Landroidx/compose/ui/geometry/Offset;", "block", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "toMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;)V", "toCancelMotionEventScope", "toCancelMotionEventScope-d-4ec7I", "emptyCancelMotionEventScope", "nowMillis", "", "cancel", "", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;Z)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long arg8, Function1 arg10) {
        MotionEvent v8 = MotionEvent.obtain(arg8, arg8, 3, 0f, 0f, 0);
        v8.setSource(0);
        arg10.invoke(v8);
        v8.recycle();
    }

    public static void emptyCancelMotionEventScope$default(long arg0, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg0 = SystemClock.uptimeMillis();
        }

        PointerInteropUtils_androidKt.emptyCancelMotionEventScope(arg0, arg2);
    }

    public static final void toCancelMotionEventScope-d-4ec7I(PointerEvent arg1, long arg2, Function1 arg4) {
        PointerInteropUtils_androidKt.toMotionEventScope-ubNVwUQ(arg1, arg2, arg4, true);
    }

    public static final void toMotionEventScope-d-4ec7I(PointerEvent arg1, long arg2, Function1 arg4) {
        PointerInteropUtils_androidKt.toMotionEventScope-ubNVwUQ(arg1, arg2, arg4, false);
    }

    private static final void toMotionEventScope-ubNVwUQ(PointerEvent arg4, long arg5, Function1 arg7, boolean arg8) {
        MotionEvent v4 = arg4.getMotionEvent();
        if(v4 != null) {
            int v0 = v4.getAction();
            if(arg8) {
                v4.setAction(3);
            }

            int v8 = ((int)(arg5 >> 0x20));
            int v5 = ((int)(arg5 & 0xFFFFFFFFL));
            v4.offsetLocation(-Float.intBitsToFloat(v8), -Float.intBitsToFloat(v5));
            arg7.invoke(v4);
            v4.offsetLocation(Float.intBitsToFloat(v8), Float.intBitsToFloat(v5));
            v4.setAction(v0);
            return;
        }

        throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
    }
}

