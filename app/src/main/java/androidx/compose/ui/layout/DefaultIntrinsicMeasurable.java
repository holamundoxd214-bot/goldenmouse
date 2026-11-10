package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0017H\u0016J\u0010\u0010\u0019\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0017H\u0016J\u0010\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0017H\u0016J\u0010\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0017H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001A\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001D"}, d2={"Landroidx/compose/ui/layout/DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "<init>", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMinMax;Landroidx/compose/ui/layout/IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultIntrinsicMeasurable implements Measurable {
    public static final int $stable = 8;
    private final IntrinsicMeasurable measurable;
    private final IntrinsicMinMax minMax;
    private final IntrinsicWidthHeight widthHeight;

    static {
    }

    public DefaultIntrinsicMeasurable(IntrinsicMeasurable arg1, IntrinsicMinMax arg2, IntrinsicWidthHeight arg3) {
        super();
        this.measurable = arg1;
        this.minMax = arg2;
        this.widthHeight = arg3;
    }

    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    public Object getParentData() {
        return this.measurable.getParentData();
    }

    public int maxIntrinsicHeight(int arg1) {
        return this.measurable.maxIntrinsicHeight(arg1);
    }

    public int maxIntrinsicWidth(int arg1) {
        return this.measurable.maxIntrinsicWidth(arg1);
    }

    public Placeable measure-BRTryo0(long arg5) {
        int v4_1;
        IntrinsicMeasurable v4;
        IntrinsicMinMax v0_1;
        IntrinsicWidthHeight v0 = this.widthHeight;
        IntrinsicWidthHeight v1 = IntrinsicWidthHeight.Width;
        IntrinsicMinMax v2 = this.minMax;
        int v3 = 0x7FFF;
        if(v0 == v1) {
            v0_1 = IntrinsicMinMax.Max;
            v4 = this.measurable;
            v4_1 = v2 == v0_1 ? v4.maxIntrinsicWidth(Constraints.getMaxHeight-impl(arg5)) : v4.minIntrinsicWidth(Constraints.getMaxHeight-impl(arg5));
            if(Constraints.getHasBoundedHeight-impl(arg5)) {
                v3 = Constraints.getMaxHeight-impl(arg5);
            }

            return new FixedSizeIntrinsicsPlaceable(v4_1, v3);
        }

        v0_1 = IntrinsicMinMax.Max;
        v4 = this.measurable;
        v4_1 = v2 == v0_1 ? v4.maxIntrinsicHeight(Constraints.getMaxWidth-impl(arg5)) : v4.minIntrinsicHeight(Constraints.getMaxWidth-impl(arg5));
        if(Constraints.getHasBoundedWidth-impl(arg5)) {
            v3 = Constraints.getMaxWidth-impl(arg5);
        }

        return new FixedSizeIntrinsicsPlaceable(v3, v4_1);
    }

    public int minIntrinsicHeight(int arg1) {
        return this.measurable.minIntrinsicHeight(arg1);
    }

    public int minIntrinsicWidth(int arg1) {
        return this.measurable.minIntrinsicWidth(arg1);
    }
}

