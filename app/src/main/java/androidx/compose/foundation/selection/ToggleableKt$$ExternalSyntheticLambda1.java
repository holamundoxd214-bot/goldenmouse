package androidx.compose.foundation.selection;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

public final class ToggleableKt$$ExternalSyntheticLambda1 implements Function3 {
    public ToggleableKt$$ExternalSyntheticLambda1(ToggleableState arg1, boolean arg2, Role arg3, Function0 arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg8, Object arg9, Object arg10) {
        return ToggleableKt.triStateToggleable_XHw0xAI$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, arg8, arg9, ((Integer)arg10).intValue());
    }
}

