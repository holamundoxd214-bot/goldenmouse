package androidx.compose.ui.layout;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0010\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\"\u0014\u0010\u0004\u001A\u00020\u0002X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"getDisplayCutoutBounds", "", "Landroidx/compose/ui/layout/RectRulers;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "NeverProvidedRectRulers", "getNeverProvidedRectRulers", "()Landroidx/compose/ui/layout/RectRulers;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsRulersKt {
    private static final RectRulers NeverProvidedRectRulers;

    static {
        WindowInsetsRulersKt.NeverProvidedRectRulers = RectRulersKt.RectRulers();
    }

    public static final List getDisplayCutoutBounds(PlacementScope arg0) {
        return WindowInsetsRulers_androidKt.findDisplayCutouts(arg0);
    }

    public static final RectRulers getNeverProvidedRectRulers() {
        return WindowInsetsRulersKt.NeverProvidedRectRulers;
    }
}

