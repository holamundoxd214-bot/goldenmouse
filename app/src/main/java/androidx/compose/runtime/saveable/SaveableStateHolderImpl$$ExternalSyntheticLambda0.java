package androidx.compose.runtime.saveable;

import kotlin.jvm.functions.Function1;

public final class SaveableStateHolderImpl$$ExternalSyntheticLambda0 implements Function1 {
    public SaveableStateHolderImpl$$ExternalSyntheticLambda0(SaveableStateHolderImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(SaveableStateHolderImpl.canBeSaved$lambda$0(this.f$0, arg1));
    }
}

