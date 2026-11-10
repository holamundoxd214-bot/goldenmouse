package androidx.compose.ui;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\f\u0010\u0013\u001A\u00020\u000B*\u00020\u0014H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/CompositionLocalMapInjectionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/CompositionLocalMapInjectionNode;", "map", "Landroidx/compose/runtime/CompositionLocalMap;", "<init>", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "getMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "create", "update", "", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CompositionLocalMapInjectionElement extends ModifierNodeElement {
    public static final int $stable;
    private final CompositionLocalMap map;

    static {
    }

    public CompositionLocalMapInjectionElement(CompositionLocalMap arg1) {
        super();
        this.map = arg1;
    }

    public CompositionLocalMapInjectionNode create() {
        return new CompositionLocalMapInjectionNode(this.map);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof CompositionLocalMapInjectionElement)) && (Intrinsics.areEqual(((CompositionLocalMapInjectionElement)arg2).map, this.map))) {
            return 1;
        }

        return 0;
    }

    public final CompositionLocalMap getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("<Injected CompositionLocalMap>");
    }

    public void update(CompositionLocalMapInjectionNode arg1) {
        arg1.setMap(this.map);
    }

    public void update(Node arg1) {
        this.update(((CompositionLocalMapInjectionNode)arg1));
    }
}

