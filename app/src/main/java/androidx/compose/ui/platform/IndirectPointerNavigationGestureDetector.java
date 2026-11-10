package androidx.compose.ui.platform;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0012J\u0006\u0010\u0019\u001A\u00020\u0007R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/ui/platform/IndirectPointerNavigationGestureDetector;", "", "context", "Landroid/content/Context;", "onMoveFocus", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "getPrimaryDirectionalMotionAxis-nZO2Niw", "()I", "setPrimaryDirectionalMotionAxis-WQKaTuc", "(I)V", "I", "ignoreCurrentGestureStream", "", "gestureDetector", "Landroid/view/GestureDetector;", "onIndirectPointerEvent", "indirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "isConsumed", "cancelCurrentEventStream", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndirectPointerNavigationGestureDetector {
    public static final int $stable = 8;
    private final GestureDetector gestureDetector;
    private boolean ignoreCurrentGestureStream;
    private final Function1 onMoveFocus;
    private int primaryDirectionalMotionAxis;

    static {
    }

    public IndirectPointerNavigationGestureDetector(Context arg2, Function1 arg3) {
        super();
        this.onMoveFocus = arg3;
        this.primaryDirectionalMotionAxis = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getNone-nZO2Niw();
        this.gestureDetector = new GestureDetector(arg2, new IndirectPointerNavigationGestureDetector$gestureDetector$1(this));
    }

    public static final boolean access$getIgnoreCurrentGestureStream$p(IndirectPointerNavigationGestureDetector arg0) {
        return arg0.ignoreCurrentGestureStream;
    }

    public static final Function1 access$getOnMoveFocus$p(IndirectPointerNavigationGestureDetector arg0) {
        return arg0.onMoveFocus;
    }

    public final void cancelCurrentEventStream() {
        this.primaryDirectionalMotionAxis = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getNone-nZO2Niw();
        this.ignoreCurrentGestureStream = true;
    }

    public final int getPrimaryDirectionalMotionAxis-nZO2Niw() {
        return this.primaryDirectionalMotionAxis;
    }

    public final boolean onIndirectPointerEvent(IndirectPointerEvent arg3, boolean arg4) {
        MotionEvent v0 = AndroidIndirectPointerEvent_androidKt.getNativeEvent(arg3);
        int v1 = v0.getAction();
        if(v1 != 0) {
            if(v1 != 1 && v1 != 2) {
                goto label_15;
            }

            if(!arg4) {
                goto label_15;
            }

            this.cancelCurrentEventStream();
        }
        else {
            this.primaryDirectionalMotionAxis = arg3.getPrimaryDirectionalMotionAxis-nZO2Niw();
            this.ignoreCurrentGestureStream = false;
        }

    label_15:
        return this.gestureDetector.onTouchEvent(v0);
    }

    public final void setPrimaryDirectionalMotionAxis-WQKaTuc(int arg1) {
        this.primaryDirectionalMotionAxis = arg1;
    }
}

