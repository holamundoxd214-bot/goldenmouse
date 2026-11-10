package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/material3/tokens/AppBarLargeFlexibleTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "SubtitleFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getSubtitleFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "TitleFont", "getTitleFont", "LargeContainerHeight", "getLargeContainerHeight-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AppBarLargeFlexibleTokens {
    public static final int $stable;
    private static final float ContainerHeight;
    public static final AppBarLargeFlexibleTokens INSTANCE;
    private static final float LargeContainerHeight;
    private static final TypographyKeyTokens SubtitleFont;
    private static final TypographyKeyTokens TitleFont;

    static {
        AppBarLargeFlexibleTokens.INSTANCE = new AppBarLargeFlexibleTokens();
        AppBarLargeFlexibleTokens.ContainerHeight = Dp.constructor-impl(120f);
        AppBarLargeFlexibleTokens.SubtitleFont = TypographyKeyTokens.TitleMedium;
        AppBarLargeFlexibleTokens.TitleFont = TypographyKeyTokens.DisplaySmall;
        AppBarLargeFlexibleTokens.LargeContainerHeight = Dp.constructor-impl(152f);
    }

    private AppBarLargeFlexibleTokens() {
        super();
    }

    public final float getContainerHeight-D9Ej5fM() {
        return AppBarLargeFlexibleTokens.ContainerHeight;
    }

    public final float getLargeContainerHeight-D9Ej5fM() {
        return AppBarLargeFlexibleTokens.LargeContainerHeight;
    }

    public final TypographyKeyTokens getSubtitleFont() {
        return AppBarLargeFlexibleTokens.SubtitleFont;
    }

    public final TypographyKeyTokens getTitleFont() {
        return AppBarLargeFlexibleTokens.TitleFont;
    }
}

