package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.functions.Function1;

public final class CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda8 implements Function1 {
    public CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda8(CoreTextFieldSemanticsModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(CoreTextFieldSemanticsModifierNode.applySemantics$lambda$3(this.f$0, ((AnnotatedString)arg1)));
    }
}

