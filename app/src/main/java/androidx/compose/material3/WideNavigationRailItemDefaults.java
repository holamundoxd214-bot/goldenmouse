package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailColorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0002\u0010\fJU\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u000E2\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001A\u00020\u000B*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"Landroidx/compose/material3/WideNavigationRailItemDefaults;", "", "<init>", "()V", "iconPositionFor", "Landroidx/compose/material3/NavigationItemIconPosition;", "railExpanded", "", "iconPositionFor-s8pcRp0", "(Z)I", "colors", "Landroidx/compose/material3/NavigationItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationItemColors;", "defaultWideNavigationRailItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultWideNavigationRailItemColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRailItemDefaults {
    public static final int $stable;
    public static final WideNavigationRailItemDefaults INSTANCE;

    static {
        WideNavigationRailItemDefaults.INSTANCE = new WideNavigationRailItemDefaults();
    }

    private WideNavigationRailItemDefaults() {
        super();
    }

    public final NavigationItemColors colors(Composer arg4, int arg5) {
        int v1 = 0x36594A6D;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)889@42453L11:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.colors (WideNavigationRail.kt:889)");
        }

        NavigationItemColors v3 = this.getDefaultWideNavigationRailItemColors(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final NavigationItemColors colors-69fazGs(long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, Composer arg36, int arg37, int arg38) {
        long v16;
        long v14;
        Composer v0 = arg36;
        int v2 = 1759081702;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedIndicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,disabledIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color)906@43491L5,907@43579L5,908@43672L5,909@43759L5,910@43851L5,914@44078L11:WideNavigationRail.kt#uh7d8r");
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
            ComposerKt.traceEventStart(v2, arg37, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.colors (WideNavigationRail.kt:914)");
        }
        else {
            arg22 = v4;
        }

        NavigationItemColors v1 = this.getDefaultWideNavigationRailItemColors(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-4JmcsL4(arg22, v6, v8, v14, v16, v10, v12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    private final NavigationItemColors getDefaultWideNavigationRailItemColors(ColorScheme arg24) {
        ColorScheme v0 = arg24;
        NavigationItemColors v1 = v0.getDefaultWideNavigationRailItemColorsCached$material3();
        if(v1 == null) {
            NavigationItemColors v2 = new NavigationItemColors(ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemActiveIcon()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemActiveLabelText()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemActiveIndicator()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveIcon()), ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveIcon()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultWideNavigationRailItemColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final int iconPositionFor-s8pcRp0(boolean arg1) {
        Companion v0 = NavigationItemIconPosition.Companion;
        if(arg1) {
            return v0.getStart--xw1Ddg();
        }

        return v0.getTop--xw1Ddg();
    }
}

