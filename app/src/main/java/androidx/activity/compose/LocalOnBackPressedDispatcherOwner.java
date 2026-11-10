package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000B2\u0006\u0010\f\u001A\u00020\u0006H\u0086\u0004R\u0016\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u00068G¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Landroidx/activity/compose/LocalOnBackPressedDispatcherOwner;", "", "<init>", "()V", "LocalOnBackPressedDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcherOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "dispatcherOwner", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LocalOnBackPressedDispatcherOwner {
    public static final int $stable;
    public static final LocalOnBackPressedDispatcherOwner INSTANCE;
    private static final ProvidableCompositionLocal LocalOnBackPressedDispatcherOwner;

    static {
        LocalOnBackPressedDispatcherOwner.INSTANCE = new LocalOnBackPressedDispatcherOwner();
        LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner = CompositionLocalKt.compositionLocalOf$default(null, new LocalOnBackPressedDispatcherOwner$$ExternalSyntheticLambda0(), 1, null);
    }

    private LocalOnBackPressedDispatcherOwner() {
        super();
    }

    static final OnBackPressedDispatcherOwner LocalOnBackPressedDispatcherOwner$lambda$0() {
        return null;
    }

    public final OnBackPressedDispatcherOwner getCurrent(Composer arg3, int arg4) {
        Context v2_3;
        OnBackPressedDispatcherOwner v2_2;
        int v0 = -2068013981;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-current>)59@2607L7:BackHandler.kt#q1dkbc");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.activity.compose.LocalOnBackPressedDispatcherOwner.<get-current> (BackHandler.kt:59)");
        }

        ProvidableCompositionLocal v2 = LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner;
        arg4 = 0x789C5F52;
        String v0_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(v2_1 == null) {
            arg3.startReplaceGroup(0x48071EAD);
            ComposerKt.sourceInformation(arg3, "60@2644L7");
            v2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
            v2_1 = arg3.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            v2_2 = ViewTreeOnBackPressedDispatcherOwner.get(((View)v2_1));
        }
        else {
            arg3.startReplaceGroup(1208423708);
        }

        arg3.endReplaceGroup();
        if(v2_1 == null) {
            arg3.startReplaceGroup(0x48072680);
            ComposerKt.sourceInformation(arg3, "61@2767L7");
            v2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
            v2_1 = arg3.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            while(true) {
                if(!(v2_1 instanceof ContextWrapper)) {
                    break;
                }
                else if((v2_1 instanceof OnBackPressedDispatcherOwner)) {
                }
                else {
                    v2_3 = ((ContextWrapper)v2_3).getBaseContext();
                    continue;
                }

                goto label_48;
            }

            v2_2 = null;
        }
        else {
            arg3.startReplaceGroup(0x4807156D);
        }

    label_48:
        arg3.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((OnBackPressedDispatcherOwner)v2_3);
    }

    public final ProvidedValue provides(OnBackPressedDispatcherOwner arg1) {
        return LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner.provides(arg1);
    }
}

