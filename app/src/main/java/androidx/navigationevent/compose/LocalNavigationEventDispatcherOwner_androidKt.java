package androidx.navigationevent.compose;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.ViewTreeNavigationEventDispatcherOwner;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u000F\u0010\u0000\u001A\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"findViewTreeNavigationEventDispatcherOwner", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "(Landroidx/compose/runtime/Composer;I)Landroidx/navigationevent/NavigationEventDispatcherOwner;", "navigationevent-compose"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LocalNavigationEventDispatcherOwner_androidKt {
    public static final NavigationEventDispatcherOwner findViewTreeNavigationEventDispatcherOwner(Composer arg3, int arg4) {
        int v1 = 0xEC0A60C5;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(findViewTreeNavigationEventDispatcherOwner)25@1013L7:LocalNavigationEventDispatcherOwner.android.kt#wc8b4r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.navigationevent.compose.findViewTreeNavigationEventDispatcherOwner (LocalNavigationEventDispatcherOwner.android.kt:25)");
        }

        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        NavigationEventDispatcherOwner v4_2 = ViewTreeNavigationEventDispatcherOwner.get(((View)v4_1));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }
}

