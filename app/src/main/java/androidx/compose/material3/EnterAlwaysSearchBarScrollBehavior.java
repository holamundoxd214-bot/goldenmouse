package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000 02\u00020\u0001:\u00010BI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000EJ\f\u0010%\u001A\u00020&*\u00020&H\u0016J\u0018\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\u0003H\u0082@¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u00038V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER+\u0010 \u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u00038V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b!\u0010\u001C\"\u0004\b\"\u0010\u001ER\u0014\u0010\'\u001A\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*¨\u00061"}, d2={"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "reverseLayout", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "<init>", "(FFLkotlin/jvm/functions/Function0;ZLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;)V", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getReverseLayout", "()Z", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "_offset", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "scrollOffset", "getScrollOffset", "()F", "setScrollOffset", "(F)V", "<set-?>", "scrollOffsetLimit", "getScrollOffsetLimit", "setScrollOffsetLimit", "scrollOffsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "searchBarScrollBehavior", "Landroidx/compose/ui/Modifier;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "settleSearchBar", "Landroidx/compose/ui/unit/Velocity;", "velocity", "settleSearchBar-OhffZ5M", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class EnterAlwaysSearchBarScrollBehavior implements SearchBarScrollBehavior {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(Function0 arg2, AnimationSpec arg3, DecayAnimationSpec arg4) {
            return ListSaverKt.listSaver(new EnterAlwaysSearchBarScrollBehavior$Companion$$ExternalSyntheticLambda0(), new EnterAlwaysSearchBarScrollBehavior$Companion$$ExternalSyntheticLambda1(arg2, arg3, arg4));
        }

        static final List Saver$lambda$0(SaverScope arg1, EnterAlwaysSearchBarScrollBehavior arg2) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(arg2.getScrollOffset()), Float.valueOf(arg2.getScrollOffsetLimit()), Boolean.valueOf(arg2.getReverseLayout())});
        }

        static final EnterAlwaysSearchBarScrollBehavior Saver$lambda$1(Function0 arg9, AnimationSpec arg10, DecayAnimationSpec arg11, List arg12) {
            Object v0 = arg12.get(0);
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Float");
            float v3 = ((Float)v0).floatValue();
            v0 = arg12.get(1);
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Float");
            float v4 = ((Float)v0).floatValue();
            Object v12 = arg12.get(2);
            Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type kotlin.Boolean");
            return new EnterAlwaysSearchBarScrollBehavior(v3, v4, arg9, ((Boolean)v12).booleanValue(), arg10, arg11);
        }
    }

    public static final Companion Companion;
    private MutableFloatState _offset;
    private final Function0 canScroll;
    private final DecayAnimationSpec flingAnimationSpec;
    private final NestedScrollConnection nestedScrollConnection;
    private final boolean reverseLayout;
    private final MutableFloatState scrollOffsetLimit$delegate;
    private final AnimationSpec snapAnimationSpec;

    static {
        EnterAlwaysSearchBarScrollBehavior.Companion = new Companion(null);
    }

    public EnterAlwaysSearchBarScrollBehavior(float arg1, float arg2, Function0 arg3, boolean arg4, AnimationSpec arg5, DecayAnimationSpec arg6) {
        super();
        this.canScroll = arg3;
        this.reverseLayout = arg4;
        this.snapAnimationSpec = arg5;
        this.flingAnimationSpec = arg6;
        this._offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg1);
        this.scrollOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg2);
        this.nestedScrollConnection = new EnterAlwaysSearchBarScrollBehavior$nestedScrollConnection$1(this);
    }

    public static final Object access$settleSearchBar-OhffZ5M(EnterAlwaysSearchBarScrollBehavior arg0, float arg1, Continuation arg2) {
        return arg0.settleSearchBar-OhffZ5M(arg1, arg2);
    }

    public final Function0 getCanScroll() {
        return this.canScroll;
    }

    public final DecayAnimationSpec getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public float getScrollOffset() {
        return this._offset.getFloatValue();
    }

    public float getScrollOffsetLimit() {
        return this.scrollOffsetLimit$delegate.getFloatValue();
    }

    public final AnimationSpec getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public Modifier searchBarScrollBehavior(Modifier arg12) {
        return OnRemeasuredModifierKt.onSizeChanged(LayoutModifierKt.layout(ClipKt.clipToBounds(DraggableKt.draggable$default(arg12, DraggableKt.DraggableState(new EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda3(this)), Orientation.Vertical, this.canScroll.invoke().booleanValue(), null, false, null, new EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2(this, null), false, 0xB8, null)), new EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda4(this)), new EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda5(this));
    }

    static final Unit searchBarScrollBehavior$lambda$0(EnterAlwaysSearchBarScrollBehavior arg1, float arg2) {
        arg1.setScrollOffset(arg1.getScrollOffset() + arg2);
        return Unit.INSTANCE;
    }

    static final MeasureResult searchBarScrollBehavior$lambda$2(EnterAlwaysSearchBarScrollBehavior arg8, MeasureScope arg9, Measurable arg10, Constraints arg11) {
        Placeable v10 = arg10.measure-BRTryo0(arg11.unbox-impl());
        int v8 = MathKt.roundToInt(arg8.getScrollOffset());
        return MeasureScope.layout$default(arg9, v10.getWidth(), RangesKt.coerceAtLeast(v10.getHeight() + v8, 0), null, new EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda2(v10, v8), 4, null);
    }

    static final Unit searchBarScrollBehavior$lambda$2$lambda$1(Placeable arg8, int arg9, PlacementScope arg10) {
        PlacementScope.placeWithLayer$default(arg10, arg8, 0, arg9, 0f, null, 12, null);
        return Unit.INSTANCE;
    }

    static final Unit searchBarScrollBehavior$lambda$3(EnterAlwaysSearchBarScrollBehavior arg4, IntSize arg5) {
        arg4.setScrollOffsetLimit(-(((float)(((int)(arg5.unbox-impl() & 0xFFFFFFFFL))))));
        return Unit.INSTANCE;
    }

    public void setScrollOffset(float arg3) {
        this._offset.setFloatValue(RangesKt.coerceIn(arg3, this.getScrollOffsetLimit(), 0f));
    }

    public void setScrollOffsetLimit(float arg1) {
        this.scrollOffsetLimit$delegate.setFloatValue(arg1);
    }

    private final Object settleSearchBar-OhffZ5M(float arg23, Continuation arg24) {
        Object v0_1;
        float v3_1;
        Object v12_1;
        FloatRef v12;
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 v2_1;
        EnterAlwaysSearchBarScrollBehavior v0 = this;
        Continuation v1 = arg24;
        if((v1 instanceof EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)) {
            Continuation v2 = v1;
            int v4 = 0x80000000;
            if((((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v2).label & v4) != 0) {
                ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = new EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(v0, v1);
        }

        Continuation v7 = ((Continuation)v2_1);
        Object v1_1 = ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).result;
        Object v2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v3 = ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).label;
        int v10 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v1_1);
            float v1_2 = v0.getScrollOffsetLimit() == 0f ? 0f : v0.getScrollOffset() / v0.getScrollOffsetLimit();
            if(v1_2 >= 0.01f) {
                v3_1 = 1f;
                if(v1_2 == v3_1) {
                }
                else {
                    v12 = new FloatRef();
                    float v14 = arg23;
                    v12.element = v14;
                    if(Math.abs(v14) > v3_1) {
                        FloatRef v3_2 = new FloatRef();
                        AnimationState v5 = AnimationStateKt.AnimationState$default(0f, v14, 0, 0, false, 28, null);
                        DecayAnimationSpec v8 = v0.flingAnimationSpec;
                        EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda0 v6 = new EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda0(v3_2, v0, v12);
                        ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).L$0 = v12;
                        ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).F$0 = v1_2;
                        ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).label = 1;
                        if(SuspendAnimationKt.animateDecay$default(v5, v8, false, ((Function1)v6), v7, 2, null) == v2_2) {
                            return v2_2;
                        }
                        else {
                            v3_1 = v1_2;
                            FloatRef v4_2 = v12;
                        label_81:
                            v1_2 = v3_1;
                            v12_1 = v4_2;
                            goto label_83;
                        }
                    }
                    else {
                    label_83:
                        if(v0.getScrollOffsetLimit() >= v0.getScrollOffset()) {
                        }
                        else if(v0.getScrollOffset() < 0f) {
                            AnimationState v3_3 = AnimationStateKt.AnimationState$default(v0.getScrollOffset(), 0f, 0, 0, false, 30, null);
                            v1_2 = v1_2 < 0.5f ? 0f : v0.getScrollOffsetLimit();
                            Float v4_3 = Boxing.boxFloat(v1_2);
                            AnimationSpec v5_1 = v0.snapAnimationSpec;
                            EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda1 v1_3 = new EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda1(v0);
                            ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).L$0 = v12;
                            ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).label = v10;
                            if(SuspendAnimationKt.animateTo$default(v3_3, v4_3, v5_1, false, v1_3, v7, 4, null) == v2_2) {
                                return v2_2;
                            }

                            FloatRef v0_2 = v12;
                        label_116:
                            v12_1 = v0_1;
                        }
                        else {
                        }

                        goto label_117;
                    }
                }
            }

            goto label_121;
        }
        else if(v3 == 1) {
            v3_1 = ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).F$0;
            Object v4_1 = ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_81;
        }
        else if(v3 == v10) {
            v0_1 = ((EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1)v7).L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_116;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_117:
        return Velocity.box-impl(VelocityKt.Velocity(0f, v12.element));
    label_121:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    static final Unit settleSearchBar_OhffZ5M$lambda$4(FloatRef arg3, EnterAlwaysSearchBarScrollBehavior arg4, FloatRef arg5, AnimationScope arg6) {
        float v0 = arg6.getValue().floatValue() - arg3.element;
        float v1 = arg4.getScrollOffset();
        arg4.setScrollOffset(v1 + v0);
        float v4 = Math.abs(v1 - arg4.getScrollOffset());
        arg3.element = arg6.getValue().floatValue();
        arg5.element = arg6.getVelocity().floatValue();
        if(Math.abs(v0 - v4) > 0.5f) {
            arg6.cancelAnimation();
        }

        return Unit.INSTANCE;
    }

    static final Unit settleSearchBar_OhffZ5M$lambda$5(EnterAlwaysSearchBarScrollBehavior arg0, AnimationScope arg1) {
        arg0.setScrollOffset(arg1.getValue().floatValue());
        return Unit.INSTANCE;
    }
}

