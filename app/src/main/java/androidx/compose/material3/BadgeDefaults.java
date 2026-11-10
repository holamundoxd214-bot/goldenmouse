package androidx.compose.material3;

import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/BadgeDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BadgeDefaults {
    public static final int $stable;
    public static final BadgeDefaults INSTANCE;

    static {
        BadgeDefaults.INSTANCE = new BadgeDefaults();
    }

    private BadgeDefaults() {
        super();
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0xCC4468B7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)194@7644L5:Badge.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BadgeDefaults.<get-containerColor> (Badge.kt:194)");
        }

        long v0_1 = ColorSchemeKt.getValue(BadgeTokens.INSTANCE.getColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }
}

