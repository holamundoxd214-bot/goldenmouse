package androidx.compose.material3.internal;

import androidx.compose.material3.TooltipState;
import androidx.compose.ui.focus.FocusState;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class BasicTooltipKt$$ExternalSyntheticLambda4 implements Function1 {
    public BasicTooltipKt$$ExternalSyntheticLambda4(CoroutineScope arg1, TooltipState arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return BasicTooltipKt.keyboardBehavior$lambda$13(this.f$0, this.f$1, ((FocusState)arg2));
    }
}

