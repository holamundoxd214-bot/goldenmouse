package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\u0018\u0010\u000B\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\u0018\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0016J\b\u0010\u000E\u001A\u00020\u0007H\u0014J \u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0016J\f\u0010\u0012\u001A\u00020\u0013*\u00020\u0002H\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/ui/graphics/vector/VectorApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "<init>", "(Landroidx/compose/ui/graphics/vector/VNode;)V", "insertTopDown", "", "index", "", "instance", "insertBottomUp", "remove", "count", "onClear", "move", "from", "to", "asGroup", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorApplier extends AbstractApplier {
    public static final int $stable;

    static {
        VectorApplier.$stable = AbstractApplier.$stable;
    }

    public VectorApplier(VNode arg1) {
        super(arg1);
    }

    private final GroupComponent asGroup(VNode arg1) {
        if((arg1 instanceof GroupComponent)) {
            return arg1;
        }

        throw new IllegalStateException("Cannot only insert VNode into Group".toString());
    }

    public void insertBottomUp(int arg2, VNode arg3) {
        this.asGroup(this.getCurrent()).insertAt(arg2, arg3);
    }

    public void insertBottomUp(int arg1, Object arg2) {
        this.insertBottomUp(arg1, ((VNode)arg2));
    }

    public void insertTopDown(int arg1, VNode arg2) {
    }

    public void insertTopDown(int arg1, Object arg2) {
        this.insertTopDown(arg1, ((VNode)arg2));
    }

    public void move(int arg2, int arg3, int arg4) {
        this.asGroup(this.getCurrent()).move(arg2, arg3, arg4);
    }

    protected void onClear() {
        GroupComponent v2 = this.asGroup(this.getRoot());
        v2.remove(0, v2.getNumChildren());
    }

    public void remove(int arg2, int arg3) {
        this.asGroup(this.getCurrent()).remove(arg2, arg3);
    }
}

