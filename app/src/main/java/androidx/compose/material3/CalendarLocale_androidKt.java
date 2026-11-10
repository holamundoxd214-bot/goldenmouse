package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0011\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2={"defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CalendarLocale_androidKt {
    public static final Locale defaultLocale(Composer arg3, int arg4) {
        int v1 = 0x9FE5D8A9;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(defaultLocale):CalendarLocale.android.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.defaultLocale (CalendarLocale.android.kt:30)");
        }

        arg3.startReplaceGroup(0x7C7ADBF1);
        ComposerKt.sourceInformation(arg3, "32@1187L15");
        Locale v4 = Locale24.Companion.defaultLocale(arg3, 6);
        arg3.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }
}

