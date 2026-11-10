package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\'\b\u0007\u0018\u0000 N2\u00020\u0001:\u0001NB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J?\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\'\u0010-\u001A#\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020*00\u0012\u0006\u0012\u0004\u0018\u0001010.¢\u0006\u0002\b2H\u0096@¢\u0006\u0002\u00103J\u0010\u00104\u001A\u00020$2\u0006\u00105\u001A\u00020$H\u0016J&\u0010H\u001A\u00020*2\u0006\u0010\u0007\u001A\u00020\u00032\u000E\b\u0002\u0010I\u001A\b\u0012\u0004\u0012\u00020$0JH\u0086@¢\u0006\u0002\u0010KJ\u0016\u0010L\u001A\u00020$2\u0006\u0010\u0007\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010MR+\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00038G@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R$\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00038F@@X\u0086\u000E¢\u0006\f\u001A\u0004\b\u000F\u0010\t\"\u0004\b\u0010\u0010\u0005R+\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00038F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001A\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0015\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00038@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u001C\u0010\f\u001A\u0004\b\u001A\u0010\t\"\u0004\b\u001B\u0010\u0005R\u0014\u0010\u001D\u001A\u00020\u001EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u000E\u0010!\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001A\u00020\'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0014\u00106\u001A\u0002078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b6\u00108R\u001B\u00109\u001A\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001A\u0004\b:\u00108R\u001B\u0010=\u001A\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010<\u001A\u0004\b>\u00108R\u0014\u0010@\u001A\u0002078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bA\u00108R\u0014\u0010B\u001A\u0002078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bC\u00108R\u0016\u0010D\u001A\u0004\u0018\u00010E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bF\u0010G¨\u0006O"}, d2={"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initial", "", "<init>", "(I)V", "<set-?>", "value", "getValue", "()I", "setValue", "value$delegate", "Landroidx/compose/runtime/MutableIntState;", "newMax", "maxValue", "getMaxValue", "setMaxValue$foundation", "viewportSize", "getViewportSize", "setViewportSize$foundation", "viewportSize$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "contentSize", "getContentSize$foundation", "setContentSize$foundation", "contentSize$delegate", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_maxValueState", "Landroidx/compose/runtime/MutableIntState;", "accumulator", "", "scrollableState", "_scrollIndicatorState", "androidx/compose/foundation/ScrollState$_scrollIndicatorState$1", "Landroidx/compose/foundation/ScrollState$_scrollIndicatorState$1;", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "", "()Z", "canScrollForward", "getCanScrollForward", "canScrollForward$delegate", "Landroidx/compose/runtime/State;", "canScrollBackward", "getCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "animateScrollTo", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollState implements ScrollableState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/ScrollState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/ScrollState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return ScrollState.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private MutableIntState _maxValueState;
    private final ScrollState$_scrollIndicatorState$1 _scrollIndicatorState;
    private float accumulator;
    private final State canScrollBackward$delegate;
    private final State canScrollForward$delegate;
    private final MutableIntState contentSize$delegate;
    private final MutableInteractionSource internalInteractionSource;
    private final ScrollableState scrollableState;
    private final MutableIntState value$delegate;
    private final MutableIntState viewportSize$delegate;

    static {
        ScrollState.Companion = new Companion(null);
        ScrollState.Saver = SaverKt.Saver(new ScrollState$$ExternalSyntheticLambda3(), new ScrollState$$ExternalSyntheticLambda4());
    }

    public ScrollState(int arg2) {
        super();
        this.value$delegate = SnapshotIntStateKt.mutableIntStateOf(arg2);
        this.viewportSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.contentSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this._maxValueState = SnapshotIntStateKt.mutableIntStateOf(0x7FFFFFFF);
        this.scrollableState = ScrollableStateKt.ScrollableState(new ScrollState$$ExternalSyntheticLambda0(this));
        this._scrollIndicatorState = new ScrollState$_scrollIndicatorState$1(this);
        this.canScrollForward$delegate = SnapshotStateKt.derivedStateOf(new ScrollState$$ExternalSyntheticLambda1(this));
        this.canScrollBackward$delegate = SnapshotStateKt.derivedStateOf(new ScrollState$$ExternalSyntheticLambda2(this));
    }

    static final Integer Saver$lambda$0(SaverScope arg0, ScrollState arg1) {
        return Integer.valueOf(arg1.getValue());
    }

    static final ScrollState Saver$lambda$1(int arg1) {
        return new ScrollState(arg1);
    }

    public static final Saver access$getSaver$cp() {
        return ScrollState.Saver;
    }

    public final Object animateScrollTo(int arg2, AnimationSpec arg3, Continuation arg4) {
        Object v1 = ScrollExtensionsKt.animateScrollBy(this, ((float)(arg2 - this.getValue())), arg3, arg4);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    public static Object animateScrollTo$default(ScrollState arg6, int arg7, AnimationSpec arg8, Continuation arg9, int arg10, Object arg11) {
        SpringSpec v8;
        if((arg10 & 2) != 0) {
            v8 = new SpringSpec(0f, 0f, null, 7, null);
        }

        return arg6.animateScrollTo(arg7, ((AnimationSpec)v8), arg9);
    }

    static final boolean canScrollBackward_delegate$lambda$0(ScrollState arg0) {
        if(arg0.getValue() > 0) {
            return 1;
        }

        return 0;
    }

    static final boolean canScrollForward_delegate$lambda$0(ScrollState arg1) {
        if(arg1.getValue() < arg1.getMaxValue()) {
            return 1;
        }

        return 0;
    }

    public float dispatchRawDelta(float arg1) {
        return this.scrollableState.dispatchRawDelta(arg1);
    }

    public boolean getCanScrollBackward() {
        return this.canScrollBackward$delegate.getValue().booleanValue();
    }

    public boolean getCanScrollForward() {
        return this.canScrollForward$delegate.getValue().booleanValue();
    }

    public final int getContentSize$foundation() {
        return this.contentSize$delegate.getIntValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation() {
        return this.internalInteractionSource;
    }

    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final int getMaxValue() {
        return this._maxValueState.getIntValue();
    }

    public ScrollIndicatorState getScrollIndicatorState() {
        return this._scrollIndicatorState;
    }

    public final int getValue() {
        return this.value$delegate.getIntValue();
    }

    public final int getViewportSize() {
        return this.viewportSize$delegate.getIntValue();
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public Object scroll(MutatePriority arg1, Function2 arg2, Continuation arg3) {
        Object v0 = this.scrollableState.scroll(arg1, arg2, arg3);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public final Object scrollTo(int arg2, Continuation arg3) {
        return ScrollExtensionsKt.scrollBy(this, ((float)(arg2 - this.getValue())), arg3);
    }

    static final float scrollableState$lambda$0(ScrollState arg4, float arg5) {
        float v0 = (((float)arg4.getValue())) + arg5 + arg4.accumulator;
        float v1 = RangesKt.coerceIn(v0, 0f, ((float)arg4.getMaxValue()));
        int v0_1 = v0 == v1 ? 1 : 0;
        v1 -= ((float)arg4.getValue());
        int v2 = Math.round(v1);
        arg4.setValue(arg4.getValue() + v2);
        arg4.accumulator = v1 - (((float)v2));
        if(v0_1 == 0) {
            return v1;
        }

        return arg5;
    }

    public final void setContentSize$foundation(int arg1) {
        this.contentSize$delegate.setIntValue(arg1);
    }

    public final void setMaxValue$foundation(int arg6) {
        this._maxValueState.setIntValue(arg6);
        androidx.compose.runtime.snapshots.Snapshot$Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            if(this.getValue() > arg6) {
                this.setValue(arg6);
            }
        }
        catch(Throwable v5) {
            v0.restoreNonObservable(v1, v3, v2);
            throw v5;
        }

        v0.restoreNonObservable(v1, v3, v2);
    }

    private final void setValue(int arg1) {
        this.value$delegate.setIntValue(arg1);
    }

    public final void setViewportSize$foundation(int arg1) {
        this.viewportSize$delegate.setIntValue(arg1);
    }
}

