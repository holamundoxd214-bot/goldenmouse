package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class ReportDrawnKt$$ExternalSyntheticLambda5 implements Function2 {
    public ReportDrawnKt$$ExternalSyntheticLambda5(Function1 arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return ReportDrawnKt.ReportDrawnAfter$lambda$0(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

