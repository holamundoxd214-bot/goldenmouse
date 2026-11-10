package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u001A\u0018\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u0010\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u0010\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u0016\u0010\b\u001A\u00020\t*\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\nH\u0000\u001A(\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0013H\u0007\u001A \u0010\u0015\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0013H\u0007\u001A%\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0017\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"SLOTS_PER_INT", "", "BITS_PER_SLOT", "bitsForSlot", "bits", "slot", "sameBits", "differentBits", "replacableWith", "", "Landroidx/compose/runtime/RecomposeScope;", "other", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", "composer", "Landroidx/compose/runtime/Composer;", "key", "tracked", "block", "", "lambdaKey", "composableLambdaInstance", "rememberComposableLambda", "(IZLjava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/internal/ComposableLambda;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposableLambdaKt {
    private static final int BITS_PER_SLOT = 3;
    public static final int SLOTS_PER_INT = 10;
    private static final Object lambdaKey;

    static {
        ComposableLambdaKt.lambdaKey = new Object();
    }

    public static final int bitsForSlot(int arg0, int arg1) {
        return arg0 << arg1 % 10 * 3 + 1;
    }

    @ComposeCompilerApi public static final ComposableLambda composableLambda(Composer arg2, int arg3, boolean arg4, Object arg5) {
        ComposableLambdaImpl v0_1;
        arg2.startMovableGroup(Integer.rotateLeft(arg3, 1), ComposableLambdaKt.lambdaKey);
        Object v0 = arg2.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = new ComposableLambdaImpl(arg3, arg4, arg5);
            arg2.updateRememberedValue(v0_1);
        }
        else {
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            ((ComposableLambdaImpl)v0).update(arg5);
        }

        arg2.endMovableGroup();
        return ((ComposableLambda)v0_1);
    }

    @ComposeCompilerApi public static final ComposableLambda composableLambdaInstance(int arg1, boolean arg2, Object arg3) {
        return new ComposableLambdaImpl(arg1, arg2, arg3);
    }

    public static final int differentBits(int arg1) {
        return ComposableLambdaKt.bitsForSlot(2, arg1);
    }

    @ComposeCompilerApi public static final ComposableLambda rememberComposableLambda(int arg3, boolean arg4, Object arg5, Composer arg6, int arg7) {
        ComposableLambdaImpl v7_1;
        int v1 = -1573003438;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(rememberComposableLambda)N(key,tracked,block)1372@35376L54:ComposableLambda.kt#9drcc");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:1372)");
        }

        ComposerKt.sourceInformationMarkerStart(arg6, 172187304, "CC(remember):ComposableLambda.kt#9igjgp");
        Object v7 = arg6.rememberedValue();
        if(v7 == Composer.Companion.getEmpty()) {
            v7_1 = new ComposableLambdaImpl(arg3, arg4, arg5);
            arg6.updateRememberedValue(v7_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        v7_1.update(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return ((ComposableLambda)v7_1);
    }

    public static final boolean replacableWith(RecomposeScope arg2, RecomposeScope arg3) {
        if(arg2 != null) {
            if(((arg2 instanceof RecomposeScopeImpl)) && ((arg3 instanceof RecomposeScopeImpl))) {
                RecomposeScope v0 = arg2;
                if(!((RecomposeScopeImpl)v0).getValid()) {
                    return 1;
                }
                else if(Intrinsics.areEqual(arg2, arg3)) {
                    return 1;
                }
                else if(Intrinsics.areEqual(((RecomposeScopeImpl)v0).getAnchor(), ((RecomposeScopeImpl)arg3).getAnchor())) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    public static final int sameBits(int arg1) {
        return ComposableLambdaKt.bitsForSlot(1, arg1);
    }
}

