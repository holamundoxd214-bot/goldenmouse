package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BW\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\b\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\b\u0010\u001F\u001A\u00020\u001EH\u0016J\b\u0010 \u001A\u00020\u001EH\u0002J\u0012\u0010!\u001A\u00020\u001E2\b\u0010\"\u001A\u0004\u0018\u00010\u0010H\u0002JM\u0010#\u001A\u00020\u001E2=\u0010$\u001A9\b\u0001\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110\'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001E0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001E0+\u0012\u0006\u0012\u0004\u0018\u00010,0%H\u0096@¢\u0006\u0002\u0010-J\u0017\u0010.\u001A\u00020\u001E2\u0006\u0010/\u001A\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0010\u00103\u001A\u00020\u001E2\u0006\u00104\u001A\u000205H\u0016J\u0016\u00106\u001A\u0002072\u0006\u00108\u001A\u000207H\u0082@¢\u0006\u0002\u00109J\b\u0010\u000E\u001A\u00020\bH\u0016J[\u0010:\u001A\u00020\u001E2\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0013\u0010;\u001A\u000200*\u000207H\u0002¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001A\u00020?*\u000207H\u0002¢\u0006\u0004\b@\u0010=J\u0013\u0010A\u001A\u000207*\u00020?H\u0002¢\u0006\u0004\bB\u0010CJ\u0013\u0010A\u001A\u000207*\u000200H\u0002¢\u0006\u0004\bD\u0010CJ\u0013\u0010E\u001A\u00020?*\u00020?H\u0002¢\u0006\u0004\bF\u0010GJ\u0013\u0010E\u001A\u000200*\u000200H\u0002¢\u0006\u0004\bH\u0010GR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0014\u001A\u00020\u0010X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006I"}, d2={"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "T", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Ljava/lang/Boolean;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "Ljava/lang/Boolean;", "resolvedFlingBehavior", "getResolvedFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setResolvedFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "density", "Landroidx/compose/ui/unit/Density;", "isReverseDirection", "()Z", "onAttach", "", "onDensityChange", "updateDensity", "updateFlingBehavior", "newFlingBehavior", "drag", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "fling", "", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat", "toFloat-TH1AsA0", "(J)F", "toFloat-k-4lQ0M", "reverseIfNeeded", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded-MK-Hz9U", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnchoredDraggableNode extends DragGestureNode {
    private Density density;
    private FlingBehavior flingBehavior;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    public FlingBehavior resolvedFlingBehavior;
    private Boolean reverseDirection;
    private Boolean startDragImmediately;
    private AnchoredDraggableState state;

    public AnchoredDraggableNode(AnchoredDraggableState arg2, Orientation arg3, boolean arg4, Boolean arg5, MutableInteractionSource arg6, OverscrollEffect arg7, Boolean arg8, FlingBehavior arg9) {
        super(AnchoredDraggableKt.AlwaysDrag, arg4, arg6, arg3);
        this.state = arg2;
        this.orientation = arg3;
        this.reverseDirection = arg5;
        this.overscrollEffect = arg7;
        this.startDragImmediately = arg8;
        this.flingBehavior = arg9;
    }

    public static final Object access$fling(AnchoredDraggableNode arg0, float arg1, Continuation arg2) {
        return arg0.fling(arg1, arg2);
    }

    public static final OverscrollEffect access$getOverscrollEffect$p(AnchoredDraggableNode arg0) {
        return arg0.overscrollEffect;
    }

    public static final AnchoredDraggableState access$getState$p(AnchoredDraggableNode arg0) {
        return arg0.state;
    }

    public static final long access$reverseIfNeeded-AH228Gc(AnchoredDraggableNode arg0, long arg1) {
        return arg0.reverseIfNeeded-AH228Gc(arg1);
    }

    public static final long access$reverseIfNeeded-MK-Hz9U(AnchoredDraggableNode arg0, long arg1) {
        return arg0.reverseIfNeeded-MK-Hz9U(arg1);
    }

    public static final float access$toFloat-TH1AsA0(AnchoredDraggableNode arg0, long arg1) {
        return arg0.toFloat-TH1AsA0(arg1);
    }

    public static final float access$toFloat-k-4lQ0M(AnchoredDraggableNode arg0, long arg1) {
        return arg0.toFloat-k-4lQ0M(arg1);
    }

    public static final long access$toOffset-tuRUvjQ(AnchoredDraggableNode arg0, float arg1) {
        return arg0.toOffset-tuRUvjQ(arg1);
    }

    public static final long access$toVelocity-adjELrA(AnchoredDraggableNode arg0, float arg1) {
        return arg0.toVelocity-adjELrA(arg1);
    }

    public Object drag(Function2 arg7, Continuation arg8) {
        Object v6 = AnchoredDraggableState.anchoredDrag$default(this.state, null, new AnchoredDraggableNode$drag$2(arg7, this, null), arg8, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    private final Object fling(float arg8, Continuation arg9) {
        Object v7;
        FloatRef v7_2;
        FloatRef v9_1;
        int v2;
        Continuation v0;
        if((arg9 instanceof AnchoredDraggableNode$fling$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((AnchoredDraggableNode$fling$1)v0).label & v2) != 0) {
                ((AnchoredDraggableNode$fling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AnchoredDraggableNode$fling$1 v0_1 = new AnchoredDraggableNode$fling$1(this, arg9);
        }

        Continuation v4 = v0;
        Object v9 = ((AnchoredDraggableNode$fling$1)v4).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((AnchoredDraggableNode$fling$1)v4).label;
        v2 = 2;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v9);
            if(this.state.getUsePreModifierChangeBehavior$foundation()) {
                AnchoredDraggableState v7_1 = this.state;
                ((AnchoredDraggableNode$fling$1)v4).label = 1;
                v7 = v7_1.settle(arg8, v4);
                if(v7 == v0_2) {
                }
                else {
                    return v7;
                }
            }
            else {
                v9_1 = new FloatRef();
                v9_1.element = arg8;
                AnchoredDraggableState v1_1 = this.state;
                AnchoredDraggableNode$fling$2 v3 = new AnchoredDraggableNode$fling$2(this, v9_1, arg8, null);
                ((AnchoredDraggableNode$fling$1)v4).L$0 = v9_1;
                ((AnchoredDraggableNode$fling$1)v4).label = v2;
                if(AnchoredDraggableState.anchoredDrag$default(v1_1, null, ((Function3)v3), v4, 1, null) == v0_2) {
                    return v0_2;
                }

                goto label_56;
            }

            return v0_2;
        label_56:
            v7_2 = v9_1;
        }
        else if(v1 == 1) {
            ResultKt.throwOnFailure(v9);
            return v9;
        }
        else if(v1 == v2) {
            v7 = ((AnchoredDraggableNode$fling$1)v4).L$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxFloat(v7_2.element);
    }

    public final FlingBehavior getResolvedFlingBehavior() {
        FlingBehavior v0 = this.resolvedFlingBehavior;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("resolvedFlingBehavior");
        return null;
    }

    private final boolean isReverseDirection() {
        Boolean v0 = this.reverseDirection;
        if(v0 == null) {
            if(DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal) {
                return 1;
            }

            return 0;
        }

        Intrinsics.checkNotNull(v0);
        return v0.booleanValue();
    }

    public void onAttach() {
        this.updateFlingBehavior(this.flingBehavior);
    }

    public void onDensityChange() {
        this.onCancelPointerInput();
        if(this.isAttached()) {
            this.updateDensity();
        }
    }

    public void onDragStarted-k-4lQ0M(long arg1) {
    }

    public void onDragStopped(DragStopped arg8) {
        if(!this.isAttached()) {
            return;
        }

        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new AnchoredDraggableNode$onDragStopped$1(this, arg8, null), 3, null);
    }

    private final long reverseIfNeeded-AH228Gc(long arg1) {
        float v0 = this.isReverseDirection() ? -1f : 1f;
        return Velocity.times-adjELrA(arg1, v0);
    }

    private final long reverseIfNeeded-MK-Hz9U(long arg1) {
        float v0 = this.isReverseDirection() ? -1f : 1f;
        return Offset.times-tuRUvjQ(arg1, v0);
    }

    public final void setResolvedFlingBehavior(FlingBehavior arg1) {
        this.resolvedFlingBehavior = arg1;
    }

    public boolean startDragImmediately() {
        Boolean v0 = this.startDragImmediately;
        if(v0 != null) {
            return v0.booleanValue();
        }

        return this.state.isAnimationRunning();
    }

    private final float toFloat-TH1AsA0(long arg2) {
        if(this.orientation == Orientation.Vertical) {
            return Velocity.getY-impl(arg2);
        }

        return Velocity.getX-impl(arg2);
    }

    private final float toFloat-k-4lQ0M(long arg3) {
        long v2 = this.orientation == Orientation.Vertical ? arg3 & 0xFFFFFFFFL : arg3 >> 0x20;
        return Float.intBitsToFloat(((int)v2));
    }

    private final long toOffset-tuRUvjQ(float arg5) {
        float v0 = this.orientation == Orientation.Horizontal ? arg5 : 0f;
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v0))) << 0x20);
    }

    private final long toVelocity-adjELrA(float arg4) {
        float v0 = this.orientation == Orientation.Horizontal ? arg4 : 0f;
        return VelocityKt.Velocity(v0, 0f);
    }

    public final void update(AnchoredDraggableState arg9, Orientation arg10, boolean arg11, Boolean arg12, MutableInteractionSource arg13, OverscrollEffect arg14, Boolean arg15, FlingBehavior arg16) {
        boolean v5;
        boolean v1;
        FlingBehavior v3 = arg16;
        this.flingBehavior = v3;
        if(!Intrinsics.areEqual(this.state, arg9)) {
            this.state = arg9;
            this.updateFlingBehavior(v3);
            v1 = true;
        }
        else {
            v1 = false;
        }

        if(this.orientation != arg10) {
            this.orientation = arg10;
            v1 = true;
        }

        if(!Intrinsics.areEqual(this.reverseDirection, arg12)) {
            this.reverseDirection = arg12;
            v5 = true;
        }
        else {
            v5 = v1;
        }

        this.startDragImmediately = arg15;
        this.overscrollEffect = arg14;
        DragGestureNode.update$default(this, null, arg11, arg13, arg10, v5, 1, null);
    }

    private final void updateDensity() {
        Density v0 = DelegatableNodeKt.requireDensity(this);
        Density v1 = this.density;
        if(v1 != null) {
            if(!Intrinsics.areEqual(v1, v0)) {
            }
            else {
                return;
            }
        }

        this.density = v0;
        this.updateFlingBehavior(this.flingBehavior);
    }

    private final void updateFlingBehavior(FlingBehavior arg4) {
        TargetedFlingBehavior v4_1;
        if(arg4 == null) {
            AnimationSpec v4 = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            Function1 v0 = AnchoredDraggableDefaults.INSTANCE.getPositionalThreshold();
            Density v1 = DelegatableNodeKt.requireDensity(this);
            this.density = v1;
            v4_1 = AnchoredDraggableKt.anchoredDraggableFlingBehavior(this.state, v1, v0, v4);
        }

        this.setResolvedFlingBehavior(((FlingBehavior)v4_1));
    }
}

