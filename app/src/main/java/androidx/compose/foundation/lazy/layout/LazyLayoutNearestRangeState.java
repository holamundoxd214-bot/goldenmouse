package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0003\u001A\u00020\u0004R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u00028V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u000E\u0010\u0011\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "Landroidx/compose/runtime/State;", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "<init>", "(III)V", "<set-?>", "value", "getValue", "()Lkotlin/ranges/IntRange;", "setValue", "(Lkotlin/ranges/IntRange;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "lastFirstVisibleItem", "update", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutNearestRangeState implements State {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0002¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState$Companion;", "", "<init>", "()V", "calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final IntRange access$calculateNearestItemsRange(Companion arg0, int arg1, int arg2, int arg3) {
            return arg0.calculateNearestItemsRange(arg1, arg2, arg3);
        }

        private final IntRange calculateNearestItemsRange(int arg2, int arg3, int arg4) {
            arg2 = arg2 / arg3 * arg3;
            return RangesKt.until(Math.max(arg2 - arg4, 0), arg2 + arg3 + arg4);
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private final int extraItemCount;
    private int lastFirstVisibleItem;
    private final int slidingWindowSize;
    private final MutableState value$delegate;

    static {
        LazyLayoutNearestRangeState.Companion = new Companion(null);
    }

    public LazyLayoutNearestRangeState(int arg2, int arg3, int arg4) {
        super();
        this.slidingWindowSize = arg3;
        this.extraItemCount = arg4;
        this.value$delegate = SnapshotStateKt.mutableStateOf(Companion.access$calculateNearestItemsRange(LazyLayoutNearestRangeState.Companion, arg2, arg3, arg4), SnapshotStateKt.structuralEqualityPolicy());
        this.lastFirstVisibleItem = arg2;
    }

    public Object getValue() {
        return this.getValue();
    }

    public IntRange getValue() {
        return this.value$delegate.getValue();
    }

    private void setValue(IntRange arg1) {
        this.value$delegate.setValue(arg1);
    }

    public final void update(int arg4) {
        if(arg4 != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = arg4;
            this.setValue(Companion.access$calculateNearestItemsRange(LazyLayoutNearestRangeState.Companion, arg4, this.slidingWindowSize, this.extraItemCount));
        }
    }
}

