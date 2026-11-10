package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000E\u001A\u00020\u0005*\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/material3/RadioButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/RadioButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "defaultRadioButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultRadioButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RadioButtonColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RadioButtonDefaults {
    public static final int $stable;
    public static final RadioButtonDefaults INSTANCE;

    static {
        RadioButtonDefaults.INSTANCE = new RadioButtonDefaults();
    }

    private RadioButtonDefaults() {
        super();
    }

    public final RadioButtonColors colors(Composer arg4, int arg5) {
        int v1 = 0xB8FA24CE;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)135@5709L11:RadioButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:135)");
        }

        RadioButtonColors v3 = this.getDefaultRadioButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final RadioButtonColors colors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = -351083046;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedColor:c#ui.graphics.Color,unselectedColor:c#ui.graphics.Color,disabledSelectedColor:c#ui.graphics.Color,disabledUnselectedColor:c#ui.graphics.Color)155@6681L11:RadioButton.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:155)");
        }

        RadioButtonColors v12 = this.getDefaultRadioButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }

    public final RadioButtonColors getDefaultRadioButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        RadioButtonColors v1 = v0.getDefaultRadioButtonColorsCached$material3();
        if(v1 == null) {
            RadioButtonColors v2 = new RadioButtonColors(ColorSchemeKt.fromToken(v0, RadioButtonTokens.INSTANCE.getSelectedIconColor()), ColorSchemeKt.fromToken(v0, RadioButtonTokens.INSTANCE.getUnselectedIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, RadioButtonTokens.INSTANCE.getDisabledSelectedIconColor()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, RadioButtonTokens.INSTANCE.getDisabledUnselectedIconColor()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultRadioButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }
}

