package androidx.compose.foundation.selection;

import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;

public final class ToggleableNode$$ExternalSyntheticLambda0 implements Function1 {
    public ToggleableNode$$ExternalSyntheticLambda0(SemanticsPropertyReceiver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(ToggleableNode.applyAdditionalSemantics$lambda$1(this.f$0, ((FillableData)arg1)));
    }
}

