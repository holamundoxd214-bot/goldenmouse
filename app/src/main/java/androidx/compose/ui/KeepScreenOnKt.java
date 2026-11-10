package androidx.compose.ui;

import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2={"keepScreenOn", "Landroidx/compose/ui/Modifier;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeepScreenOnKt {
    public static final Modifier keepScreenOn(Modifier arg1) {
        return arg1.then(KeepScreenOnElement.INSTANCE);
    }
}

