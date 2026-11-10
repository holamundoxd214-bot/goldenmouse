package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u001C\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¨\u0006\r"}, d2={"Landroidx/compose/ui/layout/NoOpSubcomposeSlotReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "<init>", "()V", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "areCompatible", "", "slotId", "", "reusableSlotId", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class NoOpSubcomposeSlotReusePolicy implements SubcomposeSlotReusePolicy {
    public static final NoOpSubcomposeSlotReusePolicy INSTANCE;

    static {
        NoOpSubcomposeSlotReusePolicy.INSTANCE = new NoOpSubcomposeSlotReusePolicy();
    }

    private NoOpSubcomposeSlotReusePolicy() {
        super();
    }

    public boolean areCompatible(Object arg1, Object arg2) {
        return 0;
    }

    public void getSlotsToRetain(SlotIdsSet arg1) {
        arg1.clear();
    }
}

