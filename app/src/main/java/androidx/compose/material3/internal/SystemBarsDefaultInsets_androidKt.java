package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.WindowInsets$Companion;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"systemBarsForVisualComponents", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getSystemBarsForVisualComponents", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SystemBarsDefaultInsets_androidKt {
    public static final WindowInsets getSystemBarsForVisualComponents(Companion arg3, Composer arg4, int arg5) {
        int v1 = 2011811170;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-systemBarsForVisualComponents>)25@1029L10,25@1046L13:SystemBarsDefaultInsets.android.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.internal.<get-systemBarsForVisualComponents> (SystemBarsDefaultInsets.android.kt:25)");
        }

        arg5 &= 14;
        WindowInsets v3 = WindowInsetsKt.union(WindowInsets_androidKt.getSystemBars(arg3, arg4, arg5), WindowInsets_androidKt.getDisplayCutout(arg3, arg4, arg5));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }
}

