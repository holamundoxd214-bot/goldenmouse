package androidx.compose.material3;

import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/material3/DividerDefaults;", "", "<init>", "()V", "Thickness", "Landroidx/compose/ui/unit/Dp;", "getThickness-D9Ej5fM", "()F", "F", "color", "Landroidx/compose/ui/graphics/Color;", "getColor", "(Landroidx/compose/runtime/Composer;I)J", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DividerDefaults {
    public static final int $stable;
    public static final DividerDefaults INSTANCE;
    private static final float Thickness;

    static {
        DividerDefaults.INSTANCE = new DividerDefaults();
        DividerDefaults.Thickness = DividerTokens.INSTANCE.getThickness-D9Ej5fM();
    }

    private DividerDefaults() {
        super();
    }

    public final long getColor(Composer arg3, int arg4) {
        int v0 = 0x49DF631;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-color>)116@4088L5:Divider.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DividerDefaults.<get-color> (Divider.kt:116)");
        }

        long v0_1 = ColorSchemeKt.getValue(DividerTokens.INSTANCE.getColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getThickness-D9Ej5fM() {
        return DividerDefaults.Thickness;
    }
}

