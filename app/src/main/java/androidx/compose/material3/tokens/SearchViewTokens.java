package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u0007R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0014\u0010\u000BR\u0011\u0010\u0015\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0017\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0018\u0010\u000BR\u0011\u0010\u0019\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0007R\u0011\u0010\u001B\u001A\u00020\u001C¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\u001F\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0007R\u0011\u0010!\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0007R\u0011\u0010#\u001A\u00020\u001C¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001ER\u0011\u0010%\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u0007¨\u0006\'"}, d2={"Landroidx/compose/material3/tokens/SearchViewTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "DividerColor", "getDividerColor", "DockedContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getDockedContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DockedHeaderContainerHeight", "getDockedHeaderContainerHeight-D9Ej5fM", "FullScreenContainerShape", "getFullScreenContainerShape", "FullScreenHeaderContainerHeight", "getFullScreenHeaderContainerHeight-D9Ej5fM", "HeaderInputTextColor", "getHeaderInputTextColor", "HeaderInputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeaderInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "HeaderLeadingIconColor", "getHeaderLeadingIconColor", "HeaderSupportingTextColor", "getHeaderSupportingTextColor", "HeaderSupportingTextFont", "getHeaderSupportingTextFont", "HeaderTrailingIconColor", "getHeaderTrailingIconColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SearchViewTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ColorSchemeKeyTokens DividerColor;
    private static final ShapeKeyTokens DockedContainerShape;
    private static final float DockedHeaderContainerHeight;
    private static final ShapeKeyTokens FullScreenContainerShape;
    private static final float FullScreenHeaderContainerHeight;
    private static final ColorSchemeKeyTokens HeaderInputTextColor;
    private static final TypographyKeyTokens HeaderInputTextFont;
    private static final ColorSchemeKeyTokens HeaderLeadingIconColor;
    private static final ColorSchemeKeyTokens HeaderSupportingTextColor;
    private static final TypographyKeyTokens HeaderSupportingTextFont;
    private static final ColorSchemeKeyTokens HeaderTrailingIconColor;
    public static final SearchViewTokens INSTANCE;

    static {
        SearchViewTokens.INSTANCE = new SearchViewTokens();
        SearchViewTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        SearchViewTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        SearchViewTokens.DividerColor = ColorSchemeKeyTokens.Outline;
        SearchViewTokens.DockedContainerShape = ShapeKeyTokens.CornerExtraLarge;
        SearchViewTokens.DockedHeaderContainerHeight = Dp.constructor-impl(56f);
        SearchViewTokens.FullScreenContainerShape = ShapeKeyTokens.CornerNone;
        SearchViewTokens.FullScreenHeaderContainerHeight = Dp.constructor-impl(72f);
        SearchViewTokens.HeaderInputTextColor = ColorSchemeKeyTokens.OnSurface;
        SearchViewTokens.HeaderInputTextFont = TypographyKeyTokens.BodyLarge;
        SearchViewTokens.HeaderLeadingIconColor = ColorSchemeKeyTokens.OnSurface;
        SearchViewTokens.HeaderSupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SearchViewTokens.HeaderSupportingTextFont = TypographyKeyTokens.BodyLarge;
        SearchViewTokens.HeaderTrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    private SearchViewTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return SearchViewTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return SearchViewTokens.ContainerElevation;
    }

    public final ColorSchemeKeyTokens getDividerColor() {
        return SearchViewTokens.DividerColor;
    }

    public final ShapeKeyTokens getDockedContainerShape() {
        return SearchViewTokens.DockedContainerShape;
    }

    public final float getDockedHeaderContainerHeight-D9Ej5fM() {
        return SearchViewTokens.DockedHeaderContainerHeight;
    }

    public final ShapeKeyTokens getFullScreenContainerShape() {
        return SearchViewTokens.FullScreenContainerShape;
    }

    public final float getFullScreenHeaderContainerHeight-D9Ej5fM() {
        return SearchViewTokens.FullScreenHeaderContainerHeight;
    }

    public final ColorSchemeKeyTokens getHeaderInputTextColor() {
        return SearchViewTokens.HeaderInputTextColor;
    }

    public final TypographyKeyTokens getHeaderInputTextFont() {
        return SearchViewTokens.HeaderInputTextFont;
    }

    public final ColorSchemeKeyTokens getHeaderLeadingIconColor() {
        return SearchViewTokens.HeaderLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return SearchViewTokens.HeaderSupportingTextColor;
    }

    public final TypographyKeyTokens getHeaderSupportingTextFont() {
        return SearchViewTokens.HeaderSupportingTextFont;
    }

    public final ColorSchemeKeyTokens getHeaderTrailingIconColor() {
        return SearchViewTokens.HeaderTrailingIconColor;
    }
}

