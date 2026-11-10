package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001A\u001A\u00020\u0017J\b\u0010\u001B\u001A\u00020\u0017H\u0016J\b\u0010\u001C\u001A\u00020\u0017H\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001D\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001D"}, d2={"Landroidx/compose/ui/layout/LayoutBoundsNode;", "Landroidx/compose/ui/Modifier$Node;", "holder", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "<init>", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "getHolder", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "setHolder", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "lastBounds", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "getLastBounds", "()Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "setLastBounds", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "rectChanged", "Lkotlin/Function1;", "", "getRectChanged", "()Lkotlin/jvm/functions/Function1;", "forceUpdate", "onAttach", "onDetach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutBoundsNode extends Node {
    public static final int $stable = 8;
    private RegistrationHandle handle;
    private LayoutBoundsHolder holder;
    private RelativeLayoutBounds lastBounds;
    private final Function1 rectChanged;

    static {
    }

    public LayoutBoundsNode(LayoutBoundsHolder arg1) {
        super();
        this.holder = arg1;
        this.rectChanged = new LayoutBoundsNode$rectChanged$1(this);
    }

    public final void forceUpdate() {
        this.holder.setBounds$ui(this.lastBounds);
    }

    public final RegistrationHandle getHandle() {
        return this.handle;
    }

    public final LayoutBoundsHolder getHolder() {
        return this.holder;
    }

    public final RelativeLayoutBounds getLastBounds() {
        return this.lastBounds;
    }

    public final Function1 getRectChanged() {
        return this.rectChanged;
    }

    public void onAttach() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0, 0, this.rectChanged);
    }

    public void onDetach() {
        RegistrationHandle v0 = this.handle;
        if(v0 != null) {
            v0.unregister();
        }

        this.holder.setBounds$ui(null);
    }

    public final void setHandle(RegistrationHandle arg1) {
        this.handle = arg1;
    }

    public final void setHolder(LayoutBoundsHolder arg1) {
        this.holder = arg1;
    }

    public final void setLastBounds(RelativeLayoutBounds arg1) {
        this.lastBounds = arg1;
    }
}

