package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\r\u001A\u00020\u000EH\u0007¢\u0006\u0002\u0010\u000FJ\u0091\u0001\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00112\b\b\u0002\u0010\u0015\u001A\u00020\u00112\b\b\u0002\u0010\u0016\u001A\u00020\u00112\b\b\u0002\u0010\u0017\u001A\u00020\u00112\b\b\u0002\u0010\u0018\u001A\u00020\u00112\b\b\u0002\u0010\u0019\u001A\u00020\u00112\b\b\u0002\u0010\u001A\u001A\u00020\u00112\b\b\u0002\u0010\u001B\u001A\u00020\u00112\b\b\u0002\u0010\u001C\u001A\u00020\u00112\b\b\u0002\u0010\u001D\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u001E\u0010\u001FJK\u0010$\u001A\u00020%2\b\b\u0002\u0010&\u001A\u00020\u00052\b\b\u0002\u0010\'\u001A\u00020\u00052\b\b\u0002\u0010(\u001A\u00020\u00052\b\b\u0002\u0010)\u001A\u00020\u00052\b\b\u0002\u0010*\u001A\u00020\u00052\b\b\u0002\u0010+\u001A\u00020\u0005H\u0007¢\u0006\u0004\b,\u0010-J[\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002012\b\b\u0002\u00103\u001A\u00020\u00112\b\b\u0002\u00104\u001A\u00020\u00112\b\b\u0002\u00105\u001A\u00020\u00112\b\b\u0002\u00106\u001A\u00020\u00112\b\b\u0002\u00107\u001A\u00020\u00052\b\b\u0002\u00108\u001A\u00020\u0005H\u0007¢\u0006\u0004\b9\u0010:R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0018\u0010 \u001A\u00020\u000E*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0011\u0010;\u001A\u00020<8G¢\u0006\u0006\u001A\u0004\b=\u0010>¨\u0006?"}, d2={"Landroidx/compose/material3/InputChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "AvatarSize", "getAvatarSize-D9Ej5fM", "inputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultInputChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultInputChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "inputChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InputChipDefaults {
    public static final int $stable;
    private static final float AvatarSize;
    private static final float Height;
    public static final InputChipDefaults INSTANCE;
    private static final float IconSize;

    static {
        InputChipDefaults.INSTANCE = new InputChipDefaults();
        InputChipDefaults.Height = InputChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        InputChipDefaults.IconSize = InputChipTokens.INSTANCE.getLeadingIconSize-D9Ej5fM();
        InputChipDefaults.AvatarSize = InputChipTokens.INSTANCE.getAvatarSize-D9Ej5fM();
    }

    private InputChipDefaults() {
        super();
    }

    public final float getAvatarSize-D9Ej5fM() {
        return InputChipDefaults.AvatarSize;
    }

    public final SelectableChipColors getDefaultInputChipColors$material3(ColorScheme arg31) {
        ColorScheme v0 = arg31;
        SelectableChipColors v1 = v0.getDefaultInputChipColorsCached$material3();
        if(v1 == null) {
            SelectableChipColors v2 = new SelectableChipColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getDisabledLabelTextColor()), InputChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getDisabledLeadingIconColor()), InputChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getDisabledTrailingIconColor()), InputChipTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getDisabledSelectedContainerColor()), InputChipTokens.INSTANCE.getDisabledSelectedContainerOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(v0, InputChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
            v0.setDefaultInputChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getHeight-D9Ej5fM() {
        return InputChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return InputChipDefaults.IconSize;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x3EBB05EF;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)1715@85906L5:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1715)");
        }

        Shape v2 = ShapesKt.getValue(InputChipTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final BorderStroke inputChipBorder-_7El2pE(boolean arg18, boolean arg19, long arg20, long arg22, long arg24, long arg26, float arg28, float arg29, Composer arg30, int arg31, int arg32) {
        Composer v0 = arg30;
        int v1 = arg32;
        int v3 = 2050575347;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(inputChipBorder)N(enabled,selected,borderColor:c#ui.graphics.Color,selectedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,disabledSelectedBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp,selectedBorderWidth:c#ui.unit.Dp)1694@84974L5,1697@85133L5:Chip.kt#uh7d8r");
        int v4 = 6;
        long v5 = (v1 & 4) != 0 ? ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), v0, v4) : arg20;
        long v7 = (v1 & 8) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg22;
        long v9 = (v1 & 16) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), v0, v4), InputChipTokens.INSTANCE.getDisabledUnselectedOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg24;
        long v11 = (v1 & 0x20) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg26;
        float v2 = (v1 & 0x40) != 0 ? InputChipTokens.INSTANCE.getUnselectedOutlineWidth-D9Ej5fM() : arg28;
        float v1_1 = (v1 & 0x80) != 0 ? InputChipTokens.INSTANCE.getSelectedOutlineWidth-D9Ej5fM() : arg29;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, arg31, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1703)");
        }

        if(arg18) {
            if(arg19) {
                v5 = v7;
            }
        }
        else if(arg19) {
            v5 = v11;
        }
        else {
            v5 = v9;
        }

        if(arg19) {
            v2 = v1_1;
        }

        BorderStroke v1_2 = BorderStrokeKt.BorderStroke-cXLIe8U(v2, v5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final SelectableChipColors inputChipColors(Composer arg4, int arg5) {
        int v1 = 0xD215005D;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(inputChipColors)1562@77510L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1562)");
        }

        SelectableChipColors v3 = this.getDefaultInputChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final SelectableChipColors inputChipColors-kwJvTHA(long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, Composer arg56, int arg57, int arg58, int arg59) {
        Composer v0 = arg56;
        int v1 = arg59;
        int v3 = 0x4E405BC6;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(inputChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1599@79651L11:Chip.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg40;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg42;
        long v18 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg44;
        long v20 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg46;
        long v22 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        long v24 = (v1 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg50;
        long v26 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg52;
        long v1_1 = (v1 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg54;
        arg54 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg30 = v4;
            ComposerKt.traceEventStart(v3, arg57, arg58, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1599)");
        }
        else {
            arg30 = v4;
        }

        SelectableChipColors v1_2 = this.getDefaultInputChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-daRQuJA(arg30, v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, arg54);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final SelectableChipElevation inputChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 1745270109;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(inputChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = InputChipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        float v4 = (arg19 & 2) != 0 ? v3 : arg12;
        float v5 = (arg19 & 4) != 0 ? v3 : arg13;
        float v6 = (arg19 & 8) != 0 ? v3 : arg14;
        float v7 = (arg19 & 16) != 0 ? InputChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? v3 : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1666)");
        }

        SelectableChipElevation v2 = new SelectableChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }
}

