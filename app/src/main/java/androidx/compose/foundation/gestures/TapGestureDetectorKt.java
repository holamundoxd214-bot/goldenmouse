package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u008B\u0001\u0010\t\u001A\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000E\u001A)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001A\u0012\u0010\u0011\u001A\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013\u001A\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017\u001A[\u0010\u0018\u001A\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000E\u001A)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0019\u001A\u001C\u0010\u001A\u001A\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001B\u001A\u00020\u001CH\u0087@¢\u0006\u0002\u0010\u001D\u001A&\u0010\u001A\u001A\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0086@¢\u0006\u0002\u0010 \u001A&\u0010!\u001A\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0080@¢\u0006\u0002\u0010 \u001A\u001E\u0010\"\u001A\u00020\u001C*\u00020#2\u0006\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010$\u001A\u00020\u001CH\u0000\u001A\u0014\u0010%\u001A\u0004\u0018\u00010\u0015*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0013\u001A\u001E\u0010%\u001A\u0004\u0018\u00010\u0015*\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0086@¢\u0006\u0002\u0010&\u001A\u001C\u0010\'\u001A\u00020(*\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0080@¢\u0006\u0002\u0010&\u001AL\u00106\u001A\u000207*\u0002082\u0006\u00109\u001A\u0002072\b\b\u0002\u0010:\u001A\u0002022\'\u0010;\u001A#\b\u0001\u0012\u0004\u0012\u000208\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060<¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u0010=\"7\u0010\u0000\u001A)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"*\u0010*\u001A\u00020\u001C2\u0006\u0010)\u001A\u00020\u001C8F@FX\u0087\u000E¢\u0006\u0012\u0012\u0004\b+\u0010,\u001A\u0004\b-\u0010.\"\u0004\b/\u00100\"\u001A\u00101\u001A\u0002028BX\u0082\u0004¢\u0006\f\u0012\u0004\b3\u0010,\u001A\u0004\b4\u00105¨\u0006>"}, d2={"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "value", "DetectTapGesturesEnableNewDispatchingBehavior", "getDetectTapGesturesEnableNewDispatchingBehavior$annotations", "()V", "getDetectTapGesturesEnableNewDispatchingBehavior", "()Z", "setDetectTapGesturesEnableNewDispatchingBehavior", "(Z)V", "coroutineStartForCurrentDispatchBehavior", "Lkotlinx/coroutines/CoroutineStart;", "getCoroutineStartForCurrentDispatchBehavior$annotations", "getCoroutineStartForCurrentDispatchBehavior", "()Lkotlinx/coroutines/CoroutineStart;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "resetJob", "start", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TapGestureDetectorKt {
    private static final Function3 NoPressGesture;

    static {
        TapGestureDetectorKt.NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);
    }

    public static final Object access$awaitSecondDown(AwaitPointerEventScope arg0, PointerInputChange arg1, Continuation arg2) {
        return TapGestureDetectorKt.awaitSecondDown(arg0, arg1, arg2);
    }

    public static final Object access$consumeUntilUp(AwaitPointerEventScope arg0, Continuation arg1) {
        return TapGestureDetectorKt.consumeUntilUp(arg0, arg1);
    }

    public static final CoroutineStart access$getCoroutineStartForCurrentDispatchBehavior() {
        return TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior();
    }

    public static final Function3 access$getNoPressGesture$p() {
        return TapGestureDetectorKt.NoPressGesture;
    }

    public static final Object awaitFirstDown(AwaitPointerEventScope arg7, boolean arg8, PointerEventPass arg9, Continuation arg10) {
        Object v7_1;
        Object v9;
        int v2;
        Continuation v0;
        if((arg10 instanceof TapGestureDetectorKt$awaitFirstDown$2)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((TapGestureDetectorKt$awaitFirstDown$2)v0).label & v2) != 0) {
                ((TapGestureDetectorKt$awaitFirstDown$2)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TapGestureDetectorKt$awaitFirstDown$2 v0_1 = new TapGestureDetectorKt$awaitFirstDown$2(arg10);
        }

        Object v10 = ((TapGestureDetectorKt$awaitFirstDown$2)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TapGestureDetectorKt$awaitFirstDown$2)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            goto label_33;
        label_40:
            if(TapGestureDetectorKt.isChangedToDown$default(((PointerEvent)v10), arg8, false, 2, null)) {
                return ((PointerEvent)v10).getChanges().get(0);
            }
        }
        else if(v2 == 1) {
            boolean v7 = ((TapGestureDetectorKt$awaitFirstDown$2)v0).Z$0;
            Object v8 = ((TapGestureDetectorKt$awaitFirstDown$2)v0).L$1;
            v9 = ((TapGestureDetectorKt$awaitFirstDown$2)v0).L$0;
            ResultKt.throwOnFailure(v10);
            Object v6 = v8;
            arg8 = v7;
            v7_1 = v9;
            v9 = v6;
            goto label_40;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        ((TapGestureDetectorKt$awaitFirstDown$2)v0).L$0 = v7_1;
        ((TapGestureDetectorKt$awaitFirstDown$2)v0).L$1 = v9;
        ((TapGestureDetectorKt$awaitFirstDown$2)v0).Z$0 = arg8;
        ((TapGestureDetectorKt$awaitFirstDown$2)v0).label = 1;
        v10 = ((AwaitPointerEventScope)v7_1).awaitPointerEvent(((PointerEventPass)v9), v0);
        if(v10 != v1) {
            goto label_40;
        }

        return v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with PointerEventPass instead.") public static final Object awaitFirstDown(AwaitPointerEventScope arg1, boolean arg2, Continuation arg3) {
        return TapGestureDetectorKt.awaitFirstDown(arg1, arg2, PointerEventPass.Main, arg3);
    }

    public static Object awaitFirstDown$default(AwaitPointerEventScope arg0, boolean arg1, PointerEventPass arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = PointerEventPass.Main;
        }

        return TapGestureDetectorKt.awaitFirstDown(arg0, true, arg2, arg3);
    }

    public static Object awaitFirstDown$default(AwaitPointerEventScope arg0, boolean arg1, Continuation arg2, int arg3, Object arg4) {
        return TapGestureDetectorKt.awaitFirstDown(arg0, true, arg2);
    }

    public static final Object awaitPrimaryFirstDown(AwaitPointerEventScope arg5, boolean arg6, PointerEventPass arg7, Continuation arg8) {
        Object v5_1;
        Object v7;
        TapGestureDetectorKt$awaitPrimaryFirstDown$1 v0_1;
        int v2;
        if((arg8 instanceof TapGestureDetectorKt$awaitPrimaryFirstDown$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((TapGestureDetectorKt$awaitPrimaryFirstDown$1)v0).label & v2) != 0) {
                ((TapGestureDetectorKt$awaitPrimaryFirstDown$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TapGestureDetectorKt$awaitPrimaryFirstDown$1(arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            goto label_33;
        label_40:
            if(TapGestureDetectorKt.isChangedToDown(((PointerEvent)v8), arg6, true)) {
                return ((PointerEvent)v8).getChanges().get(0);
            }
        }
        else if(v2 == 1) {
            boolean v5 = v0_1.Z$0;
            Object v6 = v0_1.L$1;
            v7 = v0_1.L$0;
            ResultKt.throwOnFailure(v8);
            Object v4 = v6;
            arg6 = v5;
            v5_1 = v7;
            v7 = v4;
            goto label_40;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        v0_1.L$0 = v5_1;
        v0_1.L$1 = v7;
        v0_1.Z$0 = arg6;
        v0_1.label = 1;
        v8 = ((AwaitPointerEventScope)v5_1).awaitPointerEvent(((PointerEventPass)v7), ((Continuation)v0_1));
        if(v8 != v1) {
            goto label_40;
        }

        return v1;
    }

    public static Object awaitPrimaryFirstDown$default(AwaitPointerEventScope arg0, boolean arg1, PointerEventPass arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = PointerEventPass.Main;
        }

        return TapGestureDetectorKt.awaitPrimaryFirstDown(arg0, true, arg2, arg3);
    }

    private static final Object awaitSecondDown(AwaitPointerEventScope arg4, PointerInputChange arg5, Continuation arg6) {
        return arg4.withTimeoutOrNull(arg4.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(arg5, null), arg6);
    }

    private static final Object consumeUntilUp(AwaitPointerEventScope arg8, Continuation arg9) {
        Object v8;
        int v2;
        Continuation v0;
        if((arg9 instanceof TapGestureDetectorKt$consumeUntilUp$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((TapGestureDetectorKt$consumeUntilUp$1)v0).label & v2) != 0) {
                ((TapGestureDetectorKt$consumeUntilUp$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TapGestureDetectorKt$consumeUntilUp$1 v0_1 = new TapGestureDetectorKt$consumeUntilUp$1(arg9);
        }

        Object v9 = ((TapGestureDetectorKt$consumeUntilUp$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TapGestureDetectorKt$consumeUntilUp$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
        label_27:
            ((TapGestureDetectorKt$consumeUntilUp$1)v0).L$0 = v8;
            ((TapGestureDetectorKt$consumeUntilUp$1)v0).label = 1;
            v9 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v8), null, v0, 1, null);
            if(v9 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v8 = ((TapGestureDetectorKt$consumeUntilUp$1)v0).L$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v2_1 = ((PointerEvent)v9).getChanges();
        int v4 = v2_1.size();
        int v5 = 0;
        int v6;
        for(v6 = 0; v6 < v4; ++v6) {
            v2_1.get(v6).consume();
        }

        List v9_1 = ((PointerEvent)v9).getChanges();
        v2 = v9_1.size();
        while(v5 < v2) {
            if(v9_1.get(v5).getPressed()) {
                goto label_27;
            }

            ++v5;
        }

        return Unit.INSTANCE;
    }

    public static final Object detectTapAndPress(PointerInputScope arg6, Function3 arg7, Function1 arg8, Continuation arg9) {
        Object v6 = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapAndPress$2(arg6, arg7, arg8, new PressGestureScopeImpl(arg6), null), arg9);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object detectTapAndPress$default(PointerInputScope arg0, Function3 arg1, Function1 arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = TapGestureDetectorKt.NoPressGesture;
        }

        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        return TapGestureDetectorKt.detectTapAndPress(arg0, arg1, arg2, arg3);
    }

    public static final Object detectTapGestures(PointerInputScope arg7, Function1 arg8, Function1 arg9, Function3 arg10, Function1 arg11, Continuation arg12) {
        Object v7 = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2(arg7, arg10, arg9, arg8, arg11, null), arg12);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public static Object detectTapGestures$default(PointerInputScope arg1, Function1 arg2, Function1 arg3, Function3 arg4, Function1 arg5, Continuation arg6, int arg7, Object arg8) {
        Function1 v0 = null;
        if((arg7 & 1) != 0) {
            arg2 = v0;
        }

        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        if((arg7 & 4) != 0) {
            arg4 = TapGestureDetectorKt.NoPressGesture;
        }

        if((arg7 & 8) != 0) {
            arg5 = v0;
        }

        return TapGestureDetectorKt.detectTapGestures(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static final CoroutineStart getCoroutineStartForCurrentDispatchBehavior() {
        if(ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled) {
            return CoroutineStart.UNDISPATCHED;
        }

        return CoroutineStart.DEFAULT;
    }

    private static void getCoroutineStartForCurrentDispatchBehavior$annotations() {
    }

    public static final boolean getDetectTapGesturesEnableNewDispatchingBehavior() {
        return ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled;
    }

    @Deprecated(message="This flag has been moved to ComposeFoundationFlags and renamed to isDetectTapGesturesImmediateCoroutineDispatchEnabled. For compatibility,  DetectTapGesturesEnableNewDispatchingBehavior controls the new flag (isDetectTapGesturesImmediateCoroutineDispatchEnabled). Please use  isDetectTapGesturesImmediateCoroutineDispatchEnabled instead.", replaceWith="<_subannotation>") public static void getDetectTapGesturesEnableNewDispatchingBehavior$annotations() {
    }

    public static final boolean isChangedToDown(PointerEvent arg5, boolean arg6, boolean arg7) {
        int v1;
        if(arg7) {
            List v7 = arg5.getChanges();
            v1 = v7.size();
            int v2 = 0;
            while(true) {
                if(v2 >= v1) {
                    break;
                }
                else if(!PointerType.equals-impl0(v7.get(v2).getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA())) {
                }
                else {
                    ++v2;
                    continue;
                }

                goto label_20;
            }

            if(!PointerEvent_androidKt.isPrimaryPressed-aHzCx-E(arg5.getButtons-ry648PA())) {
                return 0;
            }
        }

    label_20:
        List v5 = arg5.getChanges();
        int v7_1 = v5.size();
        for(v1 = 0; v1 < v7_1; ++v1) {
            Object v2_1 = v5.get(v1);
            boolean v2_2 = arg6 ? PointerEventKt.changedToDown(((PointerInputChange)v2_1)) : PointerEventKt.changedToDownIgnoreConsumed(((PointerInputChange)v2_1));
            if(!v2_2) {
                return 0;
            }
        }

        return 1;
    }

    public static boolean isChangedToDown$default(PointerEvent arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
        }

        return TapGestureDetectorKt.isChangedToDown(arg0, arg1, arg2);
    }

    private static final Job launchAwaitingReset(CoroutineScope arg8, Job arg9, CoroutineStart arg10, Function2 arg11) {
        return BuildersKt.launch$default(arg8, null, arg10, new TapGestureDetectorKt$launchAwaitingReset$1(arg9, arg11, null), 1, null);
    }

    static Job launchAwaitingReset$default(CoroutineScope arg0, Job arg1, CoroutineStart arg2, Function2 arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior();
        }

        return TapGestureDetectorKt.launchAwaitingReset(arg0, arg1, arg2, arg3);
    }

    public static final void setDetectTapGesturesEnableNewDispatchingBehavior(boolean arg1) {
        ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled = arg1;
    }

    public static final Object waitForLongPress(AwaitPointerEventScope arg7, PointerEventPass arg8, Continuation arg9) {
        ObjectRef v7_1;
        TapGestureDetectorKt$waitForLongPress$1 v0_1;
        int v2;
        if((arg9 instanceof TapGestureDetectorKt$waitForLongPress$1)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((TapGestureDetectorKt$waitForLongPress$1)v0).label & v2) != 0) {
                ((TapGestureDetectorKt$waitForLongPress$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TapGestureDetectorKt$waitForLongPress$1(arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            ObjectRef v9_1 = new ObjectRef();
            v9_1.element = Canceled.INSTANCE;
            try {
                long v4 = arg7.getViewConfiguration().getLongPressTimeoutMillis();
                TapGestureDetectorKt$waitForLongPress$2 v2_1 = new TapGestureDetectorKt$waitForLongPress$2(arg8, v9_1, null);
                v0_1.L$0 = v9_1;
                v0_1.label = 1;
                if(arg7.withTimeout(v4, ((Function2)v2_1), ((Continuation)v0_1)) != v1) {
                    goto label_41;
                }
            }
            catch(PointerEventTimeoutCancellationException ) {
            label_44:
                return Success.INSTANCE;
            }

            return v1;
        label_41:
            v7_1 = v9_1;
        }
        else if(v2 == 1) {
            Object v7 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v9);
            }
            catch(PointerEventTimeoutCancellationException ) {
                goto label_44;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return v7_1.element;
    }

    public static Object waitForLongPress$default(AwaitPointerEventScope arg0, PointerEventPass arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = PointerEventPass.Main;
        }

        return TapGestureDetectorKt.waitForLongPress(arg0, arg1, arg2);
    }

    public static final Object waitForUpOrCancellation(AwaitPointerEventScope arg17, PointerEventPass arg18, Continuation arg19) {
        Object v8;
        Object v3_1;
        int v10;
        int v9;
        List v0_3;
        int v3;
        Continuation v1;
        Continuation v0 = arg19;
        if((v0 instanceof TapGestureDetectorKt$waitForUpOrCancellation$2)) {
            v1 = v0;
            v3 = 0x80000000;
            if((((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).label & v3) != 0) {
                ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            TapGestureDetectorKt$waitForUpOrCancellation$2 v1_1 = new TapGestureDetectorKt$waitForUpOrCancellation$2(v0);
        }

        Object v0_1 = ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).label;
        Object v4 = null;
        int v5 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            AwaitPointerEventScope v0_2 = arg17;
            Continuation v3_2 = v1;
            PointerEventPass v1_2 = arg18;
            goto label_43;
        label_27:
            Object v16 = v3_1;
            v3_2 = v1;
            Object v1_3 = v16;
            v0_3 = ((PointerEvent)v0_1).getChanges();
            v9 = v0_3.size();
            v10 = 0;
            while(true) {
                if(v10 >= v9) {
                    break;
                }
                else if(v0_3.get(v10).isConsumed()) {
                    return v4;
                }
                else {
                    ++v10;
                    continue;
                }

                goto label_55;
            }

            v0_1 = v8;
        label_43:
            ((TapGestureDetectorKt$waitForUpOrCancellation$2)v3_2).L$0 = v0_2;
            ((TapGestureDetectorKt$waitForUpOrCancellation$2)v3_2).L$1 = v1_2;
            ((TapGestureDetectorKt$waitForUpOrCancellation$2)v3_2).label = 1;
            v8 = v0_2.awaitPointerEvent(v1_2, v3_2);
            if(v8 == v2) {
                return v2;
            }
            else {
                v16 = v8;
                AwaitPointerEventScope v8_1 = v0_2;
                v0_1 = v16;
                Continuation v16_1 = v3_2;
                v3_1 = v1_2;
                v1 = v16_1;
                goto label_55;
                return v2;
            }
        }
        else if(v3 == 1) {
            v3_1 = ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).L$1;
            v8 = ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).L$0;
            ResultKt.throwOnFailure(v0_1);
        }
        else if(v3 == v5) {
            v3_1 = ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).L$1;
            v8 = ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).L$0;
            ResultKt.throwOnFailure(v0_1);
            goto label_27;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_55:
        List v9_1 = ((PointerEvent)v0_1).getChanges();
        v10 = v9_1.size();
        int v11;
        for(v11 = 0; v11 < v10; ++v11) {
            if(!PointerEventKt.changedToUp(v9_1.get(v11))) {
                v0_3 = ((PointerEvent)v0_1).getChanges();
                v9 = v0_3.size();
                v10 = 0;
                goto label_67;
            }
        }

        return ((PointerEvent)v0_1).getChanges().get(0);
        while(true) {
        label_67:
            if(v10 >= v9) {
                goto label_79;
            }

            Object v11_1 = v0_3.get(v10);
            if(!((PointerInputChange)v11_1).isConsumed()) {
                if(PointerEventKt.isOutOfBounds-jwHxaWs(((PointerInputChange)v11_1), ((AwaitPointerEventScope)v8).getSize-YbymL2g(), ((AwaitPointerEventScope)v8).getExtendedTouchPadding-NH-jbRc())) {
                }
                else {
                    ++v10;
                    continue;
                }
            }

            return v4;
        }

        return v4;
    label_79:
        PointerEventPass v0_4 = PointerEventPass.Final;
        ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).L$0 = v8;
        ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).L$1 = v3_1;
        ((TapGestureDetectorKt$waitForUpOrCancellation$2)v1).label = v5;
        v0_1 = ((AwaitPointerEventScope)v8).awaitPointerEvent(v0_4, v1);
        if(v0_1 != v2) {
            goto label_27;
        }

        return v2;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with PointerEventPass instead.") public static final Object waitForUpOrCancellation(AwaitPointerEventScope arg1, Continuation arg2) {
        return TapGestureDetectorKt.waitForUpOrCancellation(arg1, PointerEventPass.Main, arg2);
    }

    public static Object waitForUpOrCancellation$default(AwaitPointerEventScope arg0, PointerEventPass arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = PointerEventPass.Main;
        }

        return TapGestureDetectorKt.waitForUpOrCancellation(arg0, arg1, arg2);
    }
}

