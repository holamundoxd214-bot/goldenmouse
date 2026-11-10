package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0018\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\b\u0010\u001F\u001A\u00020\u0013H\u0016J\b\u0010 \u001A\u00020\u0005H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR+\u0010\u000B\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006!"}, d2={"Landroidx/compose/foundation/layout/ValueInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "Landroidx/compose/foundation/layout/InsetsValues;", "name", "", "<init>", "(Landroidx/compose/foundation/layout/InsetsValues;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "<set-?>", "value", "getValue$foundation_layout", "()Landroidx/compose/foundation/layout/InsetsValues;", "setValue$foundation_layout", "(Landroidx/compose/foundation/layout/InsetsValues;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "equals", "", "other", "", "hashCode", "toString", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ValueInsets implements WindowInsets {
    public static final int $stable;
    private final String name;
    private final MutableState value$delegate;

    static {
    }

    public ValueInsets(InsetsValues arg2, String arg3) {
        super();
        this.name = arg3;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(arg2, null, 2, null);
    }

    public boolean equals(Object arg2) {
        if((((ValueInsets)arg2)) == this) {
            return 1;
        }

        if(!(arg2 instanceof ValueInsets)) {
            return 0;
        }

        return Intrinsics.areEqual(this.getValue$foundation_layout(), ((ValueInsets)arg2).getValue$foundation_layout());
    }

    public int getBottom(Density arg1) {
        return this.getValue$foundation_layout().getBottom();
    }

    public int getLeft(Density arg1, LayoutDirection arg2) {
        return this.getValue$foundation_layout().getLeft();
    }

    public final String getName() {
        return this.name;
    }

    public int getRight(Density arg1, LayoutDirection arg2) {
        return this.getValue$foundation_layout().getRight();
    }

    public int getTop(Density arg1) {
        return this.getValue$foundation_layout().getTop();
    }

    public final InsetsValues getValue$foundation_layout() {
        return this.value$delegate.getValue();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public final void setValue$foundation_layout(InsetsValues arg1) {
        this.value$delegate.setValue(arg1);
    }

    public String toString() {
        return this.name + "(left=" + this.getValue$foundation_layout().getLeft() + ", top=" + this.getValue$foundation_layout().getTop() + ", right=" + this.getValue$foundation_layout().getRight() + ", bottom=" + this.getValue$foundation_layout().getBottom() + ')';
    }
}

