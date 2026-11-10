package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"currentStateAsState", "Landroidx/compose/runtime/State;", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LifecycleExtKt {
    public static final State currentStateAsState(Lifecycle arg3, Composer arg4, int arg5) {
        int v1 = 0x8F34EB00;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(currentStateAsState)32@1284L16:LifecycleExt.kt#2vxrgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.lifecycle.compose.currentStateAsState (LifecycleExt.kt:32)");
        }

        State v3 = SnapshotStateKt.collectAsState(arg3.getCurrentStateFlow(), null, arg4, 0, 1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }
}

