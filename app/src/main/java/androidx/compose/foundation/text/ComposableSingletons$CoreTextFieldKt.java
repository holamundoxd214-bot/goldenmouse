package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class ComposableSingletons$CoreTextFieldKt {
    public static final ComposableSingletons$CoreTextFieldKt INSTANCE;
    private static Function3 lambda$559628295;

    static {
        ComposableSingletons$CoreTextFieldKt.INSTANCE = new ComposableSingletons$CoreTextFieldKt();
        ComposableSingletons$CoreTextFieldKt.lambda$559628295 = ComposableLambdaKt.composableLambdaInstance(0x215B4007, false, new ComposableSingletons$CoreTextFieldKt$$ExternalSyntheticLambda0());
    }

    public ComposableSingletons$CoreTextFieldKt() {
        super();
    }

    public final Function3 getLambda$559628295$foundation() {
        return ComposableSingletons$CoreTextFieldKt.lambda$559628295;
    }

    static final Unit lambda_559628295$lambda$0(Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "CN(innerTextField)210@11952L16:CoreTextField.kt#423gt5");
        if((arg5 & 6) == 0) {
            int v0 = arg4.changedInstance(arg3) ? 4 : 2;
            arg5 |= v0;
        }

        boolean v0_1 = (arg5 & 19) != 18 ? true : false;
        if(arg4.shouldExecute(v0_1, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x215B4007, arg5, -1, "androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.lambda$559628295.<anonymous> (CoreTextField.kt:210)");
            }

            arg3.invoke(arg4, Integer.valueOf(arg5 & 14));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_33;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg4.skipToGroupEnd();
        }

    label_33:
        return Unit.INSTANCE;
    }
}

