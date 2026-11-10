package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\f\u0010\u0017\u001A\u00020\u000F*\u00020\u0018H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0019"}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "create", "update", "", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class NestedScrollElement extends ModifierNodeElement {
    private final NestedScrollConnection connection;
    private final NestedScrollDispatcher dispatcher;

    public NestedScrollElement(NestedScrollConnection arg1, NestedScrollDispatcher arg2) {
        super();
        this.connection = arg1;
        this.dispatcher = arg2;
    }

    public Node create() {
        return this.create();
    }

    public NestedScrollNode create() {
        return new NestedScrollNode(this.connection, this.dispatcher);
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof NestedScrollElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(((NestedScrollElement)arg4).connection, this.connection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(((NestedScrollElement)arg4).dispatcher, this.dispatcher)) {
            return 0;
        }

        return 1;
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public int hashCode() {
        int v0 = this.connection.hashCode() * 0x1F;
        NestedScrollDispatcher v1 = this.dispatcher;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return v0 + v1_1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("nestedScroll");
        arg4.getProperties().set("connection", this.connection);
        arg4.getProperties().set("dispatcher", this.dispatcher);
    }

    public void update(Node arg1) {
        this.update(((NestedScrollNode)arg1));
    }

    public void update(NestedScrollNode arg2) {
        arg2.updateNode$ui(this.connection, this.dispatcher);
    }
}

