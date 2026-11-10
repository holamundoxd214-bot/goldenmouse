package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
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

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 i*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001iBy\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012!\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0012\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u000B\u0012#\b\u0002\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0089\u0001\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012!\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0012\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u000B\u0012#\b\u0002\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b\u0011\u0010\u0015J\u0006\u00108\u001A\u00020\u0006J#\u0010K\u001A\u00020L2\f\u0010M\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\b\b\u0002\u0010N\u001A\u00028\u0000¢\u0006\u0002\u0010OJ\u0016\u0010P\u001A\u00020L2\u0006\u0010Q\u001A\u00020\u0006H\u0086@¢\u0006\u0002\u0010RJ%\u0010S\u001A\u00028\u00002\u0006\u00101\u001A\u00020\u00062\u0006\u0010#\u001A\u00028\u00002\u0006\u0010Q\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010TJ\u001D\u0010U\u001A\u00028\u00002\u0006\u00101\u001A\u00020\u00062\u0006\u0010#\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010VJ\\\u0010Y\u001A\u00020L2\b\b\u0002\u0010Z\u001A\u00020[2B\u0010\\\u001A>\b\u0001\u0012\u0004\u0012\u00020X\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0^\u0012\u0006\u0012\u0004\u0018\u00010\u00020]¢\u0006\u0002\b_H\u0086@¢\u0006\u0002\u0010`Jy\u0010Y\u001A\u00020L2\u0006\u0010*\u001A\u00028\u00002\b\b\u0002\u0010Z\u001A\u00020[2W\u0010\\\u001AS\b\u0001\u0012\u0004\u0012\u00020X\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0^\u0012\u0006\u0012\u0004\u0018\u00010\u00020a¢\u0006\u0002\b_H\u0086@¢\u0006\u0002\u0010bJ\u0015\u0010c\u001A\u00020\u00062\u0006\u0010d\u001A\u00020\u0006H\u0000¢\u0006\u0002\beJ\u000E\u0010f\u001A\u00020\u00062\u0006\u0010d\u001A\u00020\u0006J\u0015\u0010g\u001A\u00020\u00102\u0006\u0010*\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010hR/\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u001D\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0019R/\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0017R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\u00020\u001FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R+\u0010#\u001A\u00028\u00002\u0006\u0010\"\u001A\u00028\u00008F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001B\u0010*\u001A\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b+\u0010%R\u001B\u0010.\u001A\u00028\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b0\u0010-\u001A\u0004\b/\u0010%R+\u00101\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020\u00068F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u00109\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b9\u0010:R\u001B\u0010;\u001A\u00020\u00068GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010-\u001A\u0004\b<\u00103R+\u0010>\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020\u00068F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bA\u00107\u001A\u0004\b?\u00103\"\u0004\b@\u00105R/\u0010B\u001A\u0004\u0018\u00018\u00002\b\u0010\"\u001A\u0004\u0018\u00018\u00008B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bE\u0010)\u001A\u0004\bC\u0010%\"\u0004\bD\u0010\'R7\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u00148F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bJ\u0010)\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000E\u0010W\u001A\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2={"Landroidx/compose/material3/internal/AnchoredDraggableState;", "T", "", "initialValue", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/material3/internal/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getPositionalThreshold$material3", "()Lkotlin/jvm/functions/Function1;", "getVelocityThreshold$material3", "()Lkotlin/jvm/functions/Function0;", "getAnimationSpec", "getConfirmValueChange$material3", "dragMutex", "Landroidx/compose/material3/internal/InternalMutatorMutex;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material3", "()Landroidx/compose/foundation/gestures/DraggableState;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "closestValue", "getClosestValue$material3", "closestValue$delegate", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "()Z", "progress", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/material3/internal/DraggableAnchors;", "setAnchors", "(Landroidx/compose/material3/internal/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/material3/internal/DraggableAnchors;Ljava/lang/Object;)V", "settle", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "anchoredDragScope", "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$material3", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnchoredDraggableState {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J{\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u0012\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\t2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u000E0\r2!\u0010\u000F\u001A\u001D\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000B0\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000B0\t¨\u0006\u0014"}, d2={"Landroidx/compose/material3/internal/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "T", "animationSpec", "Lkotlin/Function0;", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(Function0 arg2, Function1 arg3, Function1 arg4, Function0 arg5) {
            return SaverKt.Saver(new AnchoredDraggableState$Companion$$ExternalSyntheticLambda0(), new AnchoredDraggableState$Companion$$ExternalSyntheticLambda1(arg4, arg5, arg2, arg3));
        }

        static final Object Saver$lambda$0(SaverScope arg0, AnchoredDraggableState arg1) {
            return arg1.getCurrentValue();
        }

        static final AnchoredDraggableState Saver$lambda$1(Function1 arg6, Function0 arg7, Function0 arg8, Function1 arg9, Object arg10) {
            return new AnchoredDraggableState(arg10, arg6, arg7, arg8, arg9);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final Function0 animationSpec;
    private final State closestValue$delegate;
    private final Function1 confirmValueChange;
    private final MutableState currentValue$delegate;
    private final InternalMutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    private final Function1 positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final Function0 velocityThreshold;

    static {
        AnchoredDraggableState.Companion = new Companion(null);
    }

    public AnchoredDraggableState(Object arg7, Function1 arg8, Function0 arg9, Function0 arg10, Function1 arg11, int arg12, DefaultConstructorMarker arg13) {
        AnchoredDraggableState$$ExternalSyntheticLambda0 v11;
        if((arg12 & 16) != 0) {
            v11 = new AnchoredDraggableState$$ExternalSyntheticLambda0();
        }

        this(arg7, arg8, arg9, arg10, ((Function1)v11));
    }

    public AnchoredDraggableState(Object arg1, Function1 arg2, Function0 arg3, Function0 arg4, Function1 arg5) {
        super();
        this.positionalThreshold = arg2;
        this.velocityThreshold = arg3;
        this.animationSpec = arg4;
        this.confirmValueChange = arg5;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(arg1, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$$ExternalSyntheticLambda2(this));
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$$ExternalSyntheticLambda3(this));
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(NaNf);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new AnchoredDraggableState$$ExternalSyntheticLambda4(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public AnchoredDraggableState(Object arg7, DraggableAnchors arg8, Function1 arg9, Function0 arg10, Function0 arg11, Function1 arg12) {
        this(arg7, arg9, arg10, arg11, arg12);
        this.setAnchors(arg8);
        this.trySnapTo(arg7);
    }

    public AnchoredDraggableState(Object arg8, DraggableAnchors arg9, Function1 arg10, Function0 arg11, Function0 arg12, Function1 arg13, int arg14, DefaultConstructorMarker arg15) {
        AnchoredDraggableState$$ExternalSyntheticLambda1 v13;
        if((arg14 & 0x20) != 0) {
            v13 = new AnchoredDraggableState$$ExternalSyntheticLambda1();
        }

        this(arg8, arg9, arg10, arg11, arg12, ((Function1)v13));
    }

    static final boolean _init_$lambda$0(Object arg0) {
        return 1;
    }

    static final boolean _init_$lambda$1(Object arg0) {
        return 1;
    }

    public static final AnchoredDragScope access$getAnchoredDragScope$p(AnchoredDraggableState arg0) {
        return arg0.anchoredDragScope;
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

    public final Object anchoredDrag(MutatePriority arg7, Function3 arg8, Continuation arg9) {
        AnchoredDraggableState$anchoredDrag$1 v0_1;
        int v2;
        if((arg9 instanceof AnchoredDraggableState$anchoredDrag$1)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((AnchoredDraggableState$anchoredDrag$1)v0).label & v2) != 0) {
                ((AnchoredDraggableState$anchoredDrag$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AnchoredDraggableState$anchoredDrag$1(this, arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        float v3 = 0.5f;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            try {
                InternalMutatorMutex v9_1 = this.dragMutex;
                AnchoredDraggableState$anchoredDrag$2 v2_1 = new AnchoredDraggableState$anchoredDrag$2(this, arg8, null);
                v0_1.label = 1;
                if(v9_1.mutate(arg7, ((Function1)v2_1), ((Continuation)v0_1)) != v1) {
                    goto label_37;
                }
            }
            catch(Throwable v7) {
            label_54:
                Object v8 = this.getAnchors().closestAnchor(this.getOffset());
                if(v8 != null && Math.abs(this.getOffset() - this.getAnchors().positionOf(v8)) <= v3 && (this.confirmValueChange.invoke(v8).booleanValue())) {
                    this.setCurrentValue(v8);
                }

                throw v7;
            }

            return v1;
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v9);
            }
            catch(Throwable v7) {
                goto label_54;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_37:
        Object v7_1 = this.getAnchors().closestAnchor(this.getOffset());
        if(v7_1 != null && Math.abs(this.getOffset() - this.getAnchors().positionOf(v7_1)) <= v3 && (this.confirmValueChange.invoke(v7_1).booleanValue())) {
            this.setCurrentValue(v7_1);
        }

        return Unit.INSTANCE;
    }

    public final Object anchoredDrag(Object arg7, MutatePriority arg8, Function4 arg9, Continuation arg10) {
        AnchoredDraggableState$anchoredDrag$3 v0_1;
        int v2;
        if((arg10 instanceof AnchoredDraggableState$anchoredDrag$3)) {
            Continuation v0 = arg10;
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
            v0_1 = new AnchoredDraggableState$anchoredDrag$3(this, arg10);
        }

        Object v10 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        float v3 = 0.5f;
        Continuation v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            if(this.getAnchors().hasAnchorFor(arg7)) {
                try {
                    InternalMutatorMutex v10_1 = this.dragMutex;
                    AnchoredDraggableState$anchoredDrag$4 v2_1 = new AnchoredDraggableState$anchoredDrag$4(this, arg7, arg9, v5);
                    v0_1.label = 1;
                    if(v10_1.mutate(arg8, ((Function1)v2_1), ((Continuation)v0_1)) != v1) {
                        goto label_40;
                    }
                }
                catch(Throwable v7) {
                label_57:
                    this.setDragTarget(v5);
                    Object v8 = this.getAnchors().closestAnchor(this.getOffset());
                    if(v8 != null && Math.abs(this.getOffset() - this.getAnchors().positionOf(v8)) <= v3 && (this.confirmValueChange.invoke(v8).booleanValue())) {
                        this.setCurrentValue(v8);
                    }

                    throw v7;
                }

                return v1;
            label_40:
                this.setDragTarget(v5);
                arg7 = this.getAnchors().closestAnchor(this.getOffset());
                if(arg7 == null) {
                    goto label_75;
                }

                if(Math.abs(this.getOffset() - this.getAnchors().positionOf(arg7)) > v3) {
                    goto label_75;
                }

                if(!this.confirmValueChange.invoke(arg7).booleanValue()) {
                    goto label_75;
                }

                this.setCurrentValue(arg7);
            }
            else {
                this.setCurrentValue(arg7);
            }
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v10);
                goto label_40;
            }
            catch(Throwable v7) {
                goto label_57;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_75:
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

    static final Object closestValue_delegate$lambda$5(AnchoredDraggableState arg2) {
        Object v0 = arg2.getDragTarget();
        if(v0 == null) {
            float v0_1 = arg2.getOffset();
            if(!Float.isNaN(v0_1)) {
                return arg2.computeTargetWithoutThresholds(v0_1, arg2.getCurrentValue());
            }

            return arg2.getCurrentValue();
        }

        return v0;
    }

    private final Object computeTarget(float arg6, Object arg7, float arg8) {
        Object v8;
        Object v5;
        DraggableAnchors v0 = this.getAnchors();
        float v1 = v0.positionOf(arg7);
        float v2 = this.velocityThreshold.invoke().floatValue();
        int v3 = Float.compare(v1, arg6);
        if(v3 == 0) {
            return arg7;
        }

        if(Float.isNaN(v1)) {
        }
        else if(v3 < 0) {
            if(Float.compare(arg8, v2) >= 0) {
                v5 = v0.closestAnchor(arg6, true);
                Intrinsics.checkNotNull(v5);
                return v5;
            }
            else {
                v8 = v0.closestAnchor(arg6, true);
                Intrinsics.checkNotNull(v8);
                if(arg6 < Math.abs(v1 + Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(v0.positionOf(v8) - v1))).floatValue()))) {
                }
                else {
                    return v8;
                }
            }
        }
        else if(Float.compare(arg8, -v2) <= 0) {
            v5 = v0.closestAnchor(arg6, false);
            Intrinsics.checkNotNull(v5);
            return v5;
        }
        else {
            v8 = v0.closestAnchor(arg6, false);
            Intrinsics.checkNotNull(v8);
            float v5_1 = Math.abs(v1 - Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(v1 - v0.positionOf(v8)))).floatValue()));
            if(arg6 < 0f) {
                if(Math.abs(arg6) < v5_1) {
                    return arg7;
                }
            }
            else if(arg6 > v5_1) {
                return arg7;
            }

            return v8;
        }

        return arg7;
    }

    private final Object computeTargetWithoutThresholds(float arg3, Object arg4) {
        Object v2_1;
        DraggableAnchors v2 = this.getAnchors();
        float v0 = v2.positionOf(arg4);
        int v1 = Float.compare(v0, arg3);
        if(v1 == 0) {
            return arg4;
        }

        if(Float.isNaN(v0)) {
        }
        else if(v1 < 0) {
            v2_1 = v2.closestAnchor(arg3, true);
            if(v2_1 == null) {
            }
            else {
                return v2_1;
            }
        }
        else {
            v2_1 = v2.closestAnchor(arg3, false);
            if(v2_1 == null) {
                return arg4;
            }

            return v2_1;
        }

        return arg4;
    }

    public final float dispatchRawDelta(float arg2) {
        arg2 = this.newOffsetForDelta$material3(arg2);
        float v0 = Float.isNaN(this.getOffset()) ? 0f : this.getOffset();
        this.setOffset(arg2);
        return arg2 - v0;
    }

    public final DraggableAnchors getAnchors() {
        return this.anchors$delegate.getValue();
    }

    public final Function0 getAnimationSpec() {
        return this.animationSpec;
    }

    public final Object getClosestValue$material3() {
        return this.closestValue$delegate.getValue();
    }

    public final Function1 getConfirmValueChange$material3() {
        return this.confirmValueChange;
    }

    public final Object getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    private final Object getDragTarget() {
        return this.dragTarget$delegate.getValue();
    }

    public final DraggableState getDraggableState$material3() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final Function1 getPositionalThreshold$material3() {
        return this.positionalThreshold;
    }

    public final float getProgress() {
        return this.progress$delegate.getValue().floatValue();
    }

    public final Object getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final Function0 getVelocityThreshold$material3() {
        return this.velocityThreshold;
    }

    public final boolean isAnimationRunning() {
        if(this.getDragTarget() != null) {
            return 1;
        }

        return 0;
    }

    public final float newOffsetForDelta$material3(float arg2) {
        float v0 = Float.isNaN(this.getOffset()) ? 0f : this.getOffset();
        return RangesKt.coerceIn(v0 + arg2, this.getAnchors().minAnchor(), this.getAnchors().maxAnchor());
    }

    static final float progress_delegate$lambda$7(AnchoredDraggableState arg5) {
        float v0 = arg5.getAnchors().positionOf(arg5.getCurrentValue());
        float v1 = arg5.getAnchors().positionOf(arg5.getClosestValue$material3()) - v0;
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
        if(!Float.isNaN(this.getOffset())) {
            return this.getOffset();
        }

        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    private final void setAnchors(DraggableAnchors arg1) {
        this.anchors$delegate.setValue(arg1);
    }

    private final void setCurrentValue(Object arg1) {
        this.currentValue$delegate.setValue(arg1);
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

    public final Object settle(float arg4, Continuation arg5) {
        Object v3;
        Object v0 = this.getCurrentValue();
        Object v1 = this.computeTarget(this.requireOffset(), v0, arg4);
        if(this.confirmValueChange.invoke(v1).booleanValue()) {
            v3 = AnchoredDraggableKt.animateTo(this, v1, arg4, arg5);
            if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v3;
            }

            return Unit.INSTANCE;
        }

        v3 = AnchoredDraggableKt.animateTo(this, v0, arg4, arg5);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    static final Object targetValue_delegate$lambda$3(AnchoredDraggableState arg3) {
        Object v0 = arg3.getDragTarget();
        if(v0 == null) {
            float v0_1 = arg3.getOffset();
            if(!Float.isNaN(v0_1)) {
                return arg3.computeTarget(v0_1, arg3.getCurrentValue(), 0f);
            }

            return arg3.getCurrentValue();
        }

        return v0;
    }

    private final boolean trySnapTo(Object arg3) {
        return this.dragMutex.tryMutate(new AnchoredDraggableState$$ExternalSyntheticLambda5(this, arg3));
    }

    static final Unit trySnapTo$lambda$9(AnchoredDraggableState arg5, Object arg6) {
        AnchoredDragScope v0 = arg5.anchoredDragScope;
        float v1 = arg5.getAnchors().positionOf(arg6);
        if(!Float.isNaN(v1)) {
            AnchoredDragScope.dragTo$default(v0, v1, 0f, 2, null);
            arg5.setDragTarget(null);
        }

        arg5.setCurrentValue(arg6);
        return Unit.INSTANCE;
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

