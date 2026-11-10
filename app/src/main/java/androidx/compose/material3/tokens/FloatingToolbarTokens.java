package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018R\u0011\u0010\u001B\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0018R\u0011\u0010\u001D\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0018R\u0011\u0010\u001F\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0018R\u0011\u0010!\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0018R\u0011\u0010#\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0018¨\u0006%"}, d2={"Landroidx/compose/material3/tokens/FloatingToolbarTokens;", "", "<init>", "()V", "ContainerBetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getContainerBetweenSpace-D9Ej5fM", "()F", "F", "ContainerExternalPadding", "getContainerExternalPadding-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerLeadingSpace", "getContainerLeadingSpace-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerTrailingSpace", "getContainerTrailingSpace-D9Ej5fM", "StandardContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getStandardContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "VibrantButtonSelectedContainerColor", "getVibrantButtonSelectedContainerColor", "VibrantButtonSelectedIconColor", "getVibrantButtonSelectedIconColor", "VibrantButtonSelectedTextColor", "getVibrantButtonSelectedTextColor", "VibrantButtonUnselectedIconColor", "getVibrantButtonUnselectedIconColor", "VibrantButtonUnselectedTextColor", "getVibrantButtonUnselectedTextColor", "VibrantContainerColor", "getVibrantContainerColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatingToolbarTokens {
    public static final int $stable;
    private static final float ContainerBetweenSpace;
    private static final float ContainerExternalPadding;
    private static final float ContainerHeight;
    private static final float ContainerLeadingSpace;
    private static final ShapeKeyTokens ContainerShape;
    private static final float ContainerTrailingSpace;
    public static final FloatingToolbarTokens INSTANCE;
    private static final ColorSchemeKeyTokens StandardContainerColor;
    private static final ColorSchemeKeyTokens VibrantButtonSelectedContainerColor;
    private static final ColorSchemeKeyTokens VibrantButtonSelectedIconColor;
    private static final ColorSchemeKeyTokens VibrantButtonSelectedTextColor;
    private static final ColorSchemeKeyTokens VibrantButtonUnselectedIconColor;
    private static final ColorSchemeKeyTokens VibrantButtonUnselectedTextColor;
    private static final ColorSchemeKeyTokens VibrantContainerColor;

    static {
        FloatingToolbarTokens.INSTANCE = new FloatingToolbarTokens();
        FloatingToolbarTokens.ContainerBetweenSpace = Dp.constructor-impl(4f);
        FloatingToolbarTokens.ContainerExternalPadding = Dp.constructor-impl(16f);
        FloatingToolbarTokens.ContainerHeight = Dp.constructor-impl(64f);
        FloatingToolbarTokens.ContainerLeadingSpace = Dp.constructor-impl(8f);
        FloatingToolbarTokens.ContainerShape = ShapeKeyTokens.CornerFull;
        FloatingToolbarTokens.ContainerTrailingSpace = Dp.constructor-impl(8f);
        FloatingToolbarTokens.StandardContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        FloatingToolbarTokens.VibrantButtonSelectedContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        FloatingToolbarTokens.VibrantButtonSelectedIconColor = ColorSchemeKeyTokens.OnSurface;
        FloatingToolbarTokens.VibrantButtonSelectedTextColor = ColorSchemeKeyTokens.OnSurface;
        FloatingToolbarTokens.VibrantButtonUnselectedIconColor = ColorSchemeKeyTokens.OnPrimaryContainer;
        FloatingToolbarTokens.VibrantButtonUnselectedTextColor = ColorSchemeKeyTokens.OnPrimaryContainer;
        FloatingToolbarTokens.VibrantContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
    }

    private FloatingToolbarTokens() {
        super();
    }

    public final float getContainerBetweenSpace-D9Ej5fM() {
        return FloatingToolbarTokens.ContainerBetweenSpace;
    }

    public final float getContainerExternalPadding-D9Ej5fM() {
        return FloatingToolbarTokens.ContainerExternalPadding;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return FloatingToolbarTokens.ContainerHeight;
    }

    public final float getContainerLeadingSpace-D9Ej5fM() {
        return FloatingToolbarTokens.ContainerLeadingSpace;
    }

    public final ShapeKeyTokens getContainerShape() {
        return FloatingToolbarTokens.ContainerShape;
    }

    public final float getContainerTrailingSpace-D9Ej5fM() {
        return FloatingToolbarTokens.ContainerTrailingSpace;
    }

    public final ColorSchemeKeyTokens getStandardContainerColor() {
        return FloatingToolbarTokens.StandardContainerColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonSelectedContainerColor() {
        return FloatingToolbarTokens.VibrantButtonSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonSelectedIconColor() {
        return FloatingToolbarTokens.VibrantButtonSelectedIconColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonSelectedTextColor() {
        return FloatingToolbarTokens.VibrantButtonSelectedTextColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonUnselectedIconColor() {
        return FloatingToolbarTokens.VibrantButtonUnselectedIconColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonUnselectedTextColor() {
        return FloatingToolbarTokens.VibrantButtonUnselectedTextColor;
    }

    public final ColorSchemeKeyTokens getVibrantContainerColor() {
        return FloatingToolbarTokens.VibrantContainerColor;
    }
}

