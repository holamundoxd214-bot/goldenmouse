package androidx.compose.runtime;

import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.internal.Trace;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0011\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0012\u0012\n\u0010\u0013\u001A\u00060\u0014j\u0002`\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010?\u001A\u00020\u00102\u0006\u0010@\u001A\u00020AH\u0016J\b\u0010B\u001A\u00020\rH\u0016J\b\u0010C\u001A\u00020\rH\u0016J\r\u0010D\u001A\u00020\rH\u0000¢\u0006\u0002\bEJ\b\u0010F\u001A\u00020\rH\u0002J\b\u0010G\u001A\u00020\rH\u0002J\u0019\u0010H\u001A\u00020\r2\u0006\u0010I\u001A\u00020*2\u0006\u0010J\u001A\u00020*H\u0082\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u001E\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000E¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0015\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0012¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0017\u0010\u0013\u001A\u00060\u0014j\u0002`\u0015¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b%\u0010&R \u0010(\u001A\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+X\u0082\u000E¢\u0006\u0004\n\u0002\u0010,R\u000E\u0010-\u001A\u00020.X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010/\u001A\b\u0012\u0004\u0012\u00020100X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u00102\u001A\u000203X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b4\u00105R\u001C\u00106\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001407X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b8\u00109R\u0014\u0010:\u001A\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b;\u0010\"R\u0014\u0010<\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b<\u0010\"R\u0014\u0010=\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b=\u0010\"R\u0014\u0010>\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b>\u0010\"¨\u0006K"}, d2={"Landroidx/compose/runtime/PausedCompositionImpl;", "Landroidx/compose/runtime/PausedComposition;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "context", "Landroidx/compose/runtime/CompositionContext;", "composer", "Landroidx/compose/runtime/InternalComposer;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "reusable", "", "applier", "Landroidx/compose/runtime/Applier;", "lock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "<init>", "(Landroidx/compose/runtime/CompositionImpl;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/InternalComposer;Ljava/util/Set;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Applier;Ljava/lang/Object;)V", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "getContext", "()Landroidx/compose/runtime/CompositionContext;", "getComposer", "()Landroidx/compose/runtime/InternalComposer;", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getReusable", "()Z", "getApplier", "()Landroidx/compose/runtime/Applier;", "getLock", "()Ljava/lang/Object;", "Ljava/lang/Object;", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/PausedCompositionState;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "owningThread", "", "invalidScopes", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "getRememberManager$runtime", "()Landroidx/compose/runtime/internal/RememberEventDispatcher;", "pausableApplier", "Landroidx/compose/runtime/RecordingApplier;", "getPausableApplier$runtime", "()Landroidx/compose/runtime/RecordingApplier;", "isRecomposing", "isRecomposing$runtime", "isComplete", "isApplied", "isCancelled", "resume", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "apply", "cancel", "markIncomplete", "markIncomplete$runtime", "markComplete", "applyChanges", "updateState", "from", "to", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PausedCompositionImpl implements PausedComposition {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[PausedCompositionState.values().length];
            try {
                v0[PausedCompositionState.InitialPending.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[PausedCompositionState.RecomposePending.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[PausedCompositionState.Recomposing.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[PausedCompositionState.ApplyPending.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[PausedCompositionState.Applied.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[PausedCompositionState.Cancelled.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[PausedCompositionState.Invalid.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final Applier applier;
    private final InternalComposer composer;
    private final CompositionImpl composition;
    private final Function2 content;
    private final CompositionContext context;
    private ScatterSet invalidScopes;
    private final Object lock;
    private long owningThread;
    private final RecordingApplier pausableApplier;
    private final RememberEventDispatcher rememberManager;
    private final boolean reusable;
    private AtomicReference state;

    static {
    }

    public PausedCompositionImpl(CompositionImpl arg1, CompositionContext arg2, InternalComposer arg3, Set arg4, Function2 arg5, boolean arg6, Applier arg7, Object arg8) {
        super();
        this.composition = arg1;
        this.context = arg2;
        this.composer = arg3;
        this.content = arg5;
        this.reusable = arg6;
        this.applier = arg7;
        this.lock = arg8;
        this.state = new AtomicReference(PausedCompositionState.InitialPending);
        this.owningThread = Thread_jvmKt.currentThreadId();
        this.invalidScopes = ScatterSetKt.emptyScatterSet();
        RememberEventDispatcher v1 = new RememberEventDispatcher();
        v1.prepare(arg4, arg3.getErrorContext$runtime());
        this.rememberManager = v1;
        this.pausableApplier = new RecordingApplier(arg7.getCurrent());
    }

    public void apply() {
        String v0 = "Unexpected state change from: ";
        try {
            switch(WhenMappings.$EnumSwitchMapping$0[this.state.get().ordinal()]) {
                case 1: 
                case 2: 
                case 3: {
                    goto label_41;
                }
                case 4: {
                    goto label_24;
                }
                case 5: {
                    goto label_19;
                }
                case 6: {
                    goto label_14;
                }
                case 7: {
                    goto label_9;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_19:
            throw new IllegalStateException("The paused composition has already been applied".toString());
        label_24:
            this.applyChanges();
            PausedCompositionState v1 = PausedCompositionState.ApplyPending;
            PausedCompositionState v2 = PausedCompositionState.Applied;
            if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, v1, v2)) {
                PreconditionsKt.throwIllegalStateException(v0 + v1 + " to: " + v2 + '.');
            }

            return;
        label_41:
            throw new IllegalStateException("The paused composition has not completed yet".toString());
        label_9:
            throw new IllegalStateException("The paused composition is invalid because of a previous exception".toString());
        label_14:
            throw new IllegalStateException("The paused composition has been cancelled".toString());
        }
        catch(Exception v0_1) {
            this.state.set(PausedCompositionState.Invalid);
            throw v0_1;
        }
    }

    private final void applyChanges() {
        ScatterSet v2;
        Object v1;
        Object v0 = Trace.INSTANCE.beginSection("PausedComposition:applyChanges");
        try {
            v1 = this.lock;
            __monitor_enter(v1);
            v2 = null;
        }
        catch(Throwable v6) {
            goto label_37;
        }

        try {
            RecordingApplier v3_1 = this.pausableApplier;
            Applier v4 = this.applier;
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            v3_1.playTo(v4, this.rememberManager);
            this.rememberManager.dispatchRememberObservers();
            this.rememberManager.dispatchSideEffects();
            goto label_16;
        }
        catch(Throwable v3) {
            try {
                this.rememberManager.dispatchAbandons();
                this.composition.pausedCompositionFinished$runtime(v2);
                throw v3;
            label_16:
                this.rememberManager.dispatchAbandons();
                this.composition.pausedCompositionFinished$runtime(v2);
                goto label_21;
            }
            catch(Throwable v6) {
                try {
                    __monitor_exit(v1);
                    throw v6;
                label_21:
                    __monitor_exit(v1);
                }
                catch(Throwable v6) {
                label_37:
                    Trace.INSTANCE.endSection(v0);
                    throw v6;
                }
            }
        }

        Trace.INSTANCE.endSection(v0);
    }

    public void cancel() {
        this.state.set(PausedCompositionState.Cancelled);
        ScatterSet v0 = this.rememberManager.extractRememberSet();
        this.rememberManager.dispatchAbandons();
        this.composition.pausedCompositionFinished$runtime(v0);
    }

    public final Applier getApplier() {
        return this.applier;
    }

    public final InternalComposer getComposer() {
        return this.composer;
    }

    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final Function2 getContent() {
        return this.content;
    }

    public final CompositionContext getContext() {
        return this.context;
    }

    public final Object getLock() {
        return this.lock;
    }

    public final RecordingApplier getPausableApplier$runtime() {
        return this.pausableApplier;
    }

    public final RememberEventDispatcher getRememberManager$runtime() {
        return this.rememberManager;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    public boolean isApplied() {
        if(this.state.get() == PausedCompositionState.Applied) {
            return 1;
        }

        return 0;
    }

    public boolean isCancelled() {
        if(this.state.get() == PausedCompositionState.Cancelled) {
            return 1;
        }

        return 0;
    }

    public boolean isComplete() {
        if(this.state.get().compareTo(PausedCompositionState.ApplyPending) >= 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isRecomposing$runtime() {
        if(this.state.get() == PausedCompositionState.Recomposing && this.owningThread == Thread_jvmKt.currentThreadId()) {
            return 1;
        }

        return 0;
    }

    private final void markComplete() {
        PausedCompositionState v0 = PausedCompositionState.RecomposePending;
        PausedCompositionState v1 = PausedCompositionState.ApplyPending;
        if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, v0, v1)) {
            PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + v0 + " to: " + v1 + '.');
        }
    }

    public final void markIncomplete$runtime() {
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, PausedCompositionState.ApplyPending, PausedCompositionState.RecomposePending);
    }

    public boolean resume(ShouldPauseCallback arg9) {
        PausedCompositionState v9_2;
        long v4_1;
        PausedCompositionState v4;
        PausedCompositionState v0_1;
        try {
            int v0 = WhenMappings.$EnumSwitchMapping$0[this.state.get().ordinal()];
        }
        catch(Exception v9) {
            goto label_135;
        }

        char v1 = '.';
        String v2 = " to: ";
        String v3 = "Unexpected state change from: ";
        switch(v0) {
            case 1: {
                goto label_92;
            }
            case 2: {
                goto label_36;
            }
            case 3: {
                goto label_31;
            }
            case 4: {
                goto label_26;
            }
            case 5: {
                goto label_21;
            }
            case 6: {
                goto label_16;
            }
            case 7: {
                goto label_11;
            }
        }

        try {
            throw new NoWhenBranchMatchedException();
        label_36:
            v0_1 = PausedCompositionState.RecomposePending;
            v4 = PausedCompositionState.Recomposing;
            if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, v0_1, v4)) {
                PreconditionsKt.throwIllegalStateException(v3 + v0_1 + v2 + v4 + v1);
            }

            v4_1 = this.owningThread;
        }
        catch(Exception v9) {
            goto label_135;
        }

        try {
            this.owningThread = Thread_jvmKt.currentThreadId();
            this.invalidScopes = this.context.recomposePaused$runtime(this.composition, arg9, this.invalidScopes);
            goto label_57;
        }
        catch(Throwable v9_1) {
            try {
                this.owningThread = v4_1;
                v0_1 = PausedCompositionState.Recomposing;
                v4 = PausedCompositionState.RecomposePending;
                if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, v0_1, v4)) {
                    PreconditionsKt.throwIllegalStateException(v3 + v0_1 + v2 + v4 + v1);
                }

                throw v9_1;
            label_57:
                this.owningThread = v4_1;
                v9_2 = PausedCompositionState.Recomposing;
                v0_1 = PausedCompositionState.RecomposePending;
                if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, v9_2, v0_1)) {
                    PreconditionsKt.throwIllegalStateException(v3 + v9_2 + v2 + v0_1 + v1);
                }

                if(!this.invalidScopes.isEmpty()) {
                    goto label_122;
                }

                this.markComplete();
                goto label_122;
            label_21:
                throw new IllegalStateException("The paused composition has been applied".toString());
            label_26:
                throw new IllegalStateException("Pausable composition is complete and apply() should be applied".toString());
            label_11:
                throw new IllegalStateException("The paused composition is invalid because of a previous exception".toString());
            label_92:
                if(this.reusable) {
                    this.composer.startReuseFromRoot$runtime();
                }
            }
            catch(Exception v9) {
                goto label_135;
            }
        }

        try {
            this.invalidScopes = this.context.composeInitialPaused$runtime(this.composition, arg9, this.content);
            goto label_101;
        }
        catch(Throwable v9_1) {
            try {
                if(this.reusable) {
                    this.composer.endReuseFromRoot$runtime();
                }

                throw v9_1;
            label_101:
                if(this.reusable) {
                    this.composer.endReuseFromRoot$runtime();
                }

                v9_2 = PausedCompositionState.InitialPending;
                v0_1 = PausedCompositionState.RecomposePending;
                if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, v9_2, v0_1)) {
                    PreconditionsKt.throwIllegalStateException(v3 + v9_2 + v2 + v0_1 + v1);
                }

                if(!this.invalidScopes.isEmpty()) {
                    goto label_122;
                }

                this.markComplete();
            }
            catch(Exception v9) {
                goto label_135;
            }
        }

    label_122:
        return this.isComplete();
        try {
        label_31:
            ComposerKt.composeRuntimeError("Recursive call to resume()");
            throw new KotlinNothingValueException();
        label_16:
            throw new IllegalStateException("The paused composition has been cancelled".toString());
        }
        catch(Exception v9) {
        label_135:
            this.state.set(PausedCompositionState.Invalid);
            throw v9;
        }
    }

    private final void updateState(PausedCompositionState arg2, PausedCompositionState arg3) {
        if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, arg2, arg3)) {
            PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + arg2 + " to: " + arg3 + '.');
        }
    }
}

