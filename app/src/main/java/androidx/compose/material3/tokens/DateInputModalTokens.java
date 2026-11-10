package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0016\u0010\u000BR\u0013\u0010\u0017\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0018\u0010\u000BR\u0013\u0010\u0019\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001A\u0010\u000BR\u0011\u0010\u001B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0007R\u0011\u0010\u001D\u001A\u00020\u001E¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0011\u0010!\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0007R\u0011\u0010#\u001A\u00020\u001E¢\u0006\b\n\u0000\u001A\u0004\b$\u0010 ¨\u0006%"}, d2={"Landroidx/compose/material3/tokens/DateInputModalTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerSurfaceTintLayerColor", "getContainerSurfaceTintLayerColor", "ContainerWidth", "getContainerWidth-D9Ej5fM", "HeaderContainerHeight", "getHeaderContainerHeight-D9Ej5fM", "HeaderContainerWidth", "getHeaderContainerWidth-D9Ej5fM", "HeaderHeadlineColor", "getHeaderHeadlineColor", "HeaderHeadlineFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeaderHeadlineFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "HeaderSupportingTextColor", "getHeaderSupportingTextColor", "HeaderSupportingTextFont", "getHeaderSupportingTextFont", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DateInputModalTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens ContainerSurfaceTintLayerColor;
    private static final float ContainerWidth;
    private static final float HeaderContainerHeight;
    private static final float HeaderContainerWidth;
    private static final ColorSchemeKeyTokens HeaderHeadlineColor;
    private static final TypographyKeyTokens HeaderHeadlineFont;
    private static final ColorSchemeKeyTokens HeaderSupportingTextColor;
    private static final TypographyKeyTokens HeaderSupportingTextFont;
    public static final DateInputModalTokens INSTANCE;

    static {
        DateInputModalTokens.INSTANCE = new DateInputModalTokens();
        DateInputModalTokens.ContainerColor = ColorSchemeKeyTokens.Surface;
        DateInputModalTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        DateInputModalTokens.ContainerHeight = Dp.constructor-impl(512f);
        DateInputModalTokens.ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        DateInputModalTokens.ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
        DateInputModalTokens.ContainerWidth = Dp.constructor-impl(328f);
        DateInputModalTokens.HeaderContainerHeight = Dp.constructor-impl(120f);
        DateInputModalTokens.HeaderContainerWidth = Dp.constructor-impl(328f);
        DateInputModalTokens.HeaderHeadlineColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        DateInputModalTokens.HeaderHeadlineFont = TypographyKeyTokens.HeadlineLarge;
        DateInputModalTokens.HeaderSupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        DateInputModalTokens.HeaderSupportingTextFont = TypographyKeyTokens.LabelLarge;
    }

    private DateInputModalTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return DateInputModalTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return DateInputModalTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return DateInputModalTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return DateInputModalTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return DateInputModalTokens.ContainerSurfaceTintLayerColor;
    }

    public final float getContainerWidth-D9Ej5fM() {
        return DateInputModalTokens.ContainerWidth;
    }

    public final float getHeaderContainerHeight-D9Ej5fM() {
        return DateInputModalTokens.HeaderContainerHeight;
    }

    public final float getHeaderContainerWidth-D9Ej5fM() {
        return DateInputModalTokens.HeaderContainerWidth;
    }

    public final ColorSchemeKeyTokens getHeaderHeadlineColor() {
        return DateInputModalTokens.HeaderHeadlineColor;
    }

    public final TypographyKeyTokens getHeaderHeadlineFont() {
        return DateInputModalTokens.HeaderHeadlineFont;
    }

    public final ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return DateInputModalTokens.HeaderSupportingTextColor;
    }

    public final TypographyKeyTokens getHeaderSupportingTextFont() {
        return DateInputModalTokens.HeaderSupportingTextFont;
    }
}

