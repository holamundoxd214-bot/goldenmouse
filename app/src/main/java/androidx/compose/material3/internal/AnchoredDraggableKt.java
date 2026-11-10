package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A7\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001D\u0010\u0004\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0000\u001AH\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0000\u001A&\u0010\u0014\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0015\u001A\u0002H\u0002H\u0080@¢\u0006\u0002\u0010\u0016\u001A0\u0010\u0017\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0015\u001A\u0002H\u00022\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u0080@¢\u0006\u0002\u0010\u001A\u001AF\u0010\u001B\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u001C2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u001C0\u001E2\"\u0010\u001F\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070!\u0012\u0006\u0012\u0004\u0018\u00010\u00030 H\u0082@¢\u0006\u0002\u0010\"\u001A\u0014\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020$\"\u0004\b\u0000\u0010\u0002H\u0002\u001Ar\u0010%\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2H\u0010&\u001AD\u0012\u0013\u0012\u00110\'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u0002H\u00020-0 H\u0000¨\u0006."}, d2={"DraggableAnchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "T", "", "builder", "Lkotlin/Function1;", "Landroidx/compose/material3/internal/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "snapTo", "targetValue", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restartable", "I", "inputs", "Lkotlin/Function0;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/material3/internal/MapDraggableAnchors;", "draggableAnchors", "anchors", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnchoredDraggableKt {
    public static final DraggableAnchors DraggableAnchors(Function1 arg2) {
        DraggableAnchorsConfig v1 = new DraggableAnchorsConfig();
        arg2.invoke(v1);
        return new MapDraggableAnchors(v1.getAnchors$material3());
    }

    public static final MapDraggableAnchors access$emptyDraggableAnchors() {
        return AnchoredDraggableKt.emptyDraggableAnchors();
    }

    public static final Object access$restartable(Function0 arg0, Function2 arg1, Continuation arg2) {
        return AnchoredDraggableKt.restartable(arg0, arg1, arg2);
    }

    public static final Modifier anchoredDraggable(Modifier arg11, AnchoredDraggableState arg12, Orientation arg13, boolean arg14, boolean arg15, MutableInteractionSource arg16) {
        return DraggableKt.draggable$default(arg11, arg12.getDraggableState$material3(), arg13, arg14, arg16, arg12.isAnimationRunning(), null, new AnchoredDraggableKt$anchoredDraggable$1(arg12, null), arg15, 0x20, null);
    }

    public static Modifier anchoredDraggable$default(Modifier arg6, AnchoredDraggableState arg7, Orientation arg8, boolean arg9, boolean arg10, MutableInteractionSource arg11, int arg12, Object arg13) {
        if((arg12 & 16) != 0) {
            arg11 = null;
        }

        return AnchoredDraggableKt.anchoredDraggable(arg6, arg7, arg8, true, false, arg11);
    }

    public static final Object animateTo(AnchoredDraggableState arg9, Object arg10, float arg11, Continuation arg12) {
        Object v9 = AnchoredDraggableState.anchoredDrag$default(arg9, arg10, null, new AnchoredDraggableKt$animateTo$2(arg9, arg11, null), arg12, 2, null);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }

    public static Object animateTo$default(AnchoredDraggableState arg0, Object arg1, float arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.getLastVelocity();
        }

        return AnchoredDraggableKt.animateTo(arg0, arg1, arg2, arg3);
    }

    public static final Modifier draggableAnchors(Modifier arg1, AnchoredDraggableState arg2, Orientation arg3, Function2 arg4) {
        return arg1.then(new DraggableAnchorsElement(arg2, arg4, arg3));
    }

    private static final MapDraggableAnchors emptyDraggableAnchors() {
        return new MapDraggableAnchors(MapsKt.emptyMap());
    }

    private static final Object restartable(Function0 arg4, Function2 arg5, Continuation arg6) {
        AnchoredDraggableKt$restartable$1 v0_1;
        int v2;
        if((arg6 instanceof AnchoredDraggableKt$restartable$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((AnchoredDraggableKt$restartable$1)v0).label & v2) != 0) {
                ((AnchoredDraggableKt$restartable$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AnchoredDraggableKt$restartable$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            try {
                AnchoredDraggableKt$restartable$2 v6_1 = new AnchoredDraggableKt$restartable$2(arg4, arg5, null);
                v0_1.label = 1;
                if(CoroutineScopeKt.coroutineScope(((Function2)v6_1), ((Continuation)v0_1)) == v1) {
                    return v1;
                }
            }
            catch(AnchoredDragFinishedSignal ) {
            }

            goto label_33;
            return v1;
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(AnchoredDragFinishedSignal ) {
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        return Unit.INSTANCE;
    }

    public static final Object snapTo(AnchoredDraggableState arg9, Object arg10, Continuation arg11) {
        Object v9 = AnchoredDraggableState.anchoredDrag$default(arg9, arg10, null, new AnchoredDraggableKt$snapTo$2(null), arg11, 2, null);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }
}

