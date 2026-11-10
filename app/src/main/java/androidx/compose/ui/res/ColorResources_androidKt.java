package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"colorResource", "Landroidx/compose/ui/graphics/Color;", "id", "", "(ILandroidx/compose/runtime/Composer;I)J", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ColorResources_androidKt {
    public static final long colorResource(int arg3, Composer arg4, int arg5) {
        int v1 = 0x960B4AB7;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colorResource)35@1205L7,36@1270L7:ColorResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.colorResource (ColorResources.android.kt:34)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        ProvidableCompositionLocal v2 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0 = arg4.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        long v0_1 = ColorKt.Color(ResourcesCompat.getColor(((Resources)v0), arg3, ((Context)v5_1).getTheme()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v0_1;
    }
}

