package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A-\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001A?\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001A\u0002H\u00072\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\n\u001A1\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\b\u0010\f\u001A\u0004\u0018\u00010\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000FH\u0002¢\u0006\u0002\b\u0010\u001A \u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000F\u001A*\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0012\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000FH\u0007¨\u0006\u0013"}, d2={"collectAsState", "Landroidx/compose/runtime/State;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "R", "Lkotlinx/coroutines/flow/Flow;", "initial", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "snapshotFlowImpl", "externalManager", "Landroidx/compose/runtime/SnapshotFlowManager;", "block", "Lkotlin/Function0;", "snapshotFlowImpl$SnapshotStateKt__SnapshotFlowKt", "snapshotFlow", "manager", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/SnapshotStateKt") final class SnapshotStateKt__SnapshotFlowKt {
    public static final State collectAsState(Flow arg8, Object arg9, CoroutineContext arg10, Composer arg11, int arg12, int arg13) {
        EmptyCoroutineContext v10;
        int v1 = -606625098;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(collectAsState)N(initial,context)69@2795L153,69@2758L190:SnapshotFlow.kt#9igjgp");
        if((arg13 & 2) != 0) {
            v10 = EmptyCoroutineContext.INSTANCE;
        }

        CoroutineContext v4 = ((CoroutineContext)v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:69)");
        }

        ComposerKt.sourceInformationMarkerStart(arg11, 0x4479E26F, "CC(remember):SnapshotFlow.kt#9igjgp");
        int v10_1 = arg11.changedInstance(v4) | arg11.changedInstance(arg8);
        Object v13 = arg11.rememberedValue();
        if(v10_1 != 0 || v13 == Composer.Companion.getEmpty()) {
            SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1 v13_1 = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(v4, arg8, null);
            arg11.updateRememberedValue(v13_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        Composer v6 = arg11;
        State v8 = SnapshotStateKt.produceState(arg9, arg8, v4, v13, v6, arg12 >> 3 & 14 | arg12 << 3 & 0x70 | arg12 & 0x380);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return v8;
    }

    public static final State collectAsState(StateFlow arg8, CoroutineContext arg9, Composer arg10, int arg11, int arg12) {
        EmptyCoroutineContext v9;
        int v1 = 0xAA2D1D71;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(collectAsState)N(context)53@2117L30:SnapshotFlow.kt#9igjgp");
        if((arg12 & 1) != 0) {
            v9 = EmptyCoroutineContext.INSTANCE;
        }

        CoroutineContext v4 = ((CoroutineContext)v9);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:53)");
        }

        Composer v5 = arg10;
        State v8 = SnapshotStateKt.collectAsState(arg8, arg8.getValue(), v4, v5, arg11 & 14 | arg11 << 3 & 0x380, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8;
    }

    public static final Flow snapshotFlow(SnapshotFlowManager arg0, Function0 arg1) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlowImpl$SnapshotStateKt__SnapshotFlowKt(arg0, arg1);
    }

    public static final Flow snapshotFlow(Function0 arg1) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlowImpl$SnapshotStateKt__SnapshotFlowKt(null, arg1);
    }

    private static final Flow snapshotFlowImpl$SnapshotStateKt__SnapshotFlowKt(SnapshotFlowManager arg2, Function0 arg3) {
        return FlowKt.flow(new SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1(arg2, arg3, null));
    }
}

