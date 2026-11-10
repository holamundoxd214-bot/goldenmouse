package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R+\u0010\t\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR$\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00038V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0012\u0010\u000B\"\u0004\b\u0013\u0010\rR+\u0010\u0014\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u000F\u001A\u0004\b\u0015\u0010\u000B\"\u0004\b\u0016\u0010\rR\u0014\u0010\u0018\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u000BR\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/material3/BottomAppBarStateImpl;", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "<init>", "(FFF)V", "<set-?>", "heightOffsetLimit", "getHeightOffsetLimit", "()F", "setHeightOffsetLimit", "(F)V", "heightOffsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "contentOffset", "getContentOffset", "setContentOffset", "contentOffset$delegate", "collapsedFraction", "getCollapsedFraction", "_heightOffset", "Landroidx/compose/runtime/MutableFloatState;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class BottomAppBarStateImpl implements BottomAppBarState {
    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private final MutableFloatState heightOffsetLimit$delegate;

    public BottomAppBarStateImpl(float arg1, float arg2, float arg3) {
        super();
        this.heightOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg1);
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg3);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg2);
    }

    public float getCollapsedFraction() {
        if(this.getHeightOffsetLimit() == 0f) {
            return 0;
        }

        return this.getHeightOffset() / this.getHeightOffsetLimit();
    }

    public float getContentOffset() {
        return this.contentOffset$delegate.getFloatValue();
    }

    public float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public float getHeightOffsetLimit() {
        return this.heightOffsetLimit$delegate.getFloatValue();
    }

    public void setContentOffset(float arg1) {
        this.contentOffset$delegate.setFloatValue(arg1);
    }

    public void setHeightOffset(float arg3) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(arg3, this.getHeightOffsetLimit(), 0f));
    }

    public void setHeightOffsetLimit(float arg1) {
        this.heightOffsetLimit$delegate.setFloatValue(arg1);
    }
}

