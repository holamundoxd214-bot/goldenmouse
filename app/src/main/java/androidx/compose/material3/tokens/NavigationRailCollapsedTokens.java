package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2={"Landroidx/compose/material3/tokens/NavigationRailCollapsedTokens;", "", "<init>", "()V", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "ItemVerticalSpace", "getItemVerticalSpace-D9Ej5fM", "TopSpace", "getTopSpace-D9Ej5fM", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "NarrowContainerWidth", "getNarrowContainerWidth-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationRailCollapsedTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final float ContainerWidth;
    public static final NavigationRailCollapsedTokens INSTANCE;
    private static final float ItemVerticalSpace;
    private static final float NarrowContainerWidth;
    private static final float TopSpace;

    static {
        NavigationRailCollapsedTokens.INSTANCE = new NavigationRailCollapsedTokens();
        NavigationRailCollapsedTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        NavigationRailCollapsedTokens.ContainerShape = ShapeKeyTokens.CornerNone;
        NavigationRailCollapsedTokens.ContainerWidth = Dp.constructor-impl(96f);
        NavigationRailCollapsedTokens.ItemVerticalSpace = Dp.constructor-impl(4f);
        NavigationRailCollapsedTokens.TopSpace = Dp.constructor-impl(44f);
        NavigationRailCollapsedTokens.ContainerColor = ColorSchemeKeyTokens.Surface;
        NavigationRailCollapsedTokens.NarrowContainerWidth = Dp.constructor-impl(80f);
    }

    private NavigationRailCollapsedTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return NavigationRailCollapsedTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return NavigationRailCollapsedTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return NavigationRailCollapsedTokens.ContainerShape;
    }

    public final float getContainerWidth-D9Ej5fM() {
        return NavigationRailCollapsedTokens.ContainerWidth;
    }

    public final float getItemVerticalSpace-D9Ej5fM() {
        return NavigationRailCollapsedTokens.ItemVerticalSpace;
    }

    public final float getNarrowContainerWidth-D9Ej5fM() {
        return NavigationRailCollapsedTokens.NarrowContainerWidth;
    }

    public final float getTopSpace-D9Ej5fM() {
        return NavigationRailCollapsedTokens.TopSpace;
    }
}

