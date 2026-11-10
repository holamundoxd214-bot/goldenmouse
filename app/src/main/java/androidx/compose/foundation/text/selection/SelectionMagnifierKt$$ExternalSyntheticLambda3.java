package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class SelectionMagnifierKt$$ExternalSyntheticLambda3 implements Function3 {
    public SelectionMagnifierKt$$ExternalSyntheticLambda3(Function0 arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return SelectionMagnifierKt.animatedSelectionMagnifier$lambda$0(this.f$0, this.f$1, ((Modifier)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

