package androidx.compose.material.ripple;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0004\u001A\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\tH\u0017¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"Landroidx/compose/material/ripple/DebugRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "<init>", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) final class DebugRippleTheme implements RippleTheme {
    public static final DebugRippleTheme INSTANCE;

    static {
        DebugRippleTheme.INSTANCE = new DebugRippleTheme();
    }

    private DebugRippleTheme() {
        super();
    }

    @Deprecated(message="Super method is deprecated") public long defaultColor-WaAFU9c(Composer arg3, int arg4) {
        int v2 = 2042140174;
        arg3.startReplaceGroup(v2);
        ComposerKt.sourceInformation(arg3, "C(defaultColor):RippleTheme.kt#vhb33q");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg4, -1, "androidx.compose.material.ripple.DebugRippleTheme.defaultColor (RippleTheme.kt:237)");
        }

        long v0 = RippleTheme.Companion.defaultRippleColor-5vOe2sY(Color.Companion.getBlack-0d7_KjU(), true);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg3.endReplaceGroup();
        return v0;
    }

    @Deprecated(message="Super method is deprecated") public RippleAlpha rippleAlpha(Composer arg3, int arg4) {
        int v2 = 0x9EDAF9E9;
        arg3.startReplaceGroup(v2);
        ComposerKt.sourceInformation(arg3, "C(rippleAlpha):RippleTheme.kt#vhb33q");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg4, -1, "androidx.compose.material.ripple.DebugRippleTheme.rippleAlpha (RippleTheme.kt:242)");
        }

        RippleAlpha v2_1 = RippleTheme.Companion.defaultRippleAlpha-DxMtmZc(Color.Companion.getBlack-0d7_KjU(), true);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg3.endReplaceGroup();
        return v2_1;
    }
}

