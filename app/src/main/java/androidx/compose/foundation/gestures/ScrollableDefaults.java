package androidx.compose.foundation.gestures;

import androidx.compose.foundation.AndroidOverscroll_androidKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001A\u00020\bH\u0007¢\u0006\u0002\u0010\tJ\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000B¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/gestures/ScrollableDefaults;", "", "<init>", "()V", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "reverseDirection", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseScrolling", "NoOpOverscrollEffect", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollableDefaults {
    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ<\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\"\u0010\u0011\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/gestures/ScrollableDefaults$NoOpOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "()V", "applyToScroll", "Landroidx/compose/ui/geometry/Offset;", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInProgress", "", "()Z", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class NoOpOverscrollEffect implements OverscrollEffect {
        public static final NoOpOverscrollEffect INSTANCE;

        static {
            NoOpOverscrollEffect.INSTANCE = new NoOpOverscrollEffect();
        }

        private NoOpOverscrollEffect() {
            super();
        }

        public Object applyToFling-BMRW4eQ(long arg1, Function2 arg3, Continuation arg4) {
            Object v0 = arg3.invoke(Velocity.box-impl(arg1), arg4);
            if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v0;
            }

            return Unit.INSTANCE;
        }

        public long applyToScroll-Rhakbz0(long arg1, int arg3, Function1 arg4) {
            return arg4.invoke(Offset.box-impl(arg1)).unbox-impl();
        }

        public DelegatableNode getNode() {
            return new ScrollableDefaults$NoOpOverscrollEffect$node$1();
        }

        public boolean isInProgress() {
            return 0;
        }
    }

    public static final int $stable;
    public static final ScrollableDefaults INSTANCE;

    static {
        ScrollableDefaults.INSTANCE = new ScrollableDefaults();
    }

    private ScrollableDefaults() {
        super();
    }

    public final FlingBehavior flingBehavior(Composer arg3, int arg4) {
        int v0 = 0x4206C4AA;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(flingBehavior)591@24679L38:Scrollable.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:591)");
        }

        FlingBehavior v2 = Scrollable_androidKt.rememberPlatformDefaultFlingBehavior(arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    @Deprecated(message="This API has been replaced with rememberOverscrollEffect, which queries theme provided OverscrollFactory values instead of the \'platform default\' without customization.", replaceWith="<_subannotation>") public final OverscrollEffect overscrollEffect(Composer arg3, int arg4) {
        int v0 = 1809802212;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(overscrollEffect)609@25400L34:Scrollable.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:608)");
        }

        OverscrollEffect v2 = AndroidOverscroll_androidKt.rememberPlatformOverscrollEffect(arg3, 0);
        if(v2 == null) {
            NoOpOverscrollEffect v2_1 = NoOpOverscrollEffect.INSTANCE;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final boolean reverseDirection(LayoutDirection arg2, Orientation arg3, boolean arg4) {
        int v1 = (((int)arg4)) ^ 1;
        if(arg2 == LayoutDirection.Rtl && arg3 != Orientation.Vertical) {
            return arg4;
        }

        return ((boolean)v1);
    }
}

