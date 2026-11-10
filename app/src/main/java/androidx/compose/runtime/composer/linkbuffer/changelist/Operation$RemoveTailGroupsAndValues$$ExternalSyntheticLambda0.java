package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor$VisitSlotsInRememberOrderCallback;

public final class Operation$RemoveTailGroupsAndValues$$ExternalSyntheticLambda0 implements VisitSlotsInRememberOrderCallback {
    public Operation$RemoveTailGroupsAndValues$$ExternalSyntheticLambda0(RememberManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean visit(int arg1, int arg2, Object arg3) {
        return RemoveTailGroupsAndValues.execute$lambda$0(this.f$0, arg1, arg2, arg3);
    }
}

