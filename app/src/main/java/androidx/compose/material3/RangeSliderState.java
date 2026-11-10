package androidx.compose.material3;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b \n\u0002\u0010\u000B\n\u0002\b*\b\u0007\u0018\u0000 y2\u00020\u0001:\u0001yBG\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001A\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010f\u001A\u00020\t2\u0006\u0010g\u001A\u00020P2\u0006\u0010h\u001A\u00020\u0003H\u0000¢\u0006\u0002\biJ/\u0010r\u001A\u00020)2\u0006\u0010g\u001A\u00020P2\u0006\u0010b\u001A\u00020\u00032\u0006\u0010^\u001A\u00020\u00032\u0006\u0010h\u001A\u00020)H\u0002¢\u0006\u0004\bs\u0010tJ \u0010u\u001A\u00020\u00032\u0006\u0010b\u001A\u00020\u00032\u0006\u0010^\u001A\u00020\u00032\u0006\u0010v\u001A\u00020\u0003H\u0002J\r\u0010w\u001A\u00020\tH\u0000¢\u0006\u0002\bxR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\"\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR+\u0010\u001E\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001D\u001A\u0004\b\u001F\u0010\u0019\"\u0004\b \u0010\u001BR$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001BR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001BR(\u0010\'\u001A\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t\u0018\u00010(X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b0\u00101R+\u00102\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b5\u0010\u001D\u001A\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001BR+\u00106\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b9\u0010\u001D\u001A\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001BR+\u0010:\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b=\u0010\u001D\u001A\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001BR+\u0010>\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bA\u0010\u001D\u001A\u0004\b?\u0010\u0019\"\u0004\b@\u0010\u001BR+\u0010B\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00068@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bF\u0010G\u001A\u0004\bC\u0010\u000F\"\u0004\bD\u0010ER+\u0010H\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bK\u0010\u001D\u001A\u0004\bI\u0010\u0019\"\u0004\bJ\u0010\u001BR+\u0010L\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bO\u0010\u001D\u001A\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001BR+\u0010Q\u001A\u00020P2\u0006\u0010\u0016\u001A\u00020P8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bV\u0010W\u001A\u0004\bR\u0010S\"\u0004\bT\u0010UR+\u0010X\u001A\u00020P2\u0006\u0010\u0016\u001A\u00020P8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b[\u0010W\u001A\u0004\bY\u0010S\"\u0004\bZ\u0010UR \u0010\\\u001A\u000E\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\t0(X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b]\u0010+R+\u0010^\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\ba\u0010\u001D\u001A\u0004\b_\u0010\u0019\"\u0004\b`\u0010\u001BR+\u0010b\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\be\u0010\u001D\u001A\u0004\bc\u0010\u0019\"\u0004\bd\u0010\u001BR\u0014\u0010j\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bk\u0010\u0019R\u0014\u0010l\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bm\u0010\u0019R\u0014\u0010n\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bo\u0010\u000FR\u0014\u0010p\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bq\u0010\u000F¨\u0006z"}, d2={"Landroidx/compose/material3/RangeSliderState;", "", "activeRangeStart", "", "activeRangeEnd", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "<init>", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "getSteps", "()I", "getOnValueChangeFinished", "()Lkotlin/jvm/functions/Function0;", "setOnValueChangeFinished", "(Lkotlin/jvm/functions/Function0;)V", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "<set-?>", "activeRangeStartState", "getActiveRangeStartState", "()F", "setActiveRangeStartState", "(F)V", "activeRangeStartState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "activeRangeEndState", "getActiveRangeEndState", "setActiveRangeEndState", "activeRangeEndState$delegate", "newVal", "getActiveRangeStart", "setActiveRangeStart", "getActiveRangeEnd", "setActiveRangeEnd", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/material3/SliderRange;", "getOnValueChange$material3", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$material3", "(Lkotlin/jvm/functions/Function1;)V", "tickFractions", "", "getTickFractions$material3", "()[F", "startThumbWidth", "getStartThumbWidth$material3", "setStartThumbWidth$material3", "startThumbWidth$delegate", "startThumbHeight", "getStartThumbHeight$material3", "setStartThumbHeight$material3", "startThumbHeight$delegate", "endThumbWidth", "getEndThumbWidth$material3", "setEndThumbWidth$material3", "endThumbWidth$delegate", "endThumbHeight", "getEndThumbHeight$material3", "setEndThumbHeight$material3", "endThumbHeight$delegate", "totalWidth", "getTotalWidth$material3", "setTotalWidth$material3", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "rawOffsetStart", "getRawOffsetStart$material3", "setRawOffsetStart$material3", "rawOffsetStart$delegate", "rawOffsetEnd", "getRawOffsetEnd$material3", "setRawOffsetEnd$material3", "rawOffsetEnd$delegate", "", "isDragging", "isDragging$material3", "()Z", "setDragging$material3", "(Z)V", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "isRtl", "isRtl$material3", "setRtl$material3", "isRtl$delegate", "gestureEndAction", "getGestureEndAction$material3", "maxPx", "getMaxPx", "setMaxPx", "maxPx$delegate", "minPx", "getMinPx", "setMinPx", "minPx$delegate", "onDrag", "isStart", "offset", "onDrag$material3", "coercedActiveRangeStartAsFraction", "getCoercedActiveRangeStartAsFraction$material3", "coercedActiveRangeEndAsFraction", "getCoercedActiveRangeEndAsFraction$material3", "startSteps", "getStartSteps$material3", "endSteps", "getEndSteps$material3", "scaleToUserValue", "scaleToUserValue-8bqG3aw", "(ZFFJ)J", "scaleToOffset", "userValue", "updateMinMaxPx", "updateMinMaxPx$material3", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RangeSliderState {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¨\u0006\r"}, d2={"Landroidx/compose/material3/RangeSliderState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/RangeSliderState;", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(Function0 arg2, ClosedFloatingPointRange arg3) {
            return ListSaverKt.listSaver(new RangeSliderState$Companion$$ExternalSyntheticLambda0(), new RangeSliderState$Companion$$ExternalSyntheticLambda1(arg2, arg3));
        }

        static final List Saver$lambda$0(SaverScope arg1, RangeSliderState arg2) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(arg2.getActiveRangeStart()), Float.valueOf(arg2.getActiveRangeEnd()), Integer.valueOf(arg2.getSteps())});
        }

        static final RangeSliderState Saver$lambda$1(Function0 arg6, ClosedFloatingPointRange arg7, List arg8) {
            Object v1 = arg8.get(0);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Float");
            float v1_1 = ((Float)v1).floatValue();
            Object v3 = arg8.get(1);
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Float");
            float v2 = ((Float)v3).floatValue();
            Object v8 = arg8.get(2);
            Intrinsics.checkNotNull(v8, "null cannot be cast to non-null type kotlin.Int");
            return new RangeSliderState(v1_1, v2, ((Integer)v8).intValue(), arg6, arg7);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final MutableFloatState activeRangeEndState$delegate;
    private final MutableFloatState activeRangeStartState$delegate;
    private final MutableFloatState endThumbHeight$delegate;
    private final MutableFloatState endThumbWidth$delegate;
    private final Function1 gestureEndAction;
    private final MutableState isDragging$delegate;
    private final MutableState isRtl$delegate;
    private final MutableFloatState maxPx$delegate;
    private final MutableFloatState minPx$delegate;
    private Function1 onValueChange;
    private Function0 onValueChangeFinished;
    private final MutableFloatState rawOffsetEnd$delegate;
    private final MutableFloatState rawOffsetStart$delegate;
    private final MutableFloatState startThumbHeight$delegate;
    private final MutableFloatState startThumbWidth$delegate;
    private final int steps;
    private final float[] tickFractions;
    private final MutableIntState totalWidth$delegate;
    private final ClosedFloatingPointRange valueRange;

    static {
        RangeSliderState.Companion = new Companion(null);
        RangeSliderState.$stable = 8;
    }

    public RangeSliderState() {
        this(0f, 0f, 0, null, null, 0x1F, null);
    }

    public RangeSliderState(float arg3, float arg4, int arg5, Function0 arg6, ClosedFloatingPointRange arg7, int arg8, DefaultConstructorMarker arg9) {
        float v1 = 1f;
        if((arg8 & 2) != 0) {
            arg4 = v1;
        }

        if((arg8 & 8) != 0) {
            arg6 = null;
        }

        if((arg8 & 16) != 0) {
            arg7 = RangesKt.rangeTo(0f, v1);
        }

        this(0f, arg4, 0, arg6, arg7);
    }

    public RangeSliderState(float arg1, float arg2, int arg3, Function0 arg4, ClosedFloatingPointRange arg5) {
        super();
        this.steps = arg3;
        this.onValueChangeFinished = arg4;
        this.valueRange = arg5;
        this.activeRangeStartState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg1);
        this.activeRangeEndState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg2);
        this.tickFractions = SliderKt.access$stepsToTickFractions(arg3);
        this.startThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.startThumbHeight$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.endThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.endThumbHeight$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        Boolean v3 = Boolean.valueOf(false);
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.rawOffsetStart$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.rawOffsetEnd$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.isDragging$delegate = SnapshotStateKt.mutableStateOf$default(v3, null, 2, null);
        this.isRtl$delegate = SnapshotStateKt.mutableStateOf$default(v3, null, 2, null);
        this.gestureEndAction = new RangeSliderState$$ExternalSyntheticLambda0(this);
        this.maxPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.minPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
    }

    static final Unit gestureEndAction$lambda$0(RangeSliderState arg0, boolean arg1) {
        Function0 v0 = arg0.onValueChangeFinished;
        if(v0 != null) {
            v0.invoke();
        }

        return Unit.INSTANCE;
    }

    public final float getActiveRangeEnd() {
        return this.getActiveRangeEndState();
    }

    private final float getActiveRangeEndState() {
        return this.activeRangeEndState$delegate.getFloatValue();
    }

    public final float getActiveRangeStart() {
        return this.getActiveRangeStartState();
    }

    private final float getActiveRangeStartState() {
        return this.activeRangeStartState$delegate.getFloatValue();
    }

    public final float getCoercedActiveRangeEndAsFraction$material3() {
        return SliderKt.access$calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), this.getActiveRangeEnd());
    }

    public final float getCoercedActiveRangeStartAsFraction$material3() {
        return SliderKt.access$calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), this.getActiveRangeStart());
    }

    public final int getEndSteps$material3() {
        return ((int)(((float)Math.floor(((double)((((float)this.steps)) * (1f - this.getCoercedActiveRangeStartAsFraction$material3())))))));
    }

    public final float getEndThumbHeight$material3() {
        return this.endThumbHeight$delegate.getFloatValue();
    }

    public final float getEndThumbWidth$material3() {
        return this.endThumbWidth$delegate.getFloatValue();
    }

    public final Function1 getGestureEndAction$material3() {
        return this.gestureEndAction;
    }

    private final float getMaxPx() {
        return this.maxPx$delegate.getFloatValue();
    }

    private final float getMinPx() {
        return this.minPx$delegate.getFloatValue();
    }

    public final Function1 getOnValueChange$material3() {
        return this.onValueChange;
    }

    public final Function0 getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final float getRawOffsetEnd$material3() {
        return this.rawOffsetEnd$delegate.getFloatValue();
    }

    public final float getRawOffsetStart$material3() {
        return this.rawOffsetStart$delegate.getFloatValue();
    }

    public final int getStartSteps$material3() {
        return ((int)(((float)Math.floor(((double)((((float)this.steps)) * this.getCoercedActiveRangeEndAsFraction$material3()))))));
    }

    public final float getStartThumbHeight$material3() {
        return this.startThumbHeight$delegate.getFloatValue();
    }

    public final float getStartThumbWidth$material3() {
        return this.startThumbWidth$delegate.getFloatValue();
    }

    public final int getSteps() {
        return this.steps;
    }

    public final float[] getTickFractions$material3() {
        return this.tickFractions;
    }

    public final int getTotalWidth$material3() {
        return this.totalWidth$delegate.getIntValue();
    }

    public final ClosedFloatingPointRange getValueRange() {
        return this.valueRange;
    }

    public final boolean isDragging$material3() {
        return this.isDragging$delegate.getValue().booleanValue();
    }

    public final boolean isRtl$material3() {
        return this.isRtl$delegate.getValue().booleanValue();
    }

    public final void onDrag$material3(boolean arg9, float arg10) {
        long v0;
        if(arg9) {
            this.setRawOffsetStart$material3(this.getRawOffsetStart$material3() + arg10);
            this.setRawOffsetEnd$material3(this.scaleToOffset(this.getMinPx(), this.getMaxPx(), this.getActiveRangeEnd()));
            arg10 = this.getRawOffsetEnd$material3();
            v0 = SliderKt.SliderRange(RangesKt.coerceAtMost(SliderKt.access$snapValueToTick(RangesKt.coerceIn(this.getRawOffsetStart$material3(), this.getMinPx(), arg10), this.tickFractions, this.getMinPx(), this.getMaxPx()), arg10), arg10);
        }
        else {
            this.setRawOffsetEnd$material3(this.getRawOffsetEnd$material3() + arg10);
            this.setRawOffsetStart$material3(this.scaleToOffset(this.getMinPx(), this.getMaxPx(), this.getActiveRangeStart()));
            arg10 = this.getRawOffsetStart$material3();
            v0 = SliderKt.SliderRange(arg10, RangesKt.coerceAtLeast(SliderKt.access$snapValueToTick(RangesKt.coerceIn(this.getRawOffsetEnd$material3(), arg10, this.getMaxPx()), this.tickFractions, this.getMinPx(), this.getMaxPx()), arg10));
        }

        RangeSliderState v2 = this;
        long v8 = v2.scaleToUserValue-8bqG3aw(arg9, this.getMinPx(), this.getMaxPx(), v0);
        if(!SliderRange.equals-impl0(v8, SliderKt.SliderRange(v2.getActiveRangeStart(), v2.getActiveRangeEnd()))) {
            Function1 v10 = v2.onValueChange;
            if(v10 == null) {
                v2.setActiveRangeStart(SliderRange.getStart-impl(v8));
                v2.setActiveRangeEnd(SliderRange.getEndInclusive-impl(v8));
            }
            else if(v10 != null) {
                v10.invoke(SliderRange.box-impl(v8));
                return;
            }
        }
    }

    private final float scaleToOffset(float arg2, float arg3, float arg4) {
        return SliderKt.access$scale(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), arg4, arg2, arg3);
    }

    private final long scaleToUserValue-8bqG3aw(boolean arg9, float arg10, float arg11, long arg12) {
        return SliderKt.access$scale-2geJ7wY(arg9, arg10, arg11, arg12, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    public final void setActiveRangeEnd(float arg4) {
        this.setActiveRangeEndState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(arg4, this.getActiveRangeStart(), this.valueRange.getEndInclusive().floatValue()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    private final void setActiveRangeEndState(float arg1) {
        this.activeRangeEndState$delegate.setFloatValue(arg1);
    }

    public final void setActiveRangeStart(float arg4) {
        this.setActiveRangeStartState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(arg4, this.valueRange.getStart().floatValue(), this.getActiveRangeEnd()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    private final void setActiveRangeStartState(float arg1) {
        this.activeRangeStartState$delegate.setFloatValue(arg1);
    }

    public final void setDragging$material3(boolean arg1) {
        this.isDragging$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setEndThumbHeight$material3(float arg1) {
        this.endThumbHeight$delegate.setFloatValue(arg1);
    }

    public final void setEndThumbWidth$material3(float arg1) {
        this.endThumbWidth$delegate.setFloatValue(arg1);
    }

    private final void setMaxPx(float arg1) {
        this.maxPx$delegate.setFloatValue(arg1);
    }

    private final void setMinPx(float arg1) {
        this.minPx$delegate.setFloatValue(arg1);
    }

    public final void setOnValueChange$material3(Function1 arg1) {
        this.onValueChange = arg1;
    }

    public final void setOnValueChangeFinished(Function0 arg1) {
        this.onValueChangeFinished = arg1;
    }

    public final void setRawOffsetEnd$material3(float arg1) {
        this.rawOffsetEnd$delegate.setFloatValue(arg1);
    }

    public final void setRawOffsetStart$material3(float arg1) {
        this.rawOffsetStart$delegate.setFloatValue(arg1);
    }

    public final void setRtl$material3(boolean arg1) {
        this.isRtl$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setStartThumbHeight$material3(float arg1) {
        this.startThumbHeight$delegate.setFloatValue(arg1);
    }

    public final void setStartThumbWidth$material3(float arg1) {
        this.startThumbWidth$delegate.setFloatValue(arg1);
    }

    public final void setTotalWidth$material3(int arg1) {
        this.totalWidth$delegate.setIntValue(arg1);
    }

    public final void updateMinMaxPx$material3() {
        float v0 = Math.max((((float)this.getTotalWidth$material3())) - this.getEndThumbWidth$material3() / 2f, 0f);
        float v1 = Math.min(this.getStartThumbWidth$material3() / 2f, v0);
        if(!this.isDragging$material3()) {
            if(this.getMinPx() == v1 && this.getMaxPx() == v0 && this.getActiveRangeStart() == this.getActiveRangeEnd()) {
                return;
            }

            this.setMinPx(v1);
            this.setMaxPx(v0);
            this.setRawOffsetStart$material3(this.scaleToOffset(this.getMinPx(), this.getMaxPx(), this.getActiveRangeStart()));
            this.setRawOffsetEnd$material3(this.scaleToOffset(this.getMinPx(), this.getMaxPx(), this.getActiveRangeEnd()));
        }
    }
}

