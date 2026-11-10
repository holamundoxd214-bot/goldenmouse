package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/material3/Locale24;", "", "<init>", "()V", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class Locale24 {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/Locale24$Companion;", "", "<init>", "()V", "defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Locale defaultLocale(Composer arg3, int arg4) {
            int v0 = 0x12EE00F1;
            ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(defaultLocale)44@1519L7:CalendarLocale.android.kt#uh7d8r");
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.Locale24.Companion.defaultLocale (CalendarLocale.android.kt:43)");
            }

            ProvidableCompositionLocal v2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_1 = arg3.consume(((CompositionLocal)v2));
            ComposerKt.sourceInformationMarkerEnd(arg3);
            Locale v2_2 = ((Configuration)v2_1).getLocales().get(0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(arg3);
            return v2_2;
        }
    }

    public static final Companion Companion;

    static {
        Locale24.Companion = new Companion(null);
    }

    public Locale24() {
        super();
    }
}

