package androidx.compose.ui.semantics;

import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "adjustedBounds", "Landroidx/compose/ui/unit/IntRect;", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;)V", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getAdjustedBounds", "()Landroidx/compose/ui/unit/IntRect;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsNodeWithAdjustedBounds {
    public static final int $stable = 8;
    private final IntRect adjustedBounds;
    private final SemanticsNode semanticsNode;

    static {
    }

    public SemanticsNodeWithAdjustedBounds(SemanticsNode arg1, IntRect arg2) {
        super();
        this.semanticsNode = arg1;
        this.adjustedBounds = arg2;
    }

    public final IntRect getAdjustedBounds() {
        return this.adjustedBounds;
    }

    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }
}

