package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"isSystemInDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DarkThemeKt {
    public static final boolean isSystemInDarkTheme(Composer arg3, int arg4) {
        int v1 = -1100791446;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(isSystemInDarkTheme)36@1634L22:DarkTheme.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.isSystemInDarkTheme (DarkTheme.kt:36)");
        }

        boolean v4 = DarkTheme_androidKt._isSystemInDarkTheme(arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }
}

