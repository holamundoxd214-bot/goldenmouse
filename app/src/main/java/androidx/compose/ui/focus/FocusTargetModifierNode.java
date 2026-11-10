package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001A\u00020\u0007H\'J\u0019\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0018\u0010\f\u001A\u00020\rX¦\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011\u0082\u0001\u0001\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2={"Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "requestFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "requestFocus-3ESFkO8", "(I)Z", "focusability", "Landroidx/compose/ui/focus/Focusability;", "getFocusability-LCbbffg", "()I", "setFocusability-josRg5g", "(I)V", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FocusTargetModifierNode extends DelegatableNode {
    FocusState getFocusState();

    int getFocusability-LCbbffg();

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the version accepting FocusDirection", replaceWith="<_subannotation>") boolean requestFocus();

    boolean requestFocus-3ESFkO8(int arg1);

    static boolean requestFocus-3ESFkO8$default(FocusTargetModifierNode arg0, int arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            if((arg2 & 1) != 0) {
                arg1 = FocusDirection.Companion.getEnter-dhqQ-8s();
            }

            return arg0.requestFocus-3ESFkO8(arg1);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestFocus-3ESFkO8");
    }

    void setFocusability-josRg5g(int arg1);
}

