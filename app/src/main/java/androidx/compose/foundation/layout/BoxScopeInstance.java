package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0017J\f\u0010\b\u001A\u00020\u0005*\u00020\u0005H\u0017¨\u0006\t"}, d2={"Landroidx/compose/foundation/layout/BoxScopeInstance;", "Landroidx/compose/foundation/layout/BoxScope;", "<init>", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BoxScopeInstance implements BoxScope {
    public static final int $stable;
    public static final BoxScopeInstance INSTANCE;

    static {
        BoxScopeInstance.INSTANCE = new BoxScopeInstance();
    }

    private BoxScopeInstance() {
        super();
    }

    public Modifier align(Modifier arg3, Alignment arg4) {
        BoxScopeInstance$align$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new BoxScopeInstance$align$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new BoxChildDataElement(arg4, false, ((Function1)v0)));
    }

    public Modifier matchParentSize(Modifier arg4) {
        BoxScopeInstance$matchParentSize$$inlined$debugInspectorInfo$1 v1;
        Alignment v0 = Alignment.Companion.getCenter();
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new BoxScopeInstance$matchParentSize$$inlined$debugInspectorInfo$1();
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg4.then(new BoxChildDataElement(v0, true, ((Function1)v1)));
    }
}

