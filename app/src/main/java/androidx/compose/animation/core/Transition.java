package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B1\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB#\b\u0011\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\nB\u001B\b\u0010\u0012\u0006\u0010\u000B\u001A\u00028\u0000\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\fB#\b\u0011\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000EJ\b\u0010T\u001A\u00020\'H\u0002J\u001D\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020\'2\u0006\u0010X\u001A\u00020YH\u0000¢\u0006\u0002\bZJ\u001D\u0010U\u001A\u00020V2\u0006\u0010[\u001A\u00020\'2\u0006\u0010\\\u001A\u00020%H\u0000¢\u0006\u0002\bZJ\u0015\u0010]\u001A\u00020V2\u0006\u0010W\u001A\u00020\'H\u0000¢\u0006\u0002\b^J\r\u0010_\u001A\u00020VH\u0000¢\u0006\u0002\b`J\r\u0010a\u001A\u00020VH\u0000¢\u0006\u0002\bbJ\'\u0010c\u001A\u00020V2\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00028\u00002\u0006\u00100\u001A\u00020\'H\u0007¢\u0006\u0004\bd\u0010eJ\u0019\u0010f\u001A\u00020%2\n\u0010g\u001A\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bhJ\u0019\u0010i\u001A\u00020%2\n\u0010g\u001A\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bjJ\'\u0010k\u001A\u00020%2\u0018\u0010l\u001A\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bmJ\'\u0010n\u001A\u00020V2\u0018\u0010l\u001A\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001A\u00020V2\u0006\u0010\u0017\u001A\u00028\u0000H\u0000¢\u0006\u0004\bq\u0010\u001AJ\u0017\u0010r\u001A\u00020V2\u0006\u0010\u0017\u001A\u00028\u0000H\u0001¢\u0006\u0004\bs\u0010tJ\u0015\u0010u\u001A\u00020V2\u0006\u00100\u001A\u00020\'H\u0000¢\u0006\u0002\bvJ\u0015\u0010w\u001A\u00020V2\u0006\u0010x\u001A\u00020yH\u0000¢\u0006\u0002\bzJ\u0015\u0010{\u001A\u00020V2\u0006\u0010|\u001A\u00020YH\u0000¢\u0006\u0002\b}J\r\u0010~\u001A\u00020VH\u0000¢\u0006\u0002\b\u007FJ\u000F\u0010\u0080\u0001\u001A\u00020VH\u0000¢\u0006\u0003\b\u0081\u0001J\t\u0010\u0082\u0001\u001A\u00020\u0007H\u0016J\t\u0010\u0083\u0001\u001A\u00020VH\u0002J)\u0010n\u001A\u00020V2\u001A\u0010\u0084\u0001\u001A\u0015\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0085\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u00008F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001AR7\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001C\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u0011\u0010$\u001A\u00020%8F¢\u0006\u0006\u001A\u0004\b$\u0010&R+\u0010(\u001A\u00020\'2\u0006\u0010\u0016\u001A\u00020\'8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00100\u001A\u00020\'2\u0006\u0010/\u001A\u00020\'8G@GX\u0086\u000E¢\u0006\f\u001A\u0004\b1\u0010*\"\u0004\b2\u0010,R+\u00103\u001A\u00020\'2\u0006\u0010\u0016\u001A\u00020\'8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b6\u0010.\u001A\u0004\b4\u0010*\"\u0004\b5\u0010,R+\u00107\u001A\u00020%2\u0006\u0010\u0016\u001A\u00020%8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b;\u0010\u001C\u001A\u0004\b8\u0010&\"\u0004\b9\u0010:R&\u0010<\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u00000=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010@\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000A8F¢\u0006\u0006\u001A\u0004\bB\u0010CR)\u0010D\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u00000A8F¢\u0006\u0006\u001A\u0004\bE\u0010CR+\u0010F\u001A\u00020%2\u0006\u0010\u0016\u001A\u00020%8G@AX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bH\u0010\u001C\u001A\u0004\bF\u0010&\"\u0004\bG\u0010:R\u001A\u0010I\u001A\u00020\'X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010*\"\u0004\bK\u0010,R\u001A\u0010L\u001A\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010N\u001A\u0004\bO\u0010&R\u001B\u0010P\u001A\u00020\'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001A\u0004\bQ\u0010*¨\u0006\u008A\u0001²\u0006\u000B\u0010\u008B\u0001\u001A\u00020%X\u008A\u0084\u0002"}, d2={"Landroidx/compose/animation/core/Transition;", "S", "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "parentTransition", "label", "", "<init>", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "getLabel", "()Ljava/lang/String;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "<set-?>", "targetState", "getTargetState", "setTargetState$animation_core", "(Ljava/lang/Object;)V", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "isRunning", "", "()Z", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "value", "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "startTimeNanos", "getStartTimeNanos$animation_core", "setStartTimeNanos$animation_core", "startTimeNanos$delegate", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "(Z)V", "updateChildrenNeeded$delegate", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "_transitions", "transitions", "", "getTransitions", "()Ljava/util/List;", "animations", "getAnimations", "isSeeking", "setSeeking$animation_core", "isSeeking$delegate", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core", "setLastSeekedTimeNanos$animation_core", "hasInitialValueAnimations", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "calculateTotalDurationNanos", "onFrame", "", "frameTimeNanos", "durationScale", "", "onFrame$animation_core", "scaledPlayTimeNanos", "scaleToEnd", "onTransitionStart", "onTransitionStart$animation_core", "onDisposed", "onDisposed$animation_core", "onTransitionEnd", "onTransitionEnd$animation_core", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "addTransition", "transition", "addTransition$animation_core", "removeTransition", "removeTransition$animation_core", "addAnimation", "animation", "addAnimation$animation_core", "removeAnimation", "removeAnimation$animation_core", "updateTarget", "updateTarget$animation_core", "animateTo", "animateTo$animation_core", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "seekAnimations", "seekAnimations$animation_core", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core", "clearInitialAnimations", "clearInitialAnimations$animation_core", "updateInitialValues", "updateInitialValues$animation_core", "toString", "onChildAnimationUpdated", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "TransitionAnimationState", "SegmentImpl", "Segment", "DeferredAnimation", "animation-core", "runFrameLoop"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Transition {
    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001\'B%\b\u0000\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJT\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00010\u001A2#\u0010\u001B\u001A\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001D\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001E0\u001C¢\u0006\u0002\b\u001F2!\u0010 \u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00028\u00010\u001CJ\r\u0010$\u001A\u00020%H\u0000¢\u0006\u0002\b&R\u001D\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER{\u0010\u0012\u001A*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010R\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00112.\u0010\u000F\u001A*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010R\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2={"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core", "DeferredAnimationData", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeferredAnimation {
        @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bm\u0012\u001C\u0010\u0005\u001A\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001A\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000B0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u001B\u001A\u00020\u001C2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\nR\'\u0010\u0005\u001A\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R7\u0010\b\u001A\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000B0\t¢\u0006\u0002\b\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R5\u0010\r\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0016\"\u0004\b\u001A\u0010\u0018R\u0014\u0010\u001E\u001A\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ¨\u0006!"}, d2={"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "setTransitionSpec", "(Lkotlin/jvm/functions/Function1;)V", "getTargetValueByState", "setTargetValueByState", "updateAnimationStates", "", "segment", "value", "getValue", "()Ljava/lang/Object;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeferredAnimationData implements State {
            private final TransitionAnimationState animation;
            private Function1 targetValueByState;
            private Function1 transitionSpec;

            public DeferredAnimationData(DeferredAnimation arg1, TransitionAnimationState arg2, Function1 arg3, Function1 arg4) {
                DeferredAnimation.this = arg1;
                super();
                this.animation = arg2;
                this.transitionSpec = arg3;
                this.targetValueByState = arg4;
            }

            public final TransitionAnimationState getAnimation() {
                return this.animation;
            }

            public final Function1 getTargetValueByState() {
                return this.targetValueByState;
            }

            public final Function1 getTransitionSpec() {
                return this.transitionSpec;
            }

            public Object getValue() {
                this.updateAnimationStates(DeferredAnimation.this.this$0.getSegment());
                return this.animation.getValue();
            }

            public final void setTargetValueByState(Function1 arg1) {
                this.targetValueByState = arg1;
            }

            public final void setTransitionSpec(Function1 arg1) {
                this.transitionSpec = arg1;
            }

            public final void updateAnimationStates(Segment arg4) {
                Object v0 = this.targetValueByState.invoke(arg4.getTargetState());
                if(DeferredAnimation.this.this$0.isSeeking()) {
                    this.animation.updateInitialAndTargetValue$animation_core(this.targetValueByState.invoke(arg4.getInitialState()), v0, this.transitionSpec.invoke(arg4));
                    return;
                }

                this.animation.updateTargetValue$animation_core(v0, this.transitionSpec.invoke(arg4));
            }
        }

        private final MutableState data$delegate;
        private final String label;
        private final TwoWayConverter typeConverter;

        public DeferredAnimation(Transition arg1, TwoWayConverter arg2, String arg3) {
            Transition.this = arg1;
            super();
            this.typeConverter = arg2;
            this.label = arg3;
            this.data$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        }

        public final State animate(Function1 arg8, Function1 arg9) {
            DeferredAnimationData v0 = this.getData$animation_core();
            if(v0 == null) {
                v0 = new DeferredAnimationData(this, new TransitionAnimationState(Transition.this, arg9.invoke(Transition.this.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, arg9.invoke(Transition.this.getCurrentState())), this.typeConverter, this.label), arg8, arg9);
                Transition v1 = Transition.this;
                this.setData$animation_core(v0);
                v1.addAnimation$animation_core(v0.getAnimation());
            }

            Transition v7 = Transition.this;
            v0.setTargetValueByState(arg9);
            v0.setTransitionSpec(arg8);
            v0.updateAnimationStates(v7.getSegment());
            return ((State)v0);
        }

        public final DeferredAnimationData getData$animation_core() {
            return this.data$delegate.getValue();
        }

        public final String getLabel() {
            return this.label;
        }

        public final TwoWayConverter getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core(DeferredAnimationData arg1) {
            this.data$delegate.setValue(arg1);
        }

        public final void setupSeeking$animation_core() {
            DeferredAnimationData v0 = this.getData$animation_core();
            if(v0 != null) {
                v0.getAnimation().updateInitialAndTargetValue$animation_core(v0.getTargetValueByState().invoke(Transition.this.getSegment().getInitialState()), v0.getTargetValueByState().invoke(Transition.this.getSegment().getTargetState()), v0.getTransitionSpec().invoke(Transition.this.getSegment()));
            }
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001A\u0010\b\u001A\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001A\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001A\u00028\u0001X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00028\u0001X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0003"}, d2={"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Segment {
        @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
            @Deprecated public static boolean isTransitioningTo(Segment arg0, Object arg1, Object arg2) {
                return arg0.isTransitioningTo(arg1, arg2);
            }
        }

        static boolean access$isTransitioningTo$jd(Segment arg0, Object arg1, Object arg2) {
            return super.isTransitioningTo(arg1, arg2);
        }

        Object getInitialState();

        Object getTargetState();

        default boolean isTransitioningTo(Object arg2, Object arg3) {
            if((Intrinsics.areEqual(arg2, this.getInitialState())) && (Intrinsics.areEqual(arg3, this.getTargetState()))) {
                return 1;
            }

            return 0;
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00028\u0001\u0012\u0006\u0010\u0004\u001A\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0016\u0010\u0003\u001A\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001A\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\n\u0010\b¨\u0006\u0011"}, d2={"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class SegmentImpl implements Segment {
        private final Object initialState;
        private final Object targetState;

        public SegmentImpl(Object arg1, Object arg2) {
            super();
            this.initialState = arg1;
            this.targetState = arg2;
        }

        public boolean equals(Object arg3) {
            if(((arg3 instanceof Segment)) && (Intrinsics.areEqual(this.getInitialState(), ((Segment)arg3).getInitialState())) && (Intrinsics.areEqual(this.getTargetState(), ((Segment)arg3).getTargetState()))) {
                return 1;
            }

            return 0;
        }

        public Object getInitialState() {
            return this.initialState;
        }

        public Object getTargetState() {
            return this.targetState;
        }

        public int hashCode() {
            Object v0 = this.getInitialState();
            int v1 = 0;
            int v0_1 = v0 != null ? v0.hashCode() : 0;
            v0_1 *= 0x1F;
            Object v2 = this.getTargetState();
            if(v2 != null) {
                v1 = v2.hashCode();
            }

            return v0_1 + v1;
        }
    }

    @Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u001D\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B5\b\u0000\u0012\u0006\u0010\u0005\u001A\u00028\u0001\u0012\u0006\u0010\u0006\u001A\u00028\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020F2\u0006\u0010R\u001A\u000200H\u0000¢\u0006\u0002\bSJ\u0015\u0010T\u001A\u00020P2\u0006\u0010Q\u001A\u00020FH\u0000¢\u0006\u0002\bUJ\r\u0010V\u001A\u00020PH\u0000¢\u0006\u0002\bWJ!\u0010Y\u001A\u00020P2\b\b\u0002\u0010\u0005\u001A\u00028\u00012\b\b\u0002\u0010Z\u001A\u000200H\u0002¢\u0006\u0002\u0010[J\r\u0010\\\u001A\u00020PH\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001A\u00020P2\u0006\u0010_\u001A\u000207H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001A\u00020P2\u0006\u0010b\u001A\u00020*H\u0000¢\u0006\u0002\bcJ\r\u0010d\u001A\u00020PH\u0000¢\u0006\u0002\beJ\b\u0010f\u001A\u00020\nH\u0016J%\u0010g\u001A\u00020P2\u0006\u0010\u0012\u001A\u00028\u00012\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u001BH\u0000¢\u0006\u0004\bh\u0010iJ-\u0010j\u001A\u00020P2\u0006\u0010\u0005\u001A\u00028\u00012\u0006\u0010\u0012\u001A\u00028\u00012\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u001BH\u0000¢\u0006\u0004\bk\u0010lR\u001D\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R+\u0010\u0012\u001A\u00028\u00012\u0006\u0010\u0011\u001A\u00028\u00018B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00010\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u001B2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u001B8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 RC\u0010#\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001C\u0010)\u001A\u0004\u0018\u00010*X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001C\u0010/\u001A\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000R+\u00101\u001A\u0002002\u0006\u0010\u0011\u001A\u0002008@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0018\u001A\u0004\b2\u00103\"\u0004\b4\u00105R+\u00108\u001A\u0002072\u0006\u0010\u0011\u001A\u0002078@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000E\u0010?\u001A\u000200X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010@\u001A\u00028\u00012\u0006\u0010\u0011\u001A\u00028\u00018V@PX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001A\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u0010\u0010D\u001A\u00028\u0002X\u0082\u000E¢\u0006\u0004\n\u0002\u0010ER+\u0010G\u001A\u00020F2\u0006\u0010\u0011\u001A\u00020F8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001A\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000E\u0010N\u001A\u000200X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010X\u001A\b\u0012\u0004\u0012\u00028\u00010\u001BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2={"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "<init>", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "Landroidx/compose/runtime/MutableState;", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "initialValueAnimation", "", "isFinished", "isFinished$animation_core", "()Z", "setFinished$animation_core", "(Z)V", "isFinished$delegate", "", "resetSnapValue", "getResetSnapValue$animation_core", "()F", "setResetSnapValue$animation_core", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "useOnlyInitialValue", "value", "getValue", "setValue$animation_core", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "", "durationNanos", "getDurationNanos$animation_core", "()J", "setDurationNanos$animation_core", "(J)V", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "isSeeking", "onPlayTimeChanged", "", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core", "seekTo", "seekTo$animation_core", "updateInitialValue", "updateInitialValue$animation_core", "interruptionSpec", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "resetAnimation", "resetAnimation$animation_core", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core", "clearInitialAnimation", "clearInitialAnimation$animation_core", "toString", "updateTargetValue", "updateTargetValue$animation_core", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransitionAnimationState implements State {
        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate;
        private final SpringSpec defaultSpring;
        private final MutableLongState durationNanos$delegate;
        private TargetBasedAnimation initialValueAnimation;
        private SeekingAnimationState initialValueState;
        private final FiniteAnimationSpec interruptionSpec;
        private final MutableState isFinished$delegate;
        private boolean isSeeking;
        private final String label;
        private final MutableFloatState resetSnapValue$delegate;
        private final MutableState targetValue$delegate;
        private final TwoWayConverter typeConverter;
        private boolean useOnlyInitialValue;
        private final MutableState value$delegate;
        private AnimationVector velocityVector;

        public TransitionAnimationState(Transition arg9, Object arg10, AnimationVector arg11, TwoWayConverter arg12, String arg13) {
            Transition.this = arg9;
            super();
            this.typeConverter = arg12;
            this.label = arg13;
            SnapshotMutationPolicy v9 = null;
            this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(arg10, v9, 2, v9);
            SpringSpec v0 = AnimationSpecKt.spring$default(0f, 0f, v9, 7, v9);
            this.defaultSpring = v0;
            this.animationSpec$delegate = SnapshotStateKt.mutableStateOf$default(v0, v9, 2, v9);
            Object v5 = arg10;
            TwoWayConverter v4 = arg12;
            this.animation$delegate = SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(this.getAnimationSpec(), v4, v5, this.getTargetValue(), arg11), v9, 2, v9);
            this.isFinished$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), v9, 2, v9);
            this.resetSnapValue$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1f);
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(v5, v9, 2, v9);
            this.velocityVector = arg11;
            this.durationNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(this.getAnimation().getDurationNanos());
            arg10 = VisibilityThresholdsKt.getVisibilityThresholdMap().get(v4);
            if(arg10 != null) {
                float v10 = ((Number)arg10).floatValue();
                Object v11 = v4.getConvertToVector().invoke(v5);
                int v12 = ((AnimationVector)v11).getSize$animation_core();
                int v13;
                for(v13 = 0; v13 < v12; ++v13) {
                    ((AnimationVector)v11).set$animation_core(v13, v10);
                }

                arg10 = this.typeConverter.getConvertFromVector().invoke(v11);
            }
            else {
                arg10 = v9;
            }

            this.interruptionSpec = AnimationSpecKt.spring$default(0f, 0f, arg10, 3, v9);
        }

        public final void clearInitialAnimation$animation_core() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        public final TargetBasedAnimation getAnimation() {
            return this.animation$delegate.getValue();
        }

        public final FiniteAnimationSpec getAnimationSpec() {
            return this.animationSpec$delegate.getValue();
        }

        public final long getDurationNanos$animation_core() {
            return this.durationNanos$delegate.getLongValue();
        }

        public final SeekingAnimationState getInitialValueState$animation_core() {
            return this.initialValueState;
        }

        public final String getLabel() {
            return this.label;
        }

        public final float getResetSnapValue$animation_core() {
            return this.resetSnapValue$delegate.getFloatValue();
        }

        private final Object getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        public final TwoWayConverter getTypeConverter() {
            return this.typeConverter;
        }

        public Object getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core() {
            return this.isFinished$delegate.getValue().booleanValue();
        }

        public final void onPlayTimeChanged$animation_core(long arg1, boolean arg3) {
            if(arg3) {
                arg1 = this.getAnimation().getDurationNanos();
            }

            this.setValue$animation_core(this.getAnimation().getValueFromNanos(arg1));
            this.velocityVector = this.getAnimation().getVelocityVectorFromNanos(arg1);
            if(this.getAnimation().isFinishedFromNanos(arg1)) {
                this.setFinished$animation_core(true);
            }
        }

        public final void resetAnimation$animation_core() {
            this.setResetSnapValue$animation_core(-2f);
        }

        public final void resetAnimationValue$animation_core(float arg3) {
            int v0 = Float.compare(arg3, -4f);
            if(v0 == 0) {
            }
            else {
                if(arg3 == -5f) {
                    goto label_6;
                }

                goto label_29;
            }

        label_6:
            TargetBasedAnimation v3 = this.initialValueAnimation;
            if(v3 != null) {
                this.getAnimation().setMutableInitialValue$animation_core(v3.getTargetValue());
                this.initialValueState = null;
                this.initialValueAnimation = null;
            }

            Object v3_1 = v0 == 0 ? this.getAnimation().getInitialValue() : this.getAnimation().getTargetValue();
            this.getAnimation().setMutableInitialValue$animation_core(v3_1);
            this.getAnimation().setMutableTargetValue$animation_core(v3_1);
            this.setValue$animation_core(v3_1);
            this.setDurationNanos$animation_core(this.getAnimation().getDurationNanos());
            return;
        label_29:
            this.setResetSnapValue$animation_core(arg3);
        }

        public final void seekTo$animation_core(long arg3) {
            if(this.getResetSnapValue$animation_core() == -1f) {
                this.isSeeking = true;
                if(Intrinsics.areEqual(this.getAnimation().getTargetValue(), this.getAnimation().getInitialValue())) {
                    this.setValue$animation_core(this.getAnimation().getTargetValue());
                    return;
                }
                else {
                    this.setValue$animation_core(this.getAnimation().getValueFromNanos(arg3));
                    this.velocityVector = this.getAnimation().getVelocityVectorFromNanos(arg3);
                }
            }
        }

        private final void setAnimation(TargetBasedAnimation arg1) {
            this.animation$delegate.setValue(arg1);
        }

        private final void setAnimationSpec(FiniteAnimationSpec arg1) {
            this.animationSpec$delegate.setValue(arg1);
        }

        public final void setDurationNanos$animation_core(long arg1) {
            this.durationNanos$delegate.setLongValue(arg1);
        }

        public final void setFinished$animation_core(boolean arg1) {
            this.isFinished$delegate.setValue(Boolean.valueOf(arg1));
        }

        public final void setInitialValueAnimation$animation_core(SeekingAnimationState arg8) {
            if(!Intrinsics.areEqual(this.getAnimation().getTargetValue(), this.getAnimation().getInitialValue())) {
                this.initialValueAnimation = this.getAnimation();
                this.initialValueState = arg8;
            }

            this.setAnimation(new TargetBasedAnimation(this.interruptionSpec, this.typeConverter, this.getValue(), this.getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            this.setDurationNanos$animation_core(this.getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        public final void setInitialValueState$animation_core(SeekingAnimationState arg1) {
            this.initialValueState = arg1;
        }

        public final void setResetSnapValue$animation_core(float arg1) {
            this.resetSnapValue$delegate.setFloatValue(arg1);
        }

        private final void setTargetValue(Object arg1) {
            this.targetValue$delegate.setValue(arg1);
        }

        public void setValue$animation_core(Object arg1) {
            this.value$delegate.setValue(arg1);
        }

        public String toString() {
            return "current value: " + this.getValue() + ", target: " + this.getTargetValue() + ", spec: " + this.getAnimationSpec();
        }

        private final void updateAnimation(Object arg8, boolean arg9) {
            FiniteAnimationSpec v8;
            TargetBasedAnimation v0 = this.initialValueAnimation;
            Object v0_1 = v0 != null ? v0.getTargetValue() : null;
            if(Intrinsics.areEqual(v0_1, this.getTargetValue())) {
                this.setAnimation(new TargetBasedAnimation(this.interruptionSpec, this.typeConverter, arg8, arg8, AnimationVectorsKt.newInstance(this.velocityVector)));
                this.useOnlyInitialValue = true;
                this.setDurationNanos$animation_core(this.getAnimation().getDurationNanos());
                return;
            }

            Object v3 = arg8;
            if(!arg9 || (this.isSeeking)) {
                v8 = this.getAnimationSpec();
            }
            else if((this.getAnimationSpec() instanceof SpringSpec)) {
                v8 = this.getAnimationSpec();
            }
            else {
                v8 = this.interruptionSpec;
            }

            if(Transition.this.getPlayTimeNanos() <= 0) {
            }
            else {
                AnimationSpec v8_1 = AnimationSpecKt.delayed(((AnimationSpec)v8), Transition.this.getPlayTimeNanos());
            }

            this.setAnimation(new TargetBasedAnimation(v8, this.typeConverter, v3, this.getTargetValue(), this.velocityVector));
            this.setDurationNanos$animation_core(this.getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.this.onChildAnimationUpdated();
        }

        static void updateAnimation$default(TransitionAnimationState arg0, Object arg1, boolean arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.getValue();
            }

            arg0.updateAnimation(arg1, false);
        }

        public final void updateInitialAndTargetValue$animation_core(Object arg2, Object arg3, FiniteAnimationSpec arg4) {
            this.setTargetValue(arg3);
            this.setAnimationSpec(arg4);
            if((Intrinsics.areEqual(this.getAnimation().getInitialValue(), arg2)) && (Intrinsics.areEqual(this.getAnimation().getTargetValue(), arg3))) {
                return;
            }

            TransitionAnimationState.updateAnimation$default(this, arg2, false, 2, null);
        }

        public final void updateInitialValue$animation_core() {
            TargetBasedAnimation v1;
            SeekingAnimationState v0 = this.initialValueState;
            if(v0 == null) {
            }
            else {
                v1 = this.initialValueAnimation;
                if(v1 == null) {
                    return;
                }

                goto label_6;
            }

            return;
        label_6:
            long v2 = MathKt.roundToLong((((double)v0.getDurationNanos())) * (((double)v0.getValue())));
            Object v1_1 = v1.getValueFromNanos(v2);
            if(this.useOnlyInitialValue) {
                this.getAnimation().setMutableTargetValue$animation_core(v1_1);
            }

            this.getAnimation().setMutableInitialValue$animation_core(v1_1);
            this.setDurationNanos$animation_core(this.getAnimation().getDurationNanos());
            if(this.getResetSnapValue$animation_core() == -2f || (this.useOnlyInitialValue)) {
                this.setValue$animation_core(v1_1);
            }
            else {
                this.seekTo$animation_core(Transition.this.getPlayTimeNanos());
            }

            if(v2 >= v0.getDurationNanos()) {
                this.initialValueState = null;
                this.initialValueAnimation = null;
                return;
            }

            v0.setComplete(false);
        }

        public final void updateTargetValue$animation_core(Object arg5, FiniteAnimationSpec arg6) {
            if(this.useOnlyInitialValue) {
                TargetBasedAnimation v0 = this.initialValueAnimation;
                Object v0_1 = v0 != null ? v0.getTargetValue() : null;
                if(!Intrinsics.areEqual(arg5, v0_1)) {
                    goto label_10;
                }

                return;
            }

        label_10:
            float v1 = -1f;
            if((Intrinsics.areEqual(this.getTargetValue(), arg5)) && this.getResetSnapValue$animation_core() == v1) {
                return;
            }

            this.setTargetValue(arg5);
            this.setAnimationSpec(arg6);
            float v0_2 = -3f;
            Object v6 = this.getResetSnapValue$animation_core() == v0_2 ? arg5 : this.getValue();
            boolean v3 = true;
            this.updateAnimation(v6, this.isFinished$animation_core() ^ 1);
            if(Float.compare(this.getResetSnapValue$animation_core(), v0_2) == 0) {
            }
            else {
                v3 = false;
            }

            this.setFinished$animation_core(v3);
            if(this.getResetSnapValue$animation_core() >= 0f) {
                this.setValue$animation_core(this.getAnimation().getValueFromNanos(((long)((((float)this.getAnimation().getDurationNanos())) * this.getResetSnapValue$animation_core()))));
            }
            else if(this.getResetSnapValue$animation_core() == v0_2) {
                this.setValue$animation_core(arg5);
            }

            this.useOnlyInitialValue = false;
            this.setResetSnapValue$animation_core(v1);
        }
    }

    public static final int $stable;
    private final SnapshotStateList _animations;
    private final MutableLongState _playTimeNanos$delegate;
    private final SnapshotStateList _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final Transition parentTransition;
    private final MutableState segment$delegate;
    private final MutableLongState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final TransitionState transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    public static DisposableEffectResult $r8$lambda$GNrO9fJ7e9hIv-noDOuyhkXA7A0(CoroutineScope arg0, Transition arg1, DisposableEffectScope arg2) {
        return Transition.animateTo$lambda$2$0(arg0, arg1, arg2);
    }

    public static boolean $r8$lambda$_q6HiU1jXdrS5TVWgd8_blhENNo(Transition arg0) {
        return Transition.animateTo$lambda$0$0(arg0);
    }

    static {
    }

    public Transition(MutableTransitionState arg2, String arg3) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
        this(((TransitionState)arg2), null, arg3);
    }

    public Transition(TransitionState arg4, Transition arg5, String arg6) {
        super();
        this.transitionState = arg4;
        this.parentTransition = arg5;
        this.label = arg6;
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(this.getCurrentState(), null, 2, null);
        this.segment$delegate = SnapshotStateKt.mutableStateOf$default(new SegmentImpl(this.getCurrentState(), this.getCurrentState()), null, 2, null);
        this._playTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0);
        this.startTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(-9223372036854775808L);
        Boolean v5 = Boolean.valueOf(false);
        this.updateChildrenNeeded$delegate = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new Transition$$ExternalSyntheticLambda3(this));
        arg4.transitionConfigured$animation_core(this);
    }

    public Transition(MutableTransitionState arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public Transition(TransitionState arg1, Transition arg2, String arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public Transition(TransitionState arg2, String arg3) {
        this(arg2, null, arg3);
    }

    public Transition(TransitionState arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public Transition(Object arg2, String arg3) {
        this(new MutableTransitionState(arg2), null, arg3);
    }

    public static final void access$onChildAnimationUpdated(Transition arg0) {
        arg0.onChildAnimationUpdated();
    }

    public final boolean addAnimation$animation_core(TransitionAnimationState arg1) {
        return this._animations.add(arg1);
    }

    public final boolean addTransition$animation_core(Transition arg1) {
        return this._transitions.add(arg1);
    }

    public final void animateTo$animation_core(Object arg9, Composer arg10, int arg11) {
        int v2;
        int v1_1;
        int v0 = 0xA6F9B301;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(animateTo)N(targetState):Transition.kt#pdpnli");
        if((arg11 & 6) == 0) {
            boolean v1 = (arg11 & 8) == 0 ? arg10.changed(arg9) : arg10.changedInstance(arg9);
            v1_1 = v1 ? 4 : 2;
            v1_1 |= arg11;
        }
        else {
            v1_1 = arg11;
        }

        int v3 = 0x20;
        if((arg11 & 0x30) == 0) {
            v2 = arg10.changed(this) ? v3 : 16;
            v1_1 |= v2;
        }

        int v5 = 0;
        boolean v2_1 = (v1_1 & 19) != 18 ? true : false;
        if(arg10.shouldExecute(v2_1, v1_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1180)");
            }

            v2 = 0x18D14D41;
            if(!this.isSeeking()) {
                arg10.startReplaceGroup(466062241);
                ComposerKt.sourceInformation(arg10, "1186@50245L187");
                this.updateTarget$animation_core(arg9);
                String v4 = "CC(remember):Transition.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(arg10, 0xCF59185C, v4);
                v0 = v1_1 & 0x70;
                v1_1 = v0 == v3 ? 1 : 0;
                Object v7 = arg10.rememberedValue();
                if(v1_1 != 0 || v7 == Composer.Companion.getEmpty()) {
                    State v7_1 = SnapshotStateKt.derivedStateOf(new Transition$$ExternalSyntheticLambda0(this));
                    arg10.updateRememberedValue(v7_1);
                }

                ComposerKt.sourceInformationMarkerEnd(arg10);
                if(Transition.animateTo$lambda$1(((State)v7))) {
                    arg10.startReplaceGroup(466470356);
                    ComposerKt.sourceInformation(arg10, "1194@50651L24,1195@50731L1011,1195@50692L1050");
                    ComposerKt.sourceInformationMarkerStart(arg10, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(arg10, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
                    Object v1_2 = arg10.rememberedValue();
                    if(v1_2 == Composer.Companion.getEmpty()) {
                        CoroutineScope v1_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, arg10);
                        arg10.updateRememberedValue(v1_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(arg10);
                    ComposerKt.sourceInformationMarkerEnd(arg10);
                    ComposerKt.sourceInformationMarkerStart(arg10, 0xCF595854, v4);
                    v2_1 = arg10.changedInstance(v1_2);
                    if(v0 == v3) {
                        v5 = 1;
                    }

                    Object v3_1 = arg10.rememberedValue();
                    if(((((int)v2_1)) | v5) != 0 || v3_1 == Composer.Companion.getEmpty()) {
                        Transition$$ExternalSyntheticLambda1 v3_2 = new Transition$$ExternalSyntheticLambda1(((CoroutineScope)v1_2), this);
                        arg10.updateRememberedValue(v3_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(arg10);
                    EffectsKt.DisposableEffect(v1_2, this, ((Function1)v3_1), arg10, v0);
                }
                else {
                    arg10.startReplaceGroup(v2);
                }

                arg10.endReplaceGroup();
            }
            else {
                arg10.startReplaceGroup(v2);
            }

            arg10.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_117;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_117:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new Transition$$ExternalSyntheticLambda2(this, arg9, arg11));
        }
    }

    private static final boolean animateTo$lambda$0$0(Transition arg2) {
        if((Intrinsics.areEqual(arg2.getTargetState(), arg2.getCurrentState())) && !arg2.isRunning()) {
            if(arg2.getUpdateChildrenNeeded()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean animateTo$lambda$1(State arg0) {
        return arg0.getValue().booleanValue();
    }

    private static final DisposableEffectResult animateTo$lambda$2$0(CoroutineScope arg6, Transition arg7, DisposableEffectScope arg8) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new Transition$animateTo$1$1$1(arg7, null), 1, null);
        return new Transition$animateTo$lambda$2$0$$inlined$onDispose$1();
    }

    static final Unit animateTo$lambda$3(Transition arg0, Object arg1, int arg2, Composer arg3, int arg4) {
        arg0.animateTo$animation_core(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private final long calculateTotalDurationNanos() {
        SnapshotStateList v0 = this._animations;
        int v1 = v0.size();
        long v2 = 0;
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v1; ++v5) {
            v2 = Math.max(v2, ((List)v0).get(v5).getDurationNanos$animation_core());
        }

        SnapshotStateList v8 = this._transitions;
        int v0_1 = v8.size();
        while(v4 < v0_1) {
            v2 = Math.max(v2, ((List)v8).get(v4).calculateTotalDurationNanos());
            ++v4;
        }

        return v2;
    }

    public final void clearInitialAnimations$animation_core() {
        SnapshotStateList v0 = this._animations;
        int v1 = v0.size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((List)v0).get(v3).clearInitialAnimation$animation_core();
        }

        SnapshotStateList v5 = this._transitions;
        int v0_1 = v5.size();
        while(v2 < v0_1) {
            ((List)v5).get(v2).clearInitialAnimations$animation_core();
            ++v2;
        }
    }

    public final List getAnimations() {
        return this._animations;
    }

    public final Object getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList v0 = this._animations;
        int v1 = v0.size();
        int v3 = 0;
        while(true) {
            if(v3 >= v1) {
                break;
            }
            else if(((List)v0).get(v3).getInitialValueState$animation_core() != null) {
            }
            else {
                ++v3;
                continue;
            }

            return 1;
        }

        SnapshotStateList v5 = this._transitions;
        int v0_1 = v5.size();
        v1 = 0;
        while(true) {
            if(v1 >= v0_1) {
                return 0;
            }
            else if(!((List)v5).get(v1).getHasInitialValueAnimations()) {
                ++v1;
                continue;
            }

            return 1;
        }

        return 0;
    }

    public static void getHasInitialValueAnimations$annotations() {
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core() {
        return this.lastSeekedTimeNanos;
    }

    public final Transition getParentTransition() {
        return this.parentTransition;
    }

    public final long getPlayTimeNanos() {
        Transition v0 = this.parentTransition;
        if(v0 != null) {
            return v0.getPlayTimeNanos();
        }

        return this.get_playTimeNanos();
    }

    public final Segment getSegment() {
        return this.segment$delegate.getValue();
    }

    public final long getStartTimeNanos$animation_core() {
        return this.startTimeNanos$delegate.getLongValue();
    }

    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        return this.totalDurationNanos$delegate.getValue().longValue();
    }

    public final List getTransitions() {
        return this._transitions;
    }

    private final boolean getUpdateChildrenNeeded() {
        return this.updateChildrenNeeded$delegate.getValue().booleanValue();
    }

    private final long get_playTimeNanos() {
        return this._playTimeNanos$delegate.getLongValue();
    }

    public final boolean isRunning() {
        if(this.getStartTimeNanos$animation_core() != -9223372036854775808L) {
            return 1;
        }

        return 0;
    }

    public final boolean isSeeking() {
        return this.isSeeking$delegate.getValue().booleanValue();
    }

    private final void onChildAnimationUpdated() {
        this.setUpdateChildrenNeeded(true);
        if(this.isSeeking()) {
            SnapshotStateList v0 = this._animations;
            int v1 = v0.size();
            long v3 = 0;
            int v5;
            for(v5 = 0; v5 < v1; ++v5) {
                Object v6 = ((List)v0).get(v5);
                v3 = Math.max(v3, ((TransitionAnimationState)v6).getDurationNanos$animation_core());
                ((TransitionAnimationState)v6).seekTo$animation_core(this.lastSeekedTimeNanos);
            }

            this.setUpdateChildrenNeeded(false);
        }
    }

    public final void onDisposed$animation_core() {
        this.onTransitionEnd$animation_core();
        this.transitionState.transitionRemoved$animation_core();
    }

    public final void onFrame$animation_core(long arg5, float arg7) {
        if(this.getStartTimeNanos$animation_core() == -9223372036854775808L) {
            this.onTransitionStart$animation_core(arg5);
        }

        arg5 -= this.getStartTimeNanos$animation_core();
        int v0 = Float.compare(arg7, 0f);
        if(v0 == 0) {
        }
        else {
            arg5 = MathKt.roundToLong((((double)arg5)) / (((double)arg7)));
        }

        this.setPlayTimeNanos(arg5);
        boolean v7 = v0 == 0 ? true : false;
        this.onFrame$animation_core(arg5, v7);
    }

    public final void onFrame$animation_core(long arg9, boolean arg11) {
        Object v5;
        int v1 = 1;
        if(Long.compare(this.getStartTimeNanos$animation_core(), -9223372036854775808L) == 0) {
            this.onTransitionStart$animation_core(arg9);
        }
        else if(!this.transitionState.isRunning$animation_core()) {
            this.transitionState.setRunning$animation_core(true);
        }

        this.setUpdateChildrenNeeded(false);
        SnapshotStateList v2 = this._animations;
        int v3 = v2.size();
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            v5 = ((List)v2).get(v4);
            if(!((TransitionAnimationState)v5).isFinished$animation_core()) {
                ((TransitionAnimationState)v5).onPlayTimeChanged$animation_core(arg9, arg11);
            }

            if(!((TransitionAnimationState)v5).isFinished$animation_core()) {
                v1 = 0;
            }
        }

        v2 = this._transitions;
        v3 = v2.size();
        for(v4 = 0; v4 < v3; ++v4) {
            v5 = ((List)v2).get(v4);
            if(!Intrinsics.areEqual(((Transition)v5).getTargetState(), ((Transition)v5).getCurrentState())) {
                ((Transition)v5).onFrame$animation_core(arg9, arg11);
            }

            if(!Intrinsics.areEqual(((Transition)v5).getTargetState(), ((Transition)v5).getCurrentState())) {
                v1 = 0;
            }
        }

        if(v1 != 0) {
            this.onTransitionEnd$animation_core();
        }
    }

    public final void onTransitionEnd$animation_core() {
        this.setStartTimeNanos$animation_core(-9223372036854775808L);
        TransitionState v0 = this.transitionState;
        if((v0 instanceof MutableTransitionState)) {
            ((MutableTransitionState)v0).setCurrentState$animation_core(this.getTargetState());
        }

        this.setPlayTimeNanos(0);
        int v1 = 0;
        this.transitionState.setRunning$animation_core(false);
        SnapshotStateList v3 = this._transitions;
        int v0_1 = v3.size();
        while(v1 < v0_1) {
            ((List)v3).get(v1).onTransitionEnd$animation_core();
            ++v1;
        }
    }

    public final void onTransitionStart$animation_core(long arg1) {
        this.setStartTimeNanos$animation_core(arg1);
        this.transitionState.setRunning$animation_core(true);
    }

    public final void removeAnimation$animation_core(DeferredAnimation arg1) {
        DeferredAnimationData v1 = arg1.getData$animation_core();
        if(v1 != null) {
            TransitionAnimationState v1_1 = v1.getAnimation();
            if(v1_1 != null) {
                this.removeAnimation$animation_core(v1_1);
            }
        }
    }

    public final void removeAnimation$animation_core(TransitionAnimationState arg1) {
        this._animations.remove(arg1);
    }

    public final boolean removeTransition$animation_core(Transition arg1) {
        return this._transitions.remove(arg1);
    }

    public final void resetAnimationFraction$animation_core(float arg6) {
        SnapshotStateList v0 = this._animations;
        int v1 = v0.size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((List)v0).get(v3).resetAnimationValue$animation_core(arg6);
        }

        SnapshotStateList v5 = this._transitions;
        int v0_1 = v5.size();
        while(v2 < v0_1) {
            ((List)v5).get(v2).resetAnimationFraction$animation_core(arg6);
            ++v2;
        }
    }

    public final void seek(Object arg6, Object arg7, long arg8) {
        this.setStartTimeNanos$animation_core(-9223372036854775808L);
        int v1 = 0;
        this.transitionState.setRunning$animation_core(false);
        if(!this.isSeeking() || !Intrinsics.areEqual(this.getCurrentState(), arg6) || !Intrinsics.areEqual(this.getTargetState(), arg7)) {
            if(!Intrinsics.areEqual(this.getCurrentState(), arg6)) {
                TransitionState v0 = this.transitionState;
                if((v0 instanceof MutableTransitionState)) {
                    ((MutableTransitionState)v0).setCurrentState$animation_core(arg6);
                }
            }

            this.setTargetState$animation_core(arg7);
            this.setSeeking$animation_core(true);
            this.setSegment(new SegmentImpl(arg6, arg7));
        }

        SnapshotStateList v6 = this._transitions;
        int v7 = v6.size();
        int v0_1;
        for(v0_1 = 0; v0_1 < v7; ++v0_1) {
            Object v2 = ((List)v6).get(v0_1);
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if(((Transition)v2).isSeeking()) {
                ((Transition)v2).seek(((Transition)v2).getCurrentState(), ((Transition)v2).getTargetState(), arg8);
            }
        }

        v6 = this._animations;
        v7 = v6.size();
        while(v1 < v7) {
            ((List)v6).get(v1).seekTo$animation_core(arg8);
            ++v1;
        }

        this.lastSeekedTimeNanos = arg8;
    }

    public final void seekAnimations$animation_core(long arg6) {
        if(this.getStartTimeNanos$animation_core() == -9223372036854775808L) {
            this.setStartTimeNanos$animation_core(arg6);
        }

        this.setPlayTimeNanos(arg6);
        int v0 = 0;
        this.setUpdateChildrenNeeded(false);
        SnapshotStateList v1 = this._animations;
        int v2 = v1.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            ((List)v1).get(v3).seekTo$animation_core(arg6);
        }

        SnapshotStateList v5 = this._transitions;
        int v1_1 = v5.size();
        while(v0 < v1_1) {
            Object v2_1 = ((List)v5).get(v0);
            if(!Intrinsics.areEqual(((Transition)v2_1).getTargetState(), ((Transition)v2_1).getCurrentState())) {
                ((Transition)v2_1).seekAnimations$animation_core(arg6);
            }

            ++v0;
        }
    }

    public final void setInitialAnimations$animation_core(SeekingAnimationState arg6) {
        SnapshotStateList v0 = this._animations;
        int v1 = v0.size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((List)v0).get(v3).setInitialValueAnimation$animation_core(arg6);
        }

        SnapshotStateList v5 = this._transitions;
        int v0_1 = v5.size();
        while(v2 < v0_1) {
            ((List)v5).get(v2).setInitialAnimations$animation_core(arg6);
            ++v2;
        }
    }

    public final void setLastSeekedTimeNanos$animation_core(long arg1) {
        this.lastSeekedTimeNanos = arg1;
    }

    public final void setPlayTimeNanos(long arg2) {
        if(this.parentTransition == null) {
            this.set_playTimeNanos(arg2);
        }
    }

    public final void setSeeking$animation_core(boolean arg1) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setSegment(Segment arg1) {
        this.segment$delegate.setValue(arg1);
    }

    public final void setStartTimeNanos$animation_core(long arg1) {
        this.startTimeNanos$delegate.setLongValue(arg1);
    }

    public final void setTargetState$animation_core(Object arg1) {
        this.targetState$delegate.setValue(arg1);
    }

    private final void setUpdateChildrenNeeded(boolean arg1) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void set_playTimeNanos(long arg1) {
        this._playTimeNanos$delegate.setLongValue(arg1);
    }

    public String toString() {
        List v5 = this.getAnimations();
        int v0 = v5.size();
        String v1 = "Transition animation values: ";
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1 = v1 + v5.get(v2) + ", ";
        }

        return v1;
    }

    static final long totalDurationNanos_delegate$lambda$0(Transition arg2) {
        return arg2.calculateTotalDurationNanos();
    }

    public final void updateInitialValues$animation_core() {
        SnapshotStateList v0 = this._animations;
        int v1 = v0.size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((List)v0).get(v3).updateInitialValue$animation_core();
        }

        SnapshotStateList v5 = this._transitions;
        int v0_1 = v5.size();
        while(v2 < v0_1) {
            ((List)v5).get(v2).updateInitialValues$animation_core();
            ++v2;
        }
    }

    public final void updateTarget$animation_core(Object arg3) {
        if(!Intrinsics.areEqual(this.getTargetState(), arg3)) {
            this.setSegment(new SegmentImpl(this.getTargetState(), arg3));
            if(!Intrinsics.areEqual(this.getCurrentState(), this.getTargetState())) {
                this.transitionState.setCurrentState$animation_core(this.getTargetState());
            }

            this.setTargetState$animation_core(arg3);
            if(!this.isRunning()) {
                this.setUpdateChildrenNeeded(true);
            }

            SnapshotStateList v2 = this._animations;
            int v3 = v2.size();
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                ((List)v2).get(v0).resetAnimation$animation_core();
            }
        }
    }
}

