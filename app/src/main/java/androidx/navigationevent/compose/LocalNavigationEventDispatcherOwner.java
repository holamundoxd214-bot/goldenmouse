package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000B2\u0006\u0010\f\u001A\u00020\u0006H\u0086\u0004R\u0016\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u00068G¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Landroidx/navigationevent/compose/LocalNavigationEventDispatcherOwner;", "", "<init>", "()V", "LocalNavigationEventDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/navigationevent/NavigationEventDispatcherOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "navigationEventDispatcherOwner", "navigationevent-compose"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LocalNavigationEventDispatcherOwner {
    public static final int $stable;
    public static final LocalNavigationEventDispatcherOwner INSTANCE;
    private static final ProvidableCompositionLocal LocalNavigationEventDispatcherOwner;

    static {
        LocalNavigationEventDispatcherOwner.INSTANCE = new LocalNavigationEventDispatcherOwner();
        LocalNavigationEventDispatcherOwner.LocalNavigationEventDispatcherOwner = CompositionLocalKt.compositionLocalOf$default(null, new LocalNavigationEventDispatcherOwner$$ExternalSyntheticLambda0(), 1, null);
    }

    private LocalNavigationEventDispatcherOwner() {
        super();
    }

    static final NavigationEventDispatcherOwner LocalNavigationEventDispatcherOwner$lambda$0() {
        return null;
    }

    public final NavigationEventDispatcherOwner getCurrent(Composer arg3, int arg4) {
        NavigationEventDispatcherOwner v2_2;
        int v0 = -942026292;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-current>)38@1631L7:LocalNavigationEventDispatcherOwner.kt#wc8b4r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner.<get-current> (LocalNavigationEventDispatcherOwner.kt:38)");
        }

        ProvidableCompositionLocal v2 = LocalNavigationEventDispatcherOwner.LocalNavigationEventDispatcherOwner;
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(v2_1 == null) {
            arg3.startReplaceGroup(950836184);
            ComposerKt.sourceInformation(arg3, "39@1658L44");
            v2_2 = LocalNavigationEventDispatcherOwner_androidKt.findViewTreeNavigationEventDispatcherOwner(arg3, 0);
            arg3.endReplaceGroup();
        }
        else {
            arg3.startReplaceGroup(950834231);
            arg3.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2_2;
    }

    public final ProvidedValue provides(NavigationEventDispatcherOwner arg1) {
        return LocalNavigationEventDispatcherOwner.LocalNavigationEventDispatcherOwner.provides(arg1);
    }
}

