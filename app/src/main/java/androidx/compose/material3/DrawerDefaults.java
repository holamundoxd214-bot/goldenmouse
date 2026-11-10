package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001A\u00020\u000E8G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u00128G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0015\u001A\u00020\u00128GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0003\u001A\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0018\u001A\u00020\u00128G¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0014R\u0011\u0010\u001A\u001A\u00020\u00128G¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0014R\u0013\u0010\u001C\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001D\u0010\u0007R\u0011\u0010\u001E\u001A\u00020\u001F8G¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006\""}, d2={"Landroidx/compose/material3/DrawerDefaults;", "", "<init>", "()V", "ModalDrawerElevation", "Landroidx/compose/ui/unit/Dp;", "getModalDrawerElevation-D9Ej5fM", "()F", "F", "PermanentDrawerElevation", "getPermanentDrawerElevation-D9Ej5fM", "DismissibleDrawerElevation", "getDismissibleDrawerElevation-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "containerColor", "getContainerColor$annotations", "getContainerColor", "standardContainerColor", "getStandardContainerColor", "modalContainerColor", "getModalContainerColor", "MaximumDrawerWidth", "getMaximumDrawerWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawerDefaults {
    public static final int $stable;
    private static final float DismissibleDrawerElevation;
    public static final DrawerDefaults INSTANCE;
    private static final float MaximumDrawerWidth;
    private static final float ModalDrawerElevation;
    private static final float PermanentDrawerElevation;

    static {
        DrawerDefaults.INSTANCE = new DrawerDefaults();
        DrawerDefaults.ModalDrawerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DrawerDefaults.PermanentDrawerElevation = NavigationDrawerTokens.INSTANCE.getStandardContainerElevation-D9Ej5fM();
        DrawerDefaults.DismissibleDrawerElevation = NavigationDrawerTokens.INSTANCE.getStandardContainerElevation-D9Ej5fM();
        DrawerDefaults.MaximumDrawerWidth = NavigationDrawerTokens.INSTANCE.getContainerWidth-D9Ej5fM();
    }

    private DrawerDefaults() {
        super();
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0x94DF1D73;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)1021@43580L5:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DrawerDefaults.<get-containerColor> (NavigationDrawer.kt:1021)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getStandardContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Please use standardContainerColor or modalContainerColor instead.", replaceWith="<_subannotation>") public static void getContainerColor$annotations() {
    }

    public final float getDismissibleDrawerElevation-D9Ej5fM() {
        return DrawerDefaults.DismissibleDrawerElevation;
    }

    public final float getMaximumDrawerWidth-D9Ej5fM() {
        return DrawerDefaults.MaximumDrawerWidth;
    }

    public final long getModalContainerColor(Composer arg3, int arg4) {
        int v0 = 0x2A1B2E01;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-modalContainerColor>)1031@43992L5:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DrawerDefaults.<get-modalContainerColor> (NavigationDrawer.kt:1031)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getModalContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getModalDrawerElevation-D9Ej5fM() {
        return DrawerDefaults.ModalDrawerElevation;
    }

    public final float getPermanentDrawerElevation-D9Ej5fM() {
        return DrawerDefaults.PermanentDrawerElevation;
    }

    public final long getScrimColor(Composer arg9, int arg10) {
        int v0 = -1055074989;
        ComposerKt.sourceInformationMarkerStart(arg9, v0, "C(<get-scrimColor>)1012@43162L5:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg10, -1, "androidx.compose.material3.DrawerDefaults.<get-scrimColor> (NavigationDrawer.kt:1012)");
        }

        long v0_1 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), arg9, 6), 0.32f, 0f, 0f, 0f, 14, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return v0_1;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x3755F05F;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)1008@42990L5:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DrawerDefaults.<get-shape> (NavigationDrawer.kt:1008)");
        }

        Shape v2 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final long getStandardContainerColor(Composer arg3, int arg4) {
        int v0 = 0xF87E2A13;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-standardContainerColor>)1027@43814L5:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DrawerDefaults.<get-standardContainerColor> (NavigationDrawer.kt:1027)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getStandardContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = -909973510;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)1040@44274L29:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DrawerDefaults.<get-windowInsets> (NavigationDrawer.kt:1040)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getVertical-JoeWqyM(), WindowInsetsSides.Companion.getStart-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

