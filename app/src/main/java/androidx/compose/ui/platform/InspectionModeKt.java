package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalInspectionMode", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalInspectionMode", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InspectionModeKt {
    private static final ProvidableCompositionLocal LocalInspectionMode;

    static {
        InspectionModeKt.LocalInspectionMode = CompositionLocalKt.staticCompositionLocalOf(InspectionModeKt$LocalInspectionMode$1.INSTANCE);
    }

    public static final ProvidableCompositionLocal getLocalInspectionMode() {
        return InspectionModeKt.LocalInspectionMode;
    }
}

