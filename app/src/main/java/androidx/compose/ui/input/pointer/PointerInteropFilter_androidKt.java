package androidx.compose.ui.input.pointer;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001A\u00020\tH\u0000\u001A-\u0010\n\u001A\u00020\u0001*\u00020\u00012!\u0010\u000B\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\u0005¨\u0006\u0010"}, d2={"pointerInteropFilter", "Landroidx/compose/ui/Modifier;", "requestDisallowInterceptTouchEvent", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "onTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "view", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "motionEventSpy", "watcher", "Lkotlin/ParameterName;", "name", "motionEvent", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerInteropFilter_androidKt {
    public static final Modifier motionEventSpy(Modifier arg1, Function1 arg2) {
        return SuspendingPointerInputFilterKt.pointerInput(arg1, arg2, new PointerInteropFilter_androidKt$motionEventSpy$1(arg2));
    }

    public static final Modifier pointerInteropFilter(Modifier arg2, RequestDisallowInterceptTouchEvent arg3, Function1 arg4) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            PointerInteropFilter_androidKt$pointerInteropFilter$$inlined$debugInspectorInfo$1 v0 = new PointerInteropFilter_androidKt$pointerInteropFilter$$inlined$debugInspectorInfo$1(arg3, arg4);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, v0_1, new PointerInteropFilter_androidKt$pointerInteropFilter$2(arg4, arg3));
    }

    public static final Modifier pointerInteropFilter(Modifier arg2, AndroidViewHolder arg3) {
        PointerInteropFilter v0 = new PointerInteropFilter();
        v0.setOnTouchEvent(new PointerInteropFilter_androidKt$pointerInteropFilter$3(arg3));
        RequestDisallowInterceptTouchEvent v1 = new RequestDisallowInterceptTouchEvent();
        v0.setRequestDisallowInterceptTouchEvent(v1);
        arg3.setOnRequestDisallowInterceptTouchEvent$ui(((Function1)v1));
        return arg2.then(((Modifier)v0));
    }

    public static Modifier pointerInteropFilter$default(Modifier arg0, RequestDisallowInterceptTouchEvent arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        return PointerInteropFilter_androidKt.pointerInteropFilter(arg0, arg1, arg2);
    }
}

