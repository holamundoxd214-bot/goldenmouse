package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/material3/tokens/PlainTooltipTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getSupportingTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlainTooltipTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final ShapeKeyTokens ContainerShape;
    public static final PlainTooltipTokens INSTANCE;
    private static final ColorSchemeKeyTokens SupportingTextColor;
    private static final TypographyKeyTokens SupportingTextFont;

    static {
        PlainTooltipTokens.INSTANCE = new PlainTooltipTokens();
        PlainTooltipTokens.ContainerColor = ColorSchemeKeyTokens.InverseSurface;
        PlainTooltipTokens.ContainerShape = ShapeKeyTokens.CornerExtraSmall;
        PlainTooltipTokens.SupportingTextColor = ColorSchemeKeyTokens.InverseOnSurface;
        PlainTooltipTokens.SupportingTextFont = TypographyKeyTokens.BodySmall;
    }

    private PlainTooltipTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return PlainTooltipTokens.ContainerColor;
    }

    public final ShapeKeyTokens getContainerShape() {
        return PlainTooltipTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getSupportingTextColor() {
        return PlainTooltipTokens.SupportingTextColor;
    }

    public final TypographyKeyTokens getSupportingTextFont() {
        return PlainTooltipTokens.SupportingTextFont;
    }
}

