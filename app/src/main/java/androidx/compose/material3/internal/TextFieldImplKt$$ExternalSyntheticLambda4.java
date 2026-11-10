package androidx.compose.material3.internal;

import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import kotlin.jvm.functions.Function1;

public final class TextFieldImplKt$$ExternalSyntheticLambda4 implements Function1 {
    public TextFieldImplKt$$ExternalSyntheticLambda4(TextFieldLabelPosition arg1, State arg2, MutableState arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$17$lambda$16(this.f$0, this.f$1, this.f$2, ((Size)arg3));
    }
}

