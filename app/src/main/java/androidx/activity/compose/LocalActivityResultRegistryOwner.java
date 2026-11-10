package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000B2\u0006\u0010\f\u001A\u00020\u0006H\u0086\u0004R\u0016\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u00068G¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Landroidx/activity/compose/LocalActivityResultRegistryOwner;", "", "<init>", "()V", "LocalComposition", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/result/ActivityResultRegistryOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/result/ActivityResultRegistryOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "registryOwner", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LocalActivityResultRegistryOwner {
    public static final int $stable;
    public static final LocalActivityResultRegistryOwner INSTANCE;
    private static final ProvidableCompositionLocal LocalComposition;

    static {
        LocalActivityResultRegistryOwner.INSTANCE = new LocalActivityResultRegistryOwner();
        LocalActivityResultRegistryOwner.LocalComposition = CompositionLocalKt.compositionLocalOf$default(null, new LocalActivityResultRegistryOwner$$ExternalSyntheticLambda0(), 1, null);
    }

    private LocalActivityResultRegistryOwner() {
        super();
    }

    static final ActivityResultRegistryOwner LocalComposition$lambda$0() {
        return null;
    }

    public final ActivityResultRegistryOwner getCurrent(Composer arg3, int arg4) {
        ActivityResultRegistryOwner v2_3;
        int v0 = 1418020823;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-current>)48@1959L7:ActivityResultRegistry.kt#q1dkbc");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.activity.compose.LocalActivityResultRegistryOwner.<get-current> (ActivityResultRegistry.kt:48)");
        }

        ProvidableCompositionLocal v2 = LocalActivityResultRegistryOwner.LocalComposition;
        arg4 = 0x789C5F52;
        String v0_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(v2_1 == null) {
            arg3.startReplaceGroup(1213380307);
            ComposerKt.sourceInformation(arg3, "48@2022L7");
            v2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(arg3, arg4, v0_1);
            v2_1 = arg3.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            while(true) {
                if(!(v2_1 instanceof ContextWrapper)) {
                    break;
                }
                else if((v2_1 instanceof ActivityResultRegistryOwner)) {
                }
                else {
                    Context v2_2 = ((ContextWrapper)v2_1).getBaseContext();
                    continue;
                }

                goto label_34;
            }

            v2_3 = null;
        }
        else {
            arg3.startReplaceGroup(0x4852B36F);
        }

    label_34:
        arg3.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2_3;
    }

    public final ProvidedValue provides(ActivityResultRegistryOwner arg1) {
        return LocalActivityResultRegistryOwner.LocalComposition.provides(arg1);
    }
}

