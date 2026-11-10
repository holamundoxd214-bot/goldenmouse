package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final class ContextMenuScope$$ExternalSyntheticLambda0 implements Function3 {
    public ContextMenuScope$$ExternalSyntheticLambda0(Function2 arg1, ContextMenuScope arg2, Modifier arg3, boolean arg4, Function3 arg5, Function0 arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg10, Object arg11, Object arg12) {
        return ContextMenuScope.item$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg10, arg11, ((Integer)arg12).intValue());
    }
}

