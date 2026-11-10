package androidx.compose.foundation;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"_isSystemInDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DarkTheme_androidKt {
    public static final boolean _isSystemInDarkTheme(Composer arg3, int arg4) {
        int v1 = 0xCB645D0C;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(_isSystemInDarkTheme)46@2138L7:DarkTheme.android.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation._isSystemInDarkTheme (DarkTheme.android.kt:45)");
        }

        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        boolean v4_2 = (((Configuration)v4_1).uiMode & 0x30) == 0x20 ? true : false;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }
}

