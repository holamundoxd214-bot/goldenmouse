package androidx.compose.ui.semantics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2={"isAccessibilityIgnoredLink", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsNode_androidKt {
    public static final boolean isAccessibilityIgnoredLink(SemanticsNode arg1) {
        return arg1.getConfig().contains(SemanticsProperties.INSTANCE.getLinkTestMarker());
    }
}

