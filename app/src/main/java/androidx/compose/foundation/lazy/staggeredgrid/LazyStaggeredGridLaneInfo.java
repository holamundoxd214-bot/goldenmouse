package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0001\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005J\u000E\u0010\u000F\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u0005J\u0016\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0005J\u0006\u0010\u0013\u001A\u00020\u0005J\u0006\u0010\u0014\u001A\u00020\u0005J\u0006\u0010\u0015\u001A\u00020\fJ\u0016\u0010\u0016\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0005J\u0016\u0010\u0017\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0005J\u000E\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0005J\u0018\u0010\u001A\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00052\b\u0010\u001B\u001A\u0004\u0018\u00010\u0007J\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u00072\u0006\u0010\r\u001A\u00020\u0005J\u001A\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "", "<init>", "()V", "anchor", "", "lanes", "", "spannedItems", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "setLane", "", "itemIndex", "lane", "getLane", "assignedToLane", "", "targetLane", "upperBound", "lowerBound", "reset", "findPreviousItemIndex", "findNextItemIndex", "ensureValidIndex", "requestedIndex", "setGaps", "gaps", "getGaps", "ensureCapacity", "capacity", "newOffset", "SpannedItem", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridLaneInfo {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$Companion;", "", "<init>", "()V", "MaxCapacity", "", "LaneUnset", "LaneFullSpan", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "", "index", "", "gaps", "", "<init>", "(I[I)V", "getIndex", "()I", "getGaps", "()[I", "setGaps", "([I)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SpannedItem {
        private int[] gaps;
        private final int index;

        public SpannedItem(int arg1, int[] arg2) {
            super();
            this.index = arg1;
            this.gaps = arg2;
        }

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] arg1) {
            this.gaps = arg1;
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int LaneFullSpan = -2;
    public static final int LaneUnset = -1;
    private static final int MaxCapacity = 0x20000;
    private int anchor;
    private int[] lanes;
    private final ArrayDeque spannedItems;

    static {
        LazyStaggeredGridLaneInfo.Companion = new Companion(null);
        LazyStaggeredGridLaneInfo.$stable = 8;
    }

    public LazyStaggeredGridLaneInfo() {
        super();
        this.lanes = new int[16];
        this.spannedItems = new ArrayDeque();
    }

    public final boolean assignedToLane(int arg1, int arg2) {
        int v0 = this.getLane(arg1);
        if(v0 != arg2 && v0 != -1) {
            if(v0 == -2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final void ensureCapacity(int arg9, int arg10) {
        int v0 = arg9 <= 0x20000 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Requested item capacity " + arg9 + " is larger than max supported: 131072!");
        }

        int[] v0_1 = this.lanes;
        if(v0_1.length < arg9) {
            for(v0 = v0_1.length; v0 < arg9; v0 *= 2) {
            }

            this.lanes = ArraysKt.copyInto$default(this.lanes, new int[v0], arg10, 0, 0, 12, null);
        }
    }

    static void ensureCapacity$default(LazyStaggeredGridLaneInfo arg0, int arg1, int arg2, int arg3, Object arg4) {
        arg0.ensureCapacity(arg1, 0);
    }

    public final void ensureValidIndex(int arg6) {
        int v0 = this.anchor;
        int v1 = arg6 - v0;
        int v2 = 2;
        int v3 = 0x20000;
        if(v1 < 0 || v1 >= v3) {
            arg6 = Math.max(arg6 - this.lanes.length / v2, 0);
            this.anchor = arg6;
            arg6 -= v0;
            int[] v0_1 = this.lanes;
            if(arg6 >= 0) {
                if(arg6 < v0_1.length) {
                    ArraysKt.copyInto(v0_1, v0_1, 0, arg6, v0_1.length);
                }

                ArraysKt.fill(this.lanes, 0, Math.max(0, this.lanes.length - arg6), this.lanes.length);
            }
            else {
                arg6 = -arg6;
                if(v0_1.length + arg6 < v3) {
                    this.ensureCapacity(v0_1.length + arg6 + 1, arg6);
                    goto label_50;
                }

                if(arg6 < v0_1.length) {
                    ArraysKt.copyInto(v0_1, v0_1, arg6, 0, v0_1.length - arg6);
                }

                ArraysKt.fill(this.lanes, 0, 0, Math.min(this.lanes.length, arg6));
            }
        }
        else {
            LazyStaggeredGridLaneInfo.ensureCapacity$default(this, v1 + 1, 0, v2, null);
        }

    label_50:
        while(!this.spannedItems.isEmpty()) {
            if(this.spannedItems.first().getIndex() >= this.lowerBound()) {
                break;
            }

            this.spannedItems.removeFirst();
        }

        while(!this.spannedItems.isEmpty()) {
            if(this.spannedItems.last().getIndex() <= this.upperBound()) {
                return;
            }

            this.spannedItems.removeLast();
        }
    }

    public final int findNextItemIndex(int arg3, int arg4) {
        ++arg3;
        int v0 = this.upperBound();
        while(arg3 < v0) {
            if(this.assignedToLane(arg3, arg4)) {
                return arg3;
            }

            ++arg3;
        }

        return this.upperBound();
    }

    public final int findPreviousItemIndex(int arg2, int arg3) {
        int v0;
        --arg2;
        while(true) {
            v0 = -1;
            if(v0 >= arg2) {
                return v0;
            }

            if(this.assignedToLane(arg2, arg3)) {
                return arg2;
            }

            --arg2;
        }

        return v0;
    }

    public final int[] getGaps(int arg4) {
        Object v3 = CollectionsKt.getOrNull(this.spannedItems, CollectionsKt.binarySearch(this.spannedItems, 0, this.spannedItems.size(), new LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1(Integer.valueOf(arg4))));
        if(v3 != null) {
            return ((SpannedItem)v3).getGaps();
        }

        return null;
    }

    public final int getLane(int arg2) {
        if(arg2 >= this.lowerBound()) {
            if(arg2 >= this.upperBound()) {
            }
            else {
                return this.lanes[arg2 - this.anchor] - 1;
            }
        }

        return -1;
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void reset() {
        ArraysKt.fill$default(this.lanes, 0, 0, 0, 6, null);
        this.spannedItems.clear();
    }

    public final void setGaps(int arg5, int[] arg6) {
        int v0 = CollectionsKt.binarySearch(this.spannedItems, 0, this.spannedItems.size(), new LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1(Integer.valueOf(arg5)));
        if(v0 < 0) {
            if(arg6 == null) {
                return;
            }

            this.spannedItems.add(-(v0 + 1), new SpannedItem(arg5, arg6));
            return;
        }

        ArrayDeque v4 = this.spannedItems;
        if(arg6 == null) {
            v4.remove(v0);
            return;
        }

        v4.get(v0).setGaps(arg6);
    }

    public final void setLane(int arg3, int arg4) {
        int v1 = arg3 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Negative lanes are not supported");
        }

        this.ensureValidIndex(arg3);
        this.lanes[arg3 - this.anchor] = arg4 + 1;
    }

    public final int upperBound() {
        return this.anchor + this.lanes.length;
    }
}

