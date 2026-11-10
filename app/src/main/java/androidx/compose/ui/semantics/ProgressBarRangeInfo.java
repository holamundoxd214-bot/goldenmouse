package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0007H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0017"}, d2={"Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "", "current", "", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "<init>", "(FLkotlin/ranges/ClosedFloatingPointRange;I)V", "getCurrent", "()F", "getRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "getSteps", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ProgressBarRangeInfo {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/semantics/ProgressBarRangeInfo$Companion;", "", "<init>", "()V", "Indeterminate", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getIndeterminate", "()Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ProgressBarRangeInfo getIndeterminate() {
            return ProgressBarRangeInfo.Indeterminate;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final ProgressBarRangeInfo Indeterminate;
    private final float current;
    private final ClosedFloatingPointRange range;
    private final int steps;

    static {
        ProgressBarRangeInfo.Companion = new Companion(null);
        ProgressBarRangeInfo.Indeterminate = new ProgressBarRangeInfo(0f, RangesKt.rangeTo(0f, 0f), 0, 4, null);
    }

    public ProgressBarRangeInfo(float arg1, ClosedFloatingPointRange arg2, int arg3) {
        super();
        this.current = arg1;
        this.range = arg2;
        this.steps = arg3;
        if(!Float.isNaN(arg1)) {
            return;
        }

        throw new IllegalArgumentException("current must not be NaN".toString());
    }

    public ProgressBarRangeInfo(float arg1, ClosedFloatingPointRange arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, 0);
    }

    public static final ProgressBarRangeInfo access$getIndeterminate$cp() {
        return ProgressBarRangeInfo.Indeterminate;
    }

    public boolean equals(Object arg5) {
        if(this == (((ProgressBarRangeInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ProgressBarRangeInfo)) {
            return 0;
        }

        if(this.current == ((ProgressBarRangeInfo)arg5).current) {
            if(!Intrinsics.areEqual(this.range, ((ProgressBarRangeInfo)arg5).range)) {
                return 0;
            }

            if(this.steps != ((ProgressBarRangeInfo)arg5).steps) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final float getCurrent() {
        return this.current;
    }

    public final ClosedFloatingPointRange getRange() {
        return this.range;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return (Float.hashCode(this.current) * 0x1F + this.range.hashCode()) * 0x1F + this.steps;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.current + ", range=" + this.range + ", steps=" + this.steps + ')';
    }
}

