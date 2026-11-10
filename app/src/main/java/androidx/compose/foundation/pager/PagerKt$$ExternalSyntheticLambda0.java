package androidx.compose.foundation.pager;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class PagerKt$$ExternalSyntheticLambda0 implements Function1 {
    public PagerKt$$ExternalSyntheticLambda0(boolean arg1, PagerState arg2, CoroutineScope arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return PagerKt.pagerSemantics$lambda$0(this.f$0, this.f$1, this.f$2, ((SemanticsPropertyReceiver)arg3));
    }
}

