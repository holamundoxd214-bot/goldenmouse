package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.RememberManager;

public final class SlotTableEditorKt$$ExternalSyntheticLambda0 implements VisitSlotsInRememberOrderCallback {
    public SlotTableEditorKt$$ExternalSyntheticLambda0(SlotTableEditor arg1, RememberManager arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean visit(int arg2, int arg3, Object arg4) {
        return SlotTableEditorKt.deactivateGroup$lambda$0(this.f$0, this.f$1, arg2, arg3, arg4);
    }
}

