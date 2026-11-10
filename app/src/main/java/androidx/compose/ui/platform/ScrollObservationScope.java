package androidx.compose.ui.platform;

import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00000\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001E\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001E\u0010\b\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001A\"\u0004\b\u001E\u0010\u001CR\u0014\u0010\u001F\u001A\u00020 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010!¨\u0006\""}, d2={"Landroidx/compose/ui/platform/ScrollObservationScope;", "Landroidx/compose/ui/node/OwnerScope;", "semanticsNodeId", "", "allScopes", "", "oldXValue", "", "oldYValue", "horizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "verticalScrollAxisRange", "<init>", "(ILjava/util/List;Ljava/lang/Float;Ljava/lang/Float;Landroidx/compose/ui/semantics/ScrollAxisRange;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "getSemanticsNodeId", "()I", "getAllScopes", "()Ljava/util/List;", "getOldXValue", "()Ljava/lang/Float;", "setOldXValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getOldYValue", "setOldYValue", "getHorizontalScrollAxisRange", "()Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "isValidOwnerScope", "", "()Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollObservationScope implements OwnerScope {
    public static final int $stable = 8;
    private final List allScopes;
    private ScrollAxisRange horizontalScrollAxisRange;
    private Float oldXValue;
    private Float oldYValue;
    private final int semanticsNodeId;
    private ScrollAxisRange verticalScrollAxisRange;

    static {
    }

    public ScrollObservationScope(int arg1, List arg2, Float arg3, Float arg4, ScrollAxisRange arg5, ScrollAxisRange arg6) {
        super();
        this.semanticsNodeId = arg1;
        this.allScopes = arg2;
        this.oldXValue = arg3;
        this.oldYValue = arg4;
        this.horizontalScrollAxisRange = arg5;
        this.verticalScrollAxisRange = arg6;
    }

    public final List getAllScopes() {
        return this.allScopes;
    }

    public final ScrollAxisRange getHorizontalScrollAxisRange() {
        return this.horizontalScrollAxisRange;
    }

    public final Float getOldXValue() {
        return this.oldXValue;
    }

    public final Float getOldYValue() {
        return this.oldYValue;
    }

    public final int getSemanticsNodeId() {
        return this.semanticsNodeId;
    }

    public final ScrollAxisRange getVerticalScrollAxisRange() {
        return this.verticalScrollAxisRange;
    }

    public boolean isValidOwnerScope() {
        return this.allScopes.contains(this);
    }

    public final void setHorizontalScrollAxisRange(ScrollAxisRange arg1) {
        this.horizontalScrollAxisRange = arg1;
    }

    public final void setOldXValue(Float arg1) {
        this.oldXValue = arg1;
    }

    public final void setOldYValue(Float arg1) {
        this.oldYValue = arg1;
    }

    public final void setVerticalScrollAxisRange(ScrollAxisRange arg1) {
        this.verticalScrollAxisRange = arg1;
    }
}

