package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u001C\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/ui/layout/FixedCountSubcomposeSlotReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "<init>", "(I)V", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "areCompatible", "", "slotId", "", "reusableSlotId", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FixedCountSubcomposeSlotReusePolicy implements SubcomposeSlotReusePolicy {
    private final int maxSlotsToRetainForReuse;

    public FixedCountSubcomposeSlotReusePolicy(int arg1) {
        super();
        this.maxSlotsToRetainForReuse = arg1;
    }

    public boolean areCompatible(Object arg1, Object arg2) {
        return 1;
    }

    public void getSlotsToRetain(SlotIdsSet arg2) {
        int v0 = arg2.size();
        int v1 = this.maxSlotsToRetainForReuse;
        if(v0 > v1) {
            arg2.trimToSize(v1);
        }
    }
}

