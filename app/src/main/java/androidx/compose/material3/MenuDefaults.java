package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0013\u001A\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015JK\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0016\u001A\u00020\u00102\b\b\u0002\u0010\u0017\u001A\u00020\u00102\b\b\u0002\u0010\u0018\u001A\u00020\u00102\b\b\u0002\u0010\u0019\u001A\u00020\u00102\b\b\u0002\u0010\u001A\u001A\u00020\u00102\b\b\u0002\u0010\u001B\u001A\u00020\u0010H\u0007¢\u0006\u0004\b\u001C\u0010\u001DR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0011\u0010\u000B\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u00108G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0018\u0010\u001E\u001A\u00020\u0014*\u00020\u001F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u0011\u0010\"\u001A\u00020#¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%¨\u0006&"}, d2={"Landroidx/compose/material3/MenuDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "itemColors", "Landroidx/compose/material3/MenuItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "defaultMenuItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MenuDefaults {
    public static final int $stable;
    private static final PaddingValues DropdownMenuItemContentPadding;
    public static final MenuDefaults INSTANCE;
    private static final float ShadowElevation;
    private static final float TonalElevation;

    static {
        MenuDefaults.INSTANCE = new MenuDefaults();
        MenuDefaults.TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        MenuDefaults.ShadowElevation = MenuTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        MenuDefaults.DropdownMenuItemContentPadding = PaddingKt.PaddingValues-YgX7TsA(MenuKt.access$getDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl(0f));
    }

    private MenuDefaults() {
        super();
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0x957603A7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)193@9485L5:Menu.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (Menu.kt:193)");
        }

        long v0_1 = ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3(ColorScheme arg22) {
        ColorScheme v0 = arg22;
        MenuItemColors v1 = v0.getDefaultMenuItemColorsCached$material3();
        if(v1 == null) {
            MenuItemColors v2 = new MenuItemColors(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemLabelTextColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemDisabledLabelTextColor()), ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ListTokens.INSTANCE.getListItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultMenuItemColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return MenuDefaults.DropdownMenuItemContentPadding;
    }

    public final float getShadowElevation-D9Ej5fM() {
        return MenuDefaults.ShadowElevation;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xD092393;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)189@9350L5:Menu.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (Menu.kt:189)");
        }

        Shape v2 = ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getTonalElevation-D9Ej5fM() {
        return MenuDefaults.TonalElevation;
    }

    public final MenuItemColors itemColors(Composer arg4, int arg5) {
        int v1 = 0x4F1143BC;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(itemColors)199@9684L11:Menu.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:199)");
        }

        MenuItemColors v3 = this.getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final MenuItemColors itemColors-5tl4gsc(long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        Composer v0 = arg29;
        int v2 = 0xB3CAF924;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(itemColors)N(textColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color)224@10924L11:Menu.kt#uh7d8r");
        long v3 = (arg31 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v5 = (arg31 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        long v7 = (arg31 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v9 = (arg31 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v11 = (arg31 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v13 = (arg31 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        if(ComposerKt.isTraceInProgress()) {
            arg17 = v3;
            ComposerKt.traceEventStart(v2, arg30, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:224)");
        }
        else {
            arg17 = v3;
        }

        MenuItemColors v1 = this.getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-tNS2XkQ(arg17, v5, v7, v9, v11, v13);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }
}

