package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0015\u001A\u00020\u0004HÂ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u001A\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DHÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0010\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\u0012\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2={"Landroidx/compose/foundation/shape/DpCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "valueOverride", "getValueOverride-D9Ej5fM", "()F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/compose/foundation/shape/DpCornerSize;", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DpCornerSize implements CornerSize, InspectableValue {
    private final float size;

    public DpCornerSize(float arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    private DpCornerSize(float arg1) {
        super();
        this.size = arg1;
    }

    private final float component1-D9Ej5fM() {
        return this.size;
    }

    public final DpCornerSize copy-0680j_4(float arg2) {
        return new DpCornerSize(arg2, null);
    }

    public static DpCornerSize copy-0680j_4$default(DpCornerSize arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.size;
        }

        return arg0.copy-0680j_4(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((DpCornerSize)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof DpCornerSize)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.size, ((DpCornerSize)arg4).size)) {
            return 0;
        }

        return 1;
    }

    public Object getValueOverride() {
        return Dp.box-impl(this.getValueOverride-D9Ej5fM());
    }

    public float getValueOverride-D9Ej5fM() {
        return this.size;
    }

    public int hashCode() {
        return Dp.hashCode-impl(this.size);
    }

    public float toPx-TmRCtEA(long arg1, Density arg3) {
        return arg3.toPx-0680j_4(this.size);
    }

    public String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }
}

