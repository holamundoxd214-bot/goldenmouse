package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR\u0013\u0010\u0012\u001A\u00020\u0013¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2={"Landroidx/compose/material3/AlertDialogDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "iconContentColor", "getIconContentColor", "titleContentColor", "getTitleContentColor", "textContentColor", "getTextContentColor", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AlertDialogDefaults {
    public static final int $stable;
    public static final AlertDialogDefaults INSTANCE;
    private static final float TonalElevation;

    static {
        AlertDialogDefaults.INSTANCE = new AlertDialogDefaults();
        AlertDialogDefaults.TonalElevation = Dp.constructor-impl(0f);
    }

    private AlertDialogDefaults() {
        super();
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 616766901;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)225@10099L5:AlertDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.AlertDialogDefaults.<get-containerColor> (AlertDialog.kt:225)");
        }

        long v0_1 = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getIconContentColor(Composer arg3, int arg4) {
        int v0 = 0x6225F015;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-iconContentColor>)229@10241L5:AlertDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.AlertDialogDefaults.<get-iconContentColor> (AlertDialog.kt:229)");
        }

        long v0_1 = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getIconColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xC739F0A1;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)221@9949L5:AlertDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.AlertDialogDefaults.<get-shape> (AlertDialog.kt:221)");
        }

        Shape v2 = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final long getTextContentColor(Composer arg3, int arg4) {
        int v0 = 0x671B5995;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-textContentColor>)237@10541L5:AlertDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.AlertDialogDefaults.<get-textContentColor> (AlertDialog.kt:237)");
        }

        long v0_1 = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getSupportingTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getTitleContentColor(Composer arg3, int arg4) {
        int v0 = 247083549;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-titleContentColor>)233@10389L5:AlertDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.AlertDialogDefaults.<get-titleContentColor> (AlertDialog.kt:233)");
        }

        long v0_1 = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getHeadlineColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getTonalElevation-D9Ej5fM() {
        return AlertDialogDefaults.TonalElevation;
    }
}

