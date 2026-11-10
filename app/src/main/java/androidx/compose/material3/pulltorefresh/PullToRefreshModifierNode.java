package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u00108\u001A\u00020\u0007H\u0016J\u001F\u00109\u001A\u00020:2\u0006\u0010;\u001A\u00020:2\u0006\u0010<\u001A\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\'\u0010@\u001A\u00020:2\u0006\u0010A\u001A\u00020:2\u0006\u0010;\u001A\u00020:2\u0006\u0010<\u001A\u00020=H\u0016¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001A\u00020E2\u0006\u0010;\u001A\u00020EH\u0096@¢\u0006\u0004\bF\u0010GJ\u0006\u0010H\u001A\u00020\u0007J\u0017\u0010I\u001A\u00020:2\u0006\u0010;\u001A\u00020:H\u0002¢\u0006\u0004\bJ\u0010KJ\u0016\u0010L\u001A\u00020&2\u0006\u0010M\u001A\u00020&H\u0082@¢\u0006\u0002\u0010NJ\b\u0010O\u001A\u00020&H\u0002J\u000E\u0010P\u001A\u00020\u0007H\u0082@¢\u0006\u0002\u0010QJ\u000E\u0010R\u001A\u00020\u0007H\u0082@¢\u0006\u0002\u0010QR\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0003\u0010\u000F\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\b\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0011R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001C\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u0010\n\u0002\u0010 \u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0014\u0010!\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u000FR\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\'\u001A\u00020&2\u0006\u0010%\u001A\u00020&8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b(\u0010\u001D\"\u0004\b)\u0010\u001FR+\u0010,\u001A\u00020&2\u0006\u0010%\u001A\u00020&8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b/\u0010+\u001A\u0004\b-\u0010\u001D\"\u0004\b.\u0010\u001FR\u0014\u00100\u001A\u00020&8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b1\u0010\u001DR\u0014\u00102\u001A\u0002038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b4\u00105R\u0014\u00106\u001A\u00020&8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b7\u0010\u001D¨\u0006S"}, d2={"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "setRefreshing", "(Z)V", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "setOnRefresh", "(Lkotlin/jvm/functions/Function0;)V", "getEnabled", "setEnabled", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "getThreshold-D9Ej5fM", "()F", "setThreshold-0680j_4", "(F)V", "F", "shouldAutoInvalidate", "getShouldAutoInvalidate", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<set-?>", "", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "thresholdPx", "", "getThresholdPx", "()I", "progress", "getProgress", "onAttach", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "consumeAvailableOffset", "consumeAvailableOffset-MK-Hz9U", "(J)J", "onRelease", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateVerticalOffset", "animateToThreshold", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToHidden", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PullToRefreshModifierNode extends DelegatingNode implements NestedScrollConnection {
    public static final int $stable = 8;
    private final MutableFloatState distancePulled$delegate;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private Function0 onRefresh;
    private PullToRefreshState state;
    private float threshold;
    private final MutableFloatState verticalOffset$delegate;

    static {
    }

    public PullToRefreshModifierNode(boolean arg1, Function0 arg2, boolean arg3, PullToRefreshState arg4, float arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private PullToRefreshModifierNode(boolean arg1, Function0 arg2, boolean arg3, PullToRefreshState arg4, float arg5) {
        super();
        this.isRefreshing = arg1;
        this.onRefresh = arg2;
        this.enabled = arg3;
        this.state = arg4;
        this.threshold = arg5;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode(this, null);
        this.verticalOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
    }

    public static final Object access$animateToHidden(PullToRefreshModifierNode arg0, Continuation arg1) {
        return arg0.animateToHidden(arg1);
    }

    public static final Object access$animateToThreshold(PullToRefreshModifierNode arg0, Continuation arg1) {
        return arg0.animateToThreshold(arg1);
    }

    public static final int access$getThresholdPx(PullToRefreshModifierNode arg0) {
        return arg0.getThresholdPx();
    }

    public static final float access$getVerticalOffset(PullToRefreshModifierNode arg0) {
        return arg0.getVerticalOffset();
    }

    public static final Object access$onRelease(PullToRefreshModifierNode arg0, float arg1, Continuation arg2) {
        return arg0.onRelease(arg1, arg2);
    }

    private final Object animateToHidden(Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof PullToRefreshModifierNode$animateToHidden$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((PullToRefreshModifierNode$animateToHidden$1)v0).label & v2) != 0) {
                ((PullToRefreshModifierNode$animateToHidden$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PullToRefreshModifierNode$animateToHidden$1 v0_1 = new PullToRefreshModifierNode$animateToHidden$1(this, arg6);
        }

        Object v6 = ((PullToRefreshModifierNode$animateToHidden$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PullToRefreshModifierNode$animateToHidden$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            try {
                PullToRefreshState v6_2 = this.state;
                ((PullToRefreshModifierNode$animateToHidden$1)v0).label = 1;
                if(v6_2.animateToHidden(v0) != v1) {
                    goto label_34;
                }
            }
            catch(Throwable v6_1) {
            label_38:
                this.setDistancePulled(0f);
                this.setVerticalOffset(0f);
                throw v6_1;
            }

            return v1;
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v6_1) {
                goto label_38;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_34:
        this.setDistancePulled(0f);
        this.setVerticalOffset(0f);
        return Unit.INSTANCE;
    }

    private final Object animateToThreshold(Continuation arg5) {
        PullToRefreshModifierNode$animateToThreshold$1 v0_1;
        int v2;
        if((arg5 instanceof PullToRefreshModifierNode$animateToThreshold$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((PullToRefreshModifierNode$animateToThreshold$1)v0).label & v2) != 0) {
                ((PullToRefreshModifierNode$animateToThreshold$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new PullToRefreshModifierNode$animateToThreshold$1(this, arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            try {
                PullToRefreshState v5_2 = this.state;
                v0_1.label = 1;
                if(v5_2.animateToThreshold(((Continuation)v0_1)) != v1) {
                    goto label_33;
                }
            }
            catch(Throwable v5_1) {
            label_43:
                if(this.isAttached()) {
                    this.setDistancePulled(((float)this.getThresholdPx()));
                    this.setVerticalOffset(((float)this.getThresholdPx()));
                }

                throw v5_1;
            }

            return v1;
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v5);
            }
            catch(Throwable v5_1) {
                goto label_43;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        if(this.isAttached()) {
            this.setDistancePulled(((float)this.getThresholdPx()));
            this.setVerticalOffset(((float)this.getThresholdPx()));
        }

        return Unit.INSTANCE;
    }

    private final float calculateVerticalOffset() {
        if(this.getAdjustedDistancePulled() <= (((float)this.getThresholdPx()))) {
            return this.getAdjustedDistancePulled();
        }

        float v0 = RangesKt.coerceIn(Math.abs(this.getProgress()) - 1f, 0f, 2f);
        return (((float)this.getThresholdPx())) + (((float)this.getThresholdPx())) * (v0 - (((float)Math.pow(((double)v0), 2))) / 4f);
    }

    private final long consumeAvailableOffset-MK-Hz9U(long arg6) {
        float v7;
        long v1 = 0xFFFFFFFFL;
        if(this.isRefreshing) {
            v7 = 0f;
        }
        else {
            float v6 = RangesKt.coerceAtLeast(this.getDistancePulled() + Float.intBitsToFloat(((int)(arg6 & v1))), 0f);
            v7 = v6 - this.getDistancePulled();
            this.setDistancePulled(v6);
            this.setVerticalOffset(this.calculateVerticalOffset());
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(v7))) & v1);
    }

    private final float getAdjustedDistancePulled() {
        return this.getDistancePulled() * 0.5f;
    }

    private final float getDistancePulled() {
        return this.distancePulled$delegate.getFloatValue();
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0 getOnRefresh() {
        return this.onRefresh;
    }

    private final float getProgress() {
        return this.getAdjustedDistancePulled() / (((float)this.getThresholdPx()));
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    public final float getThreshold-D9Ej5fM() {
        return this.threshold;
    }

    private final int getThresholdPx() {
        return DelegatableNodeKt.requireDensity(this).roundToPx-0680j_4(this.threshold);
    }

    private final float getVerticalOffset() {
        return this.verticalOffset$delegate.getFloatValue();
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public void onAttach() {
        this.delegate(this.nestedScrollNode);
        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new PullToRefreshModifierNode$onAttach$1(this, null), 3, null);
        float v0 = this.isRefreshing ? ((float)this.getThresholdPx()) : 0f;
        this.setVerticalOffset(v0);
    }

    public long onPostScroll-DzOQY0M(long arg7, long arg9, int arg11) {
        if(this.state.isAnimating()) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        if(!this.enabled) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        if(NestedScrollSource.equals-impl0(arg11, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
            arg7 = this.consumeAvailableOffset-MK-Hz9U(arg9);
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new PullToRefreshModifierNode$onPostScroll$1(this, null), 3, null);
            return arg7;
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public Object onPreFling-QWom1Mo(long arg5, Continuation arg7) {
        float v4;
        PullToRefreshModifierNode$onPreFling$1 v0_1;
        int v2;
        if((arg7 instanceof PullToRefreshModifierNode$onPreFling$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((PullToRefreshModifierNode$onPreFling$1)v0).label & v2) != 0) {
                ((PullToRefreshModifierNode$onPreFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new PullToRefreshModifierNode$onPreFling$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            float v5 = Velocity.getY-impl(arg5);
            v0_1.F$0 = 0f;
            v0_1.label = 1;
            v7 = this.onRelease(v5, ((Continuation)v0_1));
            if(v7 == v1) {
                return v1;
            }
            else {
                v4 = 0f;
            }
        }
        else if(v2 == 1) {
            v4 = v0_1.F$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Velocity.box-impl(VelocityKt.Velocity(v4, ((Number)v7).floatValue()));
    }

    public long onPreScroll-OzD1aCk(long arg3, int arg5) {
        if(this.state.isAnimating()) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        if(!this.enabled) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        if((NestedScrollSource.equals-impl0(arg5, NestedScrollSource.Companion.getUserInput-WNlRxjI())) && Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg3))) < 0f) {
            return this.consumeAvailableOffset-MK-Hz9U(arg3);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    private final Object onRelease(float arg6, Continuation arg7) {
        PullToRefreshModifierNode$onRelease$1 v0_1;
        int v2;
        if((arg7 instanceof PullToRefreshModifierNode$onRelease$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((PullToRefreshModifierNode$onRelease$1)v0).label & v2) != 0) {
                ((PullToRefreshModifierNode$onRelease$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new PullToRefreshModifierNode$onRelease$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            if(this.isRefreshing) {
                return Boxing.boxFloat(0f);
            }
            else {
                if(this.getAdjustedDistancePulled() > (((float)this.getThresholdPx()))) {
                    this.onRefresh.invoke();
                }

                if(this.getDistancePulled() == 0f || arg6 < 0f) {
                    arg6 = 0f;
                }

                v0_1.F$0 = 0f;
                v0_1.label = 1;
                if(this.animateToHidden(((Continuation)v0_1)) != v1) {
                    goto label_49;
                }

                return v1;
            }
        }
        else if(v2 == 1) {
            arg6 = v0_1.F$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_49:
        this.setDistancePulled(0f);
        return Boxing.boxFloat(arg6);
    }

    private final void setDistancePulled(float arg1) {
        this.distancePulled$delegate.setFloatValue(arg1);
    }

    public final void setEnabled(boolean arg1) {
        this.enabled = arg1;
    }

    public final void setOnRefresh(Function0 arg1) {
        this.onRefresh = arg1;
    }

    public final void setRefreshing(boolean arg1) {
        this.isRefreshing = arg1;
    }

    public final void setState(PullToRefreshState arg1) {
        this.state = arg1;
    }

    public final void setThreshold-0680j_4(float arg1) {
        this.threshold = arg1;
    }

    private final void setVerticalOffset(float arg1) {
        this.verticalOffset$delegate.setFloatValue(arg1);
    }

    public final void update() {
        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new PullToRefreshModifierNode$update$1(this, null), 3, null);
    }
}

