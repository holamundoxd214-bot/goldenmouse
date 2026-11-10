package androidx.compose.foundation.text.contextmenu.gestures;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0080@¢\u0006\u0002\u0010\u0006\u001A\u0012\u0010\u0007\u001A\u00020\b*\u00020\tH\u0082@¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"onRightClickDown", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstRightClickDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RightClickGesturesKt {
    public static final Object access$awaitFirstRightClickDown(AwaitPointerEventScope arg0, Continuation arg1) {
        return RightClickGesturesKt.awaitFirstRightClickDown(arg0, arg1);
    }

    private static final Object awaitFirstRightClickDown(AwaitPointerEventScope arg8, Continuation arg9) {
        Object v8;
        int v2;
        Continuation v0;
        if((arg9 instanceof RightClickGesturesKt$awaitFirstRightClickDown$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).label & v2) != 0) {
                ((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            RightClickGesturesKt$awaitFirstRightClickDown$1 v0_1 = new RightClickGesturesKt$awaitFirstRightClickDown$1(arg9);
        }

        Object v9 = ((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
        label_27:
            ((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).L$0 = v8;
            ((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).label = 1;
            v9 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v8), null, v0, 1, null);
            if(v9 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v8 = ((RightClickGesturesKt$awaitFirstRightClickDown$1)v0).L$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(!PointerEvent_androidKt.isSecondaryPressed-aHzCx-E(((PointerEvent)v9).getButtons-ry648PA())) {
            goto label_27;
        }

        List v2_1 = ((PointerEvent)v9).getChanges();
        int v4 = v2_1.size();
        int v6;
        for(v6 = 0; v6 < v4; ++v6) {
            if(!PointerEventKt.changedToDown(v2_1.get(v6))) {
                goto label_27;
            }
        }

        return ((PointerEvent)v9).getChanges().get(0);
    }

    public static final Object onRightClickDown(PointerInputScope arg2, Function1 arg3, Continuation arg4) {
        Object v2 = ForEachGestureKt.awaitEachGesture(arg2, new RightClickGesturesKt$onRightClickDown$2(arg3, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

