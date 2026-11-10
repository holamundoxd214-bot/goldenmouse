package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000E"}, d2={"Landroidx/compose/ui/focus/FocusPropertiesNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusPropertiesScope", "Landroidx/compose/ui/focus/FocusPropertiesScope;", "<init>", "(Landroidx/compose/ui/focus/FocusPropertiesScope;)V", "getFocusPropertiesScope", "()Landroidx/compose/ui/focus/FocusPropertiesScope;", "setFocusPropertiesScope", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusPropertiesNode extends Node implements FocusPropertiesModifierNode {
    private FocusPropertiesScope focusPropertiesScope;

    public FocusPropertiesNode(FocusPropertiesScope arg1) {
        super();
        this.focusPropertiesScope = arg1;
    }

    public void applyFocusProperties(FocusProperties arg1) {
        this.focusPropertiesScope.apply(arg1);
    }

    public final FocusPropertiesScope getFocusPropertiesScope() {
        return this.focusPropertiesScope;
    }

    public final void setFocusPropertiesScope(FocusPropertiesScope arg1) {
        this.focusPropertiesScope = arg1;
    }
}

