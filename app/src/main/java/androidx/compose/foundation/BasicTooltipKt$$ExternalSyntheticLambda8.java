package androidx.compose.foundation;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class BasicTooltipKt$$ExternalSyntheticLambda8 implements Function1 {
    public BasicTooltipKt$$ExternalSyntheticLambda8(String arg1, CoroutineScope arg2, BasicTooltipState arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return BasicTooltipKt.anchorSemantics$lambda$0(this.f$0, this.f$1, this.f$2, ((SemanticsPropertyReceiver)arg3));
    }
}

