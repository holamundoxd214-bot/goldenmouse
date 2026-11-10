package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "Landroidx/compose/runtime/Recomposer;", "observer", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "setObserver", "Landroidx/compose/runtime/Composition;", "Landroidx/compose/runtime/tooling/CompositionObserver;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionObserverKt {
    public static final CompositionObserverHandle observe(Recomposer arg0, CompositionRegistrationObserver arg1) {
        return arg0.addCompositionRegistrationObserver$runtime(arg1);
    }

    public static final CompositionObserverHandle setObserver(Composition arg1, CompositionObserver arg2) {
        Object v1 = CompositionKt.getCompositionService(arg1, CompositionKt.getObservableCompositionServiceKey());
        if(v1 != null) {
            return ((ObservableComposition)v1).setObserver(arg2);
        }

        return null;
    }
}

