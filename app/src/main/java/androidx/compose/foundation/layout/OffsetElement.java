package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\u0013\u0010\u001A\u001A\u00020\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\b\u0010\u001F\u001A\u00020 H\u0016J\f\u0010!\u001A\u00020\u000B*\u00020\nH\u0016R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0005\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Landroidx/compose/foundation/layout/OffsetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetNode;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", "F", "getY-D9Ej5fM", "getRtlAware", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "equals", "other", "", "hashCode", "", "toString", "", "inspectableProperties", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class OffsetElement extends ModifierNodeElement {
    private final Function1 inspectorInfo;
    private final boolean rtlAware;
    private final float x;
    private final float y;

    private OffsetElement(float arg1, float arg2, boolean arg3, Function1 arg4) {
        super();
        this.x = arg1;
        this.y = arg2;
        this.rtlAware = arg3;
        this.inspectorInfo = arg4;
    }

    public OffsetElement(float arg1, float arg2, boolean arg3, Function1 arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public OffsetNode create() {
        return new OffsetNode(this.x, this.y, this.rtlAware, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((OffsetElement)arg5))) {
            return 1;
        }

        if((arg5 instanceof OffsetElement)) {
        }
        else {
            OffsetElement v5 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Dp.equals-impl0(this.x, v5.x)) && (Dp.equals-impl0(this.y, v5.y)) && this.rtlAware == v5.rtlAware) {
            return 1;
        }

        return 0;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final float getX-D9Ej5fM() {
        return this.x;
    }

    public final float getY-D9Ej5fM() {
        return this.y;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.x) * 0x1F + Dp.hashCode-impl(this.y)) * 0x1F + Boolean.hashCode(this.rtlAware);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public String toString() {
        return "OffsetModifierElement(x=" + Dp.toString-impl(this.x) + ", y=" + Dp.toString-impl(this.y) + ", rtlAware=" + this.rtlAware + ')';
    }

    public void update(OffsetNode arg3) {
        arg3.update-Md-fbLM(this.x, this.y, this.rtlAware);
    }

    public void update(Node arg1) {
        this.update(((OffsetNode)arg1));
    }
}

