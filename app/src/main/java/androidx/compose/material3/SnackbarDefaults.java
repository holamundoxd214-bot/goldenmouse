package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR\u0011\u0010\u0012\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000B¨\u0006\u0014"}, d2={"Landroidx/compose/material3/SnackbarDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "actionColor", "getActionColor", "actionContentColor", "getActionContentColor", "dismissActionContentColor", "getDismissActionContentColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SnackbarDefaults {
    public static final int $stable;
    public static final SnackbarDefaults INSTANCE;

    static {
        SnackbarDefaults.INSTANCE = new SnackbarDefaults();
    }

    private SnackbarDefaults() {
        super();
    }

    public final long getActionColor(Composer arg3, int arg4) {
        int v0 = 0x2C4FC5B9;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-actionColor>)425@18294L5:Snackbar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionColor> (Snackbar.kt:425)");
        }

        long v0_1 = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getActionContentColor(Composer arg3, int arg4) {
        int v0 = 0xB1BB0CA7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-actionContentColor>)429@18454L5:Snackbar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionContentColor> (Snackbar.kt:429)");
        }

        long v0_1 = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getColor(Composer arg3, int arg4) {
        int v0 = 0x3AE2BDCD;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-color>)417@18003L5:Snackbar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SnackbarDefaults.<get-color> (Snackbar.kt:417)");
        }

        long v0_1 = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getContentColor(Composer arg3, int arg4) {
        int v0 = 0x3CDFF767;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-contentColor>)421@18149L5:Snackbar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SnackbarDefaults.<get-contentColor> (Snackbar.kt:421)");
        }

        long v0_1 = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getDismissActionContentColor(Composer arg3, int arg4) {
        int v0 = 0xE07E293F;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-dismissActionContentColor>)433@18618L5:Snackbar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SnackbarDefaults.<get-dismissActionContentColor> (Snackbar.kt:433)");
        }

        long v0_1 = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getIconColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xDF1ECED3;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)413@17877L5:Snackbar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SnackbarDefaults.<get-shape> (Snackbar.kt:413)");
        }

        Shape v2 = ShapesKt.getValue(SnackbarTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

