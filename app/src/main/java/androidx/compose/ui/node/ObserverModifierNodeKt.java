package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A+\u0010\u0000\u001A\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004*\u0002H\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"observeReads", "", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier$Node;Lkotlin/jvm/functions/Function0;)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ObserverModifierNodeKt {
    public static final void observeReads(Node arg2, Function0 arg3) {
        ObserverNodeOwnerScope v0 = arg2.getOwnerScope$ui();
        if(v0 == null) {
            v0 = new ObserverNodeOwnerScope(arg2);
            arg2.setOwnerScope$ui(v0);
        }

        OwnerSnapshotObserver.access$getObserver$p(DelegatableNodeKt.requireOwner(((DelegatableNode)arg2)).getSnapshotObserver()).observeReads(v0, ObserverNodeOwnerScope.Companion.getOnObserveReadsChanged$ui(), arg3);
    }
}

