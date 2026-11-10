package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0013\u0010\u0014\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001A\u00020\u001A¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u001D\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0007R\u0011\u0010\u001F\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u000FR\u0011\u0010!\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0007R\u0011\u0010#\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u000FR\u0011\u0010%\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u0007R\u0013\u0010\'\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b(\u0010\u0017¨\u0006)"}, d2={"Landroidx/compose/material3/tokens/DialogTokens;", "", "<init>", "()V", "ActionFocusLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActionFocusLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActionHoverLabelTextColor", "getActionHoverLabelTextColor", "ActionLabelTextColor", "getActionLabelTextColor", "ActionLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getActionLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ActionPressedLabelTextColor", "getActionPressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "HeadlineColor", "getHeadlineColor", "HeadlineFont", "getHeadlineFont", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "getSupportingTextFont", "IconColor", "getIconColor", "IconSize", "getIconSize-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DialogTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ActionFocusLabelTextColor;
    private static final ColorSchemeKeyTokens ActionHoverLabelTextColor;
    private static final ColorSchemeKeyTokens ActionLabelTextColor;
    private static final TypographyKeyTokens ActionLabelTextFont;
    private static final ColorSchemeKeyTokens ActionPressedLabelTextColor;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens HeadlineColor;
    private static final TypographyKeyTokens HeadlineFont;
    public static final DialogTokens INSTANCE;
    private static final ColorSchemeKeyTokens IconColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens SupportingTextColor;
    private static final TypographyKeyTokens SupportingTextFont;

    static {
        DialogTokens.INSTANCE = new DialogTokens();
        DialogTokens.ActionFocusLabelTextColor = ColorSchemeKeyTokens.Primary;
        DialogTokens.ActionHoverLabelTextColor = ColorSchemeKeyTokens.Primary;
        DialogTokens.ActionLabelTextColor = ColorSchemeKeyTokens.Primary;
        DialogTokens.ActionLabelTextFont = TypographyKeyTokens.LabelLarge;
        DialogTokens.ActionPressedLabelTextColor = ColorSchemeKeyTokens.Primary;
        DialogTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        DialogTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        DialogTokens.ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        DialogTokens.HeadlineColor = ColorSchemeKeyTokens.OnSurface;
        DialogTokens.HeadlineFont = TypographyKeyTokens.HeadlineSmall;
        DialogTokens.SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        DialogTokens.SupportingTextFont = TypographyKeyTokens.BodyMedium;
        DialogTokens.IconColor = ColorSchemeKeyTokens.Secondary;
        DialogTokens.IconSize = Dp.constructor-impl(24f);
    }

    private DialogTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getActionFocusLabelTextColor() {
        return DialogTokens.ActionFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActionHoverLabelTextColor() {
        return DialogTokens.ActionHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActionLabelTextColor() {
        return DialogTokens.ActionLabelTextColor;
    }

    public final TypographyKeyTokens getActionLabelTextFont() {
        return DialogTokens.ActionLabelTextFont;
    }

    public final ColorSchemeKeyTokens getActionPressedLabelTextColor() {
        return DialogTokens.ActionPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return DialogTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return DialogTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return DialogTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return DialogTokens.HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return DialogTokens.HeadlineFont;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return DialogTokens.IconColor;
    }

    public final float getIconSize-D9Ej5fM() {
        return DialogTokens.IconSize;
    }

    public final ColorSchemeKeyTokens getSupportingTextColor() {
        return DialogTokens.SupportingTextColor;
    }

    public final TypographyKeyTokens getSupportingTextFont() {
        return DialogTokens.SupportingTextFont;
    }
}

