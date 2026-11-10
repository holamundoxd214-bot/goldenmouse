package androidx.compose.material3.internal;

import androidx.compose.material3.TooltipState;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class BasicTooltipKt$$ExternalSyntheticLambda5 implements Function1 {
    public BasicTooltipKt$$ExternalSyntheticLambda5(String arg1, CoroutineScope arg2, TooltipState arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return BasicTooltipKt.anchorSemantics$lambda$12(this.f$0, this.f$1, this.f$2, ((SemanticsPropertyReceiver)arg3));
    }
}

