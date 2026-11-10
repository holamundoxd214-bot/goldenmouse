package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import kotlin.jvm.functions.Function0;

public final class OperationKt$$ExternalSyntheticLambda0 implements Function0 {
    public OperationKt$$ExternalSyntheticLambda0(GapAnchor arg1, SlotWriter arg2, OperationErrorContext arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return OperationKt.attachComposeStackTrace$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

