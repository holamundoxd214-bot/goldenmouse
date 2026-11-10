package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AA\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001A?\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\r\u001AI\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\u0010\u001AG\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\u00022\u0006\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"collectAsStateWithLifecycle", "Landroidx/compose/runtime/State;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/Flow;", "initialValue", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FlowExtKt {
    public static final State collectAsStateWithLifecycle(Flow arg8, Object arg9, Lifecycle arg10, androidx.lifecycle.Lifecycle$State arg11, CoroutineContext arg12, Composer arg13, int arg14, int arg15) {
        EmptyCoroutineContext v12;
        int v1 = 0x75E27F00;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(collectAsStateWithLifecycle)N(initialValue,lifecycle,minActiveState,context)175@7721L383,175@7652L452:FlowExt.kt#2vxrgp");
        if((arg15 & 4) != 0) {
            arg11 = androidx.lifecycle.Lifecycle$State.STARTED;
        }

        androidx.lifecycle.Lifecycle$State v4 = arg11;
        if((arg15 & 8) != 0) {
            v12 = EmptyCoroutineContext.INSTANCE;
        }

        CoroutineContext v5 = ((CoroutineContext)v12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:174)");
        }

        Object[] v11 = new Object[]{arg8, arg10, v4, v5};
        ComposerKt.sourceInformationMarkerStart(arg13, -2025920897, "CC(remember):FlowExt.kt#9igjgp");
        boolean v12_1 = arg13.changedInstance(arg10);
        int v0 = 0x800;
        arg15 = (arg14 & 0x1C00 ^ 0xC00) > v0 && (arg13.changed(v4.ordinal())) || (arg14 & 0xC00) == v0 ? 1 : 0;
        int v12_2 = (((int)v12_1)) | arg15 | arg13.changedInstance(v5) | arg13.changedInstance(arg8);
        Object v15 = arg13.rememberedValue();
        if(v12_2 != 0 || v15 == Composer.Companion.getEmpty()) {
            FlowExtKt$collectAsStateWithLifecycle$1$1 v15_1 = new FlowExtKt$collectAsStateWithLifecycle$1$1(arg10, v4, v5, arg8, null);
            arg13.updateRememberedValue(v15_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        State v8 = SnapshotStateKt.produceState(arg9, v11, ((Function2)v15), arg13, arg14 >> 3 & 14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        return v8;
    }

    public static final State collectAsStateWithLifecycle(Flow arg8, Object arg9, LifecycleOwner arg10, androidx.lifecycle.Lifecycle$State arg11, CoroutineContext arg12, Composer arg13, int arg14, int arg15) {
        CoroutineContext v4_1;
        LifecycleOwner v1_2;
        int v2 = 0xA76D7B65;
        ComposerKt.sourceInformationMarkerStart(arg13, v2, "C(collectAsStateWithLifecycle)N(initialValue,lifecycleOwner,minActiveState,context)134@5915L7,138@6060L185:FlowExt.kt#2vxrgp");
        if((arg15 & 2) != 0) {
            ProvidableCompositionLocal v1 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(arg13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v1_1 = arg13.consume(((CompositionLocal)v1));
            ComposerKt.sourceInformationMarkerEnd(arg13);
        }
        else {
            v1_2 = arg10;
        }

        androidx.lifecycle.Lifecycle$State v3 = (arg15 & 4) != 0 ? androidx.lifecycle.Lifecycle$State.STARTED : arg11;
        if((arg15 & 8) != 0) {
            EmptyCoroutineContext v4 = EmptyCoroutineContext.INSTANCE;
        }
        else {
            v4_1 = arg12;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg14, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:138)");
        }

        State v0 = FlowExtKt.collectAsStateWithLifecycle(arg8, arg9, v1_2.getLifecycle(), v3, v4_1, arg13, arg14 & 14 | (arg14 >> 3 & 8) << 3 | arg14 & 0x70 | arg14 & 0x1C00 | arg14 & 0xE000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        return v0;
    }

    public static final State collectAsStateWithLifecycle(StateFlow arg11, Lifecycle arg12, androidx.lifecycle.Lifecycle$State arg13, CoroutineContext arg14, Composer arg15, int arg16, int arg17) {
        EmptyCoroutineContext v14;
        int v0 = arg16;
        int v2 = 0x913EB1ED;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(collectAsStateWithLifecycle)N(lifecycle,minActiveState,context)99@4354L168:FlowExt.kt#2vxrgp");
        if((arg17 & 2) != 0) {
            arg13 = androidx.lifecycle.Lifecycle$State.STARTED;
        }

        androidx.lifecycle.Lifecycle$State v6 = arg13;
        if((arg17 & 4) != 0) {
            v14 = EmptyCoroutineContext.INSTANCE;
        }

        CoroutineContext v7 = ((CoroutineContext)v14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:99)");
        }

        int v13 = v0 << 3;
        State v11 = FlowExtKt.collectAsStateWithLifecycle(arg11, arg11.getValue(), arg12, v6, v7, arg15, v0 & 14 | v13 & 0x380 | v13 & 0x1C00 | v13 & 0xE000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return v11;
    }

    public static final State collectAsStateWithLifecycle(StateFlow arg9, LifecycleOwner arg10, androidx.lifecycle.Lifecycle$State arg11, CoroutineContext arg12, Composer arg13, int arg14, int arg15) {
        CoroutineContext v4_1;
        Object v1_1;
        int v2 = 743249048;
        ComposerKt.sourceInformationMarkerStart(arg13, v2, "C(collectAsStateWithLifecycle)N(lifecycleOwner,minActiveState,context)58@2561L7,62@2706L183:FlowExt.kt#2vxrgp");
        if((arg15 & 1) != 0) {
            ProvidableCompositionLocal v1 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(arg13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v1_1 = arg13.consume(((CompositionLocal)v1));
            ComposerKt.sourceInformationMarkerEnd(arg13);
        }
        else {
            LifecycleOwner v1_2 = arg10;
        }

        androidx.lifecycle.Lifecycle$State v3 = (arg15 & 2) != 0 ? androidx.lifecycle.Lifecycle$State.STARTED : arg11;
        if((arg15 & 4) != 0) {
            EmptyCoroutineContext v4 = EmptyCoroutineContext.INSTANCE;
        }
        else {
            v4_1 = arg12;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg14, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:62)");
        }

        int v7 = arg14 << 3;
        State v0 = FlowExtKt.collectAsStateWithLifecycle(arg9, arg9.getValue(), ((LifecycleOwner)v1_1).getLifecycle(), v3, v4_1, arg13, arg14 & 14 | v7 & 0x1C00 | v7 & 0xE000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        return v0;
    }
}

