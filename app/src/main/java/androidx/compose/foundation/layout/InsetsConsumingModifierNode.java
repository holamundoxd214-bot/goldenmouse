package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H&J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0012H\u0016J\b\u0010\u0014\u001A\u00020\u0012H\u0016J\u0010\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u00020\u0006H\u0002J\b\u0010\u0016\u001A\u00020\u0012H\u0016J\b\u0010\u0017\u001A\u00020\u0012H\u0002R\u001E\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0006@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u001E\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0006@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\t¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "<init>", "()V", "value", "Landroidx/compose/foundation/layout/WindowInsets;", "ancestorConsumedInsets", "getAncestorConsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "consumedInsets", "getConsumedInsets", "calculateInsets", "onAttach", "", "onDetach", "onReset", "setAncestorConsumedInsets", "insetsInvalidated", "invalidateChildConsumedInsets", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class InsetsConsumingModifierNode extends Node implements TraversableNode {
    public static final int $stable = 8;
    private WindowInsets ancestorConsumedInsets;
    private WindowInsets consumedInsets;

    static {
    }

    public InsetsConsumingModifierNode() {
        super();
        this.ancestorConsumedInsets = WindowInsetsKt.WindowInsets();
        this.consumedInsets = WindowInsetsKt.WindowInsets();
    }

    public abstract WindowInsets calculateInsets(WindowInsets arg1);

    public final WindowInsets getAncestorConsumedInsets() {
        return this.ancestorConsumedInsets;
    }

    public final WindowInsets getConsumedInsets() {
        return this.consumedInsets;
    }

    public Object getTraverseKey() {
        return "androidx.compose.foundation.layout.ConsumedInsetsProvider";
    }

    public void insetsInvalidated() {
        this.consumedInsets = this.calculateInsets(this.ancestorConsumedInsets);
        this.invalidateChildConsumedInsets();
    }

    private final void invalidateChildConsumedInsets() {
        TraversableNodeKt.traverseDescendants(this, this.getTraverseKey(), new InsetsConsumingModifierNode$$ExternalSyntheticLambda0(this));
    }

    static final TraverseDescendantsAction invalidateChildConsumedInsets$lambda$0(InsetsConsumingModifierNode arg1, TraversableNode arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.foundation.layout.InsetsConsumingModifierNode");
        ((InsetsConsumingModifierNode)arg2).setAncestorConsumedInsets(arg1.consumedInsets);
        return TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
    }

    public void onAttach() {
        TraversableNodeKt.traverseAncestors(this, this.getTraverseKey(), new InsetsConsumingModifierNode$$ExternalSyntheticLambda1(this));
        this.insetsInvalidated();
        super.onAttach();
    }

    static final boolean onAttach$lambda$0(InsetsConsumingModifierNode arg1, TraversableNode arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.foundation.layout.InsetsConsumingModifierNode");
        arg1.ancestorConsumedInsets = ((InsetsConsumingModifierNode)arg2).consumedInsets;
        return 0;
    }

    public void onDetach() {
        this.consumedInsets = this.ancestorConsumedInsets;
        this.invalidateChildConsumedInsets();
        super.onDetach();
    }

    public void onReset() {
        super.onReset();
        this.ancestorConsumedInsets = WindowInsetsKt.WindowInsets();
    }

    private final void setAncestorConsumedInsets(WindowInsets arg2) {
        if(!Intrinsics.areEqual(this.ancestorConsumedInsets, arg2)) {
            this.ancestorConsumedInsets = arg2;
            this.insetsInvalidated();
        }
    }
}

