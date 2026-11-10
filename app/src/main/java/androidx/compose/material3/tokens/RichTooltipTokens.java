package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0013\u0010\u0014\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001A\u00020\u001A¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u001D\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0007R\u0011\u0010\u001F\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u000FR\u0011\u0010!\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0007R\u0011\u0010#\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u000F¨\u0006%"}, d2={"Landroidx/compose/material3/tokens/RichTooltipTokens;", "", "<init>", "()V", "ActionFocusLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActionFocusLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActionHoverLabelTextColor", "getActionHoverLabelTextColor", "ActionLabelTextColor", "getActionLabelTextColor", "ActionLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getActionLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ActionPressedLabelTextColor", "getActionPressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "SubheadColor", "getSubheadColor", "SubheadFont", "getSubheadFont", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "getSupportingTextFont", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RichTooltipTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ActionFocusLabelTextColor;
    private static final ColorSchemeKeyTokens ActionHoverLabelTextColor;
    private static final ColorSchemeKeyTokens ActionLabelTextColor;
    private static final TypographyKeyTokens ActionLabelTextFont;
    private static final ColorSchemeKeyTokens ActionPressedLabelTextColor;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    public static final RichTooltipTokens INSTANCE;
    private static final ColorSchemeKeyTokens SubheadColor;
    private static final TypographyKeyTokens SubheadFont;
    private static final ColorSchemeKeyTokens SupportingTextColor;
    private static final TypographyKeyTokens SupportingTextFont;

    static {
        RichTooltipTokens.INSTANCE = new RichTooltipTokens();
        RichTooltipTokens.ActionFocusLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ActionHoverLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ActionLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ActionLabelTextFont = TypographyKeyTokens.LabelLarge;
        RichTooltipTokens.ActionPressedLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        RichTooltipTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        RichTooltipTokens.ContainerShape = ShapeKeyTokens.CornerMedium;
        RichTooltipTokens.SubheadColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        RichTooltipTokens.SubheadFont = TypographyKeyTokens.TitleSmall;
        RichTooltipTokens.SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        RichTooltipTokens.SupportingTextFont = TypographyKeyTokens.BodyMedium;
    }

    private RichTooltipTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getActionFocusLabelTextColor() {
        return RichTooltipTokens.ActionFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActionHoverLabelTextColor() {
        return RichTooltipTokens.ActionHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActionLabelTextColor() {
        return RichTooltipTokens.ActionLabelTextColor;
    }

    public final TypographyKeyTokens getActionLabelTextFont() {
        return RichTooltipTokens.ActionLabelTextFont;
    }

    public final ColorSchemeKeyTokens getActionPressedLabelTextColor() {
        return RichTooltipTokens.ActionPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return RichTooltipTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return RichTooltipTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return RichTooltipTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getSubheadColor() {
        return RichTooltipTokens.SubheadColor;
    }

    public final TypographyKeyTokens getSubheadFont() {
        return RichTooltipTokens.SubheadFont;
    }

    public final ColorSchemeKeyTokens getSupportingTextColor() {
        return RichTooltipTokens.SupportingTextColor;
    }

    public final TypographyKeyTokens getSupportingTextFont() {
        return RichTooltipTokens.SupportingTextFont;
    }
}

