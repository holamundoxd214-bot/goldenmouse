package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

public final class AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda7 implements Function3 {
    public AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda7(Function0 arg1, boolean arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return AndroidSelectionHandles_androidKt.drawSelectionHandle$lambda$0(this.f$0, this.f$1, ((Modifier)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

