package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u000F\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0010\u0010\u000BR\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0018\u0010\u000B¨\u0006\u0019"}, d2={"Landroidx/compose/material3/tokens/DockedToolbarTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerLeadingSpace", "getContainerLeadingSpace-D9Ej5fM", "ContainerMaxSpacing", "getContainerMaxSpacing-D9Ej5fM", "ContainerMinSpacing", "getContainerMinSpacing-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerTrailingSpace", "getContainerTrailingSpace-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DockedToolbarTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerHeight;
    private static final float ContainerLeadingSpace;
    private static final float ContainerMaxSpacing;
    private static final float ContainerMinSpacing;
    private static final ShapeKeyTokens ContainerShape;
    private static final float ContainerTrailingSpace;
    public static final DockedToolbarTokens INSTANCE;

    static {
        DockedToolbarTokens.INSTANCE = new DockedToolbarTokens();
        DockedToolbarTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        DockedToolbarTokens.ContainerHeight = Dp.constructor-impl(64f);
        DockedToolbarTokens.ContainerLeadingSpace = Dp.constructor-impl(16f);
        DockedToolbarTokens.ContainerMaxSpacing = Dp.constructor-impl(32f);
        DockedToolbarTokens.ContainerMinSpacing = Dp.constructor-impl(4f);
        DockedToolbarTokens.ContainerShape = ShapeKeyTokens.CornerNone;
        DockedToolbarTokens.ContainerTrailingSpace = Dp.constructor-impl(16f);
    }

    private DockedToolbarTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return DockedToolbarTokens.ContainerColor;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return DockedToolbarTokens.ContainerHeight;
    }

    public final float getContainerLeadingSpace-D9Ej5fM() {
        return DockedToolbarTokens.ContainerLeadingSpace;
    }

    public final float getContainerMaxSpacing-D9Ej5fM() {
        return DockedToolbarTokens.ContainerMaxSpacing;
    }

    public final float getContainerMinSpacing-D9Ej5fM() {
        return DockedToolbarTokens.ContainerMinSpacing;
    }

    public final ShapeKeyTokens getContainerShape() {
        return DockedToolbarTokens.ContainerShape;
    }

    public final float getContainerTrailingSpace-D9Ej5fM() {
        return DockedToolbarTokens.ContainerTrailingSpace;
    }
}

