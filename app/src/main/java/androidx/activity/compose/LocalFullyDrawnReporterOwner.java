package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.activity.ViewTreeFullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000B2\u0006\u0010\f\u001A\u00020\u0006H\u0086\u0004R\u0016\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u00068G¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Landroidx/activity/compose/LocalFullyDrawnReporterOwner;", "", "<init>", "()V", "LocalFullyDrawnReporterOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/FullyDrawnReporterOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/FullyDrawnReporterOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "fullyDrawnReporterOwner", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LocalFullyDrawnReporterOwner {
    public static final int $stable;
    public static final LocalFullyDrawnReporterOwner INSTANCE;
    private static final ProvidableCompositionLocal LocalFullyDrawnReporterOwner;

    static {
        LocalFullyDrawnReporterOwner.INSTANCE = new LocalFullyDrawnReporterOwner();
        LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner = CompositionLocalKt.compositionLocalOf$default(null, new LocalFullyDrawnReporterOwner$$ExternalSyntheticLambda0(), 1, null);
    }

    private LocalFullyDrawnReporterOwner() {
        super();
    }

    static final FullyDrawnReporterOwner LocalFullyDrawnReporterOwner$lambda$0() {
        return null;
    }

    public final FullyDrawnReporterOwner getCurrent(Composer arg3, int arg4) {
        Context v2_3;
        FullyDrawnReporterOwner v2_2;
        int v0 = 0x20329958;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-current>)95@3564L7:ReportDrawn.kt#q1dkbc");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.activity.compose.LocalFullyDrawnReporterOwner.<get-current> (ReportDrawn.kt:95)");
        }

        ProvidableCompositionLocal v2 = LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner;
        arg4 = 0x789C5F52;
        String v0_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(v2_1 == null) {
            arg3.startReplaceGroup(0xDDF1B1BD);
            ComposerKt.sourceInformation(arg3, "96@3601L7");
            v2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
            v2_1 = arg3.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            v2_2 = ViewTreeFullyDrawnReporterOwner.get(((View)v2_1));
        }
        else {
            arg3.startReplaceGroup(0xDDF1A8C7);
        }

        arg3.endReplaceGroup();
        if(v2_2 == null) {
            arg3.startReplaceGroup(0xDDF1B8F0);
            ComposerKt.sourceInformation(arg3, "97@3714L7");
            v2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
            v2_1 = arg3.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            while(true) {
                if(!(v2_1 instanceof ContextWrapper)) {
                    break;
                }
                else if((v2_1 instanceof FullyDrawnReporterOwner)) {
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
            arg3.startReplaceGroup(0xDDF1A913);
        }

    label_48:
        arg3.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((FullyDrawnReporterOwner)v2_3);
    }

    public final ProvidedValue provides(FullyDrawnReporterOwner arg1) {
        return LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner.provides(arg1);
    }
}

