package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class ComposableSingletons$RecomposerKt {
    public static final ComposableSingletons$RecomposerKt INSTANCE;
    private static Function2 lambda$-1091980426;

    static {
        ComposableSingletons$RecomposerKt.INSTANCE = new ComposableSingletons$RecomposerKt();
        ComposableSingletons$RecomposerKt.lambda$-1091980426 = ComposableLambdaKt.composableLambdaInstance(-1091980426, false, new ComposableSingletons$RecomposerKt$$ExternalSyntheticLambda0());
    }

    public ComposableSingletons$RecomposerKt() {
        super();
    }

    public final Function2 getLambda$-1091980426$runtime() {
        return ComposableSingletons$RecomposerKt.lambda$-1091980426;
    }

    static final Unit lambda__1091980426$lambda$0(Composer arg2, int arg3) {
        ComposerKt.sourceInformation(arg2, "C:Recomposer.kt#9igjgp");
        boolean v0 = (arg3 & 3) != 2 ? true : false;
        if(arg2.shouldExecute(v0, arg3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091980426, arg3, -1, "androidx.compose.runtime.ComposableSingletons$RecomposerKt.lambda$-1091980426.<anonymous> (Recomposer.kt:469)");
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_22;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg2.skipToGroupEnd();
        }

    label_22:
        return Unit.INSTANCE;
    }
}

