package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JU\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000F\u0010\u0010R\u0018\u0010\u0011\u001A\u00020\u0005*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2={"Landroidx/compose/material3/ShortNavigationBarItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationItemColors;", "defaultShortNavigationBarItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultShortNavigationBarItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ShortNavigationBarItemDefaults {
    public static final int $stable;
    public static final ShortNavigationBarItemDefaults INSTANCE;

    static {
        ShortNavigationBarItemDefaults.INSTANCE = new ShortNavigationBarItemDefaults();
    }

    private ShortNavigationBarItemDefaults() {
        super();
    }

    public final NavigationItemColors colors(Composer arg4, int arg5) {
        int v1 = 0x38E38EAD;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)287@12395L11:ShortNavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ShortNavigationBarItemDefaults.colors (ShortNavigationBar.kt:287)");
        }

        NavigationItemColors v3 = this.getDefaultShortNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
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
        int v2 = 1801697574;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedIndicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,disabledIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color)304@13432L5,305@13519L5,306@13611L5,307@13697L5,308@13788L5,312@14015L11:ShortNavigationBar.kt#uh7d8r");
        int v3 = 6;
        long v4 = (arg38 & 1) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIconColor(), v0, v3) : arg22;
        long v6 = (arg38 & 2) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor(), v0, v3) : arg24;
        long v8 = (arg38 & 4) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor(), v0, v3) : arg26;
        long v10 = (arg38 & 8) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveIconColor(), v0, v3) : arg28;
        long v12 = (arg38 & 16) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor(), v0, v3) : arg30;
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
            ComposerKt.traceEventStart(v2, arg37, -1, "androidx.compose.material3.ShortNavigationBarItemDefaults.colors (ShortNavigationBar.kt:312)");
        }
        else {
            arg22 = v4;
        }

        NavigationItemColors v1 = this.getDefaultShortNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-4JmcsL4(arg22, v6, v8, v14, v16, v10, v12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    public final NavigationItemColors getDefaultShortNavigationBarItemColors$material3(ColorScheme arg24) {
        ColorScheme v0 = arg24;
        NavigationItemColors v1 = v0.getDefaultShortNavigationBarItemColorsCached$material3();
        if(v1 == null) {
            NavigationItemColors v2 = new NavigationItemColors(ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemActiveIconColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveIconColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveIconColor()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultShortNavigationBarItemColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }
}

