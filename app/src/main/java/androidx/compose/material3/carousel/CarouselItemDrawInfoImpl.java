package androidx.compose.material3.carousel;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001A\u0004\b\u000E\u0010\b\"\u0004\b\u000F\u0010\nR+\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001A\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR+\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u00158F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001D\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\bR\u0014\u0010\u001F\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010\bR\u0014\u0010!\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\bR\u0014\u0010#\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\u0018¨\u0006%"}, d2={"Landroidx/compose/material3/carousel/CarouselItemDrawInfoImpl;", "Landroidx/compose/material3/carousel/CarouselItemDrawInfo;", "<init>", "()V", "<set-?>", "", "sizeState", "getSizeState", "()F", "setSizeState", "(F)V", "sizeState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "minSizeState", "getMinSizeState", "setMinSizeState", "minSizeState$delegate", "maxSizeState", "getMaxSizeState", "setMaxSizeState", "maxSizeState$delegate", "Landroidx/compose/ui/geometry/Rect;", "maskRectState", "getMaskRectState", "()Landroidx/compose/ui/geometry/Rect;", "setMaskRectState", "(Landroidx/compose/ui/geometry/Rect;)V", "maskRectState$delegate", "Landroidx/compose/runtime/MutableState;", "size", "getSize", "minSize", "getMinSize", "maxSize", "getMaxSize", "maskRect", "getMaskRect", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CarouselItemDrawInfoImpl implements CarouselItemDrawInfo {
    public static final int $stable;
    private final MutableState maskRectState$delegate;
    private final MutableFloatState maxSizeState$delegate;
    private final MutableFloatState minSizeState$delegate;
    private final MutableFloatState sizeState$delegate;

    static {
    }

    public CarouselItemDrawInfoImpl() {
        super();
        this.sizeState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.minSizeState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.maxSizeState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.maskRectState$delegate = SnapshotStateKt.mutableStateOf$default(Rect.Companion.getZero(), null, 2, null);
    }

    public Rect getMaskRect() {
        return this.getMaskRectState();
    }

    public final Rect getMaskRectState() {
        return this.maskRectState$delegate.getValue();
    }

    public float getMaxSize() {
        return this.getMaxSizeState();
    }

    public final float getMaxSizeState() {
        return this.maxSizeState$delegate.getFloatValue();
    }

    public float getMinSize() {
        return this.getMinSizeState();
    }

    public final float getMinSizeState() {
        return this.minSizeState$delegate.getFloatValue();
    }

    public float getSize() {
        return this.getSizeState();
    }

    public final float getSizeState() {
        return this.sizeState$delegate.getFloatValue();
    }

    public final void setMaskRectState(Rect arg1) {
        this.maskRectState$delegate.setValue(arg1);
    }

    public final void setMaxSizeState(float arg1) {
        this.maxSizeState$delegate.setFloatValue(arg1);
    }

    public final void setMinSizeState(float arg1) {
        this.minSizeState$delegate.setFloatValue(arg1);
    }

    public final void setSizeState(float arg1) {
        this.sizeState$delegate.setFloatValue(arg1);
    }
}

