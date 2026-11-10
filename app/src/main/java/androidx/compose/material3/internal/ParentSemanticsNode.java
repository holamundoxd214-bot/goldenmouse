package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B \u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0017\u001A\u00020\u0007*\u00020\u0006H\u0016J\n\u0010\u0018\u001A\u00020\u0007*\u00020\u0006J\u0006\u0010\u0019\u001A\u00020\u0007R+\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\nR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u001A"}, d2={"Landroidx/compose/material3/internal/ParentSemanticsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getProperties", "()Lkotlin/jvm/functions/Function1;", "setProperties", "semanticsConsumed", "", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "applySemantics", "obtainSemantics", "releaseSemantics", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParentSemanticsNode extends Node implements SemanticsModifierNode, TraversableNode {
    public static final int $stable = 8;
    private Function1 properties;
    private boolean semanticsConsumed;
    private final Object traverseKey;

    static {
    }

    public ParentSemanticsNode(Function1 arg1) {
        super();
        this.properties = arg1;
        this.traverseKey = ParentSemanticsNodeKey.INSTANCE;
    }

    public void applySemantics(SemanticsPropertyReceiver arg2) {
        if(!this.semanticsConsumed) {
            this.properties.invoke(arg2);
        }
    }

    public final Function1 getProperties() {
        return this.properties;
    }

    public boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final void obtainSemantics(SemanticsPropertyReceiver arg2) {
        this.semanticsConsumed = true;
        this.properties.invoke(arg2);
        SemanticsModifierNodeKt.invalidateSemantics(((SemanticsModifierNode)this));
    }

    public final void releaseSemantics() {
        this.semanticsConsumed = false;
        SemanticsModifierNodeKt.invalidateSemantics(((SemanticsModifierNode)this));
    }

    public final void setProperties(Function1 arg1) {
        this.properties = arg1;
    }
}

