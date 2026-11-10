package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JU\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000F\u0010\u0010JA\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0011\u001A\u00020\u0005*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2={"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "defaultNavigationBarItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationBarItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationBarItemColors;", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationBarItemDefaults {
    public static final int $stable;
    public static final NavigationBarItemDefaults INSTANCE;

    static {
        NavigationBarItemDefaults.INSTANCE = new NavigationBarItemDefaults();
    }

    private NavigationBarItemDefaults() {
        super();
    }

    public final NavigationBarItemColors colors(Composer arg4, int arg5) {
        int v1 = 0x3CBAEF72;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)344@14973L11:NavigationBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:344)");
        }

        NavigationBarItemColors v3 = this.getDefaultNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final NavigationBarItemColors colors-69fazGs(long arg18, long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, Composer arg32, int arg33, int arg34) {
        Composer v0 = arg32;
        int v2 = 0x9F86AB19;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,disabledIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color)369@16357L11:NavigationBar.kt#uh7d8r");
        long v3 = (arg34 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg18;
        long v5 = (arg34 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v7 = (arg34 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v9 = (arg34 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        long v11 = (arg34 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg26;
        long v13 = (arg34 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v15 = (arg34 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        if(ComposerKt.isTraceInProgress()) {
            arg18 = v3;
            ComposerKt.traceEventStart(v2, arg33, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:369)");
        }
        else {
            arg18 = v3;
        }

        NavigationBarItemColors v1 = this.getDefaultNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-4JmcsL4(arg18, v5, v7, v9, v11, v13, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use overload with disabledIconColor and disabledTextColor") public final NavigationBarItemColors colors-zjMxDiM(long arg23, long arg25, long arg27, long arg29, long arg31, Composer arg33, int arg34, int arg35) {
        Composer v0 = arg33;
        int v2 = 0xF34400C7;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color)406@18273L5,407@18360L5,408@18444L5,409@18530L5,410@18621L5:NavigationBar.kt#uh7d8r");
        int v3 = 6;
        long v7 = (arg35 & 1) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIconColor(), v0, v3) : arg23;
        long v9 = (arg35 & 2) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor(), v0, v3) : arg25;
        long v11 = (arg35 & 4) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor(), v0, v3) : arg27;
        long v13 = (arg35 & 8) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveIconColor(), v0, v3) : arg29;
        long v15 = (arg35 & 16) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor(), v0, v3) : arg31;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg34, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:412)");
        }

        NavigationBarItemColors v6 = new NavigationBarItemColors(v7, v9, v11, v13, v15, Color.copy-wmQWz5c$default(v13, 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(v15, 0.38f, 0f, 0f, 0f, 14, null), null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v6;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColors$material3(ColorScheme arg24) {
        ColorScheme v0 = arg24;
        NavigationBarItemColors v1 = v0.getDefaultNavigationBarItemColorsCached$material3();
        if(v1 == null) {
            NavigationBarItemColors v2 = new NavigationBarItemColors(ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemActiveIconColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveIconColor()), ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveIconColor()), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultNavigationBarItemColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }
}

