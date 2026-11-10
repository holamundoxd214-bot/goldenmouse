package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function4;

public final class ContextualFlowLayoutKt$$ExternalSyntheticLambda2 implements Function4 {
    public ContextualFlowLayoutKt$$ExternalSyntheticLambda2(Function4 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        return ContextualFlowLayoutKt.ContextualFlowColumn$lambda$2(this.f$0, ((Integer)arg1).intValue(), ((FlowLineInfo)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

