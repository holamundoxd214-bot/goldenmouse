package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0014\u001A\u00020\u0002H\u0016J\u0010\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\u0002H\u0016J\u0013\u0010\u0017\u001A\u00020\t2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\f\u0010\u001E\u001A\u00020\f*\u00020\u000BH\u0016R\"\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\"\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/layout/OffsetPxElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetPxNode;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "rtlAware", "", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "", "<init>", "(Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;)V", "getOffset", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "getInspectorInfo", "create", "update", "node", "equals", "other", "", "toString", "", "hashCode", "", "inspectableProperties", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class OffsetPxElement extends ModifierNodeElement {
    private final Function1 inspectorInfo;
    private final Function1 offset;
    private final boolean rtlAware;

    public OffsetPxElement(Function1 arg1, boolean arg2, Function1 arg3) {
        super();
        this.offset = arg1;
        this.rtlAware = arg2;
        this.inspectorInfo = arg3;
    }

    public OffsetPxNode create() {
        return new OffsetPxNode(this.offset, this.rtlAware);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((OffsetPxElement)arg5))) {
            return 1;
        }

        if((arg5 instanceof OffsetPxElement)) {
        }
        else {
            OffsetPxElement v5 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.offset == v5.offset && this.rtlAware == v5.rtlAware) {
            return 1;
        }

        return 0;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final Function1 getOffset() {
        return this.offset;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public int hashCode() {
        return this.offset.hashCode() * 0x1F + Boolean.hashCode(this.rtlAware);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public String toString() {
        return "OffsetPxModifier(offset=" + this.offset + ", rtlAware=" + this.rtlAware + ')';
    }

    public void update(OffsetPxNode arg2) {
        arg2.update(this.offset, this.rtlAware);
    }

    public void update(Node arg1) {
        this.update(((OffsetPxNode)arg1));
    }
}

