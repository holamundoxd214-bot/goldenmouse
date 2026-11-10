package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import kotlin.jvm.functions.Function0;

public final class OperationKt$$ExternalSyntheticLambda0 implements Function0 {
    public OperationKt$$ExternalSyntheticLambda0(long arg1, SlotTableEditor arg3, OperationErrorContext arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg3;
        this.f$2 = arg4;
    }

    public final Object invoke() {
        return OperationKt.attachComposeStackTrace$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

