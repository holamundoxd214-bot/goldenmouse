package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B&\u0012\u001D\u0010\u0002\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R%\u0010\u0002\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlotCache;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "calculation", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "cachedConstraints", "J", "cachedDensity", "", "cachedSizes", "invoke", "density", "constraints", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyStaggeredGridSlotCache implements LazyGridStaggeredGridSlotsProvider {
    private long cachedConstraints;
    private float cachedDensity;
    private LazyStaggeredGridSlots cachedSizes;
    private final Function2 calculation;

    public LazyStaggeredGridSlotCache(Function2 arg7) {
        super();
        this.calculation = arg7;
        this.cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    }

    public LazyStaggeredGridSlots invoke-0kLqBqw(Density arg3, long arg4) {
        if(this.cachedSizes != null && (Constraints.equals-impl0(this.cachedConstraints, arg4)) && this.cachedDensity == arg3.getDensity()) {
            LazyStaggeredGridSlots v2 = this.cachedSizes;
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        this.cachedConstraints = arg4;
        this.cachedDensity = arg3.getDensity();
        Object v3 = this.calculation.invoke(arg3, Constraints.box-impl(arg4));
        this.cachedSizes = ((LazyStaggeredGridSlots)v3);
        return ((LazyStaggeredGridSlots)v3);
    }
}

