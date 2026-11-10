package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\fR\u0013\u0010\u0015\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"Landroidx/compose/material3/tokens/NavigationRailExpandedTokens;", "", "<init>", "()V", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerWidthMaximum", "getContainerWidthMaximum-D9Ej5fM", "ContainerWidthMinimum", "getContainerWidthMinimum-D9Ej5fM", "ModalContainerElevation", "getModalContainerElevation-D9Ej5fM", "ModalContainerShape", "getModalContainerShape", "TopSpace", "getTopSpace-D9Ej5fM", "ModalContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getModalContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationRailExpandedTokens {
    public static final int $stable;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final float ContainerWidthMaximum;
    private static final float ContainerWidthMinimum;
    public static final NavigationRailExpandedTokens INSTANCE;
    private static final ColorSchemeKeyTokens ModalContainerColor;
    private static final float ModalContainerElevation;
    private static final ShapeKeyTokens ModalContainerShape;
    private static final float TopSpace;

    static {
        NavigationRailExpandedTokens.INSTANCE = new NavigationRailExpandedTokens();
        NavigationRailExpandedTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        NavigationRailExpandedTokens.ContainerShape = ShapeKeyTokens.CornerNone;
        NavigationRailExpandedTokens.ContainerWidthMaximum = Dp.constructor-impl(360f);
        NavigationRailExpandedTokens.ContainerWidthMinimum = Dp.constructor-impl(220f);
        NavigationRailExpandedTokens.ModalContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        NavigationRailExpandedTokens.ModalContainerShape = ShapeKeyTokens.CornerLarge;
        NavigationRailExpandedTokens.TopSpace = Dp.constructor-impl(44f);
        NavigationRailExpandedTokens.ModalContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
    }

    private NavigationRailExpandedTokens() {
        super();
    }

    public final float getContainerElevation-D9Ej5fM() {
        return NavigationRailExpandedTokens.ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return NavigationRailExpandedTokens.ContainerShape;
    }

    public final float getContainerWidthMaximum-D9Ej5fM() {
        return NavigationRailExpandedTokens.ContainerWidthMaximum;
    }

    public final float getContainerWidthMinimum-D9Ej5fM() {
        return NavigationRailExpandedTokens.ContainerWidthMinimum;
    }

    public final ColorSchemeKeyTokens getModalContainerColor() {
        return NavigationRailExpandedTokens.ModalContainerColor;
    }

    public final float getModalContainerElevation-D9Ej5fM() {
        return NavigationRailExpandedTokens.ModalContainerElevation;
    }

    public final ShapeKeyTokens getModalContainerShape() {
        return NavigationRailExpandedTokens.ModalContainerShape;
    }

    public final float getTopSpace-D9Ej5fM() {
        return NavigationRailExpandedTokens.TopSpace;
    }
}

