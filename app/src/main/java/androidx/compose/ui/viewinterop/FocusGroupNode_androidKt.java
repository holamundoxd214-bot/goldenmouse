package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0000\u001A\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H\u0002\u001A\u0014\u0010\u0005\u001A\u00020\u0006*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0002\u001A\"\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u0003H\u0002¨\u0006\u000E"}, d2={"focusInteropModifier", "Landroidx/compose/ui/Modifier;", "getEmbeddedView", "Landroid/view/View;", "Landroidx/compose/ui/Modifier$Node;", "containsDescendant", "", "other", "getCurrentlyFocusedRect", "Landroid/graphics/Rect;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "hostView", "embeddedView", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusGroupNode_androidKt {
    public static final boolean access$containsDescendant(View arg0, View arg1) {
        return FocusGroupNode_androidKt.containsDescendant(arg0, arg1);
    }

    public static final Rect access$getCurrentlyFocusedRect(FocusOwner arg0, View arg1, View arg2) {
        return FocusGroupNode_androidKt.getCurrentlyFocusedRect(arg0, arg1, arg2);
    }

    public static final View access$getEmbeddedView(Node arg0) {
        return FocusGroupNode_androidKt.getEmbeddedView(arg0);
    }

    private static final boolean containsDescendant(View arg1, View arg2) {
        ViewParent v2;
        for(v2 = arg2.getParent(); v2 != null; v2 = v2.getParent()) {
            if(v2 == arg1.getParent()) {
                return 1;
            }
        }

        return 0;
    }

    public static final Modifier focusInteropModifier(Modifier arg1) {
        return FocusModifierKt.focusTarget(arg1.then(FocusGroupPropertiesElement.INSTANCE)).then(FocusTargetPropertiesElement.INSTANCE).then(FocusTargetInteropElement.INSTANCE);
    }

    private static final Rect getCurrentlyFocusedRect(FocusOwner arg7, View arg8, View arg9) {
        int[] v1 = new int[2];
        arg8.getLocationOnScreen(v1);
        int[] v8 = new int[2];
        arg9.getLocationOnScreen(v8);
        androidx.compose.ui.geometry.Rect v7 = arg7.getFocusRect();
        if(v7 == null) {
            return null;
        }

        return new Rect((((int)v7.getLeft())) + v1[0] - v8[0], (((int)v7.getTop())) + v1[1] - v8[1], (((int)v7.getRight())) + v1[0] - v8[0], (((int)v7.getBottom())) + v1[1] - v8[1]);
    }

    private static final View getEmbeddedView(Node arg1) {
        View v1 = DelegatableNodeKt.requireLayoutNode(arg1.getNode()).getInteropView();
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Could not fetch interop view".toString());
    }
}

