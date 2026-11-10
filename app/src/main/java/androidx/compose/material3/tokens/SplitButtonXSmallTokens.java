package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0007\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0017\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001A\u0010\u0007R\u0014\u0010\u001B\u001A\u00020\u001CX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007R\u0013\u0010\u001E\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001F\u0010\u0007R\u0014\u0010 \u001A\u00020\u001CX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0007R\u0013\u0010\"\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b#\u0010\u0007R\u0013\u0010$\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b%\u0010\u0007¨\u0006&"}, d2={"Landroidx/compose/material3/tokens/SplitButtonXSmallTokens;", "", "<init>", "()V", "BetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getBetweenSpace-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "InnerCornerCornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "getInnerCornerCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "InnerHoveredCornerCornerSize", "getInnerHoveredCornerCornerSize", "InnerPressedCornerCornerSize", "getInnerPressedCornerCornerSize", "LeadingButtonLeadingSpace", "getLeadingButtonLeadingSpace-D9Ej5fM", "LeadingButtonTrailingSpace", "getLeadingButtonTrailingSpace-D9Ej5fM", "OuterCornerCornerSizePercent", "", "getOuterCornerCornerSizePercent", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "TrailingInnerSelectedCornerCornerSizePercent", "getTrailingInnerSelectedCornerCornerSizePercent", "TrailingButtonLeadingSpace", "getTrailingButtonLeadingSpace-D9Ej5fM", "TrailingButtonTrailingSpace", "getTrailingButtonTrailingSpace-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitButtonXSmallTokens {
    public static final int $stable;
    private static final float BetweenSpace;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    public static final SplitButtonXSmallTokens INSTANCE;
    private static final CornerSize InnerCornerCornerSize;
    private static final CornerSize InnerHoveredCornerCornerSize;
    private static final CornerSize InnerPressedCornerCornerSize;
    private static final float LeadingButtonLeadingSpace;
    private static final float LeadingButtonTrailingSpace;
    private static final float OuterCornerCornerSizePercent;
    private static final float TrailingButtonLeadingSpace;
    private static final float TrailingButtonTrailingSpace;
    private static final float TrailingIconSize;
    private static final float TrailingInnerSelectedCornerCornerSizePercent;

    static {
        SplitButtonXSmallTokens.INSTANCE = new SplitButtonXSmallTokens();
        SplitButtonXSmallTokens.BetweenSpace = Dp.constructor-impl(2f);
        SplitButtonXSmallTokens.ContainerHeight = Dp.constructor-impl(32f);
        SplitButtonXSmallTokens.ContainerShape = ShapeKeyTokens.CornerFull;
        SplitButtonXSmallTokens.InnerCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueExtraSmall();
        SplitButtonXSmallTokens.InnerHoveredCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueSmall();
        SplitButtonXSmallTokens.InnerPressedCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueSmall();
        SplitButtonXSmallTokens.LeadingButtonLeadingSpace = Dp.constructor-impl(12f);
        SplitButtonXSmallTokens.LeadingButtonTrailingSpace = Dp.constructor-impl(10f);
        SplitButtonXSmallTokens.OuterCornerCornerSizePercent = 50f;
        SplitButtonXSmallTokens.TrailingIconSize = Dp.constructor-impl(22f);
        SplitButtonXSmallTokens.TrailingInnerSelectedCornerCornerSizePercent = 50f;
        SplitButtonXSmallTokens.TrailingButtonLeadingSpace = Dp.constructor-impl(13f);
        SplitButtonXSmallTokens.TrailingButtonTrailingSpace = Dp.constructor-impl(13f);
    }

    private SplitButtonXSmallTokens() {
        super();
    }

    public final float getBetweenSpace-D9Ej5fM() {
        return SplitButtonXSmallTokens.BetweenSpace;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return SplitButtonXSmallTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return SplitButtonXSmallTokens.ContainerShape;
    }

    public final CornerSize getInnerCornerCornerSize() {
        return SplitButtonXSmallTokens.InnerCornerCornerSize;
    }

    public final CornerSize getInnerHoveredCornerCornerSize() {
        return SplitButtonXSmallTokens.InnerHoveredCornerCornerSize;
    }

    public final CornerSize getInnerPressedCornerCornerSize() {
        return SplitButtonXSmallTokens.InnerPressedCornerCornerSize;
    }

    public final float getLeadingButtonLeadingSpace-D9Ej5fM() {
        return SplitButtonXSmallTokens.LeadingButtonLeadingSpace;
    }

    public final float getLeadingButtonTrailingSpace-D9Ej5fM() {
        return SplitButtonXSmallTokens.LeadingButtonTrailingSpace;
    }

    public final float getOuterCornerCornerSizePercent() {
        return SplitButtonXSmallTokens.OuterCornerCornerSizePercent;
    }

    public final float getTrailingButtonLeadingSpace-D9Ej5fM() {
        return SplitButtonXSmallTokens.TrailingButtonLeadingSpace;
    }

    public final float getTrailingButtonTrailingSpace-D9Ej5fM() {
        return SplitButtonXSmallTokens.TrailingButtonTrailingSpace;
    }

    public final float getTrailingIconSize-D9Ej5fM() {
        return SplitButtonXSmallTokens.TrailingIconSize;
    }

    public final float getTrailingInnerSelectedCornerCornerSizePercent() {
        return SplitButtonXSmallTokens.TrailingInnerSelectedCornerCornerSizePercent;
    }
}

