package androidx.compose.runtime.tooling;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2={"findCompositionInstance", "Landroidx/compose/runtime/tooling/CompositionInstance;", "Landroidx/compose/runtime/tooling/CompositionData;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionDataKt {
    public static final CompositionInstance findCompositionInstance(CompositionData arg1) {
        if((arg1 instanceof CompositionInstance)) {
            return arg1;
        }

        return null;
    }
}

