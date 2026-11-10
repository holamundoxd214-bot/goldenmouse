package androidx.compose.foundation.text.modifiers;

import kotlin.jvm.functions.Function1;

public final class TextAnnotatedStringNode$$ExternalSyntheticLambda3 implements Function1 {
    public TextAnnotatedStringNode$$ExternalSyntheticLambda3(TextAnnotatedStringNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(TextAnnotatedStringNode.applySemantics$lambda$2(this.f$0, ((Boolean)arg1).booleanValue()));
    }
}

