package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F8G¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/material3/ShortNavigationBarDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "getArrangement-LnnQw40", "()I", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ShortNavigationBarDefaults {
    public static final int $stable;
    public static final ShortNavigationBarDefaults INSTANCE;

    static {
        ShortNavigationBarDefaults.INSTANCE = new ShortNavigationBarDefaults();
    }

    private ShortNavigationBarDefaults() {
        super();
    }

    public final int getArrangement-LnnQw40() {
        return ShortNavigationBarArrangement.Companion.getEqualWeight-LnnQw40();
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = -159508825;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)262@11498L5:ShortNavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ShortNavigationBarDefaults.<get-containerColor> (ShortNavigationBar.kt:262)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getContentColor(Composer arg4, int arg5) {
        int v1 = 133067559;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-contentColor>)266@11638L14,266@11622L31:ShortNavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ShortNavigationBarDefaults.<get-contentColor> (ShortNavigationBar.kt:266)");
        }

        long v0 = ColorSchemeKt.contentColorFor-ek8zF_U(this.getContainerColor(arg4, arg5 & 14), arg4, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v0;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = -424843026;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)276@12006L29:ShortNavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ShortNavigationBarDefaults.<get-windowInsets> (ShortNavigationBar.kt:276)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

