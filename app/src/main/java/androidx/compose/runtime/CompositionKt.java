package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000P\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001A\'\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001A.\u0010\u0006\u001A\u0002H\u0007\"\u0004\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00070\fH\u0080\b¢\u0006\u0002\u0010\r\u001A\u001A\u0010\u000E\u001A\u00020\u00022\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u0012\u001A\u001A\u0010\u0013\u001A\u00020\u00142\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u0012\u001A\u001C\u0010\u0015\u001A\u00020\b2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0007\"\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u000E\u0010\u001E\u001A\u00020\u001FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010 \u001A\u00020\u001FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010!\u001A\u00020\u001FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020\u001FX\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"getCompositionService", "T", "Landroidx/compose/runtime/Composition;", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/Composition;Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "pausable", "R", "Landroidx/compose/runtime/ControlledComposition;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "block", "Lkotlin/Function0;", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Composition", "applier", "Landroidx/compose/runtime/Applier;", "parent", "Landroidx/compose/runtime/CompositionContext;", "ReusableComposition", "Landroidx/compose/runtime/ReusableComposition;", "ControlledComposition", "PendingApplyNoModifications", "", "ObservableCompositionServiceKey", "Landroidx/compose/runtime/tooling/ObservableComposition;", "getObservableCompositionServiceKey$annotations", "()V", "getObservableCompositionServiceKey", "()Landroidx/compose/runtime/CompositionServiceKey;", "RUNNING", "", "DEACTIVATED", "INCONSISTENT", "DISPOSED", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionKt {
    private static final int DEACTIVATED = 1;
    private static final int DISPOSED = 3;
    private static final int INCONSISTENT = 2;
    private static final CompositionServiceKey ObservableCompositionServiceKey;
    private static final Object PendingApplyNoModifications;
    private static final int RUNNING;

    static {
        CompositionKt.PendingApplyNoModifications = new Object();
        CompositionKt.ObservableCompositionServiceKey = new CompositionKt$ObservableCompositionServiceKey$1();
    }

    public static final Composition Composition(Applier arg1, CompositionContext arg2) {
        return new CompositionImpl(arg2, arg1);
    }

    public static final ControlledComposition ControlledComposition(Applier arg1, CompositionContext arg2) {
        return new CompositionImpl(arg2, arg1);
    }

    public static final ReusableComposition ReusableComposition(Applier arg1, CompositionContext arg2) {
        return new CompositionImpl(arg2, arg1);
    }

    public static final Object access$getPendingApplyNoModifications$p() {
        return CompositionKt.PendingApplyNoModifications;
    }

    public static final Object getCompositionService(Composition arg2, CompositionServiceKey arg3) {
        Object v1 = null;
        if((arg2 instanceof CompositionServices)) {
        }
        else {
            arg2 = ((Composition)v1);
        }

        if(arg2 != null) {
            return ((CompositionServices)arg2).getCompositionService(arg3);
        }

        return v1;
    }

    public static final CompositionServiceKey getObservableCompositionServiceKey() {
        return CompositionKt.ObservableCompositionServiceKey;
    }

    public static void getObservableCompositionServiceKey$annotations() {
    }

    public static final Object pausable(ControlledComposition arg0, ShouldPauseCallback arg1, Function0 arg2) {
        Object v2_1;
        arg1 = arg0.getAndSetShouldPauseCallback(arg1);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            arg0.getAndSetShouldPauseCallback(arg1);
            throw v2;
        }

        arg0.getAndSetShouldPauseCallback(arg1);
        return v2_1;
    }
}

