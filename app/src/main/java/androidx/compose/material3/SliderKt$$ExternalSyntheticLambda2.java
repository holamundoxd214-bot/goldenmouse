package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class SliderKt$$ExternalSyntheticLambda2 implements Function2 {
    public SliderKt$$ExternalSyntheticLambda2(FloatRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return SliderKt.awaitSlop_8vUncbI$lambda$49(this.f$0, ((PointerInputChange)arg1), ((Float)arg2).floatValue());
    }
}

