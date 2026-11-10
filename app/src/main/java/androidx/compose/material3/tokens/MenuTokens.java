package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0007R\u0011\u0010\u0019\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/material3/tokens/MenuTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "FocusIndicatorColor", "getFocusIndicatorColor", "ListItemSelectedContainerColor", "getListItemSelectedContainerColor", "ListItemSelectedLabelTextColor", "getListItemSelectedLabelTextColor", "ListItemSelectedLeadingTrailingIconColor", "getListItemSelectedLeadingTrailingIconColor", "MenuListItemLeadingIconColor", "getMenuListItemLeadingIconColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MenuTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens FocusIndicatorColor;
    public static final MenuTokens INSTANCE;
    private static final ColorSchemeKeyTokens ListItemSelectedContainerColor;
    private static final ColorSchemeKeyTokens ListItemSelectedLabelTextColor;
    private static final ColorSchemeKeyTokens ListItemSelectedLeadingTrailingIconColor;
    private static final ColorSchemeKeyTokens MenuListItemLeadingIconColor;

    static {
        MenuTokens.INSTANCE = new MenuTokens();
        MenuTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        MenuTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        MenuTokens.ContainerShape = ShapeKeyTokens.CornerExtraSmall;
        MenuTokens.FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        MenuTokens.ListItemSelectedContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
        MenuTokens.ListItemSelectedLabelTextColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        MenuTokens.ListItemSelectedLeadingTrailingIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        MenuTokens.MenuListItemLeadingIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
    }

    private MenuTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return MenuTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return MenuTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return MenuTokens.ContainerShape;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return MenuTokens.FocusIndicatorColor;
    }

    public final ColorSchemeKeyTokens getListItemSelectedContainerColor() {
        return MenuTokens.ListItemSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getListItemSelectedLabelTextColor() {
        return MenuTokens.ListItemSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getListItemSelectedLeadingTrailingIconColor() {
        return MenuTokens.ListItemSelectedLeadingTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getMenuListItemLeadingIconColor() {
        return MenuTokens.MenuListItemLeadingIconColor;
    }
}

