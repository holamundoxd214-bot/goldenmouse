package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u0007R\u0011\u0010\u000F\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0018\u0010\u000B¨\u0006\u0019"}, d2={"Landroidx/compose/material3/tokens/LoadingIndicatorTokens;", "", "<init>", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveSize", "Landroidx/compose/ui/unit/Dp;", "getActiveSize-D9Ej5fM", "()F", "F", "ContainedActiveColor", "getContainedActiveColor", "ContainedContainerColor", "getContainedContainerColor", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LoadingIndicatorTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final float ActiveSize;
    private static final ColorSchemeKeyTokens ContainedActiveColor;
    private static final ColorSchemeKeyTokens ContainedContainerColor;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    private static final float ContainerWidth;
    public static final LoadingIndicatorTokens INSTANCE;

    static {
        LoadingIndicatorTokens.INSTANCE = new LoadingIndicatorTokens();
        LoadingIndicatorTokens.ActiveIndicatorColor = ColorSchemeKeyTokens.Primary;
        LoadingIndicatorTokens.ActiveSize = Dp.constructor-impl(38f);
        LoadingIndicatorTokens.ContainedActiveColor = ColorSchemeKeyTokens.OnPrimaryContainer;
        LoadingIndicatorTokens.ContainedContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
        LoadingIndicatorTokens.ContainerHeight = Dp.constructor-impl(48f);
        LoadingIndicatorTokens.ContainerShape = ShapeKeyTokens.CornerFull;
        LoadingIndicatorTokens.ContainerWidth = Dp.constructor-impl(48f);
    }

    private LoadingIndicatorTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return LoadingIndicatorTokens.ActiveIndicatorColor;
    }

    public final float getActiveSize-D9Ej5fM() {
        return LoadingIndicatorTokens.ActiveSize;
    }

    public final ColorSchemeKeyTokens getContainedActiveColor() {
        return LoadingIndicatorTokens.ContainedActiveColor;
    }

    public final ColorSchemeKeyTokens getContainedContainerColor() {
        return LoadingIndicatorTokens.ContainedContainerColor;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return LoadingIndicatorTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return LoadingIndicatorTokens.ContainerShape;
    }

    public final float getContainerWidth-D9Ej5fM() {
        return LoadingIndicatorTokens.ContainerWidth;
    }
}

