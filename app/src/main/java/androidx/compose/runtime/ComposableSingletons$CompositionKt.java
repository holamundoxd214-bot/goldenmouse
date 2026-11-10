package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class ComposableSingletons$CompositionKt {
    public static final ComposableSingletons$CompositionKt INSTANCE;
    private static Function2 lambda$1918065384;
    private static Function2 lambda$954879418;

    static {
        ComposableSingletons$CompositionKt.INSTANCE = new ComposableSingletons$CompositionKt();
        ComposableSingletons$CompositionKt.lambda$954879418 = ComposableLambdaKt.composableLambdaInstance(0x38EA4DBA, false, new ComposableSingletons$CompositionKt$$ExternalSyntheticLambda0());
        ComposableSingletons$CompositionKt.lambda$1918065384 = ComposableLambdaKt.composableLambdaInstance(1918065384, false, new ComposableSingletons$CompositionKt$$ExternalSyntheticLambda1());
    }

    public ComposableSingletons$CompositionKt() {
        super();
    }

    public final Function2 getLambda$1918065384$runtime() {
        return ComposableSingletons$CompositionKt.lambda$1918065384;
    }

    public final Function2 getLambda$954879418$runtime() {
        return ComposableSingletons$CompositionKt.lambda$954879418;
    }

    static final Unit lambda_1918065384$lambda$0(Composer arg2, int arg3) {
        ComposerKt.sourceInformation(arg2, "C:Composition.kt#9igjgp");
        boolean v0 = (arg3 & 3) != 2 ? true : false;
        if(arg2.shouldExecute(v0, arg3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1918065384, arg3, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda$1918065384.<anonymous> (Composition.kt:917)");
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

    static final Unit lambda_954879418$lambda$0(Composer arg2, int arg3) {
        ComposerKt.sourceInformation(arg2, "C:Composition.kt#9igjgp");
        boolean v0 = (arg3 & 3) != 2 ? true : false;
        if(arg2.shouldExecute(v0, arg3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x38EA4DBA, arg3, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda$954879418.<anonymous> (Composition.kt:680)");
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

