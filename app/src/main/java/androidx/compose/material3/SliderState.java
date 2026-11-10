package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 |2\u00020\u0001:\u0001|B=\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010 \u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u0003H\u0002J?\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020#2\'\u0010$\u001A#\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\'\u0012\u0006\u0012\u0004\u0018\u00010(0%¢\u0006\u0002\b)H\u0096@¢\u0006\u0002\u0010*J\u0010\u0010+\u001A\u00020\b2\u0006\u0010,\u001A\u00020\u0003H\u0016J\u001D\u0010`\u001A\u00020\b2\u0006\u0010a\u001A\u00020\u00052\u0006\u0010b\u001A\u00020\u0005H\u0000¢\u0006\u0002\bcJ\u0017\u0010f\u001A\u00020\b2\u0006\u0010g\u001A\u00020hH\u0000¢\u0006\u0004\bi\u0010jJ \u0010v\u001A\u00020\u00032\u0006\u0010w\u001A\u00020\u00032\u0006\u0010x\u001A\u00020\u00032\u0006\u0010y\u001A\u00020\u0003H\u0002J \u0010z\u001A\u00020\u00032\u0006\u0010w\u001A\u00020\u00032\u0006\u0010x\u001A\u00020\u00032\u0006\u0010{\u001A\u00020\u0003H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\"\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R+\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\u0018\"\u0004\b\u001F\u0010\u001AR(\u0010-\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010.X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u00100\"\u0004\b1\u00102R\u001C\u00103\u001A\u0002048GX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00105\"\u0004\b6\u00107R\u0014\u00108\u001A\u000209X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b:\u0010;R+\u0010<\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00058B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b@\u0010A\u001A\u0004\b=\u0010\u000E\"\u0004\b>\u0010?R+\u0010B\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00058B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bE\u0010A\u001A\u0004\bC\u0010\u000E\"\u0004\bD\u0010?R\u001A\u0010F\u001A\u000204X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bG\u00105\"\u0004\bH\u00107R+\u0010I\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00058@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bL\u0010A\u001A\u0004\bJ\u0010\u000E\"\u0004\bK\u0010?R+\u0010M\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00058@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bP\u0010A\u001A\u0004\bN\u0010\u000E\"\u0004\bO\u0010?R\u001A\u0010Q\u001A\u00020RX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001A\u0010W\u001A\u000204X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bX\u00105\"\u0004\bY\u00107R\u0011\u0010Z\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b[\u0010\u0018R+\u0010\\\u001A\u0002042\u0006\u0010\u0015\u001A\u0002048F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\b\\\u00105\"\u0004\b]\u00107R\u001A\u0010d\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\be\u0010\u0010R+\u0010k\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bn\u0010\u001C\u001A\u0004\bl\u0010\u0018\"\u0004\bm\u0010\u001AR+\u0010o\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\br\u0010\u001C\u001A\u0004\bp\u0010\u0018\"\u0004\bq\u0010\u001AR\u000E\u0010s\u001A\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010t\u001A\u00020uX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2={"Landroidx/compose/material3/SliderState;", "Landroidx/compose/foundation/gestures/DraggableState;", "value", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "<init>", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "getSteps", "()I", "getOnValueChangeFinished", "()Lkotlin/jvm/functions/Function0;", "setOnValueChangeFinished", "(Lkotlin/jvm/functions/Function0;)V", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "<set-?>", "valueState", "getValueState", "()F", "setValueState", "(F)V", "valueState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newVal", "getValue", "setValue", "calculateSnappedValue", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "onValueChange", "Lkotlin/Function1;", "getOnValueChange", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange", "(Lkotlin/jvm/functions/Function1;)V", "shouldAutoSnap", "", "()Z", "setShouldAutoSnap", "(Z)V", "tickFractions", "", "getTickFractions$material3", "()[F", "totalWidth", "getTotalWidth", "setTotalWidth", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "totalHeight", "getTotalHeight", "setTotalHeight", "totalHeight$delegate", "isRtl", "isRtl$material3", "setRtl$material3", "thumbWidth", "getThumbWidth$material3", "setThumbWidth$material3", "thumbWidth$delegate", "thumbHeight", "getThumbHeight$material3", "setThumbHeight$material3", "thumbHeight$delegate", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation$material3", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation$material3", "(Landroidx/compose/foundation/gestures/Orientation;)V", "reverseVerticalDirection", "getReverseVerticalDirection$material3", "setReverseVerticalDirection$material3", "coercedValueAsFraction", "getCoercedValueAsFraction", "isDragging", "setDragging", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "updateDimensions", "newTotalWidth", "newTotalHeight", "updateDimensions$material3", "gestureEndAction", "getGestureEndAction$material3", "onPress", "pos", "Landroidx/compose/ui/geometry/Offset;", "onPress-k-4lQ0M$material3", "(J)V", "rawOffset", "getRawOffset", "setRawOffset", "rawOffset$delegate", "pressOffset", "getPressOffset", "setPressOffset", "pressOffset$delegate", "dragScope", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "scaleToUserValue", "minPx", "maxPx", "offset", "scaleToOffset", "userValue", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SliderState implements DraggableState {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¨\u0006\r"}, d2={"Landroidx/compose/material3/SliderState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SliderState;", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(Function0 arg2, ClosedFloatingPointRange arg3) {
            return ListSaverKt.listSaver(new SliderState$Companion$$ExternalSyntheticLambda0(), new SliderState$Companion$$ExternalSyntheticLambda1(arg2, arg3));
        }

        static final List Saver$lambda$0(SaverScope arg0, SliderState arg1) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(arg1.getValue()), Integer.valueOf(arg1.getSteps())});
        }

        static final SliderState Saver$lambda$1(Function0 arg3, ClosedFloatingPointRange arg4, List arg5) {
            Object v1 = arg5.get(0);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Float");
            float v1_1 = ((Float)v1).floatValue();
            Object v5 = arg5.get(1);
            Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlin.Int");
            return new SliderState(v1_1, ((Integer)v5).intValue(), arg3, arg4);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final DragScope dragScope;
    private final Function0 gestureEndAction;
    private final MutableState isDragging$delegate;
    private boolean isRtl;
    private Function1 onValueChange;
    private Function0 onValueChangeFinished;
    private Orientation orientation;
    private final MutableFloatState pressOffset$delegate;
    private final MutableFloatState rawOffset$delegate;
    private boolean reverseVerticalDirection;
    private final MutatorMutex scrollMutex;
    private boolean shouldAutoSnap;
    private final int steps;
    private final MutableIntState thumbHeight$delegate;
    private final MutableIntState thumbWidth$delegate;
    private final float[] tickFractions;
    private final MutableIntState totalHeight$delegate;
    private final MutableIntState totalWidth$delegate;
    private final ClosedFloatingPointRange valueRange;
    private final MutableFloatState valueState$delegate;

    static {
        SliderState.Companion = new Companion(null);
        SliderState.$stable = 8;
    }

    public SliderState(float arg1, int arg2, Function0 arg3, ClosedFloatingPointRange arg4) {
        super();
        this.steps = arg2;
        this.onValueChangeFinished = arg3;
        this.valueRange = arg4;
        this.valueState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg1);
        this.shouldAutoSnap = true;
        this.tickFractions = SliderKt.stepsToTickFractions(arg2);
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.totalHeight$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.thumbWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.thumbHeight$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.orientation = Orientation.Horizontal;
        this.isDragging$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.gestureEndAction = new SliderState$$ExternalSyntheticLambda0(this);
        this.rawOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(this.scaleToOffset(0f, 0f, arg1));
        this.pressOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.dragScope = new SliderState$dragScope$1(this);
        this.scrollMutex = new MutatorMutex();
    }

    public SliderState() {
        this(0f, 0, null, null, 15, null);
    }

    public SliderState(float arg2, int arg3, Function0 arg4, ClosedFloatingPointRange arg5, int arg6, DefaultConstructorMarker arg7) {
        if((arg6 & 4) != 0) {
            arg4 = null;
        }

        if((arg6 & 8) != 0) {
            arg5 = RangesKt.rangeTo(0f, 1f);
        }

        this(0f, 0, arg4, arg5);
    }

    public static final DragScope access$getDragScope$p(SliderState arg0) {
        return arg0.dragScope;
    }

    public static final MutatorMutex access$getScrollMutex$p(SliderState arg0) {
        return arg0.scrollMutex;
    }

    public static final void access$setDragging(SliderState arg0, boolean arg1) {
        arg0.setDragging(arg1);
    }

    private final float calculateSnappedValue(float arg3) {
        return SliderKt.snapValueToTick(RangesKt.coerceIn(arg3, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    public void dispatchRawDelta(float arg5) {
        float v1;
        float v0;
        float v3 = 2f;
        if(this.orientation == Orientation.Vertical) {
            v0 = Math.max((((float)this.getTotalHeight())) - (((float)this.getThumbHeight$material3())) / v3, 0f);
            v1 = Math.min((((float)this.getThumbHeight$material3())) / v3, v0);
        }
        else {
            v0 = Math.max((((float)this.getTotalWidth())) - (((float)this.getThumbWidth$material3())) / v3, 0f);
            v1 = Math.min((((float)this.getThumbWidth$material3())) / v3, v0);
        }

        this.setRawOffset(this.getRawOffset() + arg5 + this.getPressOffset());
        this.setPressOffset(0f);
        arg5 = this.scaleToUserValue(v1, v0, SliderKt.snapValueToTick(this.getRawOffset(), this.tickFractions, v1, v0));
        if(arg5 == this.getValue()) {
            return;
        }

        Function1 v0_1 = this.onValueChange;
        if(v0_1 != null) {
            if(v0_1 != null) {
                v0_1.invoke(Float.valueOf(arg5));
            }

            return;
        }

        this.setValue(arg5);
    }

    public Object drag(MutatePriority arg3, Function2 arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new SliderState$drag$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final Unit gestureEndAction$lambda$1(SliderState arg1) {
        if(!arg1.isDragging()) {
            Function0 v1 = arg1.onValueChangeFinished;
            if(v1 != null) {
                v1.invoke();
            }
        }

        return Unit.INSTANCE;
    }

    public final float getCoercedValueAsFraction() {
        return SliderKt.calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(this.getValue(), this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    public final Function0 getGestureEndAction$material3() {
        return this.gestureEndAction;
    }

    public final Function1 getOnValueChange() {
        return this.onValueChange;
    }

    public final Function0 getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final Orientation getOrientation$material3() {
        return this.orientation;
    }

    private final float getPressOffset() {
        return this.pressOffset$delegate.getFloatValue();
    }

    private final float getRawOffset() {
        return this.rawOffset$delegate.getFloatValue();
    }

    public final boolean getReverseVerticalDirection$material3() {
        return this.reverseVerticalDirection;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final int getThumbHeight$material3() {
        return this.thumbHeight$delegate.getIntValue();
    }

    public final int getThumbWidth$material3() {
        return this.thumbWidth$delegate.getIntValue();
    }

    public final float[] getTickFractions$material3() {
        return this.tickFractions;
    }

    private final int getTotalHeight() {
        return this.totalHeight$delegate.getIntValue();
    }

    private final int getTotalWidth() {
        return this.totalWidth$delegate.getIntValue();
    }

    public final float getValue() {
        return this.getValueState();
    }

    public final ClosedFloatingPointRange getValueRange() {
        return this.valueRange;
    }

    private final float getValueState() {
        return this.valueState$delegate.getFloatValue();
    }

    public final boolean isDragging() {
        return this.isDragging$delegate.getValue().booleanValue();
    }

    public final boolean isRtl$material3() {
        return this.isRtl;
    }

    public final void onPress-k-4lQ0M$material3(long arg4) {
        float v4;
        float v0;
        if(this.orientation == Orientation.Vertical) {
            long v1 = 0xFFFFFFFFL;
            if(this.reverseVerticalDirection) {
                v0 = ((float)this.getTotalHeight());
                v4 = Float.intBitsToFloat(((int)(arg4 & v1)));
                goto label_24;
            }
            else {
                v0 = Float.intBitsToFloat(((int)(arg4 & v1)));
            }
        }
        else {
            int v1_1 = 0x20;
            if(this.isRtl) {
                v0 = ((float)this.getTotalWidth());
                v4 = Float.intBitsToFloat(((int)(arg4 >> v1_1)));
            label_24:
                v0 -= v4;
            }
            else {
                v0 = Float.intBitsToFloat(((int)(arg4 >> v1_1)));
            }
        }

        this.setPressOffset(v0 - this.getRawOffset());
    }

    private final float scaleToOffset(float arg2, float arg3, float arg4) {
        return SliderKt.scale(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), arg4, arg2, arg3);
    }

    private final float scaleToUserValue(float arg2, float arg3, float arg4) {
        return SliderKt.scale(arg2, arg3, arg4, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    private final void setDragging(boolean arg1) {
        this.isDragging$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setOnValueChange(Function1 arg1) {
        this.onValueChange = arg1;
    }

    public final void setOnValueChangeFinished(Function0 arg1) {
        this.onValueChangeFinished = arg1;
    }

    public final void setOrientation$material3(Orientation arg1) {
        this.orientation = arg1;
    }

    private final void setPressOffset(float arg1) {
        this.pressOffset$delegate.setFloatValue(arg1);
    }

    private final void setRawOffset(float arg1) {
        this.rawOffset$delegate.setFloatValue(arg1);
    }

    public final void setReverseVerticalDirection$material3(boolean arg1) {
        this.reverseVerticalDirection = arg1;
    }

    public final void setRtl$material3(boolean arg1) {
        this.isRtl = arg1;
    }

    public final void setShouldAutoSnap(boolean arg1) {
        this.shouldAutoSnap = arg1;
    }

    public final void setThumbHeight$material3(int arg1) {
        this.thumbHeight$delegate.setIntValue(arg1);
    }

    public final void setThumbWidth$material3(int arg1) {
        this.thumbWidth$delegate.setIntValue(arg1);
    }

    private final void setTotalHeight(int arg1) {
        this.totalHeight$delegate.setIntValue(arg1);
    }

    private final void setTotalWidth(int arg1) {
        this.totalWidth$delegate.setIntValue(arg1);
    }

    public final void setValue(float arg2) {
        if(this.shouldAutoSnap) {
            arg2 = this.calculateSnappedValue(arg2);
        }

        this.setValueState(arg2);
    }

    private final void setValueState(float arg1) {
        this.valueState$delegate.setFloatValue(arg1);
    }

    public final boolean shouldAutoSnap() {
        return this.shouldAutoSnap;
    }

    public final void updateDimensions$material3(int arg1, int arg2) {
        this.setTotalWidth(arg1);
        this.setTotalHeight(arg2);
    }
}

