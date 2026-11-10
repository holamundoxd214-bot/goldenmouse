package androidx.compose.material3;

import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabPrimaryContainerTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\u00052\b\b\u0002\u0010\u001C\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ7\u0010\u001F\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\u00052\b\b\u0002\u0010\u001C\u001A\u00020\u0005H\u0007¢\u0006\u0004\b \u0010\u001EJ5\u0010!\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\u00052\b\b\u0002\u0010\u001C\u001A\u00020\u0005¢\u0006\u0004\b\"\u0010#R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u000F\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001A\u00020\u00148G¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2={"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "<init>", "()V", "LargeIconSize", "Landroidx/compose/ui/unit/Dp;", "getLargeIconSize-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "smallShape", "getSmallShape", "largeShape", "getLargeShape", "extendedFabShape", "getExtendedFabShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "bottomAppBarFabElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatingActionButtonDefaults {
    public static final int $stable;
    public static final FloatingActionButtonDefaults INSTANCE;
    private static final float LargeIconSize;

    static {
        FloatingActionButtonDefaults.INSTANCE = new FloatingActionButtonDefaults();
        FloatingActionButtonDefaults.LargeIconSize = Dp.constructor-impl(36f);
    }

    private FloatingActionButtonDefaults() {
        super();
    }

    public final FloatingActionButtonElevation bottomAppBarFabElevation-a9UjIt4(float arg7, float arg8, float arg9, float arg10) {
        return new FloatingActionButtonElevation(arg7, arg8, arg9, arg10, null);
    }

    public static FloatingActionButtonElevation bottomAppBarFabElevation-a9UjIt4$default(FloatingActionButtonDefaults arg1, float arg2, float arg3, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg6 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg6 & 4) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        if((arg6 & 8) != 0) {
            arg5 = Dp.constructor-impl(0f);
        }

        return arg1.bottomAppBarFabElevation-a9UjIt4(arg2, arg3, arg4, arg5);
    }

    public final FloatingActionButtonElevation elevation-xZ9-QkE(float arg8, float arg9, float arg10, float arg11, Composer arg12, int arg13, int arg14) {
        int v0 = 0xF1A102B7;
        ComposerKt.sourceInformationMarkerStart(arg12, v0, "C(elevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if((arg14 & 1) != 0) {
            arg8 = FabPrimaryContainerTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v2 = arg8;
        if((arg14 & 2) != 0) {
            arg9 = FabPrimaryContainerTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
        }

        float v3 = arg9;
        if((arg14 & 4) != 0) {
            arg10 = FabPrimaryContainerTokens.INSTANCE.getFocusedContainerElevation-D9Ej5fM();
        }

        float v4 = arg10;
        if((arg14 & 8) != 0) {
            arg11 = FabPrimaryContainerTokens.INSTANCE.getHoveredContainerElevation-D9Ej5fM();
        }

        float v5 = arg11;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg13, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:549)");
        }

        FloatingActionButtonElevation v1 = new FloatingActionButtonElevation(v2, v3, v4, v5, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return v1;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0x6E9B11C7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)529@24103L5:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:529)");
        }

        long v0_1 = ColorSchemeKt.getValue(FabPrimaryContainerTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final Shape getExtendedFabShape(Composer arg3, int arg4) {
        int v0 = 0xE00CF465;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-extendedFabShape>)525@23932L5:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:525)");
        }

        Shape v2 = ShapesKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getLargeIconSize-D9Ej5fM() {
        return FloatingActionButtonDefaults.LargeIconSize;
    }

    public final Shape getLargeShape(Composer arg3, int arg4) {
        int v0 = 0x92923405;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-largeShape>)521@23760L5:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:521)");
        }

        Shape v2 = ShapesKt.getValue(FabLargeTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xFCD381B3;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)513@23456L5:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:513)");
        }

        Shape v2 = ShapesKt.getValue(FabBaselineTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getSmallShape(Composer arg3, int arg4) {
        int v0 = 0x178A3485;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-smallShape>)517@23608L5:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:517)");
        }

        Shape v2 = ShapesKt.getValue(FabSmallTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final FloatingActionButtonElevation loweredElevation-xZ9-QkE(float arg8, float arg9, float arg10, float arg11, Composer arg12, int arg13, int arg14) {
        int v0 = 0xEF02405B;
        ComposerKt.sourceInformationMarkerStart(arg12, v0, "C(loweredElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if((arg14 & 1) != 0) {
            arg8 = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        }

        float v2 = arg8;
        if((arg14 & 2) != 0) {
            arg9 = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        }

        float v3 = arg9;
        if((arg14 & 4) != 0) {
            arg10 = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        }

        float v4 = arg10;
        if((arg14 & 8) != 0) {
            arg11 = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        }

        float v5 = arg11;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg13, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:573)");
        }

        FloatingActionButtonElevation v1 = new FloatingActionButtonElevation(v2, v3, v4, v5, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return v1;
    }
}

