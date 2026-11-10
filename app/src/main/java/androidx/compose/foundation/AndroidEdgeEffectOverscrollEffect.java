package androidx.compose.foundation;

import android.content.Context;
import android.os.Build$VERSION;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ3\u0010\u001F\u001A\u00020\r2\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\"2\u0012\u0010#\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0$H\u0016¢\u0006\u0004\b%\u0010&J<\u0010\'\u001A\u00020\u00132\u0006\u0010(\u001A\u00020)2\"\u0010*\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001A\u00020\u00132\u0006\u00104\u001A\u000201H\u0000¢\u0006\u0004\b5\u00106J\u000F\u00109\u001A\u00020\rH\u0000¢\u0006\u0004\b:\u0010;J\r\u0010B\u001A\u00020\u0013H\u0000¢\u0006\u0002\bCJ\b\u0010D\u001A\u00020\u0013H\u0002J\u0017\u0010E\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\rH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001A\u00020I2\u0006\u0010J\u001A\u00020\rH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001A\u00020I2\u0006\u0010J\u001A\u00020\rH\u0002¢\u0006\u0004\bN\u0010LJ\u0017\u0010O\u001A\u00020I2\u0006\u0010J\u001A\u00020\rH\u0002¢\u0006\u0004\bP\u0010LJ\u0017\u0010Q\u001A\u00020I2\u0006\u0010J\u001A\u00020\rH\u0002¢\u0006\u0004\bR\u0010LR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001A\u00020\u00178\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u000E\u0010\u001E\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00100\u001A\u000201X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u0014\u00102\u001A\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b2\u0010\u001BR\u0010\u00107\u001A\u000208X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010<\u001A\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001A\u00020?X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b@\u0010A¨\u0006S"}, d2={"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation$annotations", "()V", "getInvalidationEnabled$foundation", "()Z", "setInvalidationEnabled$foundation", "(Z)V", "scrollCycleInProgress", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containerSize", "Landroidx/compose/ui/geometry/Size;", "isInProgress", "updateSize", "size", "updateSize-uvyYCjk$foundation", "(J)V", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "displacement", "displacement-F1C5BW0$foundation", "()J", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "invalidateOverscroll", "invalidateOverscroll$foundation", "animateToReleaseIfNeeded", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "pullTop", "", "scroll", "pullTop-k-4lQ0M", "(J)F", "pullBottom", "pullBottom-k-4lQ0M", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState redrawSignal;
    private boolean scrollCycleInProgress;

    static {
    }

    private AndroidEdgeEffectOverscrollEffect(Context arg3, Density arg4, long arg5, PaddingValues arg7) {
        GlowOverscrollNode v5_1;
        super();
        this.density = arg4;
        this.pointerPosition = Offset.Companion.getUnspecified-F1C5BW0();
        EdgeEffectWrapper v4 = new EdgeEffectWrapper(arg3, ColorKt.toArgb-8_81llA(arg5));
        this.edgeEffectWrapper = v4;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.getZero-NH-jbRc();
        this.pointerId = PointerId.constructor-impl(-1);
        SuspendingPointerInputModifierNode v3 = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AndroidEdgeEffectOverscrollEffect$pointerInputNode$1(this));
        this.pointerInputNode = v3;
        if(Build$VERSION.SDK_INT >= 0x1F) {
            StretchOverscrollNode v5 = new StretchOverscrollNode(((DelegatableNode)v3), this, v4);
        }
        else {
            v5_1 = new GlowOverscrollNode(((DelegatableNode)v3), this, v4, arg7);
        }

        this.node = ((DelegatableNode)v5_1);
    }

    public AndroidEdgeEffectOverscrollEffect(Context arg1, Density arg2, long arg3, PaddingValues arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg5);
    }

    public static final long access$getPointerId$p(AndroidEdgeEffectOverscrollEffect arg2) {
        return arg2.pointerId;
    }

    public static final void access$setPointerId$p(AndroidEdgeEffectOverscrollEffect arg0, long arg1) {
        arg0.pointerId = arg1;
    }

    public static final void access$setPointerPosition$p(AndroidEdgeEffectOverscrollEffect arg0, long arg1) {
        arg0.pointerPosition = arg1;
    }

    private final void animateToReleaseIfNeeded() {
        int v1_1;
        EdgeEffectWrapper v0 = this.edgeEffectWrapper;
        EdgeEffect v1 = EdgeEffectWrapper.access$getTopEffect$p(v0);
        int v2 = 1;
        if(v1 != null) {
            v1.onRelease();
            v1_1 = v1.isFinished() ^ 1;
        }
        else {
            v1_1 = 0;
        }

        EdgeEffect v4 = EdgeEffectWrapper.access$getBottomEffect$p(v0);
        if(v4 != null) {
            v4.onRelease();
            if(v4.isFinished()) {
                if(v1_1 != 0) {
                }
                else {
                    v1_1 = 0;
                    goto label_20;
                }
            }

            v1_1 = 1;
        }

    label_20:
        v4 = EdgeEffectWrapper.access$getLeftEffect$p(v0);
        if(v4 != null) {
            v4.onRelease();
            if(v4.isFinished()) {
                if(v1_1 != 0) {
                }
                else {
                    v1_1 = 0;
                    goto label_30;
                }
            }

            v1_1 = 1;
        }

    label_30:
        EdgeEffect v0_1 = EdgeEffectWrapper.access$getRightEffect$p(v0);
        if(v0_1 != null) {
            v0_1.onRelease();
            if(v0_1.isFinished()) {
                if(v1_1 != 0) {
                }
                else {
                    v2 = 0;
                }
            }

            v1_1 = v2;
        }

        if(v1_1 != 0) {
            this.invalidateOverscroll$foundation();
        }
    }

    public Object applyToFling-BMRW4eQ(long arg12, Function2 arg14, Continuation arg15) {
        float v2_1;
        float v15_1;
        int v2;
        Continuation v0;
        if((arg15 instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1)) {
            v0 = arg15;
            v2 = 0x80000000;
            if((((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).label & v2) != 0) {
                ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AndroidEdgeEffectOverscrollEffect$applyToFling$1 v0_1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, arg15);
        }

        Object v15 = ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v15);
            if(Size.isEmpty-impl(this.containerSize)) {
                Velocity v11 = Velocity.box-impl(arg12);
                ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).label = 1;
                if(arg14.invoke(v11, v0) == v1) {
                }
                else {
                label_40:
                    return Unit.INSTANCE;
                }
            }
            else {
                v2 = 0x20;
                if(!this.edgeEffectWrapper.isLeftStretched() || Velocity.getX-impl(arg12) >= 0f) {
                    if((this.edgeEffectWrapper.isRightStretched()) && Velocity.getX-impl(arg12) > 0f) {
                        v15_1 = -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.getX-impl(arg12), Float.intBitsToFloat(((int)(this.containerSize >> v2))), this.density);
                        goto label_78;
                    }

                    v15_1 = 0f;
                }
                else {
                    v15_1 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.getX-impl(arg12), Float.intBitsToFloat(((int)(this.containerSize >> v2))), this.density);
                }

            label_78:
                long v6 = 0xFFFFFFFFL;
                if(!this.edgeEffectWrapper.isTopStretched() || Velocity.getY-impl(arg12) >= 0f) {
                    if((this.edgeEffectWrapper.isBottomStretched()) && Velocity.getY-impl(arg12) > 0f) {
                        v2_1 = -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.getY-impl(arg12), Float.intBitsToFloat(((int)(v6 & this.containerSize))), this.density);
                        goto label_114;
                    }

                    v2_1 = 0f;
                }
                else {
                    v2_1 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateTopEffect(), Velocity.getY-impl(arg12), Float.intBitsToFloat(((int)(v6 & this.containerSize))), this.density);
                }

            label_114:
                v6 = VelocityKt.Velocity(v15_1, v2_1);
                if(!Velocity.equals-impl0(v6, Velocity.Companion.getZero-9UxMQ8M())) {
                    this.invalidateOverscroll$foundation();
                }

                arg12 = Velocity.minus-AH228Gc(arg12, v6);
                Velocity v15_2 = Velocity.box-impl(arg12);
                ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).J$0 = arg12;
                ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).label = v3;
                v15 = arg14.invoke(v15_2, v0);
                if(v15 != v1) {
                    goto label_127;
                }
            }

            return v1;
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v15);
            goto label_40;
        }
        else if(v2 == v3) {
            arg12 = ((AndroidEdgeEffectOverscrollEffect$applyToFling$1)v0).J$0;
            ResultKt.throwOnFailure(v15);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_127:
        arg12 = Velocity.minus-AH228Gc(arg12, ((Velocity)v15).unbox-impl());
        this.scrollCycleInProgress = false;
        if(Velocity.getX-impl(arg12) > 0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.getX-impl(arg12)));
        }
        else if(Velocity.getX-impl(arg12) < 0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.getX-impl(arg12)));
        }

        if(Velocity.getY-impl(arg12) > 0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.getY-impl(arg12)));
        }
        else if(Velocity.getY-impl(arg12) < 0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.getY-impl(arg12)));
        }

        this.animateToReleaseIfNeeded();
        return Unit.INSTANCE;
    }

    public long applyToScroll-Rhakbz0(long arg21, int arg23, Function1 arg24) {
        int v5;
        long v18;
        float v14;
        float v10_1;
        float v11;
        AndroidEdgeEffectOverscrollEffect v0 = this;
        long v1 = arg21;
        Function1 v3 = arg24;
        if(Size.isEmpty-impl(v0.containerSize)) {
            return v3.invoke(Offset.box-impl(v1)).unbox-impl();
        }

        if(!v0.scrollCycleInProgress) {
            if(v0.edgeEffectWrapper.isLeftStretched()) {
                v0.pullLeft-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            }

            if(v0.edgeEffectWrapper.isRightStretched()) {
                v0.pullRight-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            }

            if(v0.edgeEffectWrapper.isTopStretched()) {
                v0.pullTop-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            }

            if(v0.edgeEffectWrapper.isBottomStretched()) {
                v0.pullBottom-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            }

            v0.scrollCycleInProgress = true;
        }

        float v4 = AndroidOverscroll_androidKt.access$destretchMultiplier-GyEprt8(arg23);
        long v6 = Offset.times-tuRUvjQ(v1, v4);
        long v8 = 0xFFFFFFFFL;
        int v10 = ((int)(v1 & v8));
        if(Float.intBitsToFloat(v10) != 0f) {
            if(!v0.edgeEffectWrapper.isTopStretched() || Float.intBitsToFloat(v10) >= 0f) {
                if(!v0.edgeEffectWrapper.isBottomStretched()) {
                    goto label_46;
                }

                if(Float.intBitsToFloat(v10) <= 0f) {
                    goto label_46;
                }

                v11 = v0.pullBottom-k-4lQ0M(v6);
                if(!v0.edgeEffectWrapper.isBottomStretched()) {
                    v0.edgeEffectWrapper.getOrCreateBottomEffect().finish();
                }

                if(v11 != Float.intBitsToFloat(((int)(v6 & v8)))) {
                    goto label_66;
                }

                v10_1 = Float.intBitsToFloat(v10);
            }
            else {
                v11 = v0.pullTop-k-4lQ0M(v6);
                if(!v0.edgeEffectWrapper.isTopStretched()) {
                    v0.edgeEffectWrapper.getOrCreateTopEffect().finish();
                }

                if(v11 != Float.intBitsToFloat(((int)(v6 & v8)))) {
                    goto label_66;
                }

                v10_1 = Float.intBitsToFloat(v10);
            }

            goto label_85;
        label_66:
            v10_1 = v11 / v4;
        }
        else {
        label_46:
            v10_1 = 0f;
        }

    label_85:
        int v11_1 = 0x20;
        int v13 = ((int)(v1 >> v11_1));
        if(Float.intBitsToFloat(v13) != 0f) {
            if(!v0.edgeEffectWrapper.isLeftStretched() || Float.intBitsToFloat(v13) >= 0f) {
                if(!v0.edgeEffectWrapper.isRightStretched()) {
                    goto label_90;
                }

                if(Float.intBitsToFloat(v13) <= 0f) {
                    goto label_90;
                }

                v14 = v0.pullRight-k-4lQ0M(v6);
                if(!v0.edgeEffectWrapper.isRightStretched()) {
                    v0.edgeEffectWrapper.getOrCreateRightEffect().finish();
                }

                if(v14 != Float.intBitsToFloat(((int)(v6 >> v11_1)))) {
                    goto label_110;
                }

                v4 = Float.intBitsToFloat(v13);
            }
            else {
                v14 = v0.pullLeft-k-4lQ0M(v6);
                if(!v0.edgeEffectWrapper.isLeftStretched()) {
                    v0.edgeEffectWrapper.getOrCreateLeftEffect().finish();
                }

                if(v14 != Float.intBitsToFloat(((int)(v6 >> v11_1)))) {
                    goto label_110;
                }

                v4 = Float.intBitsToFloat(v13);
            }

            goto label_129;
        label_110:
            v4 = v14 / v4;
        }
        else {
        label_90:
            v4 = 0f;
        }

    label_129:
        v6 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v4))) << v11_1 | (((long)Float.floatToRawIntBits(v10_1))) & v8);
        if(!Offset.equals-impl0(v6, Offset.Companion.getZero-F1C5BW0())) {
            v0.invalidateOverscroll$foundation();
        }

        long v13_1 = Offset.minus-MK-Hz9U(v1, v6);
        long v3_1 = v3.invoke(Offset.box-impl(v13_1)).unbox-impl();
        long v15 = v8;
        v8 = Offset.minus-MK-Hz9U(v13_1, v3_1);
        int v17 = v11_1;
        if(Float.intBitsToFloat(((int)(v13_1 >> v17))) != 0f || Float.intBitsToFloat(((int)(v13_1 & v15))) != 0f) {
            if(Float.intBitsToFloat(((int)(v3_1 >> v17))) == 0f && Float.intBitsToFloat(((int)(v3_1 & v15))) == 0f) {
                goto label_178;
            }

            EdgeEffectWrapper v10_2 = v0.edgeEffectWrapper;
            if(!v10_2.isLeftStretched() && !v10_2.isTopStretched() && !v10_2.isRightStretched() && !v10_2.isBottomStretched()) {
                goto label_178;
            }

            v0.animateToReleaseIfNeeded();
        }
        else {
        }

    label_178:
        if(NestedScrollSource.equals-impl0(arg23, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
            v10 = ((int)(v8 >> v17));
            float v12 = 0.5f;
            float v17_1 = -0.5f;
            if(Float.compare(Float.intBitsToFloat(v10), v12) > 0) {
                v0.pullLeft-k-4lQ0M(v8);
                goto label_191;
            }
            else if(Float.intBitsToFloat(v10) < v17_1) {
                v0.pullRight-k-4lQ0M(v8);
            label_191:
                v10 = 1;
                v18 = v6;
            }
            else {
                v18 = v6;
                v10 = 0;
            }

            v5 = ((int)(v8 & v15));
            if(Float.intBitsToFloat(v5) > v12) {
                v0.pullTop-k-4lQ0M(v8);
                goto label_205;
            }
            else if(Float.intBitsToFloat(v5) < v17_1) {
                v0.pullBottom-k-4lQ0M(v8);
            label_205:
                v5 = 1;
            }
            else {
                v5 = 0;
            }

            if(v10 == 0 && v5 == 0) {
                goto label_217;
            }

            v5 = 1;
        }
        else {
            v18 = v6;
        label_217:
            v5 = 0;
        }

        if(!Offset.equals-impl0(v13_1, Offset.Companion.getZero-F1C5BW0())) {
            if(!this.releaseOppositeOverscroll-k-4lQ0M(arg21)) {
                if(v5 != 0) {
                }
                else {
                    v5 = 0;
                    goto label_229;
                }
            }

            v5 = 1;
        }

    label_229:
        if(v5 != 0) {
            v0.invalidateOverscroll$foundation();
        }

        return Offset.plus-MK-Hz9U(v18, v3_1);
    }

    public final long displacement-F1C5BW0$foundation() {
        long v0 = this.pointerPosition;
        if((0x7FFFFFFF7FFFFFFFL & v0) != 0x7FC000007FC00000L) {
        }
        else {
            v0 = SizeKt.getCenter-uvyYCjk(this.containerSize);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(this.containerSize & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0 >> 0x20))) / Float.intBitsToFloat(((int)(this.containerSize >> 0x20)))))) << 0x20);
    }

    public final boolean getInvalidationEnabled$foundation() {
        return this.invalidationEnabled;
    }

    public static void getInvalidationEnabled$foundation$annotations() {
    }

    public DelegatableNode getNode() {
        return this.node;
    }

    public final MutableState getRedrawSignal$foundation() {
        return this.redrawSignal;
    }

    public final void invalidateOverscroll$foundation() {
        if(this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    public boolean isInProgress() {
        EdgeEffectWrapper v4 = this.edgeEffectWrapper;
        EdgeEffect v0 = EdgeEffectWrapper.access$getTopEffect$p(v4);
        if(v0 != null) {
            if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v0) == 0f) {
            }
            else {
                return 1;
            }
        }

        v0 = EdgeEffectWrapper.access$getBottomEffect$p(v4);
        if(v0 != null) {
            if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v0) == 0f) {
            }
            else {
                return 1;
            }
        }

        v0 = EdgeEffectWrapper.access$getLeftEffect$p(v4);
        if(v0 != null) {
            if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v0) == 0f) {
            }
            else {
                return 1;
            }
        }

        EdgeEffect v4_1 = EdgeEffectWrapper.access$getRightEffect$p(v4);
        if(v4_1 != null) {
            if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v4_1) == 0f) {
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    private final float pullBottom-k-4lQ0M(long arg7) {
        float v0 = Float.intBitsToFloat(((int)(this.displacement-F1C5BW0$foundation() >> 0x20)));
        int v7 = ((int)(arg7 & 0xFFFFFFFFL));
        float v8 = Float.intBitsToFloat(v7) / Float.intBitsToFloat(((int)(this.containerSize & 0xFFFFFFFFL)));
        EdgeEffect v3 = this.edgeEffectWrapper.getOrCreateBottomEffect();
        v8 = -EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v3, -v8, 1f - v0) * Float.intBitsToFloat(((int)(this.containerSize & 0xFFFFFFFFL)));
        if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v3) == 0f) {
            return v8;
        }

        return Float.intBitsToFloat(v7);
    }

    private final float pullLeft-k-4lQ0M(long arg6) {
        float v0 = Float.intBitsToFloat(((int)(this.displacement-F1C5BW0$foundation() & 0xFFFFFFFFL)));
        int v6 = ((int)(arg6 >> 0x20));
        float v7 = Float.intBitsToFloat(v6) / Float.intBitsToFloat(((int)(this.containerSize >> 0x20)));
        EdgeEffect v2 = this.edgeEffectWrapper.getOrCreateLeftEffect();
        v7 = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v2, v7, 1f - v0) * Float.intBitsToFloat(((int)(this.containerSize >> 0x20)));
        if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v2) == 0f) {
            return v7;
        }

        return Float.intBitsToFloat(v6);
    }

    private final float pullRight-k-4lQ0M(long arg6) {
        float v0 = Float.intBitsToFloat(((int)(this.displacement-F1C5BW0$foundation() & 0xFFFFFFFFL)));
        int v6 = ((int)(arg6 >> 0x20));
        float v7 = Float.intBitsToFloat(v6) / Float.intBitsToFloat(((int)(this.containerSize >> 0x20)));
        EdgeEffect v2 = this.edgeEffectWrapper.getOrCreateRightEffect();
        v7 = -EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v2, -v7, v0) * Float.intBitsToFloat(((int)(this.containerSize >> 0x20)));
        if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v2) == 0f) {
            return v7;
        }

        return Float.intBitsToFloat(v6);
    }

    private final float pullTop-k-4lQ0M(long arg7) {
        float v0 = Float.intBitsToFloat(((int)(this.displacement-F1C5BW0$foundation() >> 0x20)));
        int v7 = ((int)(arg7 & 0xFFFFFFFFL));
        float v8 = Float.intBitsToFloat(v7) / Float.intBitsToFloat(((int)(this.containerSize & 0xFFFFFFFFL)));
        EdgeEffect v3 = this.edgeEffectWrapper.getOrCreateTopEffect();
        v8 = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v3, v8, v0) * Float.intBitsToFloat(((int)(this.containerSize & 0xFFFFFFFFL)));
        if(EdgeEffectCompat.INSTANCE.getDistanceCompat(v3) == 0f) {
            return v8;
        }

        return Float.intBitsToFloat(v7);
    }

    private final boolean releaseOppositeOverscroll-k-4lQ0M(long arg11) {
        boolean v0_1;
        int v1 = 0x20;
        if(this.edgeEffectWrapper.isLeftAnimating()) {
            int v0 = ((int)(arg11 >> v1));
            if(Float.intBitsToFloat(v0) < 0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Float.intBitsToFloat(v0));
                v0_1 = this.edgeEffectWrapper.isLeftAnimating();
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v0_1 = false;
        }

        if(this.edgeEffectWrapper.isRightAnimating()) {
            v1 = ((int)(arg11 >> v1));
            if(Float.intBitsToFloat(v1) > 0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Float.intBitsToFloat(v1));
                if(!v0_1) {
                    if(this.edgeEffectWrapper.isRightAnimating()) {
                    }
                    else {
                        v0_1 = false;
                        goto label_40;
                    }
                }

                v0_1 = true;
            }
        }

    label_40:
        long v6 = 0xFFFFFFFFL;
        if(this.edgeEffectWrapper.isTopAnimating()) {
            v1 = ((int)(arg11 & v6));
            if(Float.intBitsToFloat(v1) < 0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Float.intBitsToFloat(v1));
                if(!v0_1) {
                    if(this.edgeEffectWrapper.isTopAnimating()) {
                    }
                    else {
                        v0_1 = false;
                        goto label_61;
                    }
                }

                v0_1 = true;
            }
        }

    label_61:
        if(this.edgeEffectWrapper.isBottomAnimating()) {
            int v11 = ((int)(arg11 & v6));
            if(Float.intBitsToFloat(v11) > 0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Float.intBitsToFloat(v11));
                if(!v0_1) {
                    if(this.edgeEffectWrapper.isBottomAnimating()) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return v0_1;
    }

    public final void setInvalidationEnabled$foundation(boolean arg1) {
        this.invalidationEnabled = arg1;
    }

    public final void updateSize-uvyYCjk$foundation(long arg10) {
        boolean v0 = Size.equals-impl0(this.containerSize, Size.Companion.getZero-NH-jbRc());
        boolean v1 = Size.equals-impl0(arg10, this.containerSize);
        this.containerSize = arg10;
        if(!v1) {
            this.edgeEffectWrapper.updateSize-ozmzZPI(IntSize.constructor-impl((((long)MathKt.roundToInt(Float.intBitsToFloat(((int)(arg10 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)MathKt.roundToInt(Float.intBitsToFloat(((int)(arg10 >> 0x20)))))) << 0x20));
        }

        if(!v0 && !v1) {
            this.animateToReleaseIfNeeded();
        }
    }
}

