package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0014\u001A\u00020\u0002H\u0016J\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0002H\u0016J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0096\u0002J\b\u0010\u001C\u001A\u00020\u0007H\u0016J\f\u0010\u001D\u001A\u00020\u0016*\u00020\u001EH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0019\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0019\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/lazy/ParentSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/ParentSizeNode;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "inspectorName", "", "<init>", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Ljava/lang/String;)V", "getFraction", "()F", "getWidthState", "()Landroidx/compose/runtime/State;", "getHeightState", "getInspectorName", "()Ljava/lang/String;", "create", "update", "", "node", "equals", "", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ParentSizeElement extends ModifierNodeElement {
    private final float fraction;
    private final State heightState;
    private final String inspectorName;
    private final State widthState;

    public ParentSizeElement(float arg2, State arg3, State arg4, String arg5, int arg6, DefaultConstructorMarker arg7) {
        State v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        this(arg2, arg3, arg4, arg5);
    }

    public ParentSizeElement(float arg1, State arg2, State arg3, String arg4) {
        super();
        this.fraction = arg1;
        this.widthState = arg2;
        this.heightState = arg3;
        this.inspectorName = arg4;
    }

    public ParentSizeNode create() {
        return new ParentSizeNode(this.fraction, this.widthState, this.heightState);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ParentSizeElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ParentSizeElement)) {
            return 0;
        }

        if(this.fraction == ((ParentSizeElement)arg5).fraction && (Intrinsics.areEqual(this.widthState, ((ParentSizeElement)arg5).widthState)) && (Intrinsics.areEqual(this.heightState, ((ParentSizeElement)arg5).heightState))) {
            return 1;
        }

        return 0;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final State getHeightState() {
        return this.heightState;
    }

    public final String getInspectorName() {
        return this.inspectorName;
    }

    public final State getWidthState() {
        return this.widthState;
    }

    public int hashCode() {
        State v0 = this.widthState;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        State v2 = this.heightState;
        if(v2 != null) {
            v1 = v2.hashCode();
        }

        return (v0_1 + v1) * 0x1F + Float.hashCode(this.fraction);
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName(this.inspectorName);
        arg2.setValue(Float.valueOf(this.fraction));
    }

    public void update(ParentSizeNode arg2) {
        arg2.setFraction(this.fraction);
        arg2.setWidthState(this.widthState);
        arg2.setHeightState(this.heightState);
    }

    public void update(Node arg1) {
        this.update(((ParentSizeNode)arg1));
    }
}

