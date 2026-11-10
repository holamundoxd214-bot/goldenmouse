package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2={"Landroidx/compose/material3/tokens/ExtendedFabLargeTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "IconLabelSpace", "getIconLabelSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LeadingSpace", "getLeadingSpace-D9Ej5fM", "TrailingSpace", "getTrailingSpace-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExtendedFabLargeTokens {
    public static final int $stable;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    public static final ExtendedFabLargeTokens INSTANCE;
    private static final float IconLabelSpace;
    private static final float IconSize;
    private static final float LeadingSpace;
    private static final float TrailingSpace;

    static {
        ExtendedFabLargeTokens.INSTANCE = new ExtendedFabLargeTokens();
        ExtendedFabLargeTokens.ContainerHeight = Dp.constructor-impl(96f);
        ExtendedFabLargeTokens.ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        ExtendedFabLargeTokens.IconLabelSpace = Dp.constructor-impl(20f);
        ExtendedFabLargeTokens.IconSize = Dp.constructor-impl(32f);
        ExtendedFabLargeTokens.LeadingSpace = Dp.constructor-impl(28f);
        ExtendedFabLargeTokens.TrailingSpace = Dp.constructor-impl(28f);
    }

    private ExtendedFabLargeTokens() {
        super();
    }

    public final float getContainerHeight-D9Ej5fM() {
        return ExtendedFabLargeTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ExtendedFabLargeTokens.ContainerShape;
    }

    public final float getIconLabelSpace-D9Ej5fM() {
        return ExtendedFabLargeTokens.IconLabelSpace;
    }

    public final float getIconSize-D9Ej5fM() {
        return ExtendedFabLargeTokens.IconSize;
    }

    public final float getLeadingSpace-D9Ej5fM() {
        return ExtendedFabLargeTokens.LeadingSpace;
    }

    public final float getTrailingSpace-D9Ej5fM() {
        return ExtendedFabLargeTokens.TrailingSpace;
    }
}

