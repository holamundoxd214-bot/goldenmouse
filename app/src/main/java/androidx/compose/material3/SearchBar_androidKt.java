package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"getWindowContainerHeight", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/runtime/Composer;I)F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SearchBar_androidKt {
    public static final float getWindowContainerHeight(Composer arg3, int arg4) {
        int v1 = 1909557323;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(getWindowContainerHeight)27@1060L7:SearchBar.android.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.getWindowContainerHeight (SearchBar.android.kt:27)");
        }

        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        float v4_2 = Dp.constructor-impl(((float)((Configuration)v4_1).screenHeightDp));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }
}

