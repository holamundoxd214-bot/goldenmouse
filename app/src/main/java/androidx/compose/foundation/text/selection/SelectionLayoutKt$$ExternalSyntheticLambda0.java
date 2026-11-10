package androidx.compose.foundation.text.selection;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class SelectionLayoutKt$$ExternalSyntheticLambda0 implements Function1 {
    public SelectionLayoutKt$$ExternalSyntheticLambda0(BooleanRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SelectionLayoutKt.isCollapsed$lambda$0(this.f$0, ((SelectableInfo)arg1));
    }
}

