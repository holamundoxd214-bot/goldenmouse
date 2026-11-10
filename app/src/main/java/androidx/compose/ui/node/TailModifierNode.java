package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\rH\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000F"}, d2={"Landroidx/compose/ui/node/TailModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "attachHasBeenRun", "", "getAttachHasBeenRun", "()Z", "setAttachHasBeenRun", "(Z)V", "toString", "", "onAttach", "", "onDetach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TailModifierNode extends Node {
    public static final int $stable = 8;
    private boolean attachHasBeenRun;

    static {
    }

    public TailModifierNode() {
        super();
        this.setAggregateChildKindSet$ui(0);
    }

    public final boolean getAttachHasBeenRun() {
        return this.attachHasBeenRun;
    }

    public void onAttach() {
        this.attachHasBeenRun = true;
    }

    public void onDetach() {
        this.attachHasBeenRun = false;
    }

    public final void setAttachHasBeenRun(boolean arg1) {
        this.attachHasBeenRun = arg1;
    }

    public String toString() {
        return "<tail>";
    }
}

