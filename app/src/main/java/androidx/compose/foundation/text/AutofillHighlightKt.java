package androidx.compose.foundation.text;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001A\'\u0010\n\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u000E\u0010\u000F\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\"\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\u0004¨\u0006\u0010"}, d2={"LocalAutofillHighlightBrush", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/graphics/Brush;", "getLocalAutofillHighlightBrush", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalAutofillHighlightColor", "Landroidx/compose/ui/graphics/Color;", "getLocalAutofillHighlightColor$annotations", "()V", "getLocalAutofillHighlightColor", "resolveAutofillHighlight", "brush", "color", "defaultColor", "resolveAutofillHighlight-WkMS-hQ", "(Landroidx/compose/ui/graphics/Brush;JJ)Landroidx/compose/ui/graphics/Brush;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AutofillHighlightKt {
    private static final ProvidableCompositionLocal LocalAutofillHighlightBrush;
    private static final ProvidableCompositionLocal LocalAutofillHighlightColor;

    static {
        AutofillHighlightKt.LocalAutofillHighlightBrush = CompositionLocalKt.compositionLocalOf$default(null, new AutofillHighlightKt$$ExternalSyntheticLambda0(), 1, null);
        AutofillHighlightKt.LocalAutofillHighlightColor = CompositionLocalKt.compositionLocalOf$default(null, AutofillHighlightKt$LocalAutofillHighlightColor$1.INSTANCE, 1, null);
    }

    static final Brush LocalAutofillHighlightBrush$lambda$0() {
        return new SolidColor(AutofillHighlight_androidKt.autofillHighlightColor(), null);
    }

    public static final ProvidableCompositionLocal getLocalAutofillHighlightBrush() {
        return AutofillHighlightKt.LocalAutofillHighlightBrush;
    }

    public static final ProvidableCompositionLocal getLocalAutofillHighlightColor() {
        return AutofillHighlightKt.LocalAutofillHighlightColor;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use LocalAutofillHighlightBrush instead. To provide a solid color, use SolidColor(yourColor).", replaceWith="<_subannotation>") public static void getLocalAutofillHighlightColor$annotations() {
    }

    public static final Brush resolveAutofillHighlight-WkMS-hQ(Brush arg0, long arg1, long arg3) {
        SolidColor v0;
        if(!Color.equals-impl0(arg1, arg3)) {
            v0 = new SolidColor(arg1, null);
        }

        return ((Brush)v0);
    }
}

