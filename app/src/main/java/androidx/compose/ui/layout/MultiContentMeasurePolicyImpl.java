package androidx.compose.ui.layout;

import androidx.compose.ui.node.MeasureScopeWithLayoutNodeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\b\u001A\u00020\t*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\"\u0010\u0017\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001A\u00020\u0013H\u0016J\"\u0010\u0019\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\"\u0010\u001A\u001A\u00020\u0013*\u00020\u00142\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001A\u00020\u0013H\u0016J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001A\u00020\u0013HÖ\u0001J\t\u0010\"\u001A\u00020#HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006$"}, d2={"Landroidx/compose/ui/layout/MultiContentMeasurePolicyImpl;", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "<init>", "(Landroidx/compose/ui/layout/MultiContentMeasurePolicy;)V", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiContentMeasurePolicyImpl implements MeasurePolicy {
    public static final int $stable;
    private final MultiContentMeasurePolicy measurePolicy;

    static {
    }

    public MultiContentMeasurePolicyImpl(MultiContentMeasurePolicy arg1) {
        super();
        this.measurePolicy = arg1;
    }

    public final MultiContentMeasurePolicy component1() {
        return this.measurePolicy;
    }

    public final MultiContentMeasurePolicyImpl copy(MultiContentMeasurePolicy arg1) {
        return new MultiContentMeasurePolicyImpl(arg1);
    }

    public static MultiContentMeasurePolicyImpl copy$default(MultiContentMeasurePolicyImpl arg0, MultiContentMeasurePolicy arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.measurePolicy;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((MultiContentMeasurePolicyImpl)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof MultiContentMeasurePolicyImpl)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.measurePolicy, ((MultiContentMeasurePolicyImpl)arg4).measurePolicy)) {
            return 0;
        }

        return 1;
    }

    public final MultiContentMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public int hashCode() {
        return this.measurePolicy.hashCode();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return this.measurePolicy.maxIntrinsicHeight(arg1, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(arg1), arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return this.measurePolicy.maxIntrinsicWidth(arg1, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(arg1), arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg1, List arg2, long arg3) {
        return this.measurePolicy.measure-3p2s80s(arg1, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(arg1), arg3);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return this.measurePolicy.minIntrinsicHeight(arg1, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(arg1), arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return this.measurePolicy.minIntrinsicWidth(arg1, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(arg1), arg3);
    }

    public String toString() {
        return "MultiContentMeasurePolicyImpl(measurePolicy=" + this.measurePolicy + ')';
    }
}

