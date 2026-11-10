package androidx.compose.foundation;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatingPointRange;

public final class ProgressSemanticsKt$$ExternalSyntheticLambda0 implements Function1 {
    public ProgressSemanticsKt$$ExternalSyntheticLambda0(float arg1, ClosedFloatingPointRange arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return ProgressSemanticsKt.progressSemantics$lambda$0(this.f$0, this.f$1, this.f$2, ((SemanticsPropertyReceiver)arg3));
    }
}

