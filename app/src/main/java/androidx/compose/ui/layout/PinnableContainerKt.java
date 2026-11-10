package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalPinnableContainer", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/layout/PinnableContainer;", "getLocalPinnableContainer", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PinnableContainerKt {
    private static final ProvidableCompositionLocal LocalPinnableContainer;

    static {
        PinnableContainerKt.LocalPinnableContainer = CompositionLocalKt.compositionLocalOf$default(null, PinnableContainerKt$LocalPinnableContainer$1.INSTANCE, 1, null);
    }

    public static final ProvidableCompositionLocal getLocalPinnableContainer() {
        return PinnableContainerKt.LocalPinnableContainer;
    }
}

