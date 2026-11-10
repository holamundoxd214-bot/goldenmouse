package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/material3/tokens/ButtonGroupSmallTokens;", "", "<init>", "()V", "BetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getBetweenSpace-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ButtonGroupSmallTokens {
    public static final int $stable;
    private static final float BetweenSpace;
    private static final float ContainerHeight;
    public static final ButtonGroupSmallTokens INSTANCE;

    static {
        ButtonGroupSmallTokens.INSTANCE = new ButtonGroupSmallTokens();
        ButtonGroupSmallTokens.BetweenSpace = Dp.constructor-impl(12f);
        ButtonGroupSmallTokens.ContainerHeight = Dp.constructor-impl(40f);
    }

    private ButtonGroupSmallTokens() {
        super();
    }

    public final float getBetweenSpace-D9Ej5fM() {
        return ButtonGroupSmallTokens.BetweenSpace;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return ButtonGroupSmallTokens.ContainerHeight;
    }
}

