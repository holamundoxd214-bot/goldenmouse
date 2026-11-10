package androidx.compose.foundation;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0003\u001A\u00020\u0001*\u00020\u0004H\u0002\"\u0014\u0010\u0005\u001A\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"isComposeRootInScrollableContainer", "", "Landroidx/compose/ui/node/DelegatableNode;", "isInScrollableViewGroup", "Landroid/view/View;", "TapIndicationDelay", "", "getTapIndicationDelay", "()J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Clickable_androidKt {
    private static final long TapIndicationDelay;

    static {
        Clickable_androidKt.TapIndicationDelay = ((long)ViewConfiguration.getTapTimeout());
    }

    public static final long getTapIndicationDelay() {
        return Clickable_androidKt.TapIndicationDelay;
    }

    public static final boolean isComposeRootInScrollableContainer(DelegatableNode arg0) {
        return Clickable_androidKt.isInScrollableViewGroup(DelegatableNode_androidKt.requireView(arg0));
    }

    private static final boolean isInScrollableViewGroup(View arg1) {
        ViewParent v1 = arg1.getParent();
        while(v1 != null) {
            if(!(v1 instanceof ViewGroup)) {
                return 0;
            }

            if(((ViewGroup)v1).shouldDelayChildPressedState()) {
                return 1;
            }
            else {
                v1 = ((ViewGroup)v1).getParent();
                continue;
            }

            return 0;
        }

        return 0;
    }
}

