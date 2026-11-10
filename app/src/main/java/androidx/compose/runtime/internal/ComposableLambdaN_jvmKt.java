package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001A0\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0007\u001A-\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0002\u0010\f\u001A(\u0010\r\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0007¨\u0006\u000E"}, d2={"composableLambdaN", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "composer", "Landroidx/compose/runtime/Composer;", "key", "", "tracked", "", "arity", "block", "", "rememberComposableLambdaN", "(IZILjava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/internal/ComposableLambdaN;", "composableLambdaNInstance", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposableLambdaN_jvmKt {
    @ComposeCompilerApi public static final ComposableLambdaN composableLambdaN(Composer arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        ComposableLambdaNImpl v0_1;
        arg2.startReplaceableGroup(arg3);
        Object v0 = arg2.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = new ComposableLambdaNImpl(arg3, arg4, arg5);
            arg2.updateRememberedValue(v0_1);
        }
        else {
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaNImpl");
        }

        v0_1.update(arg6);
        arg2.endReplaceableGroup();
        return ((ComposableLambdaN)v0_1);
    }

    @ComposeCompilerApi public static final ComposableLambdaN composableLambdaNInstance(int arg1, boolean arg2, int arg3, Object arg4) {
        ComposableLambdaNImpl v0 = new ComposableLambdaNImpl(arg1, arg2, arg3);
        v0.update(arg4);
        return ((ComposableLambdaN)v0);
    }

    @ComposeCompilerApi public static final ComposableLambdaN rememberComposableLambdaN(int arg3, boolean arg4, int arg5, Object arg6, Composer arg7, int arg8) {
        int v1 = 0xAA1593AE;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberComposableLambdaN)N(key,tracked,arity,block)171@5717L55:ComposableLambdaN.jvmAndAndroid.kt#9drcc");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.runtime.internal.rememberComposableLambdaN (ComposableLambdaN.jvmAndAndroid.kt:171)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x7AFF7025, "CC(remember):ComposableLambdaN.jvmAndAndroid.kt#9igjgp");
        Object v8 = arg7.rememberedValue();
        if(v8 == Composer.Companion.getEmpty()) {
            ComposableLambdaNImpl v8_1 = new ComposableLambdaNImpl(arg3, arg4, arg5);
            arg7.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        ((ComposableLambdaNImpl)v8).update(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((ComposableLambdaN)v8);
    }
}

