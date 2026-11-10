package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class ContextMenu_androidKt$$ExternalSyntheticLambda1 implements Function2 {
    public ContextMenu_androidKt$$ExternalSyntheticLambda1(SelectionManager arg1, Function2 arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return ContextMenu_androidKt.ContextMenuArea$lambda$2(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

