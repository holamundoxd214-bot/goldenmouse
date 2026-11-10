package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001A\u0010\u000F\u001A\u00020\u00062\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0017\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\nX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0010\u0010\r\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000E¨\u0006\u0014"}, d2={"Landroidx/compose/ui/layout/OnSizeChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "onSizeChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "previousSize", "J", "update", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OnSizeChangedNode extends Node implements LayoutAwareModifierNode {
    public static final int $stable = 8;
    private Function1 onSizeChanged;
    private long previousSize;
    private final boolean shouldAutoInvalidate;

    static {
    }

    public OnSizeChangedNode(Function1 arg3) {
        super();
        this.onSizeChanged = arg3;
        this.shouldAutoInvalidate = true;
        this.previousSize = IntSize.constructor-impl(-9223372034707292160L);
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onRemeasured-ozmzZPI(long arg3) {
        if(!IntSize.equals-impl0(this.previousSize, arg3)) {
            this.onSizeChanged.invoke(IntSize.box-impl(arg3));
            this.previousSize = arg3;
        }
    }

    public final void update(Function1 arg3) {
        this.onSizeChanged = arg3;
        this.previousSize = IntSize.constructor-impl(-9223372034707292160L);
    }
}

