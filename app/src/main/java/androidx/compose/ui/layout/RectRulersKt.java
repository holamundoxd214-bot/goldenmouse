package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A\u0006\u0010\u0000\u001A\u00020\u0001\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A#\u0010\u0004\u001A\u00020\u0001*\u00020\u00052\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001¢\u0006\u0002\u0010\b\u001A#\u0010\t\u001A\u00020\u0001*\u00020\u00052\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001¢\u0006\u0002\u0010\b¨\u0006\n"}, d2={"RectRulers", "Landroidx/compose/ui/layout/RectRulers;", "name", "", "innermostOf", "Landroidx/compose/ui/layout/RectRulers$Companion;", "rulers", "", "(Landroidx/compose/ui/layout/RectRulers$Companion;[Landroidx/compose/ui/layout/RectRulers;)Landroidx/compose/ui/layout/RectRulers;", "outermostOf", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RectRulersKt {
    public static final RectRulers RectRulers(String arg1) {
        return new RectRulersImpl(arg1);
    }

    public static final RectRulers RectRulers() {
        return new RectRulersImpl(null);
    }

    public static final RectRulers innermostOf(Companion arg0, RectRulers[] arg1) {
        return new InnerRectRulers(arg1);
    }

    public static final RectRulers outermostOf(Companion arg0, RectRulers[] arg1) {
        return new OuterRectRulers(arg1);
    }
}

