package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001m\b\u0007\u0018\u0000 \u0081\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0081\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u001F\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0004\u0010\bB4\b\u0017\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012!\u0010\t\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E0\n¢\u0006\u0004\b\u0004\u0010\u000FBD\b\u0017\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\b\u0002\u0010\t\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E0\n¢\u0006\u0004\b\u0004\u0010\u0010J\b\u0010L\u001A\u00020\u0016H\u0007J\u001D\u0010N\u001A\u00020\u00162\u0006\u0010O\u001A\u00028\u00002\u0006\u0010P\u001A\u00028\u0000H\u0007¢\u0006\u0002\u0010QJ#\u0010b\u001A\u00020c2\f\u0010d\u001A\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010e\u001A\u00028\u0000¢\u0006\u0002\u0010fJ\u001C\u0010g\u001A\u00020c2\f\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00160!H\u0086@¢\u0006\u0002\u0010iJ\u0016\u0010g\u001A\u00020\u00162\u0006\u0010j\u001A\u00020\u0016H\u0087@¢\u0006\u0002\u0010kJ\\\u0010o\u001A\u00020c2\b\b\u0002\u0010p\u001A\u00020q2B\u0010r\u001A>\b\u0001\u0012\u0004\u0012\u00020t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0u\u0012\u0006\u0012\u0004\u0018\u00010\u00020s¢\u0006\u0002\bvH\u0086@¢\u0006\u0002\u0010wJy\u0010o\u001A\u00020c2\u0006\u0010A\u001A\u00028\u00002\b\b\u0002\u0010p\u001A\u00020q2W\u0010r\u001AS\b\u0001\u0012\u0004\u0012\u00020t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(y\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(A\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0u\u0012\u0006\u0012\u0004\u0018\u00010\u00020x¢\u0006\u0002\bvH\u0086@¢\u0006\u0002\u0010zJ\u0015\u0010{\u001A\u00020\u00162\u0006\u0010|\u001A\u00020\u0016H\u0000¢\u0006\u0002\b}J\u000E\u0010~\u001A\u00020\u00162\u0006\u0010|\u001A\u00020\u0016J\u0016\u0010\u007F\u001A\u00020\u000E2\u0006\u0010A\u001A\u00028\u0000H\u0002¢\u0006\u0003\u0010\u0080\u0001R5\u0010\t\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E0\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R5\u0010\u0015\u001A\u001D\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00160\nX\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R \u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00160\u001BX\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR8\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00160!2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00160!8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010$\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R8\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00160)2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00160)8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010$\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001A\u00100\u001A\u00020\u000E8@X\u0080\u0004¢\u0006\f\u0012\u0004\b1\u0010$\u001A\u0004\b2\u00103R\u000E\u00104\u001A\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00107\u001A\u00028\u00002\u0006\u00106\u001A\u00028\u00008F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b8\u00109\"\u0004\b:\u0010\u0005R+\u0010=\u001A\u00028\u00002\u0006\u00106\u001A\u00028\u00008F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b@\u0010<\u001A\u0004\b>\u00109\"\u0004\b?\u0010\u0005R\u001B\u0010A\u001A\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001A\u0004\bB\u00109R+\u0010E\u001A\u00020\u00162\u0006\u00106\u001A\u00020\u00168G@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0011\u0010M\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\bM\u00103R!\u0010N\u001A\u00020\u00168GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bT\u0010D\u0012\u0004\bR\u0010$\u001A\u0004\bS\u0010GR+\u0010U\u001A\u00020\u00162\u0006\u00106\u001A\u00020\u00168F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bX\u0010K\u001A\u0004\bV\u0010G\"\u0004\bW\u0010IR/\u0010Y\u001A\u0004\u0018\u00018\u00002\b\u00106\u001A\u0004\u0018\u00018\u00008B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\\\u0010<\u001A\u0004\bZ\u00109\"\u0004\b[\u0010\u0005R7\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u00106\u001A\b\u0012\u0004\u0012\u00028\u00000\u00078F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\ba\u0010<\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0010\u0010l\u001A\u00020mX\u0082\u0004¢\u0006\u0004\n\u0002\u0010n¨\u0006\u0082\u0001"}, d2={"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;)V", "getConfirmValueChange$foundation", "()Lkotlin/jvm/functions/Function1;", "setConfirmValueChange$foundation", "(Lkotlin/jvm/functions/Function1;)V", "positionalThreshold", "", "totalDistance", "getPositionalThreshold$foundation", "setPositionalThreshold$foundation", "velocityThreshold", "Lkotlin/Function0;", "getVelocityThreshold$foundation", "()Lkotlin/jvm/functions/Function0;", "setVelocityThreshold$foundation", "(Lkotlin/jvm/functions/Function0;)V", "value", "Landroidx/compose/animation/core/AnimationSpec;", "snapAnimationSpec", "getSnapAnimationSpec$annotations", "()V", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setSnapAnimationSpec$foundation", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", "getDecayAnimationSpec$annotations", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setDecayAnimationSpec$foundation", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "usePreModifierChangeBehavior", "getUsePreModifierChangeBehavior$foundation$annotations", "getUsePreModifierChangeBehavior$foundation", "()Z", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "progress", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "getProgress$annotations", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "settle", "animationSpec", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "anchor", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$foundation", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnchoredDraggableState {
    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u0001J:\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u0014\b\u0002\u0010\b\u001A\u000E\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007J\u0087\u0001\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u000F2!\u0010\u0010\u001A\u001D\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\r0\u00152\u0014\b\u0002\u0010\b\u001A\u000E\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "confirmValueChange", "Lkotlin/Function1;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.") public final Saver Saver(AnimationSpec arg7, DecayAnimationSpec arg8, Function1 arg9, Function0 arg10, Function1 arg11) {
            return SaverKt.Saver(new AnchoredDraggableState$Companion$$ExternalSyntheticLambda0(), new AnchoredDraggableState$Companion$$ExternalSyntheticLambda1(arg9, arg10, arg7, arg8, arg11));
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.") public final Saver Saver(Function1 arg2) {
            return SaverKt.Saver(new AnchoredDraggableState$Companion$$ExternalSyntheticLambda3(), new AnchoredDraggableState$Companion$$ExternalSyntheticLambda4(arg2));
        }

        public final Saver Saver() {
            return SaverKt.Saver(new AnchoredDraggableState$Companion$$ExternalSyntheticLambda6(), new AnchoredDraggableState$Companion$$ExternalSyntheticLambda7());
        }

        public static Saver Saver$default(Companion arg6, AnimationSpec arg7, DecayAnimationSpec arg8, Function1 arg9, Function0 arg10, Function1 arg11, int arg12, Object arg13) {
            AnchoredDraggableState$Companion$$ExternalSyntheticLambda5 v11;
            if((arg12 & 16) != 0) {
                v11 = new AnchoredDraggableState$Companion$$ExternalSyntheticLambda5();
            }

            return arg6.Saver(arg7, arg8, arg9, arg10, ((Function1)v11));
        }

        public static Saver Saver$default(Companion arg0, Function1 arg1, int arg2, Object arg3) {
            AnchoredDraggableState$Companion$$ExternalSyntheticLambda2 v1;
            if((arg2 & 1) != 0) {
                v1 = new AnchoredDraggableState$Companion$$ExternalSyntheticLambda2();
            }

            return arg0.Saver(((Function1)v1));
        }

        static final Object Saver$lambda$0(SaverScope arg0, AnchoredDraggableState arg1) {
            return arg1.getCurrentValue();
        }

        static final AnchoredDraggableState Saver$lambda$1(Object arg1) {
            return new AnchoredDraggableState(arg1);
        }

        static final boolean Saver$lambda$2(Object arg0) {
            return 1;
        }

        static final Object Saver$lambda$3(SaverScope arg0, AnchoredDraggableState arg1) {
            return arg1.getCurrentValue();
        }

        static final AnchoredDraggableState Saver$lambda$4(Function1 arg1, Object arg2) {
            return new AnchoredDraggableState(arg2, arg1);
        }

        static final boolean Saver$lambda$5(Object arg0) {
            return 1;
        }

        static final Object Saver$lambda$6(SaverScope arg0, AnchoredDraggableState arg1) {
            return arg1.getCurrentValue();
        }

        static final AnchoredDraggableState Saver$lambda$7(Function1 arg1, Function0 arg2, AnimationSpec arg3, DecayAnimationSpec arg4, Function1 arg5, Object arg6) {
            return AnchoredDraggableKt.AnchoredDraggableState(arg6, arg1, arg2, arg3, arg4, arg5);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;
    private final MutableState anchors$delegate;
    private Function1 confirmValueChange;
    private final MutableState currentValue$delegate;
    public DecayAnimationSpec decayAnimationSpec;
    private final MutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    public Function1 positionalThreshold;
    private final State progress$delegate;
    private final MutableState settledValue$delegate;
    public AnimationSpec snapAnimationSpec;
    private final State targetValue$delegate;
    public Function0 velocityThreshold;

    static {
        AnchoredDraggableState.Companion = new Companion(null);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.") public AnchoredDraggableState(Object arg1, DraggableAnchors arg2, Function1 arg3) {
        this(arg1, arg3);
        this.setAnchors(arg2);
        this.trySnapTo(arg1);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.") public AnchoredDraggableState(Object arg1, Function1 arg2) {
        this(arg1);
        this.confirmValueChange = arg2;
    }

    public AnchoredDraggableState(Object arg4) {
        super();
        this.confirmValueChange = new AnchoredDraggableState$$ExternalSyntheticLambda0();
        this.dragMutex = new MutatorMutex();
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.settledValue$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$$ExternalSyntheticLambda1(this));
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(NaNf);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new AnchoredDraggableState$$ExternalSyntheticLambda2(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public AnchoredDraggableState(Object arg1, DraggableAnchors arg2) {
        this(arg1);
        this.setAnchors(arg2);
        this.trySnapTo(arg1);
    }

    public AnchoredDraggableState(Object arg1, DraggableAnchors arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        AnchoredDraggableState$$ExternalSyntheticLambda3 v3;
        if((arg4 & 4) != 0) {
            v3 = new AnchoredDraggableState$$ExternalSyntheticLambda3();
        }

        this(arg1, arg2, ((Function1)v3));
    }

    static final boolean _init_$lambda$0(Object arg0) {
        return 1;
    }

    public static final AnchoredDraggableState$anchoredDragScope$1 access$getAnchoredDragScope$p(AnchoredDraggableState arg0) {
        return arg0.anchoredDragScope;
    }

    public static final void access$setCurrentValue(AnchoredDraggableState arg0, Object arg1) {
        arg0.setCurrentValue(arg1);
    }

    public static final void access$setDragTarget(AnchoredDraggableState arg0, Object arg1) {
        arg0.setDragTarget(arg1);
    }

    public static final void access$setLastVelocity(AnchoredDraggableState arg0, float arg1) {
        arg0.setLastVelocity(arg1);
    }

    public static final void access$setOffset(AnchoredDraggableState arg0, float arg1) {
        arg0.setOffset(arg1);
    }

    public static final void access$setSettledValue(AnchoredDraggableState arg0, Object arg1) {
        arg0.setSettledValue(arg1);
    }

    public final Object anchoredDrag(MutatePriority arg4, Function3 arg5, Continuation arg6) {
        Object v3 = this.dragMutex.mutate(arg4, new AnchoredDraggableState$anchoredDrag$2(this, arg5, null), arg6);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public final Object anchoredDrag(Object arg6, MutatePriority arg7, Function4 arg8, Continuation arg9) {
        int v2;
        Continuation v0;
        if((arg9 instanceof AnchoredDraggableState$anchoredDrag$3)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((AnchoredDraggableState$anchoredDrag$3)v0).label & v2) != 0) {
                ((AnchoredDraggableState$anchoredDrag$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AnchoredDraggableState$anchoredDrag$3 v0_1 = new AnchoredDraggableState$anchoredDrag$3(this, arg9);
        }

        Object v9 = ((AnchoredDraggableState$anchoredDrag$3)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AnchoredDraggableState$anchoredDrag$3)v0).label;
        Continuation v4 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            if(this.getAnchors().hasPositionFor(arg6)) {
                try {
                    MutatorMutex v9_1 = this.dragMutex;
                    AnchoredDraggableState$anchoredDrag$4 v2_1 = new AnchoredDraggableState$anchoredDrag$4(this, arg6, arg8, v4);
                    ((AnchoredDraggableState$anchoredDrag$3)v0).label = 1;
                    if(v9_1.mutate(arg7, ((Function1)v2_1), v0) != v1) {
                        goto label_39;
                    }
                }
                catch(Throwable v6) {
                label_41:
                    this.setDragTarget(v4);
                    throw v6;
                }

                return v1;
            label_39:
                this.setDragTarget(v4);
            }
            else if(this.confirmValueChange.invoke(arg6).booleanValue()) {
                this.setSettledValue(arg6);
                this.setCurrentValue(arg6);
            }
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v9);
                goto label_39;
            }
            catch(Throwable v6) {
                goto label_41;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public static Object anchoredDrag$default(AnchoredDraggableState arg0, Object arg1, MutatePriority arg2, Function4 arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = MutatePriority.Default;
        }

        return arg0.anchoredDrag(arg1, arg2, arg3, arg4);
    }

    public static Object anchoredDrag$default(AnchoredDraggableState arg0, MutatePriority arg1, Function3 arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return arg0.anchoredDrag(arg1, arg2, arg3);
    }

    static final boolean confirmValueChange$lambda$0(Object arg0) {
        return 1;
    }

    public final float dispatchRawDelta(float arg5) {
        arg5 = this.newOffsetForDelta$foundation(arg5);
        float v0 = arg5 - this.requireOffset();
        AnchoredDragScope.dragTo$default(this.anchoredDragScope, arg5, 0f, 2, null);
        return v0;
    }

    public final DraggableAnchors getAnchors() {
        return this.anchors$delegate.getValue();
    }

    public final Function1 getConfirmValueChange$foundation() {
        return this.confirmValueChange;
    }

    public final Object getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final DecayAnimationSpec getDecayAnimationSpec() {
        DecayAnimationSpec v0 = this.decayAnimationSpec;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        return null;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.") public static void getDecayAnimationSpec$annotations() {
    }

    private final Object getDragTarget() {
        return this.dragTarget$delegate.getValue();
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final Function1 getPositionalThreshold$foundation() {
        Function1 v0 = this.positionalThreshold;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final float getProgress() {
        return this.progress$delegate.getValue().floatValue();
    }

    @Deprecated(message="Use the progress function to query the progress between two specified anchors.", replaceWith="<_subannotation>") public static void getProgress$annotations() {
    }

    public final Object getSettledValue() {
        return this.settledValue$delegate.getValue();
    }

    public final AnimationSpec getSnapAnimationSpec() {
        AnimationSpec v0 = this.snapAnimationSpec;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
        return null;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.") public static void getSnapAnimationSpec$annotations() {
    }

    public final Object getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final boolean getUsePreModifierChangeBehavior$foundation() {
        if(this.positionalThreshold != null && this.velocityThreshold != null && this.snapAnimationSpec != null && this.decayAnimationSpec != null) {
            return 1;
        }

        return 0;
    }

    public static void getUsePreModifierChangeBehavior$foundation$annotations() {
    }

    public final Function0 getVelocityThreshold$foundation() {
        Function0 v0 = this.velocityThreshold;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("velocityThreshold");
        return null;
    }

    public final boolean isAnimationRunning() {
        if(this.getDragTarget() != null) {
            return 1;
        }

        return 0;
    }

    public final float newOffsetForDelta$foundation(float arg2) {
        float v0 = Float.isNaN(this.getOffset()) ? 0f : this.getOffset();
        return RangesKt.coerceIn(v0 + arg2, this.getAnchors().minPosition(), this.getAnchors().maxPosition());
    }

    public final float progress(Object arg3, Object arg4) {
        float v3 = this.getAnchors().positionOf(arg3);
        float v4 = this.getAnchors().positionOf(arg4);
        float v2 = (RangesKt.coerceIn(this.getOffset(), Math.min(v3, v4), Math.max(v3, v4)) - v3) / (v4 - v3);
        v4 = 1f;
        if(!Float.isNaN(v2)) {
            if(v2 < 0.000001f) {
                return 0;
            }

            if(v2 > 0.999999f) {
                return v4;
            }

            return Math.abs(v2);
        }

        return v4;
    }

    static final float progress_delegate$lambda$0(AnchoredDraggableState arg5) {
        float v0 = arg5.getAnchors().positionOf(arg5.getSettledValue());
        float v1 = arg5.getAnchors().positionOf(arg5.getTargetValue()) - v0;
        float v2 = Math.abs(v1);
        float v4 = 1f;
        if(!Float.isNaN(v2)) {
            float v3 = 0.000001f;
            if(v2 > v3) {
                float v5 = (arg5.requireOffset() - v0) / v1;
                if(v5 < v3) {
                    return 0;
                }
                else if(v5 > 0.999999f) {
                    return v4;
                }
                else {
                    return v5;
                }
            }
        }

        return v4;
    }

    public final float requireOffset() {
        if(Float.isNaN(this.getOffset())) {
            InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }

        return this.getOffset();
    }

    private final void setAnchors(DraggableAnchors arg1) {
        this.anchors$delegate.setValue(arg1);
    }

    public final void setConfirmValueChange$foundation(Function1 arg1) {
        this.confirmValueChange = arg1;
    }

    private final void setCurrentValue(Object arg1) {
        this.currentValue$delegate.setValue(arg1);
    }

    public final void setDecayAnimationSpec$foundation(DecayAnimationSpec arg1) {
        this.decayAnimationSpec = arg1;
    }

    private final void setDragTarget(Object arg1) {
        this.dragTarget$delegate.setValue(arg1);
    }

    private final void setLastVelocity(float arg1) {
        this.lastVelocity$delegate.setFloatValue(arg1);
    }

    private final void setOffset(float arg1) {
        this.offset$delegate.setFloatValue(arg1);
    }

    public final void setPositionalThreshold$foundation(Function1 arg1) {
        this.positionalThreshold = arg1;
    }

    private final void setSettledValue(Object arg1) {
        this.settledValue$delegate.setValue(arg1);
    }

    public final void setSnapAnimationSpec$foundation(AnimationSpec arg1) {
        this.snapAnimationSpec = arg1;
    }

    public final void setVelocityThreshold$foundation(Function0 arg1) {
        this.velocityThreshold = arg1;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.") public final Object settle(float arg14, Continuation arg15) {
        if(!this.getUsePreModifierChangeBehavior$foundation()) {
            InlineClassHelperKt.throwIllegalArgumentException("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
        }

        Object v2 = this.getCurrentValue();
        Object v6 = AnchoredDraggableKt.computeTarget(this.getAnchors(), this.requireOffset(), arg14, this.getPositionalThreshold$foundation(), this.getVelocityThreshold$foundation());
        if(this.confirmValueChange.invoke(v6).booleanValue()) {
            return AnchoredDraggableKt.animateToWithDecay$default(this, v6, arg14, null, null, arg15, 12, null);
        }

        return AnchoredDraggableKt.animateToWithDecay$default(this, v2, arg14, null, null, arg15, 12, null);
    }

    public final Object settle(AnimationSpec arg4, Continuation arg5) {
        Object v3;
        Object v0 = this.getCurrentValue();
        Object v1 = this.getAnchors().closestAnchor(this.requireOffset());
        if(v1 != null && (this.confirmValueChange.invoke(v1).booleanValue())) {
            v3 = AnchoredDraggableKt.animateTo(this, v1, arg4, arg5);
            if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v3;
            }
            else {
                return Unit.INSTANCE;
            }
        }

        v3 = AnchoredDraggableKt.animateTo(this, v0, arg4, arg5);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    static final Object targetValue_delegate$lambda$0(AnchoredDraggableState arg2) {
        Object v0 = arg2.getDragTarget();
        if(v0 == null) {
            if(!Float.isNaN(arg2.getOffset())) {
                v0 = arg2.getAnchors().closestAnchor(arg2.getOffset());
                if(v0 == null) {
                    return arg2.getCurrentValue();
                }

                return v0;
            }

            return arg2.getCurrentValue();
        }

        return v0;
    }

    private final boolean trySnapTo(Object arg8) {
        MutatorMutex v0 = this.dragMutex;
        boolean v1 = v0.tryLock();
        if(v1) {
            try {
                AnchoredDraggableState$anchoredDragScope$1 v2 = this.anchoredDragScope;
                float v3 = this.getAnchors().positionOf(arg8);
                if(!Float.isNaN(v3)) {
                    AnchoredDragScope.dragTo$default(((AnchoredDragScope)v2), v3, 0f, 2, null);
                    this.setDragTarget(null);
                }

                this.setCurrentValue(arg8);
                this.setSettledValue(arg8);
            }
            catch(Throwable v7) {
                v0.unlock();
                throw v7;
            }

            v0.unlock();
            return v1;
        }

        return v1;
    }

    public final void updateAnchors(DraggableAnchors arg2, Object arg3) {
        if(!Intrinsics.areEqual(this.getAnchors(), arg2)) {
            this.setAnchors(arg2);
            if(!this.trySnapTo(arg3)) {
                this.setDragTarget(arg3);
            }
        }
    }

    public static void updateAnchors$default(AnchoredDraggableState arg0, DraggableAnchors arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            if(!Float.isNaN(arg0.getOffset())) {
                arg2 = arg1.closestAnchor(arg0.getOffset());
                if(arg2 == null) {
                    arg2 = arg0.getTargetValue();
                }
            }
            else {
                arg2 = arg0.getTargetValue();
            }
        }

        arg0.updateAnchors(arg1, arg2);
    }
}

