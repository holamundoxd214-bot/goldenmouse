package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.PausableComposition;
import androidx.compose.runtime.PausableCompositionKt;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\b"}, d2={"createSubcomposition", "Landroidx/compose/runtime/ReusableComposition;", "container", "Landroidx/compose/ui/node/LayoutNode;", "parent", "Landroidx/compose/runtime/CompositionContext;", "createPausableSubcomposition", "Landroidx/compose/runtime/PausableComposition;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SubcompositionKt {
    public static final PausableComposition createPausableSubcomposition(LayoutNode arg0, CompositionContext arg1) {
        return PausableCompositionKt.PausableComposition(Wrapper_androidKt.createApplier(arg0), arg1);
    }

    public static final ReusableComposition createSubcomposition(LayoutNode arg0, CompositionContext arg1) {
        return CompositionKt.ReusableComposition(Wrapper_androidKt.createApplier(arg0), arg1);
    }
}

