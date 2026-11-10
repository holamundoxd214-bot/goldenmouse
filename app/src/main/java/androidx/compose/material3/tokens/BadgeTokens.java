package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0013R\u0013\u0010\u001B\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u001C\u0010\u0017¨\u0006\u001D"}, d2={"Landroidx/compose/material3/tokens/BadgeTokens;", "", "<init>", "()V", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "LargeColor", "getLargeColor", "LargeLabelTextColor", "getLargeLabelTextColor", "LargeLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLargeLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LargeShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getLargeShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "LargeSize", "Landroidx/compose/ui/unit/Dp;", "getLargeSize-D9Ej5fM", "()F", "F", "Shape", "getShape", "Size", "getSize-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BadgeTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens Color;
    public static final BadgeTokens INSTANCE;
    private static final ColorSchemeKeyTokens LargeColor;
    private static final ColorSchemeKeyTokens LargeLabelTextColor;
    private static final TypographyKeyTokens LargeLabelTextFont;
    private static final ShapeKeyTokens LargeShape;
    private static final float LargeSize;
    private static final ShapeKeyTokens Shape;
    private static final float Size;

    static {
        BadgeTokens.INSTANCE = new BadgeTokens();
        BadgeTokens.Color = ColorSchemeKeyTokens.Error;
        BadgeTokens.LargeColor = ColorSchemeKeyTokens.Error;
        BadgeTokens.LargeLabelTextColor = ColorSchemeKeyTokens.OnError;
        BadgeTokens.LargeLabelTextFont = TypographyKeyTokens.LabelSmall;
        BadgeTokens.LargeShape = ShapeKeyTokens.CornerFull;
        BadgeTokens.LargeSize = Dp.constructor-impl(16f);
        BadgeTokens.Shape = ShapeKeyTokens.CornerFull;
        BadgeTokens.Size = Dp.constructor-impl(6f);
    }

    private BadgeTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getColor() {
        return BadgeTokens.Color;
    }

    public final ColorSchemeKeyTokens getLargeColor() {
        return BadgeTokens.LargeColor;
    }

    public final ColorSchemeKeyTokens getLargeLabelTextColor() {
        return BadgeTokens.LargeLabelTextColor;
    }

    public final TypographyKeyTokens getLargeLabelTextFont() {
        return BadgeTokens.LargeLabelTextFont;
    }

    public final ShapeKeyTokens getLargeShape() {
        return BadgeTokens.LargeShape;
    }

    public final float getLargeSize-D9Ej5fM() {
        return BadgeTokens.LargeSize;
    }

    public final ShapeKeyTokens getShape() {
        return BadgeTokens.Shape;
    }

    public final float getSize-D9Ej5fM() {
        return BadgeTokens.Size;
    }
}

