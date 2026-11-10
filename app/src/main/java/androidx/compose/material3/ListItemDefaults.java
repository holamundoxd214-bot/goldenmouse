package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0013\u001A\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015Ji\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u000E2\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\b\b\u0002\u0010\u001A\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u000E2\b\b\u0002\u0010\u001C\u001A\u00020\u000E2\b\b\u0002\u0010\u001D\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u001E\u0010\u001FR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u000E8G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u000E8G¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0018\u0010 \u001A\u00020\u0014*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u0006$"}, d2={"Landroidx/compose/material3/ListItemDefaults;", "", "<init>", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "colors", "Landroidx/compose/material3/ListItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "defaultListItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultListItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ListItemColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ListItemDefaults {
    public static final int $stable;
    private static final float Elevation;
    public static final ListItemDefaults INSTANCE;

    static {
        ListItemDefaults.INSTANCE = new ListItemDefaults();
        ListItemDefaults.Elevation = ListTokens.INSTANCE.getListItemContainerElevation-D9Ej5fM();
    }

    private ListItemDefaults() {
        super();
    }

    public final ListItemColors colors(Composer arg4, int arg5) {
        int v1 = 0xDF15E070;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)546@21839L11:ListItem.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:546)");
        }

        ListItemColors v3 = this.getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ListItemColors colors-J08w3-E(long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, Composer arg40, int arg41, int arg42) {
        Composer v0 = arg40;
        int v1 = arg42;
        int v3 = 0xEAFD0997;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(containerColor:c#ui.graphics.Color,headlineColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,overlineColor:c#ui.graphics.Color,supportingColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledHeadlineColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color)576@23403L11:ListItem.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg26;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v18 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v1_1 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        arg38 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg22 = v4;
            ComposerKt.traceEventStart(v3, arg41, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:576)");
        }
        else {
            arg22 = v4;
        }

        ListItemColors v1_2 = this.getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-5r9EGqc(arg22, v6, v8, v10, v12, v14, v16, v18, arg38);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0xB547E367;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)536@21490L5:ListItem.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:536)");
        }

        long v0_1 = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getContentColor(Composer arg3, int arg4) {
        int v0 = 0x40237FE7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-contentColor>)540@21651L5:ListItem.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:540)");
        }

        long v0_1 = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final ListItemColors getDefaultListItemColors$material3(ColorScheme arg28) {
        ColorScheme v0 = arg28;
        ListItemColors v1 = v0.getDefaultListItemColorsCached$material3();
        if(v1 == null) {
            ListItemColors v2 = new ListItemColors(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemContainerColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemLabelTextColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemOverlineColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemSupportingTextColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemDisabledLabelTextColor()), ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultListItemColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getElevation-D9Ej5fM() {
        return ListItemDefaults.Elevation;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xE2625753;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)532@21325L5:ListItem.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:532)");
        }

        Shape v2 = ShapesKt.getValue(ListTokens.INSTANCE.getListItemContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

