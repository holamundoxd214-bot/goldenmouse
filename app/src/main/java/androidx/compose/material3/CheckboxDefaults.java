package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0010\u001A\u00020\u0005*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2={"Landroidx/compose/material3/CheckboxDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/CheckboxColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "defaultCheckboxColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCheckboxColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CheckboxColors;", "StrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getStrokeWidth-D9Ej5fM", "()F", "F", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CheckboxDefaults {
    public static final int $stable;
    public static final CheckboxDefaults INSTANCE;
    private static final float StrokeWidth;

    static {
        CheckboxDefaults.INSTANCE = new CheckboxDefaults();
        CheckboxDefaults.StrokeWidth = Dp.constructor-impl(2f);
    }

    private CheckboxDefaults() {
        super();
    }

    public final CheckboxColors colors(Composer arg4, int arg5) {
        int v1 = -9530498;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)315@14310L11:Checkbox.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:315)");
        }

        CheckboxColors v3 = this.getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final CheckboxColors colors-5tl4gsc(long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, Composer arg43, int arg44, int arg45) {
        Composer v0 = arg43;
        int v2 = 0xFAA9C960;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(checkedColor:c#ui.graphics.Color,uncheckedColor:c#ui.graphics.Color,checkmarkColor:c#ui.graphics.Color,disabledCheckedColor:c#ui.graphics.Color,disabledUncheckedColor:c#ui.graphics.Color,disabledIndeterminateColor:c#ui.graphics.Color)341@15700L11:Checkbox.kt#uh7d8r");
        long v10 = (arg45 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v22 = (arg45 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg33;
        long v6 = (arg45 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg35;
        long v14 = (arg45 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg37;
        long v26 = (arg45 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg39;
        long v18 = (arg45 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg41;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg44, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:341)");
        }

        CheckboxColors v1 = this.getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-2qZNXz8(v6, Color.Companion.getTransparent-0d7_KjU(), v10, Color.Companion.getTransparent-0d7_KjU(), v14, Color.Companion.getTransparent-0d7_KjU(), v18, v10, v22, v14, v26, v18);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    public final CheckboxColors getDefaultCheckboxColors$material3(ColorScheme arg34) {
        ColorScheme v0 = arg34;
        CheckboxColors v1 = v0.getDefaultCheckboxColorsCached$material3();
        if(v1 == null) {
            CheckboxColors v2 = new CheckboxColors(ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedIconColor()), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedContainerColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0f, 0f, 0f, 14, null), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getUnselectedOutlineColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultCheckboxColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getStrokeWidth-D9Ej5fM() {
        return CheckboxDefaults.StrokeWidth;
    }
}

