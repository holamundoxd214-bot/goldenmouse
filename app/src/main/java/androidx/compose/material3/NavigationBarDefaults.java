package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u000E8G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/material3/NavigationBarDefaults;", "", "<init>", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationBarDefaults {
    public static final int $stable;
    private static final float Elevation;
    public static final NavigationBarDefaults INSTANCE;

    static {
        NavigationBarDefaults.INSTANCE = new NavigationBarDefaults();
        NavigationBarDefaults.Elevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    }

    private NavigationBarDefaults() {
        super();
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0x5B14EF3F;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)326@14412L5:NavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.NavigationBarDefaults.<get-containerColor> (NavigationBar.kt:326)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getElevation-D9Ej5fM() {
        return NavigationBarDefaults.Elevation;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = -1938678202;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)332@14590L29:NavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.NavigationBarDefaults.<get-windowInsets> (NavigationBar.kt:332)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

