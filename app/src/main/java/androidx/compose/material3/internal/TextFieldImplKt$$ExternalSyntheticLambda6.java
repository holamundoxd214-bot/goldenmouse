package androidx.compose.material3.internal;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

public final class TextFieldImplKt$$ExternalSyntheticLambda6 implements Function3 {
    public TextFieldImplKt$$ExternalSyntheticLambda6(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return TextFieldImplKt.textFieldLabelMinHeight$lambda$26(this.f$0, ((MeasureScope)arg1), ((Measurable)arg2), ((Constraints)arg3));
    }
}

