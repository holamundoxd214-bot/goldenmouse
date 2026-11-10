package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function3;

public final class SelectionManager_androidKt$$ExternalSyntheticLambda4 implements Function3 {
    public SelectionManager_androidKt$$ExternalSyntheticLambda4(SelectionManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return SelectionManager_androidKt.selectionMagnifier$lambda$0(this.f$0, ((Modifier)arg1), ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

