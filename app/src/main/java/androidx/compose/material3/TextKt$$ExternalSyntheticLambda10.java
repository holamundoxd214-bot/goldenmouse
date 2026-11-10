package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function2;

public final class TextKt$$ExternalSyntheticLambda10 implements Function2 {
    public TextKt$$ExternalSyntheticLambda10(TextStyle arg1, Function2 arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return TextKt.ProvideTextStyle$lambda$20(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

