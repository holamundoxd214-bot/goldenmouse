package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000B\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\rJK\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\u00052\b\b\u0002\u0010\u001C\u001A\u00020\u00052\b\b\u0002\u0010\u001D\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u001F\u0010 J5\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020\u000F2\b\b\u0002\u0010&\u001A\u00020\u000F2\b\b\u0002\u0010\'\u001A\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)J-\u0010!\u001A\u00020*2\b\b\u0002\u0010%\u001A\u00020\u000F2\b\b\u0002\u0010&\u001A\u00020\u000F2\b\b\u0002\u0010\'\u001A\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J\r\u0010-\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\rJK\u0010-\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000FH\u0007¢\u0006\u0004\b.\u0010\u0016JK\u00103\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\u00052\b\b\u0002\u0010\u001C\u001A\u00020\u00052\b\b\u0002\u0010\u001D\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u0005H\u0007¢\u0006\u0004\b4\u0010 R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0018\u0010/\u001A\u00020\f*\u0002008@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b1\u00102R\u0011\u00105\u001A\u0002068G¢\u0006\u0006\u001A\u0004\b7\u00108¨\u00069"}, d2={"Landroidx/compose/material3/SuggestionChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "suggestionChipColors", "Landroidx/compose/material3/ChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "suggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "suggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "suggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "Landroidx/compose/material3/ChipBorder;", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "elevatedSuggestionChipColors", "elevatedSuggestionChipColors-5tl4gsc", "defaultElevatedSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedSuggestionChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SuggestionChipDefaults {
    public static final int $stable;
    private static final float Height;
    public static final SuggestionChipDefaults INSTANCE;
    private static final float IconSize;

    static {
        SuggestionChipDefaults.INSTANCE = new SuggestionChipDefaults();
        SuggestionChipDefaults.Height = SuggestionChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        SuggestionChipDefaults.IconSize = SuggestionChipTokens.INSTANCE.getLeadingIconSize-D9Ej5fM();
    }

    private SuggestionChipDefaults() {
        super();
    }

    public final ChipColors elevatedSuggestionChipColors(Composer arg4, int arg5) {
        int v1 = 0x639CFE3F;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(elevatedSuggestionChipColors)1851@91827L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1851)");
        }

        ChipColors v3 = this.getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ChipColors elevatedSuggestionChipColors-5tl4gsc(long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, Composer arg35, int arg36, int arg37) {
        Composer v0 = arg35;
        int v2 = 0x4BA9DC15;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(elevatedSuggestionChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledIconContentColor:c#ui.graphics.Color)1873@92926L11:Chip.kt#uh7d8r");
        long v6 = (arg37 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v8 = (arg37 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v10 = (arg37 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v14 = (arg37 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg29;
        long v16 = (arg37 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v18 = (arg37 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg33;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg36, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1873)");
        }

        ChipColors v1 = this.getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-FD3wquc(v6, v8, v10, Color.Companion.getUnspecified-0d7_KjU(), v14, v16, v18, Color.Companion.getUnspecified-0d7_KjU());
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    public final ChipElevation elevatedSuggestionChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 1118088467;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(elevatedSuggestionChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = SuggestionChipTokens.INSTANCE.getElevatedContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg19 & 2) != 0) {
            arg12 = SuggestionChipTokens.INSTANCE.getElevatedPressedContainerElevation-D9Ej5fM();
        }

        float v4 = arg12;
        if((arg19 & 4) != 0) {
            arg13 = SuggestionChipTokens.INSTANCE.getElevatedFocusContainerElevation-D9Ej5fM();
        }

        float v5 = arg13;
        if((arg19 & 8) != 0) {
            arg14 = SuggestionChipTokens.INSTANCE.getElevatedHoverContainerElevation-D9Ej5fM();
        }

        float v6 = arg14;
        float v7 = (arg19 & 16) != 0 ? SuggestionChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerElevation-D9Ej5fM() : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1926)");
        }

        ChipElevation v2 = new ChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColors$material3(ColorScheme arg24) {
        ColorScheme v0 = arg24;
        ChipColors v1 = v0.getDefaultElevatedSuggestionChipColorsCached$material3();
        if(v1 == null) {
            ChipColors v2 = new ChipColors(ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getElevatedContainerColor()), ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.getUnspecified-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor()), AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0f, 0f, 0f, 14, null), Color.Companion.getUnspecified-0d7_KjU(), null);
            v0.setDefaultElevatedSuggestionChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getHeight-D9Ej5fM() {
        return SuggestionChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return SuggestionChipDefaults.IconSize;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x2637C157;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)1937@96518L5:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1937)");
        }

        Shape v2 = ShapesKt.getValue(SuggestionChipTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Maintained for binary compatibility. Use the suggestChipBorder functions instead", replaceWith="<_subannotation>") public final ChipBorder suggestionChipBorder-d_3_b6Q(long arg18, long arg20, float arg22, Composer arg23, int arg24, int arg25) {
        Composer v0 = arg23;
        int v2 = 0x1A2EF0CF;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(suggestionChipBorder)N(borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1832@91145L5,1834@91247L5:Chip.kt#uh7d8r");
        int v3 = 6;
        long v7 = (arg25 & 1) != 0 ? ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), v0, v3) : arg18;
        long v9 = (arg25 & 2) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), v0, v3), SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg20;
        float v11 = (arg25 & 4) != 0 ? SuggestionChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM() : arg22;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg24, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1839)");
        }

        ChipBorder v6 = new ChipBorder(v7, v9, v11, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v6;
    }

    public final BorderStroke suggestionChipBorder-h1eT-Ww(boolean arg14, long arg15, long arg17, float arg19, Composer arg20, int arg21, int arg22) {
        Composer v13 = arg20;
        int v1 = 0xDA02BCC7;
        ComposerKt.sourceInformationMarkerStart(v13, v1, "C(suggestionChipBorder)N(enabled,borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1806@89984L5,1808@90086L5:Chip.kt#uh7d8r");
        int v2 = 6;
        long v3 = (arg22 & 2) != 0 ? ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), v13, v2) : arg15;
        long v5 = (arg22 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), v13, v2), SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg17;
        float v0 = (arg22 & 8) != 0 ? SuggestionChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg21, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1812)");
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

    public final ChipColors suggestionChipColors(Composer arg3, int arg4) {
        int v0 = 0x725B10C9;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(suggestionChipColors)1733@86525L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1733)");
        }

        ChipColors v2 = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(arg3, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final ChipColors suggestionChipColors-5tl4gsc(long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, Composer arg35, int arg36, int arg37) {
        Composer v0 = arg35;
        int v2 = 0x7036ED4B;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(suggestionChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledIconContentColor:c#ui.graphics.Color)1755@87603L11:Chip.kt#uh7d8r");
        long v6 = (arg37 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v8 = (arg37 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v10 = (arg37 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v14 = (arg37 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg29;
        long v16 = (arg37 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg31;
        long v18 = (arg37 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg33;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg36, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1755)");
        }

        ChipColors v1 = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-FD3wquc(v6, v8, v10, Color.Companion.getUnspecified-0d7_KjU(), v14, v16, v18, Color.Companion.getUnspecified-0d7_KjU());
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    public final ChipElevation suggestionChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 0x73095F49;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(suggestionChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = SuggestionChipTokens.INSTANCE.getFlatContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        float v4 = (arg19 & 2) != 0 ? v3 : arg12;
        float v5 = (arg19 & 4) != 0 ? v3 : arg13;
        float v6 = (arg19 & 8) != 0 ? v3 : arg14;
        float v7 = (arg19 & 16) != 0 ? SuggestionChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? v3 : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1786)");
        }

        ChipElevation v2 = new ChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }
}

