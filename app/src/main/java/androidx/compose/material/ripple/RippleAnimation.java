package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010!\u001A\u00020\u0014H\u0086@¢\u0006\u0002\u0010\"J\u000E\u0010#\u001A\u00020\u0014H\u0082@¢\u0006\u0002\u0010\"J\u000E\u0010$\u001A\u00020\u0014H\u0082@¢\u0006\u0002\u0010\"J\u0006\u0010%\u001A\u00020\u0014J\u0019\u0010&\u001A\u00020\u0014*\u00020\'2\u0006\u0010(\u001A\u00020)¢\u0006\u0004\b*\u0010+R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\f\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00078B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR+\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00078B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b \u0010\u001C\u001A\u0004\b\u001E\u0010\u0018\"\u0004\b\u001F\u0010\u001A¨\u0006,"}, d2={"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "", "bounded", "", "<init>", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "startRadius", "Ljava/lang/Float;", "targetCenter", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedRadiusPercent", "animatedCenterPercent", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "<set-?>", "finishedFadingIn", "getFinishedFadingIn", "()Z", "setFinishedFadingIn", "(Z)V", "finishedFadingIn$delegate", "Landroidx/compose/runtime/MutableState;", "finishRequested", "getFinishRequested", "setFinishRequested", "finishRequested$delegate", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RippleAnimation {
    public static final int $stable = 8;
    private final Animatable animatedAlpha;
    private final Animatable animatedCenterPercent;
    private final Animatable animatedRadiusPercent;
    private final boolean bounded;
    private final MutableState finishRequested$delegate;
    private final CompletableDeferred finishSignalDeferred;
    private final MutableState finishedFadingIn$delegate;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;

    static {
    }

    public RippleAnimation(Offset arg1, float arg2, boolean arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private RippleAnimation(Offset arg2, float arg3, boolean arg4) {
        super();
        this.origin = arg2;
        this.radius = arg3;
        this.bounded = arg4;
        this.animatedAlpha = AnimatableKt.Animatable$default(0f, 0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0f, 0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0f, 0f, 2, null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred(null);
        Boolean v2 = Boolean.valueOf(false);
        this.finishedFadingIn$delegate = SnapshotStateKt.mutableStateOf$default(v2, null, 2, null);
        this.finishRequested$delegate = SnapshotStateKt.mutableStateOf$default(v2, null, 2, null);
    }

    public static final Object access$fadeIn(RippleAnimation arg0, Continuation arg1) {
        return arg0.fadeIn(arg1);
    }

    public static final Object access$fadeOut(RippleAnimation arg0, Continuation arg1) {
        return arg0.fadeOut(arg1);
    }

    public static final Animatable access$getAnimatedAlpha$p(RippleAnimation arg0) {
        return arg0.animatedAlpha;
    }

    public static final Animatable access$getAnimatedCenterPercent$p(RippleAnimation arg0) {
        return arg0.animatedCenterPercent;
    }

    public static final Animatable access$getAnimatedRadiusPercent$p(RippleAnimation arg0) {
        return arg0.animatedRadiusPercent;
    }

    public final Object animate(Continuation arg7) {
        RippleAnimation$animate$1 v0_1;
        int v2;
        if((arg7 instanceof RippleAnimation$animate$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((RippleAnimation$animate$1)v0).label & v2) != 0) {
                ((RippleAnimation$animate$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new RippleAnimation$animate$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 3;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            v0_1.label = 1;
            if(this.fadeIn(((Continuation)v0_1)) == v1) {
                return v1;
            }
            else {
            label_38:
                this.setFinishedFadingIn(true);
                CompletableDeferred v7_1 = this.finishSignalDeferred;
                v0_1.label = v4;
                if(v7_1.await(((Continuation)v0_1)) == v1) {
                    return v1;
                }
                else {
                label_44:
                    v0_1.label = v3;
                    if(this.fadeOut(((Continuation)v0_1)) == v1) {
                        return v1;
                    }
                }
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v7);
            goto label_38;
        }
        else if(v2 == v4) {
            ResultKt.throwOnFailure(v7);
            goto label_44;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public final void draw-4WTKRHQ(DrawScope arg20, long arg21) {
        RippleAnimation v0 = this;
        if(v0.startRadius == null) {
            v0.startRadius = Float.valueOf(RippleAnimationKt.getRippleStartRadius-uvyYCjk(arg20.getSize-NH-jbRc()));
        }

        if(v0.origin == null) {
            v0.origin = Offset.box-impl(arg20.getCenter-F1C5BW0());
        }

        if(v0.targetCenter == null) {
            v0.targetCenter = Offset.box-impl(OffsetKt.Offset(Size.getWidth-impl(arg20.getSize-NH-jbRc()) / 2f, Size.getHeight-impl(arg20.getSize-NH-jbRc()) / 2f));
        }

        float v1 = !v0.getFinishRequested() || (v0.getFinishedFadingIn()) ? v0.animatedAlpha.getValue().floatValue() : 1f;
        Float v2 = v0.startRadius;
        Intrinsics.checkNotNull(v2);
        float v8 = MathHelpersKt.lerp(v2.floatValue(), v0.radius, v0.animatedRadiusPercent.getValue().floatValue());
        Offset v2_1 = v0.origin;
        Intrinsics.checkNotNull(v2_1);
        float v2_2 = Offset.getX-impl(v2_1.unbox-impl());
        Offset v3 = v0.targetCenter;
        Intrinsics.checkNotNull(v3);
        v2_2 = MathHelpersKt.lerp(v2_2, Offset.getX-impl(v3.unbox-impl()), v0.animatedCenterPercent.getValue().floatValue());
        v3 = v0.origin;
        Intrinsics.checkNotNull(v3);
        float v3_1 = Offset.getY-impl(v3.unbox-impl());
        Offset v4 = v0.targetCenter;
        Intrinsics.checkNotNull(v4);
        long v9 = OffsetKt.Offset(v2_2, MathHelpersKt.lerp(v3_1, Offset.getY-impl(v4.unbox-impl()), v0.animatedCenterPercent.getValue().floatValue()));
        long v6 = Color.copy-wmQWz5c$default(arg21, Color.getAlpha-impl(arg21) * v1, 0f, 0f, 0f, 14, null);
        if(v0.bounded) {
            float v14 = Size.getWidth-impl(arg20.getSize-NH-jbRc());
            float v15 = Size.getHeight-impl(arg20.getSize-NH-jbRc());
            int v16 = ClipOp.Companion.getIntersect-rtfAjoo();
            DrawContext v1_1 = arg20.getDrawContext();
            long v2_3 = v1_1.getSize-NH-jbRc();
            v1_1.getCanvas().save();
            try {
                v1_1.getTransform().clipRect-N_I0leg(0f, 0f, v14, v15, v16);
                DrawScope.drawCircle-VaOC9Bg$default(arg20, v6, v8, v9, 0f, null, null, 0, 120, null);
            }
            catch(Throwable v0_1) {
                v1_1.getCanvas().restore();
                v1_1.setSize-uvyYCjk(v2_3);
                throw v0_1;
            }

            v1_1.getCanvas().restore();
            v1_1.setSize-uvyYCjk(v2_3);
            return;
        }

        DrawScope.drawCircle-VaOC9Bg$default(arg20, v6, v8, v9, 0f, null, null, 0, 120, null);
    }

    private final Object fadeIn(Continuation arg3) {
        Object v2 = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeIn$2(this, null), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    private final Object fadeOut(Continuation arg3) {
        Object v2 = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeOut$2(this, null), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final void finish() {
        this.setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    private final boolean getFinishRequested() {
        return this.finishRequested$delegate.getValue().booleanValue();
    }

    private final boolean getFinishedFadingIn() {
        return this.finishedFadingIn$delegate.getValue().booleanValue();
    }

    private final void setFinishRequested(boolean arg1) {
        this.finishRequested$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setFinishedFadingIn(boolean arg1) {
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(arg1));
    }
}

