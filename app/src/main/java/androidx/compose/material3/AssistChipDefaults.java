package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000B\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\rJ_\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000F2\b\b\u0002\u0010\u0015\u001A\u00020\u000F2\b\b\u0002\u0010\u0016\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\u00052\b\b\u0002\u0010!\u001A\u00020\u00052\b\b\u0002\u0010\"\u001A\u00020\u00052\b\b\u0002\u0010#\u001A\u00020\u00052\b\b\u0002\u0010$\u001A\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010&J5\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010+\u001A\u00020\u000F2\b\b\u0002\u0010,\u001A\u00020\u000F2\b\b\u0002\u0010-\u001A\u00020\u0005H\u0007¢\u0006\u0004\b.\u0010/J-\u0010\'\u001A\u0002002\b\b\u0002\u0010+\u001A\u00020\u000F2\b\b\u0002\u0010,\u001A\u00020\u000F2\b\b\u0002\u0010-\u001A\u00020\u0005H\u0007¢\u0006\u0004\b1\u00102J\r\u00103\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\rJ_\u00103\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000F2\b\b\u0002\u0010\u0015\u001A\u00020\u000F2\b\b\u0002\u0010\u0016\u001A\u00020\u000FH\u0007¢\u0006\u0004\b4\u0010\u0018JK\u00107\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\u00052\b\b\u0002\u0010!\u001A\u00020\u00052\b\b\u0002\u0010\"\u001A\u00020\u00052\b\b\u0002\u0010#\u001A\u00020\u00052\b\b\u0002\u0010$\u001A\u00020\u0005H\u0007¢\u0006\u0004\b8\u0010&R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0018\u0010\u0019\u001A\u00020\f*\u00020\u001A8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0018\u00105\u001A\u00020\f*\u00020\u001A8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b6\u0010\u001CR\u0011\u00109\u001A\u00020:8G¢\u0006\u0006\u001A\u0004\b;\u0010<¨\u0006="}, d2={"Landroidx/compose/material3/AssistChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "assistChipColors", "Landroidx/compose/material3/ChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "defaultAssistChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultAssistChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "assistChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderColor", "disabledBorderColor", "borderWidth", "assistChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "Landroidx/compose/material3/ChipBorder;", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "defaultElevatedAssistChipColors", "getDefaultElevatedAssistChipColors$material3", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AssistChipDefaults {
    public static final int $stable;
    private static final float Height;
    public static final AssistChipDefaults INSTANCE;
    private static final float IconSize;

    static {
        AssistChipDefaults.INSTANCE = new AssistChipDefaults();
        AssistChipDefaults.Height = AssistChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        AssistChipDefaults.IconSize = AssistChipTokens.INSTANCE.getIconSize-D9Ej5fM();
    }

    private AssistChipDefaults() {
        super();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Maintained for binary compatibility. Use the assistChipBorder function that returns BorderStroke instead", replaceWith="<_subannotation>") public final ChipBorder assistChipBorder-d_3_b6Q(long arg18, long arg20, float arg22, Composer arg23, int arg24, int arg25) {
        Composer v0 = arg23;
        int v2 = 0x16CA8BEF;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(assistChipBorder)N(borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1139@54932L5,1141@55030L5:Chip.kt#uh7d8r");
        int v3 = 6;
        long v7 = (arg25 & 1) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), v0, v3) : arg18;
        long v9 = (arg25 & 2) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), v0, v3), AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg20;
        float v11 = (arg25 & 4) != 0 ? AssistChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM() : arg22;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg24, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1146)");
        }

        ChipBorder v6 = new ChipBorder(v7, v9, v11, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v6;
    }

    public final BorderStroke assistChipBorder-h1eT-Ww(boolean arg14, long arg15, long arg17, float arg19, Composer arg20, int arg21, int arg22) {
        Composer v13 = arg20;
        int v1 = 0xA90EC627;
        ComposerKt.sourceInformationMarkerStart(v13, v1, "C(assistChipBorder)N(enabled,borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1112@53758L5,1114@53856L5:Chip.kt#uh7d8r");
        int v2 = 6;
        long v3 = (arg22 & 2) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), v13, v2) : arg15;
        long v5 = (arg22 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), v13, v2), AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg17;
        float v0 = (arg22 & 8) != 0 ? AssistChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg21, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1118)");
        }

        if(arg14) {
        }
        else {
            v3 = v5;
        }

        BorderStroke v14 = BorderStrokeKt.BorderStroke-cXLIe8U(v0, v3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v13);
        return v14;
    }

    public final ChipColors assistChipColors(Composer arg4, int arg5) {
        int v1 = 1961061417;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(assistChipColors)1013@48649L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1013)");
        }

        ChipColors v3 = this.getDefaultAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ChipColors assistChipColors-oq7We08(long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, Composer arg36, int arg37, int arg38) {
        Composer v0 = arg36;
        int v1 = arg38;
        int v3 = 0xE8A66F43;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(assistChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,leadingIconContentColor:c#ui.graphics.Color,trailingIconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconContentColor:c#ui.graphics.Color,disabledTrailingIconContentColor:c#ui.graphics.Color)1039@50070L11:Chip.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg26;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v1_1 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        arg34 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg20 = v4;
            ComposerKt.traceEventStart(v3, arg37, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1039)");
        }
        else {
            arg20 = v4;
        }

        ChipColors v1_2 = this.getDefaultAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-FD3wquc(arg20, v6, v8, v10, v12, v14, v16, arg34);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final ChipElevation assistChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 0xE9FFD53;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(assistChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = AssistChipTokens.INSTANCE.getFlatContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        float v4 = (arg19 & 2) != 0 ? v3 : arg12;
        float v5 = (arg19 & 4) != 0 ? v3 : arg13;
        float v6 = (arg19 & 8) != 0 ? v3 : arg14;
        float v7 = (arg19 & 16) != 0 ? AssistChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? v3 : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1092)");
        }

        ChipElevation v2 = new ChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final ChipColors elevatedAssistChipColors(Composer arg4, int arg5) {
        int v1 = 0x270D2F9F;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(elevatedAssistChipColors)1157@55586L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1157)");
        }

        ChipColors v3 = this.getDefaultElevatedAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ChipColors elevatedAssistChipColors-oq7We08(long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, Composer arg36, int arg37, int arg38) {
        Composer v0 = arg36;
        int v1 = arg38;
        int v3 = 0xE010E90D;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(elevatedAssistChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,leadingIconContentColor:c#ui.graphics.Color,trailingIconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconContentColor:c#ui.graphics.Color,disabledTrailingIconContentColor:c#ui.graphics.Color)1183@57027L11:Chip.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg26;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v1_1 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        arg34 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg20 = v4;
            ComposerKt.traceEventStart(v3, arg37, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1183)");
        }
        else {
            arg20 = v4;
        }

        ChipColors v1_2 = SuggestionChipDefaults.INSTANCE.getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-FD3wquc(arg20, v6, v8, v10, v12, v14, v16, arg34);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final ChipElevation elevatedAssistChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 1457698077;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(elevatedAssistChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = AssistChipTokens.INSTANCE.getElevatedContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg19 & 2) != 0) {
            arg12 = AssistChipTokens.INSTANCE.getElevatedPressedContainerElevation-D9Ej5fM();
        }

        float v4 = arg12;
        if((arg19 & 4) != 0) {
            arg13 = AssistChipTokens.INSTANCE.getElevatedFocusContainerElevation-D9Ej5fM();
        }

        float v5 = arg13;
        if((arg19 & 8) != 0) {
            arg14 = AssistChipTokens.INSTANCE.getElevatedHoverContainerElevation-D9Ej5fM();
        }

        float v6 = arg14;
        float v7 = (arg19 & 16) != 0 ? AssistChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? AssistChipTokens.INSTANCE.getElevatedDisabledContainerElevation-D9Ej5fM() : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1238)");
        }

        ChipElevation v2 = new ChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final ChipColors getDefaultAssistChipColors$material3(ColorScheme arg26) {
        ColorScheme v0 = arg26;
        ChipColors v1 = v0.getDefaultAssistChipColorsCached$material3();
        if(v1 == null) {
            ChipColors v2 = new ChipColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getIconColor()), ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getIconColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultAssistChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final ChipColors getDefaultElevatedAssistChipColors$material3(ColorScheme arg26) {
        ColorScheme v0 = arg26;
        ChipColors v1 = v0.getDefaultElevatedAssistChipColorsCached$material3();
        if(v1 == null) {
            ChipColors v2 = new ChipColors(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getElevatedContainerColor()), ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getIconColor()), ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor()), AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultElevatedAssistChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getHeight-D9Ej5fM() {
        return AssistChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return AssistChipDefaults.IconSize;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x7680D23C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)1249@60742L5:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1249)");
        }

        Shape v2 = ShapesKt.getValue(AssistChipTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

