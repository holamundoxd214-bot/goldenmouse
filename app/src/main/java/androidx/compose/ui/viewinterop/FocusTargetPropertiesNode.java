package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2={"Landroidx/compose/ui/viewinterop/FocusTargetPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "<init>", "()V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusTargetPropertiesNode extends Node implements FocusPropertiesModifierNode {
    public FocusTargetPropertiesNode() {
        super();
    }

    public void applyFocusProperties(FocusProperties arg3) {
        FocusTargetPropertiesNode v0 = this;
        View v1 = FocusGroupNode_androidKt.getEmbeddedView(((Node)v0));
        boolean v2 = !this.getNode().isAttached() || !FocusGroupNode_androidKt.getEmbeddedView(((Node)v0)).hasFocusable() ? false : true;
        arg3.setCanFocus(v2);
        View v2_1 = v1.findFocus();
        if(v2_1 != null) {
            Rect v2_2 = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(v2_1, v1);
            if(v2_2 != null) {
                arg3.setFocusRect(v2_2);
            }
        }
    }
}

