package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u000E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0013\u001A\u00020\u0014*\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0014H\u0016R\"\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\"\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\f\"\u0004\b\u0010\u0010\u000ER\"\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000E¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "<init>", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getPlacementSpec", "setPlacementSpec", "getFadeOutSpec", "setFadeOutSpec", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutAnimationSpecsNode extends Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private FiniteAnimationSpec fadeInSpec;
    private FiniteAnimationSpec fadeOutSpec;
    private FiniteAnimationSpec placementSpec;

    static {
    }

    public LazyLayoutAnimationSpecsNode(FiniteAnimationSpec arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3) {
        super();
        this.fadeInSpec = arg1;
        this.placementSpec = arg2;
        this.fadeOutSpec = arg3;
    }

    public final FiniteAnimationSpec getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    public final FiniteAnimationSpec getPlacementSpec() {
        return this.placementSpec;
    }

    public Object modifyParentData(Density arg1, Object arg2) {
        return this;
    }

    public final void setFadeInSpec(FiniteAnimationSpec arg1) {
        this.fadeInSpec = arg1;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec arg1) {
        this.fadeOutSpec = arg1;
    }

    public final void setPlacementSpec(FiniteAnimationSpec arg1) {
        this.placementSpec = arg1;
    }
}

