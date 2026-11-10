package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.RememberManager;

public final class SlotTableKt$$ExternalSyntheticLambda0 implements VisitSlotsInRememberOrderCallback {
    public SlotTableKt$$ExternalSyntheticLambda0(RememberManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean visit(int arg1, int arg2, Object arg3) {
        return SlotTableKt.deactivateCurrentGroup$lambda$0(this.f$0, arg1, arg2, arg3);
    }
}

