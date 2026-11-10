package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/material3/tokens/NavigationBarVerticalItemTokens;", "", "<init>", "()V", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", "F", "ActiveIndicatorWidth", "getActiveIndicatorWidth-D9Ej5fM", "ContainerBetweenSpace", "getContainerBetweenSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationBarVerticalItemTokens {
    public static final int $stable;
    private static final float ActiveIndicatorHeight;
    private static final float ActiveIndicatorWidth;
    private static final float ContainerBetweenSpace;
    public static final NavigationBarVerticalItemTokens INSTANCE;
    private static final float IconSize;

    static {
        NavigationBarVerticalItemTokens.INSTANCE = new NavigationBarVerticalItemTokens();
        NavigationBarVerticalItemTokens.ActiveIndicatorHeight = Dp.constructor-impl(32f);
        NavigationBarVerticalItemTokens.ActiveIndicatorWidth = Dp.constructor-impl(56f);
        NavigationBarVerticalItemTokens.ContainerBetweenSpace = Dp.constructor-impl(6f);
        NavigationBarVerticalItemTokens.IconSize = Dp.constructor-impl(24f);
    }

    private NavigationBarVerticalItemTokens() {
        super();
    }

    public final float getActiveIndicatorHeight-D9Ej5fM() {
        return NavigationBarVerticalItemTokens.ActiveIndicatorHeight;
    }

    public final float getActiveIndicatorWidth-D9Ej5fM() {
        return NavigationBarVerticalItemTokens.ActiveIndicatorWidth;
    }

    public final float getContainerBetweenSpace-D9Ej5fM() {
        return NavigationBarVerticalItemTokens.ContainerBetweenSpace;
    }

    public final float getIconSize-D9Ej5fM() {
        return NavigationBarVerticalItemTokens.IconSize;
    }
}

