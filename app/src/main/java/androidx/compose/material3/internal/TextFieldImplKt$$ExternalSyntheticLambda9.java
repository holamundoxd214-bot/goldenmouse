package androidx.compose.material3.internal;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.functions.Function1;

public final class TextFieldImplKt$$ExternalSyntheticLambda9 implements Function1 {
    public TextFieldImplKt$$ExternalSyntheticLambda9(Shape arg1, ColorProducer arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TextFieldImplKt.textFieldBackground$lambda$24(this.f$0, this.f$1, ((CacheDrawScope)arg2));
    }
}

