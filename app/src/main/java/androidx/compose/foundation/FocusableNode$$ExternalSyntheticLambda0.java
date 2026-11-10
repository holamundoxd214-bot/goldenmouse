package androidx.compose.foundation;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.jvm.functions.Function1;

public final class FocusableNode$$ExternalSyntheticLambda0 implements Function1 {
    public FocusableNode$$ExternalSyntheticLambda0(MutableInteractionSource arg1, Interaction arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return FocusableNode.emitWithFallback$lambda$0(this.f$0, this.f$1, ((Throwable)arg2));
    }
}

