package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0007\u001AU\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032:\b\u0002\u0010\u0004\u001A4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\f\u0010\r\u001A\f\u0010\u000E\u001A\u0004\u0018\u00010\u000F*\u00020\u0001¨\u0006\u0010"}, d2={"FocusTargetModifierNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "Lkotlin/ParameterName;", "name", "previous", "current", "", "FocusTargetModifierNode-PYyLHbc", "(ILkotlin/jvm/functions/Function2;)Landroidx/compose/ui/focus/FocusTargetModifierNode;", "getFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusTargetModifierNodeKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the other overload with added parameters for focusability and onFocusChange") public static final FocusTargetModifierNode FocusTargetModifierNode() {
        return new FocusTargetNode(0, false, null, new FocusTargetModifierNodeKt$FocusTargetModifierNode$1(InvalidateSemantics.INSTANCE), 7, null);
    }

    public static final FocusTargetModifierNode FocusTargetModifierNode-PYyLHbc(int arg7, Function2 arg8) {
        return new FocusTargetNode(arg7, false, arg8, null, 10, null);
    }

    public static FocusTargetModifierNode FocusTargetModifierNode-PYyLHbc$default(int arg0, Function2 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg0 = Focusability.Companion.getAlways-LCbbffg();
        }

        if((arg2 & 2) != 0) {
            arg1 = null;
        }

        return FocusTargetModifierNodeKt.FocusTargetModifierNode-PYyLHbc(arg0, arg1);
    }

    public static final Rect getFocusedRect(FocusTargetModifierNode arg3) {
        Rect v1 = null;
        if(!arg3.getNode().isAttached()) {
            return v1;
        }

        FocusState v0 = arg3.getFocusState();
        if(!v0.getHasFocus()) {
            return v1;
        }

        if(v0.isFocused()) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.ui.focus.FocusTargetNode");
            return FocusTargetNode.fetchFocusRect$ui$default(((FocusTargetNode)arg3), ((LayoutCoordinates)v1), 1, v1);
        }

        FocusTargetNode v0_1 = DelegatableNodeKt.requireOwner(((DelegatableNode)arg3)).getFocusOwner().getActiveFocusTargetNode();
        if(v0_1 != null) {
            return v0_1.fetchFocusRect$ui(DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)arg3)));
        }

        return v1;
    }
}

