package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\r\u001A\u00020\u0006*\u00020\u0005H\u0016J\b\u0010\u000E\u001A\u00020\u0006H\u0016R+\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\t¨\u0006\u000F"}, d2={"Landroidx/compose/material3/internal/ChildSemanticsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getProperties", "()Lkotlin/jvm/functions/Function1;", "setProperties", "applySemantics", "onDetach", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChildSemanticsNode extends Node implements SemanticsModifierNode {
    public static final int $stable = 8;
    private Function1 properties;

    static {
    }

    public ChildSemanticsNode(Function1 arg1) {
        super();
        this.properties = arg1;
    }

    public void applySemantics(SemanticsPropertyReceiver arg4) {
        TraversableNodeKt.traverseAncestors(this, ParentSemanticsNodeKey.INSTANCE, new ChildSemanticsNode$$ExternalSyntheticLambda0(arg4));
        this.properties.invoke(arg4);
    }

    static final boolean applySemantics$lambda$1(SemanticsPropertyReceiver arg1, TraversableNode arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.material3.internal.ParentSemanticsNode");
        ((ParentSemanticsNode)arg2).obtainSemantics(arg1);
        return 0;
    }

    public final Function1 getProperties() {
        return this.properties;
    }

    public void onDetach() {
        super.onDetach();
        TraversableNodeKt.traverseAncestors(((DelegatableNode)this), ParentSemanticsNodeKey.INSTANCE, new ChildSemanticsNode$$ExternalSyntheticLambda1());
    }

    static final boolean onDetach$lambda$2(TraversableNode arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.material3.internal.ParentSemanticsNode");
        ((ParentSemanticsNode)arg1).releaseSemantics();
        return 0;
    }

    public final void setProperties(Function1 arg1) {
        this.properties = arg1;
    }
}

