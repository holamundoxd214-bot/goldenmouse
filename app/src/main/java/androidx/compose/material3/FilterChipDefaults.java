package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000B\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\u0087\u0001\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000F2\b\b\u0002\u0010\u0015\u001A\u00020\u000F2\b\b\u0002\u0010\u0016\u001A\u00020\u000F2\b\b\u0002\u0010\u0017\u001A\u00020\u000F2\b\b\u0002\u0010\u0018\u001A\u00020\u000F2\b\b\u0002\u0010\u0019\u001A\u00020\u000F2\b\b\u0002\u0010\u001A\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u001B\u0010\u001CJK\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020\u00052\b\b\u0002\u0010$\u001A\u00020\u00052\b\b\u0002\u0010%\u001A\u00020\u00052\b\b\u0002\u0010&\u001A\u00020\u00052\b\b\u0002\u0010\'\u001A\u00020\u00052\b\b\u0002\u0010(\u001A\u00020\u0005H\u0007¢\u0006\u0004\b)\u0010*J[\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020.2\b\b\u0002\u00100\u001A\u00020\u000F2\b\b\u0002\u00101\u001A\u00020\u000F2\b\b\u0002\u00102\u001A\u00020\u000F2\b\b\u0002\u00103\u001A\u00020\u000F2\b\b\u0002\u00104\u001A\u00020\u00052\b\b\u0002\u00105\u001A\u00020\u0005H\u0007¢\u0006\u0004\b6\u00107J\r\u00108\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\u0087\u0001\u00108\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000F2\b\b\u0002\u0010\u0015\u001A\u00020\u000F2\b\b\u0002\u0010\u0016\u001A\u00020\u000F2\b\b\u0002\u0010\u0017\u001A\u00020\u000F2\b\b\u0002\u0010\u0018\u001A\u00020\u000F2\b\b\u0002\u0010\u0019\u001A\u00020\u000F2\b\b\u0002\u0010\u001A\u001A\u00020\u000FH\u0007¢\u0006\u0004\b9\u0010\u001CJK\u0010<\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020\u00052\b\b\u0002\u0010$\u001A\u00020\u00052\b\b\u0002\u0010%\u001A\u00020\u00052\b\b\u0002\u0010&\u001A\u00020\u00052\b\b\u0002\u0010\'\u001A\u00020\u00052\b\b\u0002\u0010(\u001A\u00020\u0005H\u0007¢\u0006\u0004\b=\u0010*R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0018\u0010\u001D\u001A\u00020\f*\u00020\u001E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0018\u0010:\u001A\u00020\f*\u00020\u001E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b;\u0010 R\u0011\u0010>\u001A\u00020?8G¢\u0006\u0006\u001A\u0004\b@\u0010A¨\u0006B"}, d2={"Landroidx/compose/material3/FilterChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "filterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "filterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilterChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "filterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "filterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "elevatedFilterChipColors", "elevatedFilterChipColors-XqyqHi0", "defaultElevatedFilterChipColors", "getDefaultElevatedFilterChipColors$material3", "elevatedFilterChipElevation", "elevatedFilterChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FilterChipDefaults {
    public static final int $stable;
    private static final float Height;
    public static final FilterChipDefaults INSTANCE;
    private static final float IconSize;

    static {
        FilterChipDefaults.INSTANCE = new FilterChipDefaults();
        FilterChipDefaults.Height = FilterChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FilterChipDefaults.IconSize = FilterChipTokens.INSTANCE.getIconSize-D9Ej5fM();
    }

    private FilterChipDefaults() {
        super();
    }

    public final SelectableChipColors elevatedFilterChipColors(Composer arg4, int arg5) {
        int v1 = 0x408C8E49;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(elevatedFilterChipColors)1424@69975L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1424)");
        }

        SelectableChipColors v3 = this.getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final SelectableChipColors elevatedFilterChipColors-XqyqHi0(long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, Composer arg58, int arg59, int arg60, int arg61) {
        Composer v0 = arg58;
        int v1 = arg61;
        int v3 = 0xC9695D51;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(elevatedFilterChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1459@71995L11:Chip.kt#uh7d8r");
        long v7 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v9 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v11 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        long v15 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg40;
        long v17 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg42;
        long v19 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg44;
        long v21 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg46;
        long v23 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        long v25 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg50;
        long v27 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg52;
        long v29 = (v1 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg54;
        long v31 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg56;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, arg59, arg60, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1459)");
        }

        SelectableChipColors v1_1 = this.getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-daRQuJA(v7, v9, v11, v11, v15, v17, v19, v21, v23, v25, v27, v29, v31);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final SelectableChipElevation elevatedFilterChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 684803697;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(elevatedFilterChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = FilterChipTokens.INSTANCE.getElevatedContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg19 & 2) != 0) {
            arg12 = FilterChipTokens.INSTANCE.getElevatedPressedContainerElevation-D9Ej5fM();
        }

        float v4 = arg12;
        if((arg19 & 4) != 0) {
            arg13 = FilterChipTokens.INSTANCE.getElevatedFocusContainerElevation-D9Ej5fM();
        }

        float v5 = arg13;
        if((arg19 & 8) != 0) {
            arg14 = FilterChipTokens.INSTANCE.getElevatedHoverContainerElevation-D9Ej5fM();
        }

        float v6 = arg14;
        float v7 = (arg19 & 16) != 0 ? FilterChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? FilterChipTokens.INSTANCE.getElevatedDisabledContainerElevation-D9Ej5fM() : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1530)");
        }

        SelectableChipElevation v2 = new SelectableChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final BorderStroke filterChipBorder-_7El2pE(boolean arg18, boolean arg19, long arg20, long arg22, long arg24, long arg26, float arg28, float arg29, Composer arg30, int arg31, int arg32) {
        Composer v0 = arg30;
        int v1 = arg32;
        int v3 = 0xBC2645D1;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(filterChipBorder)N(enabled,selected,borderColor:c#ui.graphics.Color,selectedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,disabledSelectedBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp,selectedBorderWidth:c#ui.unit.Dp)1400@68925L5,1403@69089L5:Chip.kt#uh7d8r");
        int v4 = 6;
        long v5 = (v1 & 4) != 0 ? ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), v0, v4) : arg20;
        long v7 = (v1 & 8) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg22;
        long v9 = (v1 & 16) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), v0, v4), FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg24;
        long v11 = (v1 & 0x20) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg26;
        float v2 = (v1 & 0x40) != 0 ? FilterChipTokens.INSTANCE.getFlatUnselectedOutlineWidth-D9Ej5fM() : arg28;
        float v1_1 = (v1 & 0x80) != 0 ? FilterChipTokens.INSTANCE.getFlatSelectedOutlineWidth-D9Ej5fM() : arg29;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, arg31, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1409)");
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

    public final SelectableChipColors filterChipColors(Composer arg4, int arg5) {
        int v1 = 0x98102653;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(filterChipColors)1267@61335L11:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1267)");
        }

        SelectableChipColors v3 = this.getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final SelectableChipColors filterChipColors-XqyqHi0(long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, Composer arg58, int arg59, int arg60, int arg61) {
        Composer v0 = arg58;
        int v1 = arg61;
        int v3 = 0x92D5D607;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(filterChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1302@63334L11:Chip.kt#uh7d8r");
        long v7 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v9 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v11 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        long v15 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg40;
        long v17 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg42;
        long v19 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg44;
        long v21 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg46;
        long v23 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        long v25 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg50;
        long v27 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg52;
        long v29 = (v1 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg54;
        long v31 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg56;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, arg59, arg60, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1302)");
        }

        SelectableChipColors v1_1 = this.getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-daRQuJA(v7, v9, v11, v11, v15, v17, v19, v21, v23, v25, v27, v29, v31);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final SelectableChipElevation filterChipElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 0xD2D24327;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(filterChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = FilterChipTokens.INSTANCE.getFlatContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg19 & 2) != 0) {
            arg12 = FilterChipTokens.INSTANCE.getFlatSelectedPressedContainerElevation-D9Ej5fM();
        }

        float v4 = arg12;
        if((arg19 & 4) != 0) {
            arg13 = FilterChipTokens.INSTANCE.getFlatSelectedFocusContainerElevation-D9Ej5fM();
        }

        float v5 = arg13;
        if((arg19 & 8) != 0) {
            arg14 = FilterChipTokens.INSTANCE.getFlatSelectedHoverContainerElevation-D9Ej5fM();
        }

        float v6 = arg14;
        float v7 = (arg19 & 16) != 0 ? FilterChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? v3 : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1372)");
        }

        SelectableChipElevation v2 = new SelectableChipElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3(ColorScheme arg31) {
        ColorScheme v0 = arg31;
        SelectableChipColors v1 = v0.getDefaultElevatedFilterChipColorsCached$material3();
        if(v1 == null) {
            SelectableChipColors v2 = new SelectableChipColors(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getDisabledTrailingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
            v0.setDefaultElevatedFilterChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3(ColorScheme arg31) {
        ColorScheme v0 = arg31;
        SelectableChipColors v1 = v0.getDefaultFilterChipColorsCached$material3();
        if(v1 == null) {
            SelectableChipColors v2 = new SelectableChipColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getDisabledTrailingIconColor()), FilterChipTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor()), FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(v0, FilterChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
            v0.setDefaultFilterChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getHeight-D9Ej5fM() {
        return FilterChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return FilterChipDefaults.IconSize;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xA0B6A24B;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)1541@76826L5:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1541)");
        }

        Shape v2 = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

