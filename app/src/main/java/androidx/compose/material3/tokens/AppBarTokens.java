package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\fR\u0013\u0010\u0019\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001A\u0010\u0007R\u0011\u0010\u001B\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\fR\u0013\u0010\u001D\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001E\u0010\u0007R\u0011\u0010\u001F\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b \u0010\fR\u0011\u0010!\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\fR\u0011\u0010#\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\fR\u0013\u0010%\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b&\u0010\u0007¨\u0006\'"}, d2={"Landroidx/compose/material3/tokens/AppBarTokens;", "", "<init>", "()V", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "IconButtonSpace", "getIconButtonSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LeadingIconColor", "getLeadingIconColor", "LeadingSpace", "getLeadingSpace-D9Ej5fM", "OnScrollContainerColor", "getOnScrollContainerColor", "OnScrollContainerElevation", "getOnScrollContainerElevation-D9Ej5fM", "SubtitleColor", "getSubtitleColor", "TitleColor", "getTitleColor", "TrailingIconColor", "getTrailingIconColor", "TrailingSpace", "getTrailingSpace-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AppBarTokens {
    public static final int $stable;
    private static final float AvatarSize;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    public static final AppBarTokens INSTANCE;
    private static final float IconButtonSpace;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens LeadingIconColor;
    private static final float LeadingSpace;
    private static final ColorSchemeKeyTokens OnScrollContainerColor;
    private static final float OnScrollContainerElevation;
    private static final ColorSchemeKeyTokens SubtitleColor;
    private static final ColorSchemeKeyTokens TitleColor;
    private static final ColorSchemeKeyTokens TrailingIconColor;
    private static final float TrailingSpace;

    static {
        AppBarTokens.INSTANCE = new AppBarTokens();
        AppBarTokens.AvatarSize = Dp.constructor-impl(32f);
        AppBarTokens.ContainerColor = ColorSchemeKeyTokens.Surface;
        AppBarTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        AppBarTokens.ContainerShape = ShapeKeyTokens.CornerNone;
        AppBarTokens.IconButtonSpace = Dp.constructor-impl(0f);
        AppBarTokens.IconSize = Dp.constructor-impl(24f);
        AppBarTokens.LeadingIconColor = ColorSchemeKeyTokens.OnSurface;
        AppBarTokens.LeadingSpace = Dp.constructor-impl(4f);
        AppBarTokens.OnScrollContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        AppBarTokens.OnScrollContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        AppBarTokens.SubtitleColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        AppBarTokens.TitleColor = ColorSchemeKeyTokens.OnSurface;
        AppBarTokens.TrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        AppBarTokens.TrailingSpace = Dp.constructor-impl(4f);
    }

    private AppBarTokens() {
        super();
    }

    public final float getAvatarSize-D9Ej5fM() {
        return AppBarTokens.AvatarSize;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return AppBarTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return AppBarTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return AppBarTokens.ContainerShape;
    }

    public final float getIconButtonSpace-D9Ej5fM() {
        return AppBarTokens.IconButtonSpace;
    }

    public final float getIconSize-D9Ej5fM() {
        return AppBarTokens.IconSize;
    }

    public final ColorSchemeKeyTokens getLeadingIconColor() {
        return AppBarTokens.LeadingIconColor;
    }

    public final float getLeadingSpace-D9Ej5fM() {
        return AppBarTokens.LeadingSpace;
    }

    public final ColorSchemeKeyTokens getOnScrollContainerColor() {
        return AppBarTokens.OnScrollContainerColor;
    }

    public final float getOnScrollContainerElevation-D9Ej5fM() {
        return AppBarTokens.OnScrollContainerElevation;
    }

    public final ColorSchemeKeyTokens getSubtitleColor() {
        return AppBarTokens.SubtitleColor;
    }

    public final ColorSchemeKeyTokens getTitleColor() {
        return AppBarTokens.TitleColor;
    }

    public final ColorSchemeKeyTokens getTrailingIconColor() {
        return AppBarTokens.TrailingIconColor;
    }

    public final float getTrailingSpace-D9Ej5fM() {
        return AppBarTokens.TrailingSpace;
    }
}

