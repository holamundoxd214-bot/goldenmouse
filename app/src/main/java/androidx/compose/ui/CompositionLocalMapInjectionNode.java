package androidx.compose.ui;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001A\u00020\u000BH\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\f"}, d2={"Landroidx/compose/ui/CompositionLocalMapInjectionNode;", "Landroidx/compose/ui/Modifier$Node;", "map", "Landroidx/compose/runtime/CompositionLocalMap;", "<init>", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "value", "getMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setMap", "onAttach", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CompositionLocalMapInjectionNode extends Node {
    public static final int $stable = 8;
    private CompositionLocalMap map;

    static {
    }

    public CompositionLocalMapInjectionNode(CompositionLocalMap arg1) {
        super();
        this.map = arg1;
    }

    public final CompositionLocalMap getMap() {
        return this.map;
    }

    public void onAttach() {
        DelegatableNodeKt.requireLayoutNode(this).setCompositionLocalMap(this.map);
    }

    public final void setMap(CompositionLocalMap arg1) {
        this.map = arg1;
        DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this)).setCompositionLocalMap(arg1);
    }
}

