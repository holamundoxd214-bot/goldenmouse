package androidx.compose.ui;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"sensitiveContent", "Landroidx/compose/ui/Modifier;", "isContentSensitive", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SensitiveContentKt {
    public static final Modifier sensitiveContent(Modifier arg1, boolean arg2) {
        return arg1.then(new SensitiveNodeElement(arg2));
    }

    public static Modifier sensitiveContent$default(Modifier arg0, boolean arg1, int arg2, Object arg3) {
        return SensitiveContentKt.sensitiveContent(arg0, true);
    }
}

