package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.RememberManager;

public final class SlotTableEditorKt$$ExternalSyntheticLambda1 implements VisitSlotsInRememberOrderCallback {
    public SlotTableEditorKt$$ExternalSyntheticLambda1(RememberManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean visit(int arg1, int arg2, Object arg3) {
        return SlotTableEditorKt.removeGroupAndForgetSlots$lambda$0(this.f$0, arg1, arg2, arg3);
    }
}

