package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\f\u0010\u0011\u001A\u00020\u000F*\u00020\u0012H\u0016J\u0013\u0010\u0013\u001A\u00020\u00062\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u001F\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\u0018"}, d2={"Landroidx/compose/ui/input/key/KeyInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/key/KeyInputNode;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreKeyEvent", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreKeyEvent", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class KeyInputElement extends ModifierNodeElement {
    private final Function1 onKeyEvent;
    private final Function1 onPreKeyEvent;

    public KeyInputElement(Function1 arg1, Function1 arg2) {
        super();
        this.onKeyEvent = arg1;
        this.onPreKeyEvent = arg2;
    }

    public Node create() {
        return this.create();
    }

    public KeyInputNode create() {
        return new KeyInputNode(this.onKeyEvent, this.onPreKeyEvent);
    }

    public boolean equals(Object arg5) {
        if(this == (((KeyInputElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof KeyInputElement)) {
            return 0;
        }

        if(this.onKeyEvent != ((KeyInputElement)arg5).onKeyEvent) {
            return 0;
        }

        if(this.onPreKeyEvent != ((KeyInputElement)arg5).onPreKeyEvent) {
            return 0;
        }

        return 1;
    }

    public final Function1 getOnKeyEvent() {
        return this.onKeyEvent;
    }

    public final Function1 getOnPreKeyEvent() {
        return this.onPreKeyEvent;
    }

    public int hashCode() {
        Function1 v0 = this.onKeyEvent;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        Function1 v2 = this.onPreKeyEvent;
        if(v2 != null) {
            v1 = v2.hashCode();
        }

        return v0_1 + v1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        Function1 v0 = this.onKeyEvent;
        if(v0 != null) {
            arg4.setName("onKeyEvent");
            arg4.getProperties().set("onKeyEvent", v0);
        }

        Function1 v3 = this.onPreKeyEvent;
        if(v3 != null) {
            arg4.setName("onPreviewKeyEvent");
            arg4.getProperties().set("onPreviewKeyEvent", v3);
        }
    }

    public void update(Node arg1) {
        this.update(((KeyInputNode)arg1));
    }

    public void update(KeyInputNode arg2) {
        arg2.setOnEvent(this.onKeyEvent);
        arg2.setOnPreEvent(this.onPreKeyEvent);
    }
}

