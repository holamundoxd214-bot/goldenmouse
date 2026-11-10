package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

public final class Recomposer$runRecomposeAndApplyChanges$2$$ExternalSyntheticLambda0 implements Function1 {
    public Recomposer$runRecomposeAndApplyChanges$2$$ExternalSyntheticLambda0(Recomposer arg1, MutableScatterSet arg2, MutableScatterSet arg3, List arg4, List arg5, MutableScatterSet arg6, List arg7, MutableScatterSet arg8, Set arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
    }

    public final Object invoke(Object arg12) {
        return Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, ((Long)arg12).longValue());
    }
}

