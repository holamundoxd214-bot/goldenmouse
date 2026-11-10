package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tJ\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0006J\u0006\u0010\u000E\u001A\u00020\u000FR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "<init>", "()V", "beyondBoundsItems", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "addInterval", "start", "", "end", "removeInterval", "", "interval", "hasIntervals", "", "getStart", "()I", "getEnd", "Interval", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutBeyondBoundsInfo {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Interval {
        public static final int $stable;
        private final int end;
        private final int start;

        static {
        }

        public Interval(int arg3, int arg4) {
            super();
            this.start = arg3;
            this.end = arg4;
            int v2 = 1;
            int v1 = arg3 >= 0 ? 1 : 0;
            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("negative start index");
            }

            if(arg4 >= arg3) {
            }
            else {
                v2 = 0;
            }

            if(v2 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("end index greater than start");
            }
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final Interval copy(int arg1, int arg2) {
            return new Interval(arg1, arg2);
        }

        public static Interval copy$default(Interval arg0, int arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.start;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.end;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Interval)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Interval)) {
                return 0;
            }

            if(this.start != ((Interval)arg5).start) {
                return 0;
            }

            if(this.end != ((Interval)arg5).end) {
                return 0;
            }

            return 1;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return Integer.hashCode(this.start) * 0x1F + Integer.hashCode(this.end);
        }

        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + ')';
        }
    }

    public static final int $stable;
    private final MutableVector beyondBoundsItems;

    static {
        LazyLayoutBeyondBoundsInfo.$stable = MutableVector.$stable;
    }

    public LazyLayoutBeyondBoundsInfo() {
        super();
        this.beyondBoundsItems = new MutableVector(new Interval[16], 0);
    }

    public final Interval addInterval(int arg2, int arg3) {
        Interval v0 = new Interval(arg2, arg3);
        this.beyondBoundsItems.add(v0);
        return v0;
    }

    public final int getEnd() {
        int v0 = this.beyondBoundsItems.first().getEnd();
        MutableVector v5 = this.beyondBoundsItems;
        Object[] v1 = v5.content;
        int v5_1 = v5.getSize();
        int v2;
        for(v2 = 0; v2 < v5_1; ++v2) {
            Object v3 = v1[v2];
            if(((Interval)v3).getEnd() > v0) {
                v0 = ((Interval)v3).getEnd();
            }
        }

        return v0;
    }

    public final int getStart() {
        int v0 = this.beyondBoundsItems.first().getStart();
        MutableVector v6 = this.beyondBoundsItems;
        Object[] v1 = v6.content;
        int v6_1 = v6.getSize();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v6_1; ++v3) {
            Object v4 = v1[v3];
            if(((Interval)v4).getStart() < v0) {
                v0 = ((Interval)v4).getStart();
            }
        }

        if(v0 >= 0) {
            v2 = 1;
        }

        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative minIndex");
        }

        return v0;
    }

    public final boolean hasIntervals() {
        if(this.beyondBoundsItems.getSize() != 0) {
            return 1;
        }

        return 0;
    }

    public final void removeInterval(Interval arg1) {
        this.beyondBoundsItems.remove(arg1);
    }
}

