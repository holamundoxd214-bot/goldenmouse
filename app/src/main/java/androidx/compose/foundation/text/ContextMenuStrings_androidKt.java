package androidx.compose.foundation.text;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0017\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"getString", "", "string", "Landroidx/compose/foundation/text/ContextMenuStrings;", "getString-tk4Tqcs", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuStrings_androidKt {
    public static final String getString-tk4Tqcs(int arg3, Composer arg4, int arg5) {
        int v1 = -2083411200;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(getString)N(string:c#foundation.text.ContextMenuStrings)56@1981L7:ContextMenuStrings.android.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.text.getString (ContextMenuStrings.android.kt:55)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        String v3 = ((Resources)v5_1).getString(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }
}

