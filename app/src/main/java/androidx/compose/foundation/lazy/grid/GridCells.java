package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\b\t\nJ\"\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/grid/GridCells;", "", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "Fixed", "Adaptive", "FixedSize", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface GridCells {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0016J\b\u0010\r\u001A\u00020\tH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/lazy/grid/GridCells$Adaptive;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Adaptive implements GridCells {
        public static final int $stable;
        private final float minSize;

        static {
        }

        private Adaptive(float arg1) {
            super();
            this.minSize = arg1;
            int v0 = Dp.compareTo-0680j_4(arg1, Dp.constructor-impl(0f)) > 0 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Provided min size should be larger than zero.");
            }
        }

        public Adaptive(float arg1, DefaultConstructorMarker arg2) {
            this(arg1);
        }

        public List calculateCrossAxisCellSizes(Density arg2, int arg3, int arg4) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(arg3, Math.max((arg3 + arg4) / (arg2.roundToPx-0680j_4(this.minSize) + arg4), 1), arg4);
        }

        public boolean equals(Object arg2) {
            if(((arg2 instanceof Adaptive)) && (Dp.equals-impl0(this.minSize, ((Adaptive)arg2).minSize))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.minSize);
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0003H\u0016J\b\u0010\u000B\u001A\u00020\u0003H\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/lazy/grid/GridCells$Fixed;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "count", "", "<init>", "(I)V", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Fixed implements GridCells {
        public static final int $stable;
        private final int count;

        static {
        }

        public Fixed(int arg1) {
            super();
            this.count = arg1;
            int v0 = arg1 > 0 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Provided count should be larger than zero");
            }
        }

        public List calculateCrossAxisCellSizes(Density arg1, int arg2, int arg3) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(arg2, this.count, arg3);
        }

        public boolean equals(Object arg2) {
            if(((arg2 instanceof Fixed)) && this.count == ((Fixed)arg2).count) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return -this.count;
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0016J\b\u0010\r\u001A\u00020\tH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/lazy/grid/GridCells$FixedSize;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "size", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FixedSize implements GridCells {
        public static final int $stable;
        private final float size;

        static {
        }

        private FixedSize(float arg1) {
            super();
            this.size = arg1;
            int v0 = Dp.compareTo-0680j_4(arg1, Dp.constructor-impl(0f)) > 0 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Provided size should be larger than zero.");
            }
        }

        public FixedSize(float arg1, DefaultConstructorMarker arg2) {
            this(arg1);
        }

        public List calculateCrossAxisCellSizes(Density arg2, int arg3, int arg4) {
            int v1 = arg2.roundToPx-0680j_4(this.size);
            int v2 = v1 + arg4;
            arg4 += arg3;
            if(v2 < arg4) {
                arg4 /= v2;
                ArrayList v2_1 = new ArrayList(arg4);
                for(arg3 = 0; arg3 < arg4; ++arg3) {
                    v2_1.add(Integer.valueOf(v1));
                }

                return ((List)v2_1);
            }

            ArrayList v1_1 = new ArrayList(1);
            v1_1.add(Integer.valueOf(arg3));
            return ((List)v1_1);
        }

        public boolean equals(Object arg2) {
            if(((arg2 instanceof FixedSize)) && (Dp.equals-impl0(this.size, ((FixedSize)arg2).size))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.size);
        }
    }

    List calculateCrossAxisCellSizes(Density arg1, int arg2, int arg3);
}

