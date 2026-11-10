package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\rR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<init>", "()V", "nodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getNodes", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector nodes;

    public static Rect $r8$lambda$jtbcC9u34tug3KKI258XiHLM1uM(Rect arg0) {
        return BringIntoViewRequesterImpl.bringIntoView$lambda$0$0(arg0);
    }

    public BringIntoViewRequesterImpl() {
        super();
        this.nodes = new MutableVector(new BringIntoViewRequesterNode[16], 0);
    }

    public Object bringIntoView(Rect arg8, Continuation arg9) {
        Object v2_1;
        int v8;
        int v7;
        int v2;
        Continuation v0;
        if((arg9 instanceof BringIntoViewRequesterImpl$bringIntoView$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((BringIntoViewRequesterImpl$bringIntoView$1)v0).label & v2) != 0) {
                ((BringIntoViewRequesterImpl$bringIntoView$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            BringIntoViewRequesterImpl$bringIntoView$1 v0_1 = new BringIntoViewRequesterImpl$bringIntoView$1(this, arg9);
        }

        Object v9 = ((BringIntoViewRequesterImpl$bringIntoView$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((BringIntoViewRequesterImpl$bringIntoView$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            MutableVector v7_1 = this.nodes;
            Object[] v9_1 = v7_1.content;
            v7 = v7_1.getSize();
            Object[] v6 = v9_1;
            Rect v9_2 = arg8;
            v8 = 0;
            Object[] v2_2 = v6;
            goto label_39;
        label_51:
            ++v8;
        }
        else if(v2 == 1) {
            v7 = ((BringIntoViewRequesterImpl$bringIntoView$1)v0).I$1;
            v8 = ((BringIntoViewRequesterImpl$bringIntoView$1)v0).I$0;
            v2_1 = ((BringIntoViewRequesterImpl$bringIntoView$1)v0).L$1;
            Object v4 = ((BringIntoViewRequesterImpl$bringIntoView$1)v0).L$0;
            ResultKt.throwOnFailure(v9);
            v9 = v4;
            goto label_51;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_39:
        if(v8 < v7) {
            DelegatableNode v4_1 = v2_1[v8];
            BringIntoViewRequesterImpl$$ExternalSyntheticLambda0 v5 = new BringIntoViewRequesterImpl$$ExternalSyntheticLambda0(((Rect)v9));
            ((BringIntoViewRequesterImpl$bringIntoView$1)v0).L$0 = v9;
            ((BringIntoViewRequesterImpl$bringIntoView$1)v0).L$1 = v2_1;
            ((BringIntoViewRequesterImpl$bringIntoView$1)v0).I$0 = v8;
            ((BringIntoViewRequesterImpl$bringIntoView$1)v0).I$1 = v7;
            ((BringIntoViewRequesterImpl$bringIntoView$1)v0).label = 1;
            if(BringIntoViewModifierNodeKt.bringIntoView(v4_1, ((Function0)v5), v0) != v1) {
                goto label_51;
            }

            return v1;
        }

        return Unit.INSTANCE;
    }

    private static final Rect bringIntoView$lambda$0$0(Rect arg0) {
        return arg0;
    }

    public final MutableVector getNodes() {
        return this.nodes;
    }
}

