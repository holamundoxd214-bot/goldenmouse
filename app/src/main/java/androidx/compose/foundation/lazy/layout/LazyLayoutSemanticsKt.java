package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001A?\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0001¢\u0006\u0002\u0010\f\u001A\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0000\u001A \u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\nH\u0000¨\u0006\u0014"}, d2={"lazyLayoutSemantics", "Landroidx/compose/ui/Modifier;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "estimatedLazyScrollOffset", "", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "estimatedLazyMaxScrollOffset", "canScrollForward", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutSemanticsKt {
    public static final float estimatedLazyMaxScrollOffset(int arg0, int arg1, boolean arg2) {
        if(arg2) {
            return LazyLayoutSemanticsKt.estimatedLazyScrollOffset(arg0, arg1) + 100f;
        }

        return LazyLayoutSemanticsKt.estimatedLazyScrollOffset(arg0, arg1);
    }

    public static final float estimatedLazyScrollOffset(int arg0, int arg1) {
        return ((float)(arg1 + arg0 * 500));
    }

    public static final Modifier lazyLayoutSemantics(Modifier arg10, Function0 arg11, LazyLayoutSemanticState arg12, Orientation arg13, boolean arg14, boolean arg15, Composer arg16, int arg17) {
        int v1 = 0x3FC8FE51;
        Composer v2 = arg16;
        ComposerKt.sourceInformationMarkerStart(v2, v1, "C(lazyLayoutSemantics)N(itemProviderLambda,state,orientation,userScrollEnabled,reverseScrolling):LazyLayoutSemantics.kt#wow0x6");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg17, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:48)");
        }

        arg10 = arg10.then(new LazyLayoutSemanticsModifier(arg11, arg12, arg13, arg14, arg15));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v2);
        return arg10;
    }
}

