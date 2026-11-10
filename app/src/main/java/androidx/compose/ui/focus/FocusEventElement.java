package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u0002H\u0016J\f\u0010\u000E\u001A\u00020\u0006*\u00020\u000FH\u0016J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u001D\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/ui/focus/FocusEventElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusEventNode;", "onFocusEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnFocusEvent", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusEventElement extends ModifierNodeElement {
    private final Function1 onFocusEvent;

    public FocusEventElement(Function1 arg1) {
        super();
        this.onFocusEvent = arg1;
    }

    public Node create() {
        return this.create();
    }

    public FocusEventNode create() {
        return new FocusEventNode(this.onFocusEvent);
    }

    public boolean equals(Object arg4) {
        if(this == (((FocusEventElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FocusEventElement)) {
            return 0;
        }

        if(this.onFocusEvent != ((FocusEventElement)arg4).onFocusEvent) {
            return 0;
        }

        return 1;
    }

    public final Function1 getOnFocusEvent() {
        return this.onFocusEvent;
    }

    public int hashCode() {
        return this.onFocusEvent.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("onFocusEvent");
        arg2.getProperties().set("onFocusEvent", this.onFocusEvent);
    }

    public void update(Node arg1) {
        this.update(((FocusEventNode)arg1));
    }

    public void update(FocusEventNode arg1) {
        arg1.setOnFocusEvent(this.onFocusEvent);
    }
}

