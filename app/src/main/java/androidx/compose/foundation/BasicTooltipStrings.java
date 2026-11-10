package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2={"Landroidx/compose/foundation/BasicTooltipStrings;", "", "<init>", "()V", "label", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "description", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BasicTooltipStrings {
    public static final int $stable;
    public static final BasicTooltipStrings INSTANCE;

    static {
        BasicTooltipStrings.INSTANCE = new BasicTooltipStrings();
    }

    private BasicTooltipStrings() {
        super();
    }

    public final String description(Composer arg3, int arg4) {
        int v0 = 0x54701D72;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(description)26@1017L44:BasicTooltip.android.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.BasicTooltipStrings.description (BasicTooltip.android.kt:26)");
        }

        String v2 = StringResources_androidKt.stringResource(string.tooltip_description, arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final String label(Composer arg3, int arg4) {
        int v0 = 0xB29E5FA;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(label)24@926L38:BasicTooltip.android.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.BasicTooltipStrings.label (BasicTooltip.android.kt:24)");
        }

        String v2 = StringResources_androidKt.stringResource(string.tooltip_label, arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

