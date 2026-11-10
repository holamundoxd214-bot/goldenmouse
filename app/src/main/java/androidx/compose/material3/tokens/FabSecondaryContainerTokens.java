package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u000F\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u0011\u0010\u0013\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0018\u0010\u000BR\u0011\u0010\u0019\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/material3/tokens/FabSecondaryContainerTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "FocusedContainerElevation", "getFocusedContainerElevation-D9Ej5fM", "FocusedIconColor", "getFocusedIconColor", "HoveredContainerElevation", "getHoveredContainerElevation-D9Ej5fM", "HoveredIconColor", "getHoveredIconColor", "IconColor", "getIconColor", "PressedContainerElevation", "getPressedContainerElevation-D9Ej5fM", "PressedIconColor", "getPressedIconColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FabSecondaryContainerTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float FocusedContainerElevation;
    private static final ColorSchemeKeyTokens FocusedIconColor;
    private static final float HoveredContainerElevation;
    private static final ColorSchemeKeyTokens HoveredIconColor;
    public static final FabSecondaryContainerTokens INSTANCE;
    private static final ColorSchemeKeyTokens IconColor;
    private static final float PressedContainerElevation;
    private static final ColorSchemeKeyTokens PressedIconColor;

    static {
        FabSecondaryContainerTokens.INSTANCE = new FabSecondaryContainerTokens();
        FabSecondaryContainerTokens.ContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
        FabSecondaryContainerTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        FabSecondaryContainerTokens.FocusedContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        FabSecondaryContainerTokens.FocusedIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        FabSecondaryContainerTokens.HoveredContainerElevation = ElevationTokens.INSTANCE.getLevel4-D9Ej5fM();
        FabSecondaryContainerTokens.HoveredIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        FabSecondaryContainerTokens.IconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        FabSecondaryContainerTokens.PressedContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        FabSecondaryContainerTokens.PressedIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
    }

    private FabSecondaryContainerTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return FabSecondaryContainerTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return FabSecondaryContainerTokens.ContainerElevation;
    }

    public final float getFocusedContainerElevation-D9Ej5fM() {
        return FabSecondaryContainerTokens.FocusedContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusedIconColor() {
        return FabSecondaryContainerTokens.FocusedIconColor;
    }

    public final float getHoveredContainerElevation-D9Ej5fM() {
        return FabSecondaryContainerTokens.HoveredContainerElevation;
    }

    public final ColorSchemeKeyTokens getHoveredIconColor() {
        return FabSecondaryContainerTokens.HoveredIconColor;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return FabSecondaryContainerTokens.IconColor;
    }

    public final float getPressedContainerElevation-D9Ej5fM() {
        return FabSecondaryContainerTokens.PressedContainerElevation;
    }

    public final ColorSchemeKeyTokens getPressedIconColor() {
        return FabSecondaryContainerTokens.PressedIconColor;
    }
}

