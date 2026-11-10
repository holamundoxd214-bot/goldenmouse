package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007\u001A.\u0010\t\u001A\u00020\n*\u00020\u000B2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¨\u0006\f"}, d2={"onLayoutRectChanged", "Landroidx/compose/ui/Modifier;", "throttleMillis", "", "debounceMillis", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "registerOnLayoutRectChanged", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "Landroidx/compose/ui/node/DelegatableNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OnLayoutRectChangedModifierKt {
    public static final Modifier onLayoutRectChanged(Modifier arg6, long arg7, long arg9, Function1 arg11) {
        return arg6.then(new OnLayoutRectChangedElement(arg7, arg9, arg11));
    }

    public static Modifier onLayoutRectChanged$default(Modifier arg6, long arg7, long arg9, Function1 arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = 0;
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = 0x40;
        }

        return OnLayoutRectChangedModifierKt.onLayoutRectChanged(arg6, v1, arg9, arg11);
    }

    public static final RegistrationHandle registerOnLayoutRectChanged(DelegatableNode arg9, long arg10, long arg12, Function1 arg14) {
        LayoutNode v0 = DelegatableNodeKt.requireLayoutNode(arg9);
        return LayoutNodeKt.requireOwner(v0).getRectManager().registerOnRectChangedCallback(v0.getSemanticsId(), arg10, arg12, arg9, arg14);
    }
}

