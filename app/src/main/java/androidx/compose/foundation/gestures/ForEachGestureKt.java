package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A;\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\'\u0010\u0003\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0087@¢\u0006\u0002\u0010\b\u001A\f\u0010\t\u001A\u00020\n*\u00020\u000BH\u0000\u001A\u0012\u0010\f\u001A\u00020\u0001*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\r\u001A\u001C\u0010\f\u001A\u00020\u0001*\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0080@¢\u0006\u0002\u0010\u0010\u001A;\u0010\u0011\u001A\u00020\u0001*\u00020\u00022\'\u0010\u0003\u001A#\b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u0012"}, d2={"forEachGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ForEachGestureKt {
    public static final boolean allPointersUp(AwaitPointerEventScope arg5) {
        List v5 = arg5.getCurrentEvent().getChanges();
        int v0 = v5.size();
        int v1 = 0;
        int v2 = 0;
        while(v2 < v0) {
            if(v5.get(v2).getPressed()) {
                v1 = 1;
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        return v1 ^ 1;
    }

    public static final Object awaitAllPointersUp(AwaitPointerEventScope arg7, PointerEventPass arg8, Continuation arg9) {
        Object v8;
        Object v7;
        ForEachGestureKt$awaitAllPointersUp$3 v0_1;
        int v2;
        if((arg9 instanceof ForEachGestureKt$awaitAllPointersUp$3)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((ForEachGestureKt$awaitAllPointersUp$3)v0).label & v2) != 0) {
                ((ForEachGestureKt$awaitAllPointersUp$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ForEachGestureKt$awaitAllPointersUp$3(arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            if(!ForEachGestureKt.allPointersUp(arg7)) {
            label_33:
                v0_1.L$0 = v7;
                v0_1.L$1 = v8;
                v0_1.label = 1;
                v9 = ((AwaitPointerEventScope)v7).awaitPointerEvent(((PointerEventPass)v8), ((Continuation)v0_1));
                if(v9 == v1) {
                    return v1;
                }
                else {
                label_39:
                    List v9_1 = ((PointerEvent)v9).getChanges();
                    v2 = v9_1.size();
                    int v4 = 0;
                    while(v4 < v2) {
                        if(v9_1.get(v4).getPressed()) {
                            goto label_33;
                        }
                        else {
                            ++v4;
                            continue;
                        }
                    }
                }
            }
        }
        else if(v2 == 1) {
            v7 = v0_1.L$1;
            v8 = v0_1.L$0;
            ResultKt.throwOnFailure(v9);
            Object v6 = v8;
            v8 = v7;
            v7 = v6;
            goto label_39;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public static final Object awaitAllPointersUp(PointerInputScope arg2, Continuation arg3) {
        Object v2 = arg2.awaitPointerEventScope(new ForEachGestureKt$awaitAllPointersUp$2(null), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public static Object awaitAllPointersUp$default(AwaitPointerEventScope arg0, PointerEventPass arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = PointerEventPass.Final;
        }

        return ForEachGestureKt.awaitAllPointersUp(arg0, arg1, arg2);
    }

    public static final Object awaitEachGesture(PointerInputScope arg3, Function2 arg4, Continuation arg5) {
        Object v3 = arg3.awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(arg5.getContext(), arg4, null), arg5);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    @Deprecated(message="Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith="<_subannotation>") public static final Object forEachGesture(PointerInputScope arg8, Function2 arg9, Continuation arg10) {
        Object v2_1;
        Object v9;
        Object v8;
        int v2;
        Continuation v0;
        if((arg10 instanceof ForEachGestureKt$forEachGesture$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((ForEachGestureKt$forEachGesture$1)v0).label & v2) != 0) {
                ((ForEachGestureKt$forEachGesture$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ForEachGestureKt$forEachGesture$1 v0_1 = new ForEachGestureKt$forEachGesture$1(arg10);
        }

        Object v10 = ((ForEachGestureKt$forEachGesture$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ForEachGestureKt$forEachGesture$1)v0).label;
        int v3 = 3;
        int v4 = 2;
        if(v2 != 0) {
            if(v2 != 1) {
                if(v2 != v4) {
                    if(v2 == v3) {
                        v8 = ((ForEachGestureKt$forEachGesture$1)v0).L$2;
                        v9 = ((ForEachGestureKt$forEachGesture$1)v0).L$1;
                        v2_1 = ((ForEachGestureKt$forEachGesture$1)v0).L$0;
                        ResultKt.throwOnFailure(v10);
                        goto label_36;
                    }

                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }

                v8 = ((ForEachGestureKt$forEachGesture$1)v0).L$2;
                v9 = ((ForEachGestureKt$forEachGesture$1)v0).L$1;
                v2_1 = ((ForEachGestureKt$forEachGesture$1)v0).L$0;
                try {
                    ResultKt.throwOnFailure(v10);
                    goto label_36;
                }
                catch(CancellationException v10_1) {
                    goto label_45;
                }
            }

            v8 = ((ForEachGestureKt$forEachGesture$1)v0).L$2;
            v9 = ((ForEachGestureKt$forEachGesture$1)v0).L$1;
            v2_1 = ((ForEachGestureKt$forEachGesture$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                goto label_59;
            }
            catch(CancellationException v10_1) {
                goto label_45;
            }
        }

        ResultKt.throwOnFailure(v10);
        CoroutineContext v10_2 = v0.getContext();
        goto label_48;
        try {
        label_59:
            ((ForEachGestureKt$forEachGesture$1)v0).L$0 = v2_1;
            ((ForEachGestureKt$forEachGesture$1)v0).L$1 = v9;
            ((ForEachGestureKt$forEachGesture$1)v0).L$2 = v8;
            ((ForEachGestureKt$forEachGesture$1)v0).label = v4;
            if(ForEachGestureKt.awaitAllPointersUp(((PointerInputScope)v2_1), v0) != v1) {
                goto label_36;
            }
        }
        catch(CancellationException v10_1) {
            goto label_45;
        }

        return v1;
    label_48:
        if(!JobKt.isActive(v10_2)) {
            goto label_81;
        }

        try {
            ((ForEachGestureKt$forEachGesture$1)v0).L$0 = arg8;
            ((ForEachGestureKt$forEachGesture$1)v0).L$1 = v9;
            ((ForEachGestureKt$forEachGesture$1)v0).L$2 = v10_2;
            ((ForEachGestureKt$forEachGesture$1)v0).label = 1;
            if(((Function2)v9).invoke(arg8, v0) != v1) {
                goto label_57;
            }
        }
        catch(CancellationException v2_2) {
            goto label_67;
        }

        return v1;
    label_57:
        PointerInputScope v2_3 = arg8;
        v8 = v10_2;
        goto label_59;
    label_67:
        CancellationException v7 = v2_2;
        v2_3 = arg8;
        v8 = v10_2;
        v10_1 = v7;
        goto label_71;
    label_81:
        return Unit.INSTANCE;
    label_71:
        if(JobKt.isActive(((CoroutineContext)v8))) {
            ((ForEachGestureKt$forEachGesture$1)v0).L$0 = v2_3;
            ((ForEachGestureKt$forEachGesture$1)v0).L$1 = v9;
            ((ForEachGestureKt$forEachGesture$1)v0).L$2 = v8;
            ((ForEachGestureKt$forEachGesture$1)v0).label = v3;
            if(ForEachGestureKt.awaitAllPointersUp(v2_3, v0) != v1) {
                goto label_36;
            }

            return v1;
        }

        throw v10_1;
    label_45:
        goto label_71;
    label_36:
        v10 = v8;
        v8 = v2_3;
        goto label_48;
    }
}

