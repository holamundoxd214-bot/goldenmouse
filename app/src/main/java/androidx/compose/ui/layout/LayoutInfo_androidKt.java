package androidx.compose.ui.layout;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"view", "Landroid/view/View;", "Landroidx/compose/ui/layout/LayoutInfo;", "getView", "(Landroidx/compose/ui/layout/LayoutInfo;)Landroid/view/View;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutInfo_androidKt {
    public static final View getView(LayoutInfo arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutNode");
        Owner v1 = ((LayoutNode)arg1).getOwner$ui();
        if((v1 instanceof View)) {
            return ((View)v1);
        }

        return null;
    }
}

