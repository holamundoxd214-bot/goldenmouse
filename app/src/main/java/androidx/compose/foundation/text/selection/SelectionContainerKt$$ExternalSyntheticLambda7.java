package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class SelectionContainerKt$$ExternalSyntheticLambda7 implements Function2 {
    public SelectionContainerKt$$ExternalSyntheticLambda7(SelectionManager arg1, SelectionRegistrarImpl arg2, Function2 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return SelectionContainerKt.SelectionContainer$lambda$9(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

