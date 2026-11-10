package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B9\b\u0002\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\nB-\b\u0016\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\rJ\u000E\u0010$\u001A\u00020%H\u0086@¢\u0006\u0002\u0010&J\u000E\u0010\'\u001A\u00020%H\u0086@¢\u0006\u0002\u0010&J\u0016\u0010(\u001A\u00020%2\u0006\u0010)\u001A\u00020\u0004H\u0086@¢\u0006\u0002\u0010*R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001A\u00020\u00048G¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001CR\u0011\u0010\u001D\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u001B\u0010 \u001A\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b!\u0010\u001F¨\u0006,"}, d2={"Landroidx/compose/material3/SearchBarState;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpecForCollapse", "<init>", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "collapsedCoords", "getCollapsedCoords", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCollapsedCoords", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "collapsedCoords$delegate", "Landroidx/compose/runtime/MutableState;", "progress", "getProgress", "()F", "isAnimating", "", "()Z", "targetValue", "getTargetValue", "()Landroidx/compose/material3/SearchBarValue;", "currentValue", "getCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/State;", "animateToExpanded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToCollapsed", "snapTo", "fraction", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SearchBarState {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001A\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00050\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/compose/material3/SearchBarState$Companion;", "", "<init>", "()V", "Collapsed", "", "Expanded", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SearchBarState;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpecForCollapse", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(AnimationSpec arg2, AnimationSpec arg3) {
            return ListSaverKt.listSaver(new SearchBarState$Companion$$ExternalSyntheticLambda0(), new SearchBarState$Companion$$ExternalSyntheticLambda1(arg2, arg3));
        }

        static final List Saver$lambda$0(SaverScope arg0, SearchBarState arg1) {
            return CollectionsKt.listOf(Float.valueOf(arg1.getProgress()));
        }

        static final SearchBarState Saver$lambda$1(AnimationSpec arg8, AnimationSpec arg9, List arg10) {
            return new SearchBarState(new Animatable(arg10.get(0), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null), arg8, arg9, null);
        }
    }

    public static final int $stable = 0;
    private static final float Collapsed = 0f;
    public static final Companion Companion = null;
    private static final float Expanded = 1f;
    private final Animatable animatable;
    private final AnimationSpec animationSpecForCollapse;
    private final AnimationSpec animationSpecForExpand;
    private final MutableState collapsedCoords$delegate;
    private final State currentValue$delegate;

    static {
        SearchBarState.Companion = new Companion(null);
    }

    public SearchBarState(SearchBarValue arg4, AnimationSpec arg5, AnimationSpec arg6) {
        float v4 = arg4 == SearchBarValue.Expanded ? 1f : 0f;
        this(AnimatableKt.Animatable$default(v4, 0f, 2, null), arg5, arg6);
    }

    private SearchBarState(Animatable arg1, AnimationSpec arg2, AnimationSpec arg3) {
        super();
        this.animatable = arg1;
        this.animationSpecForExpand = arg2;
        this.animationSpecForCollapse = arg3;
        this.collapsedCoords$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentValue$delegate = SnapshotStateKt.derivedStateOf(new SearchBarState$$ExternalSyntheticLambda0(this));
    }

    public SearchBarState(Animatable arg1, AnimationSpec arg2, AnimationSpec arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public final Object animateToCollapsed(Continuation arg9) {
        Object v8 = Animatable.animateTo$default(this.animatable, Boxing.boxFloat(0f), this.animationSpecForCollapse, null, null, arg9, 12, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public final Object animateToExpanded(Continuation arg9) {
        Object v8 = Animatable.animateTo$default(this.animatable, Boxing.boxFloat(1f), this.animationSpecForExpand, null, null, arg9, 12, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    static final SearchBarValue currentValue_delegate$lambda$0(SearchBarState arg1) {
        if(arg1.animatable.getValue().floatValue() == 0f) {
            return SearchBarValue.Collapsed;
        }

        return SearchBarValue.Expanded;
    }

    public final LayoutCoordinates getCollapsedCoords() {
        return this.collapsedCoords$delegate.getValue();
    }

    public final SearchBarValue getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final float getProgress() {
        return RangesKt.coerceIn(this.animatable.getValue().floatValue(), 0f, 1f);
    }

    public final SearchBarValue getTargetValue() {
        if(this.animatable.getTargetValue().floatValue() == 1f) {
            return SearchBarValue.Expanded;
        }

        return SearchBarValue.Collapsed;
    }

    public final boolean isAnimating() {
        return this.animatable.isRunning();
    }

    public final void setCollapsedCoords(LayoutCoordinates arg1) {
        this.collapsedCoords$delegate.setValue(arg1);
    }

    public final Object snapTo(float arg1, Continuation arg2) {
        Object v0 = this.animatable.snapTo(Boxing.boxFloat(arg1), arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

