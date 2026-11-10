package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.functions.Function1;

public final class TextFieldImplKt$$ExternalSyntheticLambda8 implements Function1 {
    public TextFieldImplKt$$ExternalSyntheticLambda8(Outline arg1, ColorProducer arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TextFieldImplKt.textFieldBackground$lambda$24$lambda$23(this.f$0, this.f$1, ((DrawScope)arg2));
    }
}

