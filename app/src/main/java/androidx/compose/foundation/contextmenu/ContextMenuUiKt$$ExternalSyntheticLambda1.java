package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class ContextMenuUiKt$$ExternalSyntheticLambda1 implements Function3 {
    public ContextMenuUiKt$$ExternalSyntheticLambda1(Function1 arg1, ContextMenuColors arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return ContextMenuUiKt.ContextMenuColumnBuilder$lambda$0(this.f$0, this.f$1, ((ColumnScope)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

