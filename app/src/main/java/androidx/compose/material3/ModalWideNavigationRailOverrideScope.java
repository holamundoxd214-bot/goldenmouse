package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\b\u0001\u0018\u00002\u00020\u0001B\u0081\u0001\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0013\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000E¢\u0006\u0002\b\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0018\u0012\u0011\u0010\u0019\u001A\r\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b$\u0010#R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R \u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000E¢\u0006\u0002\b\u0010¢\u0006\n\n\u0002\u0010)\u001A\u0004\b\'\u0010(R\u0013\u0010\u0011\u001A\u00020\u0012¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+R\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b-\u0010.R\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u001E\u0010\u0019\u001A\r\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0002\b\u0010¢\u0006\n\n\u0002\u0010)\u001A\u0004\b3\u0010(¨\u00064"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/WideNavigationRailState;", "shouldHideOnCollapse", "", "collapsedShape", "Landroidx/compose/ui/graphics/Shape;", "expandedShape", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", "header", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "content", "<init>", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getState", "()Landroidx/compose/material3/WideNavigationRailState;", "getShouldHideOnCollapse", "()Z", "getCollapsedShape", "()Landroidx/compose/ui/graphics/Shape;", "getExpandedShape", "getColors", "()Landroidx/compose/material3/WideNavigationRailColors;", "getHeader", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getExpandedHeaderTopPadding-D9Ej5fM", "()F", "F", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getExpandedProperties", "()Landroidx/compose/material3/ModalWideNavigationRailProperties;", "getContent", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ModalWideNavigationRailOverrideScope {
    public static final int $stable = 8;
    private final Vertical arrangement;
    private final Shape collapsedShape;
    private final WideNavigationRailColors colors;
    private final Function2 content;
    private final float expandedHeaderTopPadding;
    private final ModalWideNavigationRailProperties expandedProperties;
    private final Shape expandedShape;
    private final Function2 header;
    private final Modifier modifier;
    private final boolean shouldHideOnCollapse;
    private final WideNavigationRailState state;
    private final WindowInsets windowInsets;

    static {
    }

    private ModalWideNavigationRailOverrideScope(Modifier arg1, WideNavigationRailState arg2, boolean arg3, Shape arg4, Shape arg5, WideNavigationRailColors arg6, Function2 arg7, float arg8, WindowInsets arg9, Vertical arg10, ModalWideNavigationRailProperties arg11, Function2 arg12) {
        super();
        this.modifier = arg1;
        this.state = arg2;
        this.shouldHideOnCollapse = arg3;
        this.collapsedShape = arg4;
        this.expandedShape = arg5;
        this.colors = arg6;
        this.header = arg7;
        this.expandedHeaderTopPadding = arg8;
        this.windowInsets = arg9;
        this.arrangement = arg10;
        this.expandedProperties = arg11;
        this.content = arg12;
    }

    public ModalWideNavigationRailOverrideScope(Modifier arg1, WideNavigationRailState arg2, boolean arg3, Shape arg4, Shape arg5, WideNavigationRailColors arg6, Function2 arg7, float arg8, WindowInsets arg9, Vertical arg10, ModalWideNavigationRailProperties arg11, Function2 arg12, DefaultConstructorMarker arg13) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public final Vertical getArrangement() {
        return this.arrangement;
    }

    public final Shape getCollapsedShape() {
        return this.collapsedShape;
    }

    public final WideNavigationRailColors getColors() {
        return this.colors;
    }

    public final Function2 getContent() {
        return this.content;
    }

    public final float getExpandedHeaderTopPadding-D9Ej5fM() {
        return this.expandedHeaderTopPadding;
    }

    public final ModalWideNavigationRailProperties getExpandedProperties() {
        return this.expandedProperties;
    }

    public final Shape getExpandedShape() {
        return this.expandedShape;
    }

    public final Function2 getHeader() {
        return this.header;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final boolean getShouldHideOnCollapse() {
        return this.shouldHideOnCollapse;
    }

    public final WideNavigationRailState getState() {
        return this.state;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }
}

