package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J&\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00132\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0096@¢\u0006\u0002\u0010\u0019R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u0014\u0010\u000B\u001A\u00020\fX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/relocation/BringIntoViewModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "<init>", "(Landroidx/compose/foundation/relocation/BringIntoViewResponder;)V", "getResponder", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "setResponder", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "hasBeenPlaced", "onPlaced", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "bringIntoView", "childCoordinates", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BringIntoViewResponderNode extends Node implements LayoutAwareModifierNode, BringIntoViewModifierNode {
    public static final int $stable = 8;
    private boolean hasBeenPlaced;
    private BringIntoViewResponder responder;
    private final boolean shouldAutoInvalidate;

    static {
    }

    public BringIntoViewResponderNode(BringIntoViewResponder arg1) {
        super();
        this.responder = arg1;
    }

    public static final Rect access$bringIntoView$localRect(BringIntoViewResponderNode arg0, LayoutCoordinates arg1, Function0 arg2) {
        return BringIntoViewResponderNode.bringIntoView$localRect(arg0, arg1, arg2);
    }

    public Object bringIntoView(LayoutCoordinates arg7, Function0 arg8, Continuation arg9) {
        Object v6 = CoroutineScopeKt.coroutineScope(new BringIntoViewResponderNode$bringIntoView$2(this, arg7, arg8, new BringIntoViewResponderNode$$ExternalSyntheticLambda0(this, arg7, arg8), null), arg9);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    static final Rect bringIntoView$lambda$1(BringIntoViewResponderNode arg0, LayoutCoordinates arg1, Function0 arg2) {
        Rect v1 = BringIntoViewResponderNode.bringIntoView$localRect(arg0, arg1, arg2);
        if(v1 != null) {
            return arg0.responder.calculateRectForParent(v1);
        }

        return null;
    }

    private static final Rect bringIntoView$localRect(BringIntoViewResponderNode arg2, LayoutCoordinates arg3, Function0 arg4) {
        Rect v1 = null;
        if(!arg2.isAttached()) {
            return v1;
        }

        if(!arg2.hasBeenPlaced) {
            return v1;
        }

        LayoutCoordinates v2 = DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)arg2));
        if(arg3.isAttached()) {
        }
        else {
            arg3 = ((LayoutCoordinates)v1);
        }

        if(arg3 == null) {
            return v1;
        }

        Object v4 = arg4.invoke();
        if(v4 == null) {
            return v1;
        }

        return BringIntoViewRequesterKt__BringIntoViewResponderKt.localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(v2, arg3, ((Rect)v4));
    }

    public final BringIntoViewResponder getResponder() {
        return this.responder;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onPlaced(LayoutCoordinates arg1) {
        this.hasBeenPlaced = true;
    }

    public final void setResponder(BringIntoViewResponder arg1) {
        this.responder = arg1;
    }
}

