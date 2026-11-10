package androidx.compose.ui;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0002H\u0007¨\u0006\u0003"}, d2={"zIndex", "Landroidx/compose/ui/Modifier;", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ZIndexModifierKt {
    public static final Modifier zIndex(Modifier arg1, float arg2) {
        return arg1.then(new ZIndexElement(arg2));
    }
}

