package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2={"Landroidx/compose/material3/tokens/DividerTokens;", "", "<init>", "()V", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "Thickness", "Landroidx/compose/ui/unit/Dp;", "getThickness-D9Ej5fM", "()F", "F", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DividerTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens Color;
    public static final DividerTokens INSTANCE;
    private static final float Thickness;

    static {
        DividerTokens.INSTANCE = new DividerTokens();
        DividerTokens.Color = ColorSchemeKeyTokens.OutlineVariant;
        DividerTokens.Thickness = Dp.constructor-impl(1f);
    }

    private DividerTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getColor() {
        return DividerTokens.Color;
    }

    public final float getThickness-D9Ej5fM() {
        return DividerTokens.Thickness;
    }
}

