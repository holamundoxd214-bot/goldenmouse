package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2={"Landroidx/compose/material3/tokens/ConnectedButtonGroupSmallTokens;", "", "<init>", "()V", "BetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getBetweenSpace-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "InnerCornerCornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "getInnerCornerCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "PressedInnerCornerCornerSize", "getPressedInnerCornerCornerSize", "SelectedInnerCornerCornerSizePercent", "", "getSelectedInnerCornerCornerSizePercent", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ConnectedButtonGroupSmallTokens {
    public static final int $stable;
    private static final float BetweenSpace;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    public static final ConnectedButtonGroupSmallTokens INSTANCE;
    private static final CornerSize InnerCornerCornerSize;
    private static final CornerSize PressedInnerCornerCornerSize;
    private static final float SelectedInnerCornerCornerSizePercent;

    static {
        ConnectedButtonGroupSmallTokens.INSTANCE = new ConnectedButtonGroupSmallTokens();
        ConnectedButtonGroupSmallTokens.BetweenSpace = Dp.constructor-impl(2f);
        ConnectedButtonGroupSmallTokens.ContainerHeight = Dp.constructor-impl(40f);
        ConnectedButtonGroupSmallTokens.ContainerShape = ShapeKeyTokens.CornerFull;
        ConnectedButtonGroupSmallTokens.InnerCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueSmall();
        ConnectedButtonGroupSmallTokens.PressedInnerCornerCornerSize = ShapeTokens.INSTANCE.getCornerValueExtraSmall();
        ConnectedButtonGroupSmallTokens.SelectedInnerCornerCornerSizePercent = 50f;
    }

    private ConnectedButtonGroupSmallTokens() {
        super();
    }

    public final float getBetweenSpace-D9Ej5fM() {
        return ConnectedButtonGroupSmallTokens.BetweenSpace;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return ConnectedButtonGroupSmallTokens.ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ConnectedButtonGroupSmallTokens.ContainerShape;
    }

    public final CornerSize getInnerCornerCornerSize() {
        return ConnectedButtonGroupSmallTokens.InnerCornerCornerSize;
    }

    public final CornerSize getPressedInnerCornerCornerSize() {
        return ConnectedButtonGroupSmallTokens.PressedInnerCornerCornerSize;
    }

    public final float getSelectedInnerCornerCornerSizePercent() {
        return ConnectedButtonGroupSmallTokens.SelectedInnerCornerCornerSizePercent;
    }
}

