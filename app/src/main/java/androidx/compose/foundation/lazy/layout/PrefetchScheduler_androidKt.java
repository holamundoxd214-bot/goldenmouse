package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.foundation.R$id;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0004\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\"\u001A\u0010\u0003\u001A\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0007\u0012\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2={"rememberDefaultPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "RobolectricImpl", "androidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1", "getRobolectricImpl$annotations", "()V", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PrefetchScheduler_androidKt {
    private static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl;

    static {
        PrefetchScheduler_androidKt$RobolectricImpl$1 v0_1;
        if(Build.FINGERPRINT != null) {
            String v0 = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v0, "toLowerCase(...)");
            if(Intrinsics.areEqual(v0, "robolectric")) {
                v0_1 = new PrefetchScheduler_androidKt$RobolectricImpl$1();
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v0_1 = null;
        }

        PrefetchScheduler_androidKt.RobolectricImpl = v0_1;
    }

    private static void getRobolectricImpl$annotations() {
    }

    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(Composer arg3, int arg4) {
        int v1 = 0x440F9293;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberDefaultPrefetchScheduler):PrefetchScheduler.android.kt#wow0x6");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:36)");
        }

        PrefetchScheduler_androidKt$RobolectricImpl$1 v4 = PrefetchScheduler_androidKt.RobolectricImpl;
        if(v4 != null) {
            arg3.startReplaceGroup(0x503387D0);
            arg3.endReplaceGroup();
        }
        else {
            arg3.startReplaceGroup(0x50344781);
            ComposerKt.sourceInformation(arg3, "40@1441L7,41@1457L377");
            ProvidableCompositionLocal v4_1 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_2 = arg3.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            ComposerKt.sourceInformationMarkerStart(arg3, 0x7E75524C, "CC(remember):PrefetchScheduler.android.kt#9igjgp");
            boolean v0 = arg3.changed(v4_2);
            Object v1_1 = arg3.rememberedValue();
            if((v0) || v1_1 == Composer.Companion.getEmpty()) {
                Object v0_1 = ((View)v4_2).getTag(id.compose_prefetch_scheduler);
                if((v0_1 instanceof PrefetchScheduler)) {
                }
                else {
                    v0_1 = null;
                }

                if(v0_1 == null) {
                    AndroidPrefetchScheduler v0_2 = new AndroidPrefetchScheduler(((View)v4_2));
                    ((View)v4_2).setTag(id.compose_prefetch_scheduler, v0_2);
                }

                v1_1 = v0_1;
                arg3.updateRememberedValue(v1_1);
            }

            v4_2 = v1_1;
            ComposerKt.sourceInformationMarkerEnd(arg3);
            arg3.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((PrefetchScheduler)v4);
    }
}

