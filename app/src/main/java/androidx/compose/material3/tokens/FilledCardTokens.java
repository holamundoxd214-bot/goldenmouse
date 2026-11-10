package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0014\u0010\u000BR\u0014\u0010\u0015\u001A\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000BR\u0013\u0010\u0018\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0019\u0010\u000BR\u0013\u0010\u001A\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001B\u0010\u000BR\u0011\u0010\u001C\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007R\u0013\u0010\u001E\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001F\u0010\u000BR\u0011\u0010 \u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0007R\u0013\u0010\"\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b#\u0010\u000BR\u0013\u0010$\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b%\u0010\u000B¨\u0006&"}, d2={"Landroidx/compose/material3/tokens/FilledCardTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledContainerColor", "getDisabledContainerColor", "DisabledContainerElevation", "getDisabledContainerElevation-D9Ej5fM", "DisabledContainerOpacity", "", "getDisabledContainerOpacity", "DraggedContainerElevation", "getDraggedContainerElevation-D9Ej5fM", "FocusContainerElevation", "getFocusContainerElevation-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "HoverContainerElevation", "getHoverContainerElevation-D9Ej5fM", "IconColor", "getIconColor", "IconSize", "getIconSize-D9Ej5fM", "PressedContainerElevation", "getPressedContainerElevation-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FilledCardTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens DisabledContainerColor;
    private static final float DisabledContainerElevation;
    private static final float DisabledContainerOpacity;
    private static final float DraggedContainerElevation;
    private static final float FocusContainerElevation;
    private static final ColorSchemeKeyTokens FocusIndicatorColor;
    private static final float HoverContainerElevation;
    public static final FilledCardTokens INSTANCE;
    private static final ColorSchemeKeyTokens IconColor;
    private static final float IconSize;
    private static final float PressedContainerElevation;

    static {
        FilledCardTokens.INSTANCE = new FilledCardTokens();
        FilledCardTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHighest;
        FilledCardTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        FilledCardTokens.ContainerShape = ShapeKeyTokens.CornerMedium;
        FilledCardTokens.DisabledContainerColor = ColorSchemeKeyTokens.SurfaceVariant;
        FilledCardTokens.DisabledContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        FilledCardTokens.DisabledContainerOpacity = 0.38f;
        FilledCardTokens.DraggedContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        FilledCardTokens.FocusContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        FilledCardTokens.FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        FilledCardTokens.HoverContainerElevation = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        FilledCardTokens.IconColor = ColorSchemeKeyTokens.Primary;
        FilledCardTokens.IconSize = Dp.constructor-impl(24f);
        FilledCardTokens.PressedContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    }

    private FilledCardTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return FilledCardTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return FilledCardTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return FilledCardTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return FilledCardTokens.DisabledContainerColor;
    }

    public final float getDisabledContainerElevation-D9Ej5fM() {
        return FilledCardTokens.DisabledContainerElevation;
    }

    public final float getDisabledContainerOpacity() {
        return FilledCardTokens.DisabledContainerOpacity;
    }

    public final float getDraggedContainerElevation-D9Ej5fM() {
        return FilledCardTokens.DraggedContainerElevation;
    }

    public final float getFocusContainerElevation-D9Ej5fM() {
        return FilledCardTokens.FocusContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FilledCardTokens.FocusIndicatorColor;
    }

    public final float getHoverContainerElevation-D9Ej5fM() {
        return FilledCardTokens.HoverContainerElevation;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return FilledCardTokens.IconColor;
    }

    public final float getIconSize-D9Ej5fM() {
        return FilledCardTokens.IconSize;
    }

    public final float getPressedContainerElevation-D9Ej5fM() {
        return FilledCardTokens.PressedContainerElevation;
    }
}

