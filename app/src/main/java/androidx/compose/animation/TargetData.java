package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR+\u0010\u0002\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000F\u001A\u0004\b\u0010\u0010\u000B\"\u0004\b\u0011\u0010\rR+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000F\u001A\u0004\b\u0013\u0010\u000B\"\u0004\b\u0014\u0010\rR+\u0010\u0016\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000F\u001A\u0004\b\u0017\u0010\u000B\"\u0004\b\u0018\u0010\r¨\u0006\u001A"}, d2={"Landroidx/compose/animation/TargetData;", "", "size", "Landroidx/compose/ui/geometry/Size;", "initialMfrOffset", "Landroidx/compose/ui/geometry/Offset;", "targetStructuralOffset", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "getInitialMfrOffset-F1C5BW0", "setInitialMfrOffset-k-4lQ0M", "initialMfrOffset$delegate", "getTargetStructuralOffset-F1C5BW0", "setTargetStructuralOffset-k-4lQ0M", "targetStructuralOffset$delegate", "currentMfrOffset", "getCurrentMfrOffset-F1C5BW0", "setCurrentMfrOffset-k-4lQ0M", "currentMfrOffset$delegate", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TargetData {
    public static final int $stable;
    private final MutableState currentMfrOffset$delegate;
    private final MutableState initialMfrOffset$delegate;
    private final MutableState size$delegate;
    private final MutableState targetStructuralOffset$delegate;

    static {
    }

    public TargetData(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    private TargetData(long arg2, long arg4, long arg6) {
        super();
        this.size$delegate = SnapshotStateKt.mutableStateOf$default(Size.box-impl(arg2), null, 2, null);
        this.initialMfrOffset$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(arg4), null, 2, null);
        this.targetStructuralOffset$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(arg6), null, 2, null);
        this.currentMfrOffset$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(arg4), null, 2, null);
    }

    public final long getCurrentMfrOffset-F1C5BW0() {
        return this.currentMfrOffset$delegate.getValue().unbox-impl();
    }

    public final long getInitialMfrOffset-F1C5BW0() {
        return this.initialMfrOffset$delegate.getValue().unbox-impl();
    }

    public final long getSize-NH-jbRc() {
        return this.size$delegate.getValue().unbox-impl();
    }

    public final long getTargetStructuralOffset-F1C5BW0() {
        return this.targetStructuralOffset$delegate.getValue().unbox-impl();
    }

    public final void setCurrentMfrOffset-k-4lQ0M(long arg1) {
        this.currentMfrOffset$delegate.setValue(Offset.box-impl(arg1));
    }

    public final void setInitialMfrOffset-k-4lQ0M(long arg1) {
        this.initialMfrOffset$delegate.setValue(Offset.box-impl(arg1));
    }

    public final void setSize-uvyYCjk(long arg1) {
        this.size$delegate.setValue(Size.box-impl(arg1));
    }

    public final void setTargetStructuralOffset-k-4lQ0M(long arg1) {
        this.targetStructuralOffset$delegate.setValue(Offset.box-impl(arg1));
    }
}

