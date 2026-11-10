package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.EditProcessor;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class TextFieldDelegate$Companion$$ExternalSyntheticLambda1 implements Function1 {
    public TextFieldDelegate$Companion$$ExternalSyntheticLambda1(EditProcessor arg1, Function1 arg2, ObjectRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return Companion.restartInput$lambda$0(this.f$0, this.f$1, this.f$2, ((List)arg3));
    }
}

