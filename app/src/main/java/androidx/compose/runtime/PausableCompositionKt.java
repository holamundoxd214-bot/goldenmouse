package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001A\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"PausableComposition", "Landroidx/compose/runtime/PausableComposition;", "applier", "Landroidx/compose/runtime/Applier;", "parent", "Landroidx/compose/runtime/CompositionContext;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PausableCompositionKt {
    public static final PausableComposition PausableComposition(Applier arg1, CompositionContext arg2) {
        return new CompositionImpl(arg2, arg1);
    }
}

