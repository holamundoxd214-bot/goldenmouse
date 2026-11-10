package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailColorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JU\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000F\u0010\u0010JA\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0011\u001A\u00020\u0005*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2={"Landroidx/compose/material3/NavigationRailItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationRailItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "defaultNavigationRailItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationRailItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationRailItemColors;", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationRailItemDefaults {
    public static final int $stable;
    public static final NavigationRailItemDefaults INSTANCE;

    static {
        NavigationRailItemDefaults.INSTANCE = new NavigationRailItemDefaults();
    }

    private NavigationRailItemDefaults() {
        super();
    }

    public final NavigationRailItemColors colors(Composer arg4, int arg5) {
        int v1 = 0x87EFBA9B;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)346@15041L11:NavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:346)");
        }

        NavigationRailItemColors v3 = this.getDefaultNavigationRailItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final NavigationRailItemColors colors-69fazGs(long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, Composer arg36, int arg37, int arg38) {
        long v16;
        long v14;
        Composer v0 = arg36;
        int v2 = -2104358508;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,disabledIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color)363@16071L5,364@16159L5,365@16244L5,366@16331L5,367@16423L5,371@16654L11:NavigationRail.kt#uh7d8r");
        int v3 = 6;
        long v4 = (arg38 & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIcon(), v0, v3) : arg22;
        long v6 = (arg38 & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveLabelText(), v0, v3) : arg24;
        long v8 = (arg38 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIndicator(), v0, v3) : arg26;
        long v10 = (arg38 & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveIcon(), v0, v3) : arg28;
        long v12 = (arg38 & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText(), v0, v3) : arg30;
        if((arg38 & 0x20) != 0) {
            arg22 = v10;
            v10 = Color.copy-wmQWz5c$default(arg22, 0.38f, 0f, 0f, 0f, 14, null);
            v14 = arg22;
        }
        else {
            v14 = v10;
            v10 = arg32;
        }

        if((arg38 & 0x40) != 0) {
            arg22 = v12;
            v12 = Color.copy-wmQWz5c$default(arg22, 0.38f, 0f, 0f, 0f, 14, null);
            v16 = arg22;
        }
        else {
            v16 = v12;
            v12 = arg34;
        }

        if(ComposerKt.isTraceInProgress()) {
            arg22 = v4;
            ComposerKt.traceEventStart(v2, arg37, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:371)");
        }
        else {
            arg22 = v4;
        }

        NavigationRailItemColors v1 = this.getDefaultNavigationRailItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-4JmcsL4(arg22, v6, v8, v14, v16, v10, v12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use overload with disabledIconColor and disabledTextColor") public final NavigationRailItemColors colors-zjMxDiM(long arg23, long arg25, long arg27, long arg29, long arg31, Composer arg33, int arg34, int arg35) {
        Composer v0 = arg33;
        int v2 = 0x60A7AD26;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color)409@18612L5,410@18700L5,411@18785L5,412@18872L5,413@18964L5:NavigationRail.kt#uh7d8r");
        int v3 = 6;
        long v7 = (arg35 & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIcon(), v0, v3) : arg23;
        long v9 = (arg35 & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveLabelText(), v0, v3) : arg25;
        long v11 = (arg35 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIndicator(), v0, v3) : arg27;
        long v13 = (arg35 & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveIcon(), v0, v3) : arg29;
        long v15 = (arg35 & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText(), v0, v3) : arg31;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg34, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:415)");
        }

        NavigationRailItemColors v6 = new NavigationRailItemColors(v7, v9, v11, v13, v15, Color.copy-wmQWz5c$default(v13, 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(v15, 0.38f, 0f, 0f, 0f, 14, null), null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v6;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColors$material3(ColorScheme arg24) {
        ColorScheme v0 = arg24;
        NavigationRailItemColors v1 = v0.getDefaultNavigationRailItemColorsCached$material3();
        if(v1 == null) {
            NavigationRailItemColors v2 = new NavigationRailItemColors(ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemActiveIcon()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemActiveLabelText()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemActiveIndicator()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveIcon()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveIcon()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultNavigationRailItemColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }
}

