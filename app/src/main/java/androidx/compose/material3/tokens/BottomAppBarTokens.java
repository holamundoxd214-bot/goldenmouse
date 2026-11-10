package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/material3/tokens/BottomAppBarTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BottomAppBarTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    public static final BottomAppBarTokens INSTANCE;

    static {
        BottomAppBarTokens.INSTANCE = new BottomAppBarTokens();
        BottomAppBarTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        BottomAppBarTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        BottomAppBarTokens.ContainerHeight = Dp.constructor-impl(80f);
        BottomAppBarTokens.ContainerShape = ShapeKeyTokens.CornerNone;
    }

    private BottomAppBarTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return BottomAppBarTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return BottomAppBarTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return BottomAppBarTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return BottomAppBarTokens.ContainerShape;
    }
}

