package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class ComposableSingletons$BasicTextFieldKt {
    public static final ComposableSingletons$BasicTextFieldKt INSTANCE;
    private static Function3 lambda$-665310900;
    private static Function3 lambda$444370233;
    private static Function3 lambda$486633673;
    private static Function3 lambda$759698998;

    static {
        ComposableSingletons$BasicTextFieldKt.INSTANCE = new ComposableSingletons$BasicTextFieldKt();
        ComposableSingletons$BasicTextFieldKt.lambda$759698998 = ComposableLambdaKt.composableLambdaInstance(0x2D481636, false, new ComposableSingletons$BasicTextFieldKt$$ExternalSyntheticLambda0());
        ComposableSingletons$BasicTextFieldKt.lambda$486633673 = ComposableLambdaKt.composableLambdaInstance(0x1D0170C9, false, new ComposableSingletons$BasicTextFieldKt$$ExternalSyntheticLambda1());
        ComposableSingletons$BasicTextFieldKt.lambda$444370233 = ComposableLambdaKt.composableLambdaInstance(444370233, false, new ComposableSingletons$BasicTextFieldKt$$ExternalSyntheticLambda2());
        ComposableSingletons$BasicTextFieldKt.lambda$-665310900 = ComposableLambdaKt.composableLambdaInstance(-665310900, false, new ComposableSingletons$BasicTextFieldKt$$ExternalSyntheticLambda3());
    }

    public ComposableSingletons$BasicTextFieldKt() {
        super();
    }

    public final Function3 getLambda$-665310900$foundation() {
        return ComposableSingletons$BasicTextFieldKt.lambda$-665310900;
    }

    public final Function3 getLambda$444370233$foundation() {
        return ComposableSingletons$BasicTextFieldKt.lambda$444370233;
    }

    public final Function3 getLambda$486633673$foundation() {
        return ComposableSingletons$BasicTextFieldKt.lambda$486633673;
    }

    public final Function3 getLambda$759698998$foundation() {
        return ComposableSingletons$BasicTextFieldKt.lambda$759698998;
    }

    static final Unit lambda_444370233$lambda$0(Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "CN(innerTextField)949@49520L16:BasicTextField.kt#423gt5");
        if((arg5 & 6) == 0) {
            int v0 = arg4.changedInstance(arg3) ? 4 : 2;
            arg5 |= v0;
        }

        boolean v0_1 = (arg5 & 19) != 18 ? true : false;
        if(arg4.shouldExecute(v0_1, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(444370233, arg5, -1, "androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.lambda$444370233.<anonymous> (BasicTextField.kt:949)");
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

    static final Unit lambda_486633673$lambda$0(Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "CN(innerTextField)905@47848L16:BasicTextField.kt#423gt5");
        if((arg5 & 6) == 0) {
            int v0 = arg4.changedInstance(arg3) ? 4 : 2;
            arg5 |= v0;
        }

        boolean v0_1 = (arg5 & 19) != 18 ? true : false;
        if(arg4.shouldExecute(v0_1, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x1D0170C9, arg5, -1, "androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.lambda$486633673.<anonymous> (BasicTextField.kt:905)");
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

    static final Unit lambda_759698998$lambda$0(Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "CN(innerTextField)748@38867L16:BasicTextField.kt#423gt5");
        if((arg5 & 6) == 0) {
            int v0 = arg4.changedInstance(arg3) ? 4 : 2;
            arg5 |= v0;
        }

        boolean v0_1 = (arg5 & 19) != 18 ? true : false;
        if(arg4.shouldExecute(v0_1, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2D481636, arg5, -1, "androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.lambda$759698998.<anonymous> (BasicTextField.kt:748)");
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

    static final Unit lambda__665310900$lambda$0(Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "CN(innerTextField)989@51047L16:BasicTextField.kt#423gt5");
        if((arg5 & 6) == 0) {
            int v0 = arg4.changedInstance(arg3) ? 4 : 2;
            arg5 |= v0;
        }

        boolean v0_1 = (arg5 & 19) != 18 ? true : false;
        if(arg4.shouldExecute(v0_1, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-665310900, arg5, -1, "androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.lambda$-665310900.<anonymous> (BasicTextField.kt:989)");
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

