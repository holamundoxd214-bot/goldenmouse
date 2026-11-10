package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0017\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001A\u0010\u0007R\u0013\u0010\u001B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001C\u0010\u0007R\u0014\u0010\u001D\u001A\u00020\u001EX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0007R\u0013\u0010 \u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b!\u0010\u0007R\u0013\u0010\"\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b#\u0010\u0007¨\u0006$"}, d2={"Landroidx/compose/material3/tokens/SplitButtonLargeTokens;", "", "<init>", "()V", "BetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getBetweenSpace-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "InnerCornerCornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "getInnerCornerCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "InnerHoveredCornerCornerSize", "getInnerHoveredCornerCornerSize", "InnerPressedCornerCornerSize", "getInnerPressedCornerCornerSize", "LeadingButtonLeadingSpace", "getLeadingButtonLeadingSpace-D9Ej5fM", "LeadingButtonTrailingSpace", "getLeadingButtonTrailingSpace-D9Ej5fM", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "TrailingInnerSelectedCornerCornerSizePercent", "", "getTrailingInnerSelectedCornerCornerSizePercent", "TrailingButtonLeadingSpace", "getTrailingButtonLeadingSpace-D9Ej5fM", "TrailingButtonTrailingSpace", "getTrailingButtonTrailingSpace-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitButtonLargeTokens {
    public static final int $stable;
    private static final float BetweenSpace;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    public static final SplitButtonLargeTokens INSTANCE;
    private static final CornerSize InnerCornerCornerSize;
    private static final CornerSize InnerHoveredCornerCornerSize;
    private static final CornerSize InnerPressedCornerCornerSize;
    private static final float LeadingButtonLeadingSpace;
    private static final float LeadingButtonTrailingSpace;
    private static final float TrailingButtonLeadingSpace;
    private static final float TrailingButtonTrailingSpace;
    private static final float TrailingIconSize;
    private static final float TrailingInnerSelectedCornerCornerSizePercent;

    static {
        SplitButtonLargeTokens.INSTANCE = new SplitButtonLargeTokens();
        SplitButtonLargeTokens.BetweenSpace = Dp.constructor-impl(2f);
        SplitButtonLargeTokens.ContainerHeight = Dp.constructor-impl(96f);
        SplitButtonLargeTokens.ContainerShape = ShapeKeyTokens.CornerFull;
        SplitButtonLargeTokens.InnerCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueSmall();
        SplitButtonLargeTokens.InnerHoveredCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueLargeIncreased();
        SplitButtonLargeTokens.InnerPressedCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueLargeIncreased();
        SplitButtonLargeTokens.LeadingButtonLeadingSpace = Dp.constructor-impl(48f);
        SplitButtonLargeTokens.LeadingButtonTrailingSpace = Dp.constructor-impl(48f);
        SplitButtonLargeTokens.TrailingIconSize = Dp.constructor-impl(38f);
        SplitButtonLargeTokens.TrailingInnerSelectedCornerCornerSizePercent = 50f;
        SplitButtonLargeTokens.TrailingButtonLeadingSpace = Dp.constructor-impl(29f);
        SplitButtonLargeTokens.TrailingButtonTrailingSpace = Dp.constructor-impl(29f);
    }

    private SplitButtonLargeTokens() {
        super();
    }

    public final float getBetweenSpace-D9Ej5fM() {
        return SplitButtonLargeTokens.BetweenSpace;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return SplitButtonLargeTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return SplitButtonLargeTokens.ContainerShape;
    }

    public final CornerSize getInnerCornerCornerSize() {
        return SplitButtonLargeTokens.InnerCornerCornerSize;
    }

    public final CornerSize getInnerHoveredCornerCornerSize() {
        return SplitButtonLargeTokens.InnerHoveredCornerCornerSize;
    }

    public final CornerSize getInnerPressedCornerCornerSize() {
        return SplitButtonLargeTokens.InnerPressedCornerCornerSize;
    }

    public final float getLeadingButtonLeadingSpace-D9Ej5fM() {
        return SplitButtonLargeTokens.LeadingButtonLeadingSpace;
    }

    public final float getLeadingButtonTrailingSpace-D9Ej5fM() {
        return SplitButtonLargeTokens.LeadingButtonTrailingSpace;
    }

    public final float getTrailingButtonLeadingSpace-D9Ej5fM() {
        return SplitButtonLargeTokens.TrailingButtonLeadingSpace;
    }

    public final float getTrailingButtonTrailingSpace-D9Ej5fM() {
        return SplitButtonLargeTokens.TrailingButtonTrailingSpace;
    }

    public final float getTrailingIconSize-D9Ej5fM() {
        return SplitButtonLargeTokens.TrailingIconSize;
    }

    public final float getTrailingInnerSelectedCornerCornerSizePercent() {
        return SplitButtonLargeTokens.TrailingInnerSelectedCornerCornerSizePercent;
    }
}

