package androidx.compose.foundation.text.selection;

import kotlin.jvm.functions.Function1;

public final class SelectionManager$$ExternalSyntheticLambda5 implements Function1 {
    public SelectionManager$$ExternalSyntheticLambda5(SelectionManager arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SelectionManager._set_onSelectionChange_$lambda$0(this.f$0, this.f$1, ((Selection)arg2));
    }
}

