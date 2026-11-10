package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "", "value", "", "<init>", "(I)V", "getValue$foundation", "()I", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StaggeredGridItemSpan {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan$Companion;", "", "<init>", "()V", "FullLine", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "getFullLine", "()Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "SingleLane", "getSingleLane", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final StaggeredGridItemSpan getFullLine() {
            return StaggeredGridItemSpan.FullLine;
        }

        public final StaggeredGridItemSpan getSingleLane() {
            return StaggeredGridItemSpan.SingleLane;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final StaggeredGridItemSpan FullLine;
    private static final StaggeredGridItemSpan SingleLane;
    private final int value;

    static {
        StaggeredGridItemSpan.Companion = new Companion(null);
        StaggeredGridItemSpan.FullLine = new StaggeredGridItemSpan(0);
        StaggeredGridItemSpan.SingleLane = new StaggeredGridItemSpan(1);
    }

    private StaggeredGridItemSpan(int arg1) {
        super();
        this.value = arg1;
    }

    public static final StaggeredGridItemSpan access$getFullLine$cp() {
        return StaggeredGridItemSpan.FullLine;
    }

    public static final StaggeredGridItemSpan access$getSingleLane$cp() {
        return StaggeredGridItemSpan.SingleLane;
    }

    public final int getValue$foundation() {
        return this.value;
    }
}

