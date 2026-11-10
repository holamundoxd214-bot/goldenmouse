package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\f\u0010\u0014\u001A\u00020\u0015*\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u001F\u0010\u0006\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/ui/input/pointer/SuspendPointerInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "key1", "", "key2", "keys", "", "pointerInputEventHandler", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "getKey1", "()Ljava/lang/Object;", "getKey2", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getPointerInputEventHandler", "()Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "create", "update", "node", "equals", "", "other", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SuspendPointerInputElement extends ModifierNodeElement {
    public static final int $stable;
    private final Object key1;
    private final Object key2;
    private final Object[] keys;
    private final PointerInputEventHandler pointerInputEventHandler;

    static {
    }

    public SuspendPointerInputElement(Object arg1, Object arg2, Object[] arg3, PointerInputEventHandler arg4) {
        super();
        this.key1 = arg1;
        this.key2 = arg2;
        this.keys = arg3;
        this.pointerInputEventHandler = arg4;
    }

    public SuspendPointerInputElement(Object arg2, Object arg3, Object[] arg4, PointerInputEventHandler arg5, int arg6, DefaultConstructorMarker arg7) {
        Object v0 = null;
        if((arg6 & 1) != 0) {
            arg2 = v0;
        }

        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = ((Object[])v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public Node create() {
        return this.create();
    }

    public SuspendingPointerInputModifierNodeImpl create() {
        return new SuspendingPointerInputModifierNodeImpl(this.key1, this.key2, this.keys, this.pointerInputEventHandler);
    }

    public boolean equals(Object arg5) {
        if(this == (((SuspendPointerInputElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SuspendPointerInputElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.key1, ((SuspendPointerInputElement)arg5).key1)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.key2, ((SuspendPointerInputElement)arg5).key2)) {
            return 0;
        }

        Object[] v1 = this.keys;
        if(v1 != null) {
            Object[] v3 = ((SuspendPointerInputElement)arg5).keys;
            if(v3 == null) {
                return 0;
            }
            else if(!Arrays.equals(v1, v3)) {
                return 0;
            }
        }
        else if(((SuspendPointerInputElement)arg5).keys != null) {
            return 0;
        }

        if(this.pointerInputEventHandler == ((SuspendPointerInputElement)arg5).pointerInputEventHandler) {
            return 1;
        }

        return 0;
    }

    public final Object getKey1() {
        return this.key1;
    }

    public final Object getKey2() {
        return this.key2;
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final PointerInputEventHandler getPointerInputEventHandler() {
        return this.pointerInputEventHandler;
    }

    public int hashCode() {
        Object v0 = this.key1;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        Object v2 = this.key2;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Object[] v2_2 = this.keys;
        if(v2_2 != null) {
            v1 = Arrays.hashCode(v2_2);
        }

        return (v0_1 + v1) * 0x1F + this.pointerInputEventHandler.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("pointerInput");
        arg4.getProperties().set("key1", this.key1);
        arg4.getProperties().set("key2", this.key2);
        arg4.getProperties().set("keys", this.keys);
        arg4.getProperties().set("pointerInputEventHandler", this.pointerInputEventHandler);
    }

    public void update(Node arg1) {
        this.update(((SuspendingPointerInputModifierNodeImpl)arg1));
    }

    public void update(SuspendingPointerInputModifierNodeImpl arg4) {
        arg4.update$ui(this.key1, this.key2, this.keys, this.pointerInputEventHandler);
    }
}

