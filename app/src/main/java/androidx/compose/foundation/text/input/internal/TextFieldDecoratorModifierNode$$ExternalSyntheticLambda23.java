package androidx.compose.foundation.text.input.internal;

import kotlin.jvm.functions.Function3;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda23 implements Function3 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda23(TextFieldDecoratorModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$5(this.f$0, ((Integer)arg1).intValue(), ((Integer)arg2).intValue(), ((Boolean)arg3).booleanValue()));
    }
}

