package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001A\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005\u001A\u001A\u0010\u0006\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005\u001A\u001A\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005¨\u0006\b"}, d2={"detectDownAndDragGesturesWithObserver", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectPreDragGesturesWithObserver", "detectDragGesturesWithObserver", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LongPressTextDragObserverKt {
    public static final Object access$detectDragGesturesWithObserver(PointerInputScope arg0, TextDragObserver arg1, Continuation arg2) {
        return LongPressTextDragObserverKt.detectDragGesturesWithObserver(arg0, arg1, arg2);
    }

    public static final Object access$detectPreDragGesturesWithObserver(PointerInputScope arg0, TextDragObserver arg1, Continuation arg2) {
        return LongPressTextDragObserverKt.detectPreDragGesturesWithObserver(arg0, arg1, arg2);
    }

    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope arg2, TextDragObserver arg3, Continuation arg4) {
        Object v2 = CoroutineScopeKt.coroutineScope(new LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2(arg2, arg3, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    private static final Object detectDragGesturesWithObserver(PointerInputScope arg6, TextDragObserver arg7, Continuation arg8) {
        Object v6 = DragGestureDetectorKt.detectDragGestures(arg6, new LongPressTextDragObserverKt$$ExternalSyntheticLambda0(arg7), new LongPressTextDragObserverKt$$ExternalSyntheticLambda1(arg7), new LongPressTextDragObserverKt$$ExternalSyntheticLambda2(arg7), new LongPressTextDragObserverKt$$ExternalSyntheticLambda3(arg7), arg8);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    static final Unit detectDragGesturesWithObserver$lambda$0(TextDragObserver arg2, Offset arg3) {
        arg2.onStart-3MmeM6k(arg3.unbox-impl(), SelectionAdjustment.Companion.getNone());
        return Unit.INSTANCE;
    }

    static final Unit detectDragGesturesWithObserver$lambda$1(TextDragObserver arg0) {
        arg0.onStop();
        return Unit.INSTANCE;
    }

    static final Unit detectDragGesturesWithObserver$lambda$2(TextDragObserver arg0) {
        arg0.onCancel();
        return Unit.INSTANCE;
    }

    static final Unit detectDragGesturesWithObserver$lambda$3(TextDragObserver arg0, PointerInputChange arg1, Offset arg2) {
        arg0.onDrag-k-4lQ0M(arg2.unbox-impl());
        return Unit.INSTANCE;
    }

    private static final Object detectPreDragGesturesWithObserver(PointerInputScope arg2, TextDragObserver arg3, Continuation arg4) {
        Object v2 = ForEachGestureKt.awaitEachGesture(arg2, new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(arg3, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

