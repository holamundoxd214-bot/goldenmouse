package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A3\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0003¢\u0006\u0002\u0010\b\u001A+\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\n\u001A+\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\n¨\u0006\f"}, d2={"dropUnlessStateIsAtLeast", "Lkotlin/Function0;", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "block", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "dropUnlessStarted", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "dropUnlessResumed", "lifecycle-runtime-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DropUnlessLifecycleKt {
    public static Unit $r8$lambda$VavZTAL9PuPuA0x2EIZOoiTbrZk(LifecycleOwner arg0, State arg1, Function0 arg2) {
        return DropUnlessLifecycleKt.dropUnlessStateIsAtLeast$lambda$1$0(arg0, arg1, arg2);
    }

    public static final Function0 dropUnlessResumed(LifecycleOwner arg8, Function0 arg9, Composer arg10, int arg11, int arg12) {
        Object v8_1;
        int v1 = 0x4F5774C5;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(dropUnlessResumed)N(lifecycleOwner,block)97@4047L7,99@4095L62:DropUnlessLifecycle.kt#2vxrgp");
        if((arg12 & 1) != 0) {
            ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v8_1 = arg10.consume(((CompositionLocal)v8));
            ComposerKt.sourceInformationMarkerEnd(arg10);
        }

        LifecycleOwner v3 = ((LifecycleOwner)v8_1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.lifecycle.compose.dropUnlessResumed (DropUnlessLifecycle.kt:99)");
        }

        int v8_2 = arg11 << 3;
        Composer v5 = arg10;
        Function0 v8_3 = DropUnlessLifecycleKt.dropUnlessStateIsAtLeast(State.RESUMED, v3, arg9, v5, v8_2 & 0x70 | 6 | v8_2 & 0x380, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_3;
    }

    public static final Function0 dropUnlessStarted(LifecycleOwner arg8, Function0 arg9, Composer arg10, int arg11, int arg12) {
        Object v8_1;
        int v1 = 0x47FEA1EF;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(dropUnlessStarted)N(lifecycleOwner,block)75@3053L7,77@3101L62:DropUnlessLifecycle.kt#2vxrgp");
        if((arg12 & 1) != 0) {
            ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v8_1 = arg10.consume(((CompositionLocal)v8));
            ComposerKt.sourceInformationMarkerEnd(arg10);
        }

        LifecycleOwner v3 = ((LifecycleOwner)v8_1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.lifecycle.compose.dropUnlessStarted (DropUnlessLifecycle.kt:77)");
        }

        int v8_2 = arg11 << 3;
        Composer v5 = arg10;
        Function0 v8_3 = DropUnlessLifecycleKt.dropUnlessStateIsAtLeast(State.STARTED, v3, arg9, v5, v8_2 & 0x70 | 6 | v8_2 & 0x380, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_3;
    }

    private static final Function0 dropUnlessStateIsAtLeast(State arg4, LifecycleOwner arg5, Function0 arg6, Composer arg7, int arg8, int arg9) {
        Object v5_1;
        int v1 = -2057956404;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(dropUnlessStateIsAtLeast)N(state,lifecycleOwner,block)45@1919L7,53@2217L107:DropUnlessLifecycle.kt#2vxrgp");
        if((arg9 & 2) != 0) {
            ProvidableCompositionLocal v5 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v5_1 = arg7.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(arg7);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.lifecycle.compose.dropUnlessStateIsAtLeast (DropUnlessLifecycle.kt:47)");
        }

        if(arg4 != State.DESTROYED) {
            ComposerKt.sourceInformationMarkerStart(arg7, -2011135081, "CC(remember):DropUnlessLifecycle.kt#9igjgp");
            boolean v9 = arg7.changedInstance(v5_1);
            v1 = 0;
            int v3 = 4;
            int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg4.ordinal())) || (arg8 & 6) == v3 ? 1 : 0;
            arg9 = (((int)v9)) | v0;
            v3 = 0x100;
            if((arg8 & 0x380 ^ 0x180) > v3 && (arg7.changed(arg6)) || (arg8 & 0x180) == v3) {
                v1 = 1;
            }

            arg8 = arg9 | v1;
            Object v9_1 = arg7.rememberedValue();
            if(arg8 != 0 || v9_1 == Composer.Companion.getEmpty()) {
                DropUnlessLifecycleKt$$ExternalSyntheticLambda0 v9_2 = new DropUnlessLifecycleKt$$ExternalSyntheticLambda0(((LifecycleOwner)v5_1), arg4, arg6);
                arg7.updateRememberedValue(v9_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            return ((Function0)v9_1);
        }

        throw new IllegalArgumentException("Target state is not allowed to be `Lifecycle.State.DESTROYED` because Compose disposes of the composition before `Lifecycle.Event.ON_DESTROY` observers are invoked.".toString());
    }

    private static final Unit dropUnlessStateIsAtLeast$lambda$1$0(LifecycleOwner arg0, State arg1, Function0 arg2) {
        if(arg0.getLifecycle().getCurrentState().isAtLeast(arg1)) {
            arg2.invoke();
        }

        return Unit.INSTANCE;
    }
}

