package androidx.compose.foundation.contextmenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001A!\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0003\u001A\u00020\u00042\b\b\u0001\u0010\u0005\u001A\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0006\u001A/\u0010\u0007\u001A\u00020\b*\u00020\t2\b\b\u0001\u0010\n\u001A\u00020\u00042\b\b\u0001\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000E\u001A\"\u0010\u000F\u001A\u0004\u0018\u00010\u0010*\u00020\t2\b\b\u0001\u0010\n\u001A\u00020\u00042\b\b\u0001\u0010\u000B\u001A\u00020\u0004H\u0002\u001A\u001D\u0010\u0011\u001A\u00020\b*\u0004\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u001D\u0010\u0014\u001A\u00020\b*\u0004\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2={"computeContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "resolveColor", "Landroidx/compose/ui/graphics/Color;", "Landroid/content/Context;", "resId", "attrId", "defaultColor", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "Landroid/content/res/ColorStateList;", "enabledColor", "enabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "disabledColor", "disabledColor-4WTKRHQ", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuUi_androidKt {
    public static final ContextMenuColors computeContextMenuColors(Composer arg3, int arg4) {
        int v1 = 1428061410;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(computeContextMenuColors)32@1185L160:ContextMenuUi.android.kt#3xeu6s");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:32)");
        }

        ContextMenuColors v4 = ContextMenuUi_androidKt.computeContextMenuColors(0x1030086, 0x1030080, arg3, 54);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }

    public static final ContextMenuColors computeContextMenuColors(int arg17, int arg18, Composer arg19, int arg20) {
        Composer v0 = arg19;
        int v2 = 0x64B3CE0E;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(computeContextMenuColors)N(backgroundStyleId,foregroundStyleId)42@1528L7,43@1584L7,43@1547L851:ContextMenuUi.android.kt#3xeu6s");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg20, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:41)");
        }

        ProvidableCompositionLocal v1 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = v0.consume(((CompositionLocal)v1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = v0.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(v0);
        ComposerKt.sourceInformationMarkerStart(v0, 0x6F89C41, "CC(remember):ContextMenuUi.android.kt#9igjgp");
        v2 = v0.changed(v2_1) | v0.changed(v1_1);
        Object v3 = v0.rememberedValue();
        if(v2 != 0 || v3 == Composer.Companion.getEmpty()) {
            long v6 = ContextMenuUi_androidKt.resolveColor-g2O1Hgs(((Context)v1_1), arg17, 0x1010031, ContextMenuUiKt.getDefaultContextMenuColors().getBackgroundColor-0d7_KjU());
            ColorStateList v1_2 = ContextMenuUi_androidKt.resolveColorStateList(((Context)v1_1), arg18, 0x1010036);
            long v8 = ContextMenuUi_androidKt.enabledColor-4WTKRHQ(v1_2, ContextMenuUiKt.getDefaultContextMenuColors().getTextColor-0d7_KjU());
            long v12 = ContextMenuUi_androidKt.disabledColor-4WTKRHQ(v1_2, ContextMenuUiKt.getDefaultContextMenuColors().getDisabledTextColor-0d7_KjU());
            ContextMenuColors v5 = new ContextMenuColors(v6, v8, v8, v12, v12, null);
            v0.updateRememberedValue(v5);
            ContextMenuColors v3_1 = v5;
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((ContextMenuColors)v3);
    }

    private static final long disabledColor-4WTKRHQ(ColorStateList arg2, long arg3) {
        int v0 = ColorKt.toArgb-8_81llA(arg3);
        Integer v2 = arg2 != null ? Integer.valueOf(arg2.getColorForState(new int[]{0xFEFEFF62}, v0)) : null;
        if(v2 != null) {
            if(v2.intValue() == v0) {
            }
            else {
                return ColorKt.Color(v2.intValue());
            }
        }

        return arg3;
    }

    private static final long enabledColor-4WTKRHQ(ColorStateList arg2, long arg3) {
        int v0 = ColorKt.toArgb-8_81llA(arg3);
        Integer v2 = arg2 != null ? Integer.valueOf(arg2.getColorForState(new int[]{0x101009E}, v0)) : null;
        if(v2 != null) {
            if(v2.intValue() == v0) {
            }
            else {
                return ColorKt.Color(v2.intValue());
            }
        }

        return arg3;
    }

    private static final long resolveColor-g2O1Hgs(Context arg0, int arg1, int arg2, long arg3) {
        TypedArray v0 = arg0.obtainStyledAttributes(arg1, new int[]{arg2});
        arg1 = ColorKt.toArgb-8_81llA(arg3);
        arg2 = v0.getColor(0, arg1);
        v0.recycle();
        if(arg2 == arg1) {
            return arg3;
        }

        return ColorKt.Color(arg2);
    }

    private static final ColorStateList resolveColorStateList(Context arg0, int arg1, int arg2) {
        TypedArray v0 = arg0.obtainStyledAttributes(arg1, new int[]{arg2});
        ColorStateList v1 = v0.getColorStateList(0);
        v0.recycle();
        return v1;
    }
}

