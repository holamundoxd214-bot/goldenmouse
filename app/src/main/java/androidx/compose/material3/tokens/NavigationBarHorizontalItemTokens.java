package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/material3/tokens/NavigationBarHorizontalItemTokens;", "", "<init>", "()V", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", "F", "ActiveIndicatorLeadingSpace", "getActiveIndicatorLeadingSpace-D9Ej5fM", "ActiveIndicatorTrailingSpace", "getActiveIndicatorTrailingSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationBarHorizontalItemTokens {
    public static final int $stable;
    private static final float ActiveIndicatorHeight;
    private static final float ActiveIndicatorLeadingSpace;
    private static final float ActiveIndicatorTrailingSpace;
    public static final NavigationBarHorizontalItemTokens INSTANCE;
    private static final float IconSize;

    static {
        NavigationBarHorizontalItemTokens.INSTANCE = new NavigationBarHorizontalItemTokens();
        NavigationBarHorizontalItemTokens.ActiveIndicatorHeight = Dp.constructor-impl(40f);
        NavigationBarHorizontalItemTokens.ActiveIndicatorLeadingSpace = Dp.constructor-impl(16f);
        NavigationBarHorizontalItemTokens.ActiveIndicatorTrailingSpace = Dp.constructor-impl(16f);
        NavigationBarHorizontalItemTokens.IconSize = Dp.constructor-impl(24f);
    }

    private NavigationBarHorizontalItemTokens() {
        super();
    }

    public final float getActiveIndicatorHeight-D9Ej5fM() {
        return NavigationBarHorizontalItemTokens.ActiveIndicatorHeight;
    }

    public final float getActiveIndicatorLeadingSpace-D9Ej5fM() {
        return NavigationBarHorizontalItemTokens.ActiveIndicatorLeadingSpace;
    }

    public final float getActiveIndicatorTrailingSpace-D9Ej5fM() {
        return NavigationBarHorizontalItemTokens.ActiveIndicatorTrailingSpace;
    }

    public final float getIconSize-D9Ej5fM() {
        return NavigationBarHorizontalItemTokens.IconSize;
    }
}

