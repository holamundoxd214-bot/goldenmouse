package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class ComposableLambdaNImpl$$ExternalSyntheticLambda0 implements Function2 {
    public ComposableLambdaNImpl$$ExternalSyntheticLambda0(Object[] arg1, int arg2, ComposableLambdaNImpl arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return ComposableLambdaNImpl.invoke$lambda$0(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

