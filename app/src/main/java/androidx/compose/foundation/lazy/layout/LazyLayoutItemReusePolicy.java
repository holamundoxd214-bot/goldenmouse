package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.OrderedScatterSet;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy$SlotIdsSet;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u001C\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\b2\b\u0010\u0010\u001A\u0004\u0018\u00010\bH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "factory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;)V", "countPerType", "Landroidx/collection/MutableObjectIntMap;", "", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "areCompatible", "", "slotId", "reusableSlotId", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {
    private final MutableObjectIntMap countPerType;
    private final LazyLayoutItemContentFactory factory;

    public LazyLayoutItemReusePolicy(LazyLayoutItemContentFactory arg1) {
        super();
        this.factory = arg1;
        this.countPerType = ObjectIntMapKt.mutableObjectIntMapOf();
    }

    public boolean areCompatible(Object arg2, Object arg3) {
        return Intrinsics.areEqual(this.factory.getContentType(arg2), this.factory.getContentType(arg3));
    }

    public void getSlotsToRetain(SlotIdsSet arg8) {
        this.countPerType.clear();
        MutableOrderedScatterSet v0 = arg8.getSet();
        Object[] v1 = ((OrderedScatterSet)v0).elements;
        long[] v2 = ((OrderedScatterSet)v0).nodes;
        int v0_1;
        for(v0_1 = ((OrderedScatterSet)v0).tail; v0_1 != 0x7FFFFFFF; v0_1 = v3) {
            int v3 = ((int)(v2[v0_1] >> 0x1F & 0x7FFFFFFF));
            Object v0_2 = v1[v0_1];
            Object v4 = this.factory.getContentType(v0_2);
            int v5 = this.countPerType.getOrDefault(v4, 0);
            if(v5 == 7) {
                arg8.remove(v0_2);
            }
            else {
                this.countPerType.set(v4, v5 + 1);
            }
        }
    }
}

