package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\"\u001C\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"hasSelection", "", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "LocalSelectionRegistrar", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalSelectionRegistrar", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionRegistrarKt {
    private static final ProvidableCompositionLocal LocalSelectionRegistrar;

    static {
        SelectionRegistrarKt.LocalSelectionRegistrar = CompositionLocalKt.compositionLocalOf$default(null, new SelectionRegistrarKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final SelectionRegistrar LocalSelectionRegistrar$lambda$0() {
        return null;
    }

    public static final ProvidableCompositionLocal getLocalSelectionRegistrar() {
        return SelectionRegistrarKt.LocalSelectionRegistrar;
    }

    public static final boolean hasSelection(SelectionRegistrar arg0, long arg1) {
        if(arg0 != null) {
            LongObjectMap v0 = arg0.getSubselections();
            if(v0 != null) {
                return v0.containsKey(arg1);
            }
        }

        return 0;
    }
}

