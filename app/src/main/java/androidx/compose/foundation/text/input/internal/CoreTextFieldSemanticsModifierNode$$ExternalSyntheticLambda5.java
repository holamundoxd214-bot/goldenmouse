package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.autofill.FillableData;
import kotlin.jvm.functions.Function1;

public final class CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda5 implements Function1 {
    public CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda5(CoreTextFieldSemanticsModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(CoreTextFieldSemanticsModifierNode.applySemantics$lambda$1(this.f$0, ((FillableData)arg1)));
    }
}

