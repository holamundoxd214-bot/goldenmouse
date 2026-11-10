package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex$DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 Z*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002YZB\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010=\u001A\u00020\u001FH\u0002J\u000E\u0010>\u001A\u00020\u001FH\u0082@¢\u0006\u0002\u0010?J\u000E\u0010@\u001A\u00020\u001FH\u0082@¢\u0006\u0002\u0010?J\u000E\u0010A\u001A\u00020\u001FH\u0082@¢\u0006\u0002\u0010?J\u0018\u0010B\u001A\u00020\u001F2\u0006\u0010C\u001A\u0002072\u0006\u0010D\u001A\u00020\u0018H\u0002J\u0016\u0010E\u001A\u00020\u001F2\u0006\u0010\u0007\u001A\u00028\u0000H\u0086@¢\u0006\u0002\u0010FJ\"\u0010G\u001A\u00020\u001F2\b\b\u0001\u0010!\u001A\u00020 2\b\b\u0002\u0010\u0007\u001A\u00028\u0000H\u0086@¢\u0006\u0002\u0010HJ\u000E\u0010I\u001A\u00020\u001FH\u0082@¢\u0006\u0002\u0010?J\u000E\u0010J\u001A\u00020\u001FH\u0082@¢\u0006\u0002\u0010?J\b\u0010K\u001A\u00020\u001FH\u0002J*\u0010L\u001A\u00020\u001F2\b\b\u0002\u0010\u0007\u001A\u00028\u00002\u0010\b\u0002\u0010M\u001A\n\u0012\u0004\u0012\u00020 \u0018\u00010NH\u0086@¢\u0006\u0002\u0010OJ\u001B\u0010P\u001A\u00020\u001F2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001A\u00020\u001FH\u0010¢\u0006\u0002\bSJ\r\u0010T\u001A\u00020\u001FH\u0000¢\u0006\u0002\bUJ\r\u0010V\u001A\u00020\u001FH\u0000¢\u0006\u0002\bWJ\b\u0010X\u001A\u00020\u001FH\u0002R+\u0010\u0007\u001A\u00028\u00002\u0006\u0010\u0006\u001A\u00028\u00008V@PX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R+\u0010\r\u001A\u00028\u00002\u0006\u0010\u0006\u001A\u00028\u00008V@PX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u0005R\u001C\u0010\u0011\u001A\u00028\u0000X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0005R\u0016\u0010\u0015\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0017\u001A\u00020\u0018X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010!\u001A\u00020 2\u0006\u0010\u0006\u001A\u00020 8G@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b&\u0010\'\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b0\u00101R\u000E\u00102\u001A\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u00105\u001A\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001A\u0004\u0018\u000107X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00109\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001F0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010;\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010<\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001F0:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2={"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "<init>", "(Ljava/lang/Object;)V", "<set-?>", "targetState", "getTargetState", "()Ljava/lang/Object;", "setTargetState$animation_core", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "currentState", "getCurrentState", "setCurrentState$animation_core", "currentState$delegate", "composedTargetState", "getComposedTargetState$animation_core", "setComposedTargetState$animation_core", "Ljava/lang/Object;", "transition", "Landroidx/compose/animation/core/Transition;", "totalDurationNanos", "", "getTotalDurationNanos$animation_core", "()J", "setTotalDurationNanos$animation_core", "(J)V", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "", "", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core", "()Lkotlinx/coroutines/sync/Mutex;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "lastFrameTimeNanos", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "currentAnimation", "firstFrameLambda", "Lkotlin/Function1;", "durationScale", "animateOneFrameLambda", "endAllAnimations", "runAnimations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "animateOneFrame", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForCompositionAfterTargetStateChange", "waitForComposition", "moveAnimationToInitialState", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core", "transitionRemoved", "transitionRemoved$animation_core", "observeTotalDuration", "observeTotalDuration$animation_core", "onTotalDurationChanged", "onTotalDurationChanged$animation_core", "seekToFraction", "SeekingAnimationState", "Companion", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SeekableTransitionState extends TransitionState {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "<init>", "()V", "ZeroVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "Target1", "getTarget1", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001A\u00020+H\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001C\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u001C\u0010!\u001A\u0004\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u001E\"\u0004\b#\u0010 R\u001A\u0010$\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001A\u0010\'\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006,"}, d2={"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "<init>", "()V", "progressNanos", "", "getProgressNanos", "()J", "setProgressNanos", "(J)V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "value", "", "getValue", "()F", "setValue", "(F)V", "start", "getStart", "()Landroidx/compose/animation/core/AnimationVector1D;", "setStart", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "initialVelocity", "getInitialVelocity", "setInitialVelocity", "durationNanos", "getDurationNanos", "setDurationNanos", "animationSpecDuration", "getAnimationSpecDuration", "setAnimationSpecDuration", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start;
        private float value;

        static {
        }

        public SeekingAnimationState() {
            super();
            this.start = new AnimationVector1D(0f);
        }

        public final VectorizedAnimationSpec getAnimationSpec() {
            return this.animationSpec;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final float getValue() {
            return this.value;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec arg1) {
            this.animationSpec = arg1;
        }

        public final void setAnimationSpecDuration(long arg1) {
            this.animationSpecDuration = arg1;
        }

        public final void setComplete(boolean arg1) {
            this.isComplete = arg1;
        }

        public final void setDurationNanos(long arg1) {
            this.durationNanos = arg1;
        }

        public final void setInitialVelocity(AnimationVector1D arg1) {
            this.initialVelocity = arg1;
        }

        public final void setProgressNanos(long arg1) {
            this.progressNanos = arg1;
        }

        public final void setStart(AnimationVector1D arg1) {
            this.start = arg1;
        }

        public final void setValue(float arg1) {
            this.value = arg1;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private static final AnimationVector1D Target1;
    private static final AnimationVector1D ZeroVelocity;
    private final Function1 animateOneFrameLambda;
    private Object composedTargetState;
    private CancellableContinuation compositionContinuation;
    private final Mutex compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;
    private final MutableState currentState$delegate;
    private float durationScale;
    private final Function1 firstFrameLambda;
    private final MutableFloatState fraction$delegate;
    private final MutableObjectList initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final Function0 recalculateTotalDurationNanos;
    private final MutableState targetState$delegate;
    private long totalDurationNanos;
    private Transition transition;

    static {
        SeekableTransitionState.Companion = new Companion(null);
        SeekableTransitionState.$stable = 8;
        SeekableTransitionState.ZeroVelocity = new AnimationVector1D(0f);
        SeekableTransitionState.Target1 = new AnimationVector1D(1f);
    }

    public SeekableTransitionState(Object arg5) {
        super(null);
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(arg5, null, 2, null);
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(arg5, null, 2, null);
        this.composedTargetState = arg5;
        this.recalculateTotalDurationNanos = new SeekableTransitionState$$ExternalSyntheticLambda0(this);
        this.fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.compositionContinuationMutex = MutexKt.Mutex$default(false, 1, null);
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = -9223372036854775808L;
        this.initialValueAnimations = new MutableObjectList(0, 1, null);
        this.firstFrameLambda = new SeekableTransitionState$$ExternalSyntheticLambda1(this);
        this.animateOneFrameLambda = new SeekableTransitionState$$ExternalSyntheticLambda2(this);
    }

    public static final Object access$animateOneFrame(SeekableTransitionState arg0, Continuation arg1) {
        return arg0.animateOneFrame(arg1);
    }

    public static final Object access$doOneFrame(SeekableTransitionState arg0, Continuation arg1) {
        return arg0.doOneFrame(arg1);
    }

    public static final void access$endAllAnimations(SeekableTransitionState arg0) {
        arg0.endAllAnimations();
    }

    public static final Companion access$getCompanion$p() {
        return SeekableTransitionState.Companion;
    }

    public static final SeekingAnimationState access$getCurrentAnimation$p(SeekableTransitionState arg0) {
        return arg0.currentAnimation;
    }

    public static final MutableObjectList access$getInitialValueAnimations$p(SeekableTransitionState arg0) {
        return arg0.initialValueAnimations;
    }

    public static final AnimationVector1D access$getTarget1$cp() {
        return SeekableTransitionState.Target1;
    }

    public static final AnimationVector1D access$getZeroVelocity$cp() {
        return SeekableTransitionState.ZeroVelocity;
    }

    public static final void access$moveAnimationToInitialState(SeekableTransitionState arg0) {
        arg0.moveAnimationToInitialState();
    }

    public static final Object access$runAnimations(SeekableTransitionState arg0, Continuation arg1) {
        return arg0.runAnimations(arg1);
    }

    public static final void access$seekToFraction(SeekableTransitionState arg0) {
        arg0.seekToFraction();
    }

    public static final void access$setCurrentAnimation$p(SeekableTransitionState arg0, SeekingAnimationState arg1) {
        arg0.currentAnimation = arg1;
    }

    public static final void access$setFraction(SeekableTransitionState arg0, float arg1) {
        arg0.setFraction(arg1);
    }

    public static final void access$setLastFrameTimeNanos$p(SeekableTransitionState arg0, long arg1) {
        arg0.lastFrameTimeNanos = arg1;
    }

    public static final Object access$waitForComposition(SeekableTransitionState arg0, Continuation arg1) {
        return arg0.waitForComposition(arg1);
    }

    public static final Object access$waitForCompositionAfterTargetStateChange(SeekableTransitionState arg0, Continuation arg1) {
        return arg0.waitForCompositionAfterTargetStateChange(arg1);
    }

    private final Object animateOneFrame(Continuation arg3) {
        float v0 = SuspendAnimationKt.getDurationScale(arg3.getContext());
        if(v0 <= 0f) {
            this.endAllAnimations();
            return Unit.INSTANCE;
        }

        this.durationScale = v0;
        Object v2 = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final Unit animateOneFrameLambda$lambda$0(SeekableTransitionState arg9, long arg10) {
        long v0 = arg10 - arg9.lastFrameTimeNanos;
        arg9.lastFrameTimeNanos = arg10;
        arg10 = MathKt.roundToLong((((double)v0)) / (((double)arg9.durationScale)));
        Object v1 = null;
        if(arg9.initialValueAnimations.isNotEmpty()) {
            MutableObjectList v0_1 = arg9.initialValueAnimations;
            Object[] v2 = ((ObjectList)v0_1).content;
            int v0_2 = ((ObjectList)v0_1)._size;
            int v3 = 0;
            int v4;
            for(v4 = 0; v4 < v0_2; ++v4) {
                Object v5 = v2[v4];
                arg9.recalculateAnimationValue(((SeekingAnimationState)v5), arg10);
                ((SeekingAnimationState)v5).setComplete(true);
            }

            Transition v0_3 = arg9.transition;
            if(v0_3 != null) {
                v0_3.updateInitialValues$animation_core();
            }

            v0_1 = arg9.initialValueAnimations;
            int v2_1 = v0_1._size;
            Object[] v4_1 = v0_1.content;
            IntRange v5_1 = RangesKt.until(0, v0_1._size);
            int v6 = v5_1.getFirst();
            int v5_2 = v5_1.getLast();
            if(v6 <= v5_2) {
                while(true) {
                    v4_1[v6 - v3] = v4_1[v6];
                    if(v4_1[v6].isComplete()) {
                        ++v3;
                    }

                    if(v6 == v5_2) {
                        break;
                    }

                    ++v6;
                }
            }

            ArraysKt.fill(v4_1, v1, v2_1 - v3, v2_1);
            v0_1._size -= v3;
        }

        SeekingAnimationState v0_4 = arg9.currentAnimation;
        if(v0_4 != null) {
            v0_4.setDurationNanos(arg9.totalDurationNanos);
            arg9.recalculateAnimationValue(v0_4, arg10);
            arg9.setFraction(v0_4.getValue());
            if(v0_4.getValue() == 1f) {
                arg9.currentAnimation = ((SeekingAnimationState)v1);
            }

            arg9.seekToFraction();
        }

        return Unit.INSTANCE;
    }

    public final Object animateTo(Object arg8, FiniteAnimationSpec arg9, Continuation arg10) {
        Transition v1 = this.transition;
        if(v1 == null) {
            return Unit.INSTANCE;
        }

        Object v7 = MutatorMutex.mutate$default(this.mutatorMutex, null, new SeekableTransitionState$animateTo$2(v1, this, arg8, arg9, null), arg10, 1, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public static Object animateTo$default(SeekableTransitionState arg0, Object arg1, FiniteAnimationSpec arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.getTargetState();
        }

        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        return arg0.animateTo(arg1, arg2, arg3);
    }

    private final Object doOneFrame(Continuation arg5) {
        Object v4;
        if(this.lastFrameTimeNanos == -9223372036854775808L) {
            v4 = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, arg5);
            if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v4;
            }

            return Unit.INSTANCE;
        }

        v4 = this.animateOneFrame(arg5);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    private final void endAllAnimations() {
        Transition v0 = this.transition;
        if(v0 != null) {
            v0.clearInitialAnimations$animation_core();
        }

        this.initialValueAnimations.clear();
        if(this.currentAnimation != null) {
            this.currentAnimation = null;
            this.setFraction(1f);
            this.seekToFraction();
        }
    }

    static final Unit firstFrameLambda$lambda$0(SeekableTransitionState arg0, long arg1) {
        arg0.lastFrameTimeNanos = arg1;
        return Unit.INSTANCE;
    }

    public final Object getComposedTargetState$animation_core() {
        return this.composedTargetState;
    }

    public final CancellableContinuation getCompositionContinuation$animation_core() {
        return this.compositionContinuation;
    }

    public final Mutex getCompositionContinuationMutex$animation_core() {
        return this.compositionContinuationMutex;
    }

    public Object getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    public final float getFraction() {
        return this.fraction$delegate.getFloatValue();
    }

    public Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos$animation_core() {
        return this.totalDurationNanos;
    }

    private final void moveAnimationToInitialState() {
        Transition v0 = this.transition;
        if(v0 == null) {
            return;
        }

        SeekingAnimationState v1 = this.currentAnimation;
        SeekingAnimationState v2 = null;
        if(v1 == null) {
            if(this.totalDurationNanos > 0) {
                if(this.getFraction() == 1f) {
                }
                else if(Intrinsics.areEqual(this.getCurrentState(), this.getTargetState())) {
                }
                else {
                    v1 = new SeekingAnimationState();
                    v1.setValue(this.getFraction());
                    long v3 = this.totalDurationNanos;
                    v1.setDurationNanos(v3);
                    v1.setAnimationSpecDuration(MathKt.roundToLong((((double)v3)) * (1 - (((double)this.getFraction())))));
                    v1.getStart().set$animation_core(0, this.getFraction());
                    goto label_38;
                }
            }

            v1 = v2;
        }

    label_38:
        if(v1 != null) {
            v1.setDurationNanos(this.totalDurationNanos);
            this.initialValueAnimations.add(v1);
            v0.setInitialAnimations$animation_core(v1);
        }

        this.currentAnimation = v2;
    }

    public final void observeTotalDuration$animation_core() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.access$getSeekableTransitionStateTotalDurationChanged$p(), this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core() {
        long v0 = this.totalDurationNanos;
        this.observeTotalDuration$animation_core();
        long v2 = this.totalDurationNanos;
        if(v0 != v2) {
            SeekingAnimationState v0_1 = this.currentAnimation;
            if(v0_1 != null) {
                long v1 = v0_1.getProgressNanos();
                long v3 = this.totalDurationNanos;
                if(v1 > v3) {
                    this.endAllAnimations();
                    return;
                }
                else {
                    v0_1.setDurationNanos(v3);
                    if(v0_1.getAnimationSpec() == null) {
                        v0_1.setAnimationSpecDuration(MathKt.roundToLong((1 - (((double)v0_1.getStart().get$animation_core(0)))) * (((double)this.totalDurationNanos))));
                        return;
                    }
                }
            }
            else if(v2 != 0) {
                this.seekToFraction();
            }
        }
    }

    private final void recalculateAnimationValue(SeekingAnimationState arg9, long arg10) {
        long v3 = arg9.getProgressNanos() + arg10;
        arg9.setProgressNanos(v3);
        arg10 = arg9.getAnimationSpecDuration();
        float v0 = 1f;
        if(Long.compare(v3, arg10) >= 0) {
            arg9.setValue(v0);
            return;
        }

        VectorizedAnimationSpec v2 = arg9.getAnimationSpec();
        if(v2 != null) {
            AnimationVector1D v5 = arg9.getStart();
            AnimationVector1D v6 = SeekableTransitionState.Target1;
            AnimationVector1D v10 = arg9.getInitialVelocity();
            if(v10 == null) {
                v10 = SeekableTransitionState.ZeroVelocity;
            }

            arg9.setValue(RangesKt.coerceIn(v2.getValueFromNanos(v3, ((AnimationVector)v5), ((AnimationVector)v6), v10).get$animation_core(0), 0f, v0));
            return;
        }

        float v1 = (((float)v3)) / (((float)arg10));
        arg9.setValue(arg9.getStart().get$animation_core(0) * (v0 - v1) + v1 * v0);
    }

    static final Unit recalculateTotalDurationNanos$lambda$0(SeekableTransitionState arg2) {
        Transition v0 = arg2.transition;
        long v0_1 = v0 != null ? v0.getTotalDurationNanos() : 0;
        arg2.totalDurationNanos = v0_1;
        return Unit.INSTANCE;
    }

    private final Object runAnimations(Continuation arg10) {
        int v2;
        Continuation v0;
        if((arg10 instanceof SeekableTransitionState$runAnimations$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((SeekableTransitionState$runAnimations$1)v0).label & v2) != 0) {
                ((SeekableTransitionState$runAnimations$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            SeekableTransitionState$runAnimations$1 v0_1 = new SeekableTransitionState$runAnimations$1(this, arg10);
        }

        Object v10 = ((SeekableTransitionState$runAnimations$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((SeekableTransitionState$runAnimations$1)v0).label;
        int v3 = 2;
        long v5 = -9223372036854775808L;
        if(v2 != 0) {
            if(v2 != 1) {
                if(v2 == v3) {
                }
                else {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }

            ResultKt.throwOnFailure(v10);
            goto label_52;
        }
        else {
            ResultKt.throwOnFailure(v10);
            if((this.initialValueAnimations.isEmpty()) && this.currentAnimation == null) {
                return Unit.INSTANCE;
            }

            if(SuspendAnimationKt.getDurationScale(v0.getContext()) == 0f) {
                this.endAllAnimations();
                this.lastFrameTimeNanos = v5;
                return Unit.INSTANCE;
            }

            if(this.lastFrameTimeNanos == v5) {
                Function1 v10_1 = this.firstFrameLambda;
                ((SeekableTransitionState$runAnimations$1)v0).label = 1;
                if(MonotonicFrameClockKt.withFrameNanos(v10_1, v0) != v1) {
                    goto label_52;
                }

                return v1;
            }

            do {
            label_52:
                if(!this.initialValueAnimations.isNotEmpty()) {
                    if(this.currentAnimation != null) {
                    }
                    else {
                        this.lastFrameTimeNanos = v5;
                        return Unit.INSTANCE;
                    }
                }

                ((SeekableTransitionState$runAnimations$1)v0).label = v3;
                if(this.animateOneFrame(v0) != v1) {
                    continue;
                }

                return v1;
            }
            while(true);
        }

        return v1;
    }

    public final Object seekTo(float arg13, Object arg14, Continuation arg15) {
        int v1 = 0;
        if(Float.compare(0f, arg13) <= 0 && arg13 <= 1f) {
            v1 = 1;
        }

        if(v1 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + arg13);
        }

        Transition v5 = this.transition;
        if(v5 == null) {
            return Unit.INSTANCE;
        }

        Object v12 = MutatorMutex.mutate$default(this.mutatorMutex, null, new SeekableTransitionState$seekTo$3(arg14, this.getTargetState(), this, v5, arg13, null), arg15, 1, null);
        if(v12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v12;
        }

        return Unit.INSTANCE;
    }

    public static Object seekTo$default(SeekableTransitionState arg0, float arg1, Object arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.getTargetState();
        }

        return arg0.seekTo(arg1, arg2, arg3);
    }

    private final void seekToFraction() {
        Transition v0 = this.transition;
        if(v0 == null) {
            return;
        }

        v0.seekAnimations$animation_core(MathKt.roundToLong((((double)this.getFraction())) * (((double)v0.getTotalDurationNanos()))));
    }

    public final void setComposedTargetState$animation_core(Object arg1) {
        this.composedTargetState = arg1;
    }

    public final void setCompositionContinuation$animation_core(CancellableContinuation arg1) {
        this.compositionContinuation = arg1;
    }

    public void setCurrentState$animation_core(Object arg1) {
        this.currentState$delegate.setValue(arg1);
    }

    private final void setFraction(float arg1) {
        this.fraction$delegate.setFloatValue(arg1);
    }

    public void setTargetState$animation_core(Object arg1) {
        this.targetState$delegate.setValue(arg1);
    }

    public final void setTotalDurationNanos$animation_core(long arg1) {
        this.totalDurationNanos = arg1;
    }

    public final Object snapTo(Object arg7, Continuation arg8) {
        Transition v0 = this.transition;
        if(v0 == null) {
            return Unit.INSTANCE;
        }

        if((Intrinsics.areEqual(this.getCurrentState(), arg7)) && (Intrinsics.areEqual(this.getTargetState(), arg7))) {
            return Unit.INSTANCE;
        }

        Object v6 = MutatorMutex.mutate$default(this.mutatorMutex, null, new SeekableTransitionState$snapTo$2(this, arg7, v0, null), arg8, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public void transitionConfigured$animation_core(Transition arg3) {
        Transition v0 = this.transition;
        int v0_1 = v0 == null || (Intrinsics.areEqual(arg3, v0)) ? 1 : 0;
        if(v0_1 == 0) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + arg3);
        }

        this.transition = arg3;
    }

    public void transitionRemoved$animation_core() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }

    private final Object waitForComposition(Continuation arg7) {
        Object v0_2;
        Object v2_1;
        SeekableTransitionState$waitForComposition$1 v0_1;
        int v2;
        if((arg7 instanceof SeekableTransitionState$waitForComposition$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((SeekableTransitionState$waitForComposition$1)v0).label & v2) != 0) {
                ((SeekableTransitionState$waitForComposition$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SeekableTransitionState$waitForComposition$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        Object v4 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            v7 = this.getTargetState();
            Mutex v2_2 = this.compositionContinuationMutex;
            v0_1.L$0 = v7;
            v0_1.label = 1;
            if(DefaultImpls.lock$default(v2_2, v4, ((Continuation)v0_1), 1, v4) == v1) {
                return v1;
            }
            else {
            label_41:
                v0_1.L$0 = v7;
                v0_1.label = v3;
                CancellableContinuationImpl v2_3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(((Continuation)v0_1)), 1);
                v2_3.initCancellability();
                this.setCompositionContinuation$animation_core(v2_3);
                DefaultImpls.unlock$default(this.getCompositionContinuationMutex$animation_core(), v4, 1, v4);
                v2_1 = v2_3.getResult();
                if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(((Continuation)v0_1));
                }

                if(v2_1 == v1) {
                    return v1;
                }

                v0_2 = v7;
                v7 = v2_1;
            }
        }
        else if(v2 == 1) {
            v2_1 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
            v7 = v2_1;
            goto label_41;
        }
        else if(v2 == v3) {
            v0_2 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(Intrinsics.areEqual(v7, v0_2)) {
            return Unit.INSTANCE;
        }

        this.lastFrameTimeNanos = -9223372036854775808L;
        throw new CancellationException("targetState while waiting for composition");
    }

    private final Object waitForCompositionAfterTargetStateChange(Continuation arg7) {
        Object v0_2;
        Object v2_1;
        int v2;
        Continuation v0;
        if((arg7 instanceof SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).label & v2) != 0) {
                ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 v0_1 = new SeekableTransitionState$waitForCompositionAfterTargetStateChange$1(this, arg7);
        }

        Object v7 = ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).label;
        int v3 = 2;
        Object v4 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            v7 = this.getTargetState();
            Mutex v2_2 = this.compositionContinuationMutex;
            ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).L$0 = v7;
            ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).label = 1;
            if(DefaultImpls.lock$default(v2_2, v4, v0, 1, v4) == v1) {
                return v1;
            }
            else {
            label_41:
                if(Intrinsics.areEqual(v7, this.composedTargetState)) {
                    DefaultImpls.unlock$default(this.compositionContinuationMutex, v4, 1, v4);
                }
                else {
                    ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).L$0 = v7;
                    ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).label = v3;
                    CancellableContinuationImpl v2_3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(v0), 1);
                    v2_3.initCancellability();
                    this.setCompositionContinuation$animation_core(v2_3);
                    DefaultImpls.unlock$default(this.getCompositionContinuationMutex$animation_core(), v4, 1, v4);
                    v2_1 = v2_3.getResult();
                    if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(v0);
                    }

                    if(v2_1 == v1) {
                        return v1;
                    }

                    v0_2 = v7;
                    v7 = v2_1;
                label_65:
                    if(!Intrinsics.areEqual(v7, v0_2)) {
                        goto label_69;
                    }
                }
            }
        }
        else if(v2 == 1) {
            v2_1 = ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
            v7 = v2_1;
            goto label_41;
        }
        else if(v2 == v3) {
            v0_2 = ((SeekableTransitionState$waitForCompositionAfterTargetStateChange$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
            goto label_65;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    label_69:
        this.lastFrameTimeNanos = -9223372036854775808L;
        throw new CancellationException("snapTo() was canceled because state was changed to " + v7 + " instead of " + v0_2);
    }
}

