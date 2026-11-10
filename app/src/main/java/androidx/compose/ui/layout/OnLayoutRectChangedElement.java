package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0002H\u0016J\f\u0010\u0014\u001A\u00020\t*\u00020\u0015H\u0016J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2={"Landroidx/compose/ui/layout/OnLayoutRectChangedElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnLayoutRectChangedNode;", "throttleMillis", "", "debounceMillis", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "<init>", "(JJLkotlin/jvm/functions/Function1;)V", "getThrottleMillis", "()J", "getDebounceMillis", "getCallback", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OnLayoutRectChangedElement extends ModifierNodeElement {
    private final Function1 callback;
    private final long debounceMillis;
    private final long throttleMillis;

    public OnLayoutRectChangedElement(long arg1, long arg3, Function1 arg5) {
        super();
        this.throttleMillis = arg1;
        this.debounceMillis = arg3;
        this.callback = arg5;
    }

    public Node create() {
        return this.create();
    }

    public OnLayoutRectChangedNode create() {
        return new OnLayoutRectChangedNode(this.throttleMillis, this.debounceMillis, this.callback);
    }

    public boolean equals(Object arg8) {
        if(this == (((OnLayoutRectChangedElement)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof OnLayoutRectChangedElement)) {
            return 0;
        }

        if(this.throttleMillis != ((OnLayoutRectChangedElement)arg8).throttleMillis) {
            return 0;
        }

        if(this.debounceMillis != ((OnLayoutRectChangedElement)arg8).debounceMillis) {
            return 0;
        }

        if(this.callback != ((OnLayoutRectChangedElement)arg8).callback) {
            return 0;
        }

        return 1;
    }

    public final Function1 getCallback() {
        return this.callback;
    }

    public final long getDebounceMillis() {
        return this.debounceMillis;
    }

    public final long getThrottleMillis() {
        return this.throttleMillis;
    }

    public int hashCode() {
        return (Long.hashCode(this.throttleMillis) * 0x1F + Long.hashCode(this.debounceMillis)) * 0x1F + this.callback.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("onRectChanged");
        arg4.getProperties().set("throttleMillis", Long.valueOf(this.throttleMillis));
        arg4.getProperties().set("debounceMillis", Long.valueOf(this.debounceMillis));
        arg4.getProperties().set("callback", this.callback);
    }

    public void update(Node arg1) {
        this.update(((OnLayoutRectChangedNode)arg1));
    }

    public void update(OnLayoutRectChangedNode arg3) {
        arg3.setThrottleMillis(this.throttleMillis);
        arg3.setDebounceMillis(this.debounceMillis);
        arg3.setCallback(this.callback);
        arg3.disposeAndRegister();
    }
}

