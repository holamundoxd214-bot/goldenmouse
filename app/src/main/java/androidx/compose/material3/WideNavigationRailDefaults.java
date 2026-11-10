package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0018\u001A\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001AJA\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001C2\b\b\u0002\u0010\u001F\u001A\u00020\u001C2\b\b\u0002\u0010 \u001A\u00020\u001CH\u0007¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r8G¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001A\u00020\u0015¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001B\u001A\u00020\u001C8CX\u0082\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0014\u0010\u001E\u001A\u00020\u001C8CX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010$R\u0018\u0010&\u001A\u00020\u0019*\u00020\'8CX\u0082\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)¨\u0006*"}, d2={"Landroidx/compose/material3/WideNavigationRailDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "modalCollapsedShape", "getModalCollapsedShape", "modalExpandedShape", "getModalExpandedShape", "ModalExpandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "getModalExpandedProperties", "()Landroidx/compose/material3/ModalWideNavigationRailProperties;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WideNavigationRailColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailColors;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "getModalContainerColor", "defaultWideWideNavigationRailColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultWideWideNavigationRailColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WideNavigationRailColors;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRailDefaults {
    public static final int $stable;
    public static final WideNavigationRailDefaults INSTANCE;
    private static final ModalWideNavigationRailProperties ModalExpandedProperties;

    static {
        WideNavigationRailDefaults.INSTANCE = new WideNavigationRailDefaults();
        WideNavigationRailDefaults.ModalExpandedProperties = WideNavigationRail_androidKt.createDefaultModalWideNavigationRailProperties();
    }

    private WideNavigationRailDefaults() {
        super();
    }

    public final WideNavigationRailColors colors(Composer arg4, int arg5) {
        int v1 = 0xF372708;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)820@38996L11,820@39008L35:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:820)");
        }

        WideNavigationRailColors v3 = this.getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(arg4, 6), arg4, arg5 << 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final WideNavigationRailColors colors-zjMxDiM(long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        Composer v0 = arg29;
        int v1 = arg30;
        int v3 = 239918099;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,modalContainerColor:c#ui.graphics.Color,modalScrimColor:c#ui.graphics.Color,modalContentColor:c#ui.graphics.Color)839@40157L14,840@40203L31,841@40322L5,843@40401L5,844@40478L36,846@40572L11,846@40584L35:WideNavigationRail.kt#uh7d8r");
        int v4 = 6;
        long v5 = (arg31 & 1) != 0 ? WideNavigationRailDefaults.INSTANCE.getContainerColor(v0, v4) : arg19;
        long v7 = (arg31 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v5, v0, v1 & 14) : arg21;
        long v9 = (arg31 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), v0, v4) : arg23;
        long v11 = (arg31 & 8) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), v0, v4), 0.32f, 0f, 0f, 0f, 14, null) : arg25;
        long v13 = (arg31 & 16) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v9, v0, v1 >> 6 & 14) : arg27;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:846)");
        }

        WideNavigationRailColors v1_1 = this.getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(v0, v4), v0, v1 >> 12 & 0x70).copy-t635Npw(v5, v7, v9, v11, v13);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final Vertical getArrangement() {
        return Arrangement.INSTANCE.getTop();
    }

    private final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 2034736487;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)855@40987L5:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-containerColor> (WideNavigationRail.kt:855)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    private final WideNavigationRailColors getDefaultWideWideNavigationRailColors(ColorScheme arg24, Composer arg25, int arg26) {
        WideNavigationRailDefaults v0 = this;
        ColorScheme v1 = arg24;
        Composer v2 = arg25;
        int v3 = arg26;
        int v5 = 0x8A9A544F;
        ComposerKt.sourceInformationMarkerStart(v2, v5, "C(<get-defaultWideWideNavigationRailColors>):WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v3, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-defaultWideWideNavigationRailColors> (WideNavigationRail.kt:862)");
        }

        WideNavigationRailColors v4 = v1.getDefaultWideWideNavigationRailColorsCached$material3();
        if(v4 == null) {
            v2.startReplaceGroup(0x4D56C706);
            ComposerKt.sourceInformation(v2, "865@41394L14,866@41465L14,867@41528L19,868@41609L19,870@41728L5");
            v3 = v3 >> 3 & 14;
            v4 = new WideNavigationRailColors(v0.getContainerColor(v2, v3), ColorSchemeKt.contentColorFor-4WTKRHQ(v1, v0.getContainerColor(v2, v3)), v0.getModalContainerColor(v2, v3), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), v2, 6), 0.32f, 0f, 0f, 0f, 14, null), ColorSchemeKt.contentColorFor-4WTKRHQ(v1, v0.getModalContainerColor(v2, v3)), null);
            v1.setDefaultWideWideNavigationRailColorsCached$material3(v4);
            v2.endReplaceGroup();
        }
        else {
            v2.startReplaceGroup(0x4D5684C9);
            v2.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v2);
        return v4;
    }

    public final Shape getModalCollapsedShape(Composer arg4, int arg5) {
        int v1 = 0x37352127;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-modalCollapsedShape>)806@38398L5:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalCollapsedShape> (WideNavigationRail.kt:806)");
        }

        Shape v3 = this.getShape(arg4, arg5 & 14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    private final long getModalContainerColor(Composer arg3, int arg4) {
        int v0 = -1008951947;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-modalContainerColor>)858@41114L5:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalContainerColor> (WideNavigationRail.kt:858)");
        }

        long v0_1 = ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final ModalWideNavigationRailProperties getModalExpandedProperties() {
        return WideNavigationRailDefaults.ModalExpandedProperties;
    }

    public final Shape getModalExpandedShape(Composer arg3, int arg4) {
        int v0 = 0x6F342AC5;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-modalExpandedShape>)810@38592L5:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalExpandedShape> (WideNavigationRail.kt:810)");
        }

        Shape v2 = ShapesKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 1756160851;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)790@37840L5:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-shape> (WideNavigationRail.kt:790)");
        }

        Shape v2 = ShapesKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = 0x6976EFAE;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)800@38138L29:WideNavigationRail.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-windowInsets> (WideNavigationRail.kt:800)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getVertical-JoeWqyM(), WindowInsetsSides.Companion.getStart-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

