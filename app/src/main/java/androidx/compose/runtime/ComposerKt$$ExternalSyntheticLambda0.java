package androidx.compose.runtime;

import androidx.compose.runtime.composer.RememberManager;
import kotlin.jvm.functions.Function2;

public final class ComposerKt$$ExternalSyntheticLambda0 implements Function2 {
    public ComposerKt$$ExternalSyntheticLambda0(RememberManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return ComposerKt.removeCurrentGroup$lambda$0(this.f$0, ((Integer)arg1).intValue(), arg2);
    }
}

