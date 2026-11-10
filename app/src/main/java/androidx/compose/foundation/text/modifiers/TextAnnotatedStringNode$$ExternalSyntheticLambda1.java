package androidx.compose.foundation.text.modifiers;

import java.util.List;
import kotlin.jvm.functions.Function1;

public final class TextAnnotatedStringNode$$ExternalSyntheticLambda1 implements Function1 {
    public TextAnnotatedStringNode$$ExternalSyntheticLambda1(TextAnnotatedStringNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(TextAnnotatedStringNode.applySemantics$lambda$0(this.f$0, ((List)arg1)));
    }
}

