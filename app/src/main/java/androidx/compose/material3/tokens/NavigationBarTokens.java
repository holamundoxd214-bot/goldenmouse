package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u000F\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0014\u0010\u000BR\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0007R\u0013\u0010\u001B\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001C\u0010\u000BR\u0011\u0010\u001D\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0007R\u0011\u0010\u001F\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0007R\u0011\u0010!\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0018R\u0013\u0010#\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b$\u0010\u000BR\u0011\u0010%\u001A\u00020&¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(¨\u0006)"}, d2={"Landroidx/compose/material3/tokens/NavigationBarTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ItemActiveIconColor", "getItemActiveIconColor", "ItemActiveIndicatorColor", "getItemActiveIndicatorColor", "ItemActiveIndicatorIconLabelSpace", "getItemActiveIndicatorIconLabelSpace-D9Ej5fM", "ItemActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getItemActiveIndicatorShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ItemActiveLabelTextColor", "getItemActiveLabelTextColor", "ItemBetweenSpace", "getItemBetweenSpace-D9Ej5fM", "ItemInactiveIconColor", "getItemInactiveIconColor", "ItemInactiveLabelTextColor", "getItemInactiveLabelTextColor", "NavShape", "getNavShape", "TallContainerHeight", "getTallContainerHeight-D9Ej5fM", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationBarTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    public static final NavigationBarTokens INSTANCE;
    private static final ColorSchemeKeyTokens ItemActiveIconColor;
    private static final ColorSchemeKeyTokens ItemActiveIndicatorColor;
    private static final float ItemActiveIndicatorIconLabelSpace;
    private static final ShapeKeyTokens ItemActiveIndicatorShape;
    private static final ColorSchemeKeyTokens ItemActiveLabelTextColor;
    private static final float ItemBetweenSpace;
    private static final ColorSchemeKeyTokens ItemInactiveIconColor;
    private static final ColorSchemeKeyTokens ItemInactiveLabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final ShapeKeyTokens NavShape;
    private static final float TallContainerHeight;

    static {
        NavigationBarTokens.INSTANCE = new NavigationBarTokens();
        NavigationBarTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        NavigationBarTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        NavigationBarTokens.ContainerHeight = Dp.constructor-impl(64f);
        NavigationBarTokens.ItemActiveIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        NavigationBarTokens.ItemActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
        NavigationBarTokens.ItemActiveIndicatorIconLabelSpace = Dp.constructor-impl(4f);
        NavigationBarTokens.ItemActiveIndicatorShape = ShapeKeyTokens.CornerFull;
        NavigationBarTokens.ItemActiveLabelTextColor = ColorSchemeKeyTokens.Secondary;
        NavigationBarTokens.ItemBetweenSpace = Dp.constructor-impl(0f);
        NavigationBarTokens.ItemInactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        NavigationBarTokens.ItemInactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        NavigationBarTokens.NavShape = ShapeKeyTokens.CornerNone;
        NavigationBarTokens.TallContainerHeight = Dp.constructor-impl(80f);
        NavigationBarTokens.LabelTextFont = TypographyKeyTokens.LabelMedium;
    }

    private NavigationBarTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return NavigationBarTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return NavigationBarTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return NavigationBarTokens.ContainerHeight;
    }

    public final ColorSchemeKeyTokens getItemActiveIconColor() {
        return NavigationBarTokens.ItemActiveIconColor;
    }

    public final ColorSchemeKeyTokens getItemActiveIndicatorColor() {
        return NavigationBarTokens.ItemActiveIndicatorColor;
    }

    public final float getItemActiveIndicatorIconLabelSpace-D9Ej5fM() {
        return NavigationBarTokens.ItemActiveIndicatorIconLabelSpace;
    }

    public final ShapeKeyTokens getItemActiveIndicatorShape() {
        return NavigationBarTokens.ItemActiveIndicatorShape;
    }

    public final ColorSchemeKeyTokens getItemActiveLabelTextColor() {
        return NavigationBarTokens.ItemActiveLabelTextColor;
    }

    public final float getItemBetweenSpace-D9Ej5fM() {
        return NavigationBarTokens.ItemBetweenSpace;
    }

    public final ColorSchemeKeyTokens getItemInactiveIconColor() {
        return NavigationBarTokens.ItemInactiveIconColor;
    }

    public final ColorSchemeKeyTokens getItemInactiveLabelTextColor() {
        return NavigationBarTokens.ItemInactiveLabelTextColor;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return NavigationBarTokens.LabelTextFont;
    }

    public final ShapeKeyTokens getNavShape() {
        return NavigationBarTokens.NavShape;
    }

    public final float getTallContainerHeight-D9Ej5fM() {
        return NavigationBarTokens.TallContainerHeight;
    }
}

