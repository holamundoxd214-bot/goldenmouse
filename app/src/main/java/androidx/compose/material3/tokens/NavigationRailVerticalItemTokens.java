package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001A\u00020\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2={"Landroidx/compose/material3/tokens/NavigationRailVerticalItemTokens;", "", "<init>", "()V", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", "F", "ActiveIndicatorWidth", "getActiveIndicatorWidth-D9Ej5fM", "IconLabelSpace", "getIconLabelSpace-D9Ej5fM", "LeadingSpace", "getLeadingSpace-D9Ej5fM", "TrailingSpace", "getTrailingSpace-D9Ej5fM", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationRailVerticalItemTokens {
    public static final int $stable;
    private static final float ActiveIndicatorHeight;
    private static final float ActiveIndicatorWidth;
    public static final NavigationRailVerticalItemTokens INSTANCE;
    private static final float IconLabelSpace;
    private static final TypographyKeyTokens LabelTextFont;
    private static final float LeadingSpace;
    private static final float TrailingSpace;

    static {
        NavigationRailVerticalItemTokens.INSTANCE = new NavigationRailVerticalItemTokens();
        NavigationRailVerticalItemTokens.ActiveIndicatorHeight = Dp.constructor-impl(32f);
        NavigationRailVerticalItemTokens.ActiveIndicatorWidth = Dp.constructor-impl(56f);
        NavigationRailVerticalItemTokens.IconLabelSpace = Dp.constructor-impl(4f);
        NavigationRailVerticalItemTokens.LeadingSpace = Dp.constructor-impl(16f);
        NavigationRailVerticalItemTokens.TrailingSpace = Dp.constructor-impl(16f);
        NavigationRailVerticalItemTokens.LabelTextFont = TypographyKeyTokens.LabelMedium;
    }

    private NavigationRailVerticalItemTokens() {
        super();
    }

    public final float getActiveIndicatorHeight-D9Ej5fM() {
        return NavigationRailVerticalItemTokens.ActiveIndicatorHeight;
    }

    public final float getActiveIndicatorWidth-D9Ej5fM() {
        return NavigationRailVerticalItemTokens.ActiveIndicatorWidth;
    }

    public final float getIconLabelSpace-D9Ej5fM() {
        return NavigationRailVerticalItemTokens.IconLabelSpace;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return NavigationRailVerticalItemTokens.LabelTextFont;
    }

    public final float getLeadingSpace-D9Ej5fM() {
        return NavigationRailVerticalItemTokens.LeadingSpace;
    }

    public final float getTrailingSpace-D9Ej5fM() {
        return NavigationRailVerticalItemTokens.TrailingSpace;
    }
}

