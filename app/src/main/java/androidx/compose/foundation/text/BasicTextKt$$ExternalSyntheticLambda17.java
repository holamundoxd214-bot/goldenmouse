package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function2;

public final class BasicTextKt$$ExternalSyntheticLambda17 implements Function2 {
    public BasicTextKt$$ExternalSyntheticLambda17(SelectionRegistrar arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return BasicTextKt.selectionIdSaver$lambda$0(this.f$0, ((SaverScope)arg3), ((Long)arg4).longValue());
    }
}

