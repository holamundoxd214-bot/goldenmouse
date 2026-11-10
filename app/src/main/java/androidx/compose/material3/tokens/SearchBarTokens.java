package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\r\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u0013\u0010\u0013\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0014\u0010\u000BR\u0011\u0010\u0015\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0010R\u0011\u0010\u001B\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0010R\u0011\u0010\u001D\u001A\u00020\u001E¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0011\u0010!\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0010R\u0011\u0010#\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0010R\u0011\u0010%\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u0010R\u0011\u0010\'\u001A\u00020\u001E¢\u0006\b\n\u0000\u001A\u0004\b(\u0010 R\u0011\u0010)\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b*\u0010\u0010¨\u0006+"}, d2={"Landroidx/compose/material3/tokens/SearchBarTokens;", "", "<init>", "()V", "AvatarShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getAvatarShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "getContainerShape", "FocusIndicatorColor", "getFocusIndicatorColor", "HoverSupportingTextColor", "getHoverSupportingTextColor", "InputTextColor", "getInputTextColor", "InputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LeadingIconColor", "getLeadingIconColor", "PressedSupportingTextColor", "getPressedSupportingTextColor", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "getSupportingTextFont", "TrailingIconColor", "getTrailingIconColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SearchBarTokens {
    public static final int $stable;
    private static final ShapeKeyTokens AvatarShape;
    private static final float AvatarSize;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens FocusIndicatorColor;
    private static final ColorSchemeKeyTokens HoverSupportingTextColor;
    public static final SearchBarTokens INSTANCE;
    private static final ColorSchemeKeyTokens InputTextColor;
    private static final TypographyKeyTokens InputTextFont;
    private static final ColorSchemeKeyTokens LeadingIconColor;
    private static final ColorSchemeKeyTokens PressedSupportingTextColor;
    private static final ColorSchemeKeyTokens SupportingTextColor;
    private static final TypographyKeyTokens SupportingTextFont;
    private static final ColorSchemeKeyTokens TrailingIconColor;

    static {
        SearchBarTokens.INSTANCE = new SearchBarTokens();
        SearchBarTokens.AvatarShape = ShapeKeyTokens.CornerFull;
        SearchBarTokens.AvatarSize = Dp.constructor-impl(30f);
        SearchBarTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        SearchBarTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        SearchBarTokens.ContainerHeight = Dp.constructor-impl(56f);
        SearchBarTokens.ContainerShape = ShapeKeyTokens.CornerFull;
        SearchBarTokens.FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        SearchBarTokens.HoverSupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SearchBarTokens.InputTextColor = ColorSchemeKeyTokens.OnSurface;
        SearchBarTokens.InputTextFont = TypographyKeyTokens.BodyLarge;
        SearchBarTokens.LeadingIconColor = ColorSchemeKeyTokens.OnSurface;
        SearchBarTokens.PressedSupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SearchBarTokens.SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SearchBarTokens.SupportingTextFont = TypographyKeyTokens.BodyLarge;
        SearchBarTokens.TrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    private SearchBarTokens() {
        super();
    }

    public final ShapeKeyTokens getAvatarShape() {
        return SearchBarTokens.AvatarShape;
    }

    public final float getAvatarSize-D9Ej5fM() {
        return SearchBarTokens.AvatarSize;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return SearchBarTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return SearchBarTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return SearchBarTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return SearchBarTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return SearchBarTokens.FocusIndicatorColor;
    }

    public final ColorSchemeKeyTokens getHoverSupportingTextColor() {
        return SearchBarTokens.HoverSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getInputTextColor() {
        return SearchBarTokens.InputTextColor;
    }

    public final TypographyKeyTokens getInputTextFont() {
        return SearchBarTokens.InputTextFont;
    }

    public final ColorSchemeKeyTokens getLeadingIconColor() {
        return SearchBarTokens.LeadingIconColor;
    }

    public final ColorSchemeKeyTokens getPressedSupportingTextColor() {
        return SearchBarTokens.PressedSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getSupportingTextColor() {
        return SearchBarTokens.SupportingTextColor;
    }

    public final TypographyKeyTokens getSupportingTextFont() {
        return SearchBarTokens.SupportingTextFont;
    }

    public final ColorSchemeKeyTokens getTrailingIconColor() {
        return SearchBarTokens.TrailingIconColor;
    }
}

